package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

import mx.gob.cdmx.adip.portaltramites.dto.CatDependenciaDTO;


public class CatUnidadesAdministrativaDTO implements Serializable {

	private static final long serialVersionUID = -8237995924561358276L;
	private Long id;
	private String acronimo;
	private String nombre;
	private String urlDirAtencion;
	private CatEstatusUnidadAdministrativaDTO catEstatusUnidadAdministrativa;
	private CatDependenciaDTO catDependencia;
	private Boolean situacion;
		
	public CatUnidadesAdministrativaDTO() {
		catEstatusUnidadAdministrativa = new CatEstatusUnidadAdministrativaDTO();
		catDependencia = new CatDependenciaDTO();
	}

	public CatUnidadesAdministrativaDTO(Long id, String nombreUnidadAdministrativa) {
		super();
		this.id = id;
		this.nombre = nombreUnidadAdministrativa;
	}

	public CatUnidadesAdministrativaDTO(Long id) {
		this.id = id;
	}

	public CatUnidadesAdministrativaDTO(Long id, String nombre, String acronimo, String urlDirAtencion,
			Integer idDependencia, Long idEstatusUnidadAdministrativa) {
		super();
		this.id = id;
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.urlDirAtencion = urlDirAtencion;
		this.catEstatusUnidadAdministrativa = new CatEstatusUnidadAdministrativaDTO(idEstatusUnidadAdministrativa);
		this.catDependencia = new CatDependenciaDTO(idDependencia);
	}
	
	
	
	
	public CatUnidadesAdministrativaDTO(Long id, String acronimo, String nombre, String urlDirAtencion,
			Boolean situacion) {
		super();
		this.id = id;
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.urlDirAtencion = urlDirAtencion;
		this.situacion = situacion;
	}

	public CatUnidadesAdministrativaDTO(Long id, String nombre, String acronimo, String urlDirAtencion,
			Integer idDependencia, Long idEstatusUnidadAdministrativa,boolean situacion, String nombreDependencia) {
		super();
		this.id = id;
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.urlDirAtencion = urlDirAtencion;
		this.catEstatusUnidadAdministrativa = new CatEstatusUnidadAdministrativaDTO(idEstatusUnidadAdministrativa);
		this.catDependencia = new CatDependenciaDTO(idDependencia,nombreDependencia);
		this.situacion = situacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlDirAtencion() {
		return urlDirAtencion;
	}

	public void setUrlDirAtencion(String urlDirAtencion) {
		this.urlDirAtencion = urlDirAtencion;
	}

	public CatEstatusUnidadAdministrativaDTO getCatEstatusUnidadAdministrativa() {
		return catEstatusUnidadAdministrativa;
	}

	public void setCatEstatusUnidadAdministrativa(CatEstatusUnidadAdministrativaDTO catEstatusUnidadAdministrativa) {
		this.catEstatusUnidadAdministrativa = catEstatusUnidadAdministrativa;
	}

	public CatDependenciaDTO getCatDependencia() {
		return catDependencia;
	}

	public void setCatDependencia(CatDependenciaDTO catDependencia) {
		this.catDependencia = catDependencia;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
}
