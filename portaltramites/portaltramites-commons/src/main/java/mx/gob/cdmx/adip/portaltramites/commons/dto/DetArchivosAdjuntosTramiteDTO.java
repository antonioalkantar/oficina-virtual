package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class DetArchivosAdjuntosTramiteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3767132446636424613L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetFormatoDTO detFormato;
	private Boolean situacion;
	
	public DetArchivosAdjuntosTramiteDTO () {
		
	}
	
	public DetArchivosAdjuntosTramiteDTO (Long id,String nombreArchivo, Long idFormato, Long idFlujoTramite) {
		this.id = id;
		this.nombreArchivo = nombreArchivo;
		this.detFormato = new DetFormatoDTO(idFormato);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
	}
	
	public DetArchivosAdjuntosTramiteDTO (DetFormatoDTO detFormato) {
		this.detFormato = detFormato;	
		}
	
	
	public DetArchivosAdjuntosTramiteDTO (Long id) {
	this.id = id;	
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}
	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}
	public DetFormatoDTO getDetFormato() {
		return detFormato;
	}
	public void setDetFormato(DetFormatoDTO detFormato) {
		this.detFormato = detFormato;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
}
