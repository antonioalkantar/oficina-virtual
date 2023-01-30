package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetArchivosFormatoTramiteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7944077746416012904L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetFormatoDTO detFormato;
	private Boolean situacion;
	
   public DetArchivosFormatoTramiteDTO() {
		
	}
   public DetArchivosFormatoTramiteDTO(Long id,String nombreArchivo, Long idFormato, Long idFlujoTramite) {
		this.id = id;
		this.nombreArchivo = nombreArchivo;
		this.detFormato = new DetFormatoDTO(idFormato);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
	}


	public DetArchivosFormatoTramiteDTO(DetFormatoDTO detFormato) {
		
		this.detFormato = detFormato;
	}
	
	public DetArchivosFormatoTramiteDTO(Long id) {
		
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
