package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.dao.EncabezadoDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO;

@Named("encabezadoBean")
@ViewScoped
public class AdministrarEncabezadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministrarEncabezadoBean.class);
	private List<DetEncabezadoDTO> listEncabezado;
	private DetEncabezadoDTO encabezadoSelect;

	@Inject
	private EncabezadoDAO encabezadoDAO;

	public AdministrarEncabezadoBean() {
		listEncabezado = new ArrayList<>();
		encabezadoSelect = new DetEncabezadoDTO();
	}

	@PostConstruct
	private void init() {
		consultaEncabezados();
	}

	public void agregaEncabezado() {
		encabezadoSelect = new DetEncabezadoDTO();
	}

	public void modificarEncabezado(DetEncabezadoDTO encabezado) {
		encabezadoSelect = encabezado;
		if(!encabezadoSelect.getBackground().contains("#")) {
			encabezadoSelect.setBackground("#" + encabezado.getBackground());
		}
		encabezadoSelect.setBackground(encabezado.getBackground().substring(1));
	}
	
	public void actualizarSituacion(DetEncabezadoDTO encabezado) {
		encabezadoSelect = encabezado;
		encabezadoSelect.setSituacion(!encabezado.isSituacion());
		encabezadoSelect.setBackground(encabezado.getBackground().substring(1));
		guardarEncabezado(encabezadoSelect);
	}

	public void guardarEncabezado(DetEncabezadoDTO encabezado) {
		encabezado.setBackground("#" + encabezado.getBackground());
//		if (encabezado.getId() == null) {
//			encabezado.setEstatus(true);
//			try {
//				encabezadoDAO.guardar(encabezado);
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Encabezado guardado correctamente"));
//			} catch (Exception e) {
//				LOGGER.error("Error al guardar el encabezado");
//				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al guardar el encabezado"));
//			}
//		} else {
			try {
				encabezadoDAO.actualizar(encabezado);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Encabezado actualizado correctamente"));
			} catch (Exception e) {
				LOGGER.error("Error al actualizar el encabezado");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al actualizar el encabezado"));
			}
//		}
		consultaEncabezados();
	}

	public void eliminarEncabezado(DetEncabezadoDTO encabezado) {
		encabezado.setEstatus(false);
		encabezado.setSituacion(false);
		try {
			encabezadoDAO.actualizar(encabezado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Encabezado eliminado correctamente"));
		}catch (Exception e) {
			LOGGER.error("Error al eliminar el encabezado");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al eliminar el encabezado"));
		}
		consultaEncabezados();
	}

	public void consultaEncabezados() {
		listEncabezado = encabezadoDAO.buscarPorEstatus();
	}
//<editor-fold defaultstate="collapsed" desc="Validaciones length">    
	public void isLengthValid(FacesContext ctx, UIComponent component, Object value) throws ValidatorException {
        if (value != null && value.toString().length() >2000) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El campo excede el límite de caracteres permitidos (2000)"));
        }
    }
//</editor-fold>
	public List<DetEncabezadoDTO> getListEncabezado() {
		return listEncabezado;
	}

	public void setListEncabezado(List<DetEncabezadoDTO> listEncabezado) {
		this.listEncabezado = listEncabezado;
	}

	public DetEncabezadoDTO getEncabezadoSelect() {
		return encabezadoSelect;
	}

	public void setEncabezadoSelect(DetEncabezadoDTO encabezadoSelect) {
		this.encabezadoSelect = encabezadoSelect;
	}

}
