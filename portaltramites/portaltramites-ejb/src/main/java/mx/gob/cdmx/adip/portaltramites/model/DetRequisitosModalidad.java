package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



/**
 * The persistent class for the det_requisitos_modalidad database table.
 * 
 */
@Entity
@Table(name="det_requisitos_modalidad", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetRequisitosModalidad.findAll"
	, query="SELECT d FROM DetRequisitosModalidad d"),
	@NamedQuery(name="DetRequisitosModalidad.findByIdTramiteII",
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetRequisitosModalidadDTO("
			+ "d.id"
			+ ", d.articuloLeyReglamento"
			+ ", d.detalleRequisito"
			+ ", d.otraLey"
			+ ", d.situacion"
			+ ", l.id"
			+ ", l.nombre"
			+ ", ft.id"
			+ ", mt.id"
			+ ", d.replicaEnModalidades) "
			+ "FROM DetRequisitosModalidad d "
			+ "join d.catLeye l "
			+ "join d.detModalidadesTramite mt "
			+ "join mt.tramiteServicio ts  "
			+ "join ts.crcFlujoTramites ft "
			+ "left join d.crcModRequisitoModalidads mrm "			
			+ "where "
			+ "( "
			+ "(mt.id <> :idModalidad and ts.id=:idTramite and d.replicaEnModalidades = true) "
			+ "or (mt.id = :idModalidad) "
			+ ") "
			+ "and d.situacion = true "
			+ "and "
			+ "( "
			+ "mrm.estatusCampo is null or  mrm.estatusCampo <> 3"
			+ ") "
			+ "order by d.id"),
	@NamedQuery(name="DetRequisitosModalidad.findByIdTramiteHist",
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetRequisitosModalidadDTO("
			+ "  d.id "
			+ ", d.articuloLeyReglamento "
			+ ", d.detalleRequisito "
			+ ", d.otraLey "
			+ ", d.situacion "
			+ ", l.id "
			+ ", l.nombre "
			+ ", cft.id "
			+ ", mt.id "
			+ ", d.replicaEnModalidades ) "
			+ "FROM DetRequisitosModalidadHist d "
			+ "join d.catLeye l "
			+ "join d.detModalidadesTramite mt "
			+ "join mt.tramiteServicio ts  "			
			+ "join ts.crcFlujoTramites cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cett "
			+ "left join d.crcModRequisitoModalidads mrm "			
			+ "where "
			+ "( "
			+ "(mt.id <> :idModalidad and ts.id=:idTramite and d.replicaEnModalidades = true) "
			+ "or (mt.id = :idModalidad) "
			+ ") "
			+ "and d.situacion = true "
			+ "and "
			+ "( "
			+ "mrm.estatusCampo is null or  mrm.estatusCampo <> 3"
			+ ") "
			+ "and cett.id = 2 "
			+ "and cet.esProcesoFinal = false "
			+ "order by d.id"),
})
public class DetRequisitosModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String detalleRequisito;
	private String otraLey;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	private Boolean situacion;
	private Boolean replicaEnModalidades;
	private DetRequisitosModalidadHist detRequisitoModalidadHist;
	private List<CrcModRequisitoModalidad> crcModRequisitoModalidads;

	public DetRequisitosModalidad() {
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


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_legal")
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


	//bi-directional many-to-one association to DetRequisitosModalidad
	@ManyToOne
	@JoinColumn(name="id_modalidad_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@Column(name="replica_en_modalidades")
	public Boolean getReplicaEnModalidades() {
		return replicaEnModalidades;
	}


	public void setReplicaEnModalidades(Boolean replicaEnModalidades) {
		this.replicaEnModalidades = replicaEnModalidades;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetRequisitosModalidadHist getDetRequisitoModalidadHist() {
		return detRequisitoModalidadHist;
	}


	public void setDetRequisitoModalidadHist(DetRequisitosModalidadHist detRequisitoModalidadHist) {
		this.detRequisitoModalidadHist = detRequisitoModalidadHist;
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