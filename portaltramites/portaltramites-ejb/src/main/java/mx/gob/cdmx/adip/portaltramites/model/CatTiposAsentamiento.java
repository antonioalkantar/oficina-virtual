package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipos_asentamiento database table.
 * 
 */
@Entity
@Table(name="cat_tipos_asentamiento", schema = "retys_v2")
@NamedQuery(name="CatTiposAsentamiento.findAll", query="SELECT c FROM CatTiposAsentamiento c")
public class CatTiposAsentamiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTipoAsentamiento;
	private String descripcion;
	private List<CatCodigosPostale> catCodigosPostales;

	public CatTiposAsentamiento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_asentamiento")
	public Integer getIdTipoAsentamiento() {
		return this.idTipoAsentamiento;
	}

	public void setIdTipoAsentamiento(Integer idTipoAsentamiento) {
		this.idTipoAsentamiento = idTipoAsentamiento;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to CatCodigosPostale
	@OneToMany(mappedBy="catTiposAsentamiento")
	public List<CatCodigosPostale> getCatCodigosPostales() {
		return this.catCodigosPostales;
	}

	public void setCatCodigosPostales(List<CatCodigosPostale> catCodigosPostales) {
		this.catCodigosPostales = catCodigosPostales;
	}

	public CatCodigosPostale addCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().add(catCodigosPostale);
		catCodigosPostale.setCatTiposAsentamiento(this);

		return catCodigosPostale;
	}

	public CatCodigosPostale removeCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		getCatCodigosPostales().remove(catCodigosPostale);
		catCodigosPostale.setCatTiposAsentamiento(null);

		return catCodigosPostale;
	}

}