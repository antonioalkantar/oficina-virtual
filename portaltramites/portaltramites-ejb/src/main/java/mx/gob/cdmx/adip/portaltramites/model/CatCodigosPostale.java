package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_codigos_postales database table.
 * 
 */
@Entity
@Table(name="cat_codigos_postales", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatCodigosPostale.findAll", query="SELECT c FROM CatCodigosPostale c"),
	@NamedQuery(name="CatCodigosPostale.findPorCodigoPostal", 
	query="SELECT  new mx.gob.cdmx.adip.portaltramites.commons.dto.CatCodigosPostalesDTO"
			+ "("
			+ "  c.idCodigoPostal"
			+ ", c.codigoPostal"
			+ ", alc.idAlcaldia"
			+ ", alc.municipio"
			+ ", ast.idAsentamiento"
			+ ", ast.asentamiento"
			+ ", ast.idAsentamientoPorEdoMun "
			+ ") FROM CatCodigosPostale c"
			+ " INNER JOIN c.catAlcaldia alc"
			+ " INNER JOIN c.catAsentamiento ast"
			+ " WHERE c.codigoPostal =:cp ")  
})

public class CatCodigosPostale implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idCodigoPostal;
	private String codigoPostal;
	private List<CatAreaAc> catAreaAcs;
	private CatAlcaldia catAlcaldia;
	private CatAsentamiento catAsentamiento;
	private CatEstado catEstado;
	private CatTiposAsentamiento catTiposAsentamiento;

	public CatCodigosPostale() {
	}
	
	public CatCodigosPostale(Integer idCodigoPostal) {
		this.idCodigoPostal=idCodigoPostal;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_codigo_postal")
	public Integer getIdCodigoPostal() {
		return this.idCodigoPostal;
	}

	public void setIdCodigoPostal(Integer idCodigoPostal) {
		this.idCodigoPostal = idCodigoPostal;
	}


	@Column(name="codigo_postal")
	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	//bi-directional many-to-one association to CatAreaAc
	@OneToMany(mappedBy="catCodigosPostale")
	public List<CatAreaAc> getCatAreaAcs() {
		return this.catAreaAcs;
	}

	public void setCatAreaAcs(List<CatAreaAc> catAreaAcs) {
		this.catAreaAcs = catAreaAcs;
	}

	public CatAreaAc addCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().add(catAreaAc);
		catAreaAc.setCatCodigosPostale(this);

		return catAreaAc;
	}

	public CatAreaAc removeCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().remove(catAreaAc);
		catAreaAc.setCatCodigosPostale(null);

		return catAreaAc;
	}


	//bi-directional many-to-one association to CatAlcaldia
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	public CatAlcaldia getCatAlcaldia() {
		return this.catAlcaldia;
	}

	public void setCatAlcaldia(CatAlcaldia catAlcaldia) {
		this.catAlcaldia = catAlcaldia;
	}


	//bi-directional many-to-one association to CatAsentamiento
	@ManyToOne
	@JoinColumn(name="id_asentamiento")
	public CatAsentamiento getCatAsentamiento() {
		return this.catAsentamiento;
	}

	public void setCatAsentamiento(CatAsentamiento catAsentamiento) {
		this.catAsentamiento = catAsentamiento;
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


	//bi-directional many-to-one association to CatTiposAsentamiento
	@ManyToOne
	@JoinColumn(name="id_tipo_asentamiento")
	public CatTiposAsentamiento getCatTiposAsentamiento() {
		return this.catTiposAsentamiento;
	}

	public void setCatTiposAsentamiento(CatTiposAsentamiento catTiposAsentamiento) {
		this.catTiposAsentamiento = catTiposAsentamiento;
	}

}