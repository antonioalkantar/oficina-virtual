package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaCortesiaUrbanaDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1910884683825265351L;

	private String folioSolicitud;
	private String tipoDiscapacidad;
	private String folioTarjeta;
	private String vigenteAl;
	private String estatusTramite;
	private String pathImagen;

	public String getFolioSolicitud() {
		return folioSolicitud;
	}

	public void setFolioSolicitud(String folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	public String getTipoDiscapacidad() {
		return tipoDiscapacidad;
	}

	public void setTipoDiscapacidad(String tipoDiscapacidad) {
		this.tipoDiscapacidad = tipoDiscapacidad;
	}

	public String getFolioTarjeta() {
		return folioTarjeta;
	}

	public void setFolioTarjeta(String folioTarjeta) {
		this.folioTarjeta = folioTarjeta;
	}

	public String getVigenteAl() {
		return vigenteAl;
	}

	public void setVigenteAl(String vigenteAl) {
		this.vigenteAl = vigenteAl;
	}

	public String getEstatusTramite() {
		return estatusTramite;
	}

	public void setEstatusTramite(String estatusTramite) {
		this.estatusTramite = estatusTramite;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

}
