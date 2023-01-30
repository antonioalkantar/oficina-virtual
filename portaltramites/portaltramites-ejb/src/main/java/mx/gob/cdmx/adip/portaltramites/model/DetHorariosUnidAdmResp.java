package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the det_horarios_unid_adm_resp database table.
 * 
 */
@Entity
@Table(name="det_horarios_unid_adm_resp", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetHorariosUnidAdmResp.findAll", query="SELECT d FROM DetHorariosUnidAdmResp d")
	,@NamedQuery(name="DetHorariosUnidAdmResp.findByIdTramite"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetHorariosUnidAdmRespDTO"
			+ "("
			+ "  c.id "
			+ ", c.horaFin1"
			+ ", c.horaFin2"
			+ ", c.horaInicio1"
			+ ", c.horaInicio2"
			+ ", cd.id"
			+ ", cth.id"
			+ ", cth.descripcion"
			+ ", cth.situacion"
			+ ", cft.id"
			+ ", duar.id"
			+ ") "
			+ "FROM DetHorariosUnidAdmResp c "
			+ "JOIN c.detUnidadesAdmResp duar "
			+ "JOIN c.catDiaSemana cd "
			+ "JOIN c.catTipoHorario cth "
			+ "JOIN c.crcFlujoTramite cft "
			+ "WHERE duar.id = :idTramite "
		),
//	@NamedQuery(name="DetHorariosUnidAdmResp.findByIdTramiteV2"
//	, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.DetHorariosUnidAdmRespDTO"
//			+ "("
//			+ "  c.id "
//			+ ", c.horaFin1"
//			+ ", c.horaFin2"
//			+ ", c.horaInicio1"
//			+ ", c.horaInicio2"
//			+ ", cd.id"
//			+ ", cd.descripcion"
//			+ ", cth.id"
//			+ ", cth.descripcion"
//			+ ", cth.situacion"
//			+ ", cft.id"
//			+ ", duar.id"
//			+ ") "
//			+ "FROM DetHorariosUnidAdmResp c "
//			+ "JOIN c.detUnidadesAdmResp duar "
//			+ "JOIN c.catDiaSemana cd "
//			+ "JOIN c.catTipoHorario cth "
//			+ "JOIN c.crcFlujoTramite cft "
//			+ "WHERE duar.id = :idTramite and c.situacion=:situacion"
//		),
//	@NamedQuery(name = "DetHorariosUnidAdmResp.actualizaHorario",
//	query = "UPDATE DetHorariosUnidAdmResp drp SET drp.situacion=:estatus "			
//		+ "WHERE drp.crcFlujoTramite.id=:idFlujo AND drp.detUnidadesAdmResp.id=:idResp"),
//	
//	@NamedQuery(name="DetHorariosUnidAdmResp.borrar",
//		query="DELETE FROM DetHorariosUnidAdmResp drp "
//			+ " WHERE drp.crcFlujoTramite.id=:idFlujo AND drp.detUnidadesAdmResp.id=:idResp"),
//		

	})
public class DetHorariosUnidAdmResp implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Timestamp horaFin1;
	private Timestamp horaFin2;
	private Timestamp horaInicio1;
	private Timestamp horaInicio2;
	private Boolean situacion;
	private CatDiaSemana catDiaSemana;
	private CatTipoHorario catTipoHorario;
	private CrcFlujoTramite crcFlujoTramite;
	private DetUnidadesAdmResp detUnidadesAdmResp;

	public DetHorariosUnidAdmResp() {
	}

	public DetHorariosUnidAdmResp(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="hora_fin_1")
	public Date getHoraFin1() {
		return this.horaFin1;
	}

	public void setHoraFin1(Timestamp horaFin1) {
		this.horaFin1 = horaFin1;
	}


	@Column(name="hora_fin_2")
	public Date getHoraFin2() {
		return this.horaFin2;
	}

	public void setHoraFin2(Timestamp horaFin2) {
		this.horaFin2 = horaFin2;
	}


	@Column(name="hora_inicio_1")
	public Date getHoraInicio1() {
		return this.horaInicio1;
	}

	public void setHoraInicio1(Timestamp horaInicio1) {
		this.horaInicio1 = horaInicio1;
	}


	@Column(name="hora_inicio_2")
	public Date getHoraInicio2() {
		return this.horaInicio2;
	}

	public void setHoraInicio2(Timestamp horaInicio2) {
		this.horaInicio2 = horaInicio2;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CatDiaSemana
	@ManyToOne
	@JoinColumn(name="id_dia_semana")
	public CatDiaSemana getCatDiaSemana() {
		return this.catDiaSemana;
	}

	public void setCatDiaSemana(CatDiaSemana catDiaSemana) {
		this.catDiaSemana = catDiaSemana;
	}


	//bi-directional many-to-one association to CatTipoHorario
	@ManyToOne
	@JoinColumn(name="id_tipo_horario")
	public CatTipoHorario getCatTipoHorario() {
		return this.catTipoHorario;
	}

	public void setCatTipoHorario(CatTipoHorario catTipoHorario) {
		this.catTipoHorario = catTipoHorario;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramitre")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to DetUnidadesAdmResp
	@ManyToOne
	@JoinColumn(name="id_responsable")
	public DetUnidadesAdmResp getDetUnidadesAdmResp() {
		return this.detUnidadesAdmResp;
	}

	public void setDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
		this.detUnidadesAdmResp = detUnidadesAdmResp;
	}

}