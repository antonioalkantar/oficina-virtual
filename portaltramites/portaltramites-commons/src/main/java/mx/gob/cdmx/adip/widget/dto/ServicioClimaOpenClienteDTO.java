package mx.gob.cdmx.adip.widget.dto;

import java.io.Serializable;

public class ServicioClimaOpenClienteDTO implements Serializable{
	

	private static final long serialVersionUID = 3182761698320894676L;
	
	private String main;
	private String description;
	private String icon;
	public Integer codigo;
	
	public ServicioClimaOpenClienteDTO() {} 
	
	
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description != null ? description.replace("Muy nuboso", "Muy nublado").replace("Nubes", "Con nubes") : "N/D";
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
}
