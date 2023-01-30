package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatMetroEstacionesDTO implements Serializable{


	private static final long serialVersionUID = -9076115540658006359L;
	
	private Long id;
	private Long idEstacion;
	private String idLinea;
	private String nombreEstacion;
	private String tiempoArriboDirUno;
	private String movimientoDirUno;
	private String ultimaEstDirUno;
	
	private String tiempoArriboDirDos;
	private String movimientoDirDos;
	private String ultimaEstDirDos;
	private Boolean situacion;
	private String lineaestacion;
	
	
	
	
	public CatMetroEstacionesDTO() {}
	
	public CatMetroEstacionesDTO(Long id, Long idEstacion, String idLinea, String nombreEstacion,
			String tiempoArriboDirUno, String movimientoDirUno, String ultimaEstDirUno, String tiempoArriboDirDos,
			String movimientoDirDos, String ultimaEstDirDos) {
		this.id = id;
		this.idEstacion = idEstacion;
		this.idLinea = idLinea;
		this.nombreEstacion = nombreEstacion;
		this.tiempoArriboDirUno = tiempoArriboDirUno;
		this.movimientoDirUno = movimientoDirUno;
		this.ultimaEstDirUno = ultimaEstDirUno;
		this.tiempoArriboDirDos = tiempoArriboDirDos;
		this.movimientoDirDos = movimientoDirDos;
		this.ultimaEstDirDos = ultimaEstDirDos;
	}
	
	public CatMetroEstacionesDTO(Long id, Long idEstacion, String idLinea, String nombreEstacion
			) {
		this.id = id;
		this.idEstacion = idEstacion;
		this.idLinea = idLinea;
		this.nombreEstacion = nombreEstacion;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdEstacion() {
		return idEstacion;
	}
	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}
	public String getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(String idLinea) {
		this.idLinea = idLinea;
	}
	public String getNombreEstacion() {
		return nombreEstacion;
	}
	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}
	public String getTiempoArriboDirUno() {
		return tiempoArriboDirUno;
	}
	public void setTiempoArriboDirUno(String tiempoArriboDirUno) {
		this.tiempoArriboDirUno = tiempoArriboDirUno;
	}
	public String getMovimientoDirUno() {
		return movimientoDirUno;
	}
	public void setMovimientoDirUno(String movimientoDirUno) {
		this.movimientoDirUno = movimientoDirUno;
	}
	public String getUltimaEstDirUno() {
		return ultimaEstDirUno;
	}
	public void setUltimaEstDirUno(String ultimaEstDirUno) {
		this.ultimaEstDirUno = ultimaEstDirUno;
	}
	public String getTiempoArriboDirDos() {
		return tiempoArriboDirDos;
	}
	public void setTiempoArriboDirDos(String tiempoArriboDirDos) {
		this.tiempoArriboDirDos = tiempoArriboDirDos;
	}
	public String getMovimientoDirDos() {
		return movimientoDirDos;
	}
	public void setMovimientoDirDos(String movimientoDirDos) {
		this.movimientoDirDos = movimientoDirDos;
	}
	public String getUltimaEstDirDos() {
		return ultimaEstDirDos;
	}
	public void setUltimaEstDirDos(String ultimaEstDirDos) {
		this.ultimaEstDirDos = ultimaEstDirDos;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public String getLineaestacion() {
		return lineaestacion;
	}

	public void setLineaestacion(String lineaestacion) {
		this.lineaestacion = lineaestacion;
	}



}
