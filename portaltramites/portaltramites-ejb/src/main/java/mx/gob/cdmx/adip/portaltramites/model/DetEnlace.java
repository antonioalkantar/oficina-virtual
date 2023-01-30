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
@Table(name="det_enlace", schema="portaltramitescdmx")
@NamedQueries({ 
	@NamedQuery(name = "DetEnlace.findAll", query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO"
			+ "("
			+ "c.id, "
			+ "c.orden, "
			+ "c.descripcion, "
			+ "c.enlace, "
			+ "c.estatus, "
			+ "c.visible, "
			+ "c.fechaCreacion, "
			+ "c.fechaModificacion"
			+ ") "
			+ " FROM DetEnlace c"
			+ " ORDER BY c.orden"),
	@NamedQuery(name = "DetEnlace.findByVisible", 
			query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO"
			+ "("
			+ "c.id, "
			+ "c.orden, "
			+ "c.descripcion, "
			+ "c.enlace, "
			+ "c.estatus, "
			+ "c.visible, "
			+ "c.fechaCreacion, "
			+ "c.fechaModificacion"
			+ ") "
			+ "FROM DetEnlace c"
			+ " WHERE c.estatus = TRUE"
			+ " AND c.visible = true ORDER BY c.orden "
			),
	@NamedQuery(name = "DetEnlace.findByEstatus", 
	query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO"
			+ "("
			+ "c.id, "
			+ "c.orden, "
			+ "c.descripcion, "
			+ "c.enlace, "
			+ "c.estatus, "
			+ "c.visible, "
			+ "c.fechaCreacion, "
			+ "c.fechaModificacion"
			+ ") "
			+ "FROM DetEnlace c"
			+ " WHERE c.estatus = true ORDER BY c.orden "
			)
	})
public class DetEnlace implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private long orden;
	private String descripcion;
	private String enlace;
	private boolean visible;
	private boolean estatus;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	public DetEnlace() {
	}

	
	

	public DetEnlace(Long id, long orden, String descripcion, String enlace, boolean visible, boolean estatus,
			Date fechaCreacion, Date fechaModificacion) {
		super();
		this.id = id;
		this.orden = orden;
		this.descripcion = descripcion;
		this.enlace = enlace;
		this.visible = visible;
		this.estatus = estatus;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enlace", insertable = false, updatable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getOrden() {
		return orden;
	}

	public void setOrden(long orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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
