package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_unidades database table.
 * 
 */
@Entity
@Table(name="cat_unidades", schema = "retys_v2")

public class CatUnidade implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetCosto> detCostos;
//	private List<DetPlazoCumplirPrevencion> detPlazoCumplirPrevencions;
//	private List<DetPlazoPrevenirSolicitante> detPlazoPrevenirSolicitantes;
//	private List<DetPlazoResolucionInmediata> detPlazoResolucionInmediatas;
	private List<DetPlazoResolver> detPlazoResolver;
	private List<DetPlazoResolverHist> detPlazoResolverHist;
	private List<DetVigenciaModalidad> detVigenciaModalidads;

	public CatUnidade() {
	}


	public CatUnidade(Long id) {
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
	@OneToMany(mappedBy="catUnidade")
	public List<DetCosto> getDetCostos() {
		return this.detCostos;
	}

	public void setDetCostos(List<DetCosto> detCostos) {
		this.detCostos = detCostos;
	}

	public DetCosto addDetCosto(DetCosto detCosto) {
		getDetCostos().add(detCosto);
		detCosto.setCatUnidade(this);

		return detCosto;
	}

	public DetCosto removeDetCosto(DetCosto detCosto) {
		getDetCostos().remove(detCosto);
		detCosto.setCatUnidade(null);

		return detCosto;
	}


	//bi-directional many-to-one association to DetPlazoCumplirPrevencion
//	@OneToMany(mappedBy="catUnidade")
//	public List<DetPlazoCumplirPrevencion> getDetPlazoCumplirPrevencions() {
//		return this.detPlazoCumplirPrevencions;
//	}
//
//	public void setDetPlazoCumplirPrevencions(List<DetPlazoCumplirPrevencion> detPlazoCumplirPrevencions) {
//		this.detPlazoCumplirPrevencions = detPlazoCumplirPrevencions;
//	}
//
//	public DetPlazoCumplirPrevencion addDetPlazoCumplirPrevencion(DetPlazoCumplirPrevencion detPlazoCumplirPrevencion) {
//		getDetPlazoCumplirPrevencions().add(detPlazoCumplirPrevencion);
//		detPlazoCumplirPrevencion.setCatUnidade(this);
//
//		return detPlazoCumplirPrevencion;
//	}
//
//	public DetPlazoCumplirPrevencion removeDetPlazoCumplirPrevencion(DetPlazoCumplirPrevencion detPlazoCumplirPrevencion) {
//		getDetPlazoCumplirPrevencions().remove(detPlazoCumplirPrevencion);
//		detPlazoCumplirPrevencion.setCatUnidade(null);
//
//		return detPlazoCumplirPrevencion;
//	}


	//bi-directional many-to-one association to DetPlazoPrevenirSolicitante
//	@OneToMany(mappedBy="catUnidade")
//	public List<DetPlazoPrevenirSolicitante> getDetPlazoPrevenirSolicitantes() {
//		return this.detPlazoPrevenirSolicitantes;
//	}
//
//	public void setDetPlazoPrevenirSolicitantes(List<DetPlazoPrevenirSolicitante> detPlazoPrevenirSolicitantes) {
//		this.detPlazoPrevenirSolicitantes = detPlazoPrevenirSolicitantes;
//	}
//
//	public DetPlazoPrevenirSolicitante addDetPlazoPrevenirSolicitante(DetPlazoPrevenirSolicitante detPlazoPrevenirSolicitante) {
//		getDetPlazoPrevenirSolicitantes().add(detPlazoPrevenirSolicitante);
//		detPlazoPrevenirSolicitante.setCatUnidade(this);
//
//		return detPlazoPrevenirSolicitante;
//	}
//
//	public DetPlazoPrevenirSolicitante removeDetPlazoPrevenirSolicitante(DetPlazoPrevenirSolicitante detPlazoPrevenirSolicitante) {
//		getDetPlazoPrevenirSolicitantes().remove(detPlazoPrevenirSolicitante);
//		detPlazoPrevenirSolicitante.setCatUnidade(null);
//
//		return detPlazoPrevenirSolicitante;
//	}


	//bi-directional many-to-one association to DetPlazoResolucionInmediata
//	@OneToMany(mappedBy="catUnidade")
//	public List<DetPlazoResolucionInmediata> getDetPlazoResolucionInmediatas() {
//		return this.detPlazoResolucionInmediatas;
//	}
//
//	public void setDetPlazoResolucionInmediatas(List<DetPlazoResolucionInmediata> detPlazoResolucionInmediatas) {
//		this.detPlazoResolucionInmediatas = detPlazoResolucionInmediatas;
//	}
//
//	public DetPlazoResolucionInmediata addDetPlazoResolucionInmediata(DetPlazoResolucionInmediata detPlazoResolucionInmediata) {
//		getDetPlazoResolucionInmediatas().add(detPlazoResolucionInmediata);
//		detPlazoResolucionInmediata.setCatUnidade(this);
//
//		return detPlazoResolucionInmediata;
//	}
//
//	public DetPlazoResolucionInmediata removeDetPlazoResolucionInmediata(DetPlazoResolucionInmediata detPlazoResolucionInmediata) {
//		getDetPlazoResolucionInmediatas().remove(detPlazoResolucionInmediata);
//		detPlazoResolucionInmediata.setCatUnidade(null);
//
//		return detPlazoResolucionInmediata;
//	}


	//bi-directional many-to-one association to DetPlazoResolver
	@OneToMany(mappedBy="catUnidade")
	public List<DetPlazoResolver> getDetPlazoResolver() {
		return this.detPlazoResolver;
	}

	public void setDetPlazoResolver(List<DetPlazoResolver> detPlazoResolver) {
		this.detPlazoResolver = detPlazoResolver;
	}
//
//	public DetPlazoResolver addDetPlazoResolver(DetPlazoResolver detPlazoResolver) {
//		getDetPlazoResolvers().add(detPlazoResolver);
//		detPlazoResolver.setCatUnidade(this);
//
//		return detPlazoResolver;
//	}
//
//	public DetPlazoResolver removeDetPlazoResolver(DetPlazoResolver detPlazoResolver) {
//		getDetPlazoResolvers().remove(detPlazoResolver);
//		detPlazoResolver.setCatUnidade(null);
//
//		return detPlazoResolver;
//	}


	//bi-directional many-to-one association to DetVigenciaModalidad
	@OneToMany(mappedBy="catUnidade")
	public List<DetVigenciaModalidad> getDetVigenciaModalidads() {
		return this.detVigenciaModalidads;
	}

	public void setDetVigenciaModalidads(List<DetVigenciaModalidad> detVigenciaModalidads) {
		this.detVigenciaModalidads = detVigenciaModalidads;
	}

	public DetVigenciaModalidad addDetVigenciaModalidad(DetVigenciaModalidad detVigenciaModalidad) {
		getDetVigenciaModalidads().add(detVigenciaModalidad);
		detVigenciaModalidad.setCatUnidade(this);

		return detVigenciaModalidad;
	}

	public DetVigenciaModalidad removeDetVigenciaModalidad(DetVigenciaModalidad detVigenciaModalidad) {
		getDetVigenciaModalidads().remove(detVigenciaModalidad);
		detVigenciaModalidad.setCatUnidade(null);

		return detVigenciaModalidad;
	}


	//bi-directional many-to-one association to DetPlazoResolver
	@OneToMany(mappedBy="catUnidade")
	public List<DetPlazoResolverHist> getDetPlazoResolverHist() {
		return detPlazoResolverHist;
	}


	public void setDetPlazoResolverHist(List<DetPlazoResolverHist> detPlazoResolverHist) {
		this.detPlazoResolverHist = detPlazoResolverHist;
	}

}