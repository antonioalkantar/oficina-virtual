package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class ServicioLineaMetroDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5040553594062031195L;
	private String nombreLinea;
	private String colorLinea;
	
	public ServicioLineaMetroDTO() {}
	
	public String getNombreLinea() {
		return nombreLinea;
	}
	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}
	public String getColorLinea() {
		return colorLinea;
	}
	public void setColorLinea(String colorLinea) {
		this.colorLinea = colorLinea;
	}
	
	

}
