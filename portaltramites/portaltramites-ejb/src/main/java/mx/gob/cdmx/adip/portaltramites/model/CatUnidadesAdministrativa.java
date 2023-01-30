package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_unidades_administrativas database table.
 * 
 */
@Entity
@Table(name="cat_unidades_administrativas", schema = "retys_v2")
@NamedQueries({
//	@NamedQuery(name="CatUnidadesAdministrativa.findAll", query="SELECT c FROM CatUnidadesAdministrativa c"),
	 @NamedQuery(name="CatUnidadesAdministrativa.findAll"
     ,query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatUnidadesAdministrativaDTO("
     		+ "c.id " + 
 			", c.nombre " + 
 			", c.acronimo " + 
 			", c.urlDirAtencion  "+
 			", c.situacion) "+
 			"FROM CatUnidadesAdministrativa c " ),
	@NamedQuery(name="CatUnidadesAdministrativa.findAllByIdDependencia"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatUnidadesAdministrativaDTO(c.id " + 
			", c.nombre " + 
			", c.acronimo " + 
			", c.urlDirAtencion  " + 
			", d.idDependencia " + 
			", e.id) " + 
			"FROM CatUnidadesAdministrativa c " + 
			"join c.catDependencia d " + 
			"join c.catEstatusUnidadAdministrativa e " + 
			"where d.idDependencia = :idDependencia " + 
			"and e.id = 1 ")
//	@NamedQuery(name="CatUnidadesAdministrativa.findAllSinFiltro", query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatUnidadesAdministrativaDTO(c.id "+
//			", c.nombre " + 
//			", c.acronimo " + 
//			", c.urlDirAtencion  " + 
//			", d.idDependencia " + 
//			", e.id"
//			+ ",c.situacion"
//			+ ",d.nombreDependencia) " + 
//			"FROM CatUnidadesAdministrativa c " + 
//			"join c.catDependencia d " + 
//			"join c.catEstatusUnidadAdministrativa e " + 			
//			" ORDER BY c.nombre ASC ")
	
//	@NamedQuery(name="CatUnidadesAdministrativa.buscarEntrada", query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatUnidadesAdministrativaDTO(c.id "+
//			", c.nombre " + 
//			", c.acronimo " + 
//			", c.urlDirAtencion  " + 
//			", d.idDependencia " + 
//			", e.id"
//			+ ",c.situacion"
//			+ ",d.nombreDependencia) " + 
//			"FROM CatUnidadesAdministrativa c " + 
//			"join c.catDependencia d " + 
//			"join c.catEstatusUnidadAdministrativa e " + 	
//			 " WHERE  LOWER(c.nombre)  LIKE LOWER(:cadena)"+
//			" ORDER BY c.nombre ASC "),
	
})
public class CatUnidadesAdministrativa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String acronimo;
	private String nombre;
	private String urlDirAtencion;
	private CatEstatusUnidadAdministrativa catEstatusUnidadAdministrativa;
	private CatDependencia catDependencia;
	private List<TramiteServicio> tramiteServicios;
//	private List<CrcUsuarioDependencia> crcUsuarioDependencias;
	private List<DetUnidadesAdmResp> detUnidadesAdmResps;
	private List<TramiteServicioHist> tramiteServiciosHist;
	private Boolean situacion;

	public CatUnidadesAdministrativa() {
	}

	public CatUnidadesAdministrativa(Long id) {
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


	public String getAcronimo() {
		return this.acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="url_dir_atencion")
	public String getUrlDirAtencion() {
		return this.urlDirAtencion;
	}

	public void setUrlDirAtencion(String urlDirAtencion) {
		this.urlDirAtencion = urlDirAtencion;
	}


	//bi-directional many-to-one association to CatEstatusUnidadAdministrativa
	@ManyToOne
	@JoinColumn(name="id_estatus")
	public CatEstatusUnidadAdministrativa getCatEstatusUnidadAdministrativa() {
		return this.catEstatusUnidadAdministrativa;
	}

	public void setCatEstatusUnidadAdministrativa(CatEstatusUnidadAdministrativa catEstatusUnidadAdministrativa) {
		this.catEstatusUnidadAdministrativa = catEstatusUnidadAdministrativa;
	}

	//bi-directional many-to-one association to TramiteServicio
	@OneToMany(mappedBy="catUnidadesAdministrativa")
	public List<TramiteServicio> getTramiteServicios() {
		return this.tramiteServicios;
	}

	public void setTramiteServicios(List<TramiteServicio> tramiteServicios) {
		this.tramiteServicios = tramiteServicios;
	}

//	public TramiteServicio addTramiteServicio(TramiteServicio tramiteServicio) {
//		getTramiteServicios().add(tramiteServicio);
//		tramiteServicio.setCatUnidadesAdministrativa(this);
//
//		return tramiteServicio;
//	}
//
//	public TramiteServicio removeTramiteServicio(TramiteServicio tramiteServicio) {
//		getTramiteServicios().remove(tramiteServicio);
//		tramiteServicio.setCatUnidadesAdministrativa(null);
//
//		return tramiteServicio;
//	}
	
	//bi-directional many-to-one association to CatDependencia2
	@ManyToOne
	@JoinColumn(name="id_dependencia")
	public CatDependencia getCatDependencia() {
		return this.catDependencia;
	}

	public void setCatDependencia(CatDependencia catDependencia) {
		this.catDependencia = catDependencia;
	}


	//bi-directional many-to-one association to CrcUsuarioDependencia2
//	@OneToMany(mappedBy="catUnidadesAdministrativa")
//	public List<CrcUsuarioDependencia> getCrcUsuarioDependencias() {
//		return this.crcUsuarioDependencias;
//	}
//
//	public void setCrcUsuarioDependencias(List<CrcUsuarioDependencia> crcUsuarioDependencias) {
//		this.crcUsuarioDependencias = crcUsuarioDependencias;
//	}
//
//	public CrcUsuarioDependencia addCrcUsuarioDependencia(CrcUsuarioDependencia crcUsuarioDependencia) {
//		getCrcUsuarioDependencias().add(crcUsuarioDependencia);
//		crcUsuarioDependencia.setCatUnidadesAdministrativa(this);
//
//		return crcUsuarioDependencia;
//	}
//
//	public CrcUsuarioDependencia removeCrcUsuarioDependencia(CrcUsuarioDependencia crcUsuarioDependencia) {
//		getCrcUsuarioDependencias().remove(crcUsuarioDependencia);
//		crcUsuarioDependencia.setCatUnidadesAdministrativa(null);
//
//		return crcUsuarioDependencia;
//	}

	//bi-directional many-to-one association to DetUnidadesAdmResp2
	@OneToMany(mappedBy="catUnidadesAdministrativa")
	public List<DetUnidadesAdmResp> getDetUnidadesAdmResps() {
		return this.detUnidadesAdmResps;
	}

	public void setDetUnidadesAdmResps(List<DetUnidadesAdmResp> detUnidadesAdmResps) {
		this.detUnidadesAdmResps = detUnidadesAdmResps;
	}

	public DetUnidadesAdmResp addDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
		getDetUnidadesAdmResps().add(detUnidadesAdmResp);
		detUnidadesAdmResp.setCatUnidadesAdministrativa(this);

		return detUnidadesAdmResp;
	}

	public DetUnidadesAdmResp removeDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
		getDetUnidadesAdmResps().remove(detUnidadesAdmResp);
		detUnidadesAdmResp.setCatUnidadesAdministrativa(null);

		return detUnidadesAdmResp;
	}
	
	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	//bi-directional many-to-one association to TramiteServicio
	@OneToMany(mappedBy="catUnidadesAdministrativaHist")
	public List<TramiteServicioHist> getTramiteServiciosHist() {
		return tramiteServiciosHist;
	}

	public void setTramiteServiciosHist(List<TramiteServicioHist> tramiteServiciosHist) {
		this.tramiteServiciosHist = tramiteServiciosHist;
	}

}