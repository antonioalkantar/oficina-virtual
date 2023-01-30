package mx.gob.cdmx.adip.portaltramites.bean;

import javax.inject.Named;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.common.util.StringUtils;
import mx.gob.cdmx.adip.portaltramites.commons.dto.BitTramiteVistoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatOrigenConsultaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ContenidoManualDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.dao.BitTramiteVistoDAO;
import mx.gob.cdmx.adip.portaltramites.dao.ContenidoManualDAO;
import mx.gob.cdmx.adip.portaltramites.dao.MasBuscadoContDAO;
import mx.gob.cdmx.adip.portaltramites.dao.PortalTramitesBusquedaDAO;
import mx.gob.cdmx.adip.portaltramites.dao.ProgramasSocialesDAO;
import mx.gob.cdmx.adip.portaltramites.dto.PortalTramitesBusquedaDTO;
import mx.gob.cdmx.adip.sibis.dto.ProgramasSocialesDTO;

import java.io.IOException;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@Named("homeBean")
@SessionScoped
public class HomeBean implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeBean.class); 
	private static final long serialVersionUID = 9087551321296717273L;
	
	@Inject
	private PortalTramitesBusquedaDAO portalTramitesBusquedaDAO;
	@Inject
	private MasBuscadoContDAO masBuscadoContDAO;

	@Inject
	private BitTramiteVistoDAO bitTramiteVistoDAO;
	
	@Inject
	private ProgramasSocialesDAO programasSocialesDAO;

	@Inject
	private ContenidoManualDAO contenidoManualDAO;


	private List<PortalTramitesBusquedaDTO> lstPortalTramitesBusquedaDTO;
	private List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltrada;
	private List<ProgramasSocialesDTO> lstProgramasSocialesDTO;
	private List<ContenidoManualDTO> lstContenidoManualDTO;
	private String nombreTramite;

	private List<SelectItem> listItemsMenu;
	private SelectItem itemSelectMenu;
	private int optionSelect;
	private int opcionCategoria;
	private int opcionAutoridad;
	private PortalTramitesBusquedaDTO tramiteSeleccionado;

	private LocalDate hoy;
	private DayOfWeek diaDeLaSemana;
	private String palabraBuscada = "";
	private int totalElementos;
	private int origenUrl;
	private String redirectResultSearch;
	private Integer clasificacion;
	private boolean verBuscador;
	private boolean verIndicadores;
	private int menuIndicador = Constantes.MENU_INDICADORES;
	private int menuBuscador = Constantes.MENU_BUSCADOR;
	private int NumProgramasSociales ;

	@PostConstruct
	public void init() {
		lstPortalTramitesBusquedaDTO = portalTramitesBusquedaDAO.buscarTodos();
		lstProgramasSocialesDTO = programasSocialesDAO.buscarTodos(); 
		NumProgramasSociales = lstProgramasSocialesDTO.size();
		lstContenidoManualDTO = contenidoManualDAO.buscarTodos();
		for (ContenidoManualDTO lstDatoCont:lstContenidoManualDTO) {
			lstPortalTramitesBusquedaDTO.add(new PortalTramitesBusquedaDTO(lstDatoCont.getTitulo(), lstDatoCont.getDescripcion(), lstDatoCont.getPalabrasClave(), lstDatoCont.getCatDependenciasDTO().getIdDependencia().intValue(), lstDatoCont.getCatTemaDTO().getIdCatTema(), lstDatoCont.getLink(), Constantes.CLASIFICACION_SITIOS_INTERES, true, true));
		}
		for (ProgramasSocialesDTO dato:lstProgramasSocialesDTO) {
			lstPortalTramitesBusquedaDTO.add(new PortalTramitesBusquedaDTO(dato.getAbreviatura(), dato.getDescription(), dato.getPalabrasClave(), dato.getCatDependenciaRetysDTO().getIdDependenciaRetys().intValue(), dato.getCategoriasDTO().getId(), "https://tubienestar.cdmx.gob.mx/detalle_publico/resumen/programa/" + dato.getId() + "/" + dato.getClave(), Constantes.CLASIFICACION_PROGRAMAS_SOCIALES, true, dato.getEsDigital(), dato.getResumenesProgramasDTO().getUrlPrograma(), dato.getCatDependenciaRetysDTO().getNombreDependencia()));
		}

		inicializar();
		clasificacion = -1;
	}

	public void inicializar() {
		totalElementos = 0;
		lstPortalTramitesFiltrada = new ArrayList<>();
		listItemsMenu = new ArrayList<>();
		tramiteSeleccionado = new PortalTramitesBusquedaDTO();

		optionSelect = 0;
		opcionCategoria = 0;
		opcionAutoridad = 0;
		hoy = LocalDate.now();
		diaDeLaSemana = hoy.getDayOfWeek();
		palabraBuscada = "";
		verIndicadores = false;
		verBuscador = false;
	}

	public void backPage() {

	}

	public void backPageCustomm() {

		LOGGER.info("redireccionar a HOME");

	}

	public void buscarPorPalabra() {
		if (palabraBuscada != null && !palabraBuscada.isEmpty() && !lstPortalTramitesFiltrada.isEmpty()) {
			try {
				clasificacion = -1;
				FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.REDIRECT_BUSCADOR);
			} catch (IOException e) {
				LOGGER.debug(e.getMessage());
			}
		}
	}

	public void buscarPorTag(String tag) {
		palabraBuscada = tag;
		if (palabraBuscada != null && !palabraBuscada.isEmpty()) {
			try {
				clasificacion = -1;
				FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.REDIRECT_BUSCADOR);
			} catch (IOException e) {
				LOGGER.debug(e.getMessage());
			}
		}
	}

	public String detalleTramite(PortalTramitesBusquedaDTO tramite, boolean ajax, int idOrigen) throws IOException {
		tramiteSeleccionado = tramite;
		verBuscador = false;
		verIndicadores = false;
		if (tramiteSeleccionado.getId() != null) {
			origenUrl = idOrigen;
			// Contador para lo más buscado
			masBuscadoContDAO.actualizarContador(tramiteSeleccionado.getId().intValue());

			BitTramiteVistoDTO bitTramiteVistoDTO = new BitTramiteVistoDTO();
			bitTramiteVistoDTO.setCatOrigenConsultaDTO(new CatOrigenConsultaDTO(idOrigen));
			bitTramiteVistoDTO.setIdTramiteServicio(tramiteSeleccionado.getId());
			bitTramiteVistoDTO.setTituloTramite(tramiteSeleccionado.getNombreOficial());
			bitTramiteVistoDAO.guardar(bitTramiteVistoDTO);
			if (ajax) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.RETURN_DETALLE_TRAMITE_PAGE
						+ Constantes.JSF_REDIRECT + "&idTramite=" + tramiteSeleccionado.getId());
				FacesContext.getCurrentInstance().responseComplete();
			} else {
				return Constantes.RETURN_DETALLE_TRAMITE_PAGE + Constantes.JSF_REDIRECT + "&idTramite="
						+ tramiteSeleccionado.getId();
			}
		}else if(tramiteSeleccionado.getProgramaSocial() != null && tramiteSeleccionado.getProgramaSocial()){
			palabraBuscada = tramiteSeleccionado.getNombreOficial();
			buscarPorPalabra();
		}
		return "";
	}

	public List<PortalTramitesBusquedaDTO> completeText(String query) {
		palabraBuscada = query.trim();
		do {
			palabraBuscada = palabraBuscada.replaceAll("  ", " ");
		} while (palabraBuscada.indexOf("  ") > 0);
		lstPortalTramitesFiltrada.clear();

		lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO.stream()
				.filter(tramite -> StringUtils.removeDiacriticalMarks(tramite.getNombreOficial().toLowerCase())
						.contains(StringUtils.removeDiacriticalMarks(palabraBuscada.toLowerCase()))
						|| StringUtils
								.removeDiacriticalMarks((tramite.getSinonimoBusqueda() == null ? ""
										: tramite.getSinonimoBusqueda().toLowerCase()))
								.contains(StringUtils.removeDiacriticalMarks(palabraBuscada.toLowerCase())))
				.collect(Collectors.toList()));

		return lstPortalTramitesFiltrada;
	}

	public void goBack() {
		try {
			switch (origenUrl) {
				case 3:// Regresar desde resultadoBuscador-> Detalle de trámite
					origenUrl = 2;
					FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.REDIRECT_BUSCADOR);
					FacesContext.getCurrentInstance().responseComplete();
					break;
				case 1:// Buscador home->Detalle de tramite
				case 2:// Grid home -> Detalle de tramite
				case 4:// URL Directa
				case 5:// Resultado buscador
					FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.RETURN_HOME_PAGE);
					FacesContext.getCurrentInstance().responseComplete();
					break;
				default:
					FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.RETURN_HOME_PAGE);
					FacesContext.getCurrentInstance().responseComplete();
					break;
			}
		} catch (IOException e) {
			LOGGER.info("Error al redirigir", e.getMessage());
		}
	}

	public void filtraPorClasificacion(Integer tipoClasificacion) {
		try {
			clasificacion = tipoClasificacion;
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.REDIRECT_BUSCADOR);
		} catch (IOException e) {
			LOGGER.debug(e.getMessage());
		}
	}

	public void actualizaMenu(int menu) {
		switch (menu) {
			case Constantes.MENU_INDICADORES:
				if (verIndicadores) {
					verIndicadores = false;
					PrimeFaces.current().executeScript("PF('panelIndicadores').collapse()");
				} else {
					verIndicadores = true;
					PrimeFaces.current().executeScript("PF('panelIndicadores').expand()");
				}
				verBuscador = false;
				break;
			case Constantes.MENU_BUSCADOR:
				if (verBuscador) {
					verBuscador = false;
				} else {
					verBuscador = true;
				}
				verIndicadores = false;
				break;
		}
	}
	
	
	
	
	public void cerrarIndicadores() {
		verIndicadores = false;
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

	public List<SelectItem> getListItemsMenu() {
		return listItemsMenu;
	}

	public void setListItemsMenu(List<SelectItem> listItemsMenu) {
		this.listItemsMenu = listItemsMenu;
	}

	public SelectItem getItemSelectMenu() {
		return itemSelectMenu;
	}

	public void setItemSelectMenu(SelectItem itemSelectMenu) {
		this.itemSelectMenu = itemSelectMenu;
	}

	public List<PortalTramitesBusquedaDTO> getLstPortalTramitesFiltrada() {
		return lstPortalTramitesFiltrada;
	}

	public void setLstPortalTramitesFiltrada(List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltrada) {
		this.lstPortalTramitesFiltrada = lstPortalTramitesFiltrada;
	}

	public PortalTramitesBusquedaDTO getTramiteSeleccionado() {
		return tramiteSeleccionado;
	}

	public void setTramiteSeleccionado(PortalTramitesBusquedaDTO tramiteSeleccionado) {
		this.tramiteSeleccionado = tramiteSeleccionado;
	}

	public int getOptionSelect() {
		return optionSelect;
	}

	public void setOptionSelect(int optionSelect) {
		this.optionSelect = optionSelect;
	}

	public DayOfWeek getDiaDeLaSemana() {
		return diaDeLaSemana;
	}

	public void setDiaDeLaSemana(DayOfWeek diaDeLaSemana) {
		this.diaDeLaSemana = diaDeLaSemana;
	}

	public String getUrlLlave() {
		return Environment.getUrlHomeRedirectLlave();
	}

	public int getOpcionAutoridad() {
		return opcionAutoridad;
	}

	public void setOpcionAutoridad(int opcionAutoridad) {
		this.opcionAutoridad = opcionAutoridad;
	}

	public int getOpcionCategoria() {
		return opcionCategoria;
	}

	public void setOpcionCategoria(int opcionCategoria) {
		this.opcionCategoria = opcionCategoria;
	}

	public int getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(int totalElementos) {
		this.totalElementos = totalElementos;
	}

	public String getPalabraBuscada() {
		return palabraBuscada;
	}

	public void setPalabraBuscada(String palabraBuscada) {
		this.palabraBuscada = palabraBuscada;
	}

	public int getOrigenUrl() {
		return origenUrl;
	}

	public void setOrigenUrl(int origenUrl) {
		this.origenUrl = origenUrl;
	}

	public String getRedirectResultSearch() {
		return redirectResultSearch;
	}

	public void setRedirectResultSearch(String redirectResultSearch) {
		this.redirectResultSearch = redirectResultSearch;
	}

	public Integer getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Integer clasificacion) {
		this.clasificacion = clasificacion;
	}

	public boolean isVerBuscador() {
		return verBuscador;
	}

	public void setVerBuscador(boolean verBuscador) {
		this.verBuscador = verBuscador;
	}

	public boolean isVerIndicadores() {
		return verIndicadores;
	}

	public void setVerIndicadores(boolean verIndicadores) {
		this.verIndicadores = verIndicadores;
	}

	public int getMenuIndicador() {
		return menuIndicador;
	}

	public void setMenuIndicador(int menuIndicador) {
		this.menuIndicador = menuIndicador;
	}

	public int getMenuBuscador() {
		return menuBuscador;
	}

	public void setMenuBuscador(int menuBuscador) {
		this.menuBuscador = menuBuscador;
	}

	public int getNumProgramasSociales() {
		return NumProgramasSociales;
	}

	public void setNumProgramasSociales(int numProgramasSociales) {
		NumProgramasSociales = numProgramasSociales;
	}

}
