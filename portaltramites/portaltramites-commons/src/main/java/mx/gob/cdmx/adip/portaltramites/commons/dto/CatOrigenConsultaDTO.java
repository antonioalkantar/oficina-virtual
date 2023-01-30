package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatOrigenConsultaDTO implements Serializable {

	private static final long serialVersionUID = 5141403576626748977L;
	
	private Integer idOrgenConsultaDTO;
	private String descripcion;
	
	public static final Integer ID_ORIGEN_BUSCADOR_DIRECTO = 1;
	public static final Integer ID_ORIGEN_BUSCADOR_GRID = 2;
	public static final Integer ID_ORIGEN_PANTALLA_RESULTADOS = 3;
	public static final Integer ID_ORIGEN_URL_DIRECTA = 4;
	
	public CatOrigenConsultaDTO(Integer idOrgenConsultaDTO) {
		this.idOrgenConsultaDTO = idOrgenConsultaDTO;
	}
	
	public Integer getIdOrgenConsultaDTO() {
		return idOrgenConsultaDTO;
	}
	
	public void setIdOrgenConsultaDTO(Integer idOrgenConsultaDTO) {
		this.idOrgenConsultaDTO = idOrgenConsultaDTO;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
