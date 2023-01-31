package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;
import java.util.Date;

public class RegistroDTO implements Serializable {
	
	private static final long serialVersionUID = 3344513229360590100L;
	
	private long idRegistro;
	private CatEstatusDTO catEstatusDTO;
	private CatTipoFuncionalidadDTO catTipoFuncionalidadDTO;
	private CatFuncionalidadDTO catFuncionalidadDTO;
	private CatOrigenRegistroDTO catOrigenRegistroDTO;
	private CatSistemaDTO catSistemaDTO;
	private CatDependenciaTxDTO catDependenciaTxDTO;
	private String idRegistroOrigen;
	private Date fechaRegistro;
	private Date fechaRecibido;
	private Date fechaUltimaActualizacion;
	private Long idUsuarioLlaveCdmx;
	private String curpUsuario;
	private String correoUsuario;
	private boolean visible;
	//Auxiliares NoAntecedentes
	private String tipoTramite;
	private String folio;
	//Auxiliares Licencia
	private String tipoLicencia;
	private String numeroLicencia;
	private String fechaNuevaVigencia;	
	private String estatusTramite;
	private String pathImagen;
	
	public RegistroDTO() {}

	public RegistroDTO(Long idRegistro, Date fechaRegistro, Long idUsuarioLlaveCdmx, String idRegistroOrigen, Integer idEstatus, String descripcionEstatus 
					   , Integer idFuncionalidad, String nombreFuncionalidad, String urlEspecifica, Integer idTipoFuncionalidad
					   , String nombreTipoFuncionalidad, Integer idSistema, String nombreSistema, String urlSistema
					   , String pathImagenSistema, Boolean activoSistema, Integer idDependencia, String nombreDependencia
					   , Boolean activoDependencia
						) {
		this.idRegistro = idRegistro;
		this.fechaRegistro = fechaRegistro;
		this.idRegistroOrigen = idRegistroOrigen;
		this.catEstatusDTO = new CatEstatusDTO(idEstatus, descripcionEstatus);		
		this.catFuncionalidadDTO = new CatFuncionalidadDTO(idFuncionalidad, nombreFuncionalidad , urlEspecifica);
		this.catTipoFuncionalidadDTO = new CatTipoFuncionalidadDTO(idTipoFuncionalidad,nombreTipoFuncionalidad );
		this.catSistemaDTO = new CatSistemaDTO(idSistema, nombreSistema, urlSistema, pathImagenSistema, activoSistema);
		this.catDependenciaTxDTO = new CatDependenciaTxDTO(idDependencia, nombreDependencia, activoDependencia);
	}

	public long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public CatEstatusDTO getCatEstatusDTO() {
		return catEstatusDTO;
	}

	public void setCatEstatusDTO(CatEstatusDTO catEstatusDTO) {
		this.catEstatusDTO = catEstatusDTO;
	}

	public CatSistemaDTO getCatSistemaDTO() {
		return catSistemaDTO;
	}

	public void setCatSistemaDTO(CatSistemaDTO catSistemaDTO) {
		this.catSistemaDTO = catSistemaDTO;
	}

	public CatDependenciaTxDTO getCatDependenciaTxDTO() {
		return catDependenciaTxDTO;
	}

	public void setCatDependenciaTxDTO(CatDependenciaTxDTO catDependenciaTxDTO) {
		this.catDependenciaTxDTO = catDependenciaTxDTO;
	}

	public CatTipoFuncionalidadDTO getCatTipoFuncionalidadDTO() {
		return catTipoFuncionalidadDTO;
	}

	public void setCatTipoFuncionalidadDTO(CatTipoFuncionalidadDTO catTipoFuncionalidadDTO) {
		this.catTipoFuncionalidadDTO = catTipoFuncionalidadDTO;
	}

	public CatFuncionalidadDTO getCatFuncionalidadDTO() {
		return catFuncionalidadDTO;
	}

	public void setCatFuncionalidadDTO(CatFuncionalidadDTO catFuncionalidadDTO) {
		this.catFuncionalidadDTO = catFuncionalidadDTO;
	}

	public CatOrigenRegistroDTO getCatOrigenRegistroDTO() {
		return catOrigenRegistroDTO;
	}

	public void setCatOrigenRegistroDTO(CatOrigenRegistroDTO catOrigenRegistroDTO) {
		this.catOrigenRegistroDTO = catOrigenRegistroDTO;
	}

	public String getIdRegistroOrigen() {
		return idRegistroOrigen;
	}

	public void setIdRegistroOrigen(String idRegistroOrigen) {
		this.idRegistroOrigen = idRegistroOrigen;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Long getIdUsuarioLlaveCdmx() {
		return idUsuarioLlaveCdmx;
	}

	public void setIdUsuarioLlaveCdmx(Long idUsuarioLlaveCdmx) {
		this.idUsuarioLlaveCdmx = idUsuarioLlaveCdmx;
	}

	public String getCurpUsuario() {
		return curpUsuario;
	}

	public void setCurpUsuario(String curpUsuario) {
		this.curpUsuario = curpUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public String getTipoLicencia() {
		return tipoLicencia;
	}

	public void setTipoLicencia(String tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}

	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}

	public String getFechaNuevaVigencia() {
		return fechaNuevaVigencia;
	}

	public void setFechaNuevaVigencia(String fechaNuevaVigencia) {
		this.fechaNuevaVigencia = fechaNuevaVigencia;
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
