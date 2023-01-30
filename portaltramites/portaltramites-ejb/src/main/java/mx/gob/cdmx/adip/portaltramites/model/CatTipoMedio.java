package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_medio database table.
 * 
 */
@Entity
@Table(name="cat_tipo_medio", schema = "retys_v2")
@NamedQuery(name="CatTipoMedio.findAll", query="SELECT c FROM CatTipoMedio c")
public class CatTipoMedio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetCanalAtencion> detCanalAtencions;

	public CatTipoMedio() {
	}
	
	public CatTipoMedio(Long id) {
		this.id=id;
	}


	public CatTipoMedio(Long id, String descripcion, Boolean situacion, List<DetCanalAtencion> detCanalAtencions) {	
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.detCanalAtencions = detCanalAtencions;
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


	//bi-directional many-to-one association to DetCanalAtencion
	@OneToMany(mappedBy="catTipoMedio")
	public List<DetCanalAtencion> getDetCanalAtencions() {
		return this.detCanalAtencions;
	}

	public void setDetCanalAtencions(List<DetCanalAtencion> detCanalAtencions) {
		this.detCanalAtencions = detCanalAtencions;
	}

	public DetCanalAtencion addDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
		getDetCanalAtencions().add(detCanalAtencion);
		detCanalAtencion.setCatTipoMedio(this);

		return detCanalAtencion;
	}

	public DetCanalAtencion removeDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
		getDetCanalAtencions().remove(detCanalAtencion);
		detCanalAtencion.setCatTipoMedio(null);

		return detCanalAtencion;
	}

}