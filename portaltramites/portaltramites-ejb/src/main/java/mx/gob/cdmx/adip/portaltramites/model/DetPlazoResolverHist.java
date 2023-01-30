package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_plazo_resolver_hist database table.
 * 
 */
@Entity
@Table(name="det_plazo_resolver_hist", schema = "retys_v2")
@NamedQuery(name="DetPlazoResolverHist.findAll", query="SELECT d FROM DetPlazoResolverHist d")
public class DetPlazoResolverHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamentoResolver;
	private Long idFundamentoJuridicoResolver;
	private String otraLeyResolver;
	private Integer plazoResolver;
	private Boolean tieneFundamentoResolver;
	private DetPlazoMaximoRespuestaHist detPlazoMaximoRespuestaHist;
	private CatUnidade catUnidade;

	public DetPlazoResolverHist() {
	}


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="articulo_ley_reglamento_resolver")
	public String getArticuloLeyReglamentoResolver() {
		return this.articuloLeyReglamentoResolver;
	}

	public void setArticuloLeyReglamentoResolver(String articuloLeyReglamentoResolver) {
		this.articuloLeyReglamentoResolver = articuloLeyReglamentoResolver;
	}


	@Column(name="id_fundamento_juridico_resolver")
	public Long getIdFundamentoJuridicoResolver() {
		return this.idFundamentoJuridicoResolver;
	}

	public void setIdFundamentoJuridicoResolver(Long idFundamentoJuridicoResolver) {
		this.idFundamentoJuridicoResolver = idFundamentoJuridicoResolver;
	}


	//bi-directional many-to-one association to CatUnidade
	@ManyToOne
	@JoinColumn(name="id_unidad_plazo_resolver")
	public CatUnidade getCatUnidade() {
		return this.catUnidade;
	}

	public void setCatUnidade(CatUnidade catUnidade) {
		this.catUnidade = catUnidade;
	}


	@Column(name="otra_ley_resolver")
	public String getOtraLeyResolver() {
		return this.otraLeyResolver;
	}

	public void setOtraLeyResolver(String otraLeyResolver) {
		this.otraLeyResolver = otraLeyResolver;
	}


	@Column(name="plazo_resolver")
	public Integer getPlazoResolver() {
		return this.plazoResolver;
	}

	public void setPlazoResolver(Integer plazoResolver) {
		this.plazoResolver = plazoResolver;
	}


	@Column(name="tiene_fundamento_resolver")
	public Boolean getTieneFundamentoResolver() {
		return this.tieneFundamentoResolver;
	}

	public void setTieneFundamentoResolver(Boolean tieneFundamentoResolver) {
		this.tieneFundamentoResolver = tieneFundamentoResolver;
	}


	//bi-directional many-to-one association to DetPlazoMaximoRespuesta
	@ManyToOne
	@JoinColumn(name="id_plazo_maximo")
	public DetPlazoMaximoRespuestaHist getDetPlazoMaximoRespuestaHist() {
		return detPlazoMaximoRespuestaHist;
	}


	public void setDetPlazoMaximoRespuestaHist(DetPlazoMaximoRespuestaHist detPlazoMaximoRespuestaHist) {
		this.detPlazoMaximoRespuestaHist = detPlazoMaximoRespuestaHist;
	}

}