package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class CatTipoFuncionalidadDTO implements Serializable {
	
	private static final long serialVersionUID = -3999867420476579871L;
	
	private Integer idTipoFuncionalidad;
	private String descripcion;
	private boolean activo;
	public CatTipoFuncionalidadDTO() {}
	
	public CatTipoFuncionalidadDTO(Integer idTipoFuncionalidad, String descripcion, boolean activo) {		
		this.idTipoFuncionalidad = idTipoFuncionalidad;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public CatTipoFuncionalidadDTO(Integer idTipoFuncionalidad, String descripcion) {		
		this.idTipoFuncionalidad = idTipoFuncionalidad;
		this.descripcion = descripcion;
	}

	public Integer getIdTipoFuncionalidad() {
		return idTipoFuncionalidad;
	}

	public void setIdTipoFuncionalidad(Integer idTipoFuncionalidad) {
		this.idTipoFuncionalidad = idTipoFuncionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
