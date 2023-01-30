package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_tienda database table.
 * 
 */
@Entity
@Table(name="det_medio_tienda", schema = "retys_v2")
@NamedQueries({ 
	@NamedQuery(name="DetMedioTienda.findAll", query="SELECT d FROM DetMedioTienda d"),
	
	@NamedQuery(name="DetMedioTienda.findByIdCosto"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioTiendaDTO "
			+ "("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.id is not null then dmtHist.id else dmt.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.articuloLeyReglamento is not null then dmtHist.articuloLeyReglamento else dmt.articuloLeyReglamento end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.comoRealizaPago is not null then dmtHist.comoRealizaPago else dmt.comoRealizaPago end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.nombre is not null then dmtHist.nombre else dmt.nombre end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.numerosReferencia is not null then dmtHist.numerosReferencia else dmt.numerosReferencia end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.otraLey is not null then dmtHist.otraLey else dmt.otraLey end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmtHist.situacion is not null then dmtHist.situacion else dmt.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.id is not null then clHist.id else cl.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.nombre is not null then clHist.nombre else cl.nombre end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.situacion is not null then clHist.situacion else cl.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and cftHist.id is not null then cftHist.id else cft.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dcHist.id is not null then dcHist.id else dc.id end " 
			
//			+ "dmt.id"
//			+ ", dmt.articuloLeyReglamento"
//			+ ", dmt.comoRealizaPago"
//			+ ", dmt.nombre"
//			+ ", dmt.numerosReferencia"
//			+ ", dmt.otraLey"			
//			+ ", dmt.situacion"
//			+ ", cl.id" 
//			+ ", cl.nombre"
//			+ ", cl.situacion"		
//			+ ", cft.id"
//			+ ", dc.id"
			+ ")"
			+ "FROM DetMedioTienda dmt "
			+ "join dmt.crcFlujoTramite cft "
			+ "join dmt.detCosto dc "
			+ "join dmt.catLeye cl "
			
			+ "left join dmt.detMedioTiendaHist dmtHist "
			+ "join dmtHist.crcFlujoTramite cftHist "
			+ "join dmtHist.detCosto dcHist "
			+ "join dmtHist.catLeye clHist "

            + "join cft.catEtapasTramite cet "
            + "join cft.catEstatusTramite cestt "
			
			+ "where dc.id = :idCosto "
			+ "and dmt.situacion = true"
			)
})

public class DetMedioTienda implements Serializable {
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
	private DetMedioTiendaHist detMedioTiendaHist;

	public DetMedioTienda() {
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
	public DetMedioTiendaHist getDetMedioTiendaHist() {
		return detMedioTiendaHist;
	}

	public void setDetMedioTiendaHist(DetMedioTiendaHist detMedioTiendaHist) {
		this.detMedioTiendaHist = detMedioTiendaHist;
	}
}