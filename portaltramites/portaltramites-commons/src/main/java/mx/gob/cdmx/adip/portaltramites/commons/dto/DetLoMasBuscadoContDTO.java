package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetLoMasBuscadoContDTO implements Serializable{

	private static final long serialVersionUID = -1204037432876166635L;
	private Long id;
	private Long idTramiteServicio;
	private Integer contadorAccesos;
	private Boolean situacion;

	public DetLoMasBuscadoContDTO() {

	}

	public DetLoMasBuscadoContDTO(Long id, Long idTramiteServicio, Integer contadorAccesos, Boolean situacion) {
		this.id = id;
		this.idTramiteServicio = idTramiteServicio;
		this.contadorAccesos = contadorAccesos;
		this.situacion = situacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTramiteServicio() {
		return idTramiteServicio;
	}

	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}

	public Integer getContadorAccesos() {
		return contadorAccesos;
	}

	public void setContadorAccesos(Integer contadorAccesos) {
		this.contadorAccesos = contadorAccesos;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
