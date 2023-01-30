package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CatDependenciasDTO implements Serializable {

	private static final long serialVersionUID = -7494902307017429540L;
	private Long idDependencia;
	private String abreviatura;
	private Date fechaCreacion;
	private String nombreDependencia;
	private Boolean situacion;
	private String urlSitioDependencia;

	public CatDependenciasDTO() {		
	}
	
	public CatDependenciasDTO(Long idDependencia, String abreviatura, Date fechaCreacion, String nombreDependencia,
			Boolean situacion, String urlSitioDependencia) {
		this.idDependencia = idDependencia;
		this.abreviatura = abreviatura;
		this.fechaCreacion = fechaCreacion;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
		this.urlSitioDependencia = urlSitioDependencia;
	}

	public CatDependenciasDTO(Long idDependencia) {
		this.idDependencia = idDependencia;
	}

	public CatDependenciasDTO(Long idDependencia, String nombreDependencia) {
		this.idDependencia = idDependencia;
		this.nombreDependencia = nombreDependencia;
	}
	
	//Consulta de catalogo  para el Backoffice
	public CatDependenciasDTO(Long idDependencia, String nombreDependencia, Boolean situacion) {
		this.idDependencia = idDependencia;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
	}
	
	

	public CatDependenciasDTO(Long idDependencia, String abreviatura, String nombreDependencia, Boolean situacion) {
		this.idDependencia = idDependencia;
		this.abreviatura = abreviatura;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
	}
	
	

	public CatDependenciasDTO(Long idDependencia, String abreviatura, String nombreDependencia, Boolean situacion,
			String urlSitioDependencia) {
		this.idDependencia = idDependencia;
		this.abreviatura = abreviatura;
		this.nombreDependencia = nombreDependencia;
		this.situacion = situacion;
		this.urlSitioDependencia = urlSitioDependencia;
	}

	public Long getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Long idDependencia) {
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
