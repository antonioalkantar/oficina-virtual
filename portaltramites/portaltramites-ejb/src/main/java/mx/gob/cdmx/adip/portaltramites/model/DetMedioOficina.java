package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_oficina database table.
 * 
 */
@Entity
@Table(name="det_medio_oficina", schema = "retys_v2")
@NamedQueries({ 
	@NamedQuery(name="DetMedioOficina.findAll", query="SELECT d FROM DetMedioOficina d"),
	
	@NamedQuery(name="DetMedioOficina.findByIdCosto"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioOficinaDTO " 
			+ "("
			+ "dmo.id"
			+ ", dmo.articuloLeyReglamento"
			+ ", dmo.comoRealizaPago"			
			+ ", dmo.numerosReferencia"
			+ ", dmo.otraLey"			
			+ ", dmo.situacion"
			+ ", cl.id" 
			+ ", cl.nombre"
			+ ", cl.situacion"
			+ ", dmo.nombreOficinaTributaria" 			
			+ ", cft.id"
			+ ", dc.id"
			+ ")"
			+ "FROM DetMedioOficina dmo "
			+ "join dmo.crcFlujoTramite cft "
			+ "join dmo.detCosto dc "
			+ "join dmo.catLeye cl "			
			+ "where dc.id = :idCosto "
			+ "and dmo.situacion = true"
			)
	
})

public class DetMedioOficina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String comoRealizaPago;
	private String numerosReferencia;
	private String otraLey;
	private String nombreOficinaTributaria;
	private Boolean situacion;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCosto detCosto;

	public DetMedioOficina() {
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
	
	@Column(name="nombre_oficina_tributaria")
	public String getNombreOficinaTributaria() {
		return this.nombreOficinaTributaria;
	}

	public void setNombreOficinaTributaria(String nombreOficinaTributaria) {
		this.nombreOficinaTributaria = nombreOficinaTributaria;
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

}