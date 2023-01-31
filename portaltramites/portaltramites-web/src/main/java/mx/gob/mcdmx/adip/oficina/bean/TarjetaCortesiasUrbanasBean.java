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
import mx.gob.cdmx.adip.portaltx.client.CortesiasUrbanasRestClient;
import mx.gob.cdmx.adip.portaltx.client.VentanillaUnicaConstruccionClient;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaCortesiaUrbanaDTO;

@Named("tarjetaCortesiasUrbanasBean")
@RequestScoped
public class TarjetaCortesiasUrbanasBean implements Serializable {

	private static final long serialVersionUID = -5987819687273225479L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaCortesiasUrbanasBean.class);

	private TarjetaCortesiaUrbanaDTO tarjetaCortesiaUrbanaDTO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private CortesiasUrbanasRestClient cortesiasUrbanasRestClient;

	@PostConstruct
	public void init() {
		try {
			tarjetaCortesiaUrbanaDTO = cortesiasUrbanasRestClient
					.consultaBeneficiario(tramitesOficinaBean.getRegistroSelected());
			tarjetaCortesiaUrbanaDTO
					.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaCortesiaUrbanaDTO != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_CORTESIAS_URBANAS_VEHICULAR_DEV
						+ tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_CORTESIAS_URBANAS_VEHICULAR_PROD
						+ tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaCortesiaUrbanaDTO getTarjetaCortesiaUrbanaDTO() {
		return tarjetaCortesiaUrbanaDTO;
	}

	public void setTarjetaCortesiaUrbanaDTO(TarjetaCortesiaUrbanaDTO tarjetaCortesiaUrbanaDTO) {
		this.tarjetaCortesiaUrbanaDTO = tarjetaCortesiaUrbanaDTO;
	}

}
