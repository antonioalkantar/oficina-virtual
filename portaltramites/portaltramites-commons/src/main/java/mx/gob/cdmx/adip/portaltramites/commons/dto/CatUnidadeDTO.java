package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class CatUnidadeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6793027692791145282L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	
	public CatUnidadeDTO() {
		
	}
	
	public CatUnidadeDTO(Long id, String descripcion, Boolean situacion) {		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
	}

	public CatUnidadeDTO(Long idUnidad) {
		this.id = idUnidad;
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
