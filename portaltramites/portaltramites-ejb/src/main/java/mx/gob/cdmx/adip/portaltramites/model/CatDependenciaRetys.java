package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cat_dependencia_retys", schema = "public")
public class CatDependenciaRetys implements Serializable{
	
	private static final long serialVersionUID = 2489392825572168868L;
	
	private Long idDependenciaRetys;
	private String abreviatura;
	private String nombreDependencia;
	private String urlSitioDependencia;
	private Date fechaCreacion;
	private boolean situacion;
	
	
	public CatDependenciaRetys() {
		
	}
	public CatDependenciaRetys(Long idDependenciaRetys, String nombreDependencia) {
		this.idDependenciaRetys = idDependenciaRetys;
		this.nombreDependencia = nombreDependencia;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_dependencia_retys", unique = true, nullable = false)
	public Long getIdDependenciaRetys() {
		return this.idDependenciaRetys;
	}

	public void setIdDependenciaRetys(Long idDependenciaRetys) {
		this.idDependenciaRetys = idDependenciaRetys;
	}
	
	
	@Column(name = "abreviatura", length = 200)
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	@Column(name = "nombre_dependencia", nullable = false, length = 3000)
	public String getNombreDependencia() {
		return this.nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}
	
	@Column(name = "url_sitio_dependencia", length = 512)
	public String getUrlSitioDependencia() {
		return this.urlSitioDependencia;
	}

	public void setUrlSitioDependencia(String urlSitioDependencia) {
		this.urlSitioDependencia = urlSitioDependencia;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", length = 13)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@Column(name = "situacion")
	public boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(boolean situacion) {
		this.situacion = situacion;
	}
	
	
	
}
