package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.util.List;


public class DetFormatoDTO {

	
	private Long id;
	private Boolean medianteFormato;
	private String observaciones;
	private String otraPresentacion;
	private String otroBeneficio;
	private Boolean requisitosNoParteFormato;
	private Boolean situacion;
//	private List<DetArchivosAdjuntosTramiteDTO> detArchivosAdjuntosTramites;
	private List<DetArchivosFormatoTramiteDTO> detArchivosFormatoTramites;
	private CatDocumentoBeneficioDTO catDocumentoBeneficio;
//	private CatTipoPresentacionDTO catTipoPresentacion;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private TramiteServicioDTO tramiteServicio;
	private List<DetRequisitosFormatoDTO> detRequisitosFormatos;
	
	public DetFormatoDTO() {
		this.catDocumentoBeneficio = new CatDocumentoBeneficioDTO();
//		this.catTipoPresentacion  = new CatTipoPresentacionDTO();	
	}
	
	public DetFormatoDTO(Long id, Boolean medianteFormato ,String observaciones, Boolean requisitosNoParteFormato, Long catDocumentoBeneficio, Long catTipoPresentacion, String despresentacion, String desbeneficio , String otroBeneficio, String otraPresentacion ) {
	this.id = id;
	this.medianteFormato = medianteFormato;
	this.observaciones = observaciones;
	this.requisitosNoParteFormato = requisitosNoParteFormato;
	this.catDocumentoBeneficio = new CatDocumentoBeneficioDTO(catDocumentoBeneficio,desbeneficio,Boolean.TRUE);
//	this.catTipoPresentacion  = new CatTipoPresentacionDTO(catTipoPresentacion,despresentacion,Boolean.TRUE);
	this.otroBeneficio = otroBeneficio;
	this.otraPresentacion = otraPresentacion;
	} 
	
	
	public DetFormatoDTO(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getMedianteFormato() {
		return medianteFormato;
	}
	public void setMedianteFormato(Boolean medianteFormato) {
		this.medianteFormato = medianteFormato;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Boolean getRequisitosNoParteFormato() {
		return requisitosNoParteFormato;
	}
	public void setRequisitosNoParteFormato(Boolean requisitosNoParteFormato) {
		this.requisitosNoParteFormato = requisitosNoParteFormato;
	}
	public Boolean getSituacion() {
		return situacion;
	}
	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

//	public List<DetArchivosAdjuntosTramiteDTO> getDetArchivosAdjuntosTramites() {
//		return detArchivosAdjuntosTramites;
//	}
//	public void setDetArchivosAdjuntosTramites(List<DetArchivosAdjuntosTramiteDTO> detArchivosAdjuntosTramites) {
//		this.detArchivosAdjuntosTramites = detArchivosAdjuntosTramites;
//	}
	public List<DetArchivosFormatoTramiteDTO> getDetArchivosFormatoTramites() {
		return detArchivosFormatoTramites;
	}
	public void setDetArchivosFormatoTramites(List<DetArchivosFormatoTramiteDTO> detArchivosFormatoTramites) {
		this.detArchivosFormatoTramites = detArchivosFormatoTramites;
	}
	public CatDocumentoBeneficioDTO getCatDocumentoBeneficio() {
		return catDocumentoBeneficio;
	}
	public void setCatDocumentoBeneficio(CatDocumentoBeneficioDTO catDocumentoBeneficio) {
		this.catDocumentoBeneficio = catDocumentoBeneficio;
	}
//	public CatTipoPresentacionDTO getCatTipoPresentacion() {
//		return catTipoPresentacion;
//	}
//	public void setCatTipoPresentacion(CatTipoPresentacionDTO catTipoPresentacion) {
//		this.catTipoPresentacion = catTipoPresentacion;
//	}
	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}
	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}
	public TramiteServicioDTO getTramiteServicio() {
		return tramiteServicio;
	}
	public void setTramiteServicio(TramiteServicioDTO tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}
	public List<DetRequisitosFormatoDTO> getDetRequisitosFormatos() {
		return detRequisitosFormatos;
	}
	public void setDetRequisitosFormatos(List<DetRequisitosFormatoDTO> detRequisitosFormatos) {
		this.detRequisitosFormatos = detRequisitosFormatos;
	}

	public String getOtraPresentacion() {
		return otraPresentacion;
	}

	public void setOtraPresentacion(String otraPresentacion) {
		this.otraPresentacion = otraPresentacion;
	}

	public String getOtroBeneficio() {
		return otroBeneficio;
	}

	public void setOtroBeneficio(String otroBeneficio) {
		this.otroBeneficio = otroBeneficio;
	}
	
}
