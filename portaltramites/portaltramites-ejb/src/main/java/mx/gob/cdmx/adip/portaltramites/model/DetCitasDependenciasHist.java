package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_citas_dependencias_hist database table.
 * 
 */
@Entity
@Table(name="det_citas_dependencias_hist", schema = "retys_v2")
@NamedQuery(name="DetCitasDependenciasHist.findAll", query="SELECT d FROM DetCitasDependenciasHist d")
public class DetCitasDependenciasHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idFlujoTramite;
	private Boolean puedeAgendarEnLinea;
	private Boolean requiereAgendarCitas;
	private String urlAgendarCita;
	private TramiteServicio tramiteServicio;

	public DetCitasDependenciasHist() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="id_flujo_tramite")
	public Long getIdFlujoTramite() {
		return this.idFlujoTramite;
	}

	public void setIdFlujoTramite(Long idFlujoTramite) {
		this.idFlujoTramite = idFlujoTramite;
	}


	@Column(name="puede_agendar_en_linea")
	public Boolean getPuedeAgendarEnLinea() {
		return this.puedeAgendarEnLinea;
	}

	public void setPuedeAgendarEnLinea(Boolean puedeAgendarEnLinea) {
		this.puedeAgendarEnLinea = puedeAgendarEnLinea;
	}


	@Column(name="requiere_agendar_citas")
	public Boolean getRequiereAgendarCitas() {
		return this.requiereAgendarCitas;
	}

	public void setRequiereAgendarCitas(Boolean requiereAgendarCitas) {
		this.requiereAgendarCitas = requiereAgendarCitas;
	}


	@Column(name="url_agendar_cita")
	public String getUrlAgendarCita() {
		return this.urlAgendarCita;
	}

	public void setUrlAgendarCita(String urlAgendarCita) {
		this.urlAgendarCita = urlAgendarCita;
	}


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}


	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

}