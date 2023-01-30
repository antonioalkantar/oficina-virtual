package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_banco database table.
 * 
 */
@Entity
@Table(name="det_medio_banco", schema = "retys_v2")
@NamedQueries({ 
	@NamedQuery(name="DetMedioBanco.findAll", query="SELECT d FROM DetMedioBanco d") ,
	
	@NamedQuery(name="DetMedioBanco.findByIdCosto"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioBancoDTO "
			+ "("
			+ "dmb.id "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then dmbHist.articuloLeyReglamento else dmb.articuloLeyReglamento end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then dmbHist.comoRealizaPago else dmb.comoRealizaPago end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then dmbHist.nombre else dmb.nombre end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then dmbHist.numerosReferencia else dmb.numerosReferencia end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then dmbHist.otraLey else dmb.otraLey end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then dmbHist.situacion else dmb.situacion end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then clHist.id else cl.id end " 
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then clHist.nombre else cl.nombre end "
			+ ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmbHist.id is not null then clHist.situacion else cl.situacion end "	
			+ ", cft.id "
			+ ", dc.id "
			+ ")"
			+ "FROM DetMedioBanco dmb "
			+ "join dmb.detCosto dc "
			+ "join dmb.catLeye cl "

			+ "left join dmb.detMedioBancoHist dmbHist "
			+ "left join dmbHist.catLeye clHist "

			+ "join dmb.crcFlujoTramite cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cestt "
			+ "join cft.catTipoSolicitud cts "
			+ "where dc.id = :idCosto "
			+ "and dmb.situacion = true"
			)
})

public class DetMedioBanco implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String comoRealizaPago;
	private String nombre;
	private String numerosReferencia;
	private String otraLey;
	private Boolean situacion;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCosto detCosto;
	private DetMedioBancoHist detMedioBancoHist;

	public DetMedioBanco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="como_realiza_pago")
	public String getComoRealizaPago() {
		return this.comoRealizaPago;
	}

	public void setComoRealizaPago(String comoRealizaPago) {
		this.comoRealizaPago = comoRealizaPago;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="numeros_referencia")
	public String getNumerosReferencia() {
		return this.numerosReferencia;
	}

	public void setNumerosReferencia(String numerosReferencia) {
		this.numerosReferencia = numerosReferencia;
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


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
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


	//bi-directional many-to-one association to DetCosto
	@ManyToOne
	@JoinColumn(name="id_costos")
	public DetCosto getDetCosto() {
		return this.detCosto;
	}

	public void setDetCosto(DetCosto detCosto) {
		this.detCosto = detCosto;
	}


	//bi-directional many-to-one association to TramiteServicioHist
	@OneToOne
	@JoinColumn(name="id")
	public DetMedioBancoHist getDetMedioBancoHist() {
		return detMedioBancoHist;
	}


	public void setDetMedioBancoHist(DetMedioBancoHist detMedioBancoHist) {
		this.detMedioBancoHist = detMedioBancoHist;
	}

}