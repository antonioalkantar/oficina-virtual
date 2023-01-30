package mx.gob.cdmx.adip.sibis.dto;

import java.io.Serializable;
import java.util.Date;

public class CatDependenciaRetysDTO implements Serializable {
	
	private static final long serialVersionUID = 6556096752958917253L;
	
	private Long idDependenciaRetys;
	private String abreviatura;
	private String nombreDependencia;
	private String urlSitioDependencia;
	private Date fechaCreacion;
	private boolean situacion;
		
	public CatDependenciaRetysDTO() {
		
	}
	
	public CatDependenciaRetysDTO(Long idDependenciaRetys, String nombreDependencia) {
		this.idDependenciaRetys = idDependenciaRetys;
		this.nombreDependencia = nombreDependencia;
	}
	
	public Long getIdDependenciaRetys() {
		return idDependenciaRetys;
	}
	public void setIdDependenciaRetys(Long idDependenciaRetys) {
		this.idDependenciaRetys = idDependenciaRetys;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public String getNombreDependencia() {
		return nombreDependencia;
	}
	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}
	public String getUrlSitioDependencia() {
		return urlSitioDependencia;
	}
	public void setUrlSitioDependencia(String urlSitioDependencia) {
		this.urlSitioDependencia = urlSitioDependencia;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isSituacion() {
		return situacion;
	}
	public void setSituacion(boolean situacion) {
		this.situacion = situacion;
	}
	
	
}
