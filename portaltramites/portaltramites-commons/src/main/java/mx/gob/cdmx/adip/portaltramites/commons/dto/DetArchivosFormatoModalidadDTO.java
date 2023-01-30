package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetArchivosFormatoModalidadDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8045261341044429706L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetModalidadesTramiteDTO detModalidadesTramite;
	private Boolean situacion;
	private String rutaArchivo;
		
	public DetArchivosFormatoModalidadDTO() {
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		detModalidadesTramite = new DetModalidadesTramiteDTO();
	}
	
	public DetArchivosFormatoModalidadDTO(Long id, String nombreArchivo, Boolean situacion, Long idFlujoTramite,
			Long idModalidadesTramite, String rutaArchivo) {
		super();
		this.id = id;
		this.nombreArchivo = nombreArchivo;
		this.situacion = situacion;
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detModalidadesTramite = new DetModalidadesTramiteDTO(idModalidadesTramite);
		this.rutaArchivo = rutaArchivo;
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
	public DetModalidadesTramiteDTO getDetModalidadesTramite() {
		return detModalidadesTramite;
	}
	public void setDetModalidadesTramite(DetModalidadesTramiteDTO detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	
	public String nombreArchivoSinFormato() {
		return nombreArchivo != null ? nombreArchivo.contains(".") ?  nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.')) : nombreArchivo : "";
	}

}
