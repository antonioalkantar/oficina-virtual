package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;

import java.io.IOException;

import java.io.Serializable;

import java.util.Date;
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

import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.dao.DetArchivoFondoDAO;
import mx.gob.cdmx.adip.portaltramites.util.Mensajes;
import mx.gob.cdmx.adip.portaltramites.util.WebResources;
import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;

@Named("fondoBean")
@ViewScoped
public class AdministraFondoBean implements Serializable {

	private static final long serialVersionUID = -6011889367911028589L;

	private static final Logger LOGGER = LoggerFactory.getLogger(AdministraFondoBean.class);

	@Inject
	DetArchivoFondoDAO detArchivoFondoDAO;
	
	
	@Inject
	private AdministradorBean adminBean;

	private List<DetArchivoFondoDTO> listFondo;
	private List<DetArchivoFondoDTO> listFondoMobile;
	private DetArchivoFondoDTO archivoFondoDTO;  
	private UploadedFile fileImg;

	@PostConstruct
	public void init() {
		cargarListado();
//		if (!listFondo.isEmpty() && listFondo.get(0).isSituacion()) {
//			verImagen(listFondo.get(0).getNombre_archivo());
//		}
	}

	private void cargarListado() {
		archivoFondoDTO = new DetArchivoFondoDTO();
		listFondo = detArchivoFondoDAO.buscarPorEstatus();
		listFondoMobile = detArchivoFondoDAO.buscarPorEstatusMobile();
	}
	
	
	public void agregaFondo(FileUploadEvent event) {
		fileImg = event.getFile();
	}
	
	public void asignaImg() {
		if (fileImg != null) {
			if (fileImg.getContent().length <= Constantes.VALOR_500_KB) {				
				StringBuilder path = new StringBuilder();
				path.append(Environment.getPathImgFondo());
				path.append(Constantes.RUTA_FONDOS);
				path.append(Constantes.SEPARADOR_RUTA);
				path.append(fileImg.getFileName());
				archivoFondoDTO.setRuta_archivo(path.toString());
				archivoFondoDTO.setContentFileImgFondo(fileImg.getContent());
				archivoFondoDTO.setNombre_archivo(fileImg.getFileName());
				Date fechaActual = new Date();
				archivoFondoDTO.setEstatus(true);
				archivoFondoDTO.setSituacion(true);
				archivoFondoDTO.setFechaCreacion(fechaActual);
				archivoFondoDTO.setFechaModificacion(fechaActual);
				archivoFondoDTO.setEsEscritorio(true);
				guardarImgEscritorio();
				
			} else {
				WebResources.addErrorMessage("msj_img_oversize", "form:pnlImg", false);
			}
		} else {
			WebResources.addErrorMessage("msg_error_carga_archivo", "form:pnlImg", false);
		}

		fileImg = null;
	}
	
	
	
	public void asignaImgMobile() {
		if (fileImg != null) {
			if (fileImg.getContent().length <= Constantes.VALOR_500_KB) {				
				StringBuilder path = new StringBuilder();
				path.append(Environment.getPathImgFondo());
				path.append(Constantes.RUTA_FONDOS);
				path.append(Constantes.SEPARADOR_RUTA);
				path.append(fileImg.getFileName());
				archivoFondoDTO.setRuta_archivo(path.toString());
				archivoFondoDTO.setContentFileImgFondo(fileImg.getContent());
				archivoFondoDTO.setNombre_archivo(fileImg.getFileName());
				Date fechaActual = new Date();
				archivoFondoDTO.setEstatus(true);
				archivoFondoDTO.setSituacion(true);
				archivoFondoDTO.setFechaCreacion(fechaActual);
				archivoFondoDTO.setFechaModificacion(fechaActual);
				archivoFondoDTO.setEsEscritorio(false);
				guardarImgEscritorio();
				
			} else {
				WebResources.addErrorMessage("msj_img_oversize", "form:pnlImg", false);
			}
		} else {
			WebResources.addErrorMessage("msg_error_carga_archivo", "form:pnlImg", false);
		}

		fileImg = null;
	}
	
	
	
	
	
	
		
	public String guardarImgEscritorio() {		
		if (archivoFondoDTO.getContentFileImgFondo() == null) {
			WebResources.addErrorMessage(Mensajes.MSJ_CAMPO_OBLIGATORIO, "form:uploadImg", false);
			return null;
		}
		try {	
			detArchivoFondoDAO.registrar(archivoFondoDTO);
			cargarListado();			
			PrimeFaces.current().executeScript("rcGuardadoExitosoImg()");
		} catch (Exception ex) {
			LOGGER.error("ERROR AL GUARDAR 	ANUNCIO: ", ex);
			LOGGER.error("Error al intentar guardar el registro: " + archivoFondoDTO.toString() + " " + ex.getMessage());
			WebResources.validationMessage("msj_error_registro", false);
			return null;
		}
		return null;
	}
		
	public void guardadoExitoso() {
		adminBean.actualizaSeccion(7);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Imagen guardada correctamente"));
	}
	
		
	public byte[] construyeDocumento(String ruta) {
		byte[] arreglo = null;
		try {
			arreglo = FileUtils.readFileToByteArray(new File(ruta));
		} catch (IOException e) {
			LOGGER.error("Error al construir array", e);
		}
		
		verImagen(arreglo);
		return null;
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
	
	public void actualizaSituacion(DetArchivoFondoDTO fondo) {
		try {
			fondo.setFechaModificacion(new Date());
			fondo.setSituacion(!fondo.isSituacion());
			detArchivoFondoDAO.actualizar(fondo);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Situación modificada correctamente"));
		} catch (Exception e) {
			LOGGER.error("Error al modificar la situación " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al modificar la situación"));
		}

	}

	public void eliminaFondo(DetArchivoFondoDTO fondo) {
		try {
			fondo.setEstatus(false);
			fondo.setSituacion(false);
			fondo.setFechaModificacion(new Date());
			detArchivoFondoDAO.actualizar(fondo);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Imagen elimnada correctamente"));
			cargarListado();
		} catch (Exception e) {
			LOGGER.error("Error al intentar eliminar el archivo: " + fondo.toString(), e);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al eliminar el fondo"));
		}
	}
		
	public DetArchivoFondoDAO getDetArchivoFondoDAO() {
		return detArchivoFondoDAO;
	}

	public void setDetArchivoFondoDAO(DetArchivoFondoDAO detArchivoFondoDAO) {
		this.detArchivoFondoDAO = detArchivoFondoDAO;
	}

	public List<DetArchivoFondoDTO> getListFondo() {
		return listFondo;
	}

	public void setListFondo(List<DetArchivoFondoDTO> listFondo) {
		this.listFondo = listFondo;
	}

	public List<DetArchivoFondoDTO> getListFondoMobile() {
		return listFondoMobile;
	}

	public void setListFondoMobile(List<DetArchivoFondoDTO> listFondoMobile) {
		this.listFondoMobile = listFondoMobile;
	}
	
	

}
