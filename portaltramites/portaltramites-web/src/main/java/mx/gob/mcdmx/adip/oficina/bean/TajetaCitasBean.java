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
import mx.gob.cdmx.adip.portaltx.client.CitasRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaCitasDTO;

@Named("tarjetaCitasBean")
@RequestScoped
public class TajetaCitasBean implements Serializable {

	private static final long serialVersionUID = -8725288938215465737L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TajetaCitasBean.class);

	private TarjetaCitasDTO tarjetaCitasDTO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private CitasRestClient citasRestClient;

	public TajetaCitasBean() {
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaCitasDTO = citasRestClient.consultaRegistroCitas(tramitesOficinaBean.getRegistroSelected());

		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaCitasDTO != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_CITAS_DEV + tarjetaCitasDTO.getIdDetalleCitaUsuarioLlavecdmx();
			} else {
				return Constantes.RETURN_URL_CITAS_PROD + tarjetaCitasDTO.getIdDetalleCitaUsuarioLlavecdmx();
			}
		}
		return "";
	}

	public TarjetaCitasDTO getTarjetaCitasDTO() {
		return tarjetaCitasDTO;
	}

	public void setTarjetaCitasDTO(TarjetaCitasDTO tarjetaCitasDTO) {
		this.tarjetaCitasDTO = tarjetaCitasDTO;
	}

}
