package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaDescuentoAguaDTO implements Serializable {

	private static final long serialVersionUID = 4612833710339055032L;

	private String idRegistroOrigen;
	private String folio;
	private String numeroCuentaRecibo;
	private Boolean nuevoRegistro;
	private String fechaVencimiento;
	private Integer idEstatus;
	private String estatus;
	private String pathImagen;
	private String sistema;

	public TarjetaDescuentoAguaDTO() {
	}

	public String getIdRegistroOrigen() {
		return idRegistroOrigen;
	}

	public void setIdRegistroOrigen(String idRegistroOrigen) {
		this.idRegistroOrigen = idRegistroOrigen;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNumeroCuentaRecibo() {
		return numeroCuentaRecibo;
	}

	public void setNumeroCuentaRecibo(String numeroCuentaRecibo) {
		this.numeroCuentaRecibo = numeroCuentaRecibo;
	}

	public Boolean getNuevoRegistro() {
		return nuevoRegistro;
	}

	public void setNuevoRegistro(Boolean nuevoRegistro) {
		this.nuevoRegistro = nuevoRegistro;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

}
