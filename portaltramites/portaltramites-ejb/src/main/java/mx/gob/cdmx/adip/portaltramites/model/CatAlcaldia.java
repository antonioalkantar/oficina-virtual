package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_alcaldias database table.
 * 
 */
@Entity
@Table(name="cat_alcaldias", schema = "retys_v2")
@NamedQuery(name="CatAlcaldia.findAll", query="SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.CatAlcaldiaDTO(c.idAlcaldia,c.idEstado,c.idMunicipioPorEstado,c.municipio) FROM CatAlcaldia c")
//query="SELECT NEW mx.gob.cdmx.adip.retys.commons.dto.CatTipoHorarioDTO(c.id,c.descripcion, c.situacion) FROM CatTipoHorario c")
public class CatAlcaldia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idAlcaldia;
	private Integer idEstado;
	private Integer idMunicipioPorEstado;
	private String municipio;
	private List<CatAreaAc> catAreaAcs;
	private List<CatAsentamiento> catAsentamientos;
	private List<CatCodigosPostale> catCodigosPostales;
	private List<DetUnidadesAdmResp> detUnidadesAdmResps;

	public CatAlcaldia() {
	}

	public CatAlcaldia(Integer id) {
		this.idAlcaldia=id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_alcaldia")
	public Integer getIdAlcaldia() {
		return this.idAlcaldia;
	}

	public void setIdAlcaldia(Integer idAlcaldia) {
		this.idAlcaldia = idAlcaldia;
	}


	@Column(name="id_estado")
	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}


	@Column(name="id_municipio_por_estado")
	public Integer getIdMunicipioPorEstado() {
		return this.idMunicipioPorEstado;
	}

	public void setIdMunicipioPorEstado(Integer idMunicipioPorEstado) {
		this.idMunicipioPorEstado = idMunicipioPorEstado;
	}


	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	//bi-directional many-to-one association to CatAreaAc
	@OneToMany(mappedBy="catAlcaldia")
	public List<CatAreaAc> getCatAreaAcs() {
		return this.catAreaAcs;
	}

	public void setCatAreaAcs(List<CatAreaAc> catAreaAcs) {
		this.catAreaAcs = catAreaAcs;
	}

	public CatAreaAc addCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().add(catAreaAc);
		catAreaAc.setCatAlcaldia(this);

		return catAreaAc;
	}

	public CatAreaAc removeCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().remove(catAreaAc);
		catAreaAc.setCatAlcaldia(null);

		return catAreaAc;
	}


	//bi-directional many-to-one association to CatAsentamiento
	@OneToMany(mappedBy="catAlcaldia")
	public List<CatAsentamiento> getCatAsentamientos() {
		return this.catAsentamientos;
	}

	public void setCatAsentamientos(List<CatAsentamiento> catAsentamientos) {
		this.catAsentamientos = catAsentamientos;
	}

	public CatAsentamiento addCatAsentamiento(CatAsentamiento catAsentamiento) {
		getCatAsentamientos().add(catAsentamiento);
		catAsentamiento.setCatAlcaldia(this);

		return catAsentamiento;
	}

	public CatAsentamiento removeCatAsentamiento(CatAsentamiento catAsentamiento) {
		getCatAsentamientos().remove(catAsentamiento);
		catAsentamiento.setCatAlcaldia(null);

		return catAsentamiento;
	}


	//bi-directional many-to-one association to CatCodigosPostale
	@OneToMany(mappedBy="catAlcaldia")
	public List<CatCodigosPostale> getCatCodigosPostales() {
		return this.catCodigosPostales;
	}

	public void setCatCodigosPostales(List<CatCodigosPostale> catCodigosPostales) {
		this.catCodigosPostales = catCodigosPostales;
	}

	public CatCodigosPostale addCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().add(catCodigosPostale);
		catCodigosPostale.setCatAlcaldia(this);

		return catCodigosPostale;
	}

	public CatCodigosPostale removeCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().remove(catCodigosPostale);
		catCodigosPostale.setCatAlcaldia(null);

		return catCodigosPostale;
	}

}