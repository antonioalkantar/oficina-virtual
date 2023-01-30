package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the det_horarios_telefonos database table.
 * 
 */
@Entity
@Table(name="det_horarios_telefonos", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetHorariosTelefono.findAll", query="SELECT d FROM DetHorariosTelefono d"),
//	@NamedQuery(name="DetHorariosTelefono.buscarPorIdTelefono", query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetHorariosTelefonosDTO(d.id,d.horaFin1,d.horaFin2,d.horaInicio1,d.horaInicio2,semana.id,semana.descripcion,semana.situacion,horario.id,horario.descripcion, flujo.id,tel.id,d.situacion) "
//			+ " FROM DetHorariosTelefono d"
//			+ " INNER JOIN d.detTelefonosRegistrado tels"
//			+ " INNER JOIN d.catDiaSemana semana"
//			+ " INNER JOIN d.catTipoHorario horario"
//			+ " INNER JOIN d.crcFlujoTramite flujo"
//			+ " INNER JOIN d.detTelefonosRegistrado tel"
//			+ " WHERE tels.id=:idTel AND d.situacion=:situacion")
})

public class DetHorariosTelefono implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Timestamp horaFin1;
	private Timestamp horaFin2;
	private Timestamp horaInicio1;
	private Timestamp horaInicio2;
	private CatDiaSemana catDiaSemana;
	private CatTipoHorario catTipoHorario; 
	private CrcFlujoTramite crcFlujoTramite;
	private DetTelefonosRegistrado detTelefonosRegistrado;
	private Boolean situacion;

	public DetHorariosTelefono() {
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
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to DetTelefonosRegistrado
	@ManyToOne
	@JoinColumn(name="id_telefono_registrado")
	public DetTelefonosRegistrado getDetTelefonosRegistrado() {
		return this.detTelefonosRegistrado;
	}

	public void setDetTelefonosRegistrado(DetTelefonosRegistrado detTelefonosRegistrado) {
		this.detTelefonosRegistrado = detTelefonosRegistrado;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}
	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}