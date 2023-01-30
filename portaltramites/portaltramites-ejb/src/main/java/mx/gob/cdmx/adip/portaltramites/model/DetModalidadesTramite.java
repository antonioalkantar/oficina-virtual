package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_modalidades_tramite database table.
 * 
 */
@Entity
@Table(name="det_modalidades_tramite", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetModalidadesTramite.findAll", query="SELECT d FROM DetModalidadesTramite d")
	, @NamedQuery(name="DetModalidadesTramite.findByIdTramiteII"
	, query="select new mx.gob.cdmx.adip.portaltramites.dto.ModalidadesTramiteServicioDTO"
			+ "("
			+ "  c.id "  
			+ ", c.nombre "
			+ ", db.descripcion " 
			+ ", c.otroDocBeneficio "
			+ ", dvm.catVigencia.id "
			+ ", dvm.catVigencia.descripcion "
			+ ", tf.descripcion "
			+ ", cl.id "
			+ ", cl.nombre "
			+ ", c.articuloLeyReglamMonto" 
			+ ", cuv.id "
			+ ", cuv.descripcion "
			+ ", dvm.vigencia "
			+ ", dvm.especificaOtra "
			+ ", dvm.vigenciaSuperior "
			+ ", c.replicaMedianteFormato"
			+ ", c.medianteFormato"
			+ ") " 
			+ "from DetModalidadesTramite c  " 
			+ "left join c.catDocumentoBeneficio db  " 
			+ "left join c.catTipoFicta tf  " 
			+ "left join c.tramiteServicio ts  "
			+ "left join c.catLeye2 cl "
			+ "left join c.detVigenciaModalidads dvm "
			+ "left join dvm.catUnidade cuv "
			+ "left join c.crcModificacionModalidads cmm "
//			+ "join c.crcFlujoTramite cft "
//			+ "join cft.catEtapasTramite cet "
//			+ "join cft.catEstatusTramite cestt "
			+ "where ts.id = :idTramite  " 
			+ "and c.situacion = true "
			+ "and (cmm.estatusCampo is null or cmm.estatusCampo in (1,2)) ")
//			+ "and cestt.id = 2 "
//			+ "and cet.esProcesoFinal = true")
	
	, @NamedQuery(name="DetModalidadesTramite.findByIdTramiteHist"
	, query="select new mx.gob.cdmx.adip.portaltramites.dto.ModalidadesTramiteServicioDTO"
			+ "("
			+ "  c.id "  
			+ ", modhist.nombre "
			+ ", dbhist.descripcion " 
			+ ", modhist.otroDocBeneficio "
			+ ", histdvm.catVigencia.id "
			+ ", histdvm.catVigencia.descripcion "
			+ ", fictahist.descripcion "
			+ ", clhist.id "
			+ ", clhist.nombre "
			+ ", modhist.articuloLeyReglamMonto" 
			+ ", histcuv.id "
			+ ", histcuv.descripcion "
			+ ", histdvm.vigencia "
			+ ", histdvm.especificaOtra "
			+ ", histdvm.vigenciaSuperior "
			+ ", modhist.replicaMedianteFormato"
			+ ", modhist.medianteFormato"
			+ ") " 
			+ "from DetModalidadesTramite c  " 
			+ "join c.tramiteServicio ts  "
			+ "join c.detModalidadesTramiteHist modhist "
			+ "left join modhist.catDocumentoBeneficio dbhist  " 
			+ "left join modhist.catTipoFicta fictahist  "
			+ "left join modhist.catLeye2 clhist  "
			+ "left join modhist.detVigenciaModalidads histdvm "			
			+ "left join histdvm.catUnidade histcuv "
			+ "left join histdvm.catVigencia histcv "

			+ "left join c.crcModificacionModalidads cmm "
			+ "join c.crcFlujoTramite cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cestt "
			+ "where ts.id = :idTramite  " 
			+ "and c.situacion = true "
			+ "and (cmm.estatusCampo is null or cmm.estatusCampo in (1,2)) "
			+ "and cestt.id = 2 "
			+ "and cet.esProcesoFinal = false")

})
public class DetModalidadesTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamFicta;
	private String articuloLeyReglamMonto;
	private Boolean medianteFormato;
	private String metodoCalcular;
	private String nombre;
	private String otraLeyFicta;
	private String otraLeyMonto;
	private Boolean situacion;
	private Boolean tieneMontoDerechos;
//	private List<DetArchivosAdjuntosModalidad> detArchivosAdjuntosModalidads;
//	private List<DetArchivosFormatoModalidad> detArchivosFormatoModalidads;
//	private List<DetDocumentoModalidad> detDocumentoModalidads;
	private CatDocumentoBeneficio catDocumentoBeneficio;
	private CatFijoOCalculado catFijoOCalculado;
	private CatLeye catLeye1;
	private CatLeye catLeye2;
	private CatTipoFicta catTipoFicta;
//	private CatTipoPresentacion catTipoPresentacion;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private List<DetVigenciaModalidad> detVigenciaModalidads;
	private List<DetRequisitosModalidad> detRequisitosModalidad;
	private CatTipoConcepto catTipoConcepto;
	private List<DetConcCostosModal> detConcCostosModal;
	private Boolean tieneVigencia;
	private Boolean replicaMedianteFormato;
	private Boolean replicaDocumentoBeneficio;
	private Boolean replicaFijoCalculado;
	private Boolean replicaFicta;
	private Boolean replicaVigencia;
//	private List<CrcObservacionesModalidad> crcObservacionesModalidads;
	private String otroMedioPresentacion;
//	private List<CrcValidacionCamposModalidade> crcValidacionCamposModalidades;
	private List<CrcModificacionModalidad> crcModificacionModalidads;
	private String otroDocBeneficio;
	
	private DetModalidadesTramiteHist detModalidadesTramiteHist;

	public DetModalidadesTramite() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="articulo_ley_reglam_ficta")
	public String getArticuloLeyReglamFicta() {
		return this.articuloLeyReglamFicta;
	}

	public void setArticuloLeyReglamFicta(String articuloLeyReglamFicta) {
		this.articuloLeyReglamFicta = articuloLeyReglamFicta;
	}


	@Column(name="articulo_ley_reglam_monto")
	public String getArticuloLeyReglamMonto() {
		return this.articuloLeyReglamMonto;
	}

	public void setArticuloLeyReglamMonto(String articuloLeyReglamMonto) {
		this.articuloLeyReglamMonto = articuloLeyReglamMonto;
	}


	@Column(name="mediante_formato")
	public Boolean getMedianteFormato() {
		return this.medianteFormato;
	}

	public void setMedianteFormato(Boolean medianteFormato) {
		this.medianteFormato = medianteFormato;
	}


	@Column(name="metodo_calcular")
	public String getMetodoCalcular() {
		return this.metodoCalcular;
	}

	public void setMetodoCalcular(String metodoCalcular) {
		this.metodoCalcular = metodoCalcular;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="otra_ley_ficta")
	public String getOtraLeyFicta() {
		return this.otraLeyFicta;
	}

	public void setOtraLeyFicta(String otraLeyFicta) {
		this.otraLeyFicta = otraLeyFicta;
	}


	@Column(name="otra_ley_monto")
	public String getOtraLeyMonto() {
		return this.otraLeyMonto;
	}

	public void setOtraLeyMonto(String otraLeyMonto) {
		this.otraLeyMonto = otraLeyMonto;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	@Column(name="tiene_monto_derechos")
	public Boolean getTieneMontoDerechos() {
		return this.tieneMontoDerechos;
	}

	public void setTieneMontoDerechos(Boolean tieneMontoDerechos) {
		this.tieneMontoDerechos = tieneMontoDerechos;
	}


	//bi-directional many-to-one association to DetArchivosAdjuntosModalidad
//	@OneToMany(mappedBy="detModalidadesTramite")
//	public List<DetArchivosAdjuntosModalidad> getDetArchivosAdjuntosModalidads() {
//		return this.detArchivosAdjuntosModalidads;
//	}
//
//	public void setDetArchivosAdjuntosModalidads(List<DetArchivosAdjuntosModalidad> detArchivosAdjuntosModalidads) {
//		this.detArchivosAdjuntosModalidads = detArchivosAdjuntosModalidads;
//	}
//
//	public DetArchivosAdjuntosModalidad addDetArchivosAdjuntosModalidad(DetArchivosAdjuntosModalidad detArchivosAdjuntosModalidad) {
//		getDetArchivosAdjuntosModalidads().add(detArchivosAdjuntosModalidad);
//		detArchivosAdjuntosModalidad.setDetModalidadesTramite(this);
//
//		return detArchivosAdjuntosModalidad;
//	}
//
//	public DetArchivosAdjuntosModalidad removeDetArchivosAdjuntosModalidad(DetArchivosAdjuntosModalidad detArchivosAdjuntosModalidad) {
//		getDetArchivosAdjuntosModalidads().remove(detArchivosAdjuntosModalidad);
//		detArchivosAdjuntosModalidad.setDetModalidadesTramite(null);
//
//		return detArchivosAdjuntosModalidad;
//	}


	//bi-directional many-to-one association to DetArchivosFormatoModalidad
//	@OneToMany(mappedBy="detModalidadesTramite")
//	public List<DetArchivosFormatoModalidad> getDetArchivosFormatoModalidads() {
//		return this.detArchivosFormatoModalidads;
//	}
//
//	public void setDetArchivosFormatoModalidads(List<DetArchivosFormatoModalidad> detArchivosFormatoModalidads) {
//		this.detArchivosFormatoModalidads = detArchivosFormatoModalidads;
//	}
//
//	public DetArchivosFormatoModalidad addDetArchivosFormatoModalidad(DetArchivosFormatoModalidad detArchivosFormatoModalidad) {
//		getDetArchivosFormatoModalidads().add(detArchivosFormatoModalidad);
//		detArchivosFormatoModalidad.setDetModalidadesTramite(this);
//
//		return detArchivosFormatoModalidad;
//	}
//
//	public DetArchivosFormatoModalidad removeDetArchivosFormatoModalidad(DetArchivosFormatoModalidad detArchivosFormatoModalidad) {
//		getDetArchivosFormatoModalidads().remove(detArchivosFormatoModalidad);
//		detArchivosFormatoModalidad.setDetModalidadesTramite(null);
//
//		return detArchivosFormatoModalidad;
//	}


	//bi-directional many-to-one association to DetDocumentoModalidad
//	@OneToMany(mappedBy="detModalidadesTramite")
//	public List<DetDocumentoModalidad> getDetDocumentoModalidads() {
//		return this.detDocumentoModalidads;
//	}
//
//	public void setDetDocumentoModalidads(List<DetDocumentoModalidad> detDocumentoModalidads) {
//		this.detDocumentoModalidads = detDocumentoModalidads;
//	}
//
//	public DetDocumentoModalidad addDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
//		getDetDocumentoModalidads().add(detDocumentoModalidad);
//		detDocumentoModalidad.setDetModalidadesTramite(this);
//
//		return detDocumentoModalidad;
//	}
//
//	public DetDocumentoModalidad removeDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
//		getDetDocumentoModalidads().remove(detDocumentoModalidad);
//		detDocumentoModalidad.setDetModalidadesTramite(null);
//
//		return detDocumentoModalidad;
//	}


	//bi-directional many-to-one association to CatDocumentoBeneficio
	@ManyToOne
	@JoinColumn(name="id_documento_beneficio")
	public CatDocumentoBeneficio getCatDocumentoBeneficio() {
		return this.catDocumentoBeneficio;
	}

	public void setCatDocumentoBeneficio(CatDocumentoBeneficio catDocumentoBeneficio) {
		this.catDocumentoBeneficio = catDocumentoBeneficio;
	}


	//bi-directional many-to-one association to CatFijoOCalculado
	@ManyToOne
	@JoinColumn(name="id_fijo_o_calculado")
	public CatFijoOCalculado getCatFijoOCalculado() {
		return this.catFijoOCalculado;
	}

	public void setCatFijoOCalculado(CatFijoOCalculado catFijoOCalculado) {
		this.catFijoOCalculado = catFijoOCalculado;
	}


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fund_juridico_ficta")
	public CatLeye getCatLeye1() {
		return this.catLeye1;
	}

	public void setCatLeye1(CatLeye catLeye1) {
		this.catLeye1 = catLeye1;
	}


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fund_juridico_monto")
	public CatLeye getCatLeye2() {
		return this.catLeye2;
	}

	public void setCatLeye2(CatLeye catLeye2) {
		this.catLeye2 = catLeye2;
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


	//bi-directional many-to-one association to CatTipoPresentacion
//	@ManyToOne
//	@JoinColumn(name="id_tipo_presentacion")
//	public CatTipoPresentacion getCatTipoPresentacion() {
//		return this.catTipoPresentacion;
//	}
//
//	public void setCatTipoPresentacion(CatTipoPresentacion catTipoPresentacion) {
//		this.catTipoPresentacion = catTipoPresentacion;
//	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramitre")
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

	//bi-directional many-to-one association to DetVigenciaModalidad
	@OneToMany(mappedBy="detModalidadesTramite")
	public List<DetVigenciaModalidad> getDetVigenciaModalidads() {
		return this.detVigenciaModalidads;
	}

	public void setDetVigenciaModalidads(List<DetVigenciaModalidad> detVigenciaModalidads) {
		this.detVigenciaModalidads = detVigenciaModalidads;
	}

	//bi-directional many-to-one association to DetRequisitosModalidad
	@OneToMany(mappedBy="detModalidadesTramite")
	public List<DetRequisitosModalidad> getDetRequisitosModalidad() {
		return this.detRequisitosModalidad;
	}

	public void setDetRequisitosModalidad(List<DetRequisitosModalidad> detRequisitosModalidad) {
		this.detRequisitosModalidad = detRequisitosModalidad;
	}
//
//	public DetRequisitosModalidad addDetRequisitosModalidad(DetRequisitosModalidad detRequisitosModalidad) {
//		getDetRequisitosModalidads().add(detRequisitosModalidad);
//		detRequisitosModalidad.setDetModalidadesTramite(this);
//
//		return detRequisitosModalidad;
//	}
//
//	public DetRequisitosModalidad removeDetRequisitosModalidad(DetRequisitosModalidad detRequisitosModalidad) {
//		getDetRequisitosModalidads().remove(detRequisitosModalidad);
//		detRequisitosModalidad.setDetModalidadesTramite(null);
//
//		return detRequisitosModalidad;
//	}
	
	//bi-directional many-to-one association to DetRequisitosModalidad
	@OneToMany(mappedBy="detModalidadesTramite")
	public List<DetConcCostosModal> getDetConcCostosModal() {
		return this.detConcCostosModal;
	}

	public void setDetConcCostosModal(List<DetConcCostosModal> detConcCostosModal) {
		this.detConcCostosModal = detConcCostosModal;
	}
//
//	public DetConcCostosModal addDetConcCostosModal(DetConcCostosModal detConcCostosModal) {
//		getDetConcCostosModals().add(detConcCostosModal);
//		detConcCostosModal.setDetModalidadesTramite(this);
//
//		return detConcCostosModal;
//	}
//
//	public DetConcCostosModal removeDetConcCostosModal(DetConcCostosModal detConcCostosModal) {
//		getDetConcCostosModals().remove(detConcCostosModal);
//		detConcCostosModal.setDetModalidadesTramite(null);
//
//		return detConcCostosModal;
//	}
	
	//bi-directional many-to-one association to CatTipoConcepto
	@ManyToOne
	@JoinColumn(name="id_tipo_concepto")
	public CatTipoConcepto getCatTipoConcepto() {
		return this.catTipoConcepto;
	}

	public void setCatTipoConcepto(CatTipoConcepto catTipoConcepto) {
		this.catTipoConcepto = catTipoConcepto;
	}
	
	@Column(name="tiene_vigencia")
	public Boolean getTieneVigencia() {
		return this.tieneVigencia;
	}

	public void setTieneVigencia(Boolean tieneVigencia) {
		this.tieneVigencia = tieneVigencia;
	}

	@Column(name="replica_mediante_formato")
	public Boolean getReplicaMedianteFormato() {
		return replicaMedianteFormato;
	}


	public void setReplicaMedianteFormato(Boolean replicaMedianteFormato) {
		this.replicaMedianteFormato = replicaMedianteFormato;
	}

	@Column(name="replica_documento_beneficio")
	public Boolean getReplicaDocumentoBeneficio() {
		return replicaDocumentoBeneficio;
	}


	public void setReplicaDocumentoBeneficio(Boolean replicaDocumentoBeneficio) {
		this.replicaDocumentoBeneficio = replicaDocumentoBeneficio;
	}

	@Column(name="replica_fijo_calculado")
	public Boolean getReplicaFijoCalculado() {
		return replicaFijoCalculado;
	}


	public void setReplicaFijoCalculado(Boolean replicaFijoCalculado) {
		this.replicaFijoCalculado = replicaFijoCalculado;
	}

	@Column(name="replica_ficta")
	public Boolean getReplicaFicta() {
		return replicaFicta;
	}


	public void setReplicaFicta(Boolean replicaFicta) {
		this.replicaFicta = replicaFicta;
	}

	@Column(name="replica_vigencia")
	public Boolean getReplicaVigencia() {
		return replicaVigencia;
	}


	public void setReplicaVigencia(Boolean replicaVigencia) {
		this.replicaVigencia = replicaVigencia;
	}
	
	//bi-directional many-to-one association to CrcObservacionesModalidad
//	@OneToMany(mappedBy="detModalidadesTramite")
//	public List<CrcObservacionesModalidad> getCrcObservacionesModalidads() {
//		return this.crcObservacionesModalidads;
//	}
//
//	public void setCrcObservacionesModalidads(List<CrcObservacionesModalidad> crcObservacionesModalidads) {
//		this.crcObservacionesModalidads = crcObservacionesModalidads;
//	}
//
//	public CrcObservacionesModalidad addCrcObservacionesModalidad(CrcObservacionesModalidad crcObservacionesModalidad) {
//		getCrcObservacionesModalidads().add(crcObservacionesModalidad);
//		crcObservacionesModalidad.setDetModalidadesTramite(this);
//
//		return crcObservacionesModalidad;
//	}
//
//	public CrcObservacionesModalidad removeCrcObservacionesModalidad(CrcObservacionesModalidad crcObservacionesModalidad) {
//		getCrcObservacionesModalidads().remove(crcObservacionesModalidad);
//		crcObservacionesModalidad.setDetModalidadesTramite(null);
//
//		return crcObservacionesModalidad;
//	}

	@Column(name="otro_medio_presentacion")
	public String getOtroMedioPresentacion() {
		return otroMedioPresentacion;
	}

	public void setOtroMedioPresentacion(String otroMedioPresentacion) {
		this.otroMedioPresentacion = otroMedioPresentacion;
	}
	
	//bi-directional many-to-one association to CrcValidacionCamposModalidade
//	@OneToMany(mappedBy="detModalidadesTramite")
//	public List<CrcValidacionCamposModalidade> getCrcValidacionCamposModalidades() {
//		return this.crcValidacionCamposModalidades;
//	}
//
//	public void setCrcValidacionCamposModalidades(List<CrcValidacionCamposModalidade> crcValidacionCamposModalidades) {
//		this.crcValidacionCamposModalidades = crcValidacionCamposModalidades;
//	}
//
//	public CrcValidacionCamposModalidade addCrcValidacionCamposModalidade(CrcValidacionCamposModalidade crcValidacionCamposModalidade) {
//		getCrcValidacionCamposModalidades().add(crcValidacionCamposModalidade);
//		crcValidacionCamposModalidade.setDetModalidadesTramite(this);
//
//		return crcValidacionCamposModalidade;
//	}
//
//	public CrcValidacionCamposModalidade removeCrcValidacionCamposModalidade(CrcValidacionCamposModalidade crcValidacionCamposModalidade) {
//		getCrcValidacionCamposModalidades().remove(crcValidacionCamposModalidade);
//		crcValidacionCamposModalidade.setDetModalidadesTramite(null);
//
//		return crcValidacionCamposModalidade;
//	}
	
	//bi-directional many-to-one association to CrcModificacionModalidad
	@OneToMany(mappedBy="detModalidadesTramite")
	public List<CrcModificacionModalidad> getCrcModificacionModalidads() {
		return this.crcModificacionModalidads;
	}

	public void setCrcModificacionModalidads(List<CrcModificacionModalidad> crcModificacionModalidads) {
		this.crcModificacionModalidads = crcModificacionModalidads;
	}
//
//	public CrcModificacionModalidad addCrcModificacionModalidad(CrcModificacionModalidad crcModificacionModalidad) {
//		getCrcModificacionModalidads().add(crcModificacionModalidad);
//		crcModificacionModalidad.setDetModalidadesTramite(this);
//
//		return crcModificacionModalidad;
//	}
//
//	public CrcModificacionModalidad removeCrcModificacionModalidad(CrcModificacionModalidad crcModificacionModalidad) {
//		getCrcModificacionModalidads().remove(crcModificacionModalidad);
//		crcModificacionModalidad.setDetModalidadesTramite(null);
//
//		return crcModificacionModalidad;
//	}

	@Column(name="otro_doc_beneficio")
	public String getOtroDocBeneficio() {
		return this.otroDocBeneficio;
	}

	public void setOtroDocBeneficio(String otroDocBeneficio) {
		this.otroDocBeneficio = otroDocBeneficio;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetModalidadesTramiteHist getDetModalidadesTramiteHist() {
		return detModalidadesTramiteHist;
	}


	public void setDetModalidadesTramiteHist(DetModalidadesTramiteHist detModalidadesTramiteHist) {
		this.detModalidadesTramiteHist = detModalidadesTramiteHist;
	}

}