
package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaPermisoResidentesDTO implements Serializable {

	private static final long serialVersionUID = -7300397534641617934L;

	private String idRegistroOrigen;
	private String folio;
	private String pathImagen;
	private String sistema;
	private String tipoTramite;
	private String placa;
	private String poligonoAutorizado;
	private String fechaVigencia;
	private Integer idEstatus;
	private String estatusDictaminador;
	private String documento;
	private Boolean documentoDisponible;

	public TarjetaPermisoResidentesDTO() {
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

	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPoligonoAutorizado() {
		return poligonoAutorizado;
	}

	public void setPoligonoAutorizado(String poligonoAutorizado) {
		this.poligonoAutorizado = poligonoAutorizado;
	}

	public String getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public String getEstatusDictaminador() {
		return estatusDictaminador;
	}

	public void setEstatusDictaminador(String estatusDictaminador) {
		this.estatusDictaminador = estatusDictaminador;
	}

	public Boolean getDocumentoDisponible() {
		return documentoDisponible;
	}

	public void setDocumentoDisponible(Boolean documentoDisponible) {
		this.documentoDisponible = documentoDisponible;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

}
