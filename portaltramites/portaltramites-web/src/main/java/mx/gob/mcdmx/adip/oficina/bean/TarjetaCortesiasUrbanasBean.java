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
import mx.gob.cdmx.adip.portaltx.client.VentanillaUnicaConstruccionClient;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;

@Named("tarjetaCortesiasUrbanasBean")
@RequestScoped
public class TarjetaCortesiasUrbanasBean implements Serializable {
	
	private static final long serialVersionUID = -5987819687273225479L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaCortesiasUrbanasBean.class);
	
	private RegistroDTO registroVentanillaUnicaConstr;
	
	@Inject
	private tramitesOficinaBean tramitesOficinaBean;
	
	@Inject
	private VentanillaUnicaConstruccionClient ventanillaUnicaConstruccionClient;
	
	public TarjetaCortesiasUrbanasBean() {}
	
	@PostConstruct
	public void init() {
		try {
			// TODO:eliminar cuando existan datos del WS
			registroVentanillaUnicaConstr = new RegistroDTO();
			registroVentanillaUnicaConstr.setCatSistemaDTO(new CatSistemaDTO(tramitesOficinaBean.getID_SISTEMA_CORTESIAS_URBANAS()));
			registroVentanillaUnicaConstr = ventanillaUnicaConstruccionClient.consultaRegistroVentanillaUnicaConstr(tramitesOficinaBean.getRegistroSelected());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (registroVentanillaUnicaConstr != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_CORTESIAS_URBANAS_VEHICULAR_DEV + registroVentanillaUnicaConstr.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_CORTESIAS_URBANAS_VEHICULAR_PROD + registroVentanillaUnicaConstr.getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public RegistroDTO getRegistroVentanillaUnicaConstr() {
		return registroVentanillaUnicaConstr;
	}

}
