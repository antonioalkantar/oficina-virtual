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
import mx.gob.cdmx.adip.portaltx.client.JuridicoLaboralRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaJuridicoLaboralDTO;

@Named("tarjetaJuridicoLaboralBean")
@RequestScoped
public class TarjetaJuridicoLaboralBean implements Serializable {
	
	private static final long serialVersionUID = -5987819687273225479L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaJuridicoLaboralBean.class);
	
	private TarjetaJuridicoLaboralDTO tarjetaJuridicoLaboralDTO;
	
	@Inject
	private tramitesOficinaBean tramitesOficinaBean;
	
	@Inject
	private JuridicoLaboralRestClient juridicoLaboralRestClient;
	
	@PostConstruct
	public void init() {
		try {
			tarjetaJuridicoLaboralDTO = juridicoLaboralRestClient.consultaRegistroJuridicoLaboral(tramitesOficinaBean.getRegistroSelected());
			tarjetaJuridicoLaboralDTO.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaJuridicoLaboralDTO != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_JURIDICO_LABORAL_DEV + tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_JURIDICO_LABORAL_PROD + tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaJuridicoLaboralDTO getTarjetaJuridicoLaboralDTO() {
		return tarjetaJuridicoLaboralDTO;
	}

	public void setTarjetaJuridicoLaboralDTO(TarjetaJuridicoLaboralDTO tarjetaJuridicoLaboralDTO) {
		this.tarjetaJuridicoLaboralDTO = tarjetaJuridicoLaboralDTO;
	}

}
