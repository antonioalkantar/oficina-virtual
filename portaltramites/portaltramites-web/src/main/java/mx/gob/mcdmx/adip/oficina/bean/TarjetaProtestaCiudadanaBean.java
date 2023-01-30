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
import mx.gob.cdmx.adip.portaltx.client.ProtestaCiudadanaRestClient;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;

@Named("tarjetaProtestaCiudadanaBean")
@RequestScoped
public class TarjetaProtestaCiudadanaBean implements Serializable {
	private static final long serialVersionUID = -8411344410621734631L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaProtestaCiudadanaBean.class);
	
	private RegistroDTO registroProtestaCiudadana;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;
	
	@Inject
	private ProtestaCiudadanaRestClient protestaCiudadanaRestClient;
	
	public TarjetaProtestaCiudadanaBean(){}
	
	
	@PostConstruct
	public void init() {
		try {
			//TODO:eliminar cuando existan datos del WS
			registroProtestaCiudadana= new RegistroDTO();
			registroProtestaCiudadana.setCatSistemaDTO(new CatSistemaDTO(tramitesOficinaBean.getID_SISTEMA_PROTESTA_CIUDADANA()));
			
			registroProtestaCiudadana = protestaCiudadanaRestClient.consultaRegistroProtestaCiud(tramitesOficinaBean.getRegistroSelected());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}
	
	public String urlAction() {
		if (registroProtestaCiudadana != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_PROTESTA_CIUDADANA_DEV + registroProtestaCiudadana.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_PROTESTA_CIUDADANA_PROD + registroProtestaCiudadana.getIdRegistroOrigen();
			}
		}
		return "#";
	}


	public RegistroDTO getRegistroProtestaCiudadana() {
		return registroProtestaCiudadana;
	}
	
	
}
