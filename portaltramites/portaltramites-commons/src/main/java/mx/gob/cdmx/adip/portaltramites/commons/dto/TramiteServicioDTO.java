package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class TramiteServicioDTO implements Serializable {
	
	private static final long serialVersionUID = -3395275019697733490L;
	private Long id;
	private String beneficio;
	private String homoclave;
	private String nombreOficial;
	private String nombreParaCiudadano;
	private Boolean tieneModalidades;
	private CatEsTramiteServicioDTO catEsTramiteServicio;
//	private CatEtapaDeVidaDTO catEtapaDeVida;
//	private CatUnidadesAdministrativaDTO catUnidadesAdministrativa;
//	private CatDependenciaDTO catDependencia;
	
	public TramiteServicioDTO() {
		super();
		catEsTramiteServicio = new CatEsTramiteServicioDTO();
//		catEtapaDeVida = new CatEtapaDeVidaDTO();
//		catUnidadesAdministrativa = new CatUnidadesAdministrativaDTO();
//		catDependencia = new CatDependenciaDTO();
	}
	

	public TramiteServicioDTO(Long id) {
	
		this.id = id;
	}


	public TramiteServicioDTO(Long id, String homoclave, String nombreOficial) {
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
	}
//	public TramiteServicioDTO( String beneficio, String homoclave, String nombreOficial,
//			String nombreParaCiudadano, Boolean tieneModalidades, CatEsTramiteServicioDTO catEsTramiteServicio,
//			CatEtapaDeVidaDTO catEtapaDeVida, CatUnidadesAdministrativaDTO catUnidadesAdministrativa) {	
//	
//		this.beneficio = beneficio;
//		this.homoclave = homoclave;
//		this.nombreOficial = nombreOficial;
//		this.nombreParaCiudadano = nombreParaCiudadano;
//		this.tieneModalidades = tieneModalidades;
//		this.catEsTramiteServicio = catEsTramiteServicio;
//		this.catEtapaDeVida = catEtapaDeVida;
//		this.catUnidadesAdministrativa = catUnidadesAdministrativa;
//	}
	
	
	public TramiteServicioDTO(Long id, 
			String homoclave, 
			String nombreOficial, 
			Boolean tieneModalidades, 
			Long idEsTramiteServicio,
			String descEsTramiteServicio,
			Long idEtapaDeVida, 
			String descEtapaDeVida,
			Long idUnidadesAdministrativa,
			String descUnidadesAdministrativa,
			Integer idDependencia,
			String nombreDependencia,
			String abreviaturaDependencia) {
	
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
		this.tieneModalidades = tieneModalidades;
		this.catEsTramiteServicio = new CatEsTramiteServicioDTO(idEsTramiteServicio, descEsTramiteServicio);
//		this.catEtapaDeVida = new CatEtapaDeVidaDTO(idEtapaDeVida, descEtapaDeVida, null);
//		this.catUnidadesAdministrativa = new CatUnidadesAdministrativaDTO(idUnidadesAdministrativa, descUnidadesAdministrativa);
//		this.catDependencia = new CatDependenciaDTO(idDependencia, abreviaturaDependencia, nombreDependencia, true);
	}
	
	public TramiteServicioDTO(Long id, String homoclave, String nombreOficial,
			Long idEsTramiteServicio, String descEsTramiteServicio, Long idEtapaDeVida, 
			String descEtapaDeVida, Boolean tieneModalidades) {
		super();
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
		this.catEsTramiteServicio = new CatEsTramiteServicioDTO(idEsTramiteServicio, descEsTramiteServicio, null);
//		this.catEtapaDeVida = new CatEtapaDeVidaDTO(idEtapaDeVida, descEtapaDeVida, null);
		this.tieneModalidades = tieneModalidades;
	}
	
	public TramiteServicioDTO (Boolean tieneModalidades ){
		this.tieneModalidades = tieneModalidades;
	}
	
	public TramiteServicioDTO (String nombreOficial ){
		this.nombreOficial = nombreOficial;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	public String getHomoclave() {
		return homoclave;
	}
	public void setHomoclave(String homoclave) {
		this.homoclave = homoclave;
	}
	public String getNombreOficial() {
		return nombreOficial;
	}
	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}
	public String getNombreParaCiudadano() {
		return nombreParaCiudadano;
	}
	public void setNombreParaCiudadano(String nombreParaCiudadano) {
		this.nombreParaCiudadano = nombreParaCiudadano;
	}
	public Boolean getTieneModalidades() {
		return tieneModalidades;
	}
	public void setTieneModalidades(Boolean tieneModalidades) {
		this.tieneModalidades = tieneModalidades;
	}

	public CatEsTramiteServicioDTO getCatEsTramiteServicio() {
		return catEsTramiteServicio;
	}

	public void setCatEsTramiteServicio(CatEsTramiteServicioDTO catEsTramiteServicio) {
		this.catEsTramiteServicio = catEsTramiteServicio;
	}

//	public CatEtapaDeVidaDTO getCatEtapaDeVida() {
//		return catEtapaDeVida;
//	}
//
//	public void setCatEtapaDeVida(CatEtapaDeVidaDTO catEtapaDeVida) {
//		this.catEtapaDeVida = catEtapaDeVida;
//	}
//
//	public CatUnidadesAdministrativaDTO getCatUnidadesAdministrativa() {
//		return catUnidadesAdministrativa;
//	}
//
//	public void setCatUnidadesAdministrativa(CatUnidadesAdministrativaDTO catUnidadesAdministrativa) {
//		this.catUnidadesAdministrativa = catUnidadesAdministrativa;
//	}
//
//	public CatDependenciaDTO getCatDependencia() {
//		return catDependencia;
//	}
//
//
//	public void setCatDependencia(CatDependenciaDTO catDependencia) {
//		this.catDependencia = catDependencia;
//	}
	
}
