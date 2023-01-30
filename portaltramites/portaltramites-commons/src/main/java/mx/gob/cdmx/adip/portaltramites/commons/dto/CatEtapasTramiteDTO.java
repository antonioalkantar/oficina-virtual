package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatEtapasTramiteDTO implements Serializable {

	private static final long serialVersionUID = 9077427709096100314L;
	private Long id;
	private String descripcion;
	private Boolean esProcesoFinal;
	private Boolean situacion;

	public CatEtapasTramiteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CatEtapasTramiteDTO(Long id) {
		this.id = id;
		
	}

	public CatEtapasTramiteDTO(Long id, String descripcion) {
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

	public Boolean getEsProcesoFinal() {
		return esProcesoFinal;
	}

	public void setEsProcesoFinal(Boolean esProcesoFinal) {
		this.esProcesoFinal = esProcesoFinal;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
}
