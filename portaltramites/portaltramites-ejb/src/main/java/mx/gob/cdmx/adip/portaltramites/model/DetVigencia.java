package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_vigencia database table.
 * 
 */
@Entity
@Table(name="det_vigencia", schema = "retys_v2")

public class DetVigencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;	
	private String otraLey;
	private Boolean tieneFundamentoJuridico;
	private Boolean tieneVigencia;
	private Integer vigencia;
	private CatLeye catLeye;
	private CatUnidade catUnidade;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private CatVigencia catVigencia;
	private Integer vigenciaSuperior;
	private String especificaOtra;

	public DetVigencia() {
	}
	
	public DetVigencia(Long id) {
		this.id=id;
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


	@Column(name="tiene_fundamento_juridico")
	public Boolean getTieneFundamentoJuridico() {
		return this.tieneFundamentoJuridico;
	}

	public void setTieneFundamentoJuridico(Boolean tieneFundamentoJuridico) {
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
	}


	@Column(name="tiene_vigencia")
	public Boolean getTieneVigencia() {
		return this.tieneVigencia;
	}

	public void setTieneVigencia(Boolean tieneVigencia) {
		this.tieneVigencia = tieneVigencia;
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


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
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
	
	@Column(name="especifica_otra")
	public String getEspecificaOtra() {
		return this.especificaOtra;
	}

	public void setEspecificaOtra(String especificaOtra) {
		this.especificaOtra = especificaOtra;
	}

}