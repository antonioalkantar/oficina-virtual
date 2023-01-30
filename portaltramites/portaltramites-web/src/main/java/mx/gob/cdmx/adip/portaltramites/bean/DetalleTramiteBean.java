package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.primefaces.PrimeFaces;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.catalogos.dao.*;
import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.dto.*;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.dao.*;
import mx.gob.cdmx.adip.portaltramites.dto.*;
import mx.gob.cdmx.adip.portaltramites.restful.ReverseGeocodingMaps;

@Named("detalleTramiteBean")
@ViewScoped
public class DetalleTramiteBean  implements Serializable {

	private static final Logger LOGGER = LoggerFactory.getLogger(DetalleTramiteBean.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 4413706003474934670L;
	@Inject
	private DetalleTramiteServicioDAO detalleTramiteServicioDAO;
	@Inject
	private ModalidadesTramiteServicioDAO modalidadesTramiteServicioDAO;
	@Inject
	private DetDocumentosTramiteDAO docsTramiteDAO;
	@Inject
	private DetPasosRegistradoDAO pasosRegistrados;
	@Inject
	private DetLugaresRegistradosDAO lugaresRegistrados;
	@Inject
	private DetTelefonosRegistradosDAO telefonosRegistrados;
	@Inject
	private DetUrlRegistradaDAO urlRegistro;
	@Inject
	private CatAreaAcDAO catCentrosAtencion;
	@Inject
	private PortalTramitesBusquedaDAO portalTramitesBusquedaDAO;
	@Inject
	private MasBuscadoContDAO masBuscadoContDAO;
	@Inject
	private BitTramiteVistoDAO bitTramiteVistoDAO;
	@Inject
	private DetArchivosFormatoTramiteDAO detArchivosFormatoTramiteDAO;
	@Inject
	private DetArchivosFormatoModalidadDAO detArchivosFormatoModalidadDAO;
	@Inject
	private DetArchivosAdjuntosModalidadDAO detArchivosAdjuntosModalidadDAO;
	@Inject
	private DetArchivosAdjuntosTramiteDAO detArchivosAdjuntosTramiteDAO;
	@Inject
	private DetFechaPublicacionDAO detFechaPublicacionDAO;
	@Inject
	private DetRequisitosFormatoDAO detRequisitosFormatoDAO;
	@Inject
	private DetRequisitosModalidadDAO detRequisitosModalidadDAO;
	@Inject
	private DetConceptosCostoDAO detConceptosCostoDAO;
	@Inject
	private DetConcCostosModalDAO detConcCostosModalDAO;
	@Inject
	private DetMedioBancoDAO detMedioBancoDAO;
	@Inject
	private DetMedioDependenciaDAO detMedioDependenciaDAO;
	@Inject
	private DetMedioOficinaDAO detMedioOficinaDAO;
	@Inject
	private DetMedioOnlineDAO detMedioOnlineDAO;
	@Inject
	private DetMedioOtroDAO detMedioOtroDAO;
	@Inject
	private DetMedioTiendaDAO detMedioTiendaDAO;
	@Inject
	private CrcTramiteFundamentoDAO fundamentoDAO;
	@Inject
	private DetTelefonoRegistradoDAO detTelefonoRegistradoDAO;
	
	@Inject
	private HomeBean homebean;

	private String doctosOficiales;
	private String doctosRepLegal;
	int cont;
	private MapModel simpleModel;
	private Marker marker;
	private Long idModalidadSeleccionada;
	private DetalleTramiteServicioDTO detalleTramiteServicioDTO;
	private ModalidadesTramiteServicioDTO modalidadesTramiteServicioDTO;
	private PortalTramitesBusquedaDTO tramiteSeleccionado;
	private List<DetDocumentosTramiteDTO> lstDocsTramIdenOfical;
	private List<DetDocumentosTramiteDTO> lstDocsTramRepresentante;
	private List<DetDocumentosTramiteDTO> lstDocsTramCompDomicilio;
	private List<CatUnidadesAdministrativaDTO> listUnidadesAdm;
	private List<CatTipoVialidadDTO> listTipoVialidad;
	private List<ModalidadesTramiteServicioDTO> listModalidadesTramiteServicioDTO;
	private List<DetArchivosFormatoTramiteDTO> lstFormatosDTO;
	private List<DetArchivosFormatoModalidadDTO> lstFormatosModalidadDTO;
	private List<DetArchivosAdjuntosTramiteDTO> lstArchivosTramiteDTO;
	private List<DetArchivosAdjuntosModalidadDTO> lstArchivosModalidadDTO;
	private List<DetRequisitosFormatoDTO> lstReqEspFormatoDTO;
	private List<DetRequisitosModalidadDTO> lstReqEspFormatoModalidadDTO;
	private List<DetConceptosCostoDTO> lstConceptoCostoDTO;
	private List<DetConcCostosModalDTO> lstConceptoModalidadDTO;	
	private List<DetPasosRegistradoDTO> pasos;
	private List<DetPasosRegistradoDTO> pasosTel;
	private List<DetPasosRegistradoDTO> pasosDig;
	private List<DetLugaresRegistradosDTO> lugares;
	private List<DetTelefonosRegistradosDTO> telefonos;
	private List<DetMedioBancoDTO> lstDetMedioBanco;
	private List<DetMedioDependenciaDTO> lstDetMedioDependencia;
	private List<DetMedioOficinaDTO> lstDetMedioOficina;
	private List<DetMedioOnlineDTO> lstDetMedioOnline;
	private List<DetMedioOtroDTO> lstDetMedioOtro;
	private List<DetMedioTiendaDTO> lstDetMedioTienda;
	private List<DetUrlRegistradoDTO> urls;
	private List<CatAreaAcDTO> lstcentroAt;
	private List<CatAreaAcDTO> lstcentHorarios;
	private List<CrcTramiteFundamentoDTO> lstTramiteFundamento;
	private DetFechaPublicacionDTO fechaPublicacion;
	private List<SelectItem> lstAlcaldia;
	private Integer id_alcaldia;
	private List<CatAreaAcDTO> listadoAlcaldiaAux;
	private Boolean tieneCosto;

	private CatAreaAcDTO centroAt;
	
	private int indiceRequisitos;
	
	private ReverseGeocodingMaps reverseGeocode;
	
	private StreamedContent file;
	private String estiloBuscador;
	private String estiloCiudad;
	private boolean verBuscador;
	private boolean verIndicadores;
	private int menuIndicador = Constantes.MENU_INDICADORES;
	private int menuBuscador = Constantes.MENU_BUSCADOR;
	
	@PostConstruct
	public void init() {
		file = null;
		Long idTramite = buscarIdTramiteURL();
		reverseGeocode= new ReverseGeocodingMaps();
		verBuscador = false;
		estiloBuscador = "adip-circle-gold";
		verIndicadores = false;
		estiloCiudad = "adip-ciudad-hoy";
		if (idTramite != null) {

			tramiteSeleccionado = portalTramitesBusquedaDAO.buscarPorIdTramite(idTramite);

			if (tramiteSeleccionado != null) {
				inicializar(tramiteSeleccionado);
				
				masBuscadoContDAO.actualizarContador(idTramite.intValue());
				
				BitTramiteVistoDTO bitTramiteVistoDTO = new BitTramiteVistoDTO();
				bitTramiteVistoDTO.setCatOrigenConsultaDTO(new CatOrigenConsultaDTO(CatOrigenConsultaDTO.ID_ORIGEN_URL_DIRECTA));
				bitTramiteVistoDTO.setIdTramiteServicio(tramiteSeleccionado.getId());
				bitTramiteVistoDTO.setTituloTramite(tramiteSeleccionado.getNombreOficial());
				bitTramiteVistoDAO.guardar(bitTramiteVistoDTO);
				
				indiceRequisitos = asignaIndiceRequisitos();
				if(idModalidadSeleccionada != null) {
					getModalidades();
				}
				if(homebean.getOrigenUrl() == 0) {
					homebean.setOrigenUrl(CatOrigenConsultaDTO.ID_ORIGEN_URL_DIRECTA);
				}
			} else {
				redirecHome();
			}
		} else {
			redirecHome();
		}
	}

    public void inicializar(PortalTramitesBusquedaDTO tramiteSeleccionado) {
    	this.tramiteSeleccionado = tramiteSeleccionado;
    	reverseGeocode= new ReverseGeocodingMaps();
		doctosOficiales = "";
		doctosRepLegal = "";
		tieneCosto = false;
    	detalleTramiteServicioDTO = new DetalleTramiteServicioDTO();
    	modalidadesTramiteServicioDTO = new ModalidadesTramiteServicioDTO();
    	listModalidadesTramiteServicioDTO = new ArrayList<ModalidadesTramiteServicioDTO>();
    	lstDocsTramIdenOfical = new ArrayList<DetDocumentosTramiteDTO>();
    	lstFormatosModalidadDTO = new ArrayList<DetArchivosFormatoModalidadDTO>();
    	lstFormatosDTO = new ArrayList<DetArchivosFormatoTramiteDTO>();
    	lstArchivosTramiteDTO = new ArrayList<DetArchivosAdjuntosTramiteDTO>();
    	lstArchivosModalidadDTO = new ArrayList<DetArchivosAdjuntosModalidadDTO>();
    	lstReqEspFormatoDTO = new ArrayList<DetRequisitosFormatoDTO>();
    	lstReqEspFormatoModalidadDTO = new ArrayList<DetRequisitosModalidadDTO>();
    	lstConceptoCostoDTO = new ArrayList<DetConceptosCostoDTO>();
    	lstConceptoModalidadDTO = new ArrayList<DetConcCostosModalDTO>();
    	lstDetMedioBanco = new ArrayList<DetMedioBancoDTO>();
    	lstDetMedioDependencia= new ArrayList<DetMedioDependenciaDTO>();
    	lstDetMedioOficina= new ArrayList<DetMedioOficinaDTO>();
    	lstDetMedioOnline = new ArrayList<DetMedioOnlineDTO>();
    	lstDetMedioOtro = new ArrayList<DetMedioOtroDTO>();
    	lstDetMedioTienda = new ArrayList<DetMedioTiendaDTO>();
    	lstTramiteFundamento = new ArrayList<CrcTramiteFundamentoDTO>();
    	pasos = new ArrayList<DetPasosRegistradoDTO>();
    	pasosTel = new ArrayList<DetPasosRegistradoDTO>();
    	pasosDig = new ArrayList<DetPasosRegistradoDTO>();
    	lugares = new ArrayList<DetLugaresRegistradosDTO>();
    	telefonos = new ArrayList<DetTelefonosRegistradosDTO>();
    	urls = new ArrayList<DetUrlRegistradoDTO>();
    	lstcentroAt = new ArrayList<CatAreaAcDTO>();
    	lstcentHorarios = new ArrayList<CatAreaAcDTO>();
    	centroAt = new CatAreaAcDTO();
    	fechaPublicacion = new DetFechaPublicacionDTO();
    	lstAlcaldia = new ArrayList<>();
    	fechaPublicacion = detFechaPublicacionDAO.buscarPorIdTramite(this.tramiteSeleccionado.getId());

    	detalleTramiteServicioDTO = detalleTramiteServicioDAO.buscarPorId(tramiteSeleccionado.getId());
    	
    	if(detalleTramiteServicioDTO.getIdCosto() != null) {
	    	lstDetMedioBanco = detMedioBancoDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
	    	lstDetMedioDependencia = detMedioDependenciaDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
	    	lstDetMedioOficina = detMedioOficinaDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
	    	lstDetMedioOnline = detMedioOnlineDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
	    	lstDetMedioOtro = detMedioOtroDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
	    	lstDetMedioTienda = detMedioTiendaDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
    	}
    	
    	if (tramiteSeleccionado.getTieneModalidades() != null && tramiteSeleccionado.getTieneModalidades()) {
    		listModalidadesTramiteServicioDTO = modalidadesTramiteServicioDAO.buscarPorId(tramiteSeleccionado.getId());
    	} else {
        	if (detalleTramiteServicioDTO.getMedianteFormato() != null && detalleTramiteServicioDTO.getMedianteFormato()) {
        		lstFormatosDTO = detArchivosFormatoTramiteDAO.buscarPorCriterios(detalleTramiteServicioDTO.getIdFormato());
        		lstArchivosTramiteDTO = detArchivosAdjuntosTramiteDAO.buscarPorCriterios(detalleTramiteServicioDTO.getIdFormato());
        	}

        	lstReqEspFormatoDTO = detRequisitosFormatoDAO.buscarPorIdFormato(detalleTramiteServicioDTO.getIdFormato());

        	
        	lstConceptoCostoDTO = detConceptosCostoDAO.buscarPorIdCosto(detalleTramiteServicioDTO.getIdCosto());
        	if (lstConceptoCostoDTO.size() > 0) {
        		tieneCosto = true;
        	} else {
        		tieneCosto = false;
        	}
    	}
    	lstDocsTramIdenOfical = docsTramiteDAO.buscarPorIdTramiteAndIdTipo(tramiteSeleccionado.getId(), 1L);

		lstDocsTramRepresentante = docsTramiteDAO.buscarPorIdTramiteAndIdTipo(tramiteSeleccionado.getId(), 2L);

		lstDocsTramCompDomicilio = docsTramiteDAO.buscarPorIdTramiteAndIdTipo(tramiteSeleccionado.getId(), 3L);

		//APARTADO PRESENCIAL
		if (tramiteSeleccionado.getPuedeRealizarsePresencialmente()) {
			pasos =  pasosRegistrados.buscarPorCanalTipoSolicitud(tramiteSeleccionado.getIdCanalAtencion(), 1L);
			lugares = lugaresRegistrados.buscarPorCanal(tramiteSeleccionado.getIdCanalAtencion());
			
			List<CatAreaAcDTO> lstAtTmp;
			List<CatAreaAcDTO> lstHorariosTmp;
			List<DetTelefonoRegistradoDTO> lstTel;
			for (DetLugaresRegistradosDTO lst:lugares) {
				lstAtTmp = new ArrayList<CatAreaAcDTO>();
				lstAtTmp = catCentrosAtencion.buscarPorIdArea(lst.getCatAreaAc().getId());
				for (CatAreaAcDTO lstAtTemp:lstAtTmp) {
					lstHorariosTmp = new ArrayList<CatAreaAcDTO>();
					lstHorariosTmp = catCentrosAtencion.busqHorarios(lst.getCatAreaAc().getId());
					lstTel = detTelefonoRegistradoDAO.buscarPoridArea(lst.getCatAreaAc().getId());
//					for (CatAreaAcDTO lstHorariosTemp:lstHorariosTmp) {
//						lstAtTemp.setDetHorarioRegistrados(lstHorariosTemp.getDetHorarioRegistrados());
//					}
					lstAtTemp.setDetHorarioRegistrados(new ArrayList<>());
					for (CatAreaAcDTO lstHorariosTemp : lstHorariosTmp) {
						Optional<DetHorarioRegistradoDTO> optHorario = lstHorariosTemp.getDetHorarioRegistrados()
								.stream()
								.filter(horario -> horario.getAtiendeLunes() || horario.getAtiendeMartes()
										|| horario.getAtiendeMiercoles() || horario.getAtiendeJueves()
										|| horario.getAtiendeViernes() || horario.getAtiendeSabado()
										|| horario.getAtiendeDomingo())
								.findAny();
						if (optHorario.isPresent()) {
							//Horario dividido
							if (optHorario.get().getCatTipoHorario().getId().intValue() == 2) {
								lstAtTemp.getDetHorarioRegistrados().add(optHorario.get());
							} else {
								Optional<DetHorarioRegistradoDTO> optHorarioTmp = lstAtTemp.getDetHorarioRegistrados()
										.stream()
										.filter(h -> (h.getAtiendeLunes() && optHorario.get().getAtiendeLunes())
												|| (h.getAtiendeMartes() && optHorario.get().getAtiendeMartes())
												|| (h.getAtiendeMiercoles() && optHorario.get().getAtiendeMiercoles())
												|| (h.getAtiendeJueves() && optHorario.get().getAtiendeJueves())
												|| (h.getAtiendeViernes() && optHorario.get().getAtiendeViernes())
												|| (h.getAtiendeSabado() && optHorario.get().getAtiendeSabado())
												|| (h.getAtiendeDomingo() && optHorario.get().getAtiendeDomingo()))
										.findAny();
								if (!optHorarioTmp.isPresent()) {
									lstAtTemp.getDetHorarioRegistrados().add(optHorario.get());
								}
							}

						}
					}
					lstAtTemp.setDireccion("Calle " + lstAtTemp.getCalle() + " No. " + lstAtTemp.getNumExterior() + ", Col. " + lstAtTemp.getCatAsentamiento().getDescripcion() + " Alcaldía " + lstAtTemp.getCatAlcaldia().getMunicipio() + ", código postal " + lstAtTemp.getCatCodigosPostale().getCodigoPostal());
					lstAtTemp.setDetTelefonoRegistrados(new ArrayList<DetTelefonoRegistradoDTO>(lstTel));
                    lstcentroAt.add(lstAtTemp);
                    Optional<SelectItem> optAlc = lstAlcaldia.stream().filter(alcaldia-> alcaldia.getValue().equals(lstAtTemp.getCatAlcaldia().getIdAlcaldia())).findAny();
                    if(!optAlc.isPresent()) {
						lstAlcaldia.add(new SelectItem(lstAtTemp.getCatAlcaldia().getIdAlcaldia(),lstAtTemp.getCatAlcaldia().getMunicipio()));
					}
					
				}				
			}
		}
		
		asignarMarcadores();
		
		//APARTADO TELEFONICO
		if (tramiteSeleccionado.getPuedeRealizarseTelefonicamente()) {
			pasosTel =  pasosRegistrados.buscarPorCanalTipoSolicitud(tramiteSeleccionado.getIdCanalAtencion(), 2L);
			telefonos = telefonosRegistrados.buscarPorCanal(tramiteSeleccionado.getIdCanalAtencion());
		}
		//APARTADO DIGITAL
		if (tramiteSeleccionado.getPuedeRealizarseDigitalmente()) {
			pasosDig =  pasosRegistrados.buscarPorCanalTipoSolicitud(tramiteSeleccionado.getIdCanalAtencion(), 3L);
			urls = urlRegistro.buscarPorCanal(tramiteSeleccionado.getIdCanalAtencion());
		}
		
		//APARTADO FUNDAMENTO JURIDICO
		lstTramiteFundamento = fundamentoDAO.buscarPorIdTramite(tramiteSeleccionado.getId());

//    	return Constantes.RETURN_DETALLE_TRAMITE_PAGE + Constantes.JSF_REDIRECT+tramiteSeleccionado.getId();
    }
    
	public void asignarMarcadores() {
		if(lstcentroAt != null && !lstcentroAt.isEmpty()) {
			simpleModel = new DefaultMapModel();
			for(CatAreaAcDTO modulo:lstcentroAt) {
				if(modulo.getLatitud() != null && modulo.getLongitud() != null && !modulo.getLatitud().isEmpty() && !modulo.getLongitud().isEmpty()) {
					LatLng latLong;
					try {
						latLong = new LatLng(
								Double.valueOf(modulo.getLatitud().contains(",") ? modulo.getLatitud().replace(",", "")
										: modulo.getLatitud()),
								Double.valueOf(
										modulo.getLongitud().contains(",") ? modulo.getLongitud().replace(",", "")
												: modulo.getLongitud()));
					} catch (Exception e) {
						LOGGER.error("No es posible castear alguno de los valores: lat" + modulo.getLatitud() + "long "
								+ modulo.getLongitud() + " ", e);
						latLong = new LatLng(0, 0);
					}
					simpleModel.addOverlay(new Marker(latLong, modulo.getNombreAac(), modulo.getDireccion()));
				}
			}
		}
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
		for (CatAreaAcDTO modulo : lstcentroAt) {
			LatLng latLong;
			try {
				latLong = new LatLng(Double.valueOf(modulo.getLatitud()), Double.valueOf(modulo.getLongitud()));
			} catch (Exception e) {
				LOGGER.error("No es posible castear alguno de los valores: lat" + modulo.getLatitud() + "long "
						+ modulo.getLongitud() + " ", e);
				latLong = new LatLng(0, 0);
			}
		}
	}

	public void getModalidades() {
		if (idModalidadSeleccionada != null) {
			// LOGGER.info("idModalidadSeleccionada " + idModalidadSeleccionada);
			// Cuando el tramite se replica medianteformato se toma el id de la modalidad de
			// la cual serán replicados los formatos
			Optional<ModalidadesTramiteServicioDTO> optMod = listModalidadesTramiteServicioDTO.stream()
					.filter(mod -> mod.getIdModalidad().intValue() == idModalidadSeleccionada.intValue()
							&& mod.isMedianteFormato())
					.findAny();
			if (optMod.isPresent()) {
				Optional<ModalidadesTramiteServicioDTO> optModalidad = listModalidadesTramiteServicioDTO.stream()
						.filter(modalidad -> modalidad.isReplicaMedianteFormato()).findAny();

				lstFormatosModalidadDTO = detArchivosFormatoModalidadDAO
						.buscarPorIdModalidad(tramiteSeleccionado.getId(), idModalidadSeleccionada);
				lstArchivosModalidadDTO = detArchivosAdjuntosModalidadDAO.buscarPorIdModalidad(
						optModalidad.isPresent() ? optModalidad.get().getIdModalidad() : idModalidadSeleccionada);

			}

			lstReqEspFormatoModalidadDTO = detRequisitosModalidadDAO.buscarPorIdModalidad(tramiteSeleccionado.getId(),
					idModalidadSeleccionada);
			lstConceptoModalidadDTO = detConcCostosModalDAO.buscarPorIdModalidad(idModalidadSeleccionada);

			if (lstConceptoModalidadDTO.size() > 0) {
				tieneCosto = true;
			} else {
				tieneCosto = false;
			}

			for (ModalidadesTramiteServicioDTO lstMod : listModalidadesTramiteServicioDTO) {
				if (lstMod.getIdModalidad().compareTo(idModalidadSeleccionada) == 0) {
					modalidadesTramiteServicioDTO = lstMod;
				}
			}
		} else {
			tieneCosto = false;
			lstFormatosModalidadDTO = new ArrayList<DetArchivosFormatoModalidadDTO>();
			lstArchivosModalidadDTO = new ArrayList<DetArchivosAdjuntosModalidadDTO>();
			lstReqEspFormatoModalidadDTO = new ArrayList<DetRequisitosModalidadDTO>();
			modalidadesTramiteServicioDTO = new ModalidadesTramiteServicioDTO();
			lstConceptoModalidadDTO = new ArrayList<DetConcCostosModalDTO>();
		}
	}

	public Long buscarIdTramiteURL() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idTramite = params.get("idTramite");
		String idModalidad = params.get("idModalidad");
		Long idTramiteL;
		try {
			idTramiteL = Long.valueOf(idTramite);
			if(idModalidad != null) {
				idModalidadSeleccionada = obtenerIdModalidad(idModalidad);
			}
		} catch (NumberFormatException e) {
//			LOGGER.error("Error al parsear idTramite",e);
			return null;
		}
		return idTramiteL;
	}

	public Long obtenerIdModalidad(String idModalidad) {
		try{
			if(idModalidad != null) {
				idModalidadSeleccionada = Long.valueOf(idModalidad);
				}
		}catch(NumberFormatException e) {
			LOGGER.error("Error al parsear idModalidad",e);
			return null;
		}
		return idModalidadSeleccionada;
	}
	
	
	/**
	 * TODO cambiar por URL's dinámicas acorde a ambiente DEV o PROD
	 * @return
	 */
	public String getRedirectFacebook() {
		String urlFacebook = "";
		if(tramiteSeleccionado != null) {
			if(idModalidadSeleccionada != null) {
				urlFacebook = "https://www.facebook.com/sharer/sharer.php?u="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId()+"%26"+"idModalidad%3D"+idModalidadSeleccionada;
			}else {
				urlFacebook = "https://www.facebook.com/sharer/sharer.php?u="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId();
			}
		}
		return urlFacebook;
	}
	
	public String getRedirectTwitter() {
		String urlTwitter = "";
		if(tramiteSeleccionado != null) {
			if(idModalidadSeleccionada != null) {
				urlTwitter = "https://twitter.com/share?url="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId()+"%26"+"idModalidad%3D"+idModalidadSeleccionada+"&text=portal-cdmx-tramites";
				}else {
					urlTwitter = "https://twitter.com/share?url="
							+ "https%3A%2F%2F"+Environment.getUrlPortal()
							+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId()+"&text=portal-cdmx-tramites";
				}
		}
		return urlTwitter;
	}
	
	public String getRedirectWhatsapp() {
		String urlWhatsapp = "";
		if(tramiteSeleccionado != null) {
			if(idModalidadSeleccionada != null) {
				urlWhatsapp =  "whatsapp://send?text="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId()+"%26"+"idModalidad%3D"+idModalidadSeleccionada;
			}else {
				urlWhatsapp =  "whatsapp://send?text="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId();
			}
		}
		return urlWhatsapp;
	}
	public String getRedirectWhatsappDesc() {
		String urlWhatsapp = "";
		if(tramiteSeleccionado != null) {
			if(idModalidadSeleccionada != null) {
				urlWhatsapp =  "https://web.whatsapp.com/send?text="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId()+"%26"+"idModalidad%3D"+idModalidadSeleccionada;
			}else {
				urlWhatsapp =  "https://web.whatsapp.com:/send?text="
						+ "https%3A%2F%2F"+Environment.getUrlPortal()
						+ "%2Fpublic%2FInformacionTramite.xhtml%3FidTramite%3D"+tramiteSeleccionado.getId();
			}
		}
		return urlWhatsapp;
	}
	
	/*
	 *Método para obtener las áreas de atención
	 */
	public void getListCentrosAc() {
		listadoAlcaldiaAux  = new ArrayList<>();
		//LOGGER.info("el Id de la alcaldia "+id_alcaldia);
		listadoAlcaldiaAux = lstcentroAt.stream().filter(centro -> centro.getCatAlcaldia() != null ?centro.getCatAlcaldia().getIdAlcaldia() == id_alcaldia:false ).collect(Collectors.toList());
	
		/*--Se sobreescribe la dirección respecto a latitud y longitud(actualmente desactivado)
		int i = 0;
		for(CatAreaAcDTO dto : listadoAlcaldiaAux) {
			GeocoderReverseMapsDTO geocode = reverseGeocode.obtenDireccion(dto.getLatitud().contains(",") ?dto.getLatitud().replace(",", "") :dto.getLatitud(),dto.getLongitud().contains(",") ? dto.getLongitud().replace(",", ""): dto.getLongitud());
			if(geocode.getCodeStatus() == 200) {
				listadoAlcaldiaAux.get(i).setDireccion(geocode.getDireccion());
				LOGGER.info(listadoAlcaldiaAux.get(i).getDireccion());
				LOGGER.info(geocode.getDireccion());
			}
			i++;
		}
		*/
	}
	
	public String getUrlGoogleMaps() {
		
		return "https://maps.googleapis.com/maps/api/js?key=" + Environment.getApiKeyGoogleMaps() + ""; //&amp;callback=initMap
	}
	
	
	public void download(String nameDocument) {
		file = null;
		String ruta = Environment.getPathDocumentosUsuarios() + tramiteSeleccionado.getId() + Constantes.SEPARADOR_RUTA
				+ nameDocument;
//		LOGGER.info(ruta);

		File tmpFile = new File(Environment.getPathDocumentosUsuarios() + tramiteSeleccionado.getId()
				+ Constantes.SEPARADOR_RUTA + nameDocument);

		if (!tmpFile.canRead() || !tmpFile.isFile() || !tmpFile.exists() || tmpFile.isDirectory()) {
			LOGGER.error("El archivo " + nameDocument + "con ruta " + ruta + " no existe");
			LOGGER.error("Puede leerse:" + tmpFile.canRead() + " es documento: " + tmpFile.isFile() + " existe: "
					+ tmpFile.exists() + " es directorio " + !tmpFile.isDirectory());
		} else {

			String mimeType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(ruta);

			file = DefaultStreamedContent.builder().name(nameDocument).contentType(mimeType).stream(() -> {
				try {
					return new FileInputStream(tmpFile);
				} catch (FileNotFoundException e) {
					LOGGER.error("Error al descargar el archivo : ", e);
					return null;
				}
			}).build();

		}
	}
	
	public void downloadModalidad(String nameDocument, String rutaDocument) {
		file = null;
		InputStream inputArchivoFormato;
		
		try {
			File archivo = new File(rutaDocument);
			inputArchivoFormato = new FileInputStream(archivo);
			
			if (!archivo.canRead() || !archivo.isFile() || !archivo.exists() || archivo.isDirectory()) {
				LOGGER.error("El archivo " + nameDocument + "con ruta " + rutaDocument + " no existe");
				LOGGER.error("Puede leerse:" + archivo.canRead() 
				+ " es documento: " + archivo.isFile() 
				+ " existe: " + archivo.exists()
				+ " es directorio " + !archivo.isDirectory());
			}

			String mimeType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(rutaDocument);

			if (mimeType == null) {
				mimeType = URLConnection.guessContentTypeFromStream(inputArchivoFormato);
				if (mimeType == null && nameDocument.substring(nameDocument.lastIndexOf('.'), nameDocument.length())
						.contains("xls")) {
					mimeType = "application/vnd.ms-excel";
				}
			}

			file = DefaultStreamedContent.builder().name(nameDocument).contentType(mimeType).stream(() -> {
				try {
					return new FileInputStream(archivo);
				} catch (FileNotFoundException e) {
					LOGGER.error("Error al descargar el archivo : ", e);
					return null;
				}
			}).build();
			

		} catch (FileNotFoundException ex) {
			LOGGER.error("Ocurrió un error al intentar descargar el archivo (Modalidad)", ex);
		} catch (IOException ex) {
			LOGGER.error("Ocurrió un error al intentar descargar el archivo (Modalidad)", ex);
		}
		
//		return file;
	}
	
	public void redirecHome() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.RETURN_HOME_PAGE);
		} catch (IOException ex) {
			LOGGER.error("Ocurrió un error al redireccionar", ex);
		}
	}
	
	public int asignaIndiceRequisitos() {

		if(tramiteSeleccionado.getTieneModalidades() != null && tramiteSeleccionado.getTieneModalidades()) {
			if(!lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()) {
				return lstFormatosModalidadDTO.isEmpty()?4:3;
			}else if(!lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && lstDocsTramCompDomicilio.isEmpty()
					||!lstDocsTramIdenOfical.isEmpty() && lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()
					||lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()) {
				return lstFormatosModalidadDTO.isEmpty()?3:2;
			}else if(!lstDocsTramIdenOfical.isEmpty() && lstDocsTramRepresentante.isEmpty() && lstDocsTramCompDomicilio.isEmpty()
					||lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && lstDocsTramCompDomicilio.isEmpty()
					||lstDocsTramIdenOfical.isEmpty() && lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()) {
				return lstFormatosModalidadDTO.isEmpty()?2:1;
			}else {
				return 1;
			}
		}
		
		if(!lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()) {
			return 4;
		}else if(!lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && lstDocsTramCompDomicilio.isEmpty()
				||!lstDocsTramIdenOfical.isEmpty() && lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()
				||lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()) {
			return 3;
		}else if(!lstDocsTramIdenOfical.isEmpty() && lstDocsTramRepresentante.isEmpty() && lstDocsTramCompDomicilio.isEmpty()
				||lstDocsTramIdenOfical.isEmpty() && !lstDocsTramRepresentante.isEmpty() && lstDocsTramCompDomicilio.isEmpty()
				||lstDocsTramIdenOfical.isEmpty() && lstDocsTramRepresentante.isEmpty() && !lstDocsTramCompDomicilio.isEmpty()) {
			return 2;
		}else {
			return 1;
		}
	
	}
	
	public void actualizaPanel(int menu){
		switch (menu) {
			case Constantes.MENU_INDICADORES:
				if (verIndicadores) {
					verIndicadores = false;
					PrimeFaces.current().executeScript("PF('panelWidget').collapse()");
					estiloCiudad = "adip-ciudad-hoy";
				} else {
					verIndicadores = true;
					PrimeFaces.current().executeScript("PF('panelWidget').expand()");
					estiloCiudad = "adip-ciudad-hoy-false";
				}
				if(verBuscador) {
//					PrimeFaces.current().executeScript("document.getElementById('formBuscador:pnlColapsable_toggler').click()");
					PrimeFaces.current().executeScript("PF('panelBuscador').collapse()");
					estiloBuscador = "adip-circle-gold"; 
				}
				verBuscador = false;
				break;
			case Constantes.MENU_BUSCADOR:
				if (verBuscador) {
					verBuscador = false;
					PrimeFaces.current().executeScript("PF('panelBuscador').collapse()");
					estiloBuscador = "adip-circle-gold"; 
				} else {
					verBuscador = true;
					PrimeFaces.current().executeScript("PF('panelBuscador').expand()");
					estiloBuscador = "adip-circle-grey"; 
				}
				if(verIndicadores) {
					PrimeFaces.current().executeScript("PF('panelWidget').collapse()");
					estiloCiudad = "adip-ciudad-hoy"; 
				}
				verIndicadores = false;
				break;
		}

//		PrimeFaces.current().executeScript("document.getElementById('formBuscador:pnlColapsable_toggler').click()");
	}

	public DetalleTramiteServicioDTO getDetalleTramiteServicioDTO() {
		return detalleTramiteServicioDTO;
	}

	public List<CatUnidadesAdministrativaDTO> getListUnidadesAdm() {
		return listUnidadesAdm;
	}

	public PortalTramitesBusquedaDTO getTramiteSeleccionado() {
		return tramiteSeleccionado;
	}

	public List<CatTipoVialidadDTO> getListTipoVialidad() {
		return listTipoVialidad;
	}

	public void setDetalleTramiteServicioDTO(DetalleTramiteServicioDTO detalleTramiteServicioDTO) {
		this.detalleTramiteServicioDTO = detalleTramiteServicioDTO;
	}

	public void setListUnidadesAdm(List<CatUnidadesAdministrativaDTO> listUnidadesAdm) {
		this.listUnidadesAdm = listUnidadesAdm;
	}

	public void setTramiteSeleccionado(PortalTramitesBusquedaDTO tramiteSeleccionado) {
		this.tramiteSeleccionado = tramiteSeleccionado;
	}

	public void setListTipoVialidad(List<CatTipoVialidadDTO> listTipoVialidad) {
		this.listTipoVialidad = listTipoVialidad;
	}

	public List<ModalidadesTramiteServicioDTO> getListModalidadesTramiteServicioDTO() {
		return listModalidadesTramiteServicioDTO;
	}

	public void setListModalidadesTramiteServicioDTO(
			List<ModalidadesTramiteServicioDTO> listModalidadesTramiteServicioDTO) {
		this.listModalidadesTramiteServicioDTO = listModalidadesTramiteServicioDTO;
	}

	public List<DetDocumentosTramiteDTO> getLstDocsTramIdenOfical() {
		return lstDocsTramIdenOfical;
	}

	public List<DetDocumentosTramiteDTO> getLstDocsTramRepresentante() {
		return lstDocsTramRepresentante;
	}

	public List<DetDocumentosTramiteDTO> getLstDocsTramCompDomicilio() {
		return lstDocsTramCompDomicilio;
	}

	public void setLstDocsTramIdenOfical(List<DetDocumentosTramiteDTO> lstDocsTramIdenOfical) {
		this.lstDocsTramIdenOfical = lstDocsTramIdenOfical;
	}

	public void setLstDocsTramRepresentante(List<DetDocumentosTramiteDTO> lstDocsTramRepresentante) {
		this.lstDocsTramRepresentante = lstDocsTramRepresentante;
	}

	public void setLstDocsTramCompDomicilio(List<DetDocumentosTramiteDTO> lstDocsTramCompDomicilio) {
		this.lstDocsTramCompDomicilio = lstDocsTramCompDomicilio;
	}

	public String getDoctosOficiales() {
		return doctosOficiales;
	}

	public void setDoctosOficiales(String doctosOficiales) {
		this.doctosOficiales = doctosOficiales;
	}

	public String getDoctosRepLegal() {
		return doctosRepLegal;
	}

	public int getCont() {
		return cont;
	}

	public void setDoctosRepLegal(String doctosRepLegal) {
		this.doctosRepLegal = doctosRepLegal;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public List<DetPasosRegistradoDTO> getPasos() {
		return pasos;
	}

	public List<DetPasosRegistradoDTO> getPasosTel() {
		return pasosTel;
	}

	public List<DetPasosRegistradoDTO> getPasosDig() {
		return pasosDig;
	}

	public void setPasos(List<DetPasosRegistradoDTO> pasos) {
		this.pasos = pasos;
	}

	public void setPasosTel(List<DetPasosRegistradoDTO> pasosTel) {
		this.pasosTel = pasosTel;
	}

	public void setPasosDig(List<DetPasosRegistradoDTO> pasosDig) {
		this.pasosDig = pasosDig;
	}

	public List<DetLugaresRegistradosDTO> getLugares() {
		return lugares;
	}

	public List<DetTelefonosRegistradosDTO> getTelefonos() {
		return telefonos;
	}

	public List<DetUrlRegistradoDTO> getUrls() {
		return urls;
	}

	public void setLugares(List<DetLugaresRegistradosDTO> lugares) {
		this.lugares = lugares;
	}

	public void setTelefonos(List<DetTelefonosRegistradosDTO> telefonos) {
		this.telefonos = telefonos;
	}

	public void setUrls(List<DetUrlRegistradoDTO> urls) {
		this.urls = urls;
	}

	public List<CatAreaAcDTO> getLstcentroAt() {
		return lstcentroAt;
	}

	public List<CatAreaAcDTO> getLstcentHorarios() {
		return lstcentHorarios;
	}

	public void setLstcentroAt(List<CatAreaAcDTO> lstcentroAt) {
		this.lstcentroAt = lstcentroAt;
	}

	public void setLstcentHorarios(List<CatAreaAcDTO> lstcentHorarios) {
		this.lstcentHorarios = lstcentHorarios;
	}

	public Long getIdModalidadSeleccionada() {
		return idModalidadSeleccionada;
	}

	public void setIdModalidadSeleccionada(Long idModalidadSeleccionada) {
		this.idModalidadSeleccionada = idModalidadSeleccionada;
	}

	public List<DetArchivosFormatoTramiteDTO> getLstFormatosDTO() {
		return lstFormatosDTO;
	}

	public void setLstFormatosDTO(List<DetArchivosFormatoTramiteDTO> lstFormatosDTO) {
		this.lstFormatosDTO = lstFormatosDTO;
	}

	public List<DetArchivosFormatoModalidadDTO> getLstFormatosModalidadDTO() {
		return lstFormatosModalidadDTO;
	}

	public void setLstFormatosModalidadDTO(List<DetArchivosFormatoModalidadDTO> lstFormatosModalidadDTO) {
		this.lstFormatosModalidadDTO = lstFormatosModalidadDTO;
	}

	public List<DetArchivosAdjuntosTramiteDTO> getLstArchivosTramiteDTO() {
		return lstArchivosTramiteDTO;
	}

	public void setLstArchivosTramiteDTO(List<DetArchivosAdjuntosTramiteDTO> lstArchivosTramiteDTO) {
		this.lstArchivosTramiteDTO = lstArchivosTramiteDTO;
	}

	public List<DetArchivosAdjuntosModalidadDTO> getLstArchivosModalidadDTO() {
		return lstArchivosModalidadDTO;
	}

	public void setLstArchivosModalidadDTO(List<DetArchivosAdjuntosModalidadDTO> lstArchivosModalidadDTO) {
		this.lstArchivosModalidadDTO = lstArchivosModalidadDTO;
	}

	public CatAreaAcDTO getCentroAt() {
		return centroAt;
	}

	public void setCentroAt(CatAreaAcDTO centroAt) {
		this.centroAt = centroAt;
	}

	public DetFechaPublicacionDAO getDetFechaPublicacionDAO() {
		return detFechaPublicacionDAO;
	}

	public void setDetFechaPublicacionDAO(DetFechaPublicacionDAO detFechaPublicacionDAO) {
		this.detFechaPublicacionDAO = detFechaPublicacionDAO;
	}

	public DetFechaPublicacionDTO getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(DetFechaPublicacionDTO fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public List<SelectItem> getLstAlcaldia() {
		return lstAlcaldia;
	}

	public void setLstAlcaldia(List<SelectItem> lstAlcaldia) {
		this.lstAlcaldia = lstAlcaldia;
	}

	public Integer getId_alcaldia() {
		return id_alcaldia;
	}

	public void setId_alcaldia(Integer id_alcaldia) {
		this.id_alcaldia = id_alcaldia;
	}

	public List<CatAreaAcDTO> getListadoAlcaldiaAux() {
		return listadoAlcaldiaAux;
	}

	public void setListadoAlcaldiaAux(List<CatAreaAcDTO> listadoAlcaldiaAux) {
		this.listadoAlcaldiaAux = listadoAlcaldiaAux;
	}

	public List<DetRequisitosFormatoDTO> getLstReqEspFormatoDTO() {
		return lstReqEspFormatoDTO;
	}

	public void setLstReqEspFormatoDTO(List<DetRequisitosFormatoDTO> lstReqEspFormatoDTO) {
		this.lstReqEspFormatoDTO = lstReqEspFormatoDTO;
	}

	public List<DetRequisitosModalidadDTO> getLstReqEspFormatoModalidadDTO() {
		return lstReqEspFormatoModalidadDTO;
	}

	public void setLstReqEspFormatoModalidadDTO(List<DetRequisitosModalidadDTO> lstReqEspFormatoModalidadDTO) {
		this.lstReqEspFormatoModalidadDTO = lstReqEspFormatoModalidadDTO;
	}

	public ModalidadesTramiteServicioDTO getModalidadesTramiteServicioDTO() {
		return modalidadesTramiteServicioDTO;
	}

	public void setModalidadesTramiteServicioDTO(ModalidadesTramiteServicioDTO modalidadesTramiteServicioDTO) {
		this.modalidadesTramiteServicioDTO = modalidadesTramiteServicioDTO;
	}

	public List<DetConceptosCostoDTO> getLstConceptoCostoDTO() {
		return lstConceptoCostoDTO;
	}

	public void setLstConceptoCostoDTO(List<DetConceptosCostoDTO> lstConceptoCostoDTO) {
		this.lstConceptoCostoDTO = lstConceptoCostoDTO;
	}

	public List<DetConcCostosModalDTO> getLstConceptoModalidadDTO() {
		return lstConceptoModalidadDTO;
	}

	public void setLstConceptoModalidadDTO(List<DetConcCostosModalDTO> lstConceptoModalidadDTO) {
		this.lstConceptoModalidadDTO = lstConceptoModalidadDTO;
	}

	public Boolean getTieneCosto() {
		return tieneCosto;
	}

	public void setTieneCosto(Boolean tieneCosto) {
		this.tieneCosto = tieneCosto;
	}

	public List<DetMedioBancoDTO> getLstDetMedioBanco() {
		return lstDetMedioBanco;
	}

	public List<DetMedioDependenciaDTO> getLstDetMedioDependencia() {
		return lstDetMedioDependencia;
	}

	public List<DetMedioOficinaDTO> getLstDetMedioOficina() {
		return lstDetMedioOficina;
	}

	public List<DetMedioOnlineDTO> getLstDetMedioOnline() {
		return lstDetMedioOnline;
	}

	public List<DetMedioOtroDTO> getLstDetMedioOtro() {
		return lstDetMedioOtro;
	}

	public List<DetMedioTiendaDTO> getLstDetMedioTienda() {
		return lstDetMedioTienda;
	}

	public void setLstDetMedioBanco(List<DetMedioBancoDTO> lstDetMedioBanco) {
		this.lstDetMedioBanco = lstDetMedioBanco;
	}

	public void setLstDetMedioDependencia(List<DetMedioDependenciaDTO> lstDetMedioDependencia) {
		this.lstDetMedioDependencia = lstDetMedioDependencia;
	}

	public void setLstDetMedioOficina(List<DetMedioOficinaDTO> lstDetMedioOficina) {
		this.lstDetMedioOficina = lstDetMedioOficina;
	}

	public void setLstDetMedioOnline(List<DetMedioOnlineDTO> lstDetMedioOnline) {
		this.lstDetMedioOnline = lstDetMedioOnline;
	}

	public void setLstDetMedioOtro(List<DetMedioOtroDTO> lstDetMedioOtro) {
		this.lstDetMedioOtro = lstDetMedioOtro;
	}

	public void setLstDetMedioTienda(List<DetMedioTiendaDTO> lstDetMedioTienda) {
		this.lstDetMedioTienda = lstDetMedioTienda;
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public int getIndiceRequisitos() {
		return indiceRequisitos;
	}

	public void setIndiceRequisitos(int indiceRequisitos) {
		this.indiceRequisitos = indiceRequisitos;
	}

	public List<CrcTramiteFundamentoDTO> getLstTramiteFundamento() {
		return lstTramiteFundamento;
	}

	public void setLstTramiteFundamento(List<CrcTramiteFundamentoDTO> lstTramiteFundamento) {
		this.lstTramiteFundamento = lstTramiteFundamento;
	}

	public ReverseGeocodingMaps getReverseGeocode() {
		return reverseGeocode;
	}

	public void setReverseGeocode(ReverseGeocodingMaps reverseGeocode) {
		this.reverseGeocode = reverseGeocode;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public String getEstiloBuscador() {
		return estiloBuscador;
	}

	public void setEstiloBuscador(String estiloBuscador) {
		this.estiloBuscador = estiloBuscador;
	}

	public String getEstiloCiudad() {
		return estiloCiudad;
	}

	public void setEstiloCiudad(String estiloCiudad) {
		this.estiloCiudad = estiloCiudad;
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
}
