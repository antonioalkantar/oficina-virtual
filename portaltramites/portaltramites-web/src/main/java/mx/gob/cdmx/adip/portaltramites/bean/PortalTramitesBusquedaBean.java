package mx.gob.cdmx.adip.portaltramites.bean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.gob.cdmx.adip.portaltramites.dao.PortalTramitesBusquedaDAO;
import mx.gob.cdmx.adip.portaltramites.dto.PortalTramitesBusquedaDTO;

import javax.inject.Inject;

@Named()
@ViewScoped
public class PortalTramitesBusquedaBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2748705305041815037L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PortalTramitesBusquedaBean.class);


	@Inject
	PortalTramitesBusquedaDAO portalTramitesBusquedaDAO;
	
	private List<PortalTramitesBusquedaDTO> lstPortalTramitesBusquedaDTO;
	private String nombreTramite;
	
	public PortalTramitesBusquedaBean() {
	}

	@PostConstruct
    public void init() {
		lstPortalTramitesBusquedaDTO = new ArrayList<PortalTramitesBusquedaDTO>();
		lstPortalTramitesBusquedaDTO = portalTramitesBusquedaDAO.buscarTodos();
	}

	public List<String> completeText(String query) {
		String queryLowerCase = query.toLowerCase();
		List<String> countryList = new ArrayList<>();
		for (PortalTramitesBusquedaDTO country : lstPortalTramitesBusquedaDTO) {
			countryList.add(country.getNombreOficial());
		}
		return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
	}
	public List<PortalTramitesBusquedaDTO> getLstPortalTramitesBusquedaDTO() {
		return lstPortalTramitesBusquedaDTO;
	}

	public void setLstPortalTramitesBusquedaDTO(List<PortalTramitesBusquedaDTO> lstPortalTramitesBusquedaDTO) {
		this.lstPortalTramitesBusquedaDTO = lstPortalTramitesBusquedaDTO;
	}

	public String getNombreTramite() {
		return nombreTramite;
	}

	public void setNombreTramite(String nombreTramite) {
		this.nombreTramite = nombreTramite;
	}
}
