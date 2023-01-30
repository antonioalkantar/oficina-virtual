package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;




public class DetHorariosTelefonosDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481532742891048851L;	
	
	private Long id;
	private Date horaFin1;
	private Date horaFin2;
	private Date horaInicio1;
	private Date horaInicio2;
//	private CatDiaSemanaDTO catDiaSemana;
	private CatTipoHorarioDTO catTipoHorario;
	private CrcFlujoTramiteDTO crcFlujoTramite;
//	private DetTelefonosRegistradosDTO detTelefonosRegistrado;
	private Boolean situacion;
	
	
	
	public DetHorariosTelefonosDTO() {	
		
		catTipoHorario = new CatTipoHorarioDTO();
	}
	
	public DetHorariosTelefonosDTO(Long id) {	
		
		this.id = id;
	}
	
//	(d.id,d.horaFin1,d.horaFin2,horaInicio1,d.horaInicio2,semana.id,semana.descripcion,semana.situacion,horario.id,horario.descripcion)
	
	public DetHorariosTelefonosDTO(Long id, Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,
//			CatDiaSemanaDTO catDiaSemana, 
			CatTipoHorarioDTO catTipoHorario, CrcFlujoTramiteDTO crcFlujoTramite
//			,DetTelefonosRegistradosDTO detTelefonosRegistrado
			) {		
		this.id = id;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
//		this.catDiaSemana = catDiaSemana;
		this.catTipoHorario = catTipoHorario;
		this.crcFlujoTramite = crcFlujoTramite;
//		this.detTelefonosRegistrado = detTelefonosRegistrado;
	}
	
	public DetHorariosTelefonosDTO(Long id, Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,Long idSemana, String descripSemana, Boolean situacionSemana, Long idHorario, String descripcionHorario,Long idFlujo, Long idTEL) {		
		this.id = id;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
//		this.catDiaSemana = new CatDiaSemanaDTO(idSemana,descripSemana);
		this.catTipoHorario = new CatTipoHorarioDTO(idHorario,descripcionHorario);
		this.crcFlujoTramite  = new CrcFlujoTramiteDTO(idFlujo);
//		this.detTelefonosRegistrado = new DetTelefonosRegistradosDTO(idTEL);
	}
	
	public DetHorariosTelefonosDTO(Long id, Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,Long idSemana, String descripSemana, Boolean situacionSemana, Long idHorario, String descripcionHorario,Long idFlujo, Long idTEL,Boolean situacion) {		
		this.id = id;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
//		this.catDiaSemana = new CatDiaSemanaDTO(idSemana,descripSemana);
		this.catTipoHorario = new CatTipoHorarioDTO(idHorario,descripcionHorario);
		this.crcFlujoTramite  = new CrcFlujoTramiteDTO(idFlujo);
//		this.detTelefonosRegistrado = new DetTelefonosRegistradosDTO(idTEL);
		this.situacion = situacion;
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
//	public CatDiaSemanaDTO getCatDiaSemana() {
//		return catDiaSemana;
//	}
//	public void setCatDiaSemana(CatDiaSemanaDTO catDiaSemana) {
//		this.catDiaSemana = catDiaSemana;
//	}
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
//	public DetTelefonosRegistradosDTO getDetTelefonosRegistrado() {
//		return detTelefonosRegistrado;
//	}
//	public void setDetTelefonosRegistrado(DetTelefonosRegistradosDTO detTelefonosRegistrado) {
//		this.detTelefonosRegistrado = detTelefonosRegistrado;
//	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
	
	

}
