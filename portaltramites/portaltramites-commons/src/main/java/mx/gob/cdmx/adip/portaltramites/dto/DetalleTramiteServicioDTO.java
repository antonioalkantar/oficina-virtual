package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;

public class DetalleTramiteServicioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4221889167708616635L;
	private Long id;
	private String esTramiteServicio;
	private String descripcionTramite;
	private String descripcionUsuario;
	private String documentoBeneficio;
	private String tipoConcepto;
	private Long idCosto;
	private Long idFundamentoCosto;
	private String fundamentoCostos;
	private String articuloLeyReglamentoCostos;
	private String otraLeyCostos;
	private Long idUnidadVigencia;
	private String descripcionUnidadVigencia;
	private String vigencia;
	private Integer cantVigencia;
	private String tipoFicta;
/*	private String fundamentoTramite;
	private String articuloLeyReglamentoTramite;
	private String otraLeyTramite;*/
	private Boolean esResolucionInmediata;
	private Integer plazoResolver;
	private String descripcionUnidadPlazo;
	private Long idFormato;
	private Boolean medianteFormato;
	private Boolean requiereAgendarCitas;
	private Boolean puedeAgendarEnLinea;
	private String urlAgendarCita;
	private String otroBeneficio;
//	private String especificaOtra;
	private String informacionUtil;
	
	public DetalleTramiteServicioDTO () {
	}

	public DetalleTramiteServicioDTO (Long id, String esTramiteServicio, String descripcionTramite, String descripcionUsuario,
			String documentoBeneficio, String tipoConcepto, Long idCosto, Long idFundamentoCosto, String fundamentoCostos,
			String articuloLeyReglamentoCostos, String otraLeyCostos, Long idUnidadVigencia, String descripcionUnidadVigencia, 
			String vigencia,  String tipoFicta, /*String fundamentoTramite, String articuloLeyReglamentoTramite, String otraLeyTramite,*/
			Boolean esResolucionInmediata, Integer plazoResolver, String descripcionUnidadPlazo,
			Long idFormato, Boolean medianteFormato, Boolean requiereAgendarCitas, Boolean puedeAgendarEnLinea, String urlAgendarCita, Integer cantVig,
			String otroBeneficio, String especificaOtra, String informacionUtil) {
		this.id = id;
		this.esTramiteServicio = esTramiteServicio;
		this.descripcionTramite = descripcionTramite;
		this.descripcionUsuario = descripcionUsuario;
		this.documentoBeneficio =  documentoBeneficio != null &&  documentoBeneficio.equals("Otro") ? otroBeneficio : documentoBeneficio;
		this.tipoConcepto = tipoConcepto;
		this.idCosto = idCosto;
		this.idFundamentoCosto = idFundamentoCosto;
		this.fundamentoCostos = fundamentoCostos;
		this.articuloLeyReglamentoCostos = articuloLeyReglamentoCostos;
		this.otraLeyCostos = otraLeyCostos;
		this.idUnidadVigencia = idUnidadVigencia;
		this.descripcionUnidadVigencia = descripcionUnidadVigencia;
		this.cantVigencia = cantVig;
		//		this.vigencia = idUnidadVigencia != null && idUnidadVigencia.compareTo(0L) == 1 ? idUnidadVigencia.toString() + " " + descripcionUnidadVigencia : vigencia ;
		this.vigencia =  especificaOtra != null ? especificaOtra : cantVig != null ?  cantVig.toString()  + " " + descripcionUnidadVigencia : vigencia;
		this.tipoFicta = tipoFicta;
/*		this.fundamentoTramite = fundamentoTramite;
		this.articuloLeyReglamentoTramite = articuloLeyReglamentoTramite;
		this.otraLeyTramite = otraLeyTramite;*/
		this.esResolucionInmediata = esResolucionInmediata;
		this.plazoResolver = plazoResolver;
		this.descripcionUnidadPlazo = descripcionUnidadPlazo;
		this.idFormato = idFormato;
		this.medianteFormato = medianteFormato;
		this.requiereAgendarCitas = requiereAgendarCitas; 
		this.puedeAgendarEnLinea = puedeAgendarEnLinea; 
		this.urlAgendarCita = urlAgendarCita;
		this.otroBeneficio = otroBeneficio == null  ? "" : otroBeneficio;
		this.informacionUtil = informacionUtil;
	}

	public Long getId() {
		return id;
	}

	public String getEsTramiteServicio() {
		return esTramiteServicio;
	}

	public String getDescripcionTramite() {
		return descripcionTramite;
	}

	public String getDescripcionUsuario() {
		return descripcionUsuario;
	}

	public String getDocumentoBeneficio() {
		return documentoBeneficio;
	}

	public String getTipoConcepto() {
		return tipoConcepto;
	}

	public String getFundamentoCostos() {
		return fundamentoCostos;
	}

	public String getArticuloLeyReglamentoCostos() {
		return articuloLeyReglamentoCostos;
	}

	public String getOtraLeyCostos() {
		return otraLeyCostos;
	}

	public String getVigencia() {
		return vigencia;
	}

	public String getTipoFicta() {
		return tipoFicta;
	}
/*
	public String getFundamentoTramite() {
		return fundamentoTramite;
	}

	public String getArticuloLeyReglamentoTramite() {
		return articuloLeyReglamentoTramite;
	}

	public String getOtraLeyTramite() {
		return otraLeyTramite;
	}
*/
	public void setId(Long id) {
		this.id = id;
	}

	public void setEsTramiteServicio(String esTramiteServicio) {
		this.esTramiteServicio = esTramiteServicio;
	}

	public void setDescripcionTramite(String descripcionTramite) {
		this.descripcionTramite = descripcionTramite;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
	}

	public void setDocumentoBeneficio(String documentoBeneficio) {
		this.documentoBeneficio = documentoBeneficio;
	}

	public void setTipoConcepto(String tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}

	public void setFundamentoCostos(String fundamentoCostos) {
		this.fundamentoCostos = fundamentoCostos;
	}

	public void setArticuloLeyReglamentoCostos(String articuloLeyReglamentoCostos) {
		this.articuloLeyReglamentoCostos = articuloLeyReglamentoCostos;
	}

	public void setOtraLeyCostos(String otraLeyCostos) {
		this.otraLeyCostos = otraLeyCostos;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public void setTipoFicta(String tipoFicta) {
		this.tipoFicta = tipoFicta;
	}
/*
	public void setFundamentoTramite(String fundamentoTramite) {
		this.fundamentoTramite = fundamentoTramite;
	}

	public void setArticuloLeyReglamentoTramite(String articuloLeyReglamentoTramite) {
		this.articuloLeyReglamentoTramite = articuloLeyReglamentoTramite;
	}

	public void setOtraLeyTramite(String otraLeyTramite) {
		this.otraLeyTramite = otraLeyTramite;
	}
*/
	public Boolean getEsResolucionInmediata() {
		return esResolucionInmediata;
	}

	public Integer getPlazoResolver() {
		return plazoResolver;
	}

	public String getDescripcionUnidadPlazo() {
		return descripcionUnidadPlazo;
	}

	public void setEsResolucionInmediata(Boolean esResolucionInmediata) {
		this.esResolucionInmediata = esResolucionInmediata;
	}

	public void setPlazoResolver(Integer plazoResolver) {
		this.plazoResolver = plazoResolver;
	}

	public void setDescripcionUnidadPlazo(String descripcionUnidadPlazo) {
		this.descripcionUnidadPlazo = descripcionUnidadPlazo;
	}

	public Boolean getMedianteFormato() {
		return medianteFormato;
	}

	public void setMedianteFormato(Boolean medianteFormato) {
		this.medianteFormato = medianteFormato;
	}

	public Long getIdFormato() {
		return idFormato;
	}

	public void setIdFormato(Long idFormato) {
		this.idFormato = idFormato;
	}

	public Long getIdCosto() {
		return idCosto;
	}

	public void setIdCosto(Long idCosto) {
		this.idCosto = idCosto;
	}

	public Long getIdFundamentoCosto() {
		return idFundamentoCosto;
	}

	public void setIdFundamentoCosto(Long idFundamentoCosto) {
		this.idFundamentoCosto = idFundamentoCosto;
	}

	public Long getIdUnidadVigencia() {
		return idUnidadVigencia;
	}

	public void setIdUnidadVigencia(Long idUnidadVigencia) {
		this.idUnidadVigencia = idUnidadVigencia;
	}

	public String getDescripcionUnidadVigencia() {
		return descripcionUnidadVigencia;
	}

	public void setDescripcionUnidadVigencia(String descripcionUnidadVigencia) {
		this.descripcionUnidadVigencia = descripcionUnidadVigencia;
	}

	public Boolean getRequiereAgendarCitas() {
		return requiereAgendarCitas;
	}

	public void setRequiereAgendarCitas(Boolean requiereAgendarCitas) {
		this.requiereAgendarCitas = requiereAgendarCitas;
	}

	public Boolean getPuedeAgendarEnLinea() {
		return puedeAgendarEnLinea;
	}

	public void setPuedeAgendarEnLinea(Boolean puedeAgendarEnLinea) {
		this.puedeAgendarEnLinea = puedeAgendarEnLinea;
	}

	public String getUrlAgendarCita() {
		return urlAgendarCita;
	}

	public void setUrlAgendarCita(String urlAgendarCita) {
		this.urlAgendarCita = urlAgendarCita;
	}
	
	public String getObtenerFundamentoCosto() {
		return this.idFundamentoCosto != null && this.idFundamentoCosto != 0L ? this.fundamentoCostos : "";
	}

	public Integer getCantVigencia() {
		return cantVigencia;
	}

	public void setCantVigencia(Integer cantVigencia) {
		this.cantVigencia = cantVigencia;
	}

	public String getOtroBeneficio() {
		return otroBeneficio;
	}

	public void setOtroBeneficio(String otroBeneficio) {
		this.otroBeneficio = otroBeneficio;
	}

	public String getInformacionUtil() {
		return informacionUtil;
	}

	public void setInformacionUtil(String informacionUtil) {
		this.informacionUtil = informacionUtil;
	}
	

}
