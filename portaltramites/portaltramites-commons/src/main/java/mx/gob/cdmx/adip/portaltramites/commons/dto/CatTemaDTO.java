package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatTemaDTO implements Serializable {
	
	private static final long serialVersionUID = -7462395016645903501L; 
	
	private Long idCatTema;
	private String descripcion;
	private Long idCategoria;
	private Boolean situacion;
		
	public CatTemaDTO() {		
	}	
	//Consulta catalogo para el Backoffice
	public CatTemaDTO(Long idCatTema, String descripcion, Boolean situacion) {
		this.idCatTema = idCatTema;
		this.descripcion = descripcion;
		this.situacion = situacion;
	}

	public CatTemaDTO(Long idCatTema, String descripcion) {
		this.idCatTema = idCatTema;
		this.descripcion = descripcion;
	}

	public Long getIdCatTema() {
		return idCatTema;
	}

	public void setIdCatTema(Long idCatTema) {
		this.idCatTema = idCatTema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
