package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;

public class ServicioVerificacionDTO implements Serializable{
	
	private static final long serialVersionUID = 6795056337169885357L;
	private String nombreLinea;
	private String colorLinea;
	private List<String> estaciones;
	
	public ServicioVerificacionDTO() {}
	
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
	public List<String> getEstaciones() {
		return estaciones;
	}
	public void setEstaciones(List<String> estaciones) {
		this.estaciones = estaciones;
	}
}
