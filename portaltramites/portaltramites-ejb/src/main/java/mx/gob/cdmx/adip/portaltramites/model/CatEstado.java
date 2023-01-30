package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_estados database table.
 * 
 */
@Entity
@Table(name="cat_estados", schema = "retys_v2")
@NamedQuery(name="CatEstado.findAll", query="SELECT c FROM CatEstado c")
public class CatEstado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idEstado;
	private String cveEstado;
	private String estado;
	private List<CatAsentamiento> catAsentamientos;
	private List<CatCodigosPostale> catCodigosPostales;

	public CatEstado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado")
	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}


	@Column(name="cve_estado")
	public String getCveEstado() {
		return this.cveEstado;
	}

	public void setCveEstado(String cveEstado) {
		this.cveEstado = cveEstado;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	//bi-directional many-to-one association to CatAsentamiento
	@OneToMany(mappedBy="catEstado")
	public List<CatAsentamiento> getCatAsentamientos() {
		return this.catAsentamientos;
	}

	public void setCatAsentamientos(List<CatAsentamiento> catAsentamientos) {
		this.catAsentamientos = catAsentamientos;
	}

	public CatAsentamiento addCatAsentamiento(CatAsentamiento catAsentamiento) {
		getCatAsentamientos().add(catAsentamiento);
		catAsentamiento.setCatEstado(this);

		return catAsentamiento;
	}

	public CatAsentamiento removeCatAsentamiento(CatAsentamiento catAsentamiento) {
		getCatAsentamientos().remove(catAsentamiento);
		catAsentamiento.setCatEstado(null);

		return catAsentamiento;
	}


	//bi-directional many-to-one association to CatCodigosPostale
	@OneToMany(mappedBy="catEstado")
	public List<CatCodigosPostale> getCatCodigosPostales() {
		return this.catCodigosPostales;
	}

	public void setCatCodigosPostales(List<CatCodigosPostale> catCodigosPostales) {
		this.catCodigosPostales = catCodigosPostales;
	}

	public CatCodigosPostale addCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().add(catCodigosPostale);
		catCodigosPostale.setCatEstado(this);

		return catCodigosPostale;
	}

	public CatCodigosPostale removeCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().remove(catCodigosPostale);
		catCodigosPostale.setCatEstado(null);

		return catCodigosPostale;
	}

}