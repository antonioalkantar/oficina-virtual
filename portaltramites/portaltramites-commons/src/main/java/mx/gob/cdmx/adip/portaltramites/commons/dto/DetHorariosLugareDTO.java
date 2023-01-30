package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;


public class DetHorariosLugareDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775640027383263467L;
	
	
	private Long id;
	private Date horaFin1;
	private Date horaFin2;
	private Date horaInicio1;
	private Date horaInicio2;
	
	private CatDiaSemanaDTO catDiaSemana;
	private CatTipoHorarioDTO catTipoHorario;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetCanalAtencionDTO detCanalAtencion;
	
	
	public DetHorariosLugareDTO() {
		
		catTipoHorario = new CatTipoHorarioDTO();
	}
	
	

	public DetHorariosLugareDTO( Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,
			CatDiaSemanaDTO catDiaSemana, CatTipoHorarioDTO catTipoHorario, CrcFlujoTramiteDTO crcFlujoTramite,
			DetCanalAtencionDTO detCanalAtencion) {
		
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
		this.catDiaSemana = catDiaSemana;
		this.catTipoHorario = catTipoHorario;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
	}
	

	public DetHorariosLugareDTO(Long id, Date horaFin1, Date horaFin2, Date horaInicio1, Date horaInicio2,
			CatDiaSemanaDTO catDiaSemana, CatTipoHorarioDTO catTipoHorario, CrcFlujoTramiteDTO crcFlujoTramite,
			DetCanalAtencionDTO detCanalAtencion) {
		
		this.id = id;
		this.horaFin1 = horaFin1;
		this.horaFin2 = horaFin2;
		this.horaInicio1 = horaInicio1;
		this.horaInicio2 = horaInicio2;
		this.catDiaSemana = catDiaSemana;
		this.catTipoHorario = catTipoHorario;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
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


	public CatDiaSemanaDTO getCatDiaSemana() {
		return catDiaSemana;
	}


	public void setCatDiaSemana(CatDiaSemanaDTO catDiaSemana) {
		this.catDiaSemana = catDiaSemana;
	}


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


	public DetCanalAtencionDTO getDetCanalAtencion() {
		return detCanalAtencion;
	}


	public void setDetCanalAtencion(DetCanalAtencionDTO detCanalAtencion) {
		this.detCanalAtencion = detCanalAtencion;
	}
	
	

}
