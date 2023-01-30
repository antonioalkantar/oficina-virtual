package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;
import java.util.Date;

public class CatSistemaDTO implements Serializable {

	private static final long serialVersionUID = -825531773412694513L;
	
	private Integer idSistema;
	private CatDependenciaTxDTO catDependenciaTxDTO;
	private String nombre;
	private String urlHome;
	private boolean activo;
	private Date fechaAlta;
	private String pathImagen;
	
	public CatSistemaDTO() {}

	public CatSistemaDTO(Integer idSistema) {
		this.idSistema = idSistema;
	}
	public CatSistemaDTO(Integer idSistema, String nombre, String urlHome, String pathImagen) {
		this.idSistema = idSistema;	
		this.nombre = nombre;
		this.urlHome = urlHome;
		this.pathImagen = pathImagen;
	}

	public CatSistemaDTO(Integer idSistema, String nombre, String urlHome, String pathImagen
						 ,boolean activo) {
		
		this.idSistema = idSistema;	
		this.nombre = nombre;
		this.urlHome = urlHome;
		this.activo = activo;		
		this.pathImagen = pathImagen;
	}

	public CatSistemaDTO(int idSistema, String nombre, String urlHome, String pathImagen, Integer idDependencia, String nombreDependencia, String acronimo) {
		this.idSistema = idSistema;
		this.nombre = nombre;
		this.urlHome = urlHome;
		this.pathImagen = pathImagen;
		this.catDependenciaTxDTO = new CatDependenciaTxDTO(idDependencia, nombreDependencia, acronimo);
	}

	public Integer getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	public CatDependenciaTxDTO getCatDependenciaTxDTO() {
		return catDependenciaTxDTO;
	}

	public void setCatDependenciaTxDTO(CatDependenciaTxDTO catDependenciaTxDTO) {
		this.catDependenciaTxDTO = catDependenciaTxDTO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlHome() {
		return urlHome;
	}

	public void setUrlHome(String urlHome) {
		this.urlHome = urlHome;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

}
