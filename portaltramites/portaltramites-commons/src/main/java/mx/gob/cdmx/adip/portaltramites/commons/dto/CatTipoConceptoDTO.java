package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;

public class CatTipoConceptoDTO implements Serializable {

	private static final long serialVersionUID = 1342095783970807949L;

	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatTipoConceptoDTO() {
		
	}
	
	public CatTipoConceptoDTO(Long id, String descripcion, Boolean situacion) {		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
	}

	public CatTipoConceptoDTO(long id) {
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
