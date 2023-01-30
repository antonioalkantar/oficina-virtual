package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the cat_dia_semana database table.
 */
@Entity
@Table(name="cat_origen_consulta", schema = "portaltramitescdmx")
public class CatOrigenConsulta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idOrigenConsulta;
	private String descripcion;

	public CatOrigenConsulta() {
	}
	
	@Id
	@Column(name="id_origen_consulta")
	public Long getIdOrigenConsulta() {
		return idOrigenConsulta;
	}

	public void setIdOrigenConsulta(Long idOrigenConsulta) {
		this.idOrigenConsulta = idOrigenConsulta;
	}

	@Column(name="descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}