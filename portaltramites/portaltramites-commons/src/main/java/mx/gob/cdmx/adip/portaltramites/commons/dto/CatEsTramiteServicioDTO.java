package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatEsTramiteServicioDTO implements Serializable {

	private static final long serialVersionUID = 8491877732364612996L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	//auxiliar movil
	private String descripcionMov;

	public CatEsTramiteServicioDTO() {
		// TODO Auto-generated constructor stub
	}

	public CatEsTramiteServicioDTO(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.descripcionMov = descripcion;
	}

	public CatEsTramiteServicioDTO(Long id, String descripcion, Boolean situacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.descripcionMov = descripcion;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public String getDescripcionMov() {
		return descripcionMov;
	}

	public void setDescripcionMov(String descripcionMov) {
		this.descripcionMov = descripcionMov;
	}
	
	
	
}
