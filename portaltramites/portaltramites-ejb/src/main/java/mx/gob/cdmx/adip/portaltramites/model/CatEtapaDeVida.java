package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_etapa_de_vida database table.
 * 
 */
@Entity
@Table(name="cat_etapa_de_vida", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatEtapaDeVida.findAll"	
		,query="SELECT new mx.gob.cdmx.adip.portaltramites.dto.CatEtapaDeVidaDTO"
			+ "(t.id " + 
			", t.descripcion " + 
			", t.situacion) " + 
			"FROM CatEtapaDeVida  t  ")

})
public class CatEtapaDeVida implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;

	public CatEtapaDeVida() {
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

}