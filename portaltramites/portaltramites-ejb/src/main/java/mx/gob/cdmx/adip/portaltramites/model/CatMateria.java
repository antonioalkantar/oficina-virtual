package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cat_materia database table.
 * 
 */
@Entity
@Table(name="cat_materia", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatMateria.findAll"
	,query="SELECT new mx.gob.cdmx.adip.portaltramites.dto.AdminMateriaDTO"
			+ "(t.id " + 
			", t.descripcion) " + 
			"FROM CatMateria  t  ")

})
public class CatMateria implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatMateria() {
	}


	public CatMateria(Long id) {
		this.id = id;
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
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}