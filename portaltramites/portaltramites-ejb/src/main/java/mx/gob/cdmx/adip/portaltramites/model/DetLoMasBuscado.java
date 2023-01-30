package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "det_lo_mas_buscado", schema = "portaltramitescdmx")
	@NamedQueries({ @NamedQuery(name = "DetLoMasBuscado.find", query = "SELECT d FROM DetLoMasBuscado d"),

	@NamedQuery(name="DetLoMasBuscado.findAll"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetLoMasBuscadoDTO "
			+ "("
			+ "t.id "
			+ ", t.idTramiteServicio " 
			+ ", t.titulo_tramite"
			+ ", t.descripcion_tramite"
			+ ", t.link_tramite"
			+ ", t.es_tramite_digital"
			+ ", t.situacion"
			+ ")  " + 
			"FROM DetLoMasBuscado t "),
})
public class DetLoMasBuscado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1174975267949235626L;
	private Long id;
	private Long idTramiteServicio;
	private String titulo_tramite;
	private String descripcion_tramite;
	private String link_tramite;
	private Boolean es_tramite_digital;
	private Boolean situacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="id_tramite_servicio")
	public Long getIdTramiteServicio() {
		return idTramiteServicio;
	}

	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}

	public String getTitulo_tramite() {
		return titulo_tramite;
	}

	public void setTitulo_tramite(String titulo_tramite) {
		this.titulo_tramite = titulo_tramite;
	}

	public String getDescripcion_tramite() {
		return descripcion_tramite;
	}

	public void setDescripcion_tramite(String descripcion_tramite) {
		this.descripcion_tramite = descripcion_tramite;
	}

	public String getLink_tramite() {
		return link_tramite;
	}

	public void setLink_tramite(String link_tramite) {
		this.link_tramite = link_tramite;
	}

	public Boolean getEs_tramite_digital() {
		return es_tramite_digital;
	}

	public void setEs_tramite_digital(Boolean es_tramite_digital) {
		this.es_tramite_digital = es_tramite_digital;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
