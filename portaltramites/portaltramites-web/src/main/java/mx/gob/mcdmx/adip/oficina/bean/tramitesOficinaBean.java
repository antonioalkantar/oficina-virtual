package mx.gob.mcdmx.adip.oficina.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.acceso.bean.AuthenticatorBean;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.dao.CatDependenciaTxDAO;
import mx.gob.cdmx.adip.portaltx.dao.CatEstatusDAO;
import mx.gob.cdmx.adip.portaltx.dao.CatTipoFuncionalidadDAO;
import mx.gob.cdmx.adip.portaltx.dao.RegistroDAO;
import mx.gob.cdmx.adip.portaltx.dto.CatDependenciaTxDTO;
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;
import mx.gob.cdmx.adip.portaltx.dto.CatTipoFuncionalidadDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;

@Named("tramitesOficinaBean")
@SessionScoped
public class tramitesOficinaBean implements Serializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(tramitesOficinaBean.class);
	private static final long serialVersionUID = -5581664539900453340L;

	private RegistroDTO registroSelected;
	private List<RegistroDTO> lstRegistro;
	private List<RegistroDTO> lstRegistroFiltered;
	private List<RegistroDTO> lstRegistroBySearch;
	private List<CatTipoFuncionalidadDTO> lstCatTipoFuncionalidad;
	private List<CatTipoFuncionalidadDTO> lstCatTipoFuncionalidadSelected;
	private List<CatDependenciaTxDTO> lstCatDependencia;
	private List<CatDependenciaTxDTO> lstCatDependenciaSelected;
	private List<CatEstatusDTO> lstCatEstatus;
	private List<CatEstatusDTO> lstCatEstatusSelected;
	private boolean selectAllEstatus;
	private boolean selectAllDependencias;
	private String palabraBuscada;
	private StreamedContent file;
//	Variables para panel buscador
	private String estiloBuscador;
	private String estiloCiudad;
	private boolean verBuscador;
	private boolean verIndicadores;
	private int menuIndicador = Constantes.MENU_INDICADORES;
	private int menuBuscador = Constantes.MENU_BUSCADOR;
//	Variables para constantes
	private Integer ID_TIPO_TRAMITE = Constantes.ID_TIPO_TRAMITE;
	private Integer ID_TIPO_SERVICIO = Constantes.ID_TIPO_SERVICIO;
	private Integer ID_TIPO_REPORTE = Constantes.ID_TIPO_REPORTE;
	private Integer ID_TIPO_PROGRAMA = Constantes.ID_TIPO_PROGRAMA;

	private Integer ID_ESTATUS_RECIBIDO = Constantes.ID_ESTATUS_RECIBIDO;
	private Integer ID_ESTATUS_EN_PROCESO = Constantes.ID_ESTATUS_EN_PROCESO;
	private Integer ID_ESTATUS_ESPERA_TURNADO = Constantes.ID_ESTATUS_ESPERA_TURNADO;
	private Integer ID_ESTATUS_ESPERA_PAGO = Constantes.ID_ESTATUS_ESPERA_PAGO;
	private Integer ID_ESTATUS_PAGADO = Constantes.ID_ESTATUS_PAGADO;
	private Integer ID_ESTATUS_RECHAZADO = Constantes.ID_ESTATUS_RECHAZADO;
	private Integer ID_ESTATUS_APROBADO = Constantes.ID_ESTATUS_APROBADO;
	private Integer ID_ESTATUS_FINALIZADO = Constantes.ID_ESTATUS_FINALIZADO;
	
	private Integer ID_SISTEMA_SUAC = Constantes.ID_SISTEMA_SUAC;
	private Integer ID_SISTEMA_SACMEX = Constantes.ID_SISTEMA_SACMEX;
	private Integer ID_SISTEMA_LICENCIA = Constantes.ID_SISTEMA_LICENCIA;
	private Integer ID_SISTEMA_MIBECA = Constantes.ID_SISTEMAS_MIBECA;
	private Integer ID_SISTEMA_CITAS = Constantes.ID_SISTEMA_CITAS;
	private Integer ID_SISTEMA_REFRENDO_TARJETA_CIRCULACION = Constantes.ID_SISTEMAS_REFRENDO_TARJETA_CIRCULACION;
	private Integer ID_SISTEMA_ACTA_DIGITAL = Constantes.ID_SISTEMA_ACTA_DIGITAL;
	private Integer ID_SISTEMA_NOANTECEDENTES = Constantes.ID_SISTEMA_NO_ANTECEDENTES;
	private Integer ID_SISTEMA_SEGURO_DESEMPLEO = Constantes.ID_SISTEMA_SEGURO_DESEMPLEO;
	private Integer ID_SISTEMA_SISTEMA_ELECTRICO = Constantes.ID_SISTEMA_SISTEMA_ELECTRICO;	
	private Integer ID_SISTEMA_PROTESTA_CIUDADANA = Constantes.ID_SISTEMA_PROTESTA_CIUDADANA;	
	private Integer ID_SISTEMA_VENTANILLA_UNICA_CONSTRUCCION = Constantes.ID_SISTEMA_VENTANILLA_UNICA_CONSTRUCCION;
	private Integer ID_SISTEMA_PERMISO_RESIDENTES = Constantes.ID_SISTEMA_PERMISO_RESIDENTES;
	private Integer ID_SISTEMA_JURIDICO_LABORAL = Constantes.ID_SISTEMA_JURIDICO_LABORAL;
	private Integer ID_SISTEMA_VENTANILLA_CONTROL_VEHICULAR = Constantes.ID_SISTEMA_VENTANILLA_CONTROL_VEHICULAR;
	private Integer ID_SISTEMA_CORTESIAS_URBANAS = Constantes.ID_SISTEMA_CORTESIAS_URBANAS;

	@Inject
	private RegistroDAO registroDAO;
	@Inject
	private CatEstatusDAO catEstatusDAO;
	@Inject
	private CatTipoFuncionalidadDAO catTipoFuncionalidadDAO;
	@Inject
	private CatDependenciaTxDAO catDependenciaTxDAO;
	@Inject
	private AuthenticatorBean authenticatorBean;

	public tramitesOficinaBean() {
//		LOGGER.info("---- SE INICIALIZAN VARIABLES ----");
		lstCatTipoFuncionalidad = new ArrayList<>();
		lstCatDependencia = new ArrayList<>();
		lstCatEstatus = new ArrayList<>();
		lstRegistroFiltered = new ArrayList<>();
		lstCatTipoFuncionalidadSelected = new ArrayList<>();
		lstCatDependenciaSelected = new ArrayList<>();
		lstCatEstatusSelected = new ArrayList<>();
		lstRegistroBySearch = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
//		LOGGER.info("---- SE REALIZAN CONSULTAS GENERALES ----");
		lstCatTipoFuncionalidad = catTipoFuncionalidadDAO.buscarTodos();
		lstCatDependencia = catDependenciaTxDAO.buscarTodos();
		lstCatEstatus = catEstatusDAO.buscarTodos();
		lstRegistro = registroDAO.consultaGral(authenticatorBean.getUsuarioLogueado().getIdPersona(), authenticatorBean.getUsuarioLogueado().getCurp(), authenticatorBean.getUsuarioLogueado().getCorreoElectronico());
		lstRegistroFiltered.addAll(lstRegistro);
		verIndicadores = false;
		verBuscador = false;
		registroSelected = null;
	}

	/*
	 * Método para filtrar los registros por Clasificacion, Dependencia y Estatus
	 */
	public void filtraRegistros() {
		registroSelected = null;
		lstRegistroFiltered.clear();
		lstRegistroBySearch.clear();
		
		if (palabraBuscada != null && !palabraBuscada.trim().isEmpty()) {
			lstRegistroBySearch.addAll(lstRegistro.stream().filter(registro -> registro.getCatFuncionalidadDTO().getNombre()
					.toLowerCase().contains(palabraBuscada.toLowerCase().trim())).collect(Collectors.toList()));
		}else {
			palabraBuscada = null;
			lstRegistroBySearch.addAll(lstRegistro);
		}

		if (lstCatTipoFuncionalidadSelected.isEmpty() && lstCatDependenciaSelected.isEmpty()
				&& lstCatEstatusSelected.isEmpty()) {
			lstRegistroFiltered.addAll(lstRegistroBySearch);
			return;
		}
		
		//FILTRO POR FUNCIONALIDAD
		if (lstCatTipoFuncionalidadSelected.isEmpty()) {
			lstRegistroFiltered.addAll(lstRegistroBySearch);
		} else {
			lstCatTipoFuncionalidadSelected.forEach(tipo -> {
				lstRegistroFiltered.addAll(lstRegistroBySearch
						.stream().filter(registro -> registro.getCatTipoFuncionalidadDTO()
								.getIdTipoFuncionalidad() == tipo.getIdTipoFuncionalidad())
						.collect(Collectors.toList()));
			});
		}

		List<RegistroDTO> listadoTmp = new ArrayList<>();
		// Filtrado por Dependencia
		if (!lstCatDependenciaSelected.isEmpty()) {
			lstCatDependenciaSelected.forEach(dependencia -> {
				listadoTmp
						.addAll(lstRegistroFiltered
								.stream().filter(registro -> registro.getCatDependenciaTxDTO()
										.getIdDependencia() == dependencia.getIdDependencia())
								.collect(Collectors.toList()));
			});
			lstRegistroFiltered.clear();
			lstRegistroFiltered.addAll(listadoTmp);
			listadoTmp.clear();
		}
		// Filtrado por Estatus
		if (!lstCatEstatusSelected.isEmpty()) {
			lstCatEstatusSelected.forEach(estatus -> {
				listadoTmp.addAll(lstRegistroFiltered.stream()
						.filter(registro -> registro.getCatEstatusDTO().getIdEstatus() == estatus.getIdEstatus())
						.collect(Collectors.toList()));
			});
			lstRegistroFiltered.clear();
			lstRegistroFiltered.addAll(listadoTmp);
		}
	}
	
	

	/*
	 * Método para limpiar o añadir elemento a la lista de Dependencias cuando
	 * selecciona "Todos"
	 */
	public void seleccionaDependencias() {
		if (selectAllDependencias) {
			lstCatDependenciaSelected.clear();
			lstCatDependenciaSelected.addAll(lstCatDependencia);
			return;
		}
		lstCatDependenciaSelected.clear();
	}

	/*
	 * Método para limpiar o añadir elemento a la lista de Dependencias cuando
	 * selecciona Toggle
	 */
	public void seleccionaToggleDependencias() {
		selectAllDependencias = lstCatDependenciaSelected.size() == lstCatDependencia.size();
	}

	/*
	 * Método para limpiar o añadir elemento a la lista de Estatus cuando selecciona
	 * "Todos"
	 */
	public void seleccionaEstatus() {
		if (selectAllEstatus) {
			lstCatEstatusSelected.clear();
			lstCatEstatusSelected.addAll(lstCatEstatus);
			return;
		}
		lstCatEstatusSelected.clear();
	}

	/*
	 * Método para limpiar o añadir elemento a la lista de Estatus cuando selecciona
	 * Toggle
	 */
	public void seleccionaToggleEstatus() {
		selectAllEstatus = lstCatEstatusSelected.size() == lstCatEstatus.size();
	}

	public void filtrarPorPalabra() {
		
		registroSelected = null;
		lstRegistroFiltered.clear();
		filtraRegistros();
//		if (palabraBuscada == null || palabraBuscada.trim().isEmpty()) {
//			lstRegistroFiltered.addAll(lstRegistro);
//			palabraBuscada = null;
//			return;
//		}
//
//		lstRegistroFiltered.addAll(lstRegistro.stream().filter(registro -> registro.getCatFuncionalidadDTO().getNombre()
//				.toLowerCase().contains(palabraBuscada.toLowerCase().trim())).collect(Collectors.toList()));
		

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
		
	
	public void borraFiltro() {
		lstCatTipoFuncionalidad = new ArrayList<>();
		lstCatDependencia = new ArrayList<>();
		lstCatEstatus = new ArrayList<>();
		lstRegistroFiltered = new ArrayList<>();
		lstCatTipoFuncionalidadSelected = new ArrayList<>();
		lstCatDependenciaSelected = new ArrayList<>();
		lstCatEstatusSelected = new ArrayList<>();
		lstCatTipoFuncionalidad = catTipoFuncionalidadDAO.buscarTodos();
		lstCatDependencia = catDependenciaTxDAO.buscarTodos();
		lstCatEstatus = catEstatusDAO.buscarTodos();
		lstRegistro = registroDAO.consultaGral(authenticatorBean.getUsuarioLogueado().getIdPersona(), authenticatorBean.getUsuarioLogueado().getCurp(), authenticatorBean.getUsuarioLogueado().getCorreoElectronico());
		lstRegistroFiltered.addAll(lstRegistro);
		verIndicadores = false;
		verBuscador = false;
		registroSelected = null;
		palabraBuscada = null;
		PrimeFaces.current().scrollTo("messages");
	}
	
//	public void consultaDetalleReporte() {
//		try {
//		switch (registroSelected.getCatTipoFuncionalidadDTO().getIdTipoFuncionalidad()) {
//			case Constantes.ID_TIPO_REPORTE:
//				new SUACRestClient().consultaRegistroSUAC(registroSelected);
//				break;
//			default:
//				break;
//			}
//		} catch (Exception e) {
//			LOGGER.error("ERROR al consultar servicio", e);
//		}
//
//	}

	public RegistroDTO getRegistroSelected() {
		return registroSelected;
	}

	public void setRegistroSelected(RegistroDTO registroSelected) {
		this.registroSelected = registroSelected;
	}

	public List<RegistroDTO> getLstRegistro() {
		return lstRegistro;
	}

	public void setLstRegistro(List<RegistroDTO> lstRegistro) {
		this.lstRegistro = lstRegistro;
	}

	public List<CatTipoFuncionalidadDTO> getLstCatTipoFuncionalidad() {
		return lstCatTipoFuncionalidad;
	}

	public void setLstCatTipoFuncionalidad(List<CatTipoFuncionalidadDTO> lstCatTipoFuncionalidad) {
		this.lstCatTipoFuncionalidad = lstCatTipoFuncionalidad;
	}

	public List<CatDependenciaTxDTO> getLstCatDependencia() {
		return lstCatDependencia;
	}

	public void setLstCatDependencia(List<CatDependenciaTxDTO> lstCatDependencia) {
		this.lstCatDependencia = lstCatDependencia;
	}

	public List<CatEstatusDTO> getLstCatEstatus() {
		return lstCatEstatus;
	}

	public void setLstCatEstatus(List<CatEstatusDTO> lstCatEstatus) {
		this.lstCatEstatus = lstCatEstatus;
	}

	public List<RegistroDTO> getLstRegistroFiltered() {
		return lstRegistroFiltered;
	}

	public void setLstRegistroFiltered(List<RegistroDTO> lstRegistroFiltered) {
		this.lstRegistroFiltered = lstRegistroFiltered;
	}

	public List<CatTipoFuncionalidadDTO> getLstCatTipoFuncionalidadSelected() {
		return lstCatTipoFuncionalidadSelected;
	}

	public void setLstCatTipoFuncionalidadSelected(List<CatTipoFuncionalidadDTO> lstCatTipoFuncionalidadSelected) {
		this.lstCatTipoFuncionalidadSelected = lstCatTipoFuncionalidadSelected;
	}

	public List<CatDependenciaTxDTO> getLstCatDependenciaSelected() {
		return lstCatDependenciaSelected;
	}

	public void setLstCatDependenciaSelected(List<CatDependenciaTxDTO> lstCatDependenciaSelected) {
		this.lstCatDependenciaSelected = lstCatDependenciaSelected;
	}

	public List<CatEstatusDTO> getLstCatEstatusSelected() {
		return lstCatEstatusSelected;
	}

	public void setLstCatEstatusSelected(List<CatEstatusDTO> lstCatEstatusSelected) {
		this.lstCatEstatusSelected = lstCatEstatusSelected;
	}

	public boolean isSelectAllEstatus() {
		return selectAllEstatus;
	}

	public void setSelectAllEstatus(boolean selectAllEstatus) {
		this.selectAllEstatus = selectAllEstatus;
	}

	public boolean isSelectAllDependencias() {
		return selectAllDependencias;
	}

	public void setSelectAllDependencias(boolean selectAllDependencias) {
		this.selectAllDependencias = selectAllDependencias;
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
	
	public Integer getID_TIPO_TRAMITE() {
		return ID_TIPO_TRAMITE;
	}

	public Integer getID_TIPO_SERVICIO() {
		return ID_TIPO_SERVICIO;
	}

	public Integer getID_TIPO_REPORTE() {
		return ID_TIPO_REPORTE;
	}

	public Integer getID_TIPO_PROGRAMA() {
		return ID_TIPO_PROGRAMA;
	}

	public Integer getID_ESTATUS_RECIBIDO() {
		return ID_ESTATUS_RECIBIDO;
	}

	public Integer getID_ESTATUS_EN_PROCESO() {
		return ID_ESTATUS_EN_PROCESO;
	}

	public Integer getID_ESTATUS_ESPERA_TURNADO() {
		return ID_ESTATUS_ESPERA_TURNADO;
	}

	public Integer getID_ESTATUS_ESPERA_PAGO() {
		return ID_ESTATUS_ESPERA_PAGO;
	}

	public Integer getID_ESTATUS_PAGADO() {
		return ID_ESTATUS_PAGADO;
	}

	public Integer getID_ESTATUS_RECHAZADO() {
		return ID_ESTATUS_RECHAZADO;
	}

	public Integer getID_ESTATUS_APROBADO() {
		return ID_ESTATUS_APROBADO;
	}

	public Integer getID_ESTATUS_FINALIZADO() {
		return ID_ESTATUS_FINALIZADO;
	}

	public String getPalabraBuscada() {
		return palabraBuscada;
	}

	public void setPalabraBuscada(String palabraBuscada) {
		this.palabraBuscada = palabraBuscada;
	}

	public Integer getID_SISTEMA_SUAC() {
		return ID_SISTEMA_SUAC;
	}
	
	public Integer getID_SISTEMA_SACMEX() {
		return ID_SISTEMA_SACMEX;
	}
	
	public Integer getID_SISTEMA_MIBECA() {
		return ID_SISTEMA_MIBECA;
	}	

	public Integer getID_SISTEMA_LICENCIA() {
		return ID_SISTEMA_LICENCIA;
	}

	public Integer getID_SISTEMA_CITAS() {
		return ID_SISTEMA_CITAS;
	}	

	public Integer getID_SISTEMA_REFRENDO_TARJETA_CIRCULACION() {
		return ID_SISTEMA_REFRENDO_TARJETA_CIRCULACION;
	}

	public void setID_SISTEMA_REFRENDO_TARJETA_CIRCULACION(Integer iD_SISTEMA_REFRENDO_TARJETA_CIRCULACION) {
		ID_SISTEMA_REFRENDO_TARJETA_CIRCULACION = iD_SISTEMA_REFRENDO_TARJETA_CIRCULACION;
	}

	public Integer getID_SISTEMA_ACTA_DIGITAL() {
		return ID_SISTEMA_ACTA_DIGITAL;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public Integer getID_SISTEMA_NOANTECEDENTES() {
		return ID_SISTEMA_NOANTECEDENTES;
	}

	public Integer getID_SISTEMA_SEGURO_DESEMPLEO() {
		return ID_SISTEMA_SEGURO_DESEMPLEO;
	}

	public Integer getID_SISTEMA_SISTEMA_ELECTRICO() {
		return ID_SISTEMA_SISTEMA_ELECTRICO;
	}

	public Integer getID_SISTEMA_PROTESTA_CIUDADANA() {
		return ID_SISTEMA_PROTESTA_CIUDADANA;
	}

	public Integer getID_SISTEMA_VENTANILLA_UNICA_CONSTRUCCION() {
		return ID_SISTEMA_VENTANILLA_UNICA_CONSTRUCCION;
	}
	
	public Integer getID_SISTEMA_PERMISO_RESIDENTES() {
		return ID_SISTEMA_PERMISO_RESIDENTES;
	}
	
	public Integer getID_SISTEMA_JURIDICO_LABORAL() {
		return ID_SISTEMA_JURIDICO_LABORAL;
	}
	
	public Integer getID_SISTEMA_VENTANILLA_CONTROL_VEHICULAR() {
		return ID_SISTEMA_VENTANILLA_CONTROL_VEHICULAR;
	}
	
	public Integer getID_SISTEMA_CORTESIAS_URBANAS() {
		return ID_SISTEMA_CORTESIAS_URBANAS;
	}
}
