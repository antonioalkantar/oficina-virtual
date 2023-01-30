package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class CrcFlujoTramiteDTO implements Serializable {

	private static final long serialVersionUID = -7320874261757927267L;
	
	private Long id;
	private Date fecha;
	private String correoOrigen;
	private String nombreUsuarioOrigen;
	private String primerApellidoOrigen;
	private String segundoApellidoOrigen;
	private String tipoUsuarioOrigen;
	private String etapaTramiteOrigen;
	private String dependenciaOrigen;
//	private CatEstatusTramiteDTO catEstatusTramite;
	private CatEtapasTramiteDTO catEtapasTramite;
//	private CatTipoSolicitudDTO catTipoSolicitud;
//	private TramiteServicioDTO tramiteServicio;
//	private UsuarioDTO usuario;
	
	public CrcFlujoTramiteDTO() {
//		catEstatusTramite = new CatEstatusTramiteDTO();
		catEtapasTramite = new CatEtapasTramiteDTO();
//		catTipoSolicitud = new CatTipoSolicitudDTO();
//		usuario = new UsuarioDTO();
//		tramiteServicio = new TramiteServicioDTO();
	}
	
	public CrcFlujoTramiteDTO(Long id) {
		this.id = id;
		
	}
	//( d.id,d.fecha, catEst.id, catEst.descripcion,catTipo.id, catTipo.descripcion,catEtap.id, catEtap.descripcion,d.usuario.id    )
	
	public CrcFlujoTramiteDTO(Long id, Date fecha, Long catEstatusTramiteid, String catEstatusTramiteDescrip, Long  catTipoSolicitudId, String catTipoSolicitudDescripcion,
			Long catEtapasTramiteId, String catEtapasTramiteString,Long isUsuario, Long idTram ) {		
		this.id = id;
		this.fecha = fecha;
//		this.catEstatusTramite = new CatEstatusTramiteDTO(catEstatusTramiteid,catEstatusTramiteDescrip);
		this.catEtapasTramite =  new CatEtapasTramiteDTO(catEtapasTramiteId,catEtapasTramiteString);
//		this.catTipoSolicitud =  new CatTipoSolicitudDTO(catTipoSolicitudId,catTipoSolicitudDescripcion);
//		this.tramiteServicio = new TramiteServicioDTO(idTram);
//		this.usuario = new UsuarioDTO(isUsuario);
	}
	
	public CrcFlujoTramiteDTO(Long id,Long idEtapa) {
		this.id = id;
		this.catEtapasTramite = new CatEtapasTramiteDTO(idEtapa);
	}
	
//	public CrcFlujoTramiteDTO( Date fecha, CatEstatusTramiteDTO catEstatusTramite,
//			CatEtapasTramiteDTO catEtapasTramite, CatTipoSolicitudDTO catTipoSolicitud,
//			TramiteServicioDTO tramiteServicio, UsuarioDTO usuario) {		
//		
//		this.fecha = fecha;
//		this.catEstatusTramite = catEstatusTramite;
//		this.catEtapasTramite = catEtapasTramite;
//		this.catTipoSolicitud = catTipoSolicitud;
//		this.tramiteServicio = tramiteServicio;
//		this.usuario = usuario;
//	}
//	
//
//	public CrcFlujoTramiteDTO(Long id, Date fecha, CatEstatusTramiteDTO catEstatusTramite,
//			CatEtapasTramiteDTO catEtapasTramite, CatTipoSolicitudDTO catTipoSolicitud,
//			TramiteServicioDTO tramiteServicio, UsuarioDTO usuario) {
//		
//		this.id = id;
//		this.fecha = fecha;
//		this.catEstatusTramite = catEstatusTramite;
//		this.catEtapasTramite = catEtapasTramite;
//		this.catTipoSolicitud = catTipoSolicitud;
//		this.tramiteServicio = tramiteServicio;
//		this.usuario = usuario;
//	}
	
	
	//DTO Para notificaciones	
	public CrcFlujoTramiteDTO(Long id, Long idUsuario, String correoOrigen, String nombreUsuarioOrigen, String primerApellidoOrigen, String segundoApellidoOrigen,
			String tipoUsuarioOrigen, String etapaTramiteOrigen, String dependenciaOrigen, Long idEtapaTramite, String descripcionEtapa,
							 Long idEstatusTramite, String descripcionEstatus,  Long idTramite,  String homoclave, String nombreTramite,
							 Long idTipoSolicitud, String descripcionTipoSolicitud,  Date fecha) {
		this.id = id;
//		this.usuario = new UsuarioDTO(idUsuario);
		this.correoOrigen = correoOrigen;	
		this. nombreUsuarioOrigen = nombreUsuarioOrigen;
		this. primerApellidoOrigen = primerApellidoOrigen;
		this. segundoApellidoOrigen = segundoApellidoOrigen;
		this. tipoUsuarioOrigen = tipoUsuarioOrigen;
		this. etapaTramiteOrigen = etapaTramiteOrigen;
		this. dependenciaOrigen = dependenciaOrigen;		
		this.catEtapasTramite = new CatEtapasTramiteDTO(idEtapaTramite, descripcionEtapa);
//		this.catEstatusTramite = new CatEstatusTramiteDTO(idEstatusTramite, descripcionEstatus);
//		this.tramiteServicio = new TramiteServicioDTO(idTramite, homoclave, nombreTramite);
//		this.catTipoSolicitud =  new CatTipoSolicitudDTO(idTipoSolicitud,descripcionTipoSolicitud);
		this.fecha = fecha;		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
//
//	public CatEstatusTramiteDTO getCatEstatusTramite() {
//		return catEstatusTramite;
//	}
//
//	public void setCatEstatusTramite(CatEstatusTramiteDTO catEstatusTramite) {
//		this.catEstatusTramite = catEstatusTramite;
//	}
//
//	public CatEtapasTramiteDTO getCatEtapasTramite() {
//		return catEtapasTramite;
//	}
//
//	public void setCatEtapasTramite(CatEtapasTramiteDTO catEtapasTramite) {
//		this.catEtapasTramite = catEtapasTramite;
//	}
//
//	public CatTipoSolicitudDTO getCatTipoSolicitud() {
//		return catTipoSolicitud;
//	}
//
//	public void setCatTipoSolicitud(CatTipoSolicitudDTO catTipoSolicitud) {
//		this.catTipoSolicitud = catTipoSolicitud;
//	}
//
//	public TramiteServicioDTO getTramiteServicio() {
//		return tramiteServicio;
//	}
//
//	public void setTramiteServicio(TramiteServicioDTO tramiteServicio) {
//		this.tramiteServicio = tramiteServicio;
//	}
//
//	public UsuarioDTO getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(UsuarioDTO usuario) {
//		this.usuario = usuario;
//	}

	public String getCorreoOrigen() {
		return correoOrigen;
	}

	public void setCorreoOrigen(String correoOrigen) {
		this.correoOrigen = correoOrigen;
	}

	public String getNombreUsuarioOrigen() {
		return nombreUsuarioOrigen;
	}

	public void setNombreUsuarioOrigen(String nombreUsuarioOrigen) {
		this.nombreUsuarioOrigen = nombreUsuarioOrigen;
	}

	public String getPrimerApellidoOrigen() {
		return primerApellidoOrigen;
	}

	public void setPrimerApellidoOrigen(String primerApellidoOrigen) {
		this.primerApellidoOrigen = primerApellidoOrigen;
	}

	public String getSegundoApellidoOrigen() {
		return segundoApellidoOrigen;
	}

	public void setSegundoApellidoOrigen(String segundoApellidoOrigen) {
		this.segundoApellidoOrigen = segundoApellidoOrigen;
	}

	public String getTipoUsuarioOrigen() {
		return tipoUsuarioOrigen;
	}

	public void setTipoUsuarioOrigen(String tipoUsuarioOrigen) {
		this.tipoUsuarioOrigen = tipoUsuarioOrigen;
	}

	public String getEtapaTramiteOrigen() {
		return etapaTramiteOrigen;
	}

	public void setEtapaTramiteOrigen(String etapaTramiteOrigen) {
		this.etapaTramiteOrigen = etapaTramiteOrigen;
	}

	public String getDependenciaOrigen() {
		return dependenciaOrigen;
	}

	public void setDependenciaOrigen(String dependenciaOrigen) {
		this.dependenciaOrigen = dependenciaOrigen;
	}	
}
