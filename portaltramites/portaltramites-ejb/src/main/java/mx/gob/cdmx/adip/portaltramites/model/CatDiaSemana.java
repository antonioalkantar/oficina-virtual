package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_dia_semana database table.
 * 
 */
@Entity
@Table(name="cat_dia_semana", schema = "retys_v2")
@NamedQuery(name="CatDiaSemana.findAll", query="SELECT c FROM CatDiaSemana c")
public class CatDiaSemana implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetHorariosLugare> detHorariosLugares;
/*	private List<DetHorariosMedioDependencia> detHorariosMedioDependencias;
	private List<DetHorariosTelefono> detHorariosTelefonos;
	private List<DetHorariosUnidAdmResp> detHorariosUnidAdmResps;
*/
	public CatDiaSemana() {
	}
	
	public CatDiaSemana(Long id) {
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


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to DetHorariosLugare
	@OneToMany(mappedBy="catDiaSemana")
	public List<DetHorariosLugare> getDetHorariosLugares() {
		return this.detHorariosLugares;
	}

	public void setDetHorariosLugares(List<DetHorariosLugare> detHorariosLugares) {
		this.detHorariosLugares = detHorariosLugares;
	}

	public DetHorariosLugare addDetHorariosLugare(DetHorariosLugare detHorariosLugare) {
		getDetHorariosLugares().add(detHorariosLugare);
		detHorariosLugare.setCatDiaSemana(this);

		return detHorariosLugare;
	}

	public DetHorariosLugare removeDetHorariosLugare(DetHorariosLugare detHorariosLugare) {
		getDetHorariosLugares().remove(detHorariosLugare);
		detHorariosLugare.setCatDiaSemana(null);

		return detHorariosLugare;
	}

/*
	//bi-directional many-to-one association to DetHorariosMedioDependencia
	@OneToMany(mappedBy="catDiaSemana")
	public List<DetHorariosMedioDependencia> getDetHorariosMedioDependencias() {
		return this.detHorariosMedioDependencias;
	}

	public void setDetHorariosMedioDependencias(List<DetHorariosMedioDependencia> detHorariosMedioDependencias) {
		this.detHorariosMedioDependencias = detHorariosMedioDependencias;
	}

	public DetHorariosMedioDependencia addDetHorariosMedioDependencia(DetHorariosMedioDependencia detHorariosMedioDependencia) {
		getDetHorariosMedioDependencias().add(detHorariosMedioDependencia);
		detHorariosMedioDependencia.setCatDiaSemana(this);

		return detHorariosMedioDependencia;
	}

	public DetHorariosMedioDependencia removeDetHorariosMedioDependencia(DetHorariosMedioDependencia detHorariosMedioDependencia) {
		getDetHorariosMedioDependencias().remove(detHorariosMedioDependencia);
		detHorariosMedioDependencia.setCatDiaSemana(null);

		return detHorariosMedioDependencia;
	}


	//bi-directional many-to-one association to DetHorariosTelefono
	@OneToMany(mappedBy="catDiaSemana")
	public List<DetHorariosTelefono> getDetHorariosTelefonos() {
		return this.detHorariosTelefonos;
	}

	public void setDetHorariosTelefonos(List<DetHorariosTelefono> detHorariosTelefonos) {
		this.detHorariosTelefonos = detHorariosTelefonos;
	}

	public DetHorariosTelefono addDetHorariosTelefono(DetHorariosTelefono detHorariosTelefono) {
		getDetHorariosTelefonos().add(detHorariosTelefono);
		detHorariosTelefono.setCatDiaSemana(this);

		return detHorariosTelefono;
	}

	public DetHorariosTelefono removeDetHorariosTelefono(DetHorariosTelefono detHorariosTelefono) {
		getDetHorariosTelefonos().remove(detHorariosTelefono);
		detHorariosTelefono.setCatDiaSemana(null);

		return detHorariosTelefono;
	}


	//bi-directional many-to-one association to DetHorariosUnidAdmResp
	@OneToMany(mappedBy="catDiaSemana")
	public List<DetHorariosUnidAdmResp> getDetHorariosUnidAdmResps() {
		return this.detHorariosUnidAdmResps;
	}

	public void setDetHorariosUnidAdmResps(List<DetHorariosUnidAdmResp> detHorariosUnidAdmResps) {
		this.detHorariosUnidAdmResps = detHorariosUnidAdmResps;
	}

	public DetHorariosUnidAdmResp addDetHorariosUnidAdmResp(DetHorariosUnidAdmResp detHorariosUnidAdmResp) {
		getDetHorariosUnidAdmResps().add(detHorariosUnidAdmResp);
		detHorariosUnidAdmResp.setCatDiaSemana(this);

		return detHorariosUnidAdmResp;
	}

	public DetHorariosUnidAdmResp removeDetHorariosUnidAdmResp(DetHorariosUnidAdmResp detHorariosUnidAdmResp) {
		getDetHorariosUnidAdmResps().remove(detHorariosUnidAdmResp);
		detHorariosUnidAdmResp.setCatDiaSemana(null);

		return detHorariosUnidAdmResp;
	}
*/
}