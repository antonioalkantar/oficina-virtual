package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_costos database table.
 * 
 */
@Entity
@Table(name="det_costos", schema = "retys_v2")

public class DetCosto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer diasVigencia;
	private Boolean seEstableceVigencia;
	private Boolean sePuedeBanco;
	private Boolean sePuedeDependencia;
	private Boolean sePuedeOficina;
	private Boolean sePuedeOnline;
	private Boolean sePuedeOtro;
	private Boolean sePuedeTienda;
	private Boolean situacion;
	private Boolean tieneMontoDerechos;
	private String articuloLeyReglamento;
	private String otraLey;
	private CatMomentoRealizaPago catMomentoRealizaPago;
	private CatUnidade catUnidade;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
//	private List<DetMedioBanco> detMedioBancos;
//	private List<DetMedioDependencia> detMedioDependencias;
//	private List<DetMedioOficina> detMedioOficinas;
//	private List<DetMedioOnline> detMedioOnlines;
//	private List<DetMedioOtro> detMedioOtros;
//	private List<DetMedioTienda> detMedioTiendas;
	private CatLeye catLeye;
//	private List<DetConceptosCosto> detConceptosCostos;
	private CatTipoConcepto catTipoConcepto;
	private CatFijoOCalculado catFijoOCalculado;
	private String metodoCalcular;
//	private List<CrcObservacionesCosto> crcObservacionesCostos;

	public DetCosto() {
	}
	
	public DetCosto(Long id) {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="dias_vigencia")
	public Integer getDiasVigencia() {
		return this.diasVigencia;
	}

	public void setDiasVigencia(Integer diasVigencia) {
		this.diasVigencia = diasVigencia;
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
		return tieneMontoDerechos;
	}

	public void setTieneMontoDerechos(Boolean tieneMontoDerechos) {
		this.tieneMontoDerechos = tieneMontoDerechos;
	}
	
	@Column(name="articulo_ley_reglamento")
	public String getArticuloLeyReglamento() {
		return this.articuloLeyReglamento;
	}

	public void setArticuloLeyReglamento(String articuloLeyReglamento) {
		this.articuloLeyReglamento = articuloLeyReglamento;
	}
	
	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}
	
	
	@Column(name="metodo_calcular")
	public String getMetodoCalcular() {
		return this.metodoCalcular;
	}

	public void setMetodoCalcular(String metodoCalcular) {
		this.metodoCalcular = metodoCalcular;
	}
	
	


	//bi-directional many-to-one association to CatMomentoRealizaPago
	@ManyToOne
	@JoinColumn(name="id_momento_realiza_pago")
	public CatMomentoRealizaPago getCatMomentoRealizaPago() {
		return this.catMomentoRealizaPago;
	}

	public void setCatMomentoRealizaPago(CatMomentoRealizaPago catMomentoRealizaPago) {
		this.catMomentoRealizaPago = catMomentoRealizaPago;
	}


	//bi-directional many-to-one association to CatUnidade
	@ManyToOne
	@JoinColumn(name="id_unidad_dias_vigencia")
	public CatUnidade getCatUnidade() {
		return this.catUnidade;
	}

	public void setCatUnidade(CatUnidade catUnidade) {
		this.catUnidade = catUnidade;
	}


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


	//bi-directional many-to-one association to DetMedioBanco
//	@OneToMany(mappedBy="detCosto")
//	public List<DetMedioBanco> getDetMedioBancos() {
//		return this.detMedioBancos;
//	}
	
	//bi-directional many-to-one association to CatLeye
		@ManyToOne
		@JoinColumn(name="id_fundamento_juridico")
		public CatLeye getCatLeye() {
			return this.catLeye;
		}

		public void setCatLeye(CatLeye catLeye) {
			this.catLeye = catLeye;
		}
	

//	public void setDetMedioBancos(List<DetMedioBanco> detMedioBancos) {
//		this.detMedioBancos = detMedioBancos;
//	}
//
//	public DetMedioBanco addDetMedioBanco(DetMedioBanco detMedioBanco) {
//		getDetMedioBancos().add(detMedioBanco);
//		detMedioBanco.setDetCosto(this);
//
//		return detMedioBanco;
//	}
//
//	public DetMedioBanco removeDetMedioBanco(DetMedioBanco detMedioBanco) {
//		getDetMedioBancos().remove(detMedioBanco);
//		detMedioBanco.setDetCosto(null);
//
//		return detMedioBanco;
//	}


	//bi-directional many-to-one association to DetMedioDependencia
//	@OneToMany(mappedBy="detCosto")
//	public List<DetMedioDependencia> getDetMedioDependencias() {
//		return this.detMedioDependencias;
//	}
//
//	public void setDetMedioDependencias(List<DetMedioDependencia> detMedioDependencias) {
//		this.detMedioDependencias = detMedioDependencias;
//	}
//
//	public DetMedioDependencia addDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().add(detMedioDependencia);
//		detMedioDependencia.setDetCosto(this);
//
//		return detMedioDependencia;
//	}

//	public DetMedioDependencia removeDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().remove(detMedioDependencia);
//		detMedioDependencia.setDetCosto(null);
//
//		return detMedioDependencia;
//	}


	//bi-directional many-to-one association to DetMedioOficina
//	@OneToMany(mappedBy="detCosto")
//	public List<DetMedioOficina> getDetMedioOficinas() {
//		return this.detMedioOficinas;
//	}
//
//	public void setDetMedioOficinas(List<DetMedioOficina> detMedioOficinas) {
//		this.detMedioOficinas = detMedioOficinas;
//	}
//
//	public DetMedioOficina addDetMedioOficina(DetMedioOficina detMedioOficina) {
//		getDetMedioOficinas().add(detMedioOficina);
//		detMedioOficina.setDetCosto(this);
//
//		return detMedioOficina;
//	}
//
//	public DetMedioOficina removeDetMedioOficina(DetMedioOficina detMedioOficina) {
//		getDetMedioOficinas().remove(detMedioOficina);
//		detMedioOficina.setDetCosto(null);
//
//		return detMedioOficina;
//	}


	//bi-directional many-to-one association to DetMedioOnline
//	@OneToMany(mappedBy="detCosto")
//	public List<DetMedioOnline> getDetMedioOnlines() {
//		return this.detMedioOnlines;
//	}
//
//	public void setDetMedioOnlines(List<DetMedioOnline> detMedioOnlines) {
//		this.detMedioOnlines = detMedioOnlines;
//	}
//
//	public DetMedioOnline addDetMedioOnline(DetMedioOnline detMedioOnline) {
//		getDetMedioOnlines().add(detMedioOnline);
//		detMedioOnline.setDetCosto(this);
//
//		return detMedioOnline;
//	}
//
//	public DetMedioOnline removeDetMedioOnline(DetMedioOnline detMedioOnline) {
//		getDetMedioOnlines().remove(detMedioOnline);
//		detMedioOnline.setDetCosto(null);
//
//		return detMedioOnline;
//	}


	//bi-directional many-to-one association to DetMedioOtro
//	@OneToMany(mappedBy="detCosto")
//	public List<DetMedioOtro> getDetMedioOtros() {
//		return this.detMedioOtros;
//	}
//
//	public void setDetMedioOtros(List<DetMedioOtro> detMedioOtros) {
//		this.detMedioOtros = detMedioOtros;
//	}
//
//	public DetMedioOtro addDetMedioOtro(DetMedioOtro detMedioOtro) {
//		getDetMedioOtros().add(detMedioOtro);
//		detMedioOtro.setDetCosto(this);
//
//		return detMedioOtro;
//	}
//
//	public DetMedioOtro removeDetMedioOtro(DetMedioOtro detMedioOtro) {
//		getDetMedioOtros().remove(detMedioOtro);
//		detMedioOtro.setDetCosto(null);
//
//		return detMedioOtro;
//	}


	//bi-directional many-to-one association to DetMedioTienda
//	@OneToMany(mappedBy="detCosto")
//	public List<DetMedioTienda> getDetMedioTiendas() {
//		return this.detMedioTiendas;
//	}
//
//	public void setDetMedioTiendas(List<DetMedioTienda> detMedioTiendas) {
//		this.detMedioTiendas = detMedioTiendas;
//	}
//
//	public DetMedioTienda addDetMedioTienda(DetMedioTienda detMedioTienda) {
//		getDetMedioTiendas().add(detMedioTienda);
//		detMedioTienda.setDetCosto(this);
//
//		return detMedioTienda;
//	}
//
//	public DetMedioTienda removeDetMedioTienda(DetMedioTienda detMedioTienda) {
//		getDetMedioTiendas().remove(detMedioTienda);
//		detMedioTienda.setDetCosto(null);
//
//		return detMedioTienda;
//	}
	
	//bi-directional many-to-one association to DetConceptosCosto
//	@OneToMany(mappedBy="detCosto")
//	public List<DetConceptosCosto> getDetConceptosCostos() {
//		return this.detConceptosCostos;
//	}
//
//	public void setDetConceptosCostos(List<DetConceptosCosto> detConceptosCostos) {
//		this.detConceptosCostos = detConceptosCostos;
//	}
//
//	public DetConceptosCosto addDetConceptosCosto(DetConceptosCosto detConceptosCosto) {
//		getDetConceptosCostos().add(detConceptosCosto);
//		detConceptosCosto.setDetCosto(this);
//
//		return detConceptosCosto;
//	}
//
//	public DetConceptosCosto removeDetConceptosCosto(DetConceptosCosto detConceptosCosto) {
//		getDetConceptosCostos().remove(detConceptosCosto);
//		detConceptosCosto.setDetCosto(null);
//
//		return detConceptosCosto;
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
	
	//bi-directional many-to-one association to CatFijoOCalculado
	@ManyToOne
	@JoinColumn(name="id_fijo_o_calculado")
	public CatFijoOCalculado getCatFijoOCalculado() {
		return this.catFijoOCalculado;
	}

	public void setCatFijoOCalculado(CatFijoOCalculado catFijoOCalculado) {
		this.catFijoOCalculado = catFijoOCalculado;
	}
	
	//bi-directional many-to-one association to CrcObservacionesCosto
//	@OneToMany(mappedBy="detCosto")
//	public List<CrcObservacionesCosto> getCrcObservacionesCostos() {
//		return this.crcObservacionesCostos;
//	}
//
//	public void setCrcObservacionesCostos(List<CrcObservacionesCosto> crcObservacionesCostos) {
//		this.crcObservacionesCostos = crcObservacionesCostos;
//	}
//
//	public CrcObservacionesCosto addCrcObservacionesCosto(CrcObservacionesCosto crcObservacionesCosto) {
//		getCrcObservacionesCostos().add(crcObservacionesCosto);
//		crcObservacionesCosto.setDetCosto(this);
//
//		return crcObservacionesCosto;
//	}
//
//	public CrcObservacionesCosto removeCrcObservacionesCosto(CrcObservacionesCosto crcObservacionesCosto) {
//		getCrcObservacionesCostos().remove(crcObservacionesCosto);
//		crcObservacionesCosto.setDetCosto(null);
//
//		return crcObservacionesCosto;
//	}
	
}