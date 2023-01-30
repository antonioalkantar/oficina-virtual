package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the det_plazo_maximo_respuesta_hist database table.
 * 
 */
@Entity
@Table(name="det_plazo_maximo_respuesta_hist", schema = "retys_v2")
@NamedQuery(name="DetPlazoMaximoRespuestaHist.findAll", query="SELECT d FROM DetPlazoMaximoRespuestaHist d")
public class DetPlazoMaximoRespuestaHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamentoFicta;
	private Boolean esResolucionInmediata;
	private Long idFlujoTramite;
	private Long idFundamentoJuridicoFicta;
	private String otraLeyFicta;
	private Boolean tieneFundamentoCumplirPrevencion;
	private Boolean tieneFundamentoPrevenirSolicitante;
	private Boolean tieneFundamentoResolucionInmediata;
	private Boolean tieneFundamentoResolver;
	private TramiteServicio tramiteServicio;
	private List<DetPlazoResolverHist> detPlazoResolverHist;
	private CatTipoFicta catTipoFicta;


	public DetPlazoMaximoRespuestaHist() {
	}


	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="articulo_ley_reglamento_ficta")
	public String getArticuloLeyReglamentoFicta() {
		return this.articuloLeyReglamentoFicta;
	}

	public void setArticuloLeyReglamentoFicta(String articuloLeyReglamentoFicta) {
		this.articuloLeyReglamentoFicta = articuloLeyReglamentoFicta;
	}


	@Column(name="es_resolucion_inmediata")
	public Boolean getEsResolucionInmediata() {
		return this.esResolucionInmediata;
	}

	public void setEsResolucionInmediata(Boolean esResolucionInmediata) {
		this.esResolucionInmediata = esResolucionInmediata;
	}


	@Column(name="id_flujo_tramite")
	public Long getIdFlujoTramite() {
		return this.idFlujoTramite;
	}

	public void setIdFlujoTramite(Long idFlujoTramite) {
		this.idFlujoTramite = idFlujoTramite;
	}


	@Column(name="id_fundamento_juridico_ficta")
	public Long getIdFundamentoJuridicoFicta() {
		return this.idFundamentoJuridicoFicta;
	}

	public void setIdFundamentoJuridicoFicta(Long idFundamentoJuridicoFicta) {
		this.idFundamentoJuridicoFicta = idFundamentoJuridicoFicta;
	}


	@Column(name="otra_ley_ficta")
	public String getOtraLeyFicta() {
		return this.otraLeyFicta;
	}

	public void setOtraLeyFicta(String otraLeyFicta) {
		this.otraLeyFicta = otraLeyFicta;
	}


	@Column(name="tiene_fundamento_cumplir_prevencion")
	public Boolean getTieneFundamentoCumplirPrevencion() {
		return this.tieneFundamentoCumplirPrevencion;
	}

	public void setTieneFundamentoCumplirPrevencion(Boolean tieneFundamentoCumplirPrevencion) {
		this.tieneFundamentoCumplirPrevencion = tieneFundamentoCumplirPrevencion;
	}


	@Column(name="tiene_fundamento_prevenir_solicitante")
	public Boolean getTieneFundamentoPrevenirSolicitante() {
		return this.tieneFundamentoPrevenirSolicitante;
	}

	public void setTieneFundamentoPrevenirSolicitante(Boolean tieneFundamentoPrevenirSolicitante) {
		this.tieneFundamentoPrevenirSolicitante = tieneFundamentoPrevenirSolicitante;
	}


	@Column(name="tiene_fundamento_resolucion_inmediata")
	public Boolean getTieneFundamentoResolucionInmediata() {
		return this.tieneFundamentoResolucionInmediata;
	}

	public void setTieneFundamentoResolucionInmediata(Boolean tieneFundamentoResolucionInmediata) {
		this.tieneFundamentoResolucionInmediata = tieneFundamentoResolucionInmediata;
	}


	@Column(name="tiene_fundamento_resolver")
	public Boolean getTieneFundamentoResolver() {
		return this.tieneFundamentoResolver;
	}

	public void setTieneFundamentoResolver(Boolean tieneFundamentoResolver) {
		this.tieneFundamentoResolver = tieneFundamentoResolver;
	}


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}


	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	//bi-directional many-to-one association to DetPlazoResolver
	@OneToMany(mappedBy="detPlazoMaximoRespuestaHist")
	public List<DetPlazoResolverHist> getDetPlazoResolverHist() {
		return detPlazoResolverHist;
	}


	public void setDetPlazoResolverHist(List<DetPlazoResolverHist> detPlazoResolverHist) {
		this.detPlazoResolverHist = detPlazoResolverHist;
	}


	//bi-directional many-to-one association to CatTipoFicta
	@ManyToOne
	@JoinColumn(name="id_tipo_ficta")
	public CatTipoFicta getCatTipoFicta() {
		return this.catTipoFicta;
	}

	public void setCatTipoFicta(CatTipoFicta catTipoFicta) {
		this.catTipoFicta = catTipoFicta;
	}

}