package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_plazo_maximo_respuesta database table.
 * 
 */
@Entity
@Table(name="det_plazo_maximo_respuesta", schema = "retys_v2")
@NamedQueries({
})
public class DetPlazoMaximoRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamentoFicta;
	private Boolean esResolucionInmediata;
	private String otraLeyFicta;
//	private List<DetPlazoCumplirPrevencion> detPlazoCumplirPrevencions;
	private CatLeye catLeye;
	private CatTipoFicta catTipoFicta;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
//	private List<DetPlazoPrevenirSolicitante> detPlazoPrevenirSolicitantes;
//	private List<DetPlazoResolucionInmediata> detPlazoResolucionInmediatas;
	private List<DetPlazoResolver> detPlazoResolver;
	private Boolean tieneFundamentoResolver;
	private Boolean tieneFundamentoPrevenirSolicitante;
	private Boolean tieneFundamentoCumplirPrevencion;
	private Boolean tieneFundamentoResolucionInmediata;

	public DetPlazoMaximoRespuesta() {
	}


	public DetPlazoMaximoRespuesta(Long id) {
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="otra_ley_ficta")
	public String getOtraLeyFicta() {
		return this.otraLeyFicta;
	}

	public void setOtraLeyFicta(String otraLeyFicta) {
		this.otraLeyFicta = otraLeyFicta;
	}
	
	@Column(name="tiene_fundamento_resolver")
	public Boolean getTieneFundamentoResolver() {
		return this.tieneFundamentoResolver;
	}

	public void setTieneFundamentoResolver(Boolean tieneFundamentoResolver) {
		this.tieneFundamentoResolver = tieneFundamentoResolver;
	}
	
	@Column(name="tiene_fundamento_prevenir_solicitante")
	public Boolean getTieneFundamentoPrevenirSolicitante() {
		return this.tieneFundamentoPrevenirSolicitante;
	}

	public void setTieneFundamentoPrevenirSolicitante(Boolean tieneFundamentoPrevenirSolicitante) {
		this.tieneFundamentoPrevenirSolicitante = tieneFundamentoPrevenirSolicitante;
	}
	
	@Column(name="tiene_fundamento_cumplir_prevencion")
	public Boolean getTieneFundamentoCumplirPrevencion() {
		return this.tieneFundamentoCumplirPrevencion;
	}

	public void setTieneFundamentoCumplirPrevencion(Boolean tieneFundamentoCumplirPrevencion) {
		this.tieneFundamentoCumplirPrevencion = tieneFundamentoCumplirPrevencion;
	}
	
	@Column(name="tiene_fundamento_resolucion_inmediata")
	public Boolean getTieneFundamentoResolucionInmediata() {
		return this.tieneFundamentoResolucionInmediata;
	}

	public void setTieneFundamentoResolucionInmediata(Boolean tieneFundamentoResolucionInmediata) {
		this.tieneFundamentoResolucionInmediata = tieneFundamentoResolucionInmediata;
	}


	//bi-directional many-to-one association to DetPlazoCumplirPrevencion
//	@OneToMany(mappedBy="detPlazoMaximoRespuesta")
//	public List<DetPlazoCumplirPrevencion> getDetPlazoCumplirPrevencions() {
//		return this.detPlazoCumplirPrevencions;
//	}
//
//	public void setDetPlazoCumplirPrevencions(List<DetPlazoCumplirPrevencion> detPlazoCumplirPrevencions) {
//		this.detPlazoCumplirPrevencions = detPlazoCumplirPrevencions;
//	}
//
//	public DetPlazoCumplirPrevencion addDetPlazoCumplirPrevencion(DetPlazoCumplirPrevencion detPlazoCumplirPrevencion) {
//		getDetPlazoCumplirPrevencions().add(detPlazoCumplirPrevencion);
//		detPlazoCumplirPrevencion.setDetPlazoMaximoRespuesta(this);
//
//		return detPlazoCumplirPrevencion;
//	}
//
//	public DetPlazoCumplirPrevencion removeDetPlazoCumplirPrevencion(DetPlazoCumplirPrevencion detPlazoCumplirPrevencion) {
//		getDetPlazoCumplirPrevencions().remove(detPlazoCumplirPrevencion);
//		detPlazoCumplirPrevencion.setDetPlazoMaximoRespuesta(null);
//
//		return detPlazoCumplirPrevencion;
//	}


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico_ficta")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
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


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
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


	//bi-directional many-to-one association to DetPlazoPrevenirSolicitante
//	@OneToMany(mappedBy="detPlazoMaximoRespuesta")
//	public List<DetPlazoPrevenirSolicitante> getDetPlazoPrevenirSolicitantes() {
//		return this.detPlazoPrevenirSolicitantes;
//	}
//
//	public void setDetPlazoPrevenirSolicitantes(List<DetPlazoPrevenirSolicitante> detPlazoPrevenirSolicitantes) {
//		this.detPlazoPrevenirSolicitantes = detPlazoPrevenirSolicitantes;
//	}
//
//	public DetPlazoPrevenirSolicitante addDetPlazoPrevenirSolicitante(DetPlazoPrevenirSolicitante detPlazoPrevenirSolicitante) {
//		getDetPlazoPrevenirSolicitantes().add(detPlazoPrevenirSolicitante);
//		detPlazoPrevenirSolicitante.setDetPlazoMaximoRespuesta(this);
//
//		return detPlazoPrevenirSolicitante;
//	}
//
//	public DetPlazoPrevenirSolicitante removeDetPlazoPrevenirSolicitante(DetPlazoPrevenirSolicitante detPlazoPrevenirSolicitante) {
//		getDetPlazoPrevenirSolicitantes().remove(detPlazoPrevenirSolicitante);
//		detPlazoPrevenirSolicitante.setDetPlazoMaximoRespuesta(null);
//
//		return detPlazoPrevenirSolicitante;
//	}


	//bi-directional many-to-one association to DetPlazoResolucionInmediata
//	@OneToMany(mappedBy="detPlazoMaximoRespuesta")
//	public List<DetPlazoResolucionInmediata> getDetPlazoResolucionInmediatas() {
//		return this.detPlazoResolucionInmediatas;
//	}
//
//	public void setDetPlazoResolucionInmediatas(List<DetPlazoResolucionInmediata> detPlazoResolucionInmediatas) {
//		this.detPlazoResolucionInmediatas = detPlazoResolucionInmediatas;
//	}
//
//	public DetPlazoResolucionInmediata addDetPlazoResolucionInmediata(DetPlazoResolucionInmediata detPlazoResolucionInmediata) {
//		getDetPlazoResolucionInmediatas().add(detPlazoResolucionInmediata);
//		detPlazoResolucionInmediata.setDetPlazoMaximoRespuesta(this);
//
//		return detPlazoResolucionInmediata;
//	}
//
//	public DetPlazoResolucionInmediata removeDetPlazoResolucionInmediata(DetPlazoResolucionInmediata detPlazoResolucionInmediata) {
//		getDetPlazoResolucionInmediatas().remove(detPlazoResolucionInmediata);
//		detPlazoResolucionInmediata.setDetPlazoMaximoRespuesta(null);
//
//		return detPlazoResolucionInmediata;
//	}


	//bi-directional many-to-one association to DetPlazoResolver
	@OneToMany(mappedBy="detPlazoMaximoRespuesta")
	public List<DetPlazoResolver> getDetPlazoResolver() {
		return this.detPlazoResolver;
	}

	public void setDetPlazoResolver(List<DetPlazoResolver> detPlazoResolver) {
		this.detPlazoResolver = detPlazoResolver;
	}
//
//	public DetPlazoResolver addDetPlazoResolver(DetPlazoResolver detPlazoResolver) {
//		getDetPlazoResolvers().add(detPlazoResolver);
//		detPlazoResolver.setDetPlazoMaximoRespuesta(this);
//
//		return detPlazoResolver;
//	}
//
//	public DetPlazoResolver removeDetPlazoResolver(DetPlazoResolver detPlazoResolver) {
//		getDetPlazoResolvers().remove(detPlazoResolver);
//		detPlazoResolver.setDetPlazoMaximoRespuesta(null);
//
//		return detPlazoResolver;
//	}


}