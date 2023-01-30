package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class DetUrlRegistradoDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481532742891048851L;
	
	
	private Long id;
	private String url;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetCanalAtencionDTO detCanalAtencion;
	private boolean situacion;
	
	public DetUrlRegistradoDTO() {	}

	public DetUrlRegistradoDTO( String url, CrcFlujoTramiteDTO crcFlujoTramite,
			DetCanalAtencionDTO detCanalAtencion, boolean situacion) {	
		this.url = url;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
		this.situacion = situacion;
	}
	


	public DetUrlRegistradoDTO(Long id, String url, CrcFlujoTramiteDTO crcFlujoTramite,
			DetCanalAtencionDTO detCanalAtencion, boolean situacion) {	
		this.id = id;
		this.url = url;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
		this.situacion = situacion;
	}

	public DetUrlRegistradoDTO(Long id, String url, Long idCanal, Long idTram ,Boolean situacion) {	
		this.id = id;
		this.url = url;
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idTram);
		this.detCanalAtencion = new DetCanalAtencionDTO(idCanal);
		this.situacion = situacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	public DetCanalAtencionDTO getDetCanalAtencion() {
		return detCanalAtencion;
	}

	public void setDetCanalAtencion(DetCanalAtencionDTO detCanalAtencion) {
		this.detCanalAtencion = detCanalAtencion;
	}

	public boolean isSituacion() {
		return situacion;
	}

	public void setSituacion(boolean situacion) {
		this.situacion = situacion;
	}

}
