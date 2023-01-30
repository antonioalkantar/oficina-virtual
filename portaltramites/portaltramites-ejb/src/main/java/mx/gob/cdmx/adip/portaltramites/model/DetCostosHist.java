package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_costos_hist database table.
 * 
 */
@Entity
@Table(name="det_costos_hist", schema = "retys_v2")
@NamedQuery(name="DetCostosHist.findAll", query="SELECT d FROM DetCostosHist d")
public class DetCostosHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private Integer diasVigencia;
	private Long idFijoOCalculado;
	private Long idFlujoTramitre;
	private Long idMomentoRealizaPago;
	private Long idUnidadDiasVigencia;
	private String metodoCalcular;
	private String otraLey;
	private Boolean seEstableceVigencia;
	private Boolean sePuedeBanco;
	private Boolean sePuedeDependencia;
	private Boolean sePuedeOficina;
	private Boolean sePuedeOnline;
	private Boolean sePuedeOtro;
	private Boolean sePuedeTienda;
	private Boolean situacion;
	private Boolean tieneMontoDerechos;
	private TramiteServicio tramiteServicio;
	private CatTipoConcepto catTipoConcepto;
	private CatLeye catLeye;

	public DetCostosHist() {
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


	@Column(name="dias_vigencia")
	public Integer getDiasVigencia() {
		return this.diasVigencia;
	}

	public void setDiasVigencia(Integer diasVigencia) {
		this.diasVigencia = diasVigencia;
	}


	@Column(name="id_fijo_o_calculado")
	public Long getIdFijoOCalculado() {
		return this.idFijoOCalculado;
	}

	public void setIdFijoOCalculado(Long idFijoOCalculado) {
		this.idFijoOCalculado = idFijoOCalculado;
	}


	@Column(name="id_flujo_tramitre")
	public Long getIdFlujoTramitre() {
		return this.idFlujoTramitre;
	}

	public void setIdFlujoTramitre(Long idFlujoTramitre) {
		this.idFlujoTramitre = idFlujoTramitre;
	}


	@Column(name="id_momento_realiza_pago")
	public Long getIdMomentoRealizaPago() {
		return this.idMomentoRealizaPago;
	}

	public void setIdMomentoRealizaPago(Long idMomentoRealizaPago) {
		this.idMomentoRealizaPago = idMomentoRealizaPago;
	}


	@Column(name="id_unidad_dias_vigencia")
	public Long getIdUnidadDiasVigencia() {
		return this.idUnidadDiasVigencia;
	}

	public void setIdUnidadDiasVigencia(Long idUnidadDiasVigencia) {
		this.idUnidadDiasVigencia = idUnidadDiasVigencia;
	}


	@Column(name="metodo_calcular")
	public String getMetodoCalcular() {
		return this.metodoCalcular;
	}

	public void setMetodoCalcular(String metodoCalcular) {
		this.metodoCalcular = metodoCalcular;
	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	@Column(name="se_establece_vigencia")
	public Boolean getSeEstableceVigencia() {
		return this.seEstableceVigencia;
	}

	public void setSeEstableceVigencia(Boolean seEstableceVigencia) {
		this.seEstableceVigencia = seEstableceVigencia;
	}


	@Column(name="se_puede_banco")
	public Boolean getSePuedeBanco() {
		return this.sePuedeBanco;
	}

	public void setSePuedeBanco(Boolean sePuedeBanco) {
		this.sePuedeBanco = sePuedeBanco;
	}


	@Column(name="se_puede_dependencia")
	public Boolean getSePuedeDependencia() {
		return this.sePuedeDependencia;
	}

	public void setSePuedeDependencia(Boolean sePuedeDependencia) {
		this.sePuedeDependencia = sePuedeDependencia;
	}


	@Column(name="se_puede_oficina")
	public Boolean getSePuedeOficina() {
		return this.sePuedeOficina;
	}

	public void setSePuedeOficina(Boolean sePuedeOficina) {
		this.sePuedeOficina = sePuedeOficina;
	}


	@Column(name="se_puede_online")
	public Boolean getSePuedeOnline() {
		return this.sePuedeOnline;
	}

	public void setSePuedeOnline(Boolean sePuedeOnline) {
		this.sePuedeOnline = sePuedeOnline;
	}


	@Column(name="se_puede_otro")
	public Boolean getSePuedeOtro() {
		return this.sePuedeOtro;
	}

	public void setSePuedeOtro(Boolean sePuedeOtro) {
		this.sePuedeOtro = sePuedeOtro;
	}


	@Column(name="se_puede_tienda")
	public Boolean getSePuedeTienda() {
		return this.sePuedeTienda;
	}

	public void setSePuedeTienda(Boolean sePuedeTienda) {
		this.sePuedeTienda = sePuedeTienda;
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


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}


	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	//bi-directional many-to-one association to CatTipoConcepto
	@ManyToOne
	@JoinColumn(name="id_tipo_concepto")
	public CatTipoConcepto getCatTipoConcepto() {
		return this.catTipoConcepto;
	}

	public void setCatTipoConcepto(CatTipoConcepto catTipoConcepto) {
		this.catTipoConcepto = catTipoConcepto;
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
}