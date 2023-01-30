package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_requisitos_formato database table.
 * 
 */
@Entity
@Table(name="det_requisitos_formato", schema = "retys_v2")

@NamedQueries({
	@NamedQuery(name="DetRequisitosFormato.findAll"
	, query="SELECT d FROM DetRequisitosFormato d")
	, @NamedQuery(name="DetRequisitosFormato.findByIdHist"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetRequisitosFormatoDTO "
			+ "("
			+ " d.id,"
			+ "d.articuloLeyReglamento, "
			+ "d.otraLey, "
			+ "d.parteDelFormato,"
			+ "d.detalleRequisito, "
			+ "d.catLeye.id, "
			+ "cat.nombre, "
			+ "df.id, "
			+ "cft.id"
			+ " ) "
			+ " FROM DetRequisitosFormatoHist d "
			+ " JOIN d.catLeye cat "
			+ " JOIN d.detFormato df "
			+ " JOIN df.tramiteServicio ts "
			+ " JOIN ts.crcFlujoTramites cft "
			+ " join cft.catEtapasTramite cet "
			+ " join cft.catEstatusTramite cestt "		
			+ " WHERE  d.detFormato.id  = :detFormatoid  "
			+ " and d.situacion = TRUE "
			+ " and cestt.id = 2 "
			+ " and cet.esProcesoFinal = false"
			+ " order by d.id")	

	, @NamedQuery(name="DetRequisitosFormato.findById"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetRequisitosFormatoDTO "
			+ "("
			+ " d.id,"
			+ "d.articuloLeyReglamento, "
			+ "d.otraLey, "
			+ "d.parteDelFormato,"
			+ "d.detalleRequisito, "
			+ "d.catLeye.id, "
			+ "cat.nombre, "
			+ "df.id, "
			+ "cft.id"
			+ " ) "
			+ " FROM DetRequisitosFormato d "
			+ " JOIN d.catLeye cat "
			+ " JOIN d.detFormato df "
			+ " JOIN d.crcFlujoTramite cft "
			+ " join cft.catEtapasTramite cet "
			+ " join cft.catEstatusTramite cestt "
			
			+ " WHERE  d.detFormato.id  = :detFormatoid  "
			+ " and d.situacion = TRUE "
			+ " order by d.id"),	
})

public class DetRequisitosFormato implements Serializable {
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
	private DetRequisitosFormatoHist detRequisitosFormatoHist;
	
	public DetRequisitosFormato() {
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
	public DetRequisitosFormatoHist getDetRequisitosFormatoHist() {
		return detRequisitosFormatoHist;
	}

	public void setDetRequisitosFormatoHist(DetRequisitosFormatoHist detRequisitosFormatoHist) {
		this.detRequisitosFormatoHist = detRequisitosFormatoHist;
	}
	
	

}