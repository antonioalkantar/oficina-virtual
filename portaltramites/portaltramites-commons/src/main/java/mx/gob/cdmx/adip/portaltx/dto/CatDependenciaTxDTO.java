package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;
import java.util.Date;

public class CatDependenciaTxDTO implements Serializable {

	private static final long serialVersionUID = -393971347805090727L;
	
	private Integer idDependencia;
	private String nombre;
	private String acronimo;
	private boolean activo;
	private Date fechaAlta;
	
	public CatDependenciaTxDTO() {}

	public CatDependenciaTxDTO(Integer idDependencia, String nombre, boolean activo) {
		this.idDependencia = idDependencia;
		this.nombre = nombre;
		this.activo = activo;
	}

	public CatDependenciaTxDTO(Integer idDependencia, String nombre, String acronimo) {
		this.idDependencia = idDependencia;
		this.nombre = nombre;
		this.acronimo = acronimo;
	}

	public Integer getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
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

}
