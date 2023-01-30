package mx.gob.cdmx.adip.portaltramites.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contenido_manual", schema = "portaltramitescdmx")
@NamedQueries({
	  @NamedQuery(name = "ContenidoManual.findAll"
	, query = "SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.ContenidoManualDTO"
			+ "( "
			+ "b.titulo "
			+ ",b.descripcion "
			+ ",b.link "
			+ ",b.palabrasClave "
            + ",c.idDependencia " 
            + ",c.nombreDependencia " 
            + ",d.idCatTema "
            + ",d.descripcion " 
			+ ") "
			+ "FROM ContenidoManual b "
			+ "JOIN b.catDependencias c "
			+ "JOIN b.catTema d "
			+ "WHERE b.situacion = true "
			+ "ORDER BY b.orden"),
})

public class ContenidoManual implements java.io.Serializable {
	

	private static final long serialVersionUID = 9033392191071786196L;
	
	private Long idContenido;
	private CatDependencias catDependencias;
	private CatTema catTema;
	private String titulo;
	private String descripcion;
	private String link;
	private Integer orden;
	private Boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean situacion;
	private String palabrasClave;

	public ContenidoManual() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_contenido", unique = true, nullable = false)
	public Long getIdContenido() {
		return this.idContenido;
	}
	
	public void setIdContenido(Long idContenido) {
		this.idContenido = idContenido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dependencia")
	public CatDependencias getCatDependencias() {
		return this.catDependencias;
	}

	public void setCatDependencias(CatDependencias catDependencias) {
		this.catDependencias = catDependencias;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tema")
	public CatTema getCatTema() {
		return this.catTema;
	}

	public void setCatTema(CatTema catTema) {
		this.catTema = catTema;
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

	@Column(name = "orden", nullable = false)
	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Column(name = "activo", nullable = false)
	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
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
	
	@Column(name = "palabras_clave", length = 500)
	public String getPalabrasClave() {
		return this.palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

}

