package mx.gob.cdmx.adip.portaltramites.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the det_requisitos_modalidad_hist database table.
 * 
 */
@Entity
@Table(name="det_requisitos_modalidad_hist", schema = "retys_v2")
@NamedQuery(name="DetRequisitosModalidadHist.findAll", query="SELECT d FROM DetRequisitosModalidadHist d")
public class DetRequisitosModalidadHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String detalleRequisito;
	//private Long idFlujoTramite;
	//private Long idFundamentoLegal;
	//private Long idModalidadTramite;
	private String otraLey;
	private Boolean replicaEnModalidades;
	private Boolean situacion;
	
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	
	private DetRequisitosModalidad detRequisitoModalidad;
	private List<CrcModRequisitoModalidad> crcModRequisitoModalidads;

	public DetRequisitosModalidadHist() {
	}


	@Id
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


	@Column(name="detalle_requisito")
	public String getDetalleRequisito() {
		return this.detalleRequisito;
	}

	public void setDetalleRequisito(String detalleRequisito) {
		this.detalleRequisito = detalleRequisito;
	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	@Column(name="replica_en_modalidades")
	public Boolean getReplicaEnModalidades() {
		return this.replicaEnModalidades;
	}

	public void setReplicaEnModalidades(Boolean replicaEnModalidades) {
		this.replicaEnModalidades = replicaEnModalidades;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetRequisitosModalidad getDetRequisitoModalidad() {
		return detRequisitoModalidad;
	}


	public void setDetRequisitoModalidad(DetRequisitosModalidad detRequisitoModalidad) {
		this.detRequisitoModalidad = detRequisitoModalidad;
	}

	@ManyToOne
	@JoinColumn(name="id_fundamento_legal")
	public CatLeye getCatLeye() {
		return catLeye;
	}


	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}

	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return crcFlujoTramite;
	}


	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	@ManyToOne
	@JoinColumn(name="id_modalidad_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return detModalidadesTramite;
	}


	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	//bi-directional many-to-one association to CrcModRequisitoModalidad
	@OneToMany(mappedBy="detRequisitosModalidad")
	public List<CrcModRequisitoModalidad> getCrcModRequisitoModalidads() {
		return this.crcModRequisitoModalidads;
	}

	public void setCrcModRequisitoModalidads(List<CrcModRequisitoModalidad> crcModRequisitoModalidads) {
		this.crcModRequisitoModalidads = crcModRequisitoModalidads;
	}
}