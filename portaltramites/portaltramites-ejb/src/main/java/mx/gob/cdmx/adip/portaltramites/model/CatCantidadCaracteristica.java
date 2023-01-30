package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_cantidad_caracteristicas database table.
 * 
 */
@Entity
@Table(name="cat_cantidad_caracteristicas", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatCantidadCaracteristica.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatCantidadCaracteristicaDTO(cc.id"
//					+ ", cc.descripcion"
//					+ ", cc.situacion) "
//					+ "FROM CatCantidadCaracteristica cc "
//					+ "where cc.situacion = true "
//					+ "order by cc.descripcion ASC")
//})
public class CatCantidadCaracteristica implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetDocumentoModalidad> detDocumentoModalidads;
	private List<DetDocumentosTramite> detDocumentosTramites;

	public CatCantidadCaracteristica() {
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


	//bi-directional many-to-one association to DetDocumentoModalidad
	@OneToMany(mappedBy="catCantidadCaracteristica")
	public List<DetDocumentoModalidad> getDetDocumentoModalidads() {
		return this.detDocumentoModalidads;
	}

	public void setDetDocumentoModalidads(List<DetDocumentoModalidad> detDocumentoModalidads) {
		this.detDocumentoModalidads = detDocumentoModalidads;
	}

//	public DetDocumentoModalidad addDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
//		getDetDocumentoModalidads().add(detDocumentoModalidad);
//		detDocumentoModalidad.setCatCantidadCaracteristica(this);
//
//		return detDocumentoModalidad;
//	}
//
//	public DetDocumentoModalidad removeDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
//		getDetDocumentoModalidads().remove(detDocumentoModalidad);
//		detDocumentoModalidad.setCatCantidadCaracteristica(null);
//
//		return detDocumentoModalidad;
//	}


	//bi-directional many-to-one association to DetDocumentosTramite
	@OneToMany(mappedBy="catCantidadCaracteristica")
	public List<DetDocumentosTramite> getDetDocumentosTramites() {
		return this.detDocumentosTramites;
	}

	public void setDetDocumentosTramites(List<DetDocumentosTramite> detDocumentosTramites) {
		this.detDocumentosTramites = detDocumentosTramites;
	}

//	public DetDocumentosTramite addDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().add(detDocumentosTramite);
//		detDocumentosTramite.setCatCantidadCaracteristica(this);
//
//		return detDocumentosTramite;
//	}
//
//	public DetDocumentosTramite removeDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().remove(detDocumentosTramite);
//		detDocumentosTramite.setCatCantidadCaracteristica(null);
//
//		return detDocumentosTramite;
//	}

}