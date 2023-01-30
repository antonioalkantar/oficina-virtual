package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;




public class DetTelefonosRegistradosDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481532742891048851L;
	
	
	private Long id;
	private Long extensionTel;
	private Long numTelefono;
	private Boolean situacion;
	private List<DetHorariosTelefonosDTO> detHorariosTelefonos;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetCanalAtencionDTO detCanalAtencion;
	
	//Otros
	private DetHorariosTelefonosDTO horarioTelefono;

	public DetTelefonosRegistradosDTO() {
		
		horarioTelefono = new DetHorariosTelefonosDTO();
	}
	
	public DetTelefonosRegistradosDTO(Long id) {
		this.id = id;
	}
	
	
	public DetTelefonosRegistradosDTO(Long id, Long extensionTel, Long numTelefono, Boolean situacion, Long idCanal, Long idTramite,  Long idCanal1, Long idTramite1
			) {
		
		this.id = id;
		this.extensionTel = extensionTel;
		this.numTelefono = numTelefono;
		this.situacion = situacion;	
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idTramite);
		this.detCanalAtencion = new DetCanalAtencionDTO(idCanal);
	}
	
	
	public DetTelefonosRegistradosDTO( Long extensionTel, Long numTelefono, Boolean situacion,
			List<DetHorariosTelefonosDTO> detHorariosTelefonos, CrcFlujoTramiteDTO crcFlujoTramite,
			DetCanalAtencionDTO detCanalAtencion) {
		
		this.extensionTel = extensionTel;
		this.numTelefono = numTelefono;
		this.situacion = situacion;
		this.detHorariosTelefonos = detHorariosTelefonos;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
	}

	
	public DetTelefonosRegistradosDTO(Long id, Long extensionTel, Long numTelefono, Boolean situacion,
			List<DetHorariosTelefonosDTO> detHorariosTelefonos, CrcFlujoTramiteDTO crcFlujoTramite,
			DetCanalAtencionDTO detCanalAtencion) {
		
		this.id = id;
		this.extensionTel = extensionTel;
		this.numTelefono = numTelefono;
		this.situacion = situacion;
		this.detHorariosTelefonos = detHorariosTelefonos;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getExtensionTel() {
		return extensionTel;
	}



	public void setExtensionTel(Long extensionTel) {
		this.extensionTel = extensionTel;
	}



	public Long getNumTelefono() {
		return numTelefono;
	}



	public void setNumTelefono(Long numTelefono) {
		this.numTelefono = numTelefono;
	}



	public Boolean getSituacion() {
		return situacion;
	}



	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}



	public List<DetHorariosTelefonosDTO> getDetHorariosTelefonos() {
		return detHorariosTelefonos;
	}



	public void setDetHorariosTelefonos(List<DetHorariosTelefonosDTO> detHorariosTelefonos) {
		this.detHorariosTelefonos = detHorariosTelefonos;
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


	public DetHorariosTelefonosDTO getHorarioTelefono() {
		return horarioTelefono;
	}


	public void setHorarioTelefono(DetHorariosTelefonosDTO horarioTelefono) {
		this.horarioTelefono = horarioTelefono;
	}

}
