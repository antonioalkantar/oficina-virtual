package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the cat_dependencia database table.
 * 
 */
@Entity
@Table(name="cat_dependencia", schema = "retys_v2")
@NamedQueries({
    @NamedQuery(name="CatDependencia.findAll"
            ,query="SELECT new mx.gob.cdmx.adip.portaltramites.dto.CatDependenciaDTO"
                    + "(t.idDependencia " + 
                    ", t.abreviatura " + 
                    ", t.nombreDependencia " + 
                    ", t.situacion " + 
                    ", t.urlSitioDependencia) " + 
                    " FROM CatDependencia  t "
                    + " WHERE t.situacion = true "
                    + " AND t.idDependencia <> 112 "
                    + " ORDER BY t.nombreDependencia")
})
public class CatDependencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idDependencia;
	private String abreviatura;
	private Date fechaCreacion;
	private String nombreDependencia;
	private Boolean situacion;
	private String urlSitioDependencia;

	public CatDependencia() {
	}
	
	public CatDependencia(int idDependencia) {
		this.idDependencia=idDependencia;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_dependencia")
	public Integer getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name="nombre_dependencia")
	public String getNombreDependencia() {
		return this.nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@Column(name="url_sitio_dependencia")
	public String getUrlSitioDependencia() {
		return this.urlSitioDependencia;
	}

	public void setUrlSitioDependencia(String urlSitioDependencia) {
		this.urlSitioDependencia = urlSitioDependencia;
	}

}