package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the det_horarios_lugares database table.
 * 
 */
@Entity
@Table(name="det_horarios_lugares", schema = "retys_v2")
@NamedQuery(name="DetHorariosLugare.findAll", query="SELECT d FROM DetHorariosLugare d")
public class DetHorariosLugare implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Timestamp horaFin1;
	private Timestamp horaFin2;
	private Timestamp horaInicio1;
	private Timestamp horaInicio2;
	private CatDiaSemana catDiaSemana;
	private CatTipoHorario catTipoHorario;
	private DetLugaresRegistrado detLugaresRegistrado;

	public DetHorariosLugare() {
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


	//bi-directional many-to-one association to DetLugaresRegistrado
	@ManyToOne
	@JoinColumn(name="id_lugar_registrado")
	public DetLugaresRegistrado getDetLugaresRegistrado() {
		return this.detLugaresRegistrado;
	}

	public void setDetLugaresRegistrado(DetLugaresRegistrado detLugaresRegistrado) {
		this.detLugaresRegistrado = detLugaresRegistrado;
	}

}