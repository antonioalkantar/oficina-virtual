package mx.gob.cdmx.adip.portaltramites.bean;

import javax.inject.Named;
import javax.inject.Inject;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.component.autocomplete.AutoComplete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.catalogos.dao.CatDependenciaDAO;
import mx.gob.cdmx.adip.portaltramites.catalogos.dao.CatMateriaDAO;
import mx.gob.cdmx.adip.portaltramites.dao.DetEnlaceDAO;
import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.common.util.StringUtils;
import mx.gob.cdmx.adip.portaltramites.commons.dto.BitTramiteVistoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatEsTramiteServicioDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatOrigenConsultaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ContenidoManualDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetLoMasBuscadoContDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetLoMasBuscadoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetUrlRegistradoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.dao.BitTramiteVistoDAO;
import mx.gob.cdmx.adip.portaltramites.dao.ContenidoManualDAO;
import mx.gob.cdmx.adip.portaltramites.dao.MasBuscadoContDAO;
import mx.gob.cdmx.adip.portaltramites.dao.MasBuscadoDAO;
import mx.gob.cdmx.adip.portaltramites.dao.PortalTramitesBusquedaDAO;
import mx.gob.cdmx.adip.portaltramites.dao.ProgramasSocialesDAO;
import mx.gob.cdmx.adip.portaltramites.dto.AdminMateriaDTO;
import mx.gob.cdmx.adip.portaltramites.dto.CatDependenciaDTO;
import mx.gob.cdmx.adip.portaltramites.dto.PortalTramitesBusquedaDTO;
import mx.gob.cdmx.adip.sibis.dto.ProgramasSocialesDTO;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

@Named
@ViewScoped
public class BusquedaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2354451371363196145L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaBean.class);

	@Inject
	private PortalTramitesBusquedaDAO portalTramitesBusquedaDAO;

	@Inject
	private CatDependenciaDAO catDependenciaDAO;

	@Inject
	private CatMateriaDAO catMateriaDAO;

	@Inject
	private MasBuscadoDAO masBuscadoDAO;
	
	@Inject
	private MasBuscadoContDAO masBuscadoContDAO;
	
	@Inject
	private BitTramiteVistoDAO bitTramiteVistoDAO;
		
	@Inject
	private DetEnlaceDAO detEnlaceDAO;

	@Inject
	private ContenidoManualDAO contenidoManualDAO;
	
	@Inject
	private HomeBean homeBean;

	@Inject
	private ProgramasSocialesDAO programasSocialesDAO;
	
	private List<PortalTramitesBusquedaDTO> lstPortalTramitesBusquedaDTO;
	private List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltrada;
	private List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltradaAux;
	private List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltradaMovil;
	private List<ProgramasSocialesDTO> lstProgramasSocialesDTO;
	private List<CatDependenciaDTO> lstCatDependenciaDTOView;
	private List<CatDependenciaDTO> lstAllCatDependenciaDTO;
	private List<ContenidoManualDTO> lstContenidoManualDTO;
	private List<AdminMateriaDTO> lstCatMateriaDTOView;
	private List<AdminMateriaDTO> lstAllCatMateriaDTO;
	private List<DetLoMasBuscadoDTO> lstMasBuscadoDTO;
    private List<DetLoMasBuscadoContDTO> lstMasBuscadoContDTO;
    private List<CatEsTramiteServicioDTO> lstEsTramiteServicioView;
    private List<CatEsTramiteServicioDTO> lstAllEsTramiteServicio;
    private List<DetEnlaceDTO> listDetEnlace;
    private List<DetUrlRegistradoDTO> lstUrl;
    private PortalTramitesBusquedaDTO tramiteSeleccionado;
	private Integer[] selectedDependencia;
	private Long[] selectedClasificacion;	
	private Long[] selectedTema;
	private Long idTemaSelected;
    private Integer optionSelect;
    private int totalElementos;
    private int origenUrl;	
    private int contadorAux;
    private String palabraBuscada = ""; 
	private Boolean bndTodoCategoria;
	private Boolean bndTodoDep;
	private Boolean mandaDependencia;
	private Boolean mandaCategoria;
    
	@PostConstruct
    public void init() {

		if (homeBean == null) {
			palabraBuscada = "";
		} else {
			this.origenUrl = homeBean.getOrigenUrl();
			this.palabraBuscada = homeBean.getPalabraBuscada();
			FacesContext context = FacesContext.getCurrentInstance();
			AutoComplete autocomplete = (AutoComplete) context.getViewRoot().findComponent("frmHomeTramite:acSimple");
			AutoComplete autocompleteMob = (AutoComplete) context.getViewRoot().findComponent("frmHomeTramite:acSimpleMob");
			if (autocomplete != null) {
				autocomplete.setValue(new PortalTramitesBusquedaDTO(null, null, palabraBuscada));
			}
			if (autocompleteMob != null) {
				autocompleteMob.setValue(new PortalTramitesBusquedaDTO(null, null, palabraBuscada));
			}
		}

		lstEsTramiteServicioView = new ArrayList<CatEsTramiteServicioDTO>();
		lstCatDependenciaDTOView = new ArrayList<CatDependenciaDTO>();
		lstAllCatDependenciaDTO = new ArrayList<CatDependenciaDTO>();
		lstAllCatMateriaDTO = new ArrayList<AdminMateriaDTO>();
		lstCatMateriaDTOView = new ArrayList<AdminMateriaDTO>();
		lstPortalTramitesFiltrada = new ArrayList<PortalTramitesBusquedaDTO>();
		lstPortalTramitesFiltradaMovil = new ArrayList<PortalTramitesBusquedaDTO>();
		lstAllEsTramiteServicio = new ArrayList<CatEsTramiteServicioDTO>(); 
		lstPortalTramitesFiltradaAux = new ArrayList<PortalTramitesBusquedaDTO>();
		lstProgramasSocialesDTO = new ArrayList<ProgramasSocialesDTO>();
		lstUrl = new ArrayList<DetUrlRegistradoDTO>();
		tramiteSeleccionado = new PortalTramitesBusquedaDTO();
			
		totalElementos = Constantes.INT_VALOR_CERO;
		
		lstAllCatDependenciaDTO = catDependenciaDAO.buscarTodosAlt();
		lstAllCatMateriaDTO = catMateriaDAO.buscarTodos();
		lstContenidoManualDTO = contenidoManualDAO.buscarTodos();
		lstMasBuscadoDTO = masBuscadoDAO.buscarTodos();
		lstMasBuscadoContDTO = masBuscadoContDAO.buscarTodos();
		listDetEnlace = detEnlaceDAO.buscarPorVisible();
		lstProgramasSocialesDTO = programasSocialesDAO.buscarTodos();
		
		llenaListaTramServProgContManual();

		lstAllEsTramiteServicio.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_PROGRAMAS_SOCIALES, Constantes.CLASIFICACION_PROGRAMAS_SOCIALES_DESC));
		lstAllEsTramiteServicio.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_TRAMITES, Constantes.CLASIFICACION_TRAMITES_DESC));
//		lstAllEsTramiteServicio.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_SERVICIOS, Constantes.CLASIFICACION_SERVICIOS_DESC));
		lstAllEsTramiteServicio.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_TRAMITES_DIGITALES, Constantes.CLASIFICACION_TRAMITES_DIGITALES_DESC));
//		lstAllEsTramiteServicio.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_SITIOS_INTERES, Constantes.CLASIFICACION_SITIOS_INTERES_DESC));
		lstEsTramiteServicioView.addAll(lstAllEsTramiteServicio);

		mandaDependencia = false;
		mandaCategoria = false;

		buscarPorPalabra();
		if (homeBean.getClasificacion() != null && homeBean.getClasificacion() != -1) {
			this.optionSelect = homeBean.getClasificacion();
			filtraPorClasificacion(homeBean.getClasificacion());
		}
	}
	
	// se obitnene todos los datos para filtrar
	public void llenaListaTramServProgContManual() {
		Boolean esDigital = false;
		lstPortalTramitesFiltradaAux.clear();
		lstPortalTramitesBusquedaDTO = portalTramitesBusquedaDAO.buscarTodos();
		for (PortalTramitesBusquedaDTO dat:lstPortalTramitesBusquedaDTO) {
			if (dat.getPuedeRealizarseDigitalmente() != null && dat.getPuedeRealizarseDigitalmente() && dat.getLink() == null) {
				dat.setPuedeRealizarseDigitalmente(false);
			}
			lstPortalTramitesFiltradaAux.add(dat);
		}
		lstPortalTramitesBusquedaDTO.clear();
		lstPortalTramitesBusquedaDTO.addAll(lstPortalTramitesFiltradaAux);
		lstPortalTramitesFiltradaAux.clear();

		for (ContenidoManualDTO lstDatoCont:lstContenidoManualDTO) {// sitios de interés se clasifican como trámites
			lstPortalTramitesBusquedaDTO.add(new PortalTramitesBusquedaDTO(lstDatoCont.getTitulo(), lstDatoCont.getDescripcion(), lstDatoCont.getPalabrasClave(), lstDatoCont.getCatDependenciasDTO().getIdDependencia().intValue(), lstDatoCont.getCatTemaDTO().getIdCatTema(), lstDatoCont.getLink(), Constantes.CLASIFICACION_TRAMITES, true, true));
		}

		for (ProgramasSocialesDTO dato:lstProgramasSocialesDTO) {
			if (dato.getEsDigital() != null && dato.getEsDigital() && dato.getResumenesProgramasDTO().getUrlPrograma() != null) {
				esDigital = true;
			} else {
				esDigital = false;
			}
			lstPortalTramitesBusquedaDTO.add(new PortalTramitesBusquedaDTO(dato.getAbreviatura(), dato.getDescription(), dato.getPalabrasClave(), dato.getCatDependenciaRetysDTO().getIdDependenciaRetys().intValue(), dato.getCategoriasDTO().getId(), "https://tubienestar.cdmx.gob.mx/detalle_publico/resumen/programa/" + dato.getId() + "/" + dato.getClave(), Constantes.CLASIFICACION_PROGRAMAS_SOCIALES, true, esDigital, dato.getResumenesProgramasDTO().getUrlPrograma(), dato.getCatDependenciaRetysDTO().getNombreDependencia()));
		}
		
//		if (optionSelect != null && optionSelect > 0) {
//			lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO.stream().filter(tramite -> tramite.getIdEsTramiteServicio().intValue() == optionSelect).collect(Collectors.toList()));
//		}
	}


	public void buscarPorPalabra() {
		optionSelect = -1;

		selectedDependencia = new Integer[Constantes.INT_VALOR_CERO];
		selectedClasificacion = new Long[Constantes.INT_VALOR_CERO];
		selectedTema = new Long[Constantes.INT_VALOR_CERO];
//		lstEsTramiteServicioView.clear();
		lstCatMateriaDTOView.clear();
		lstCatDependenciaDTOView.clear();

	    filtraPorPalabra();
		//ordenaCatalogosClasificacion(lstPortalTramitesBusquedaDTO);
		ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
		ordenaCatalogosDependencia(lstPortalTramitesFiltrada);
		mandaDependencia = false;
		mandaCategoria = false;
		lstPortalTramitesFiltrada = ordenaFiltraTramites(lstPortalTramitesFiltrada);
		totalElementos = lstPortalTramitesFiltrada.size();
	}
	
	public void filtraPorPalabra() {
		if(palabraBuscada != null && !palabraBuscada.isEmpty()) {
			lstPortalTramitesFiltradaAux.clear();
			
			lstPortalTramitesFiltradaAux = lstPortalTramitesBusquedaDTO.stream().filter(tramite -> 
			StringUtils.removeDiacriticalMarks(tramite.getNombreOficial().toLowerCase()).contains(StringUtils.removeDiacriticalMarks(palabraBuscada.toLowerCase()))
			||StringUtils.removeDiacriticalMarks( (tramite.getSinonimoBusqueda() == null ? "" : tramite.getSinonimoBusqueda().toLowerCase()) ).contains(StringUtils.removeDiacriticalMarks(palabraBuscada.toLowerCase()))
			).collect(Collectors.toList());
			
			lstPortalTramitesFiltrada.clear();
			lstPortalTramitesFiltrada.addAll(lstPortalTramitesFiltradaAux);
			totalElementos = lstPortalTramitesFiltrada.size();
		}
	}

    public void deleteItemFiltroDependencia() {
    	List<CatDependenciaDTO> selectedDependenciaAux = new ArrayList<CatDependenciaDTO>();
    	
    	for (CatDependenciaDTO det:lstCatDependenciaDTOView) {
    		for (contadorAux=Constantes.INT_VALOR_CERO; contadorAux<selectedDependencia.length; contadorAux++) {
    			if (det.getIdDependencia().intValue() == selectedDependencia[contadorAux].intValue()) 
    				selectedDependenciaAux.add(new CatDependenciaDTO(det.getIdDependencia().intValue()));
    		}
    	}
    	
    	if (selectedDependenciaAux.size() > 0) {
            selectedDependencia = new Integer[selectedDependenciaAux.size()];
            for (int i=0; i<selectedDependenciaAux.size(); i++) {
                selectedDependencia[i] = selectedDependenciaAux.get(i).getIdDependencia();
            }
    	} else {
    		selectedDependencia = new Integer[Constantes.INT_VALOR_CERO];
    	}
    }

    public void deleteItemFiltroTema() {
    	List<AdminMateriaDTO> selectedCategoriaAux = new ArrayList<AdminMateriaDTO>();

    	for (AdminMateriaDTO det:lstCatMateriaDTOView) {
    		for (contadorAux=Constantes.INT_VALOR_CERO; contadorAux<selectedTema.length; contadorAux++) {
    			if (det.getId().intValue() == selectedTema[contadorAux].intValue())
    				selectedCategoriaAux.add(new AdminMateriaDTO(det.getId()));
    		}
    	}
    	
    	if (selectedCategoriaAux.size() > 0) {
	        selectedTema = new Long[selectedCategoriaAux.size()];
	        for (int i=0; i<selectedCategoriaAux.size(); i++) {
	        	selectedTema[i] = selectedCategoriaAux.get(i).getId();
	        }    		
    	} else {
    		selectedTema = new Long[Constantes.INT_VALOR_CERO];
    	}
    }
	/*	
	public void ordenaCatalogosNew(List<PortalTramitesBusquedaDTO> listadoIn) {
		boolean bndDigital =  false;
		boolean bndTramites = false;
		//listado Categoria
		List<AdminMateriaDTO> listadoCatAux = new ArrayList<AdminMateriaDTO>();
		//listado Autoridad
		List<CatDependenciaDTO> listadoDependenciaAux = new ArrayList<CatDependenciaDTO>();
		//listado Clasificación
		List<CatEsTramiteServicioDTO> lstEsTramiteServicioAux = new ArrayList<CatEsTramiteServicioDTO>();
		
		for(PortalTramitesBusquedaDTO tramite:listadoIn) {
			if (tramite.getIdMateria() != null) {
				Optional<AdminMateriaDTO> optCategoria = lstAllCatMateriaDTO.stream().filter(cat -> cat.getId().intValue() == tramite.getIdMateria().intValue()).findAny();
				if (optCategoria.isPresent()) {
					Optional<AdminMateriaDTO> optAuxCat = listadoCatAux.stream().filter(aux -> aux.getId() == optCategoria.get().getId().intValue()).findAny();
					if (!optAuxCat.isPresent()) {
						listadoCatAux.add(optCategoria.get());
					}
				}
			}
			lstCatMateriaDTOView.clear();
			lstCatMateriaDTOView.addAll(listadoCatAux);

			if (tramite.getIdDependencia() != null) {
				Optional<CatDependenciaDTO> optDependencia = lstAllCatDependenciaDTO.stream().filter(materia -> materia.getIdDependencia().intValue() == tramite.getIdDependencia().intValue()).findAny();
				if (optDependencia.isPresent()) {
					Optional<CatDependenciaDTO> optAuxDep = listadoDependenciaAux.stream().filter(auxDep -> auxDep.getIdDependencia().intValue() == optDependencia.get().getIdDependencia().intValue()).findAny();
					if (!optAuxDep.isPresent()) {
						listadoDependenciaAux.add(optDependencia.get());
					}
				}
			} 
			lstCatDependenciaDTOView.clear();
			lstCatDependenciaDTOView.addAll(listadoDependenciaAux);
		
			if (tramite.getIdEsTramiteServicio() != null 
					&& tramite.getIdEsTramiteServicio().intValue() == Constantes.CLASIFICACION_TRAMITES.intValue() 
					&& (tramite.getPuedeRealizarseDigitalmente() == null || !tramite.getPuedeRealizarseDigitalmente())
					&& !bndTramites) {
				lstEsTramiteServicioAux.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_TRAMITES,Constantes.CLASIFICACION_TRAMITES_DESC));
				bndTramites = true;
			}

			if (tramite.getPuedeRealizarseDigitalmente() != null 
					&& tramite.getPuedeRealizarseDigitalmente().booleanValue() 
					&& !bndDigital 
					&& tramite.getIdEsTramiteServicio().intValue() == Constantes.CLASIFICACION_TRAMITES.intValue()) {
				lstEsTramiteServicioAux.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_TRAMITES_DIGITALES,Constantes.CLASIFICACION_TRAMITES_DIGITALES_DESC));
				bndDigital = true;
			}

		}
		
		lstEsTramiteServicioView.clear();
		lstEsTramiteServicioView.addAll(lstEsTramiteServicioAux);
	}
*/
	public void ordenaCatalogosClasificacion(List<PortalTramitesBusquedaDTO> listadoIn) {
		boolean bndDigital =  false;
		boolean bndTramites = false;
		//listado Clasificación
		List<CatEsTramiteServicioDTO> lstEsTramiteServicioAux = new ArrayList<CatEsTramiteServicioDTO>();
		
		for(PortalTramitesBusquedaDTO tramite:listadoIn) {
			if (tramite.getIdEsTramiteServicio() != null 
					&& tramite.getIdEsTramiteServicio().intValue() == Constantes.CLASIFICACION_TRAMITES.intValue() 
					&& (tramite.getPuedeRealizarseDigitalmente() == null || !tramite.getPuedeRealizarseDigitalmente())
					&& !bndTramites) {
				lstEsTramiteServicioAux.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_TRAMITES,Constantes.CLASIFICACION_TRAMITES_DESC));
				bndTramites = true;
			}

			if (tramite.getIdEsTramiteServicio() != null 
					&& tramite.getIdEsTramiteServicio().intValue() == Constantes.CLASIFICACION_PROGRAMAS_SOCIALES.intValue() 
					&& (tramite.getPuedeRealizarseDigitalmente() == null || !tramite.getPuedeRealizarseDigitalmente())
					&& !bndTramites) {
				lstEsTramiteServicioAux.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_PROGRAMAS_SOCIALES,Constantes.CLASIFICACION_PROGRAMAS_SOCIALES_DESC));
				bndTramites = true;
			}

			if (tramite.getPuedeRealizarseDigitalmente() != null 
					&& tramite.getPuedeRealizarseDigitalmente().booleanValue() 
					&& !bndDigital 
					&& tramite.getIdEsTramiteServicio().intValue() == Constantes.CLASIFICACION_TRAMITES.intValue()) {
				lstEsTramiteServicioAux.add(new CatEsTramiteServicioDTO(Constantes.CLASIFICACION_TRAMITES_DIGITALES,Constantes.CLASIFICACION_TRAMITES_DIGITALES_DESC));
				bndDigital = true;
			}

		}
		
		lstEsTramiteServicioView.clear();
		lstEsTramiteServicioView.addAll(lstEsTramiteServicioAux);
	}

	public void ordenaCatalogosCategoria(List<PortalTramitesBusquedaDTO> listadoIn) {
		//listado Categoria
		List<AdminMateriaDTO> listadoCatAux = new ArrayList<AdminMateriaDTO>();
		for(PortalTramitesBusquedaDTO tramite:listadoIn) {
			if (tramite.getIdMateria() != null) {
				Optional<AdminMateriaDTO> optCategoria = lstAllCatMateriaDTO.stream().filter(cat -> cat.getId().intValue() == tramite.getIdMateria().intValue()).findAny();
				if (optCategoria.isPresent()) {
					Optional<AdminMateriaDTO> optAuxCat = listadoCatAux.stream().filter(aux -> aux.getId() == optCategoria.get().getId().intValue()).findAny();
					if (!optAuxCat.isPresent()) {
						listadoCatAux.add(optCategoria.get());
					}
				}
			}
		}
		lstCatMateriaDTOView.clear();
		lstCatMateriaDTOView.addAll(listadoCatAux);
	}

	public void ordenaCatalogosDependencia(List<PortalTramitesBusquedaDTO> listadoIn) {
		//listado Autoridad
		List<CatDependenciaDTO> listadoDependenciaAux = new ArrayList<CatDependenciaDTO>();
		for(PortalTramitesBusquedaDTO tramite:listadoIn) {
			if (tramite.getIdDependencia() != null) {
				Optional<CatDependenciaDTO> optDependencia = lstAllCatDependenciaDTO.stream().filter(materia -> materia.getIdDependencia().intValue() == tramite.getIdDependencia().intValue()).findAny();
				if (optDependencia.isPresent()) {
					Optional<CatDependenciaDTO> optAuxDep = listadoDependenciaAux.stream().filter(auxDep -> auxDep.getIdDependencia().intValue() == optDependencia.get().getIdDependencia().intValue()).findAny();
					if (!optAuxDep.isPresent()) {
						listadoDependenciaAux.add(optDependencia.get());
					}
				}
			} 
		}		
		lstCatDependenciaDTOView.clear();
		lstCatDependenciaDTOView.addAll(listadoDependenciaAux);
	}

	public void filtroClasificacion() {
		totalElementos = Constantes.INT_VALOR_CERO;
		lstPortalTramitesFiltrada.clear();
		// Filtra trámites, servicios y sitios de interés
		if (optionSelect != null && optionSelect > 0)
			lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO);
		else
			filtraPorPalabra();

		if (selectedClasificacion.length > Constantes.INT_VALOR_CERO)
			filtraListaClasificacion();

		if (mandaCategoria) {
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
			ordenaCatalogosDependencia(lstPortalTramitesFiltrada);			
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
		} else if (mandaDependencia) {
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
			ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
		} else {
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
			ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
			ordenaCatalogosDependencia(lstPortalTramitesFiltrada);			
		}

		lstPortalTramitesFiltrada = ordenaFiltraTramites(lstPortalTramitesFiltrada);
		totalElementos = lstPortalTramitesFiltrada.size();
		PrimeFaces.current().scrollTo("messages");
	}
	
	public void filtraListaClasificacion() {
		lstPortalTramitesFiltradaAux.clear();
		List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltradaTmp = new ArrayList<PortalTramitesBusquedaDTO>();

		for (contadorAux=Constantes.INT_VALOR_CERO; contadorAux<selectedClasificacion.length; contadorAux++) {//filtra trámites
			if (selectedClasificacion[contadorAux].intValue() == Constantes.OPCION_PROGRAMAS) {//Filtra programas sociales digitales y no digitales
				lstPortalTramitesFiltradaAux.addAll(lstPortalTramitesFiltrada.stream().filter(tramite -> tramite.getIdEsTramiteServicio().intValue() == selectedClasificacion[contadorAux].intValue()).collect(Collectors.toList()));
			} else {//filtra trámites no digitales
				lstPortalTramitesFiltradaAux.addAll(lstPortalTramitesFiltrada.stream().filter(tramite -> tramite.getIdEsTramiteServicio().intValue() == selectedClasificacion[contadorAux].intValue() && (tramite.getPuedeRealizarseDigitalmente() == null || tramite.getPuedeRealizarseDigitalmente().booleanValue() == false)).collect(Collectors.toList()));
			}
		}

		for (contadorAux=Constantes.INT_VALOR_CERO; contadorAux<selectedClasificacion.length; contadorAux++) {//filtra por trámites digitales
			if (selectedClasificacion[contadorAux].intValue() == Constantes.CLASIFICACION_TRAMITES_DIGITALES) {
				lstPortalTramitesFiltradaTmp.addAll(lstPortalTramitesFiltrada.stream().filter(tramite -> tramite.getPuedeRealizarseDigitalmente() != null && tramite.getPuedeRealizarseDigitalmente().booleanValue() == true && tramite.getIdEsTramiteServicio().intValue() != Constantes.OPCION_PROGRAMAS).collect(Collectors.toList()));
				lstPortalTramitesFiltradaTmp.forEach(li -> {
					Optional<PortalTramitesBusquedaDTO> optLi = lstPortalTramitesFiltradaAux.stream().filter(ls -> li.getId() != null && ls.getId() != null && li.getId().intValue() == ls.getId().intValue()).findAny();
					if (!optLi.isPresent()) {
						lstPortalTramitesFiltradaAux.add(li);
					}
				});
			}
		}
		
		lstPortalTramitesFiltrada.clear();
		lstPortalTramitesFiltrada.addAll(lstPortalTramitesFiltradaAux);
	}

	public void filtroDependencia() {
		totalElementos = Constantes.INT_VALOR_CERO;
		lstPortalTramitesFiltrada.clear();

		if (optionSelect != null && optionSelect > 0)
			lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO);
		else
			filtraPorPalabra();

		if (lstCatDependenciaDTOView.size() == selectedDependencia.length)
			bndTodoDep = true;
		else
			bndTodoDep = false;

		if (selectedTema.length == 0) {
			mandaDependencia = true;
			mandaCategoria = false;
		}
		
		if (selectedClasificacion.length > Constantes.INT_VALOR_CERO) 
			filtraListaClasificacion();
		
		if (mandaCategoria) {
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO) 
				filtraListaDependencia();
		} else if (mandaDependencia) {
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
			else 
				selectedTema = new Long[Constantes.INT_VALOR_CERO];
			ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				deleteItemFiltroTema();
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
		} else {
			if (selectedTema.length > Constantes.INT_VALOR_CERO)
				filtraListaTema();
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
			ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
			ordenaCatalogosDependencia(lstPortalTramitesFiltrada);
		}
		
		lstPortalTramitesFiltrada = ordenaFiltraTramites(lstPortalTramitesFiltrada);
		totalElementos = lstPortalTramitesFiltrada.size();
		PrimeFaces.current().scrollTo("messages");
	}

	public void filtraListaDependencia() {
		lstPortalTramitesFiltradaAux.clear();
				
		for (contadorAux=Constantes.INT_VALOR_CERO; contadorAux<selectedDependencia.length; contadorAux++) {
			lstPortalTramitesFiltradaAux.addAll(lstPortalTramitesFiltrada.stream().filter(tramite -> tramite.getIdDependencia() != null && tramite.getIdDependencia().intValue() == selectedDependencia[contadorAux].intValue()).collect(Collectors.toList()));			
		}

		lstPortalTramitesFiltrada.clear();
		lstPortalTramitesFiltrada.addAll(lstPortalTramitesFiltradaAux);			
	}

	public void filtroTema() {
		totalElementos = Constantes.INT_VALOR_CERO;
		lstPortalTramitesFiltrada.clear();

		if (optionSelect != null && optionSelect > 0) 
			lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO);
		else
			filtraPorPalabra();
		
		if (lstCatMateriaDTOView.size() == selectedTema.length) 
			bndTodoCategoria = true;
		else
			bndTodoCategoria = false;

		if (selectedDependencia.length == 0) {
			mandaCategoria = true;
			mandaDependencia = false;
		}
		
		if (selectedClasificacion.length > Constantes.INT_VALOR_CERO) 
			filtraListaClasificacion();

		if (mandaCategoria) {
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
			else 
				selectedDependencia = new Integer[Constantes.INT_VALOR_CERO];
			ordenaCatalogosDependencia(lstPortalTramitesFiltrada);
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				deleteItemFiltroDependencia();
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
		} else if (mandaDependencia) {
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
		} else {
			if (selectedTema.length > Constantes.INT_VALOR_CERO) 
				filtraListaTema();
			if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
				filtraListaDependencia();
			ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
			ordenaCatalogosDependencia(lstPortalTramitesFiltrada);			
		}
		
		lstPortalTramitesFiltrada = ordenaFiltraTramites(lstPortalTramitesFiltrada);
		totalElementos = lstPortalTramitesFiltrada.size();
		PrimeFaces.current().scrollTo("messages");
	}

	public void filtraListaTema() {
		lstPortalTramitesFiltradaAux.clear();
		
		for (contadorAux=Constantes.INT_VALOR_CERO; contadorAux<selectedTema.length; contadorAux++) {
			lstPortalTramitesFiltradaAux.addAll(lstPortalTramitesFiltrada.stream().filter(tramite -> 
			tramite.getIdMateria() != null && tramite.getIdMateria().intValue() == selectedTema[contadorAux].intValue()).collect(Collectors.toList()));
		}
		
		lstPortalTramitesFiltrada.clear();
		lstPortalTramitesFiltrada.addAll(lstPortalTramitesFiltradaAux);
	}

	public void todasLasCategorias() {
		int contDepAux = Constantes.INT_VALOR_CERO;
		if (bndTodoCategoria) {
			selectedTema = new Long[lstCatMateriaDTOView.size()];
			for (AdminMateriaDTO datoMat:lstCatMateriaDTOView) {
				selectedTema[contDepAux] = datoMat.getId();
				contDepAux++;
			}
		} else {
			selectedTema = new Long[Constantes.INT_VALOR_CERO];
		}
		filtroTema();
	}

    public void todasLasCategoriasMob() {
        int contDepAux = Constantes.INT_VALOR_CERO;
        if (bndTodoCategoria) {
            selectedTema = new Long[lstCatMateriaDTOView.size()];
            for (AdminMateriaDTO datoMat:lstCatMateriaDTOView) {
                selectedTema[contDepAux] = datoMat.getId();
                contDepAux++;
            }
        } else {
            selectedTema = new Long[Constantes.INT_VALOR_CERO];
        }
    }

	public void todasLasDependencias() {
		int contDepAux = Constantes.INT_VALOR_CERO;
		if (bndTodoDep) {
			selectedDependencia = new Integer[lstCatDependenciaDTOView.size()];
			for (CatDependenciaDTO datoDep:lstCatDependenciaDTOView) {
				selectedDependencia[contDepAux] = datoDep.getIdDependencia();
				contDepAux++;
			}
		} else {
			selectedDependencia = new Integer[Constantes.INT_VALOR_CERO];			
		}
		filtroDependencia();
	}

    public void todasLasDependenciasMob() {
        int contDepAux = Constantes.INT_VALOR_CERO;
        if (bndTodoDep) {
            selectedDependencia = new Integer[lstCatDependenciaDTOView.size()];
            for (CatDependenciaDTO datoDep:lstCatDependenciaDTOView) {
                selectedDependencia[contDepAux] = datoDep.getIdDependencia();
                contDepAux++;
            }
        } else {
            selectedDependencia = new Integer[Constantes.INT_VALOR_CERO];            
        }
    }

    private List<PortalTramitesBusquedaDTO> ordenaFiltraTramites(List<PortalTramitesBusquedaDTO> listadoIn) {
		List<PortalTramitesBusquedaDTO> listado = new ArrayList<>();

		//Agrega contenido manual
		for (PortalTramitesBusquedaDTO lstDato:listadoIn) {
			if (lstDato.getContenidoManual() != null && lstDato.getContenidoManual())
				listado.add(lstDato);
		}

		//Agrega los trámites digitales
		for (PortalTramitesBusquedaDTO lstDato:listadoIn) {
			if (lstDato.getPuedeRealizarseDigitalmente() != null && lstDato.getPuedeRealizarseDigitalmente() && (lstDato.getContenidoManual() == null || (lstDato.getContenidoManual() != null && !lstDato.getContenidoManual())))
				listado.add(lstDato);
		}

		//Se agregan primero lo mas buscado autoadministrable
		lstMasBuscadoDTO.forEach(lmb-> {
			Optional<PortalTramitesBusquedaDTO> optTramite = listadoIn.stream().filter(tramIn-> tramIn.getId() != null && tramIn.getId().intValue() == lmb.getIdTramiteServicio().intValue()).findAny();
			if(optTramite.isPresent()) {
				listado.add(optTramite.get());
			}
		});
		
		// Se agregan los que se encuentren en lo mas buscado cont (lo mas clickeado)
		lstMasBuscadoContDTO.forEach(lmbC-> {
			Optional<PortalTramitesBusquedaDTO> optionalTram = listadoIn.stream().filter(ls -> ls.getId() != null &&  ls.getId().intValue() == lmbC.getIdTramiteServicio().intValue()).findAny();
			if (optionalTram.isPresent()) {
				if (listado.stream().filter(ls -> ls.getId() == optionalTram.get().getId()).findAny().orElse(null) == null) {
					listado.add(optionalTram.get());
				}
			}
		});

		//Agrega los programas sociales no digitales
		for (PortalTramitesBusquedaDTO lstDato:listadoIn) {
			if (lstDato.getProgramaSocial() != null && lstDato.getProgramaSocial() && (lstDato.getPuedeRealizarseDigitalmente() == null || !lstDato.getPuedeRealizarseDigitalmente()))
				listado.add(lstDato);
		}

		
		//Agrega los elementos que faltan sin importar el orden
		for (PortalTramitesBusquedaDTO lstDato:listadoIn) {
			if (lstDato.getId() != null) {
				Optional<PortalTramitesBusquedaDTO> optLi = listado.stream().filter(ls -> ls.getId() != null && ls.getId().intValue() == lstDato.getId().intValue()).findAny();
				if (!optLi.isPresent()) {
					listado.add(lstDato);
				}
			}
		};

		return listado;
	}

	public List<PortalTramitesBusquedaDTO> completeText(String query) {
		palabraBuscada = query.trim();
		do {
			palabraBuscada = palabraBuscada.replaceAll("  ", " ");
		} while (palabraBuscada.indexOf("  ") > 0);
		List<PortalTramitesBusquedaDTO> listado = new ArrayList<>();
		
		listado.addAll(lstPortalTramitesBusquedaDTO.stream().filter(tramite -> 
		StringUtils.removeDiacriticalMarks(tramite.getNombreOficial().toLowerCase()).contains(StringUtils.removeDiacriticalMarks(palabraBuscada.toLowerCase()))
		||StringUtils.removeDiacriticalMarks((tramite.getSinonimoBusqueda() == null ? "" : tramite.getSinonimoBusqueda().toLowerCase()) ).contains(StringUtils.removeDiacriticalMarks(palabraBuscada.toLowerCase()))
		).collect(Collectors.toList()));
				
		return listado;
	}

	public String detalleTramite(PortalTramitesBusquedaDTO tramite, boolean ajax, int idOrigen) throws IOException {
		tramiteSeleccionado = tramite;
		if(tramiteSeleccionado.getId() != null) {
			homeBean.setOrigenUrl(idOrigen);
			//Contador para lo más buscado
			masBuscadoContDAO.actualizarContador(tramiteSeleccionado.getId().intValue());
			
			BitTramiteVistoDTO bitTramiteVistoDTO = new BitTramiteVistoDTO();
			bitTramiteVistoDTO.setCatOrigenConsultaDTO(new CatOrigenConsultaDTO(idOrigen));
			bitTramiteVistoDTO.setIdTramiteServicio(tramiteSeleccionado.getId());
			bitTramiteVistoDTO.setTituloTramite(tramiteSeleccionado.getNombreOficial());
			bitTramiteVistoDAO.guardar(bitTramiteVistoDTO);
			if(ajax) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.RETURN_DETALLE_TRAMITE_PAGE + Constantes.JSF_REDIRECT + "&idTramite=" + tramiteSeleccionado.getId());
				FacesContext.getCurrentInstance().responseComplete();
			}else {
				return Constantes.RETURN_DETALLE_TRAMITE_PAGE + Constantes.JSF_REDIRECT + "&idTramite=" + tramiteSeleccionado.getId();
			}
		}
		return "";
	}

	private void filtraPorClasificacion(Integer categoria) {
//		lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO);

		if (categoria != null) {
			lstPortalTramitesFiltrada.clear();
			lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO.stream().filter(tramite -> tramite.getIdEsTramiteServicio().intValue() == categoria).collect(Collectors.toList()));
			if (categoria == Constantes.OPCION_PROGRAMAS) {
				selectedClasificacion = new Long[1];
				selectedClasificacion[0] = Constantes.CLASIFICACION_PROGRAMAS_SOCIALES;
			} else {
				selectedClasificacion = new Long[2];
				selectedClasificacion[0] = Constantes.CLASIFICACION_TRAMITES;
				selectedClasificacion[1] = Constantes.CLASIFICACION_TRAMITES_DIGITALES;				
			}
		}

		//ordenaCatalogosClasificacion(lstPortalTramitesBusquedaDTO);
		ordenaCatalogosCategoria(lstPortalTramitesFiltrada);
		ordenaCatalogosDependencia(lstPortalTramitesFiltrada);
		mandaDependencia = false;
		mandaCategoria = false;
		lstPortalTramitesFiltrada = ordenaFiltraTramites(lstPortalTramitesFiltrada);
		totalElementos = lstPortalTramitesFiltrada.size();
	}

	public void borraFiltro() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.REDIRECT_BUSCADOR);
			FacesContext.getCurrentInstance().responseComplete();
			
		} catch (IOException e) {
			LOGGER.info("Error al redirigir", e.getMessage());
		}
	}

	public void goHome() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.RETURN_HOME_PAGE);
			FacesContext.getCurrentInstance().responseComplete();
		} catch (IOException e) {
			LOGGER.error("Error al redirigir", e.getMessage());
		}
	}

    public void filtroBusqueda() {
        totalElementos = Constantes.INT_VALOR_CERO;
        lstPortalTramitesFiltrada.clear();
        // Filtra trámites, servicios y sitios de interés
        if (optionSelect != null && optionSelect > 0)
            lstPortalTramitesFiltrada.addAll(lstPortalTramitesBusquedaDTO);
        else
            filtraPorPalabra();

        if (selectedClasificacion.length > Constantes.INT_VALOR_CERO)
            filtraListaClasificacion();
        if (selectedTema.length > Constantes.INT_VALOR_CERO) 
            filtraListaTema();
        if (selectedDependencia.length > Constantes.INT_VALOR_CERO)
            filtraListaDependencia();

        lstPortalTramitesFiltrada = ordenaFiltraTramites(lstPortalTramitesFiltrada);
        totalElementos = lstPortalTramitesFiltrada.size();
        PrimeFaces.current().scrollTo("messages");
    }
	

	public void pageChanged() {
		PrimeFaces.current().scrollTo("messages");		
	}
	
	public List<PortalTramitesBusquedaDTO> getLstPortalTramitesBusquedaDTO() {
		return lstPortalTramitesBusquedaDTO;
	}

	public void setLstPortalTramitesBusquedaDTO(List<PortalTramitesBusquedaDTO> lstPortalTramitesBusquedaDTO) {
		this.lstPortalTramitesBusquedaDTO = lstPortalTramitesBusquedaDTO;
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

	public List<DetLoMasBuscadoDTO> getLstMasBuscadoDTO() {
		return lstMasBuscadoDTO;
	}

	public void setLstMasBuscadoDTO(List<DetLoMasBuscadoDTO> lstMasBuscadoDTO) {
		this.lstMasBuscadoDTO = lstMasBuscadoDTO;
	}

	public Integer getOptionSelect() {
		return optionSelect;
	}

	public void setOptionSelect(Integer optionSelect) {
		this.optionSelect = optionSelect;
	}

	public String getUrlLlave() {
		return Environment.getUrlHomeRedirectLlave();
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

	public List<PortalTramitesBusquedaDTO> getLstPortalTramitesFiltradaMovil() {
		return lstPortalTramitesFiltradaMovil;
	}

	public void setLstPortalTramitesFiltradaMovil(List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltradaMovil) {
		this.lstPortalTramitesFiltradaMovil = lstPortalTramitesFiltradaMovil;
	}

	public List<DetEnlaceDTO> getListDetEnlace() {
		return listDetEnlace;
	}

	public void setListDetEnlace(List<DetEnlaceDTO> listDetEnlace) {
		this.listDetEnlace = listDetEnlace;
	}

	public List<CatDependenciaDTO> getLstAllCatDependenciaDTO() {
		return lstAllCatDependenciaDTO;
	}


	public void setLstAllCatDependenciaDTO(List<CatDependenciaDTO> lstAllCatDependenciaDTO) {
		this.lstAllCatDependenciaDTO = lstAllCatDependenciaDTO;
	}


	public List<AdminMateriaDTO> getLstAllCatMateriaDTO() {
		return lstAllCatMateriaDTO;
	}


	public void setLstAllCatMateriaDTO(List<AdminMateriaDTO> lstAllCatMateriaDTO) {
		this.lstAllCatMateriaDTO = lstAllCatMateriaDTO;
	}


	public Long[] getSelectedClasificacion() {
		return selectedClasificacion;
	}


	public void setSelectedClasificacion(Long[] selectedClasificacion) {
		this.selectedClasificacion = selectedClasificacion;
	}


	public Integer[] getSelectedDependencia() {
		return selectedDependencia;
	}

	public void setSelectedDependencia(Integer[] selectedDependencia) {
		this.selectedDependencia = selectedDependencia;
	}

	public Long[] getSelectedTema() {
		return selectedTema;
	}

	public void setSelectedTema(Long[] selectedTema) {
		this.selectedTema = selectedTema;
	}	
	
	public List<PortalTramitesBusquedaDTO> getLstPortalTramitesFiltradaAux() {
		return lstPortalTramitesFiltradaAux;
	}

	public void setLstPortalTramitesFiltradaAux(List<PortalTramitesBusquedaDTO> lstPortalTramitesFiltradaAux) {
		this.lstPortalTramitesFiltradaAux = lstPortalTramitesFiltradaAux;
	}

	public int getContadorAux() {
		return contadorAux;
	}

	public void setContadorAux(int contadorAux) {
		this.contadorAux = contadorAux;
	}

	public List<CatEsTramiteServicioDTO> getLstAllEsTramiteServicio() {
		return lstAllEsTramiteServicio;
	}

	public void setLstAllEsTramiteServicio(List<CatEsTramiteServicioDTO> lstAllEsTramiteServicio) {
		this.lstAllEsTramiteServicio = lstAllEsTramiteServicio;
	}

	public List<ContenidoManualDTO> getLstContenidoManualDTO() {
		return lstContenidoManualDTO;
	}

	public void setLstContenidoManualDTO(List<ContenidoManualDTO> lstContenidoManualDTO) {
		this.lstContenidoManualDTO = lstContenidoManualDTO;
	}

	public List<CatEsTramiteServicioDTO> getLstEsTramiteServicioView() {
		return lstEsTramiteServicioView;
	}

	public void setLstEsTramiteServicioView(List<CatEsTramiteServicioDTO> lstEsTramiteServicioView) {
		this.lstEsTramiteServicioView = lstEsTramiteServicioView;
	}

	public List<AdminMateriaDTO> getLstCatMateriaDTOView() {
		return lstCatMateriaDTOView;
	}

	public void setLstCatMateriaDTOView(List<AdminMateriaDTO> lstCatMateriaDTOView) {
		this.lstCatMateriaDTOView = lstCatMateriaDTOView;
	}

	public List<CatDependenciaDTO> getLstCatDependenciaDTOView() {
		return lstCatDependenciaDTOView;
	}

	public void setLstCatDependenciaDTOView(List<CatDependenciaDTO> lstCatDependenciaDTOView) {
		this.lstCatDependenciaDTOView = lstCatDependenciaDTOView;
	}

	public Boolean getBndTodoCategoria() {
		return bndTodoCategoria;
	}

	public void setBndTodoCategoria(Boolean bndTodoCategoria) {
		this.bndTodoCategoria = bndTodoCategoria;
	}

	public Long getIdTemaSelected() {
		return idTemaSelected;
	}

	public void setIdTemaSelected(Long idTemaSelected) {
		this.idTemaSelected = idTemaSelected;
	}

	public Boolean getBndTodoDep() {
		return bndTodoDep;
	}

	public void setBndTodoDep(Boolean bndTodoDep) {
		this.bndTodoDep = bndTodoDep;
	}

	public List<ProgramasSocialesDTO> getLstProgramasSocialesDTO() {
		return lstProgramasSocialesDTO;
	}

	public void setLstProgramasSocialesDTO(List<ProgramasSocialesDTO> lstProgramasSocialesDTO) {
		this.lstProgramasSocialesDTO = lstProgramasSocialesDTO;
	}

	public List<DetUrlRegistradoDTO> getLstUrl() {
		return lstUrl;
	}

	public void setLstUrl(List<DetUrlRegistradoDTO> lstUrl) {
		this.lstUrl = lstUrl;
	}

	public Boolean getMandaDependencia() {
		return mandaDependencia;
	}

	public void setMandaDependencia(Boolean mandaDependencia) {
		this.mandaDependencia = mandaDependencia;
	}

	public Boolean getMandaCategoria() {
		return mandaCategoria;
	}

	public void setMandaCategoria(Boolean mandaCategoria) {
		this.mandaCategoria = mandaCategoria;
	}	

}
