package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatTipoVialidadDTO implements Serializable {

	private static final long serialVersionUID = -5700339961006460735L;

	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatTipoVialidadDTO() {

	}

	public CatTipoVialidadDTO(Long id) {
		this.id = id;
	}

	public CatTipoVialidadDTO(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
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
