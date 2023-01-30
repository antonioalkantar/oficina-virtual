package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.omnifaces.cdi.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.dto.AnunciosDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.TagsDTO;
import mx.gob.cdmx.adip.portaltramites.dao.AnunciosDAO;
import mx.gob.cdmx.adip.portaltramites.dao.DetEnlaceDAO;
import mx.gob.cdmx.adip.portaltramites.dao.ServicioSemaforoEpDAO;
import mx.gob.cdmx.adip.portaltramites.dao.TagsDAO;
import mx.gob.cdmx.adip.widget.dto.ServicioSemaforoEpDTO;

@Named
@ViewScoped
public class HomeSeccionesBean implements Serializable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeSeccionesBean.class);
	private static final long serialVersionUID = -6156789668523560478L;
	
	@Inject
	private DetEnlaceDAO detEnlaceDAO;
	
	@Inject
	private ServicioSemaforoEpDAO servicioSemaforoDAO;	
	
	@Inject 
	private TagsDAO tagsDAO;
	
	@Inject
	private AnunciosDAO anunciosDAO;
	
	private List<DetEnlaceDTO> listDetEnlace;
	private List<TagsDTO> lstTags;
    private List<AnunciosDTO> lstAnuncios;
	
	private ServicioSemaforoEpDTO semaforoEpi;
	
	@PostConstruct
    public void init() {
//		LOGGER.info("...............Inicializa HOME.............");
		listDetEnlace = detEnlaceDAO.buscarPorVisible();
		lstTags = tagsDAO.consultaTopTags();
		lstAnuncios = anunciosDAO.buscarTodos();
		cargaSemaforoEpidemiologico();
	}

	public void cargaSemaforoEpidemiologico() {
		 List<ServicioSemaforoEpDTO> dtos= servicioSemaforoDAO.buscarTodos();
		 semaforoEpi = (dtos.size()>0) ? dtos.get(0) : new ServicioSemaforoEpDTO() ;	 
	}
	
	public String toBase64Img(String path) {
		String base="";		
		byte[] fileContent = null;
		try {
	        File file = new File(path);
			if (file.exists()) {
				fileContent = FileUtils.readFileToByteArray(file);
				base = Base64.getEncoder().encodeToString(fileContent);		
				return "data:image/jpeg;base64,"+base;
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "data:image/jpeg;base64,"+base;
		
	}
	
	public List<DetEnlaceDTO> getListDetEnlace() {
		return listDetEnlace;
	}

	public void setListDetEnlace(List<DetEnlaceDTO> listDetEnlace) {
		this.listDetEnlace = listDetEnlace;
	}

	public ServicioSemaforoEpDTO getSemaforoEpi() {
		return semaforoEpi;
	}

	public void setSemaforoEpi(ServicioSemaforoEpDTO semaforoEpi) {
		this.semaforoEpi = semaforoEpi;
	}

	public List<TagsDTO> getLstTags() {
		return lstTags;
	}

	public void setLstTags(List<TagsDTO> lstTags) {
		this.lstTags = lstTags;
	}

	public List<AnunciosDTO> getLstAnuncios() {
		return lstAnuncios;
	}

	public void setLstAnuncios(List<AnunciosDTO> lstAnuncios) {
		this.lstAnuncios = lstAnuncios;
	}

}
