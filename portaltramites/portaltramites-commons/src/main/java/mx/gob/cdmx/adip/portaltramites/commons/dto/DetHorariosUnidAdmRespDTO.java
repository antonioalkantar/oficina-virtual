package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class DetHorariosUnidAdmRespDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7409330817660577236L;
	private Long id;
	private Date horaFin1;
	private Date horaFin2;
	private Date horaInicio1;
	private Date horaInicio2;

	private Boolean atiendeDomingo;
	private Boolean atiendeJueves;
	private Boolean atiendeLunes;
	private Boolean atiendeMartes;
	private Boolean atiendeMiercoles;
	private Boolean atiendeSabado;
	private Boolean atiendeViernes;

//	private CatDiaSemanaDTO catDiaSemana;
	private CatTipoHorarioDTO catTipoHorario;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetUnidadesAdmRespDTO detUnidadesAdmRespDTO;
	
	
	public DetHorariosUnidAdmRespDTO() {
		atiendeDomingo = false;
		atiendeJueves = false;
		atiendeLunes = false;
		atiendeMartes = false;
		atiendeMiercoles = false;
		atiendeSabado = false;
		atiendeViernes = false;
		//horaInicio2 = new Date();
		//horaFin2 = new Date();
		catTipoHorario = new CatTipoHorarioDTO();
//		catDiaSemana = new CatDiaSemanaDTO();
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		detUnidadesAdmRespDTO = new DetUnidadesAdmRespDTO();
	}

	public DetHorariosUnidAdmRespDTO(Long id, Boolean atiendeLunes, Boolean atiendeMartes, Boolean atiendeMiercoles
			, Boolean atiendeJueves, Boolean atiendeViernes, Boolean atiendeSabado, Boolean atiendeDomingo, Date horaFin1 
			, Date horaFin2, Date horaInicio1, Date horaInicio2
//			, CatDiaSemanaDTO catDiaSemana
			, CatTipoHorarioDTO catTipoHorario, CrcFlujoTramiteDTO crcFlujoTramite, DetUnidadesAdmRespDTO detUnidadesAdmRespDTO) {		
		this.id = id;
		this.atiendeLunes = atiendeLunes;
		this.atiendeMartes = atiendeMartes;
		this.atiendeMiercoles = atiendeMiercoles;
		this.atiendeJueves = atiendeJueves;
		this.atiendeViernes = atiendeViernes;
		this.atiendeSabado = atiendeSabado;
		this.atiendeDomingo =  atiendeDomingo;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
//		this.catDiaSemana = catDiaSemana;
		this.catTipoHorario = catTipoHorario;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detUnidadesAdmRespDTO = detUnidadesAdmRespDTO;
	}

	public DetHorariosUnidAdmRespDTO(Long id, Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,
			Long idDiaSemana, Long idTipoHorario, String descripcionTipoHorario, Boolean situacionTipoHorario, Long idFlujoTramite,
			Long idDtUnidadesAdmRespDTO) {
		
		this.id = id;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
//		this.catDiaSemana = new CatDiaSemanaDTO(idDiaSemana);
		this.catTipoHorario = new CatTipoHorarioDTO(idTipoHorario, descripcionTipoHorario, situacionTipoHorario);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detUnidadesAdmRespDTO = new DetUnidadesAdmRespDTO(idDtUnidadesAdmRespDTO);
	}
	
	public DetHorariosUnidAdmRespDTO(Long id, Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,
			Long idDiaSemana,String descripcionDiaSemana, Long idTipoHorario, String descripcionTipoHorario, Boolean situacionTipoHorario, Long idFlujoTramite,
			Long idDtUnidadesAdmRespDTO) {
		
		this.id = id;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
//		this.catDiaSemana = new CatDiaSemanaDTO(idDiaSemana,descripcionDiaSemana);
		this.catTipoHorario = new CatTipoHorarioDTO(idTipoHorario, descripcionTipoHorario, situacionTipoHorario);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detUnidadesAdmRespDTO = new DetUnidadesAdmRespDTO(idDtUnidadesAdmRespDTO);
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getHoraFin1() {
		return horaFin1;
	}


	public void setHoraFin1(Date horaFin1) {
		this.horaFin1 = horaFin1;
	}


	public Date getHoraFin2() {
		return horaFin2;
	}


	public void setHoraFin2(Date horaFin2) {
		this.horaFin2 = horaFin2;
	}


	public Date getHoraInicio1() {
		return horaInicio1;
	}


	public void setHoraInicio1(Date horaInicio1) {
		this.horaInicio1 = horaInicio1;
	}


	public Date getHoraInicio2() {
		return horaInicio2;
	}


	public void setHoraInicio2(Date horaInicio2) {
		this.horaInicio2 = horaInicio2;
	}
//
//
//	public CatDiaSemanaDTO getCatDiaSemana() {
//		return catDiaSemana;
//	}
//
//
//	public void setCatDiaSemana(CatDiaSemanaDTO catDiaSemana) {
//		this.catDiaSemana = catDiaSemana;
//	}
//

	public CatTipoHorarioDTO getCatTipoHorario() {
		return catTipoHorario;
	}


	public void setCatTipoHorario(CatTipoHorarioDTO catTipoHorario) {
		this.catTipoHorario = catTipoHorario;
	}


	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}


	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}



	public DetUnidadesAdmRespDTO getDetUnidadesAdmRespDTO() {
		return detUnidadesAdmRespDTO;
	}



	public void setDetUnidadesAdmRespDTO(DetUnidadesAdmRespDTO detUnidadesAdmRespDTO) {
		this.detUnidadesAdmRespDTO = detUnidadesAdmRespDTO;
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

	
}
