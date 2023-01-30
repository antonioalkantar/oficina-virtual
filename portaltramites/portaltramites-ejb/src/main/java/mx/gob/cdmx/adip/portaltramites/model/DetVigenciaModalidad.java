package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_vigencia_modalidad database table.
 * 
 */
@Entity
@Table(name="det_vigencia_modalidad", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetVigenciaModalidad.findAll", query="SELECT d FROM DetVigenciaModalidad d"),
})
public class DetVigenciaModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String otraLey;
	private Integer vigencia;
	private CatLeye catLeye;
	private CatUnidade catUnidade;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	private Integer vigenciaSuperior;
	private CatVigencia catVigencia;
	private String especificaOtra;
	
	private DetVigenciaModalidadHist detVigenciaModHist;

	public DetVigenciaModalidad() {
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


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	public Integer getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
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


	//bi-directional many-to-one association to CatUnidade
	@ManyToOne
	@JoinColumn(name="id_unidad_vigencia")
	public CatUnidade getCatUnidade() {
		return this.catUnidade;
	}

	public void setCatUnidade(CatUnidade catUnidade) {
		this.catUnidade = catUnidade;
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


	//bi-directional many-to-one association to DetModalidadesTramite
	@ManyToOne
	@JoinColumn(name="id_modalidades_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return this.detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}
	
	@Column(name="especifica_otra")
	public String getEspecificaOtra() {
		return this.especificaOtra;
	}

	public void setEspecificaOtra(String especificaOtra) {
		this.especificaOtra = especificaOtra;
	}
	
	@Column(name="vigencia_superior")
	public Integer getVigenciaSuperior() {
		return this.vigenciaSuperior;
	}

	public void setVigenciaSuperior(Integer vigenciaSuperior) {
		this.vigenciaSuperior = vigenciaSuperior;
	}


	//bi-directional many-to-one association to CatVigencia2
	@ManyToOne
	@JoinColumn(name="id_vigencia")
	public CatVigencia getCatVigencia() {
		return this.catVigencia;
	}

	public void setCatVigencia(CatVigencia catVigencia) {
		this.catVigencia = catVigencia;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetVigenciaModalidadHist getDetVigenciaModHist() {
		return detVigenciaModHist;
	}


	public void setDetVigenciaModHist(DetVigenciaModalidadHist detVigenciaModHist) {
		this.detVigenciaModHist = detVigenciaModHist;
	}

}