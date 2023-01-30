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
import mx.gob.cdmx.adip.portaltx.client.SACMEXRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaDescuentoAguaDTO;

@Named("tarjetaSACMEXBean")
@RequestScoped
public class TarjetaSACMEXBean implements Serializable {
	private static final long serialVersionUID = 1258102050526093893L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaSACMEXBean.class);

	private TarjetaDescuentoAguaDTO tarjetaDescuentoAguaDTO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private SACMEXRestClient sacmexRestClient;

	public TarjetaSACMEXBean() {
		tarjetaDescuentoAguaDTO = new TarjetaDescuentoAguaDTO();
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaDescuentoAguaDTO
					.setIdRegistroOrigen(tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen());
			tarjetaDescuentoAguaDTO
					.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
			tarjetaDescuentoAguaDTO
			.setSistema(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getNombre());
			sacmexRestClient.consultaRegistroSACMEX(tarjetaDescuentoAguaDTO);
		} catch (Exception e) {
			LOGGER.error("Al consultar el servico de SACMEX:", e);
		}
	}

	public String urlAction() {
		if (tarjetaDescuentoAguaDTO != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_SACMEX_DEV + tarjetaDescuentoAguaDTO.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_SACMEX_PROD + tarjetaDescuentoAguaDTO.getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaDescuentoAguaDTO getTarjetaDescuentoAguaDTO() {
		return tarjetaDescuentoAguaDTO;
	}

	public void setTarjetaDescuentoAguaDTO(TarjetaDescuentoAguaDTO tarjetaDescuentoAguaDTO) {
		this.tarjetaDescuentoAguaDTO = tarjetaDescuentoAguaDTO;
	}

}
