package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;



public class CatTipoHorarioDTO  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481532742891048851L;	
	
	private Long id;	
	private String descripcion;
	private Boolean situacion;
	
	private List<DetHorariosTelefonosDTO> detHorariosTelefonos;
	
	
	public CatTipoHorarioDTO() {}
	public CatTipoHorarioDTO(Long id, String descripcion	) {		
		this.id = id;
		this.descripcion = descripcion;
		
	
	}
	
	public CatTipoHorarioDTO(Long id, String descripcion, Boolean situacion
			) {		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
	
	}
	
	public CatTipoHorarioDTO(Long id, String descripcion, Boolean situacion,
			List<DetHorariosTelefonosDTO> detHorariosTelefonos) {
		
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detHorariosTelefonos = detHorariosTelefonos;
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


	public List<DetHorariosTelefonosDTO> getDetHorariosTelefonos() {
		return detHorariosTelefonos;
	}


	public void setDetHorariosTelefonos(List<DetHorariosTelefonosDTO> detHorariosTelefonos) {
		this.detHorariosTelefonos = detHorariosTelefonos;
	}

}
