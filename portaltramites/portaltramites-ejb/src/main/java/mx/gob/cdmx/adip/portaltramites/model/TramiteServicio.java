package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tramite_servicio database table.
 * 
 */
@Entity
@Table(name="tramite_servicio", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="TramiteServicio.findAll", query="SELECT t FROM TramiteServicio t"),
	@NamedQuery(name="TramiteServicio.findSearch"
	, query="select new mx.gob.cdmx.adip.portaltramites.dto.PortalTramitesBusquedaDTO"
			+ "("
			+ " t.id " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.homoclave else t.homoclave end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.nombreOficial else t.nombreOficial end "
			+ ", cedv.id "
			+ ", cedv.descripcion "
			+ ", cd.idDependencia "
			+ ", cd.abreviatura "
			+ ", cd.nombreDependencia "
			+ ", cm.id "
			+ ", cm.descripcion "
			+ ", dca.id "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.puedeRealizarseDigitalmente else dca.puedeRealizarseDigitalmente end "
			+ ", dca.tramiteConLlave "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.puedeRealizarsePresencialmente else dca.puedeRealizarsePresencialmente end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.puedeRealizarseTelefonicamente else dca.puedeRealizarseTelefonicamente end "
			+ ", t.tieneModalidades "
			+ ", 1 "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.sinonimosBusqueda else ddt.sinonimosBusqueda end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.descripcionTramite else ddt.descripcionTramite end "
			+ ", ddt.descripcionUsuario "
			+ ", ddt.descripcionCiudadana "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cuahist.nombre else cua.nombre end "
			+ ", dur.url "
			+ ") " 
			+ "from TramiteServicio t "
			+ "join t.catEtapaDeVida cedv "
			+ "join t.catDependencia cd "
			+ "join t.catEsTramiteServicio cets "
			+ "join t.detDescripcionTramites ddt "
			+ "join ddt.catMateria cm "
			+ "join t.detCanalAtencions dca "
			+ "join t.catUnidadesAdministrativa cua "
			+ "left join dca.detUrlRegistrados dur "

			+ "left join t.tramiteServicioHist tshist "
			+ "left join t.detDescripcionTramitesHist ddthist "
			+ "left join t.detCanalAtencionsHist dcahist "
			+ "left join tshist.catUnidadesAdministrativaHist cuahist "
			
			+ "join t.crcFlujoTramites cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cestt "
			+ "join cft.catTipoSolicitud cts "
			+ "where t.situacion = true "
			+ "and cestt.id = 2 "
			+ "and cets.id <> 3 "//se omiten programas sociales de retys
			+ "and (dur.situacion is null or dur.situacion = true) "
			),
	@NamedQuery(name="TramiteServicio.findById"
	, query="select new mx.gob.cdmx.adip.portaltramites.dto.DetalleTramiteServicioDTO"
			+ "("
			+ "  case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.id else t.id end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cetshist.descripcion else cets.descripcion end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.descripcionTramite else ddt.descripcionTramite end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.descripcionUsuario else ddt.descripcionUsuario end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dfhist.id is not null then cdbhist.descripcion else cdb.descripcion end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dchist.id is not null then ctchist.descripcion else ctc.descripcion end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dchist.id is not null then dchist.id else dc.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dchist.id is not null then clhist.id else cl.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dchist.id is not null then clhist.nombre else cl.nombre end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dchist.id is not null then dchist.articuloLeyReglamento else dc.articuloLeyReglamento end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dchist.id is not null then dchist.otraLey else dc.otraLey end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dvhist.id is not null then cuvhist.id else cuv.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dvhist.id is not null then cuvhist.descripcion else cuv.descripcion end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dvhist.id is not null then cvhist.descripcion else cv.descripcion end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dpmrhist.id is not null then ctfichist.descripcion else ctfic.descripcion end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dpmrhist.id is not null then dpmrhist.esResolucionInmediata else dpmr.esResolucionInmediata end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dpmrhist.id is not null then dprhist.plazoResolver else dpr.plazoResolver end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dpmrhist.id is not null then cuhist.descripcion else cu.descripcion end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dfhist.id is not null then dfhist.id else df.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dfhist.id is not null then dfhist.medianteFormato else df.medianteFormato end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcdhist.id is not null then dcdhist.requiereAgendarCitas else dcd.requiereAgendarCitas end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcdhist.id is not null then dcdhist.puedeAgendarEnLinea else dcd.puedeAgendarEnLinea end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcdhist.id is not null then dcdhist.urlAgendarCita else dcd.urlAgendarCita end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dvhist.id is not null then dvhist.vigencia else dv.vigencia end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dfhist.id is not null then dfhist.otroBeneficio else df.otroBeneficio end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dvhist.id is not null then dvhist.especificaOtra else dv.especificaOtra end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and diaHist.id is not null then diaHist.informacionUtil else dia.informacionUtil end "
			+ ") " 
			+ "from TramiteServicio t "
			+ "join t.catEsTramiteServicio cets  "
			+ "left join t.detCitasDependencia dcd "
			+ "left join t.detDescripcionTramites ddt "
			+ "left join t.detFormatos df "
			+ "left join df.catDocumentoBeneficio cdb "
			+ "left join t.detCostos dc "
			+ "left join dc.catTipoConcepto ctc "
			+ "left join dc.catLeye cl "
			+ "left join t.detVigencias dv "
			+ "left join dv.catVigencia cv "
			+ "left join dv.catUnidade cuv "
			+ "left join t.detPlazoMaximoRespuestas dpmr "
			+ "left join dpmr.catTipoFicta ctfic "
			+ "left join dpmr.detPlazoResolver dpr "
			+ "left join dpr.catUnidade cu "

			+ "left join t.tramiteServicioHist tshist "
			+ "left join tshist.catEsTramiteServicio cetshist "
			+ "left join t.detCitasDependenciaHist dcdhist "
			+ "left join t.detDescripcionTramitesHist ddthist "
			+ "left join t.detFormatosHist dfhist "
			+ "left join dfhist.catDocumentoBeneficio cdbhist "
			+ "left join t.detCostosHist dchist "
			+ "left join dchist.catTipoConcepto ctchist "
			+ "left join dchist.catLeye clhist "
			+ "left join t.detVigenciasHist dvhist "
			+ "left join dvhist.catVigencia cvhist "
			+ "left join dvhist.catUnidade cuvhist "
			+ "left join t.detPlazoMaximoRespuestasHist dpmrhist "
			+ "left join dpmrhist.catTipoFicta ctfichist "
			+ "left join dpmrhist.detPlazoResolverHist dprhist "
			+ "left join dprhist.catUnidade cuhist "
			
			+ "join t.crcFlujoTramites cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cestt "
			+ "join cft.catTipoSolicitud cts "
			
			+ "left join cft.detInformacionAdicional dia "
			+ "left join dia.detInformacionAdicional diaHist "
			
			+ "where t.id = :idTramite"
			+ ""),

	@NamedQuery(name="TramiteServicio.findByIdTramite"
	, query="select new mx.gob.cdmx.adip.portaltramites.dto.PortalTramitesBusquedaDTO"
			+ "("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.id else t.id end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.homoclave else t.homoclave end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.nombreOficial else t.nombreOficial end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cedvhist.id else cedv.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cedvhist.descripcion else cedv.descripcion end"
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cdhist.idDependencia else cd.idDependencia end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cdhist.abreviatura else cd.abreviatura end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cdhist.nombreDependencia else cd.nombreDependencia end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then cmhist.id else cm.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then cmhist.descripcion else cm.descripcion end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.id else dca.id end"
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.puedeRealizarseDigitalmente else dca.puedeRealizarseDigitalmente end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dca.tramiteConLlave else dca.tramiteConLlave end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.puedeRealizarsePresencialmente else dca.puedeRealizarsePresencialmente end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dcahist.id is not null then dcahist.puedeRealizarseTelefonicamente else dca.puedeRealizarseTelefonicamente end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then tshist.tieneModalidades else t.tieneModalidades end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and tshist.id is not null then cetshist.id else cets.id end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.sinonimosBusqueda else ddt.sinonimosBusqueda end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.descripcionTramite else ddt.descripcionTramite end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddthist.descripcionUsuario else ddt.descripcionUsuario end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and ddthist.id is not null then ddt.descripcionCiudadana else ddt.descripcionCiudadana end "
			+ ") " 
			+ "from TramiteServicio t "
			+ "join t.catEsTramiteServicio cets "
			+ "left join t.catEtapaDeVida cedv "
			+ "left join t.catDependencia cd "

			+ "left join t.detDescripcionTramites ddt "
			+ "left join ddt.catMateria cm "

			+ "left join t.detCanalAtencions dca "

			+ "left join t.tramiteServicioHist tshist "
			+ "left join tshist.catEtapaDeVida cedvhist "
			+ "left join tshist.catDependencia cdhist "
			+ "left join tshist.catEsTramiteServicio cetshist "

			+ "left join t.detDescripcionTramitesHist ddthist "
			+ "left join ddt.catMateria cmhist "

			+ "left join t.detCanalAtencionsHist dcahist "

			+ "join t.crcFlujoTramites cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cestt "
			+ "join cft.catTipoSolicitud cts "
			+ "where t.id = :idTramite "
			+ "and t.situacion = true "
			+ "and cestt.id = 2"
			)
})

public class TramiteServicio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8451322893518280876L;
	private Long id;
	private String homoclave;
	private String nombreOficial;
	private Boolean tieneModalidades;
	private Boolean situacion;
	private CatDependencia catDependencia;
	private CatEtapaDeVida catEtapaDeVida;
	private CatEsTramiteServicio catEsTramiteServicio;
	private TramiteServicioHist tramiteServicioHist;
	private CatEstatusTramite catEstatusTramite;
	private CatUnidadesAdministrativa catUnidadesAdministrativa;

	private List<DetCanalAtencion> detCanalAtencions;
	private List<DetCanalAtencionHist> detCanalAtencionsHist;
	private List<DetDescripcionTramite> detDescripcionTramites;
	private List<DetDescripcionTramiteHist> detDescripcionTramitesHist;
	private List<DetFormato> detFormatos;
	private List<DetFormatoHist> detFormatosHist;
	private List<DetCosto> detCostos;
	private List<DetCostosHist> detCostosHist;
	private List<DetVigencia> detVigencias;
	private List<DetVigenciaHist> detVigenciasHist;
	private List<DetCitasDependencia> detCitasDependencia;
	private List<DetCitasDependenciasHist> detCitasDependenciaHist;
	private List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas;
	private List<DetPlazoMaximoRespuestaHist> detPlazoMaximoRespuestasHist;
	private List<CrcFlujoTramite> crcFlujoTramites;

	public TramiteServicio() {
	}
	
	@Id
	@Column(name="id")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="homoclave")
	public String getHomoclave() {
		return this.homoclave;
	}

	public void setHomoclave(String homoclave) {
		this.homoclave = homoclave;
	}

	@Column(name="nombre_oficial")
	public String getNombreOficial() {
		return nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	//bi-directional many-to-one association to CatEtapaDeVida
	@ManyToOne
	@JoinColumn(name="id_dependencia")
	public CatDependencia getCatDependencia() {
		return this.catDependencia;
	}

	public void setCatDependencia(CatDependencia catDependencia) {
		this.catDependencia = catDependencia;
	}

	//bi-directional many-to-one association to CatEtapaDeVida
	@ManyToOne
	@JoinColumn(name="id_etapa_de_vida")
	public CatEtapaDeVida getCatEtapaDeVida() {
		return this.catEtapaDeVida;
	}

	public void setCatEtapaDeVida(CatEtapaDeVida catEtapaDeVida) {
		this.catEtapaDeVida = catEtapaDeVida;
	}

	//bi-directional many-to-one association to DetCanalAtencion
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetCanalAtencion> getDetCanalAtencions() {
		return this.detCanalAtencions;
	}

	public void setDetCanalAtencions(List<DetCanalAtencion> detCanalAtencions) {
		this.detCanalAtencions = detCanalAtencions;
	}

	//bi-directional many-to-one association to DetDescripcionTramite
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetDescripcionTramite> getDetDescripcionTramites() {
		return this.detDescripcionTramites;
	}

	public void setDetDescripcionTramites(List<DetDescripcionTramite> detDescripcionTramites) {
		this.detDescripcionTramites = detDescripcionTramites;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetDescripcionTramiteHist> getDetDescripcionTramitesHist() {
		return this.detDescripcionTramitesHist;
	}

	public void setDetDescripcionTramitesHist(List<DetDescripcionTramiteHist> detDescripcionTramitesHist) {
		this.detDescripcionTramitesHist = detDescripcionTramitesHist;
	}

	//bi-directional many-to-one association to CatEsTramiteServicio
	@ManyToOne
	@JoinColumn(name="id_es_tramite_servicio")
	public CatEsTramiteServicio getCatEsTramiteServicio() {
		return this.catEsTramiteServicio;
	}

	public void setCatEsTramiteServicio(CatEsTramiteServicio catEsTramiteServicio) {
		this.catEsTramiteServicio = catEsTramiteServicio;
	}

	//bi-directional many-to-one association to DetFormato
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetFormato> getDetFormatos() {
		return this.detFormatos;
	}

	public void setDetFormatos(List<DetFormato> detFormatos) {
		this.detFormatos = detFormatos;
	}

	//bi-directional many-to-one association to DetCosto
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetCosto> getDetCostos() {
		return this.detCostos;
	}

	public void setDetCostos(List<DetCosto> detCostos) {
		this.detCostos = detCostos;
	}

	//bi-directional many-to-one association to DetVigencia
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetVigencia> getDetVigencias() {
		return this.detVigencias;
	}

	public void setDetVigencias(List<DetVigencia> detVigencias) {
		this.detVigencias = detVigencias;
	}

	//bi-directional many-to-one association to DetPlazoMaximoRespuesta
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetPlazoMaximoRespuesta> getDetPlazoMaximoRespuestas() {
		return this.detPlazoMaximoRespuestas;
	}

	public void setDetPlazoMaximoRespuestas(List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas) {
		this.detPlazoMaximoRespuestas = detPlazoMaximoRespuestas;
	}

	//bi-directional many-to-one association to CrcFlujoTramite2
	@OneToMany(mappedBy="tramiteServicio")
	public List<CrcFlujoTramite> getCrcFlujoTramites() {
		return this.crcFlujoTramites;
	}

	public void setCrcFlujoTramites(List<CrcFlujoTramite> crcFlujoTramites) {
		this.crcFlujoTramites = crcFlujoTramites;
	}

	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@Column(name="tiene_modalidades")
	public Boolean getTieneModalidades() {
		return this.tieneModalidades;
	}

	public void setTieneModalidades(Boolean tieneModalidades) {
		this.tieneModalidades = tieneModalidades;
	}

	//bi-directional many-to-one association to DetCitasDependencia
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetCitasDependencia> getDetCitasDependencia() {
		return detCitasDependencia;
	}

	public void setDetCitasDependencia(List<DetCitasDependencia> detCitasDependencia) {
		this.detCitasDependencia = detCitasDependencia;
	}

	//bi-directional many-to-one association to TramiteServicioHist
	@OneToOne
	@JoinColumn(name="id")
	public TramiteServicioHist getTramiteServicioHist() {
		return tramiteServicioHist;
	}

	public void setTramiteServicioHist(TramiteServicioHist tramiteServicioHist) {
		this.tramiteServicioHist = tramiteServicioHist;
	}

	public CatEstatusTramite getCatEstatusTramite() {
		return catEstatusTramite;
	}

	public void setCatEstatusTramite(CatEstatusTramite catEstatusTramite) {
		this.catEstatusTramite = catEstatusTramite;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetCanalAtencionHist> getDetCanalAtencionsHist() {
		return detCanalAtencionsHist;
	}

	public void setDetCanalAtencionsHist(List<DetCanalAtencionHist> detCanalAtencionsHist) {
		this.detCanalAtencionsHist = detCanalAtencionsHist;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetCitasDependenciasHist> getDetCitasDependenciaHist() {
		return detCitasDependenciaHist;
	}

	public void setDetCitasDependenciaHist(List<DetCitasDependenciasHist> detCitasDependenciaHist) {
		this.detCitasDependenciaHist = detCitasDependenciaHist;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetFormatoHist> getDetFormatosHist() {
		return detFormatosHist;
	}

	public void setDetFormatosHist(List<DetFormatoHist> detFormatosHist) {
		this.detFormatosHist = detFormatosHist;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetCostosHist> getDetCostosHist() {
		return detCostosHist;
	}

	public void setDetCostosHist(List<DetCostosHist> detCostosHist) {
		this.detCostosHist = detCostosHist;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetVigenciaHist> getDetVigenciasHist() {
		return detVigenciasHist;
	}

	public void setDetVigenciasHist(List<DetVigenciaHist> detVigenciasHist) {
		this.detVigenciasHist = detVigenciasHist;
	}

	//bi-directional many-to-one association to DetDescripcionTramiteHist
	@OneToMany(mappedBy="tramiteServicio")
	public List<DetPlazoMaximoRespuestaHist> getDetPlazoMaximoRespuestasHist() {
		return detPlazoMaximoRespuestasHist;
	}

	public void setDetPlazoMaximoRespuestasHist(List<DetPlazoMaximoRespuestaHist> detPlazoMaximoRespuestasHist) {
		this.detPlazoMaximoRespuestasHist = detPlazoMaximoRespuestasHist;
	}

	//bi-directional many-to-one association to CatUnidadesAdministrativa
	@ManyToOne
	@JoinColumn(name="id_area_administrativa")
	public CatUnidadesAdministrativa getCatUnidadesAdministrativa() {
		return catUnidadesAdministrativa;
	}

	public void setCatUnidadesAdministrativa(CatUnidadesAdministrativa catUnidadesAdministrativa) {
		this.catUnidadesAdministrativa = catUnidadesAdministrativa;
	}

}