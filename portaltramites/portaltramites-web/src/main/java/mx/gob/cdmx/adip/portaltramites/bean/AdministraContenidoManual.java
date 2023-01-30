package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.dto.CatDependenciasDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatTemaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ContenidoManualDTO;
import mx.gob.cdmx.adip.portaltramites.dao.ContenidoManualDAO;
import mx.gob.cdmx.adip.portaltramites.util.WebResources;

@Named("contenidoManualBean")
@ViewScoped
public class AdministraContenidoManual  implements Serializable{

	private static final long serialVersionUID = -2433884840711413987L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministraContenidoManual.class);
	
	@Inject
	private AdministradorBean adminBean;
	
	@Inject
	private ContenidoManualDAO contenidoManualDAO;
	
	private ContenidoManualDTO contenidoManualDTO;
	private List<ContenidoManualDTO> lstContManual;
	private List<CatDependenciasDTO> lstDep;
	private List<CatTemaDTO> lstTemas;
	private String lblTitulo;
	private String filtroTitulo;
	private Boolean filtroEstatus;
	
	@PostConstruct
	public void iniciarBandejaContManual() {
		limpiarFiltros();
	}
	
	public String init() {
		limpiarFiltros();
		agregarNuevoContenido();
		return adminBean.initContenido();
	}
	
	public void limpiarFiltros() {
		filtroTitulo = "";
		filtroEstatus = null;
		buscarCriterios();
	}
	
	public void buscarCriterios() {
		lstContManual = new ArrayList<ContenidoManualDTO>();
		ContenidoManualDTO criterios = new ContenidoManualDTO();
		criterios.setTitulo(filtroTitulo);
		criterios.setActivo(filtroEstatus);
		lstContManual = contenidoManualDAO.buscarPorCriterios(criterios);
	}
	
	public void initCat() {
		lstDep = new ArrayList<CatDependenciasDTO>();
		lstTemas = new ArrayList<CatTemaDTO>();		
		lstDep = contenidoManualDAO.buscarTodosBackDep();
		lstTemas = contenidoManualDAO.buscarTodosBackTema();
	}
	
	
	public void activoInactivo(ContenidoManualDTO dto) {
		contenidoManualDAO.actualizarActivoInactivo(dto);
		buscarCriterios();
	}
	
	public void removerContenido(ContenidoManualDTO dto) {
		contenidoManualDAO.remover(dto);
		buscarCriterios();
	}
	
	public void agregarNuevoContenido() {
		contenidoManualDTO = new ContenidoManualDTO();
		lblTitulo = "Nuevo";
		initCat();
	}
	
	public void verModificarContenido(ContenidoManualDTO dto) {
		contenidoManualDTO = dto;
		lblTitulo = "Modificar";
		initCat();
	}
	
	public String guardarContenido() {
		try {
			contenidoManualDAO.guardar(contenidoManualDTO);
			limpiarFiltros();
			PrimeFaces.current().executeScript("rcGuardadoExitosoContenido()");
		} catch (Exception ex) {
			LOGGER.error("ERROR AL GUARDAR CONTENIDO MANUAL: ", ex);
			WebResources.validationMessage("msj_error_registro", false);
			return null;
		}
		return null;
	}
	
	public void guardadoExitoso() {
		adminBean.actualizaSeccion(6);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Contenido guardado correctamente"));
	}
	
	public String actualizarContenido() {		
		try {
			contenidoManualDAO.actualizar(contenidoManualDTO);
			limpiarFiltros();
			PrimeFaces.current().executeScript("rcActualizacionExitosaContenido()");
		} catch (Exception ex) {
			LOGGER.error("ERROR AL ACTUALIZAR CONTENIDO MANUAL: ", ex);
			WebResources.validationMessage("msj_error_registro", false);
			return null;
		}		
		return null;
	}
	
	public void actualizacionExitosa() {
		adminBean.actualizaSeccion(6);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Contenido modificado correctamente"));
	}

	public ContenidoManualDTO getContenidoManualDTO() {
		return contenidoManualDTO;
	}

	public void setContenidoManualDTO(ContenidoManualDTO contenidoManualDTO) {
		this.contenidoManualDTO = contenidoManualDTO;
	}

	public List<ContenidoManualDTO> getLstContManual() {
		return lstContManual;
	}

	public void setLstContManual(List<ContenidoManualDTO> lstContManual) {
		this.lstContManual = lstContManual;
	}

	public String getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(String lblTitulo) {
		this.lblTitulo = lblTitulo;
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

	public List<CatDependenciasDTO> getLstDep() {
		return lstDep;
	}

	public void setLstDep(List<CatDependenciasDTO> lstDep) {
		this.lstDep = lstDep;
	}

	public List<CatTemaDTO> getLstTemas() {
		return lstTemas;
	}

	public void setLstTemas(List<CatTemaDTO> lstTemas) {
		this.lstTemas = lstTemas;
	}	
}
