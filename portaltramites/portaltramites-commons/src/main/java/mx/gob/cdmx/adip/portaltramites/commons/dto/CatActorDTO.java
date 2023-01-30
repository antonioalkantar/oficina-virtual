package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;



public class CatActorDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905747436822832399L;
	
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetPasosRegistradoDTO> detPasosRegistrados;
	
	
	
	public CatActorDTO() {		
		
	}

	public CatActorDTO(Long id) {		
		this.id = id;
	}
	public CatActorDTO(Long id, String descripcion) {		
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public CatActorDTO(Long id, String descripcion, Boolean situacion,
			List<DetPasosRegistradoDTO> detPasosRegistrados) {		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detPasosRegistrados = detPasosRegistrados;
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
	public List<DetPasosRegistradoDTO> getDetPasosRegistrados() {
		return detPasosRegistrados;
	}
	public void setDetPasosRegistrados(List<DetPasosRegistradoDTO> detPasosRegistrados) {
		this.detPasosRegistrados = detPasosRegistrados;
	}
	
	
	
	
}
