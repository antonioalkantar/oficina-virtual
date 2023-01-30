package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_ficta database table.
 * 
 */
@Entity
@Table(name="cat_tipo_ficta", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatTipoFicta.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatTipoFictaDTO(c.id"
//					+ ", c.descripcion"
//					+ ", c.situacion) "
//					+ "FROM CatTipoFicta c "
//					+ "where c.situacion = true"
//					+ " order by c.situacion")
//})
public class CatTipoFicta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetModalidadesTramite> detModalidadesTramites;
	private List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas;
	private List<DetPlazoMaximoRespuestaHist> detPlazoMaximoRespuestasHist;

	public CatTipoFicta() {
	}
	

	public CatTipoFicta(Long id) {
		
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


	//bi-directional many-to-one association to DetModalidadesTramite
	@OneToMany(mappedBy="catTipoFicta")
	public List<DetModalidadesTramite> getDetModalidadesTramites() {
		return this.detModalidadesTramites;
	}

	public void setDetModalidadesTramites(List<DetModalidadesTramite> detModalidadesTramites) {
		this.detModalidadesTramites = detModalidadesTramites;
	}

	public DetModalidadesTramite addDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		getDetModalidadesTramites().add(detModalidadesTramite);
		detModalidadesTramite.setCatTipoFicta(this);

		return detModalidadesTramite;
	}

	public DetModalidadesTramite removeDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		getDetModalidadesTramites().remove(detModalidadesTramite);
		detModalidadesTramite.setCatTipoFicta(null);

		return detModalidadesTramite;
	}


	//bi-directional many-to-one association to DetPlazoMaximoRespuesta
	@OneToMany(mappedBy="catTipoFicta")
	public List<DetPlazoMaximoRespuesta> getDetPlazoMaximoRespuestas() {
		return this.detPlazoMaximoRespuestas;
	}

	public void setDetPlazoMaximoRespuestas(List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas) {
		this.detPlazoMaximoRespuestas = detPlazoMaximoRespuestas;
	}

	public DetPlazoMaximoRespuesta addDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
		getDetPlazoMaximoRespuestas().add(detPlazoMaximoRespuesta);
		detPlazoMaximoRespuesta.setCatTipoFicta(this);

		return detPlazoMaximoRespuesta;
	}

	public DetPlazoMaximoRespuesta removeDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
		getDetPlazoMaximoRespuestas().remove(detPlazoMaximoRespuesta);
		detPlazoMaximoRespuesta.setCatTipoFicta(null);

		return detPlazoMaximoRespuesta;
	}


	//bi-directional many-to-one association to DetPlazoMaximoRespuesta
	@OneToMany(mappedBy="catTipoFicta")
	public List<DetPlazoMaximoRespuestaHist> getDetPlazoMaximoRespuestasHist() {
		return detPlazoMaximoRespuestasHist;
	}


	public void setDetPlazoMaximoRespuestasHist(List<DetPlazoMaximoRespuestaHist> detPlazoMaximoRespuestasHist) {
		this.detPlazoMaximoRespuestasHist = detPlazoMaximoRespuestasHist;
	}

}