package mx.gob.cdmx.adip.portaltramites.commons.dto;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.gob.cdmx.adip.portaltramites.dto.CatDependenciaDTO;

public class CatAreaAcDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905747436822832399L;
	
	private Long id;
	private String calle;
	private Boolean esKiosco;
	private Integer idDependencia;
	private String latitud;
	private String longitud;
	private String nombreAac;
	private String numExterior;
	private String numInterior;
	private String direccion;
	private Boolean situacion;
	private CatAlcaldiaDTO catAlcaldia;
	private CatAsentamientosDTO catAsentamiento;
	private CatCodigosPostalesDTO catCodigosPostale;
	private CatEstatusAreaAcDTO catEstatusAreaAc;
	private List<DetHorarioRegistradoDTO> detHorarioRegistrados;
	private List<DetTelefonoRegistradoDTO> detTelefonoRegistrados;
	private CatTipoVialidadDTO catTipoVialidad;
	private CatDependenciaDTO catDependenciaDTO;
	
	public CatAreaAcDTO() {
		catAlcaldia = new CatAlcaldiaDTO();
		catAsentamiento = new CatAsentamientosDTO();
		catCodigosPostale = new CatCodigosPostalesDTO();
		catEstatusAreaAc= new CatEstatusAreaAcDTO();
	}

	public CatAreaAcDTO(Long id, String nombreAac) {
		this.id = id;
		this.nombreAac = nombreAac;
	}

	public CatAreaAcDTO(Long id, String calle, Boolean esKiosco, String latitud, String longitud,
			String nombreAac, String numExterior, String numInterior, Boolean situacion, Integer idAlcaldia, String municipio,  
			Integer idCodigoPostal,  String codigoPostal, Integer idAsentamiento, String asentamiento,Long idVialidad, String nombVialidad) {
		this.id = id;
		this.calle = calle;
		this.esKiosco = esKiosco;
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombreAac = nombreAac;
		this.numExterior = numExterior;
		this.numInterior = numInterior;
		this.situacion = situacion;
		this.catAlcaldia = new CatAlcaldiaDTO(idAlcaldia, null, null,municipio);
		this.catAsentamiento = new CatAsentamientosDTO(idAsentamiento, asentamiento);
		this.catCodigosPostale = new CatCodigosPostalesDTO(idCodigoPostal, codigoPostal);
		this.catTipoVialidad = new CatTipoVialidadDTO(idVialidad,nombVialidad);
	}
	
	public CatAreaAcDTO(Long id, Long idHorario ,Boolean atiendeDomingo,Boolean atiendeJueves ,Boolean atiendeLunes, Boolean atiendeMartes, Boolean atiendeMiercoles, Boolean atiendeSabado, Boolean atiendeViernes,
			Date horaFin, Date horaInicio) {
		this.id = id;
		
		DetHorarioRegistradoDTO dto = new DetHorarioRegistradoDTO(idHorario, atiendeDomingo, atiendeJueves, atiendeLunes, atiendeMartes, atiendeMiercoles, atiendeSabado, atiendeViernes,new Timestamp( horaFin.getTime()),new Timestamp( horaInicio.getTime()), new CatAreaAcDTO(id,null));
		
		 List<DetHorarioRegistradoDTO> lstdto = new ArrayList<DetHorarioRegistradoDTO>();
		 lstdto.add(dto);
		
		this.detHorarioRegistrados = lstdto;

	}
	
	public CatAreaAcDTO(Long id, Long idHorario, Boolean atiendeDomingo, Boolean atiendeJueves, Boolean atiendeLunes, 
			Boolean atiendeMartes, Boolean atiendeMiercoles, Boolean atiendeSabado, Boolean atiendeViernes,
			Date horaFin, Date horaInicio, Long idTipoHorario, String descHorario) {
		
		this.id = id;
		
		DetHorarioRegistradoDTO dto = new DetHorarioRegistradoDTO(idHorario, atiendeDomingo, atiendeJueves, atiendeLunes, atiendeMartes, atiendeMiercoles, atiendeSabado, atiendeViernes,new Timestamp( horaFin.getTime()),new Timestamp( horaInicio.getTime()), new CatAreaAcDTO(id,null), new CatTipoHorarioDTO(idTipoHorario, descHorario));
		
		 List<DetHorarioRegistradoDTO> lstdto = new ArrayList<DetHorarioRegistradoDTO>();
		 lstdto.add(dto);
		
		this.detHorarioRegistrados = lstdto;

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
	public Boolean getEsKiosco() {
		return esKiosco;
	}
	public void setEsKiosco(Boolean esKiosco) {
		this.esKiosco = esKiosco;
	}

	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getNombreAac() {
		return nombreAac;
	}
	public void setNombreAac(String nombreAac) {
		this.nombreAac = nombreAac;
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
	public Boolean getSituacion() {
		return situacion;
	}
	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	public CatAlcaldiaDTO getCatAlcaldia() {
		return catAlcaldia;
	}
	public void setCatAlcaldia(CatAlcaldiaDTO catAlcaldia) {
		this.catAlcaldia = catAlcaldia;
	}
	public CatAsentamientosDTO getCatAsentamiento() {
		return catAsentamiento;
	}
	public void setCatAsentamiento(CatAsentamientosDTO catAsentamiento) {
		this.catAsentamiento = catAsentamiento;
	}
	public CatCodigosPostalesDTO getCatCodigosPostale() {
		return catCodigosPostale;
	}
	public void setCatCodigosPostale(CatCodigosPostalesDTO catCodigosPostale) {
		this.catCodigosPostale = catCodigosPostale;
	}
	public CatEstatusAreaAcDTO getCatEstatusAreaAc() {
		return catEstatusAreaAc;
	}
	public void setCatEstatusAreaAc(CatEstatusAreaAcDTO catEstatusAreaAc) {
		this.catEstatusAreaAc = catEstatusAreaAc;
	}
	public List<DetHorarioRegistradoDTO> getDetHorarioRegistrados() {
		return detHorarioRegistrados;
	}

	public void setDetHorarioRegistrados(List<DetHorarioRegistradoDTO> detHorarioRegistrados) {
		this.detHorarioRegistrados = detHorarioRegistrados;
	}

	public List<DetTelefonoRegistradoDTO> getDetTelefonoRegistrados() {
		return detTelefonoRegistrados;
	}

	public void setDetTelefonoRegistrados(List<DetTelefonoRegistradoDTO> detTelefonoRegistrados) {
		this.detTelefonoRegistrados = detTelefonoRegistrados;
	}

	public CatTipoVialidadDTO getCatTipoVialidad() {
		return catTipoVialidad;
	}

	public void setCatTipoVialidad(CatTipoVialidadDTO catTipoVialidad) {
		this.catTipoVialidad = catTipoVialidad;
	}

	public Integer getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
