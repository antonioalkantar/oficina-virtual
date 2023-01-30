package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatLeyeDTO implements Serializable {

	private static final long serialVersionUID = -8944336367784580738L;
	
	private Long id;
	private String nombre;
	private Boolean situacion;

	public CatLeyeDTO() {
		// TODO Auto-generated constructor stub
	}
	public CatLeyeDTO(Long id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
		
	}

	public CatLeyeDTO(Long id, String nombre, Boolean situacion) {
		
		this.id = id;
		this.nombre = nombre;
		this.situacion = situacion;
	}

	public CatLeyeDTO(Long id) {
		this.id = id;
	}

	public CatLeyeDTO(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
