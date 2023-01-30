package mx.gob.cdmx.adip.portaltramites.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "resumenes_programas", schema = "public")
public class ResumenesProgramas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803780316999002182L;

	public ResumenesProgramas () {
		
	}
	
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
	private Programs programs;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "tipo_apoyo_otorgado")
	public String getTipoApoyoOtorgado() {
		return tipoApoyoOtorgado;
	}
	public void setTipoApoyoOtorgado(String tipoApoyoOtorgado) {
		this.tipoApoyoOtorgado = tipoApoyoOtorgado;
	}

	@Column(name = "monto_apoyo_otorgado")
	public String getMontoApoyoOtorgado() {
		return montoApoyoOtorgado;
	}
	public void setMontoApoyoOtorgado(String montoApoyoOtorgado) {
		this.montoApoyoOtorgado = montoApoyoOtorgado;
	}

	@Column(name = "periodicidad")
	public String getPeriodicidad() {
		return periodicidad;
	}
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	@Column(name = "requisitos_acceso")
	public String getRequisitosAcceso() {
		return requisitosAcceso;
	}
	public void setRequisitosAcceso(String requisitosAcceso) {
		this.requisitosAcceso = requisitosAcceso;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_at", length = 22)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 22)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "poblacion_obtetivo")
	public String getPoblacionObjetivo() {
		return poblacionObjetivo;
	}
	public void setPoblacionObjetivo(String poblacionObjetivo) {
		this.poblacionObjetivo = poblacionObjetivo;
	}

	@Column(name = "acceso_simultaneo_programa")
	public Boolean getAccesoSimultaneoPrograma() {
		return accesoSimultaneoPrograma;
	}
	public void setAccesoSimultaneoPrograma(Boolean accesoSimultaneoPrograma) {
		this.accesoSimultaneoPrograma = accesoSimultaneoPrograma;
	}

	@Column(name = "url_programa")
	public String getUrlPrograma() {
		return urlPrograma;
	}
	public void setUrlPrograma(String urlPrograma) {
		this.urlPrograma = urlPrograma;
	}

	@Column(name = "path_infografia")
	public String getPathInfografia() {
		return pathInfografia;
	}
	public void setPathInfografia(String pathInfografia) {
		this.pathInfografia = pathInfografia;
	}

	@ManyToOne
	@JoinColumn(name = "program_id")
	public Programs getPrograms() {
		return programs;
	}
	public void setPrograms(Programs programs) {
		this.programs = programs;
	}
}
