package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_documento_requisito database table.
 * 
 */
@Entity
@Table(name="cat_documento_requisito", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatDocumentoRequisito.findAll", query="SELECT c FROM CatDocumentoRequisito c"),
//	@NamedQuery(name="CatDocumentoRequisito.findByTipoDoc"
//	, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatDocumentoRequisitoDTO(dr.id"
//			+ ", dr.descripcion"
//			+ ", dr.situacion"
//			+ ", td.id"
//			+ ", td.descripcion"
//			+ ", td.situacion) "
//			+ "FROM CatDocumentoRequisito dr "
//			+ "join dr.catTipoDocumento td "
//			+ "where dr.situacion = true "
//			+ "and td.situacion = true "
//			+ "and td.id = :idTipoDoc "
//			+ "order by dr.id")
//})
public class CatDocumentoRequisito implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private CatTipoDocumento catTipoDocumento;
	private List<DetDocumentoModalidad> detDocumentoModalidads;
	private List<DetDocumentosTramite> detDocumentosTramites;

	public CatDocumentoRequisito() {
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


	//bi-directional many-to-one association to CatTipoDocumento
	@ManyToOne
	@JoinColumn(name="id_tipo_documento")
	public CatTipoDocumento getCatTipoDocumento() {
		return this.catTipoDocumento;
	}

	public void setCatTipoDocumento(CatTipoDocumento catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
	}


	//bi-directional many-to-one association to DetDocumentoModalidad
	@OneToMany(mappedBy="catDocumentoRequisito")
	public List<DetDocumentoModalidad> getDetDocumentoModalidads() {
		return this.detDocumentoModalidads;
	}

	public void setDetDocumentoModalidads(List<DetDocumentoModalidad> detDocumentoModalidads) {
		this.detDocumentoModalidads = detDocumentoModalidads;
	}

	public DetDocumentoModalidad addDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
		getDetDocumentoModalidads().add(detDocumentoModalidad);
		detDocumentoModalidad.setCatDocumentoRequisito(this);

		return detDocumentoModalidad;
	}

	public DetDocumentoModalidad removeDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
		getDetDocumentoModalidads().remove(detDocumentoModalidad);
		detDocumentoModalidad.setCatDocumentoRequisito(null);

		return detDocumentoModalidad;
	}


	//bi-directional many-to-one association to DetDocumentosTramite
	@OneToMany(mappedBy="catDocumentoRequisito")
	public List<DetDocumentosTramite> getDetDocumentosTramites() {
		return this.detDocumentosTramites;
	}

	public void setDetDocumentosTramites(List<DetDocumentosTramite> detDocumentosTramites) {
		this.detDocumentosTramites = detDocumentosTramites;
	}

//	public DetDocumentosTramite addDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().add(detDocumentosTramite);
//		detDocumentosTramite.setCatDocumentoRequisito(this);
//
//		return detDocumentosTramite;
//	}
//
//	public DetDocumentosTramite removeDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
//		getDetDocumentosTramites().remove(detDocumentosTramite);
//		detDocumentosTramite.setCatDocumentoRequisito(null);
//
//		return detDocumentosTramite;
//	}

}