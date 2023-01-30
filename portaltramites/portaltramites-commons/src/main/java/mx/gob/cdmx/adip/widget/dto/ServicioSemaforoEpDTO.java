package mx.gob.cdmx.adip.widget.dto;

import java.io.Serializable;

public class ServicioSemaforoEpDTO implements Serializable{
	
	private static final long serialVersionUID = 3182761698320894676L;
	
	private Long id;
	private String nombre;
	private String color;
	
	public ServicioSemaforoEpDTO() {
	}
	
	public ServicioSemaforoEpDTO(Long id, String nombre, String color) {		
		this.id = id;
		this.nombre = nombre;
		this.color = color;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
