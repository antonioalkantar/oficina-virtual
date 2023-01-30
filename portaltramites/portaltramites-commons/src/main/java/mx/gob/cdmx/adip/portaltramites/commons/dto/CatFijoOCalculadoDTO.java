package mx.gob.cdmx.adip.portaltramites.commons.dto;


public class CatFijoOCalculadoDTO {

	private Long id;
	private String descripcion;
	private Boolean situacion;
	
	public CatFijoOCalculadoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CatFijoOCalculadoDTO(Long id, String descripcion, Boolean situacion) {
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
	}

	public CatFijoOCalculadoDTO(long id) {
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
