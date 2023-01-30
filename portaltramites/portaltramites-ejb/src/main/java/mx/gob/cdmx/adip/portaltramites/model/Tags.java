package mx.gob.cdmx.adip.portaltramites.model;

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
@Table(name = "tags", schema = "portaltramitescdmx")
@NamedQueries({
	@NamedQuery(name = "Tags.consultaTop", query = "SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.TagsDTO"
			+ "("
			+ "	t.idTag,"
			+ "	t.tituloTag,"
			+ "	t.orden"
			+ ")"
			+ "	FROM Tags t"
			+ "	WHERE t.activo = true"
			+ "	AND t.situacion = true"
			+ "	ORDER BY t.orden ")
})
public class Tags implements java.io.Serializable {

	private static final long serialVersionUID = -7890867290393397341L;
	
	private Long idTag;
	private String tituloTag;
	private Integer orden;
	private boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean situacion;

	public Tags() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_tag", unique = true, nullable = false)
	public Long getIdTag() {
		return this.idTag;
	}

	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}

	@Column(name = "titulo_tag", length = 200)
	public String getTituloTag() {
		return this.tituloTag;
	}

	public void setTituloTag(String tituloTag) {
		this.tituloTag = tituloTag;
	}

	@Column(name = "orden", nullable = false)
	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", length = 29)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_modificacion", length = 29)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Column(name = "situacion")
	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}

