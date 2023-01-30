package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;

public class GeocoderReverseMapsDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4221889167708616635L;
	
	private Integer codeStatus;
	private String direccion;
	
	public GeocoderReverseMapsDTO() {}
	
	public Integer getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(Integer codeStatus) {
		this.codeStatus = codeStatus;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
