package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class DetEnlaceDTO implements Serializable {

	private static final long serialVersionUID = 1247267586791107618L;
	private Long id;
	private long orden;
	private String descripcion;
	private String enlace;
	private boolean estatus;
	private boolean visible;
	private Date fechaCreacion;
	private Date fechaModificacion;

	public DetEnlaceDTO() {
	}
	
	public DetEnlaceDTO(Long id, long orden, String descripcion, String enlace, boolean estatus, boolean visible, Date fechaCreacion,
			Date fechaModificacion) {
//		super();
		this.id = id;
		this.orden = orden;
		this.descripcion = descripcion;
		this.enlace = enlace;
		this.estatus = estatus;
		this.visible = visible;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getOrden() {
		return orden;
	}

	public void setOrden(long orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
