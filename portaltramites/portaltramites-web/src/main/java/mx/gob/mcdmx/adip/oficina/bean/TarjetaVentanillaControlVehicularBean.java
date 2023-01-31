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
import mx.gob.cdmx.adip.portaltx.client.ControlVehicularRestClient;
import mx.gob.cdmx.adip.portaltx.client.VentanillaUnicaConstruccionClient;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaVentanillaControlVehicularDTO;

@Named("tarjetaVentanillaControlVehicularBean")
@RequestScoped
public class TarjetaVentanillaControlVehicularBean implements Serializable {
	
	private static final long serialVersionUID = -5987819687273225479L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaVentanillaControlVehicularBean.class);
	
	private TarjetaVentanillaControlVehicularDTO registroVentanillaControlVehicularDTO;
	
	@Inject
	private tramitesOficinaBean tramitesOficinaBean;
	
	@Inject
	private ControlVehicularRestClient controlVehicularRestClient;
	
	
	@PostConstruct
	public void init() {
		try {
			registroVentanillaControlVehicularDTO = controlVehicularRestClient.consultaBeneficiario(tramitesOficinaBean.getRegistroSelected());
			registroVentanillaControlVehicularDTO.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (registroVentanillaControlVehicularDTO != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_VENTANILLA_CONTROL_VEHICULAR_DEV + tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_VENTANILLA_CONTROL_VEHICULAR_PROD + tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen();
			}
		}
		return "#";
	}


	public TarjetaVentanillaControlVehicularDTO getRegistroVentanillaControlVehicularDTO() {
		return registroVentanillaControlVehicularDTO;
	}

	public void setRegistroVentanillaControlVehicularDTO(
			TarjetaVentanillaControlVehicularDTO registroVentanillaControlVehicularDTO) {
		this.registroVentanillaControlVehicularDTO = registroVentanillaControlVehicularDTO;
	}
	
}
