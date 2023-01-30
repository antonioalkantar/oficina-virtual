package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class CatOrigenRegistroDTO implements Serializable {
	
	private static final long serialVersionUID = 1337507251619759241L;
	
	private Integer idOrigenRegistro;
	private String descripcion;
	
	public CatOrigenRegistroDTO() {}

	public CatOrigenRegistroDTO(Integer idOrigenRegistro, String descripcion) {
		this.idOrigenRegistro = idOrigenRegistro;
		this.descripcion = descripcion;
	}

	public Integer getIdOrigenRegistro() {
		return idOrigenRegistro;
	}

	public void setIdOrigenRegistro(Integer idOrigenRegistro) {
		this.idOrigenRegistro = idOrigenRegistro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
