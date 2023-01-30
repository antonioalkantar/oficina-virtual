package mx.gob.mcdmx.adip.oficina.bean;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.bouncycastle.util.encoders.Base64;
import org.primefaces.model.DefaultStreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.client.PermisosResidentesRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaPermisoResidentesDTO;

@Named("tarjetaPermisoResidentesBean")
@RequestScoped
public class TarjetaPermisoResidentesBean implements Serializable {

	private static final long serialVersionUID = -5987819687273225479L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaPermisoResidentesBean.class);
	private Integer ID_ESTATUS_PPR_APROBADO_DIRECTOR = Constantes.ID_ESTATUS_PPR_APROBADO_DIRECTOR;
	private Integer ID_ESTATUS_PPR_BAJA = Constantes.ID_ESTATUS_PPR_BAJA;

	private TarjetaPermisoResidentesDTO tarjetaPermisoResidentesDTO;
	private ByteArrayInputStream doc = null;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private PermisosResidentesRestClient permisosResidentesRestClient;

	public TarjetaPermisoResidentesBean() {
		tarjetaPermisoResidentesDTO = new TarjetaPermisoResidentesDTO();
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaPermisoResidentesDTO
					.setIdRegistroOrigen(tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen());
			tarjetaPermisoResidentesDTO
					.setSistema(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getNombre());
			tarjetaPermisoResidentesDTO
					.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
			permisosResidentesRestClient.consultaRegistroPermisoResidente(tarjetaPermisoResidentesDTO);
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio ", e);
		}
	}

	public void download() {
		tramitesOficinaBean.setFile(null);
		try {
			permisosResidentesRestClient.consultaDocumentoPermisoResidentes(tarjetaPermisoResidentesDTO);
			doc = new ByteArrayInputStream(Base64.decode(tarjetaPermisoResidentesDTO.getDocumento()));

			tramitesOficinaBean.setFile(DefaultStreamedContent.builder().name("Permiso").contentType("application/pdf")
					.stream(() -> doc).build());
		} catch (Exception e) {
			LOGGER.error("Error al descargar ACTA ", e);
		} finally {
			try {if (doc != null) {doc.close();}
			} catch (Exception e) {
				LOGGER.error("Error al cerrar el documento de Acta Digital ", e);
			}
		}
	}

	public String urlAction() {
		if (tarjetaPermisoResidentesDTO.getIdRegistroOrigen() != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_PERMISO_RESIDENTES_DEV + tarjetaPermisoResidentesDTO.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_PERMISO_RESIDENTES_PROD
						+ tarjetaPermisoResidentesDTO.getIdRegistroOrigen();
			}
		}
		return "#";
	}

	public TarjetaPermisoResidentesDTO getTarjetaPermisoResidentesDTO() {
		return tarjetaPermisoResidentesDTO;
	}

	public Integer getID_ESTATUS_PPR_APROBADO_DIRECTOR() {
		return ID_ESTATUS_PPR_APROBADO_DIRECTOR;
	}

	public Integer getID_ESTATUS_PPR_BAJA() {
		return ID_ESTATUS_PPR_BAJA;
	}
	
}
