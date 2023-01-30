package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO;
import mx.gob.cdmx.adip.portaltramites.dao.DetEnlaceDAO;

@Named("enlaceBean")
@ViewScoped
public class AdministraEnlaceBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministraEnlaceBean.class);
	private List<DetEnlaceDTO> listEnlace;
	private DetEnlaceDTO enlaceSelect;
	private String lblRegistro;

	@Inject
	private DetEnlaceDAO detEnlaceDAO;

	public AdministraEnlaceBean() {
		listEnlace = new ArrayList<>();
		enlaceSelect = new DetEnlaceDTO();
	}

	@PostConstruct
	private void init() {
		consultaEnlaces();
	}

	public void modificarEnlace(DetEnlaceDTO enlace) {
		lblRegistro = "Editar registro";
		enlaceSelect = enlace;
	}

	public void agregarEnlace() {
		enlaceSelect = new DetEnlaceDTO();
		lblRegistro = "Agregar registro";
	}

	public void guardarEnlace(DetEnlaceDTO enlace) {
		Date fechaActual = new Date();

		enlace.setFechaModificacion(fechaActual);

		if (enlace.getId() == null) {
			enlace.setEstatus(true);
			enlace.setFechaCreacion(fechaActual);
			try {
				detEnlaceDAO.guardar(enlace);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Enlace guardado correctamente"));
			} catch (Exception e) {
				LOGGER.error("Error al guardar enlace" + e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al eliminar el enlace"));
			}
		} else {
			try {
				detEnlaceDAO.actualizar(enlace);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Enlace modificado correctamente"));
			} catch (Exception e) {
				LOGGER.error("Error al actualizar enlace" + e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al actualizar el enlace"));
			}
		}
		consultaEnlaces();
	}

	public void consultaEnlaces() {
		listEnlace = detEnlaceDAO.buscarPorEstatus();
	}

	public void eliminarEnlace(DetEnlaceDTO enlace) {
		enlace.setEstatus(false);
		enlace.setVisible(false);
		try {
			detEnlaceDAO.actualizar(enlace);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Enlace eliminado correctamente"));
		} catch (Exception e) {
			LOGGER.error("Error al eliminar el enlace" + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al eliminar el enlace"));

		}
		consultaEnlaces();
	}

	public void actualizaSituacion(DetEnlaceDTO enlace) {
		try {
			enlace.setFechaModificacion(new Date());
			enlace.setVisible(!enlace.isVisible());
			detEnlaceDAO.actualizar(enlace);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Situación modificada correctamente"));
		} catch (Exception e) {
			LOGGER.error("Error al modificar situación" + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al modificar situación"));
		}
	}


	public List<DetEnlaceDTO> getListEnlace() {
		return listEnlace;
	}

	public void setListEnlace(List<DetEnlaceDTO> listEnlace) {
		this.listEnlace = listEnlace;
	}

	public DetEnlaceDTO getEnlaceSelect() {
		return enlaceSelect;
	}

	public void setEnlaceSelect(DetEnlaceDTO enlaceSelect) {
		this.enlaceSelect = enlaceSelect;
	}

	public String getLblRegistro() {
		return lblRegistro;
	}

	public void setLblRegistro(String lblRegistro) {
		this.lblRegistro = lblRegistro;
	}
	
	
	

}
