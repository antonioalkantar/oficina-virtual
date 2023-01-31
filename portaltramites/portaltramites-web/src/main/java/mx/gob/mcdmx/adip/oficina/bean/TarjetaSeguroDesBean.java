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
import mx.gob.cdmx.adip.portaltx.client.SeguroDesempleoRestClient;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;

@Named("tarjetaSeguroDesBean")
@RequestScoped
public class TarjetaSeguroDesBean implements Serializable {

	private static final long serialVersionUID = 2659134550719560210L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaSeguroDesBean.class);

	private RegistroDTO registroSeguroDes;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private SeguroDesempleoRestClient seguroDesempleoRestClient;

	public TarjetaSeguroDesBean() {
	}

	@PostConstruct
	public void init() {
		try {
			// TODO:eliminar cuando existan datos del WS
			registroSeguroDes = new RegistroDTO();
			registroSeguroDes.setCatSistemaDTO(new CatSistemaDTO(tramitesOficinaBean.getID_SISTEMA_SEGURO_DESEMPLEO()));

			registroSeguroDes = seguroDesempleoRestClient
					.consultaRegistroSeguroDes(tramitesOficinaBean.getRegistroSelected());
			registroSeguroDes.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (registroSeguroDes != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_SEGURO_DESEMPLEO_DEV + registroSeguroDes.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_SEGURO_DESEMPLEO_PROD + registroSeguroDes.getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public RegistroDTO getRegistroSeguroDes() {
		return registroSeguroDes;
	}

}
