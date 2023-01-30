package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;



public class DetPasosRegistradoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775640027383263467L;
	
	private Long id;
	private String descripcion;
	private Long numeroPaso;	
	private CatActorDTO catActor;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetCanalAtencionDTO detCanalAtencion;	
	private Boolean situacion;
	private Long tipoSolicitud;
	
//	private CrcModificacionDTO modificacionDTO;
	
	public DetPasosRegistradoDTO() {
		this.catActor=new CatActorDTO();
	}
	

	
	public DetPasosRegistradoDTO(Long id, String descripcion, Long numeroPaso, Long idActor, String descrActor,		
			Boolean situacion,Long idCanal, Long idTram,Long tipoSolicitud) {
		this.id = id;
		this.descripcion = descripcion;
		this.numeroPaso = numeroPaso;
		this.catActor = new CatActorDTO(idActor,descrActor);		
		this.detCanalAtencion = new DetCanalAtencionDTO(idCanal);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idTram);
	
		this.situacion = situacion;
		this.tipoSolicitud=tipoSolicitud;
	} 


	public DetPasosRegistradoDTO( String descripcion, Long numeroPaso, CatActorDTO catActor,
			CrcFlujoTramiteDTO crcFlujoTramite, DetCanalAtencionDTO detCanalAtencion, Boolean tieneFundamentoJuridico,
			Boolean situacion,Long tipoSolicitud) {
	
		this.descripcion = descripcion;
		this.numeroPaso = numeroPaso;
		this.catActor = catActor;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
	
		this.situacion = situacion;
		this.tipoSolicitud=tipoSolicitud;
	}



	public DetPasosRegistradoDTO(Long id, String descripcion, Long numeroPaso, CatActorDTO catActor,
			CrcFlujoTramiteDTO crcFlujoTramite, DetCanalAtencionDTO detCanalAtencion, Boolean tieneFundamentoJuridico,
			Boolean situacion,Long tipoSolicitud) {
		this.id = id;
		this.descripcion = descripcion;
		this.numeroPaso = numeroPaso;
		this.catActor = catActor;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
		
		this.situacion = situacion;
		this.tipoSolicitud=tipoSolicitud;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getNumeroPaso() {
		return numeroPaso;
	}

	public void setNumeroPaso(Long numeroPaso) {
		this.numeroPaso = numeroPaso;
	}

	public CatActorDTO getCatActor() {
		return catActor;
	}

	public void setCatActor(CatActorDTO catActor) {
		this.catActor = catActor;
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




	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}



	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}



	public void setTipoSolicitud(Long tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}


//
//	public CrcModificacionDTO getModificacionDTO() {
//		return modificacionDTO;
//	}
//
//
//
//	public void setModificacionDTO(CrcModificacionDTO modificacionDTO) {
//		this.modificacionDTO = modificacionDTO;
//	}




	
	
	

}
