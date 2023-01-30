package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class TagsDTO implements Serializable {
	
	private static final long serialVersionUID = 5990897792416898633L;
	
	private Long idTag;
	private String tituloTag;
	private Integer orden;
	private Boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean situacion;		
	
	public TagsDTO() {
	
	}
	
	/** Buscar Por Criterios
	 * @param idTag
	 * @param tituloTag
	 * @param orden
	 * @param activo
	 * @param fechaCreacion
	 * @param fechaModificacion
	 * @param situacion
	 */
	
	public TagsDTO(Long idTag, String tituloTag, Integer orden, Boolean activo,  Boolean situacion, Date fechaCreacion) {
		this.idTag = idTag;
		this.tituloTag = tituloTag;
		this.orden = orden;
		this.activo = activo;		
		this.situacion = situacion;
		this.fechaCreacion = fechaCreacion;
	}
	
	/*
	 * Constructor para consulta Tag.consultaTop
	 */
	public TagsDTO(Long idTag, String tituloTag, Integer orden) {
		this.idTag = idTag;
		this.tituloTag = tituloTag;
		this.orden = orden;
	}

	public Long getIdTag() {
		return idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	public String getTituloTag() {
		return tituloTag;
	}

	public void setTituloTag(String tituloTag) {
		this.tituloTag = tituloTag;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
