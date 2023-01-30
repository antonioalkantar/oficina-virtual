package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetEncabezadoDTO implements Serializable {

	private static final long serialVersionUID = -1504037432823166635L;

	private Long id;
	private String descripcion_encabezado;
	private String link_encabezado;
	private String background;
	private Long orden;
	private boolean situacion;
	private boolean estatus;

	public DetEncabezadoDTO() {
	}

	public DetEncabezadoDTO(Long id, String descripcion_encabezado, String link_encabezado, String background,
			Long orden, boolean situacion) {
		this.id = id;
		this.descripcion_encabezado = descripcion_encabezado;
		this.link_encabezado = link_encabezado;
		this.background = background;
		this.orden = orden;
		this.situacion = situacion;
	}
	
	public DetEncabezadoDTO(Long id, String descripcion_encabezado, String link_encabezado, String background,
			Long orden, boolean situacion, boolean estatus) {
		this.id = id;
		this.descripcion_encabezado = descripcion_encabezado;
		this.link_encabezado = link_encabezado;
		this.background = background;
		this.orden = orden;
		this.situacion = situacion;
		this.estatus = estatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion_encabezado() {
		return descripcion_encabezado;
	}

	public void setDescripcion_encabezado(String descripcion_encabezado) {
		this.descripcion_encabezado = descripcion_encabezado;
	}

	public String getLink_encabezado() {
		return link_encabezado;
	}

	public void setLink_encabezado(String link_encabezado) {
		this.link_encabezado = link_encabezado;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public boolean isSituacion() {
		return situacion;
	}

	public void setSituacion(boolean situacion) {
		this.situacion = situacion;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
