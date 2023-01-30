package mx.gob.mcdmx.adip.oficina.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import org.bouncycastle.util.encoders.Base64;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.client.DoctoRefrendoTCRestClient;
import mx.gob.cdmx.adip.portaltx.client.RefrendoTCRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaRefrendoTarjetaCirculacionDTO;

@Named
@RequestScoped
public class TarjetaRefrendoTarjetaCirculacionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7349583149179420091L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaRefrendoTarjetaCirculacionBean.class);

	private TarjetaRefrendoTarjetaCirculacionDTO tarRefrendoTCDTO;
	private TarjetaRefrendoTarjetaCirculacionDTO doctoTarRefrendoTCDTO;
	private StreamedContent file;
	private String ruta;
	private File tmpFile; 
	
	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private RefrendoTCRestClient refrendoTCRestClient;

	@Inject
	private DoctoRefrendoTCRestClient doctoRefrendoTCRestClient;

	@Inject
	private tramitesOficinaBean tramOfiBean;

	public TarjetaRefrendoTarjetaCirculacionBean() {
		
	}

	@PostConstruct
	public void init() {
		try {
			tarRefrendoTCDTO = refrendoTCRestClient.consultaRegistroRefrendoTC(tramitesOficinaBean.getRegistroSelected());
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}

	}

	public String urlAction() {
//		try {
			if (tarRefrendoTCDTO != null) {
				if (Environment.getAppProfile().compareTo("dev") == 0
						|| Environment.getAppProfile().compareTo("local") == 0) {
					return Constantes.RETURN_URL_REFRENDO_TARJETA_CIRCULACION_DEV + tarRefrendoTCDTO.getIdTarjetaCirculacion() + Constantes.RETURN_COMP_URL_REFRENDOTC;
				} else {
					return Constantes.RETURN_URL_REFRENDO_TARJETA_CIRCULACION_PROD + tarRefrendoTCDTO.getIdTarjetaCirculacion() + Constantes.RETURN_COMP_URL_REFRENDOTC;
				}
			}
//		} catch (Exception e) {
//			LOGGER.error("Ocurrio un error al consultar el detalle del trámite de refrendo de tarjeta de circulación " + e);
//			return "";
//		}
		return "#";
	}

	public String download() {
		try {
			doctoRefrendoTCRestClient.consultaDoctoRefrendoTC(tarRefrendoTCDTO);
			tramitesOficinaBean.setFile(DefaultStreamedContent.builder().name(tarRefrendoTCDTO.getFullName())
					.contentType("application/pdf").stream(() -> new ByteArrayInputStream(Base64.decode(tarRefrendoTCDTO.getContent()))).build());
	    } catch (Exception e) {
	    	LOGGER.error("Error al descargar el archivo : ", e);
	    }
		return Constantes.RETURN_SAME_PAGE;
	}

	public TarjetaRefrendoTarjetaCirculacionDTO getTarRefrendoTCDTO() {
		return tarRefrendoTCDTO;
	}

	public void setTarRefrendoTCDTO(TarjetaRefrendoTarjetaCirculacionDTO tarRefrendoTCDTO) {
		this.tarRefrendoTCDTO = tarRefrendoTCDTO;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public File getTmpFile() {
		return tmpFile;
	}

	public void setTmpFile(File tmpFile) {
		this.tmpFile = tmpFile;
	}

	public TarjetaRefrendoTarjetaCirculacionDTO getDoctoTarRefrendoTCDTO() {
		return doctoTarRefrendoTCDTO;
	}

	public void setDoctoTarRefrendoTCDTO(TarjetaRefrendoTarjetaCirculacionDTO doctoTarRefrendoTCDTO) {
		this.doctoTarRefrendoTCDTO = doctoTarRefrendoTCDTO;
	}

	public tramitesOficinaBean getTramOfiBean() {
		return tramOfiBean;
	}

	public void setTramOfiBean(tramitesOficinaBean tramOfiBean) {
		this.tramOfiBean = tramOfiBean;
	}
		
}
