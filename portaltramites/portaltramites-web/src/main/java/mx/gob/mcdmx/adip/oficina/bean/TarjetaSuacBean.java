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
import mx.gob.cdmx.adip.portaltx.client.SUACRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaSuacDTO;

@Named("tarjetaSuacBean")
@RequestScoped
public class TarjetaSuacBean implements Serializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaSuacBean.class);
	private static final long serialVersionUID = -8160796840171300434L;

	private TarjetaSuacDTO tarjetaSuacDTO;
	private Integer ID_ESTATUS_SUAC_RECIBIDO = Constantes.ID_ESTATUS_SUAC_RECIBIDO;
	private Integer ID_ESTATUS_SUAC_TURNADO = Constantes.ID_ESTATUS_SUAC_TURNADO;
	private Integer ID_ESTATUS_SUAC_ATENDIDO = Constantes.ID_ESTATUS_SUAC_ATENDIDO;
	private Integer ID_ESTATUS_SUAC_CERRADO = Constantes.ID_ESTATUS_SUAC_CERRADO;
	private Integer ID_ESTATUS_SUAC_CANCELADO = Constantes.ID_ESTATUS_SUAC_CANCELADO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private SUACRestClient suacRestClient;

	public TarjetaSuacBean() {
		tarjetaSuacDTO = new TarjetaSuacDTO();
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaSuacDTO.setIdRegistroOrigen(tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen());
			tarjetaSuacDTO.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
			tarjetaSuacDTO.setSistema(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getNombre());
			suacRestClient.consultaRegistroSUAC(tarjetaSuacDTO);
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaSuacDTO.getIdRegistroOrigen() != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_SUAC_DEV + tarjetaSuacDTO.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_SUAC_PROD + tarjetaSuacDTO.getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaSuacDTO getTarjetaSuacDTO() {
		return tarjetaSuacDTO;
	}

	public void setTarjetaSuacDTO(TarjetaSuacDTO tarjetaSuacDTO) {
		this.tarjetaSuacDTO = tarjetaSuacDTO;
	}

	public Integer getID_ESTATUS_SUAC_RECIBIDO() {
		return ID_ESTATUS_SUAC_RECIBIDO;
	}

	public Integer getID_ESTATUS_SUAC_TURNADO() {
		return ID_ESTATUS_SUAC_TURNADO;
	}

	public Integer getID_ESTATUS_SUAC_ATENDIDO() {
		return ID_ESTATUS_SUAC_ATENDIDO;
	}

	public Integer getID_ESTATUS_SUAC_CERRADO() {
		return ID_ESTATUS_SUAC_CERRADO;
	}

	public Integer getID_ESTATUS_SUAC_CANCELADO() {
		return ID_ESTATUS_SUAC_CANCELADO;
	}

}
