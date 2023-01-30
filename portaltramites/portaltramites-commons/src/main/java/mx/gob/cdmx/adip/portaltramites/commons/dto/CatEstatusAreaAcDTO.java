package mx.gob.cdmx.adip.portaltramites.commons.dto;


import java.io.Serializable;
import java.util.List;



public class CatEstatusAreaAcDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905747436822832399L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<CatAreaAcDTO> catAreaAcs;
	
	public CatEstatusAreaAcDTO() {}
	
	public CatEstatusAreaAcDTO(Long id, String descripcion) {
    this.id = id;
	this.descripcion = descripcion;
	}
	
	
	public CatEstatusAreaAcDTO(String descripcion, Boolean situacion, List<CatAreaAcDTO> catAreaAcs) {
		
		
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.catAreaAcs = catAreaAcs;
	}
	
	public CatEstatusAreaAcDTO(Long id, String descripcion, Boolean situacion, List<CatAreaAcDTO> catAreaAcs) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.catAreaAcs = catAreaAcs;
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
	public List<CatAreaAcDTO> getCatAreaAcs() {
		return catAreaAcs;
	}
	public void setCatAreaAcs(List<CatAreaAcDTO> catAreaAcs) {
		this.catAreaAcs = catAreaAcs;
	}
	
	
	
	
	
}
