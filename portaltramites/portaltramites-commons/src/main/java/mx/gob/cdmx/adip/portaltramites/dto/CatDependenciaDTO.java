package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;
import java.util.Date;

public class CatDependenciaDTO implements Serializable {

	private static final long serialVersionUID = -7494902307017429540L;
	private Integer idDependencia;
	private String abreviatura;
	private Date fechaCreacion;
	private String nombreDependencia;
	private Boolean situacion;
	private String urlSitioDependencia;

	public CatDependenciaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CatDependenciaDTO(Integer idDependencia, String abreviatura, Date fechaCreacion, String nombreDependencia,
			Boolean situacion, String urlSitioDependencia) {
//		super();
		this.idDependencia = idDependencia;
		this.abreviatura = abreviatura;
		this.fechaCreacion = fechaCreacion;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
		this.urlSitioDependencia = urlSitioDependencia;
	}
	
	public CatDependenciaDTO(Integer idDependencia, String abreviatura, String nombreDependencia,
			Boolean situacion, String urlSitioDependencia) {
//		super();
		this.idDependencia = idDependencia;
		this.abreviatura = abreviatura;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
		this.urlSitioDependencia = urlSitioDependencia;
	}

	public CatDependenciaDTO(Integer idDependencia) {
//		super();
		this.idDependencia = idDependencia;
	}

	public CatDependenciaDTO(Integer idDependencia, String nombreDependencia) {
//		super();
		this.idDependencia = idDependencia;
		this.nombreDependencia = nombreDependencia;
	}

	public CatDependenciaDTO(Integer idDependencia, String nombreDependencia, Boolean situacion) {
//		super();
		this.idDependencia = idDependencia;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
	}
	
	

	public CatDependenciaDTO(Integer idDependencia, String abreviatura, String nombreDependencia, Boolean situacion) {
//		super();
		this.idDependencia = idDependencia;
		this.abreviatura = abreviatura;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
	}

	public Integer getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public String getUrlSitioDependencia() {
		return urlSitioDependencia;
	}

	public void setUrlSitioDependencia(String urlSitioDependencia) {
		this.urlSitioDependencia = urlSitioDependencia;
	}

}
