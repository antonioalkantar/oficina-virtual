package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatEstatusUnidadAdministrativaDTO implements Serializable {

	private static final long serialVersionUID = 8466325170363557991L;
	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatEstatusUnidadAdministrativaDTO() {
		// TODO Auto-generated constructor stub
	}

	public CatEstatusUnidadAdministrativaDTO(Long id) {
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
