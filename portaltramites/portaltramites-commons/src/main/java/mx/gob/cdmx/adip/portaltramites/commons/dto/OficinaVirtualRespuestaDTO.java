package mx.gob.cdmx.adip.portaltramites.commons.dto;

public class OficinaVirtualRespuestaDTO {
	private Integer codigoResultado;
	private String mensajeResultado;

	public OficinaVirtualRespuestaDTO() {
	}

	public OficinaVirtualRespuestaDTO(Integer codigoResultado, String mensajeResultado) {

		this.codigoResultado = codigoResultado;
		this.mensajeResultado = mensajeResultado;
	}

	public Integer getCodigoResultado() {
		return codigoResultado;
	}

	public void setCodigoResultado(Integer codigoResultado) {
		this.codigoResultado = codigoResultado;
	}

	public String getMensajeResultado() {
		return mensajeResultado;
	}

	public void setMensajeResultado(String mensajeResultado) {
		this.mensajeResultado = mensajeResultado;
	}

}
