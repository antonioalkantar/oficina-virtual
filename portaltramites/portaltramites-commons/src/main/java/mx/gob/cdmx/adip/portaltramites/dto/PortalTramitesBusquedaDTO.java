package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;

public class PortalTramitesBusquedaDTO implements Serializable {

	private static final long serialVersionUID = 1989772054555972523L;
	private Long id;
	private String homoclave;
	private String nombreOficial;
	private Long idEtapaDeVida;
	private String descripcionEtapaDeVida;
	private Integer idDependencia;
	private String abreviaturaDependencia;
	private String nombreDependencia;
	private Long idMateria;
	private String descripcionMateria;
	private Long idCanalAtencion;
	private Boolean puedeRealizarseDigitalmente;
	private Boolean tramiteConLlave;
	private Boolean puedeRealizarsePresencialmente;
	private Boolean puedeRealizarseTelefonicamente;
	private Boolean tieneModalidades;
	private Long idEsTramiteServicio;
	private String sinonimoBusqueda;
	private String descripcionTramite;
	private String descripcionCuidadana;
	private String descripcionUsuario;
	private String link;
	private Boolean contenidoManual;
	private Boolean programaSocial;
	private String urlPrograma;
	private String areaAdministrativa;
	

	public PortalTramitesBusquedaDTO() {
		
	}

	public PortalTramitesBusquedaDTO(Long id, String homoclave, String nombreOficial) {
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
	}

	//Constructor para cotenido manual
	public PortalTramitesBusquedaDTO(String nombreOficial, String descripcionTramite, String sinonimoBusqueda, Integer idDependencia, Long idMateria, String link, Long idEsTramiteServicio, Boolean contenidoManual, Boolean dispEnLinea) {
		this.nombreOficial = nombreOficial;
		this.descripcionTramite = descripcionTramite;
		this.tramiteConLlave = false;
		this.sinonimoBusqueda = sinonimoBusqueda;
		this.idDependencia = idDependencia;
		this.idMateria = idMateria;
		this.link = link;
		this.idEsTramiteServicio = idEsTramiteServicio;
		this.setContenidoManual(contenidoManual);
		this.puedeRealizarseDigitalmente = dispEnLinea;
	}

	//Constructor para programas sociales
	public PortalTramitesBusquedaDTO(String nombreOficial, String descripcionTramite, String sinonimoBusqueda, Integer idDependencia, Long idMateria, String link, Long idEsTramiteServicio, Boolean programaSocial, Boolean dispEnLinea, String urlPrograma, String nombreDependencia) {
		this.nombreOficial = nombreOficial;
		this.descripcionTramite = descripcionTramite;
		this.sinonimoBusqueda = sinonimoBusqueda;
		this.idDependencia = idDependencia;
		this.idMateria = idMateria;
		this.link = link;
		this.idEsTramiteServicio = idEsTramiteServicio;
		this.programaSocial = programaSocial;
		this.puedeRealizarseDigitalmente = dispEnLinea;
		this.urlPrograma = urlPrograma;
		this.nombreDependencia = nombreDependencia;
	}

	public PortalTramitesBusquedaDTO(Long id, String homoclave, String nombreOficial, 
			Long idEtapaDeVida, String descripcionEtapaDeVida, Integer idDependencia, 
			String abreviaturaDependencia, String nombreDependencia, Long idMateria, 
			String descripcionMateria, Long idCanalAtencion, Boolean puedeRealizarseDigitalmente,
			Boolean puedeRealizarsePresencialmente, Boolean puedeRealizarseTelefonicamente,
			Boolean tieneModalidades) {
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
		this.idEtapaDeVida = idEtapaDeVida;
		this.descripcionEtapaDeVida = descripcionEtapaDeVida;
		this.idDependencia = idDependencia;
		this.abreviaturaDependencia = abreviaturaDependencia;
		this.nombreDependencia = nombreDependencia;
		this.idMateria = idMateria;
		this.descripcionMateria = descripcionMateria;
		this.idCanalAtencion = idCanalAtencion;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneModalidades = tieneModalidades;
	}
	
	public PortalTramitesBusquedaDTO(Long id, String homoclave, String nombreOficial, 
			Long idEtapaDeVida, String descripcionEtapaDeVida, Integer idDependencia, 
			String abreviaturaDependencia, String nombreDependencia, Long idMateria, 
			String descripcionMateria, Long idCanalAtencion, Boolean puedeRealizarseDigitalmente,
			Boolean tramiteConLlave,
			Boolean puedeRealizarsePresencialmente, Boolean puedeRealizarseTelefonicamente,
			Boolean tieneModalidades, Long idEsTramiteServicio,String sinonimoBusqueda) {
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
		this.idEtapaDeVida = idEtapaDeVida;
		this.descripcionEtapaDeVida = descripcionEtapaDeVida;
		this.idDependencia = idDependencia;
		this.abreviaturaDependencia = abreviaturaDependencia;
		this.nombreDependencia = nombreDependencia;
		this.idMateria = idMateria;
		this.descripcionMateria = descripcionMateria;
		this.idCanalAtencion = idCanalAtencion;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.tramiteConLlave = tramiteConLlave;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneModalidades = tieneModalidades;
		this.idEsTramiteServicio = idEsTramiteServicio;
		this.sinonimoBusqueda = sinonimoBusqueda;
	}
	
	/**
	 * Constructor usado en los namedQuery TramiteServicio.findByIdTramite
	 * @param id
	 * @param homoclave
	 * @param nombreOficial
	 * @param idEtapaDeVida
	 * @param descripcionEtapaDeVida
	 * @param idDependencia
	 * @param abreviaturaDependencia
	 * @param nombreDependencia
	 * @param idMateria
	 * @param descripcionMateria
	 * @param idCanalAtencion
	 * @param puedeRealizarseDigitalmente
	 * @param tramiteConLlave
	 * @param puedeRealizarsePresencialmente
	 * @param puedeRealizarseTelefonicamente
	 * @param tieneModalidades
	 * @param idEsTramiteServicio
	 * @param sinonimoBusqueda
	 * @param descripcionUsuario
	 * @param descripcionCuidadana
	 */
	public PortalTramitesBusquedaDTO(Long id, String homoclave, String nombreOficial, 
			Long idEtapaDeVida, String descripcionEtapaDeVida, Integer idDependencia, 
			String abreviaturaDependencia, String nombreDependencia, Long idMateria, 
			String descripcionMateria, Long idCanalAtencion, Boolean puedeRealizarseDigitalmente,
			Boolean tramiteConLlave,
			Boolean puedeRealizarsePresencialmente, Boolean puedeRealizarseTelefonicamente,
			Boolean tieneModalidades, Long idEsTramiteServicio,String sinonimoBusqueda,
			String descripcionTramite, 
			String descripcionUsuario, String descripcionCuidadana) {
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
		this.idEtapaDeVida = idEtapaDeVida;
		this.descripcionEtapaDeVida = descripcionEtapaDeVida;
		this.idDependencia = idDependencia;
		this.abreviaturaDependencia = abreviaturaDependencia;
		this.nombreDependencia = nombreDependencia;
		this.idMateria = idMateria;
		this.descripcionMateria = descripcionMateria;
		this.idCanalAtencion = idCanalAtencion;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.tramiteConLlave = tramiteConLlave;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneModalidades = tieneModalidades;
		this.idEsTramiteServicio = idEsTramiteServicio;
		this.sinonimoBusqueda = sinonimoBusqueda;
		this.descripcionTramite = descripcionTramite;
		this.descripcionUsuario =descripcionUsuario;
		this.descripcionCuidadana = descripcionCuidadana;
	}

	/**
	 * Constructor usado en los namedQuery TramiteServicio.findSearch
	 * @param id
	 * @param homoclave
	 * @param nombreOficial
	 * @param idEtapaDeVida
	 * @param descripcionEtapaDeVida
	 * @param idDependencia
	 * @param abreviaturaDependencia
	 * @param nombreDependencia
	 * @param idMateria
	 * @param descripcionMateria
	 * @param idCanalAtencion
	 * @param puedeRealizarseDigitalmente
	 * @param tramiteConLlave
	 * @param puedeRealizarsePresencialmente
	 * @param puedeRealizarseTelefonicamente
	 * @param tieneModalidades
	 * @param idEsTramiteServicio
	 * @param sinonimoBusqueda
	 * @param descripcionUsuario
	 * @param descripcionCuidadana
	 */
	public PortalTramitesBusquedaDTO(Long id, String homoclave, String nombreOficial, 
			Long idEtapaDeVida, String descripcionEtapaDeVida, Integer idDependencia, 
			String abreviaturaDependencia, String nombreDependencia, Long idMateria, 
			String descripcionMateria, Long idCanalAtencion, Boolean puedeRealizarseDigitalmente,
			Boolean tramiteConLlave, Boolean puedeRealizarsePresencialmente, Boolean puedeRealizarseTelefonicamente,
			Boolean tieneModalidades, Integer idEsTramiteServicio,String sinonimoBusqueda,
			String descripcionTramite, String descripcionUsuario, String descripcionCuidadana, String areaAdministrativa,
			String link) {
		this.id = id;
		this.homoclave = homoclave;
		this.nombreOficial = nombreOficial;
		this.idEtapaDeVida = idEtapaDeVida;
		this.descripcionEtapaDeVida = descripcionEtapaDeVida;
		this.idDependencia = idDependencia;
		this.abreviaturaDependencia = abreviaturaDependencia;
		this.nombreDependencia = nombreDependencia;
		this.idMateria = idMateria;
		this.descripcionMateria = descripcionMateria;
		this.idCanalAtencion = idCanalAtencion;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.tramiteConLlave = tramiteConLlave;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneModalidades = tieneModalidades;
		this.idEsTramiteServicio = Long.parseLong(idEsTramiteServicio.toString());
		this.sinonimoBusqueda = sinonimoBusqueda;
		this.descripcionTramite = descripcionTramite;
		this.descripcionUsuario =descripcionUsuario;
		this.descripcionCuidadana = descripcionCuidadana;
		this.areaAdministrativa = areaAdministrativa;
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdEtapaDeVida() {
		return idEtapaDeVida;
	}

	public void setIdEtapaDeVida(Long idEtapaDeVida) {
		this.idEtapaDeVida = idEtapaDeVida;
	}

	public String getDescripcionEtapaDeVida() {
		return descripcionEtapaDeVida;
	}

	public void setDescripcionEtapaDeVida(String descripcionEtapaDeVida) {
		this.descripcionEtapaDeVida = descripcionEtapaDeVida;
	}

	public Integer getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getAbreviaturaDependencia() {
		return abreviaturaDependencia;
	}

	public void setAbreviaturaDependencia(String abreviaturaDependencia) {
		this.abreviaturaDependencia = abreviaturaDependencia;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public Long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Long idMateria) {
		this.idMateria = idMateria;
	}

	public String getDescripcionMateria() {
		return descripcionMateria;
	}

	public void setDescripcionMateria(String descripcionMateria) {
		this.descripcionMateria = descripcionMateria;
	}

	public Boolean getPuedeRealizarseDigitalmente() {
		return puedeRealizarseDigitalmente;
	}

	public void setPuedeRealizarseDigitalmente(Boolean puedeRealizarseDigitalmente) {
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
	}

	public Long getIdCanalAtencion() {
		return idCanalAtencion;
	}

	public void setIdCanalAtencion(Long idCanalAtencion) {
		this.idCanalAtencion = idCanalAtencion;
	}

	public Boolean getPuedeRealizarsePresencialmente() {
		return puedeRealizarsePresencialmente;
	}

	public Boolean getPuedeRealizarseTelefonicamente() {
		return puedeRealizarseTelefonicamente;
	}

	public void setPuedeRealizarsePresencialmente(Boolean puedeRealizarsePresencialmente) {
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
	}

	public void setPuedeRealizarseTelefonicamente(Boolean puedeRealizarseTelefonicamente) {
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
	}

	public Boolean getTieneModalidades() {
		return tieneModalidades;
	}

	public void setTieneModalidades(Boolean tieneModalidades) {
		this.tieneModalidades = tieneModalidades;
	}

	public Long getIdEsTramiteServicio() {
		return idEsTramiteServicio;
	}

	public void setIdEsTramiteServicio(Long idEsTramiteServicio) {
		this.idEsTramiteServicio = idEsTramiteServicio;
	}

	public Boolean getTramiteConLlave() {
		return tramiteConLlave;
	}

	public void setTramiteConLlave(Boolean tramiteConLlave) {
		this.tramiteConLlave = tramiteConLlave;
	}

	public String getSinonimoBusqueda() {
		return sinonimoBusqueda;
	}

	public void setSinonimoBusqueda(String sinonimoBusqueda) {
		this.sinonimoBusqueda = sinonimoBusqueda;
	}

	public String getDescripcionCuidadana() {
		return descripcionCuidadana;
	}

	public void setDescripcionCuidadana(String descripcionCuidadana) {
		this.descripcionCuidadana = descripcionCuidadana;
	}

	public String getDescripcionUsuario() {
		return descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;

	}

	public String getDescripcionTramite() {
		return descripcionTramite;
	}

	public void setDescripcionTramite(String descripcionTramite) {
		this.descripcionTramite = descripcionTramite;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getContenidoManual() {
		return contenidoManual;
	}

	public void setContenidoManual(Boolean contenidoManual) {
		this.contenidoManual = contenidoManual;
	}

	public Boolean getProgramaSocial() {
		return programaSocial;
	}

	public void setProgramaSocial(Boolean programaSocial) {
		this.programaSocial = programaSocial;
	}

	public String getUrlPrograma() {
		return urlPrograma;
	}

	public void setUrlPrograma(String urlPrograma) {
		this.urlPrograma = urlPrograma;
	}

	public String getAreaAdministrativa() {
		return areaAdministrativa;
	}

	public void setAreaAdministrativa(String areaAdministrativa) {
		this.areaAdministrativa = areaAdministrativa;
	}

}