package mx.gob.mcdmx.adip.oficina.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.client.MiBecaRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaMiBecaDTO;

@Named("tarjetaMiBecaBean")
@RequestScoped
public class TarjetaMiBecaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8775877732576739986L;

	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaMiBecaBean.class);

	private TarjetaMiBecaDTO tarjetaMiBecaDTO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private MiBecaRestClient miBecaRestClient;

	public TarjetaMiBecaBean() {
	}	

	@PostConstruct
	public void init() {
		try {
			
			tarjetaMiBecaDTO = miBecaRestClient.consultaBeneficiario(tramitesOficinaBean.getRegistroSelected());
			tarjetaMiBecaDTO.setNombreCompleto(tarjetaMiBecaDTO.getNombre() + " " + tarjetaMiBecaDTO.getPrimerApellido() + " " + tarjetaMiBecaDTO.getSegundoApellido());
			tarjetaMiBecaDTO.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
			LOGGER.info("DATOS: " + tarjetaMiBecaDTO);
			if(tarjetaMiBecaDTO.getIdEncuesta() == 0) {
				LOGGER.info("ENTRANDO AL IF: " + tarjetaMiBecaDTO);
				tarjetaMiBecaDTO.setDescripcionEstatus("");
				tarjetaMiBecaDTO.setDescripcionEstatus("Solicitud incompleta");
			}
			LOGGER.info("TERMINA: " + tarjetaMiBecaDTO);
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaMiBecaDTO != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_MIBECA_DEV + tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_MIBECA_PROD + tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaMiBecaDTO getTarjetaMiBecaDTO() {
		return tarjetaMiBecaDTO;
	}

	public void setTarjetaTarjetaMiBecaDTODTO(TarjetaMiBecaDTO tarjetaMiBecaDTO) {
		this.tarjetaMiBecaDTO = tarjetaMiBecaDTO;
	}

}
