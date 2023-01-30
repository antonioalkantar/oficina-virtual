package mx.gob.cdmx.adip.sibis.dto;

import java.io.Serializable;
import java.util.Date;

public class ResponsibleUnitsDTO implements Serializable {
	
	private static final long serialVersionUID = -3673934028881063932L;
	
	private long id;
	private String clave;
	private String desc;
	private String siglas;
	private int estatus;
	private Date deletedAt;
	private Date createdAt;
	private Date updatedAt;
	private int tipoEnte;	
	private Long idDependencia;
	
	public ResponsibleUnitsDTO() {
	}

	public ResponsibleUnitsDTO(Long idDependencia) {
		this.idDependencia = idDependencia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
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

	public int getTipoEnte() {
		return tipoEnte;
	}

	public void setTipoEnte(int tipoEnte) {
		this.tipoEnte = tipoEnte;
	}

	public Long getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Long idDependencia) {
		this.idDependencia = idDependencia;
	}

}
