package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class CatEstatusDTO implements Serializable {
	
	private static final long serialVersionUID = -6296454299663932333L;
	
	private Integer idEstatus;
	private String descripcion;
	
	public CatEstatusDTO() {}

	public CatEstatusDTO(Integer idEstatus, String descripcion) {
		this.idEstatus = idEstatus;
		this.descripcion = descripcion;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
