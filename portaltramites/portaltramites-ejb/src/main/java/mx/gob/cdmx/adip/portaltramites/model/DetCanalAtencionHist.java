package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_canal_atencion_hist database table.
 * 
 */
@Entity
@Table(name="det_canal_atencion_hist", schema = "retys_v2")
@NamedQuery(name="DetCanalAtencionHist.findAll", query="SELECT d FROM DetCanalAtencionHist d")
public class DetCanalAtencionHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private Long idFlujoTramite;
	private Long idFundamentoJuridico;
	private Long idTipoMedio;
	private String otraLey;
	private Boolean puedeRealizarseDigitalmente;
	private Boolean puedeRealizarsePresencialmente;
	private Boolean puedeRealizarseTelefonicamente;
	private Boolean tieneFundamentoJuridico;
	private TramiteServicio tramiteServicio;

	public DetCanalAtencionHist() {
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


	@Column(name="id_flujo_tramite")
	public Long getIdFlujoTramite() {
		return this.idFlujoTramite;
	}

	public void setIdFlujoTramite(Long idFlujoTramite) {
		this.idFlujoTramite = idFlujoTramite;
	}


	@Column(name="id_fundamento_juridico")
	public Long getIdFundamentoJuridico() {
		return this.idFundamentoJuridico;
	}

	public void setIdFundamentoJuridico(Long idFundamentoJuridico) {
		this.idFundamentoJuridico = idFundamentoJuridico;
	}


	@Column(name="id_tipo_medio")
	public Long getIdTipoMedio() {
		return this.idTipoMedio;
	}

	public void setIdTipoMedio(Long idTipoMedio) {
		this.idTipoMedio = idTipoMedio;
	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	@Column(name="puede_realizarse_digitalmente")
	public Boolean getPuedeRealizarseDigitalmente() {
		return this.puedeRealizarseDigitalmente;
	}

	public void setPuedeRealizarseDigitalmente(Boolean puedeRealizarseDigitalmente) {
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
	}


	@Column(name="puede_realizarse_presencialmente")
	public Boolean getPuedeRealizarsePresencialmente() {
		return this.puedeRealizarsePresencialmente;
	}

	public void setPuedeRealizarsePresencialmente(Boolean puedeRealizarsePresencialmente) {
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
	}


	@Column(name="puede_realizarse_telefonicamente")
	public Boolean getPuedeRealizarseTelefonicamente() {
		return this.puedeRealizarseTelefonicamente;
	}

	public void setPuedeRealizarseTelefonicamente(Boolean puedeRealizarseTelefonicamente) {
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
	}


	@Column(name="tiene_fundamento_juridico")
	public Boolean getTieneFundamentoJuridico() {
		return this.tieneFundamentoJuridico;
	}

	public void setTieneFundamentoJuridico(Boolean tieneFundamentoJuridico) {
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
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

}