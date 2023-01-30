package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_descripcion_tramite_hist database table.
 * 
 */
@Entity
@Table(name="det_descripcion_tramite_hist", schema = "retys_v2")
@NamedQuery(name="DetDescripcionTramiteHist.findAll", query="SELECT d FROM DetDescripcionTramiteHist d")
public class DetDescripcionTramiteHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String casosPuedeRealizarse;
	private String descripcionTramite;
	private String descripcionUsuario;
	private String efectosEliminacion;
	private Long idFlujoTramitre;
	private Long idSolicitante;
	private String otroSolicitante;
	private String sinonimosBusqueda;
	private Boolean situacion;
	private TramiteServicio tramiteServicio;
	private CatMateria catMateria;

	public DetDescripcionTramiteHist() {
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


	@Column(name="id_flujo_tramitre")
	public Long getIdFlujoTramitre() {
		return this.idFlujoTramitre;
	}

	public void setIdFlujoTramitre(Long idFlujoTramitre) {
		this.idFlujoTramitre = idFlujoTramitre;
	}


	@Column(name="id_solicitante")
	public Long getIdSolicitante() {
		return this.idSolicitante;
	}

	public void setIdSolicitante(Long idSolicitante) {
		this.idSolicitante = idSolicitante;
	}


	@Column(name="otro_solicitante")
	public String getOtroSolicitante() {
		return this.otroSolicitante;
	}

	public void setOtroSolicitante(String otroSolicitante) {
		this.otroSolicitante = otroSolicitante;
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

	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
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

}