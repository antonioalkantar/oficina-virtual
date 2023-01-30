package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_requisitos_formato_hist database table.
 * 
 */
@Entity
@Table(name="det_requisitos_formato_hist", schema = "retys_v2")
@NamedQuery(name="DetRequisitosFormatoHist.findAll", query="SELECT d FROM DetRequisitosFormatoHist d")
public class DetRequisitosFormatoHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String detalleRequisito;
	private String otraLey;
	private Boolean parteDelFormato;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private DetFormato detFormato;
	private Boolean situacion;
	private DetRequisitosFormato detRequisitosFormato;

	public DetRequisitosFormatoHist() {
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


	@Column(name="parte_del_formato")
	public Boolean getParteDelFormato() {
		return this.parteDelFormato;
	}

	public void setParteDelFormato(Boolean parteDelFormato) {
		this.parteDelFormato = parteDelFormato;
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


	//bi-directional many-to-one association to DetFormato
	@ManyToOne
	@JoinColumn(name="id_formato")
	public DetFormato getDetFormato() {
		return this.detFormato;
	}

	public void setDetFormato(DetFormato detFormato) {
		this.detFormato = detFormato;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetRequisitosFormato getDetRequisitosFormato() {
		return detRequisitosFormato;
	}

	public void setDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
		this.detRequisitosFormato = detRequisitosFormato;
	}

	
}