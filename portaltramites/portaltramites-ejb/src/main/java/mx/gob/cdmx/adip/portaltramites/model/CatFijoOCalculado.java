package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_fijo_o_calculado database table.
 * 
 */
@Entity
@Table(name="cat_fijo_o_calculado", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatFijoOCalculado.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatFijoOCalculadoDTO(c.id"
//					+ ", c.descripcion"
//					+ ", c.situacion) "
//					+ "FROM CatFijoOCalculado c "
//					+ "where c.situacion = true"
//					+ " ORDER BY c.descripcion ASC ")
//})
public class CatFijoOCalculado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetModalidadesTramite> detModalidadesTramites;

	public CatFijoOCalculado() {
	}


	public CatFijoOCalculado(Long id) {
		
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


	//bi-directional many-to-one association to DetModalidadesTramite
	@OneToMany(mappedBy="catFijoOCalculado")
	public List<DetModalidadesTramite> getDetModalidadesTramites() {
		return this.detModalidadesTramites;
	}

	public void setDetModalidadesTramites(List<DetModalidadesTramite> detModalidadesTramites) {
		this.detModalidadesTramites = detModalidadesTramites;
	}

//	public DetModalidadesTramite addDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
//		getDetModalidadesTramites().add(detModalidadesTramite);
//		detModalidadesTramite.setCatFijoOCalculado(this);
//
//		return detModalidadesTramite;
//	}
//
//	public DetModalidadesTramite removeDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
//		getDetModalidadesTramites().remove(detModalidadesTramite);
//		detModalidadesTramite.setCatFijoOCalculado(null);
//
//		return detModalidadesTramite;
//	}

}