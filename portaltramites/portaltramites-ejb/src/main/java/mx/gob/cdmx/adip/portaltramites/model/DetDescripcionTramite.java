package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_descripcion_tramite database table.
 * 
 */
@Entity
@Table(name="det_descripcion_tramite", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetDescripcionTramite.findAll", query="SELECT d FROM DetDescripcionTramite d")
})
public class DetDescripcionTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String casosPuedeRealizarse;
	private String descripcionTramite;
	private String descripcionUsuario;
	private String efectosEliminacion;
	private String sinonimosBusqueda;
	private Boolean situacion;
	private CatMateria catMateria;
	private TramiteServicio tramiteServicio;
	private String otroSolicitante;
	private String descripcionCiudadana;

	public DetDescripcionTramite() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="casos_puede_realizarse")
	public String getCasosPuedeRealizarse() {
		return this.casosPuedeRealizarse;
	}

	public void setCasosPuedeRealizarse(String casosPuedeRealizarse) {
		this.casosPuedeRealizarse = casosPuedeRealizarse;
	}


	@Column(name="descripcion_tramite")
	public String getDescripcionTramite() {
		return this.descripcionTramite;
	}

	public void setDescripcionTramite(String descripcionTramite) {
		this.descripcionTramite = descripcionTramite;
	}


	@Column(name="descripcion_usuario")
	public String getDescripcionUsuario() {
		return this.descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
	}


	@Column(name="efectos_eliminacion")
	public String getEfectosEliminacion() {
		return this.efectosEliminacion;
	}

	public void setEfectosEliminacion(String efectosEliminacion) {
		this.efectosEliminacion = efectosEliminacion;
	}


	@Column(name="sinonimos_busqueda")
	public String getSinonimosBusqueda() {
		return this.sinonimosBusqueda;
	}

	public void setSinonimosBusqueda(String sinonimosBusqueda) {
		this.sinonimosBusqueda = sinonimosBusqueda;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CatMateria
	@ManyToOne
	@JoinColumn(name="id_materia")
	public CatMateria getCatMateria() {
		return this.catMateria;
	}

	public void setCatMateria(CatMateria catMateria) {
		this.catMateria = catMateria;
	}

	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}
	
	@Column(name="otro_solicitante")
	public String getOtroSolicitante() {
		return this.otroSolicitante;
	}

	public void setOtroSolicitante(String otroSolicitante) {
		this.otroSolicitante = otroSolicitante;
	}
	@Column(name="descripcion_cuidadana")
	public String getDescripcionCiudadana() {
		return descripcionCiudadana;
	}


	public void setDescripcionCiudadana(String descripcionCiudadana) {
		this.descripcionCiudadana = descripcionCiudadana;
	}

}