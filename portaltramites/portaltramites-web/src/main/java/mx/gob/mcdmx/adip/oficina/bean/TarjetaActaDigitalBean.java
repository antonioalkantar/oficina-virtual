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

import mx.gob.cdmx.adip.portaltx.client.ActaDigitalRestClient;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaActaDigitalDTO;

@Named("tarjetaActaBean")
@RequestScoped
public class TarjetaActaDigitalBean implements Serializable {

	private static final long serialVersionUID = -1573304962480562046L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TarjetaActaDigitalBean.class);

	private TarjetaActaDigitalDTO tarjetaActaDigitalDTO;
	private ByteArrayInputStream doc = null;

	@Inject
	private tramitesOficinaBean tramitesOficinaBean;

	@Inject
	private ActaDigitalRestClient actaDigitalRestClient;

	public TarjetaActaDigitalBean() {
		tarjetaActaDigitalDTO = new TarjetaActaDigitalDTO();
	}

	@PostConstruct
	public void init() {
		try {
			tarjetaActaDigitalDTO.setIdRegistroOrigen(tramitesOficinaBean.getRegistroSelected().getIdRegistroOrigen());
			tarjetaActaDigitalDTO.setPathImagen(tramitesOficinaBean.getRegistroSelected().getCatSistemaDTO().getPathImagen());
			actaDigitalRestClient.consultaRegistroActa(tarjetaActaDigitalDTO);
		} catch (Exception e) {
			LOGGER.error("ERROR al consultar servicio", e);
		}
	}

	public String urlAction() {
		if (tarjetaActaDigitalDTO != null) {
			return tarjetaActaDigitalDTO.getLinkRedirect();
		}
		return "#";
	}

	public void download() {
		tramitesOficinaBean.setFile(null);
		try {
			actaDigitalRestClient.consultaDocumentoActaDigital(tarjetaActaDigitalDTO);
			doc = new  ByteArrayInputStream(Base64.decode(tarjetaActaDigitalDTO.getDocumento()));
			
			tramitesOficinaBean.setFile(DefaultStreamedContent.builder()
					.name(tarjetaActaDigitalDTO.getNombreDocumento()).contentType("application/pdf")
					.stream(() -> doc)
					.build());

		} catch (Exception e) {
			LOGGER.error("Error al descargar ACTA ", e);
		}finally {
			try {if(doc!= null) {doc.close();};} catch (Exception e) {
				LOGGER.error("Error al cerrar el documento de Acta Digital ", e);
			}
		}
	}

	public TarjetaActaDigitalDTO getTarjetaActaDigitalDTO() {
		return tarjetaActaDigitalDTO;
	}

	public void setTarjetaActaDigitalDTO(TarjetaActaDigitalDTO tarjetaActaDigitalDTO) {
		this.tarjetaActaDigitalDTO = tarjetaActaDigitalDTO;
	}

}
