package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_estatus_unidad_administrativa database table.
 * 
 */
@Entity
@Table(name="cat_estatus_unidad_administrativa", schema = "retys_v2")
@NamedQuery(name="CatEstatusUnidadAdministrativa.findAll", query="SELECT c FROM CatEstatusUnidadAdministrativa c")
public class CatEstatusUnidadAdministrativa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<CatUnidadesAdministrativa> catUnidadesAdministrativas;

	public CatEstatusUnidadAdministrativa() {
	}
	
	public CatEstatusUnidadAdministrativa(Long id) {
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
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CatUnidadesAdministrativa
	@OneToMany(mappedBy="catEstatusUnidadAdministrativa")
	public List<CatUnidadesAdministrativa> getCatUnidadesAdministrativas() {
		return this.catUnidadesAdministrativas;
	}

	public void setCatUnidadesAdministrativas(List<CatUnidadesAdministrativa> catUnidadesAdministrativas) {
		this.catUnidadesAdministrativas = catUnidadesAdministrativas;
	}

	public CatUnidadesAdministrativa addCatUnidadesAdministrativa(CatUnidadesAdministrativa catUnidadesAdministrativa) {
		getCatUnidadesAdministrativas().add(catUnidadesAdministrativa);
		catUnidadesAdministrativa.setCatEstatusUnidadAdministrativa(this);

		return catUnidadesAdministrativa;
	}

	public CatUnidadesAdministrativa removeCatUnidadesAdministrativa(CatUnidadesAdministrativa catUnidadesAdministrativa) {
		getCatUnidadesAdministrativas().remove(catUnidadesAdministrativa);
		catUnidadesAdministrativa.setCatEstatusUnidadAdministrativa(null);

		return catUnidadesAdministrativa;
	}

}