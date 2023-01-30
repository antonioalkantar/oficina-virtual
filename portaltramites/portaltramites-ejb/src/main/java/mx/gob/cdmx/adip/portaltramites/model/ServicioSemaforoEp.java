package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="semaforo_epidemiologico", schema = "portaltramitescdmx")
@NamedQueries({
	@NamedQuery(name="ServicioSemaforoEp.findAll", query="SELECT t FROM ServicioSemaforoEp t"),
	
	@NamedQuery(name="ServicioSemaforoEp.findAllById"
	, query="SELECT new mx.gob.cdmx.adip.widget.dto.ServicioSemaforoEpDTO(t.id " + 
			", t.nombre " + 
			", t.color)  " + 
			"FROM ServicioSemaforoEp  t  ")
	
})
public class ServicioSemaforoEp implements Serializable{
	

	private static final long serialVersionUID = 3182761698320894676L;
	
	private Long id;
	private String nombre;
	private String color;
	
	
	public ServicioSemaforoEp() {}
	
	
	@Id
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="color")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
