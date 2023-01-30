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

import mx.gob.cdmx.adip.portaltramites.commons.dto.TagsDTO;
import mx.gob.cdmx.adip.portaltramites.dao.TagsDAO;

@Named("tagBean")
@ViewScoped
public class AdministraTagBean implements Serializable {
	
	private static final long serialVersionUID = -1993349738180583756L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministraTagBean.class);
	
	@Inject
	private AdministradorBean adminBean;
	
	@Inject
	TagsDAO tagsDAO;
	
	private TagsDTO tagsDTO;
	private List<TagsDTO> lstTags;
	private String lblTitulo;
	private String filtroTituloTag;
	private Boolean filtroEstatus;
	
	@PostConstruct
	public void iniciarBandejaTags() {
		limpiarFiltros();
	}
	
	public String init() {		
		limpiarFiltros();
		agregarNuevoTag();
		return adminBean.init();
	}
	
	public void limpiarFiltros() {
		filtroTituloTag = "";
		filtroEstatus = null;
		buscarTags();
	}
	
	public void buscarTags() {
		lstTags = new ArrayList<TagsDTO>();
		TagsDTO criterios = new TagsDTO();
		criterios.setTituloTag(filtroTituloTag);
		criterios.setActivo(filtroEstatus);
		lstTags = tagsDAO.buscarPorCriterios(criterios);
	}	
	
	public void activoInactivo(TagsDTO dto) {
		tagsDAO.actualizarActivoInactivo(dto);
		buscarTags();
	}
	
	public void removerTag(TagsDTO dto) {
		tagsDAO.remover(dto);
		buscarTags();		
	}	
	
	public void agregarNuevoTag() {
		tagsDTO = new TagsDTO();
		lblTitulo = "Nuevo";
	}
	
	public void verModificarTag(TagsDTO dto) {
		lblTitulo = "Modificar";
		tagsDTO = dto;		
	}
	
	public String guardarNuevoTag() {		
		try {	
			String filtered = tagsDTO.getTituloTag().trim().replaceAll("\\s+", " ");
			tagsDTO.setTituloTag(filtered);
			tagsDAO.guardar(tagsDTO);
			limpiarFiltros();			
			PrimeFaces.current().executeScript("rcGuardadoExitosoTag()");
		} catch (Exception ex) {
			LOGGER.error("ERROR AL GUARDAR TAG: ", ex);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al guardar el enlace"));
			PrimeFaces.current().executeScript("rcAdmin()");
			return null;
		}
		return null;
	}
	
	public void guardadoExitoso() {
		adminBean.actualizaSeccion(4);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Tag guardado correctamente"));
	}
	
	public String actualizarTag() {		
		try {
			String filtered = tagsDTO.getTituloTag().trim().replaceAll("\\s+", " ");
			tagsDTO.setTituloTag(filtered);
			tagsDAO.actualizar(tagsDTO);
			limpiarFiltros();			
			PrimeFaces.current().executeScript("rcActualizacionExitosaTag()");
		} catch (Exception ex) {
			LOGGER.error("ERROR AL ACTUALIZAR TAGS: ", ex);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al actualizar el Tag"));
			PrimeFaces.current().executeScript("rcAdmin()");
			return null;
		}
		return null;
	}
	
	public void actualizacionExitosa() {
		adminBean.actualizaSeccion(4);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Tag modificado correctamente"));
	}

	public TagsDTO getTagsDTO() {
		return tagsDTO;
	}

	public void setTagsDTO(TagsDTO tagsDTO) {
		this.tagsDTO = tagsDTO;
	}

	public List<TagsDTO> getLstTags() {
		return lstTags;
	}

	public void setLstTags(List<TagsDTO> lstTags) {
		this.lstTags = lstTags;
	}

	public String getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(String lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public String getFiltroTituloTag() {
		return filtroTituloTag;
	}

	public void setFiltroTituloTag(String filtroTituloTag) {
		this.filtroTituloTag = filtroTituloTag;
	}

	public Boolean getFiltroEstatus() {
		return filtroEstatus;
	}

	public void setFiltroEstatus(Boolean filtroEstatus) {
		this.filtroEstatus = filtroEstatus;
	}
	
}
