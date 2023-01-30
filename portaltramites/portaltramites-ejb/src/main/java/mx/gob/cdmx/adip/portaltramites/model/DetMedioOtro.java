package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_otro database table.
 * 
 */
@Entity
@Table(name="det_medio_otro", schema = "retys_v2")
@NamedQueries({ 
	@NamedQuery(name="DetMedioOtro.findAll", query="SELECT d FROM DetMedioOtro d"),
	
	@NamedQuery(name="DetMedioOtro.findByIdCosto"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioOtroDTO "  
			+ "("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.id is not null then dmot.id else dmot.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.articuloLeyReglamento is not null then dmotHist.articuloLeyReglamento else dmot.articuloLeyReglamento end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.comoRealizaPago is not null then dmotHist.comoRealizaPago else dmot.comoRealizaPago end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.nombreMedio is not null then dmotHist.nombreMedio else dmot.nombreMedio end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.numerosReferencia is not null then dmotHist.numerosReferencia else dmot.numerosReferencia end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.otraLey is not null then dmotHist.otraLey else dmot.otraLey end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dmotHist.situacion is not null then dmotHist.situacion else dmot.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.id is not null then clHist.id else cl.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.nombre is not null then clHist.nombre else cl.nombre end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and clHist.situacion is not null then clHist.situacion else cl.situacion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and cftHist.id is not null then cftHist.id else cft.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dcHist.id is not null then dcHist.id else dc.id end " 
//			+ "dmot.id"
//			+ ", dmot.articuloLeyReglamento"
//			+ ", dmot.comoRealizaPago"
//			+ ", dmot.nombreMedio"
//			+ ", dmot.numerosReferencia"
//			+ ", dmot.otraLey"			
//			+ ", dmot.situacion"
//			+ ", cl.id" 
//			+ ", cl.nombre"
//			+ ", cl.situacion"		
//			+ ", cft.id"
//			+ ", dc.id"
			+ ")"
			+ "FROM DetMedioOtro dmot "
			+ "join dmot.crcFlujoTramite cft "
			+ "join dmot.detCosto dc "
			+ "join dmot.catLeye cl "
			
			+ "left join dmot.detMedioOtroHist dmotHist "
			+ "join dmotHist.crcFlujoTramite cftHist "
			+ "join dmotHist.detCosto dcHist "
			+ "join dmotHist.catLeye clHist "
			

            + "join cft.catEtapasTramite cet "
            + "join cft.catEstatusTramite cestt "
			
			+ "where dc.id = :idCosto "
			+ "and dmot.situacion = true"
			)
})

public class DetMedioOtro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String comoRealizaPago;
	private String nombreMedio;
	private String numerosReferencia;
	private String otraLey;
	private Boolean situacion;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCosto detCosto;
	private DetMedioOtroHist detMedioOtroHist;

	public DetMedioOtro() {
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


	@Column(name="nombre_medio")
	public String getNombreMedio() {
		return this.nombreMedio;
	}

	public void setNombreMedio(String nombreMedio) {
		this.nombreMedio = nombreMedio;
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
	
	@OneToOne
	@JoinColumn(name="id")
	public DetMedioOtroHist getDetMedioOtroHist() {
		return detMedioOtroHist;
	}

	public void setDetMedioOtroHist(DetMedioOtroHist detMedioOtroHist) {
		this.detMedioOtroHist = detMedioOtroHist;
	}

}