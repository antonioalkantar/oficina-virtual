package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaActaDigitalDTO implements Serializable {

	private static final long serialVersionUID = 6529785078464750868L;

	private String idRegistroOrigen;
	private String folio;
	private String tipoTramite;
	private String fechaSolicitud;
	private String numeroActa;
	private Boolean descargaHabilitada;
	private String nombreDocumento;
	private String documento;
	private String linkRedirect;
	private String linkDocumento;
	private String titular;
	private String segundoTitular;
	private String fechaVencimiento;
	private Integer idEstatus;
	private String estatus;
	private String pathImagen;
	
	
	public TarjetaActaDigitalDTO() {
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getNumeroActa() {
		return numeroActa;
	}

	public void setNumeroActa(String numeroActa) {
		this.numeroActa = numeroActa;
	}

	public Boolean getDescargaHabilitada() {
		return descargaHabilitada;
	}

	public void setDescargaHabilitada(Boolean descargaHabilitada) {
		this.descargaHabilitada = descargaHabilitada;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getLinkRedirect() {
		return linkRedirect;
	}

	public void setLinkRedirect(String linkRedirect) {
		this.linkRedirect = linkRedirect;
	}

	public String getLinkDocumento() {
		return linkDocumento;
	}

	public void setLinkDocumento(String linkDocumento) {
		this.linkDocumento = linkDocumento;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getSegundoTitular() {
		return segundoTitular;
	}

	public void setSegundoTitular(String segundoTitular) {
		this.segundoTitular = segundoTitular;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getIdRegistroOrigen() {
		return idRegistroOrigen;
	}

	public void setIdRegistroOrigen(String idRegistroOrigen) {
		this.idRegistroOrigen = idRegistroOrigen;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

}
