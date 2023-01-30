package mx.gob.cdmx.adip.portaltramites.commons.enums;

public enum RespuestaHttpEnum {
	//Códigos respuesta correcta
	CREACION_CORRECTA (201, "Creado correctamente."),
	ACTUALIZACION_CORRECTA (200, "Actualizado correctamente."),

	//Códigos para errores de validación
	FALTAN_PARAMETROS_OBLIGATORIOS (400, "Faltan parámetros obligatorios"),

	//Códigos de error
	ERROR_500 (500, "Server Error"),
	ERROR_INESPERADO(500, "Error inesperado");
	
	private Integer codigoRespuesta;
	private String mensajeRespuesta;
	
	RespuestaHttpEnum(final Integer codigoRespuesta, final String mensajeRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public Integer getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}	
}
