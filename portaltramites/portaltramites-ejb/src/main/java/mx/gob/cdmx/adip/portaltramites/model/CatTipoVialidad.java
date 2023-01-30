package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_vialidad database table.
 * 
 */
@Entity
@Table(name="cat_tipo_vialidad", schema = "retys_v2")
@NamedQuery(name="CatTipoVialidad.findAll"			
			, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatTipoVialidadDTO "
					+ "( "
					+ "ctv.id "											
					+ ", ctv.descripcion"					
					+ ")"
					+ "FROM CatTipoVialidad ctv "
					+ "where ctv.situacion = true"
					+ " ORDER BY ctv.descripcion ASC "
			)
public class CatTipoVialidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
//	private List<DetMedioDependencia> detMedioDependencias;
	private List<DetUnidadesAdmResp> detUnidadesAdmResps;

	public CatTipoVialidad() {
	}

	public CatTipoVialidad(Long id) {
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


	//bi-directional many-to-one association to DetMedioDependencia
//	@OneToMany(mappedBy="catTipoVialidad")
//	public List<DetMedioDependencia> getDetMedioDependencias() {
//		return this.detMedioDependencias;
//	}
//
//	public void setDetMedioDependencias(List<DetMedioDependencia> detMedioDependencias) {
//		this.detMedioDependencias = detMedioDependencias;
//	}
//
//	public DetMedioDependencia addDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().add(detMedioDependencia);
//		detMedioDependencia.setCatTipoVialidad(this);
//
//		return detMedioDependencia;
//	}
//
//	public DetMedioDependencia removeDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().remove(detMedioDependencia);
//		detMedioDependencia.setCatTipoVialidad(null);
//
//		return detMedioDependencia;
//	}


	//bi-directional many-to-one association to DetUnidadesAdmResp
	@OneToMany(mappedBy="catTipoVialidad")
	public List<DetUnidadesAdmResp> getDetUnidadesAdmResps() {
		return this.detUnidadesAdmResps;
	}

	public void setDetUnidadesAdmResps(List<DetUnidadesAdmResp> detUnidadesAdmResps) {
		this.detUnidadesAdmResps = detUnidadesAdmResps;
	}

	public DetUnidadesAdmResp addDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
		getDetUnidadesAdmResps().add(detUnidadesAdmResp);
		detUnidadesAdmResp.setCatTipoVialidad(this);

		return detUnidadesAdmResp;
	}

	public DetUnidadesAdmResp removeDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
		getDetUnidadesAdmResps().remove(detUnidadesAdmResp);
		detUnidadesAdmResp.setCatTipoVialidad(null);

		return detUnidadesAdmResp;
	}

}