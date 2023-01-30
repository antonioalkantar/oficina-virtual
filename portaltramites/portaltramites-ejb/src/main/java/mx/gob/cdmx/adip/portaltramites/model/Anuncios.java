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
@Table(name = "anuncios", schema = "portaltramitescdmx")
@NamedQueries({
	@NamedQuery(name = "Anuncios.findById"
	, query = "SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.AnunciosDTO"
						+ "( "
						+ "a.idAnuncio, "
						+ "a.titulo, "
						+ "a.descripcion, "
						+ "a.link, "
						+ "a.imagen, "
						+ "a.orden, "
						+ "a.activo, "
						+ "a.situacion "
						+ ") "
						+ " FROM Anuncios a "
						+ " WHERE a.idAnuncio =:idAnuncio")
	
	
	,@NamedQuery(name = "Anuncios.findAll"
	, query = "SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.AnunciosDTO"
						+ "( "
						+ "a.idAnuncio, "
						+ "a.titulo, "
						+ "a.descripcion, "
						+ "a.link, "
						+ "a.imagen, "
						+ "a.orden, "
						+ "a.activo, "
						+ "a.situacion "
						+ ") "
						+ " FROM Anuncios a "
						+ " WHERE a.situacion = TRUE "
						+ " AND a.activo = TRUE"
						+ " ORDER BY a.orden ASC")
	
})
public class Anuncios implements Serializable {

	private static final long serialVersionUID = 5905970142365229354L;
	private Long idAnuncio;
	private String titulo;
	private String descripcion;
	private String link;
	private String imagen;
	private Integer orden;
	private boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean situacion;

	public Anuncios() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_anuncio", unique = true, nullable = false)
	public Long getIdAnuncio() {
		return this.idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	@Column(name = "titulo", length = 200)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "link", nullable = false, length = 500)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "imagen", nullable = false, length = 150)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

