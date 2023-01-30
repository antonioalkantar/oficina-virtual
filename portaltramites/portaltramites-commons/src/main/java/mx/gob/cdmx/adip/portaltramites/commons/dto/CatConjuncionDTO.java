package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatConjuncionDTO implements Serializable {

	private static final long serialVersionUID = -4494570244673982474L;
	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatConjuncionDTO() {
		// TODO Auto-generated constructor stub
	}

	public CatConjuncionDTO(Long id) {
		super();
		this.id = id;
	}

	public CatConjuncionDTO(Long id, String descripcion, Boolean situacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
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
