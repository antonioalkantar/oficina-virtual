package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;




public class CatDiaSemanaDTO  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481532742891048851L;	
	

	
	private Long id;
	private String descripcion;
	private Boolean situacion;	
	private List<DetHorariosLugareDTO> detHorariosLugares;

	
	public CatDiaSemanaDTO() {}

	public CatDiaSemanaDTO(Long id) {
		this.id = id;
	}
	public CatDiaSemanaDTO(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	
	public CatDiaSemanaDTO( String descripcion, Boolean situacion,
			List<DetHorariosLugareDTO> detHorariosLugares) {		
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detHorariosLugares = detHorariosLugares;
	}
	

	public CatDiaSemanaDTO(Long id, String descripcion, Boolean situacion,
			List<DetHorariosLugareDTO> detHorariosLugares) {
	
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detHorariosLugares = detHorariosLugares;
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


	public List<DetHorariosLugareDTO> getDetHorariosLugares() {
		return detHorariosLugares;
	}


	public void setDetHorariosLugares(List<DetHorariosLugareDTO> detHorariosLugares) {
		this.detHorariosLugares = detHorariosLugares;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
