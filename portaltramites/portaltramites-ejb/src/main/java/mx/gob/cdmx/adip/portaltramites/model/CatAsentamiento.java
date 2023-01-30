package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_asentamientos database table.
 * 
 */
@Entity
@Table(name="cat_asentamientos", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatAsentamiento.findAll", query="SELECT c FROM CatAsentamiento c"),
	@NamedQuery(name="CatAsentamiento.findPorAlcaldia"
	, query="SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.CatAsentamientosDTO(c.idAsentamiento, c.asentamiento) "
			+ " FROM CatAsentamiento c "
			+ " INNER JOIN c.catAlcaldia alc"
			+ " WHERE alc.idAlcaldia=:idMunicipio")  
})

public class CatAsentamiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idAsentamiento;
	private String asentamiento;
	private Integer idAsentamientoAnterior;
	private Integer idAsentamientoPorEdoMun;
	private Integer idMunicipioPorEstado;
	private List<CatAreaAc> catAreaAcs;
	private CatAlcaldia catAlcaldia;
	private CatEstado catEstado;
	private List<CatCodigosPostale> catCodigosPostales;
	private List<DetUnidadesAdmResp> detUnidadesAdmResps;

	public CatAsentamiento() {
	}

	public CatAsentamiento(Integer idAsentamiento) {
		this.idAsentamiento=idAsentamiento;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asentamiento")
	public Integer getIdAsentamiento() {
		return this.idAsentamiento;
	}

	public void setIdAsentamiento(Integer idAsentamiento) {
		this.idAsentamiento = idAsentamiento;
	}


	public String getAsentamiento() {
		return this.asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}


	@Column(name="id_asentamiento_anterior")
	public Integer getIdAsentamientoAnterior() {
		return this.idAsentamientoAnterior;
	}

	public void setIdAsentamientoAnterior(Integer idAsentamientoAnterior) {
		this.idAsentamientoAnterior = idAsentamientoAnterior;
	}


	@Column(name="id_asentamiento_por_edo_mun")
	public Integer getIdAsentamientoPorEdoMun() {
		return this.idAsentamientoPorEdoMun;
	}

	public void setIdAsentamientoPorEdoMun(Integer idAsentamientoPorEdoMun) {
		this.idAsentamientoPorEdoMun = idAsentamientoPorEdoMun;
	}


	@Column(name="id_municipio_por_estado")
	public Integer getIdMunicipioPorEstado() {
		return this.idMunicipioPorEstado;
	}

	public void setIdMunicipioPorEstado(Integer idMunicipioPorEstado) {
		this.idMunicipioPorEstado = idMunicipioPorEstado;
	}


	//bi-directional many-to-one association to CatAreaAc
	@OneToMany(mappedBy="catAsentamiento")
	public List<CatAreaAc> getCatAreaAcs() {
		return this.catAreaAcs;
	}

	public void setCatAreaAcs(List<CatAreaAc> catAreaAcs) {
		this.catAreaAcs = catAreaAcs;
	}

	public CatAreaAc addCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().add(catAreaAc);
		catAreaAc.setCatAsentamiento(this);

		return catAreaAc;
	}

	public CatAreaAc removeCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().remove(catAreaAc);
		catAreaAc.setCatAsentamiento(null);

		return catAreaAc;
	}


	//bi-directional many-to-one association to CatAlcaldia
	@ManyToOne
	@JoinColumn(name="id_municipio")
	public CatAlcaldia getCatAlcaldia() {
		return this.catAlcaldia;
	}

	public void setCatAlcaldia(CatAlcaldia catAlcaldia) {
		this.catAlcaldia = catAlcaldia;
	}


	//bi-directional many-to-one association to CatEstado
	@ManyToOne
	@JoinColumn(name="id_estado")
	public CatEstado getCatEstado() {
		return this.catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}


	//bi-directional many-to-one association to CatCodigosPostale
	@OneToMany(mappedBy="catAsentamiento")
	public List<CatCodigosPostale> getCatCodigosPostales() {
		return this.catCodigosPostales;
	}

	public void setCatCodigosPostales(List<CatCodigosPostale> catCodigosPostales) {
		this.catCodigosPostales = catCodigosPostales;
	}

	public CatCodigosPostale addCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().add(catCodigosPostale);
		catCodigosPostale.setCatAsentamiento(this);

		return catCodigosPostale;
	}

	public CatCodigosPostale removeCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().remove(catCodigosPostale);
		catCodigosPostale.setCatAsentamiento(null);

		return catCodigosPostale;
	}

}