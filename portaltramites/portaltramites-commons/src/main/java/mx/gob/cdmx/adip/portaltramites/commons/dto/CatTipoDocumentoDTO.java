package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatTipoDocumentoDTO implements Serializable {

	private static final long serialVersionUID = -4620516123294628357L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	
	public CatTipoDocumentoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CatTipoDocumentoDTO(Long id, String descripcion, Boolean situacion) {
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
