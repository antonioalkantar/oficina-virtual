package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;



public class DetHorarioRegistradoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905747436822832399L;
	
	private Long id;
	private Boolean atiendeDomingo;
	private Boolean atiendeJueves;
	private Boolean atiendeLunes;
	private Boolean atiendeMartes;
	private Boolean atiendeMiercoles;
	private Boolean atiendeSabado;
	private Boolean atiendeViernes;
	private Timestamp horaFin;
	private Timestamp horaInicio;
	private Timestamp horaFin2;
	private Timestamp horaInicio2;
	private CatAreaAcDTO catAreaAc;
	private CatTipoHorarioDTO catTipoHorario;
	private Boolean situacion;
	private String horarioAtencion;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	
	public DetHorarioRegistradoDTO() {}
	
	
	public DetHorarioRegistradoDTO( Boolean atiendeDomingo, Boolean atiendeJueves, Boolean atiendeLunes,
			Boolean atiendeMartes, Boolean atiendeMiercoles, Boolean atiendeSabado, Boolean atiendeViernes,
			Timestamp horaFin, Timestamp horaInicio, CatAreaAcDTO catAreaAc) {
		
		
		this.atiendeDomingo = atiendeDomingo;
		this.atiendeJueves = atiendeJueves;
		this.atiendeLunes = atiendeLunes;
		this.atiendeMartes = atiendeMartes;
		this.atiendeMiercoles = atiendeMiercoles;
		this.atiendeSabado = atiendeSabado;
		this.atiendeViernes = atiendeViernes;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
		this.catAreaAc = catAreaAc;
	}
	
	
	public DetHorarioRegistradoDTO(Long id, Boolean atiendeDomingo, Boolean atiendeJueves, Boolean atiendeLunes,
			Boolean atiendeMartes, Boolean atiendeMiercoles, Boolean atiendeSabado, Boolean atiendeViernes,
			Timestamp horaFin, Timestamp horaInicio, CatAreaAcDTO catAreaAc) {
		
		this.id = id;
		this.atiendeDomingo = atiendeDomingo;
		this.atiendeJueves = atiendeJueves;
		this.atiendeLunes = atiendeLunes;
		this.atiendeMartes = atiendeMartes;
		this.atiendeMiercoles = atiendeMiercoles;
		this.atiendeSabado = atiendeSabado;
		this.atiendeViernes = atiendeViernes;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
		this.catAreaAc = catAreaAc;
	}
	
	public DetHorarioRegistradoDTO(Long id, Boolean atiendeDomingo, Boolean atiendeJueves, Boolean atiendeLunes,
			Boolean atiendeMartes, Boolean atiendeMiercoles, Boolean atiendeSabado, Boolean atiendeViernes,
			Timestamp horaFin, Timestamp horaInicio, CatAreaAcDTO catAreaAc, CatTipoHorarioDTO catTipoHorario) {
		
		this.id = id;
		this.atiendeDomingo = atiendeDomingo;
		this.atiendeJueves = atiendeJueves;
		this.atiendeLunes = atiendeLunes;
		this.atiendeMartes = atiendeMartes;
		this.atiendeMiercoles = atiendeMiercoles;
		this.atiendeSabado = atiendeSabado;
		this.atiendeViernes = atiendeViernes;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
		this.catAreaAc = catAreaAc;
		this.catTipoHorario = catTipoHorario;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getAtiendeDomingo() {
		return atiendeDomingo;
	}
	public void setAtiendeDomingo(Boolean atiendeDomingo) {
		this.atiendeDomingo = atiendeDomingo;
	}
	public Boolean getAtiendeJueves() {
		return atiendeJueves;
	}
	public void setAtiendeJueves(Boolean atiendeJueves) {
		this.atiendeJueves = atiendeJueves;
	}
	public Boolean getAtiendeLunes() {
		return atiendeLunes;
	}
	public void setAtiendeLunes(Boolean atiendeLunes) {
		this.atiendeLunes = atiendeLunes;
	}
	public Boolean getAtiendeMartes() {
		return atiendeMartes;
	}
	public void setAtiendeMartes(Boolean atiendeMartes) {
		this.atiendeMartes = atiendeMartes;
	}
	public Boolean getAtiendeMiercoles() {
		return atiendeMiercoles;
	}
	public void setAtiendeMiercoles(Boolean atiendeMiercoles) {
		this.atiendeMiercoles = atiendeMiercoles;
	}
	public Boolean getAtiendeSabado() {
		return atiendeSabado;
	}
	public void setAtiendeSabado(Boolean atiendeSabado) {
		this.atiendeSabado = atiendeSabado;
	}
	public Boolean getAtiendeViernes() {
		return atiendeViernes;
	}
	public void setAtiendeViernes(Boolean atiendeViernes) {
		this.atiendeViernes = atiendeViernes;
	}
	public Timestamp getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}
	public Timestamp getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}
	public CatAreaAcDTO getCatAreaAc() {
		return catAreaAc;
	}
	public void setCatAreaAc(CatAreaAcDTO catAreaAc) {
		this.catAreaAc = catAreaAc;
	}


	public CatTipoHorarioDTO getCatTipoHorario() {
		return catTipoHorario;
	}


	public void setCatTipoHorario(CatTipoHorarioDTO catTipoHorario) {
		this.catTipoHorario = catTipoHorario;
	}


	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	public Timestamp getHoraFin2() {
		return horaFin2;
	}


	public void setHoraFin2(Timestamp horaFin2) {
		this.horaFin2 = horaFin2;
	}


	public Timestamp getHoraInicio2() {
		return horaInicio2;
	}


	public void setHoraInicio2(Timestamp horaInicio2) {
		this.horaInicio2 = horaInicio2;
	}


	public String getHorarioAtencion() {
		return horarioAtencion;
	}


	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}
	
	
	public String horaInicioSt() {
		return sdf.format(horaInicio.getTime());
	}
	
	public String horaFinSt() {
		return sdf.format(horaFin.getTime());
	}

}
