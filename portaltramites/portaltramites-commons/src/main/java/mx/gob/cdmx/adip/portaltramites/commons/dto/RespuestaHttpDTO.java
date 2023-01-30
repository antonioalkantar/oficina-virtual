package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class RespuestaHttpDTO implements Serializable {

	private static final long serialVersionUID = -3169150294977061195L;
	private Integer codigo;
	private String mensaje;

	public RespuestaHttpDTO() {

	}

	public RespuestaHttpDTO(Integer codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
