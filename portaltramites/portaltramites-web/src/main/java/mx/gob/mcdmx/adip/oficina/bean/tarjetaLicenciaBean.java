package mx.gob.mcdmx.adip.oficina.bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.URISyntaxException;
import java.text.ParseException;
//import java.util.Base64;
import org.bouncycastle.util.encoders.Base64;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.codehaus.jettison.json.JSONException;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.client.LicenciaRestClient;
import mx.gob.cdmx.adip.portaltx.client.LicenciaRestClient.LicenciaException;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaLicenciaDTO;

@Named("tarjetaLicenciaBean")
@RequestScoped
public class tarjetaLicenciaBean implements Serializable {
	private static final long serialVersionUID = 1258102050526093893L;
	private static final Logger LOGGER = LoggerFactory.getLogger(tarjetaLicenciaBean.class);

	private RegistroDTO tarjetaLicencia;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private LicenciaRestClient licenciaRestClient;

	public tarjetaLicenciaBean() {
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaLicencia = licenciaRestClient.consultaRegistroLicencia(tramitesOficinaBean.getRegistroSelected());
			if (tarjetaLicencia.getCatEstatusDTO().getIdEstatus()== 6 || tarjetaLicencia.getCatEstatusDTO().getIdEstatus()== 11) {
				tarjetaLicencia.setTipoLicencia("No aplica ");
			}else {
				tarjetaLicencia.setTipoLicencia("TIPO A"); 
			}
			tarjetaLicencia.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
		} catch (Exception e) {
			LOGGER.error("Al consultar el servico de Licencia:", e);
		}
	}

	public String urlAction() {
		if (tarjetaLicencia != null) {
			if (Environment.getAppProfile().compareTo("dev") == 0
					|| Environment.getAppProfile().compareTo("local") == 0) {
				return Constantes.RETURN_URL_LICENCIA_DEV + tarjetaLicencia.getIdRegistroOrigen();
			} else {
				return Constantes.RETURN_URL_LICENCIA_PROD + tarjetaLicencia.getIdRegistroOrigen();
			}
		}
		return "#";
	}
	
//	public StreamedContent descargarDocumento() throws ConnectException, URISyntaxException, JSONException, LicenciaException, ParseException {
//		LOGGER.info("Se descarga documento de licencia...");
//		TarjetaLicenciaDTO tarjetaLicenciaDTO = new TarjetaLicenciaDTO();
//		StreamedContent archivoReporte = null;
//		try {
//			tarjetaLicenciaDTO = licenciaRestClient.consultaDocumentoRegistroLicencia(tramitesOficinaBean.getRegistroSelected());
//			byte[] pdfBytes = Base64.getDecoder().decode(tarjetaLicenciaDTO.getDocumento());
//	        InputStream stream = new ByteArrayInputStream(pdfBytes);
//	        archivoReporte = DefaultStreamedContent.builder().name("licencia"+tarjetaLicenciaDTO.getExtension())
//					.contentType(Constantes.CONTENT_TYPE_PDF).stream(() -> stream).build();
//	        FacesContext.getCurrentInstance().responseComplete();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return archivoReporte;
//	}
	
	public void descargarDocumento() {
		tramitesOficinaBean.setFile(null);
		try {
			TarjetaLicenciaDTO tarjetaLicenciaDTO = licenciaRestClient.consultaDocumentoRegistroLicencia(tramitesOficinaBean.getRegistroSelected());
			
			tramitesOficinaBean.setFile(DefaultStreamedContent.builder().name("licencia" + tarjetaLicenciaDTO.getExtension())
					.contentType("application/pdf").stream(() -> new ByteArrayInputStream(Base64.decode(tarjetaLicenciaDTO.getDocumento()))).build());

		} catch (Exception e) {
			LOGGER.error("Error al descargar documento de licencia: ", e);
		}

	}

	public RegistroDTO getTarjetaLicencia() {
		return tarjetaLicencia;
	}

	public void setTarjetaLicencia(RegistroDTO tarjetaLicencia) {
		this.tarjetaLicencia = tarjetaLicencia;
	}
}
