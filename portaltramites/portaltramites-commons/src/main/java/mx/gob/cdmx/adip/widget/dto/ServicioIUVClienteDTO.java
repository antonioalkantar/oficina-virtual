package mx.gob.cdmx.adip.widget.dto;

import java.io.Serializable;

public class ServicioIUVClienteDTO implements Serializable{
	

	private static final long serialVersionUID = 3182761698320894676L;
	private String iUV;
	
	public ServicioIUVClienteDTO() {}
	
	public String getiUV() {
		return iUV;
	}
	public void setiUV(String iUV) {
		this.iUV = iUV;
	}
	
}
