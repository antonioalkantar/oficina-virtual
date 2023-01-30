package mx.gob.cdmx.adip.sibis.dto;

import java.io.Serializable;
import java.util.Date;

public class CategoriasDTO implements Serializable {
	
	private static final long serialVersionUID = -1927205360129643582L;
	
	private long id;
	private String descripcion;
	private Date createdAt;
	private Date updatedAt;
	
	public CategoriasDTO() {}

	public CategoriasDTO(long id, String descripcion) {		
		this.id = id;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	

}
