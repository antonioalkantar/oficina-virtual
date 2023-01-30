package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_documento database table.
 * 
 */
@Entity
@Table(name="cat_tipo_documento", schema = "retys_v2")
//@NamedQuery(name="CatTipoDocumento.findAll", query="SELECT c FROM CatTipoDocumento c")
public class CatTipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<CatDocumentoRequisito> catDocumentoRequisitos;
	private List<DetDocumentoModalidad> detDocumentoModalidads;
	private List<DetDocumentosTramite> detDocumentosTramites;

	public CatTipoDocumento() {
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


	//bi-directional many-to-one association to CatDocumentoRequisito
	@OneToMany(mappedBy="catTipoDocumento")
	public List<CatDocumentoRequisito> getCatDocumentoRequisitos() {
		return this.catDocumentoRequisitos;
	}

	public void setCatDocumentoRequisitos(List<CatDocumentoRequisito> catDocumentoRequisitos) {
		this.catDocumentoRequisitos = catDocumentoRequisitos;
	}

	public CatDocumentoRequisito addCatDocumentoRequisito(CatDocumentoRequisito catDocumentoRequisito) {
		getCatDocumentoRequisitos().add(catDocumentoRequisito);
		catDocumentoRequisito.setCatTipoDocumento(this);

		return catDocumentoRequisito;
	}

	public CatDocumentoRequisito removeCatDocumentoRequisito(CatDocumentoRequisito catDocumentoRequisito) {
		getCatDocumentoRequisitos().remove(catDocumentoRequisito);
		catDocumentoRequisito.setCatTipoDocumento(null);

		return catDocumentoRequisito;
	}


	//bi-directional many-to-one association to DetDocumentoModalidad
	@OneToMany(mappedBy="catTipoDocumento")
	public List<DetDocumentoModalidad> getDetDocumentoModalidads() {
		return this.detDocumentoModalidads;
	}

	public void setDetDocumentoModalidads(List<DetDocumentoModalidad> detDocumentoModalidads) {
		this.detDocumentoModalidads = detDocumentoModalidads;
	}

	public DetDocumentoModalidad addDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
		getDetDocumentoModalidads().add(detDocumentoModalidad);
		detDocumentoModalidad.setCatTipoDocumento(this);

		return detDocumentoModalidad;
	}

	public DetDocumentoModalidad removeDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
		getDetDocumentoModalidads().remove(detDocumentoModalidad);
		detDocumentoModalidad.setCatTipoDocumento(null);

		return detDocumentoModalidad;
	}


	//bi-directional many-to-one association to DetDocumentosTramite
	@OneToMany(mappedBy="catTipoDocumento")
	public List<DetDocumentosTramite> getDetDocumentosTramites() {
		return this.detDocumentosTramites;
	}

	public void setDetDocumentosTramites(List<DetDocumentosTramite> detDocumentosTramites) {
		this.detDocumentosTramites = detDocumentosTramites;
	}

//	public DetDocumentosTramite addDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().add(detDocumentosTramite);
//		detDocumentosTramite.setCatTipoDocumento(this);
//
//		return detDocumentosTramite;
//	}
//
//	public DetDocumentosTramite removeDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().remove(detDocumentosTramite);
//		detDocumentosTramite.setCatTipoDocumento(null);
//
//		return detDocumentosTramite;
//	}

}