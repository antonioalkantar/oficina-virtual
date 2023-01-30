package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the det_encabezado database table.
 * 
 */
@Entity
@Table(name = "det_encabezado", schema = "portaltramitescdmx")
@NamedQueries({ 
	@NamedQuery(name = "DetEncabezado.find", query = "SELECT d FROM DetEncabezado d"),

	@NamedQuery(name="DetEncabezado.findAll"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO "
			+ "("
			+ "t.id "
			+ ", t.descripcion_encabezado " 
			+ ", t.link_encabezado"
			+ ", t.background"
			+ ", t.orden"
			+ ", t.situacion"
			+ ")  " + 
			"FROM DetEncabezado t "),
	@NamedQuery(name="DetEncabezado.findByEstatus"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO "
			+ "("
			+ "t.id "
			+ ", t.descripcion_encabezado " 
			+ ", t.link_encabezado"
			+ ", t.background"
			+ ", t.orden"
			+ ", t.situacion"
			+ ", t.estatus"
			+ ")  " 
			+ " FROM DetEncabezado t "
			+ " WHERE t.estatus = TRUE"),
	@NamedQuery(name="DetEncabezado.findBySituacion"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO "
			+ "("
			+ "t.id "
			+ ", t.descripcion_encabezado " 
			+ ", t.link_encabezado"
			+ ", t.background"
			+ ", t.orden"
			+ ", t.situacion"
			+ ")  " 
			+ " FROM DetEncabezado t "
			+ " WHERE t.estatus = TRUE "
			+ " AND t.situacion = TRUE")
})
public class DetEncabezado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5274933959075470531L;
	private Long id;
	private String descripcion_encabezado;
	private String link_encabezado;
	private String background;
	private Long orden;
	private Boolean situacion;
	private boolean estatus;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion_encabezado() {
		return descripcion_encabezado;
	}

	public void setDescripcion_encabezado(String descripcion_encabezado) {
		this.descripcion_encabezado = descripcion_encabezado;
	}

	public String getLink_encabezado() {
		return link_encabezado;
	}

	public void setLink_encabezado(String link_encabezado) {
		this.link_encabezado = link_encabezado;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
