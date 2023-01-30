package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_concepto database table.
 * 
 */
@Entity
@Table(name="cat_tipo_concepto", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatTipoConcepto.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatTipoConceptoDTO(c.id"
//					+ ", c.descripcion"
//					+ ", c.situacion) "
//					+ "FROM CatTipoConcepto c "
//					+ "where c.situacion = true "
//					+ "order by c.id")
//})
public class CatTipoConcepto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetCosto> detCostos;
	private List<DetCostosHist> detCostosHist;
	private List<DetModalidadesTramite> detModalidadesTramites;

	public CatTipoConcepto() {
	}


	public CatTipoConcepto(Long id) {
		// TODO Auto-generated constructor stub
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


	//bi-directional many-to-one association to DetCosto
	@OneToMany(mappedBy="catTipoConcepto")
	public List<DetCosto> getDetCostos() {
		return this.detCostos;
	}

	public void setDetCostos(List<DetCosto> detCostos) {
		this.detCostos = detCostos;
	}

	//bi-directional many-to-one association to DetModalidadesTramite2
	@OneToMany(mappedBy="catTipoConcepto")
	public List<DetModalidadesTramite> getDetModalidadesTramites() {
		return this.detModalidadesTramites;
	}

	public void setDetModalidadesTramites(List<DetModalidadesTramite> detModalidadesTramites) {
		this.detModalidadesTramites = detModalidadesTramites;
	}

	public DetModalidadesTramite addDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		getDetModalidadesTramites().add(detModalidadesTramite);
		detModalidadesTramite.setCatTipoConcepto(this);

		return detModalidadesTramite;
	}

	public DetModalidadesTramite removeDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		getDetModalidadesTramites().remove(detModalidadesTramite);
		detModalidadesTramite.setCatTipoConcepto(null);

		return detModalidadesTramite;
	}


	//bi-directional many-to-one association to DetCosto
	@OneToMany(mappedBy="catTipoConcepto")
	public List<DetCostosHist> getDetCostosHist() {
		return detCostosHist;
	}


	public void setDetCostosHist(List<DetCostosHist> detCostosHist) {
		this.detCostosHist = detCostosHist;
	}
}