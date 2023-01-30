package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_actor database table.
 * 
 */
@Entity
@Table(name="cat_actor", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatActor.findAll", query="SELECT  new mx.gob.cdmx.adip.portaltramites.commons.dto.CatActoresDTO(c.id,c.descripcion,c.situacion) FROM CatActor c" 
			+ " WHERE c.situacion =true ORDER BY c.descripcion ASC" )
}) 

public class CatActor implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetPasosRegistrado> detPasosRegistrados;

	public CatActor() {
	}
	
	
	public CatActor(Long id) {
		this.id = id;
	}
	

	public CatActor(String descripcion, Boolean situacion, List<DetPasosRegistrado> detPasosRegistrados) {	
		
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detPasosRegistrados = detPasosRegistrados;
	}

	

	public CatActor(Long id, String descripcion, Boolean situacion, List<DetPasosRegistrado> detPasosRegistrados) {	
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detPasosRegistrados = detPasosRegistrados;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to DetPasosRegistrado
	@OneToMany(mappedBy="catActor")
	public List<DetPasosRegistrado> getDetPasosRegistrados() {
		return this.detPasosRegistrados;
	}

	public void setDetPasosRegistrados(List<DetPasosRegistrado> detPasosRegistrados) {
		this.detPasosRegistrados = detPasosRegistrados;
	}

	public DetPasosRegistrado addDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
		getDetPasosRegistrados().add(detPasosRegistrado);
		detPasosRegistrado.setCatActor(this);

		return detPasosRegistrado;
	}

	public DetPasosRegistrado removeDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
		getDetPasosRegistrados().remove(detPasosRegistrado);
		detPasosRegistrado.setCatActor(null);

		return detPasosRegistrado;
	}

}