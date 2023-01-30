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
@Table(name = "det_archivo_fondo", schema="portaltramitescdmx")
@NamedQueries({
	@NamedQuery(name = "DetArchivoFondo.findAll", query = "SELECT d FROM DetArchivoFondo d"),
	@NamedQuery(name = "DetArchivoFondo.findByEstatus", query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO"
			+ "("
			+ "d.id,"
			+ "d.nombre_archivo,"
			+ "d.ruta_archivo,"
			+ "d.estatus,"
			+ "d.situacion,"
			+ "d.fechaCreacion,"
			+ "d.fechaModificacion"
			+ ")"
			+ " FROM DetArchivoFondo d"
			+ " WHERE d.estatus = TRUE"
			+ " AND d.esEscritorio = TRUE"
			+ " ORDER BY d.situacion DESC, d.fechaModificacion DESC"),
	@NamedQuery(name = "DetArchivoFondo.findByEstatusMobile", query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO"
			+ "("
			+ "d.id,"
			+ "d.nombre_archivo,"
			+ "d.ruta_archivo,"
			+ "d.estatus,"
			+ "d.situacion,"
			+ "d.fechaCreacion,"
			+ "d.fechaModificacion"
			+ ")"
			+ " FROM DetArchivoFondo d"
			+ " WHERE d.estatus = TRUE"
			+ " AND d.esEscritorio = FALSE"
			+ " ORDER BY d.situacion DESC, d.fechaModificacion DESC"),
	@NamedQuery(name = "DetArchivoFondo.findBySituacion", query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO"
			+ "("
			+ "d.id,"
			+ "d.nombre_archivo,"
			+ "d.ruta_archivo,"
			+ "d.estatus,"
			+ "d.situacion,"
			+ "d.fechaCreacion,"
			+ "d.fechaModificacion"
			+ ")"
			+ " FROM DetArchivoFondo d"
			+ " WHERE d.estatus = TRUE"
			+ " AND d.situacion = TRUE"
			+ " AND d.esEscritorio = TRUE"
			+ " ORDER BY d.situacion DESC, d.fechaModificacion DESC"),
	
	@NamedQuery(name = "DetArchivoFondo.findBySituacionMobile", query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO"
			+ "("
			+ "d.id,"
			+ "d.nombre_archivo,"
			+ "d.ruta_archivo,"
			+ "d.estatus,"
			+ "d.situacion,"
			+ "d.fechaCreacion,"
			+ "d.fechaModificacion"
			+ ")"
			+ " FROM DetArchivoFondo d"
			+ " WHERE d.estatus = TRUE"
			+ " AND d.situacion = TRUE"
			+ " AND d.esEscritorio = FALSE"
			+ " ORDER BY d.situacion DESC, d.fechaModificacion DESC")
})
public class DetArchivoFondo implements Serializable {

	private static final long serialVersionUID = 2445624575444816604L;
	private Long id;
	private String nombre_archivo;
	private String ruta_archivo;
	private boolean estatus;
	private boolean situacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private boolean esEscritorio;
	

	public DetArchivoFondo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}

	public String getRuta_archivo() {
		return ruta_archivo;
	}

	public void setRuta_archivo(String ruta_archivo) {
		this.ruta_archivo = ruta_archivo;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public boolean isSituacion() {
		return situacion;
	}

	public void setSituacion(boolean situacion) {
		this.situacion = situacion;
	}
	
	@Column(name = "es_escritorio")
	public boolean isEsEscritorio() {
		return esEscritorio;
	}	
	public void setEsEscritorio(boolean esEscritorio) {
		this.esEscritorio = esEscritorio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion")
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
