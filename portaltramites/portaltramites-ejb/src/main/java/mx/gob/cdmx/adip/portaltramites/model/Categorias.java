package mx.gob.cdmx.adip.portaltramites.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "categorias", schema = "public")
public class Categorias implements java.io.Serializable {
	
	private static final long serialVersionUID = 3372943440767253135L;
	private long id;
	private String descripcion;
	private Date createdAt;
	private Date updatedAt;
	private Set<Programs> programses = new HashSet<Programs>(0);

	public Categorias() {
	}

	public Categorias(long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Categorias(long id, String descripcion, Date createdAt, Date updatedAt, Set<Programs> programses) {
		this.id = id;
		this.descripcion = descripcion;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.programses = programses;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 22)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 22)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	public Set<Programs> getProgramses() {
		return this.programses;
	}

	public void setProgramses(Set<Programs> programses) {
		this.programses = programses;
	}

}
