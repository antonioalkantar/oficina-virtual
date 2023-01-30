package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;
import java.util.Date;

public class OficinaVirtualDTO implements Serializable {

	private static final long serialVersionUID = 6437256856663403748L;
	private Long idSistema;
	private Long idFuncionalidad;
	private String idRegistro;
	private Long idEstatus;
	private String fechaRegistro;
	private Long idUsuarioLlavecdmx;
	private String curpUsuario;
	private String correoUsuario;

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public Long getIdFuncionalidad() {
		return idFuncionalidad;
	}

	public void setIdFuncionalidad(Long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	public String getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(String idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Long getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getIdUsuarioLlavecdmx() {
		return idUsuarioLlavecdmx;
	}

	public void setIdUsuarioLlavecdmx(Long idUsuarioLlavecdmx) {
		this.idUsuarioLlavecdmx = idUsuarioLlavecdmx;
	}

	public String getCurpUsuario() {
		return curpUsuario;
	}

	public void setCurpUsuario(String curpUsuario) {
		this.curpUsuario = curpUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}	

}
