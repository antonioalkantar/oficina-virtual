package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_conjuncion database table.
 * 
 */
@Entity
@Table(name="cat_conjuncion", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatConjuncion.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatConjuncionDTO(c.id "
//					+ ", c.descripcion "
//					+ ", c.situacion) "
//					+ "FROM CatConjuncion c "
//					+ "where c.situacion = true")
//})
public class CatConjuncion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetDocumentosTramite> detDocumentosTramites;

	public CatConjuncion() {
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


	//bi-directional many-to-one association to DetDocumentosTramite2
	@OneToMany(mappedBy="catConjuncion")
	public List<DetDocumentosTramite> getDetDocumentosTramites() {
		return this.detDocumentosTramites;
	}

	public void setDetDocumentosTramites(List<DetDocumentosTramite> detDocumentosTramites) {
		this.detDocumentosTramites = detDocumentosTramites;
	}

//	public DetDocumentosTramite addDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().add(detDocumentosTramite);
//		detDocumentosTramite.setCatConjuncion(this);
//
//		return detDocumentosTramite;
//	}
//
//	public DetDocumentosTramite removeDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().remove(detDocumentosTramite);
//		detDocumentosTramite.setCatConjuncion(null);
//
//		return detDocumentosTramite;
//	}

}