package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_online database table.
 * 
 */
@Entity
@Table(name="det_medio_online", schema = "retys_v2")
@NamedQueries({ 
	@NamedQuery(name="DetMedioOnline.findAll", query="SELECT d FROM DetMedioOnline d"),
	
	@NamedQuery(name="DetMedioOnline.findByIdCosto"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioOnlineDTO "
			+ "("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.id is not null then dmoHist.id else dmo.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.articuloLeyReglamento is not null then dmoHist.articuloLeyReglamento else dmo.articuloLeyReglamento end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.comoRealizaPago is not null then dmoHist.comoRealizaPago else dmo.comoRealizaPago end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.numerosReferencia is not null then dmoHist.numerosReferencia else dmo.numerosReferencia end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.otraLey is not null then dmoHist.otraLey else dmo.otraLey end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.url is not null then dmoHist.url else dmo.url end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmoHist.situacion is not null then dmoHist.situacion else dmo.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.id is not null then clHist.id else cl.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.nombre is not null then clHist.nombre else cl.nombre end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.situacion is not null then clHist.situacion else cl.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and cftHist.id is not null then cftHist.id else cft.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dcHist.id is not null then dcHist.id else dc.id end " 
//			+ "dmo.id"
//			+ ", dmo.articuloLeyReglamento"
//			+ ", dmo.comoRealizaPago"
//			+ ", dmo.numerosReferencia"
//			+ ", dmo.otraLey"
//			+ ", dmo.url"
//			+ ", dmo.situacion"
//			+ ", cl.id" 
//			+ ", cl.nombre"
//			+ ", cl.situacion"		
//			+ ", cft.id"
//			+ ", dc.id"
			+ ")"
			+ "FROM DetMedioOnline dmo "
			+ "join dmo.crcFlujoTramite cft "
			+ "join dmo.detCosto dc "
			+ "join dmo.catLeye cl "
			
			+ "left join dmo.detMedioOnlineHist dmoHist "
			+ "join dmoHist.crcFlujoTramite cftHist "
			+ "join dmoHist.detCosto dcHist "
			+ "join dmoHist.catLeye clHist "

            + "join cft.catEtapasTramite cet "
            + "join cft.catEstatusTramite cestt "
			
			+ "where dc.id = :idCosto "
			+ "and dmo.situacion = true"
			)
	
})

public class DetMedioOnline implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String comoRealizaPago;
	private String numerosReferencia;
	private String otraLey;
	private String url;
	private Boolean situacion;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCosto detCosto;
	private DetMedioOnlineHist detMedioOnlineHist;

	public DetMedioOnline() {
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


	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	@JoinColumn(name="id_flujo_tramite")
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

	@OneToOne
	@JoinColumn(name="id")
	public DetMedioOnlineHist getDetMedioOnlineHist() {
		return detMedioOnlineHist;
	}

	public void setDetMedioOnlineHist(DetMedioOnlineHist detMedioOnlineHist) {
		this.detMedioOnlineHist = detMedioOnlineHist;
	}
	

}