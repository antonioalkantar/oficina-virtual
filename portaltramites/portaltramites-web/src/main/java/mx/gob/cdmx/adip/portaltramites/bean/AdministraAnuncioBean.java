package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.dto.AnunciosDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.dao.AnunciosDAO;
import mx.gob.cdmx.adip.portaltramites.util.Mensajes;
import mx.gob.cdmx.adip.portaltramites.util.WebResources;

@Named("anuncioBean")
@ViewScoped
public class AdministraAnuncioBean implements Serializable {

	private static final long serialVersionUID = -1993349738180583756L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministraAnuncioBean.class);
	
	
	@Inject
	private AdministradorBean adminBean;
	
	@Inject
	AnunciosDAO anunciosDAO;
	
	private AnunciosDTO anunciosDTO;
	private List<AnunciosDTO> lstAnuncios;
	private UploadedFile file;
	private String lblTitulo;
	private String filtroTitulo;
	private Boolean filtroEstatus;
	private String pathActual;
	
	
	@PostConstruct
	public void iniciarBandejaAnuncios() {
		limpiarFiltros();
	}

	public String init() {
		limpiarFiltros();
		agregarNuevaTarjeta();
		return adminBean.initAnuncios();		
	}
	public void agregarNuevaTarjeta() {	
		anunciosDTO = new AnunciosDTO();
		lblTitulo = "Nueva";
	}
	
	public void agregaDocumento(FileUploadEvent event) {
		file = event.getFile();
	}
	
	/**
	 * Método auxiliar que asigna el documento adjunto para la identificación
	 * oficial
	 */
	public void asignaImgTarjetaAnuncios() {
		if (file != null) {
			if (file.getContent().length <= Constantes.VALOR_01_MB) {				
				StringBuilder path = new StringBuilder();
				path.append(Environment.getPathImgTargetaAnuncios());
				//path.append(Constantes.SEPARADOR_RUTA);
				path.append(Constantes.RUTA_TARJETA_ANUNCIOS);
				path.append(Constantes.SEPARADOR_RUTA);
				path.append(file.getFileName());
				anunciosDTO.setImagen(path.toString());
				anunciosDTO.setContentFileTarjetaAnuncio(file.getContent());	
			} else {
				WebResources.addErrorMessage("msj_documento_oversize", "form:pnlImagen", false);
			}
		} else {
			WebResources.addErrorMessage("msg_error_carga_archivo", "form:pnlImagen", false);
		}

		file = null;
	}
	
	public void limpiarFiltros() {
		filtroTitulo = "";
		filtroEstatus = null;
		buscarAnuncios();
		pathActual = "";
		
	}
	
	public void buscarAnuncios() {		
		lstAnuncios = new ArrayList<AnunciosDTO>();
		AnunciosDTO criterios = new AnunciosDTO();
		criterios.setTitulo(filtroTitulo);
		criterios.setActivo(filtroEstatus);		
		lstAnuncios = anunciosDAO.buscarPorCriterios(criterios);		
	}
	
	public void activoInactivo(AnunciosDTO dto) {
		anunciosDAO.actualizarActivoInactivo(dto);
		buscarAnuncios();
	}
	
	public void removerAnuncio(AnunciosDTO dto) {
		anunciosDAO.remover(dto);
		buscarAnuncios();
	}
	
	public void verModificarAnuncio(AnunciosDTO dto) {
		lblTitulo = "Modificar";
		anunciosDTO = dto;
		anunciosDTO.setContentFileTarjetaAnuncio(construyeDocumento(anunciosDTO.getImagen()));
		pathActual = anunciosDTO.getImagen();
	}
	
		
	public String guardarAnuncio() {
		if (anunciosDTO.getContentFileTarjetaAnuncio() == null) {
			WebResources.addErrorMessage(Mensajes.MSJ_CAMPO_OBLIGATORIO, "form:uploadIdenOf", false);
			return null;
		}
		try {
			String espacios = anunciosDTO.getLink().trim();
			anunciosDTO.setLink(espacios);
			anunciosDAO.registrar(anunciosDTO);
			limpiarFiltros();
			PrimeFaces.current().executeScript("rcGuardadoExitosoAnuncio()");
		} catch (IOException ex) {
			LOGGER.error("ERROR AL GUARDAR 	ANUNCIO: ", ex);
			WebResources.validationMessage("msj_error_registro", false);
			return null;
		}
		return null;
	}
	
	public void guardadoExitoso() {
		adminBean.actualizaSeccion(5);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Anuncio guardado correctamente"));
	}
	
	public String actualizarAnuncio() {		
		try {
			String espacios = anunciosDTO.getLink().trim();
			anunciosDTO.setLink(espacios);
			anunciosDAO.editar(anunciosDTO , pathActual);
			limpiarFiltros();
			PrimeFaces.current().executeScript("rcActualizacionExitosaAnuncio()");
		} catch (IOException ex) {
			LOGGER.error("ERROR AL ACTUALIZAR ANUNCIO: ", ex);
			WebResources.validationMessage("msj_error_registro", false);
			return null;
		}
		return null;
	}
	
	public void actualizacionExitosa() {
		adminBean.actualizaSeccion(5);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Anuncio modificado correctamente"));
	}
	
	/**
	 * Método que permite ver la imagen en nueva pestaña
	 * 
	 * @param archivo
	 * @param nombreImagen(archioo)
	 */
	public void verImagen(byte[] archivo) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		try (BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(archivo));
				BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream(),
						Constantes.TAMAÑO_BUFFER);) {
			byte[] buffer = new byte[Constantes.TAMAÑO_BUFFER];
			int tamaño;
			while ((tamaño = input.read(buffer)) > Constantes.INT_VALOR_CERO) {
				output.write(buffer, Constantes.INT_VALOR_CERO, tamaño);
			}

			input.close();
			output.flush();
			output.close();
			facesContext.responseComplete();
			facesContext.renderResponse();

			PrimeFaces.current().ajax().update("form");
		} catch (IOException e) {
			LOGGER.error("Error al leer el documento", e);
		}
	}
	
	public byte[] construyeDocumento(String ruta) {
		byte[] arreglo = null;
		try {
			arreglo = FileUtils.readFileToByteArray(new File(ruta));
		} catch (IOException e) {
			LOGGER.error("Error al construir array", e);
		}
		return arreglo;
	}
	

	public String getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(String lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public AnunciosDTO getAnunciosDTO() {
		return anunciosDTO;
	}

	public void setAnunciosDTO(AnunciosDTO anunciosDTO) {
		this.anunciosDTO = anunciosDTO;
	}

	public List<AnunciosDTO> getLstAnuncios() {
		return lstAnuncios;
	}

	public void setLstAnuncios(List<AnunciosDTO> lstAnuncios) {
		this.lstAnuncios = lstAnuncios;
	}

	public String getFiltroTitulo() {
		return filtroTitulo;
	}

	public void setFiltroTitulo(String filtroTitulo) {
		this.filtroTitulo = filtroTitulo;
	}

	public Boolean getFiltroEstatus() {
		return filtroEstatus;
	}

	public void setFiltroEstatus(Boolean filtroEstatus) {
		this.filtroEstatus = filtroEstatus;
	}
	
	

}
