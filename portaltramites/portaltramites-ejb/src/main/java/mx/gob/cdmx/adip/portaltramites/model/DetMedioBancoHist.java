package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_medio_banco_hist database table.
 * 
 */
@Entity
@Table(name="det_medio_banco_hist", schema = "retys_v2")
@NamedQuery(name="DetMedioBancoHist.findAll", query="SELECT d FROM DetMedioBancoHist d")
public class DetMedioBancoHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String comoRealizaPago;
	private Long idCostos;
	private Long idFlujoTramitre;
	private String nombre;
	private String numerosReferencia;
	private String otraLey;
	private Boolean situacion;
	private DetMedioBanco detMedioBanco;
	private CatLeye catLeye;

	public DetMedioBancoHist() {
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


	@Column(name="como_realiza_pago")
	public String getComoRealizaPago() {
		return this.comoRealizaPago;
	}

	public void setComoRealizaPago(String comoRealizaPago) {
		this.comoRealizaPago = comoRealizaPago;
	}


	@Column(name="id_costos")
	public Long getIdCostos() {
		return this.idCostos;
	}

	public void setIdCostos(Long idCostos) {
		this.idCostos = idCostos;
	}


	@Column(name="id_flujo_tramitre")
	public Long getIdFlujoTramitre() {
		return this.idFlujoTramitre;
	}

	public void setIdFlujoTramitre(Long idFlujoTramitre) {
		this.idFlujoTramitre = idFlujoTramitre;
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


	//bi-directional many-to-one association to TramiteServicio
	@OneToOne
	@JoinColumn(name="id")
	public DetMedioBanco getDetMedioBanco() {
		return detMedioBanco;
	}


	public void setDetMedioBanco(DetMedioBanco detMedioBanco) {
		this.detMedioBanco = detMedioBanco;
	}


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico")
	public CatLeye getCatLeye() {
		return catLeye;
	}


	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}

}