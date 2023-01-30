package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaSuacDTO implements Serializable {

	private static final long serialVersionUID = 652221667856396692L;

	private String idRegistroOrigen;
	private String folio;
	private String descripcionSolicitud;
	private String alcaldiaSolicitud;
	private String atiende;
	private Integer idEstatus;
	private String estatus;
	private String pathImagen;
	private String sistema;

	public TarjetaSuacDTO() {
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

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public String getAlcaldiaSolicitud() {
		return alcaldiaSolicitud;
	}

	public void setAlcaldiaSolicitud(String alcaldiaSolicitud) {
		this.alcaldiaSolicitud = alcaldiaSolicitud;
	}

	public String getAtiende() {
		return atiende;
	}

	public void setAtiende(String atiende) {
		this.atiende = atiende;
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
