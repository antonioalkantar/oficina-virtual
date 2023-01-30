package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_citas_dependencias database table.
 * 
 */
@Entity
@Table(name="det_citas_dependencias", schema = "retys_v2")
@NamedQueries({
/*	@NamedQuery(name="DetCitasDependencia.findByIdTramite"
			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.DetCitasDependenciaDTO"
					+ "("
					+ "  c.id "
					+ ", ts.id"
					+ ", ts.homoclave"
					+ ", ts.nombreOficial"
					+ ", c.requiereAgendarCitas"
					+ ", c.puedeAgendarEnLinea"
					+ ", c.urlAgendarCita"
					+ ", cft.id"
					+ ") "
					+ "FROM DetCitasDependencia c "
					+ "JOIN c.tramiteServicio ts "
					+ "JOIN c.crcFlujoTramite cft "
					+ "WHERE c.id = :idTramite "
				)

	, @NamedQuery(name="DetCitasDependencia.findByIdTramiteFlujo"
		, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.DetCitasDependenciaDTO"
			+ "("
			+ "  COALESCE(max(c.id), 0) "
			+ ") "
			+ "FROM DetCitasDependencia c "
			+ "JOIN c.tramiteServicio ts "
			+ "WHERE ts.id = :idTramite "
		)
	
	, @NamedQuery(name="DetCitasDependencia.totalRegistrosByIdTramite"
	, query="select count(cd) from DetCitasDependencia cd where cd.tramiteServicio.id = :idTramite")
*/
})

public class DetCitasDependencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Boolean puedeAgendarEnLinea;
	private Boolean requiereAgendarCitas;
	private String urlAgendarCita;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;

	public DetCitasDependencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

}