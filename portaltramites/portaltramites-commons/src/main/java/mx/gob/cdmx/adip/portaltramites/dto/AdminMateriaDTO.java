package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;

public class AdminMateriaDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1485829898633575177L;

	private Long id;
	private String descripcion;

	public AdminMateriaDTO() {
	}

	public AdminMateriaDTO(Long id) {
		this.id=id;
	}

	public AdminMateriaDTO(Long id, String descripcion) {	
		this.id=id;
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

}
