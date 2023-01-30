package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DetUnidadesAdmRespDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long numeroUnidades;
	private String calle;
	private String email;
	private String numExterior;
	private String numInterior;
	private String telefono;
	private DetHorariosUnidAdmRespDTO detHorariosUnidAdmRespDTO;
//	private CatAlcaldiaDTO catAlcaldiaDTO;
	private CatAsentamientosDTO catAsentamientosDTO;
	private CatCodigosPostalesDTO catCodigosPostalesDTO;
	private CatTipoVialidadDTO catTipoVialidadDTO;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private TramiteServicioDTO tramiteServicioDTO;
	private CatUnidadesAdministrativaDTO catUnidadesAdministrativaDTO;
	private Boolean situacion;
	
	
//	private CrcModificacionDTO modificacionDTO;
	
	
	
	private Map<Long,DetHorariosUnidAdmRespDTO> lstDetHorariosUnidAdmRespDTO;

	public DetUnidadesAdmRespDTO() {
		//detHorariosUnidAdmRespDTO = new DetHorariosUnidAdmRespDTO();
	}

	public DetUnidadesAdmRespDTO(Long id) {
		this.id = id;
	}
	
	public DetUnidadesAdmRespDTO(Long id,Long numeroUnidades, Boolean situacion) {
		this.id = id;
		this.numeroUnidades=numeroUnidades;
		this.situacion=situacion;
		
	}

	public DetUnidadesAdmRespDTO(Long id, Long idTramite, String homoclave, String nombreOficial, Long numeroUnidades
			, Long idUnidadAdministrativa, String nombreUnidad, Long tipoVialidad, String nombreVialidad 
			, String calle, String numExterior, String numInterior, Integer idAlcaldia, Integer idEstado
			, Integer idMunicipioPorEstado, String municipio, Integer idAsentamiento , String descripcion, int idCodigoPostal
			, String codigoPostal , String telefono, String email
			, Long idCrcFlujoTramite, Boolean situacion) {

		this.id = id;
		this.tramiteServicioDTO = new TramiteServicioDTO(idTramite, homoclave, nombreOficial);
		this.numeroUnidades = numeroUnidades;
		this.catUnidadesAdministrativaDTO = new CatUnidadesAdministrativaDTO(idUnidadAdministrativa, nombreUnidad);
		this.catTipoVialidadDTO = new CatTipoVialidadDTO(tipoVialidad, nombreVialidad);
		this.calle = calle;
		this.numExterior = numExterior;
		this.numInterior = numInterior;
//		this.catAlcaldiaDTO = new CatAlcaldiaDTO(idAlcaldia, idEstado, idMunicipioPorEstado, municipio);
		this.catAsentamientosDTO = new CatAsentamientosDTO(idAsentamiento, descripcion);
		this.catCodigosPostalesDTO = new CatCodigosPostalesDTO(idCodigoPostal, codigoPostal);
		this.email = email;
		this.telefono = telefono;
		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite);
		this.situacion  = situacion;
	}
	
	public DetUnidadesAdmRespDTO(Long id, Long idTramite, String homoclave, String nombreOficial, Long numeroUnidades
			, Long idUnidadAdministrativa, String nombreUnidad, Long tipoVialidad, String nombreVialidad 
			, String calle, String numExterior, String numInterior, Integer idAlcaldia, Integer idEstado
			, Integer idMunicipioPorEstado, String municipio, Integer idAsentamiento , String descripcion, int idCodigoPostal
			, String codigoPostal , String telefono, String email
			, Long idCrcFlujoTramite, Boolean situacion, Long idModificacion, String fundamento, String motivo) {

		this.id = id;
		this.tramiteServicioDTO = new TramiteServicioDTO(idTramite, homoclave, nombreOficial);
		this.numeroUnidades = numeroUnidades;
		this.catUnidadesAdministrativaDTO = new CatUnidadesAdministrativaDTO(idUnidadAdministrativa, nombreUnidad);
		this.catTipoVialidadDTO = new CatTipoVialidadDTO(tipoVialidad, nombreVialidad);
		this.calle = calle;
		this.numExterior = numExterior;
		this.numInterior = numInterior;
//		this.catAlcaldiaDTO = new CatAlcaldiaDTO(idAlcaldia, idEstado, idMunicipioPorEstado, municipio);
		this.catAsentamientosDTO = new CatAsentamientosDTO(idAsentamiento, descripcion);
		this.catCodigosPostalesDTO = new CatCodigosPostalesDTO(idCodigoPostal, codigoPostal);
		this.email = email;
		this.telefono = telefono;
		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite);
		this.situacion  = situacion;
		
//		this.modificacionDTO = new CrcModisficacionDTO(idModificacion, fundamento, motivo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumExterior() {
		return numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}

	public String getNumInterior() {
		return numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

//	public CatAlcaldiaDTO getCatAlcaldiaDTO() {
//		return catAlcaldiaDTO;
//	}
//
//	public void setCatAlcaldiaDTO(CatAlcaldiaDTO catAlcaldiaDTO) {
//		this.catAlcaldiaDTO = catAlcaldiaDTO;
//	}

	public CatAsentamientosDTO getCatAsentamientosDTO() {
		return catAsentamientosDTO;
	}

	public void setCatAsentamientosDTO(CatAsentamientosDTO catAsentamientosDTO) {
		this.catAsentamientosDTO = catAsentamientosDTO;
	}

	public CatCodigosPostalesDTO getCatCodigosPostalesDTO() {
		return catCodigosPostalesDTO;
	}

	public void setCatCodigosPostalesDTO(CatCodigosPostalesDTO catCodigosPostalesDTO) {
		this.catCodigosPostalesDTO = catCodigosPostalesDTO;
	}

	public CatTipoVialidadDTO getCatTipoVialidadDTO() {
		return catTipoVialidadDTO;
	}

	public void setCatTipoVialidadDTO(CatTipoVialidadDTO catTipoVialidadDTO) {
		this.catTipoVialidadDTO = catTipoVialidadDTO;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramiteDTO() {
		return crcFlujoTramiteDTO;
	}

	public void setCrcFlujoTramiteDTO(CrcFlujoTramiteDTO crcFlujoTramiteDTO) {
		this.crcFlujoTramiteDTO = crcFlujoTramiteDTO;
	}

	public TramiteServicioDTO getTramiteServicioDTO() {
		return tramiteServicioDTO;
	}

	public void setTramiteServicioDTO(TramiteServicioDTO tramiteServicioDTO) {
		this.tramiteServicioDTO = tramiteServicioDTO;
	}

	public DetHorariosUnidAdmRespDTO getDetHorariosUnidAdmRespDTO() {
		return detHorariosUnidAdmRespDTO;
	}

	public void setDetHorariosUnidAdmRespDTO(DetHorariosUnidAdmRespDTO detHorariosUnidAdmRespDTO) {
		this.detHorariosUnidAdmRespDTO = detHorariosUnidAdmRespDTO;
	}

	public Long getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(Long numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public CatUnidadesAdministrativaDTO getCatUnidadesAdministrativaDTO() {
		return catUnidadesAdministrativaDTO;
	}

	public void setCatUnidadesAdministrativaDTO(CatUnidadesAdministrativaDTO catUnidadesAdministrativaDTO) {
		this.catUnidadesAdministrativaDTO = catUnidadesAdministrativaDTO;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public Map<Long, DetHorariosUnidAdmRespDTO> getLstDetHorariosUnidAdmRespDTO() {
		return lstDetHorariosUnidAdmRespDTO;
	}

	public void setLstDetHorariosUnidAdmRespDTO(Map<Long, DetHorariosUnidAdmRespDTO> lstDetHorariosUnidAdmRespDTO) {
		this.lstDetHorariosUnidAdmRespDTO = lstDetHorariosUnidAdmRespDTO;
	}

//	public CrcModificacionDTO getModificacionDTO() {
//		return modificacionDTO;
//	}
//
//	public void setModificacionDTO(CrcModificacionDTO modificacionDTO) {
//		this.modificacionDTO = modificacionDTO;
//	}

	
}
