package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class CatTipoFictaDTO implements Serializable {
	
	private static final long serialVersionUID = -4409680991279825285L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
		
	public CatTipoFictaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CatTipoFictaDTO(Long id, String descripcion, Boolean situacion) {
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
	}
	
	

	public CatTipoFictaDTO(Long id) {
		
		this.id = id;
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
	
}
