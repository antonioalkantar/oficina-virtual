package mx.gob.cdmx.adip.sibis.dto;

import java.io.Serializable;
import java.util.Date;

public class ResumenesProgramasDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5569668053454921013L;
	private Long id;
	private String descripcion;
	private String tipoApoyoOtorgado;
	private String montoApoyoOtorgado;
	private String periodicidad;
	private String requisitosAcceso;
	private Date createdAt;
	private Date updatedAt;
	private String poblacionObjetivo;
	private Boolean accesoSimultaneoPrograma;
	private String urlPrograma;
	private String pathInfografia;
	
	public ResumenesProgramasDTO() {
		
	}
	
	public ResumenesProgramasDTO(String urlPrograma) {
		this.urlPrograma = urlPrograma;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoApoyoOtorgado() {
		return tipoApoyoOtorgado;
	}
	public void setTipoApoyoOtorgado(String tipoApoyoOtorgado) {
		this.tipoApoyoOtorgado = tipoApoyoOtorgado;
	}
	public String getMontoApoyoOtorgado() {
		return montoApoyoOtorgado;
	}
	public void setMontoApoyoOtorgado(String montoApoyoOtorgado) {
		this.montoApoyoOtorgado = montoApoyoOtorgado;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}
	public String getRequisitosAcceso() {
		return requisitosAcceso;
	}
	public void setRequisitosAcceso(String requisitosAcceso) {
		this.requisitosAcceso = requisitosAcceso;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getPoblacionObjetivo() {
		return poblacionObjetivo;
	}
	public void setPoblacionObjetivo(String poblacionObjetivo) {
		this.poblacionObjetivo = poblacionObjetivo;
	}
	public Boolean getAccesoSimultaneoPrograma() {
		return accesoSimultaneoPrograma;
	}
	public void setAccesoSimultaneoPrograma(Boolean accesoSimultaneoPrograma) {
		this.accesoSimultaneoPrograma = accesoSimultaneoPrograma;
	}
	public String getUrlPrograma() {
		return urlPrograma;
	}
	public void setUrlPrograma(String urlPrograma) {
		this.urlPrograma = urlPrograma;
	}
	public String getPathInfografia() {
		return pathInfografia;
	}
	public void setPathInfografia(String pathInfografia) {
		this.pathInfografia = pathInfografia;
	}
	
}
