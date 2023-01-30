package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;

public class CatEtapaDeVidaDTO implements Serializable {

	private static final long serialVersionUID = 7622070742578211872L;
	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatEtapaDeVidaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CatEtapaDeVidaDTO(Long id, String descripcion, Boolean situacion) {
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
