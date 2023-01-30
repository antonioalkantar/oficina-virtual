package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.acceso.bean.AuthenticatorBean;
import mx.gob.cdmx.adip.portaltramites.acceso.filters.AutenticacionFilter;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DocumentoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.oauth.dto.PersonaDTO;

@Named
@ViewScoped
public class ExpedienteDigitalBean implements Serializable {

	private static final long serialVersionUID = -123968266676896226L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpedienteDigitalBean.class);

	private List<DocumentoDTO> documentos = new ArrayList<>();
	
	@Inject
	private AuthenticatorBean authenticatorBean;
	
	private PersonaDTO usuarioLogueado;

	@PostConstruct
	public void inicializarBean() {
		usuarioLogueado = authenticatorBean.getUsuarioLogueado();
		LOGGER.info("Inicializar expedienteDigitalBean");
		documentos.add(new DocumentoDTO(1l, "Identificacion oficial:", "Licencia de conducir", "pdf", Boolean.TRUE,
				Boolean.TRUE, Boolean.TRUE));
		documentos.add(new DocumentoDTO(2l, "Comprobante de domicilio:", "Recibo de luz", "pdf", Boolean.TRUE,
				Boolean.TRUE, Boolean.TRUE));
		documentos.add(new DocumentoDTO(3l, "", "Fotografía", "pdf", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));
		documentos.add(new DocumentoDTO(4l, "Identificacion oficial:", "Licencia de conducir 2", "pdf", Boolean.TRUE,
				Boolean.TRUE, Boolean.TRUE));
		documentos.add(new DocumentoDTO(5l, "Comprobante de domicilio:", "Recibo de luz 2", "pdf", Boolean.TRUE,
				Boolean.TRUE, Boolean.TRUE));
		documentos.add(new DocumentoDTO(6l, "", "Fotografía 2", "pdf", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));
	}

	public String navegarExpedienteDigital() {
		return Constantes.RETURN_ADMIN_TAGS + Constantes.JSF_REDIRECT;
	}

	public List<DocumentoDTO> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoDTO> documentos) {
		this.documentos = documentos;
	}

	public PersonaDTO getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(PersonaDTO usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}


}
