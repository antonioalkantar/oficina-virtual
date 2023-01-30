package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_estatus_area_ac database table.
 * 
 */
@Entity
@Table(name="cat_estatus_area_ac", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatEstatusAreaAc.findAll",
       query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatEstatusAreaAcDTO(c.id, c.descripcion)  FROM CatEstatusAreaAc c  ORDER BY  c.descripcion")

})
public class CatEstatusAreaAc implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<CatAreaAc> catAreaAcs;

	public CatEstatusAreaAc() {
	}

	public CatEstatusAreaAc(Long id) {
	this.id = id;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CatAreaAc
	@OneToMany(mappedBy="catEstatusAreaAc")
	public List<CatAreaAc> getCatAreaAcs() {
		return this.catAreaAcs;
	}

	public void setCatAreaAcs(List<CatAreaAc> catAreaAcs) {
		this.catAreaAcs = catAreaAcs;
	}

	public CatAreaAc addCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().add(catAreaAc);
		catAreaAc.setCatEstatusAreaAc(this);

		return catAreaAc;
	}

	public CatAreaAc removeCatAreaAc(CatAreaAc catAreaAc) {
		getCatAreaAcs().remove(catAreaAc);
		catAreaAc.setCatEstatusAreaAc(null);

		return catAreaAc;
	}

}