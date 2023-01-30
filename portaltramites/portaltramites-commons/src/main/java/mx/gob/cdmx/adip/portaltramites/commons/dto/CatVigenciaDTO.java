package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatVigenciaDTO  implements Serializable {

	private static final long serialVersionUID = -8944336367784580738L;
	
	
	private Long id;
	private String descripcion;
	private Boolean situacion;
	
	
	public CatVigenciaDTO() {				
	}
	
	public CatVigenciaDTO(Long id, String descripcion) {		
		this.id = id;
		this.descripcion = descripcion;		
	}
	
	public CatVigenciaDTO(Long id, String descripcion, Boolean situacion) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
	}
	
	public CatVigenciaDTO(Long id) {
		super();
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
