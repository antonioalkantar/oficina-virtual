package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaRefrendoTarjetaCirculacionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8118249547887112078L;
	private String idTarjetaCirculacion;
	private String idDependencia;
	private String folioSemovi;
	private String placa;
	private String nbEstatus;
	private String fhVigencia;
	private Boolean stVigente;
	private Integer idEstatus;
	private String displayName;
	private String extension;
	private String fullName;
	private String content;
	
	public String getIdTarjetaCirculacion() {
		return idTarjetaCirculacion;
	}
	public void setIdTarjetaCirculacion(String idTarjetaCirculacion) {
		this.idTarjetaCirculacion = idTarjetaCirculacion;
	}
	public String getIdDependencia() {
		return idDependencia;
	}
	public void setIdDependencia(String idDependencia) {
		this.idDependencia = idDependencia;
	}
	public String getFolioSemovi() {
		return folioSemovi;
	}
	public void setFolioSemovi(String folioSemovi) {
		this.folioSemovi = folioSemovi;
	}
	public String getNbEstatus() {
		return nbEstatus;
	}
	public void setNbEstatus(String nbEstatus) {
		this.nbEstatus = nbEstatus;
	}
	public String getFhVigencia() {
		return fhVigencia;
	}
	public void setFhVigencia(String fhVigencia) {
		this.fhVigencia = fhVigencia;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Boolean getStVigente() {
		return stVigente;
	}
	public void setStVigente(Boolean stVigente) {
		this.stVigente = stVigente;
	}
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
