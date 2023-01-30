	package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cat_dependencias", schema = "portaltramitescdmx")
@NamedQueries({      
    @NamedQuery(name = "CatDependencias.findAllBack"
            ,query = "SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.CatDependenciasDTO"
                    + "( "
                    + "cd.idDependencia, " 
                    + "cd.nombreDependencia, " 
                    + "cd.situacion "
                    + ") "
                    + "FROM CatDependencias cd "
                    + "WHERE cd.situacion = true "
					+ "order by cd.nombreDependencia ASC")    				
})
public class CatDependencias implements Serializable {

	private static final long serialVersionUID = 3703651828787893359L;
	private Long idDependencia;
	private String abreviatura;
	private String nombreDependencia;
	private String urlSitioDependencia;
	private Date fechaCreacion;
	private boolean situacion;

	public CatDependencias() {

	}

	public CatDependencias(Long idDependencia) {
		this.idDependencia = idDependencia;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dependencia", unique = true, nullable = false)
	public Long getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(Long idDependencia) {
		this.idDependencia = idDependencia;
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

