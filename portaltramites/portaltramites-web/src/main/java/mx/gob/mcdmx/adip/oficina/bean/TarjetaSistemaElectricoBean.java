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
import mx.gob.cdmx.adip.portaltx.client.SistemaElectricoRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaSistemaElectricoDTO;

@Named("tarjetaSistemaElectricoBean")
@RequestScoped
public class TarjetaSistemaElectricoBean implements Serializable {

	private static final long serialVersionUID = 5385349351103197240L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaSistemaElectricoBean.class);

	private TarjetaSistemaElectricoDTO tarjetaSistemaElectricoDTO;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private SistemaElectricoRestClient sistemaElectricoRestClient;

	public TarjetaSistemaElectricoBean() {
		tarjetaSistemaElectricoDTO = new TarjetaSistemaElectricoDTO();
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaSistemaElectricoDTO.setIdRegistroOrigen(tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen());
			tarjetaSistemaElectricoDTO.setSistema(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getNombre());
			tarjetaSistemaElectricoDTO.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());

			sistemaElectricoRestClient.consultaRegistroSistemaElectrico(tarjetaSistemaElectricoDTO);
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaSistemaElectricoDTO.getIdRegistroOrigen() != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_SISTEMA_ELECTRICO_DEV + tarjetaSistemaElectricoDTO.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_SISTEMA_ELECTRICO_PROD + tarjetaSistemaElectricoDTO.getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaSistemaElectricoDTO getTarjetaSistemaElectricoDTO() {
		return tarjetaSistemaElectricoDTO;
	}

}
