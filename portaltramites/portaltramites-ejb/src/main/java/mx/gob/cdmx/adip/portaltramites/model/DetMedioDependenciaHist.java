package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_dependencia_hist database table.
 * 
 */
@Entity
@Table(name="det_medio_dependencia_hist", schema = "retys_v2")
@NamedQuery(name="DetMedioDependenciaHist.findAll", query="SELECT d FROM DetMedioDependenciaHist d")
public class DetMedioDependenciaHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String calle;
	private Long idCostos;
	private Long idFlujoTramite;
	private String numeroExterior;
	private String numeroInterior;
	private String numeroReferencia;
	private String otraLey;
	private Boolean situacion;
	private DetMedioDependencia detMedioDependencia;
	private CatAlcaldia catAlcaldia;
	private CatAsentamiento catAsentamiento;
	private CatCodigosPostale catCodigosPostale;
	private CatLeye catLeye;
	private CatTipoVialidad catTipoVialidad;



	public DetMedioDependenciaHist() {
	}


	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="articulo_ley_reglamento")
	public String getArticuloLeyReglamento() {
		return this.articuloLeyReglamento;
	}

	public void setArticuloLeyReglamento(String articuloLeyReglamento) {
		this.articuloLeyReglamento = articuloLeyReglamento;
	}


	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	@Column(name="id_costos")
	public Long getIdCostos() {
		return this.idCostos;
	}

	public void setIdCostos(Long idCostos) {
		this.idCostos = idCostos;
	}


	@Column(name="id_flujo_tramite")
	public Long getIdFlujoTramite() {
		return this.idFlujoTramite;
	}

	public void setIdFlujoTramite(Long idFlujoTramite) {
		this.idFlujoTramite = idFlujoTramite;
	}


	@Column(name="numero_exterior")
	public String getNumeroExterior() {
		return this.numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}


	@Column(name="numero_interior")
	public String getNumeroInterior() {
		return this.numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}


	@Column(name="numero_referencia")
	public String getNumeroReferencia() {
		return this.numeroReferencia;
	}

	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetMedioDependencia getDetMedioDependencia() {
		return detMedioDependencia;
	}


	public void setDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
		this.detMedioDependencia = detMedioDependencia;
	}

	//bi-directional many-to-one association to CatAlcaldia
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	public CatAlcaldia getCatAlcaldia() {
		return this.catAlcaldia;
	}

	public void setCatAlcaldia(CatAlcaldia catAlcaldia) {
		this.catAlcaldia = catAlcaldia;
	}


	//bi-directional many-to-one association to CatAsentamiento
	@ManyToOne
	@JoinColumn(name="id_colonia")
	public CatAsentamiento getCatAsentamiento() {
		return this.catAsentamiento;
	}

	public void setCatAsentamiento(CatAsentamiento catAsentamiento) {
		this.catAsentamiento = catAsentamiento;
	}


	//bi-directional many-to-one association to CatCodigosPostale
	@ManyToOne
	@JoinColumn(name="id_codigo_postal")
	public CatCodigosPostale getCatCodigosPostale() {
		return this.catCodigosPostale;
	}

	public void setCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		this.catCodigosPostale = catCodigosPostale;
	}


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}


	//bi-directional many-to-one association to CatTipoVialidad
	@ManyToOne
	@JoinColumn(name="id_tipo_vialidad")
	public CatTipoVialidad getCatTipoVialidad() {
		return this.catTipoVialidad;
	}

	public void setCatTipoVialidad(CatTipoVialidad catTipoVialidad) {
		this.catTipoVialidad = catTipoVialidad;
	}

}