package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;
import java.util.Date;

public class CatFuncionalidadDTO implements Serializable {

	private static final long serialVersionUID = -5812959104041714243L;
	
	private Integer idFuncionalidad;
	private CatSistemaDTO catSistemaDTO;
	private CatTipoFuncionalidadDTO catTipoFuncionalidadDTO;
	private String nombre;
	private Date fechaAlta;
	private boolean activo;
	private String urlEspecifica;
	
	public CatFuncionalidadDTO() {}

	public CatFuncionalidadDTO(Integer idFuncionalidad, String nombre, String urlEspecifica,
			Integer idSistema, String nombreSistema, String urlHome, String pathImagen
			,Integer idTipoFuncionalidad, String descripcion) {
		
		this.idFuncionalidad = idFuncionalidad;
		this.nombre = nombre;
		this.urlEspecifica = urlEspecifica;
		this.catSistemaDTO = new CatSistemaDTO(idSistema, nombreSistema, urlHome, pathImagen);
		this.catTipoFuncionalidadDTO = new CatTipoFuncionalidadDTO(idTipoFuncionalidad, descripcion);
	}

	public CatFuncionalidadDTO(Integer idFuncionalidad, String nombre, String urlEspecifica) {
		
		this.idFuncionalidad = idFuncionalidad;
		this.nombre = nombre;		
		this.urlEspecifica = urlEspecifica;
	}

	public Integer getIdFuncionalidad() {
		return idFuncionalidad;
	}

	public void setIdFuncionalidad(Integer idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public CatSistemaDTO getCatSistemaDTO() {
		return catSistemaDTO;
	}

	public void setCatSistemaDTO(CatSistemaDTO catSistemaDTO) {
		this.catSistemaDTO = catSistemaDTO;
	}

	public CatTipoFuncionalidadDTO getCatTipoFuncionalidadDTO() {
		return catTipoFuncionalidadDTO;
	}

	public void setCatTipoFuncionalidadDTO(CatTipoFuncionalidadDTO catTipoFuncionalidadDTO) {
		this.catTipoFuncionalidadDTO = catTipoFuncionalidadDTO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getUrlEspecifica() {
		return urlEspecifica;
	}

	public void setUrlEspecifica(String urlEspecifica) {
		this.urlEspecifica = urlEspecifica;
	}

}
