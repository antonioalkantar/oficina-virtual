package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetLoMasBuscadoDTO implements Serializable {

	private static final long serialVersionUID = -1304037432876166635L;
	private Long id;
	private Long idTramiteServicio;
	private String titulo_tramite;
	private String descripcion_tramite;
	private String link_tramite;
	private Boolean es_tramite_digital;
	private Boolean situacion;

	public DetLoMasBuscadoDTO(Long id, Long idTramiteServicio, String titulo_tramite, String descripcion_tramite,
			String link_tramite, Boolean es_tramite_digital, Boolean situacion) {
		this.id = id;
		this.idTramiteServicio = idTramiteServicio;
		this.titulo_tramite = titulo_tramite;
		this.descripcion_tramite = descripcion_tramite;
		this.link_tramite = link_tramite;
		this.es_tramite_digital = es_tramite_digital;
		this.situacion = situacion;
	}

	public DetLoMasBuscadoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean isSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public Long getIdTramiteServicio() {
		return idTramiteServicio;
	}

	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}

}
