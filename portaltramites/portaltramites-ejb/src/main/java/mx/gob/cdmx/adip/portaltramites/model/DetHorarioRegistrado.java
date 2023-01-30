package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the det_horario_registrado database table.
 * 
 */
@Entity
@Table(name="det_horario_registrado", schema = "retys_v2")
@NamedQuery(name="DetHorarioRegistrado.findAll", query="SELECT d FROM DetHorarioRegistrado d")
public class DetHorarioRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private CatAreaAc catAreaAc;
	private CatTipoHorario catTipoHorario; 
	private Boolean situacion;

	public DetHorarioRegistrado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="atiende_domingo")
	public Boolean getAtiendeDomingo() {
		return this.atiendeDomingo;
	}

	public void setAtiendeDomingo(Boolean atiendeDomingo) {
		this.atiendeDomingo = atiendeDomingo;
	}


	@Column(name="atiende_jueves")
	public Boolean getAtiendeJueves() {
		return this.atiendeJueves;
	}

	public void setAtiendeJueves(Boolean atiendeJueves) {
		this.atiendeJueves = atiendeJueves;
	}


	@Column(name="atiende_lunes")
	public Boolean getAtiendeLunes() {
		return this.atiendeLunes;
	}

	public void setAtiendeLunes(Boolean atiendeLunes) {
		this.atiendeLunes = atiendeLunes;
	}


	@Column(name="atiende_martes")
	public Boolean getAtiendeMartes() {
		return this.atiendeMartes;
	}

	public void setAtiendeMartes(Boolean atiendeMartes) {
		this.atiendeMartes = atiendeMartes;
	}


	@Column(name="atiende_miercoles")
	public Boolean getAtiendeMiercoles() {
		return this.atiendeMiercoles;
	}

	public void setAtiendeMiercoles(Boolean atiendeMiercoles) {
		this.atiendeMiercoles = atiendeMiercoles;
	}


	@Column(name="atiende_sabado")
	public Boolean getAtiendeSabado() {
		return this.atiendeSabado;
	}

	public void setAtiendeSabado(Boolean atiendeSabado) {
		this.atiendeSabado = atiendeSabado;
	}


	@Column(name="atiende_viernes")
	public Boolean getAtiendeViernes() {
		return this.atiendeViernes;
	}

	public void setAtiendeViernes(Boolean atiendeViernes) {
		this.atiendeViernes = atiendeViernes;
	}


	@Column(name="hora_fin")
	public Date getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}


	@Column(name="hora_inicio")
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Column(name="hora_fin2")
	public Date getHoraFin2() {
		return horaFin2;
	}


	public void setHoraFin2(Timestamp horaFin2) {
		this.horaFin2 = horaFin2;
	}

	@Column(name="hora_inicio2")
	public Date getHoraInicio2() {
		return horaInicio2;
	}


	public void setHoraInicio2(Timestamp horaInicio2) {
		this.horaInicio2 = horaInicio2;
	}


	//bi-directional many-to-one association to CatAreaAc
	@ManyToOne
	@JoinColumn(name="id_area_ac")
	public CatAreaAc getCatAreaAc() {
		return this.catAreaAc;
	}

	public void setCatAreaAc(CatAreaAc catAreaAc) {
		this.catAreaAc = catAreaAc;
	}

	@ManyToOne
	@JoinColumn(name="id_tipo_horario")
	public CatTipoHorario getCatTipoHorario() {
		return catTipoHorario;
	}


	public void setCatTipoHorario(CatTipoHorario catTipoHorario) {
		this.catTipoHorario = catTipoHorario;
	}


	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}