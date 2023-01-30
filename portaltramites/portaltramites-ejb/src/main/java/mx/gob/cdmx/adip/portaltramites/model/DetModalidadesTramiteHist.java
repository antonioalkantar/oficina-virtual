package mx.gob.cdmx.adip.portaltramites.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the det_modalidades_tramite_hist database table.
 * 
 */
@Entity
@Table(name="det_modalidades_tramite_hist", schema = "retys_v2")
@NamedQuery(name="DetModalidadesTramiteHist.findAll", query="SELECT d FROM DetModalidadesTramiteHist d")
public class DetModalidadesTramiteHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamFicta;
	private String articuloLeyReglamMonto;
	//private Long idFijoOCalculado;
	//private Long idFlujoTramitre;
	private Long idFundJuridicoFicta;
	//private Long idFundJuridicoMonto;
	//private Long idTipoConcepto;
	//private Long idTipoFicta;
	private Long idTipoPresentacion;
	//private Long idTramiteServicio;
	private Boolean medianteFormato;
	private String metodoCalcular;
	private String nombre;
	private String otraLeyFicta;
	private String otraLeyMonto;
	private String otroMedioPresentacion;
	private Boolean replicaDocumentoBeneficio;
	private Boolean replicaFicta;
	private Boolean replicaFijoCalculado;
	private Boolean replicaMedianteFormato;
	private Boolean replicaVigencia;
	private Boolean situacion;
	private Boolean tieneMontoDerechos;
	private Boolean tieneVigencia;
	private String otroDocBeneficio;
	private CatDocumentoBeneficio catDocumentoBeneficio;
	private CatTipoFicta catTipoFicta;
	private CatLeye catLeye2;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private CatFijoOCalculado catFijoOCalculado;
	private CatTipoConcepto catTipoConcepto;
	private List<DetVigenciaModalidad> detVigenciaModalidads;
	
	private DetModalidadesTramite detModalidadesTramite;

	public DetModalidadesTramiteHist() {
	}


	@Id
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


	@Column(name="id_fund_juridico_ficta")
	public Long getIdFundJuridicoFicta() {
		return this.idFundJuridicoFicta;
	}

	public void setIdFundJuridicoFicta(Long idFundJuridicoFicta) {
		this.idFundJuridicoFicta = idFundJuridicoFicta;
	}

	@Column(name="id_tipo_presentacion")
	public Long getIdTipoPresentacion() {
		return this.idTipoPresentacion;
	}

	public void setIdTipoPresentacion(Long idTipoPresentacion) {
		this.idTipoPresentacion = idTipoPresentacion;
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


	@Column(name="otro_medio_presentacion")
	public String getOtroMedioPresentacion() {
		return this.otroMedioPresentacion;
	}

	public void setOtroMedioPresentacion(String otroMedioPresentacion) {
		this.otroMedioPresentacion = otroMedioPresentacion;
	}


	@Column(name="replica_documento_beneficio")
	public Boolean getReplicaDocumentoBeneficio() {
		return this.replicaDocumentoBeneficio;
	}

	public void setReplicaDocumentoBeneficio(Boolean replicaDocumentoBeneficio) {
		this.replicaDocumentoBeneficio = replicaDocumentoBeneficio;
	}


	@Column(name="replica_ficta")
	public Boolean getReplicaFicta() {
		return this.replicaFicta;
	}

	public void setReplicaFicta(Boolean replicaFicta) {
		this.replicaFicta = replicaFicta;
	}


	@Column(name="replica_fijo_calculado")
	public Boolean getReplicaFijoCalculado() {
		return this.replicaFijoCalculado;
	}

	public void setReplicaFijoCalculado(Boolean replicaFijoCalculado) {
		this.replicaFijoCalculado = replicaFijoCalculado;
	}


	@Column(name="replica_mediante_formato")
	public Boolean getReplicaMedianteFormato() {
		return this.replicaMedianteFormato;
	}

	public void setReplicaMedianteFormato(Boolean replicaMedianteFormato) {
		this.replicaMedianteFormato = replicaMedianteFormato;
	}


	@Column(name="replica_vigencia")
	public Boolean getReplicaVigencia() {
		return this.replicaVigencia;
	}

	public void setReplicaVigencia(Boolean replicaVigencia) {
		this.replicaVigencia = replicaVigencia;
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


	@Column(name="tiene_vigencia")
	public Boolean getTieneVigencia() {
		return this.tieneVigencia;
	}

	public void setTieneVigencia(Boolean tieneVigencia) {
		this.tieneVigencia = tieneVigencia;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return detModalidadesTramite;
	}


	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	@Column(name="otro_doc_beneficio")
	public String getOtroDocBeneficio() {
		return otroDocBeneficio;
	}


	public void setOtroDocBeneficio(String otroDocBeneficio) {
		this.otroDocBeneficio = otroDocBeneficio;
	}


	//bi-directional many-to-one association to CatDocumentoBeneficio
	@ManyToOne
	@JoinColumn(name="id_documento_beneficio")
	public CatDocumentoBeneficio getCatDocumentoBeneficio() {
		return catDocumentoBeneficio;
	}
	public void setCatDocumentoBeneficio(CatDocumentoBeneficio catDocumentoBeneficio) {
		this.catDocumentoBeneficio = catDocumentoBeneficio;
	}

	@ManyToOne
	@JoinColumn(name="id_tipo_ficta")
	public CatTipoFicta getCatTipoFicta() {
		return catTipoFicta;
	}
	public void setCatTipoFicta(CatTipoFicta catTipoFicta) {
		this.catTipoFicta = catTipoFicta;
	}

	@ManyToOne
	@JoinColumn(name="id_fund_juridico_monto")
	public CatLeye getCatLeye2() {
		return catLeye2;
	}
	public void setCatLeye2(CatLeye catLeye2) {
		this.catLeye2 = catLeye2;
	}

	@OneToMany(mappedBy="detModalidadesTramite")
	public List<DetVigenciaModalidad> getDetVigenciaModalidads() {
		return detVigenciaModalidads;
	}
	public void setDetVigenciaModalidads(List<DetVigenciaModalidad> detVigenciaModalidads) {
		this.detVigenciaModalidads = detVigenciaModalidads;
	}

	@ManyToOne
	@JoinColumn(name="id_flujo_tramitre")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return crcFlujoTramite;
	}
	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}
	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	@ManyToOne
	@JoinColumn(name="id_fijo_o_calculado")
	public CatFijoOCalculado getCatFijoOCalculado() {
		return catFijoOCalculado;
	}
	public void setCatFijoOCalculado(CatFijoOCalculado catFijoOCalculado) {
		this.catFijoOCalculado = catFijoOCalculado;
	}

	@ManyToOne
	@JoinColumn(name="id_tipo_concepto")
	public CatTipoConcepto getCatTipoConcepto() {
		return catTipoConcepto;
	}
	public void setCatTipoConcepto(CatTipoConcepto catTipoConcepto) {
		this.catTipoConcepto = catTipoConcepto;
	}

}