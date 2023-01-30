package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_plazo_resolver database table.
 * 
 */
@Entity
@Table(name="det_plazo_resolver", schema = "retys_v2")
@NamedQueries({
})

public class DetPlazoResolver implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamentoResolver;
	private String otraLeyResolver;
	private Integer plazoResolver;
	private Boolean tieneFundamentoResolver;
	private CatLeye catLeye;
	private CatUnidade catUnidade;
	private DetPlazoMaximoRespuesta detPlazoMaximoRespuesta;

	public DetPlazoResolver() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico_resolver")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
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


	//bi-directional many-to-one association to DetPlazoMaximoRespuesta
	@ManyToOne
	@JoinColumn(name="id_plazo_maximo")
	public DetPlazoMaximoRespuesta getDetPlazoMaximoRespuesta() {
		return this.detPlazoMaximoRespuesta;
	}

	public void setDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
		this.detPlazoMaximoRespuesta = detPlazoMaximoRespuesta;
	}

}