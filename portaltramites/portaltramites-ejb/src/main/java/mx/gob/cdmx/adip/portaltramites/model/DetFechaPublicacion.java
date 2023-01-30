package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the det_fecha_publicacion database table.
 * 
 */
@Entity
@Table(name="det_fecha_publicacion", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetFechaPublicacion.findAll", query="SELECT d FROM DetFechaPublicacion d"),
	@NamedQuery(name="DetFechaPublicacion.findByIdTramite"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetFechaPublicacionDTO(fp.id"
			+ ", fp.fecha"
			+ ", fp.vigente"
			+ ", ts.id"
			+ ", ft.id) "
			+ "FROM DetFechaPublicacion fp "
			+ "join fp.tramiteServicio ts "
			+ "join fp.crcFlujoTramite ft "
			+ "where ts.id = :idTramite "
			+ "and ft.id = :idCrcFlujo "
			+ "and fp.vigente = true")
		
	,@NamedQuery(name="DetFechaPublicacion.findByIdTram"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetFechaPublicacionDTO"
			+ "("
			+ "fp.id"
			+ ", fp.fecha"
			+ ", fp.vigente"
			+ ", ts.id"
			+ ", ft.id) "
			+ "FROM DetFechaPublicacion fp "
			+ "join fp.tramiteServicio ts "
			+ "join fp.crcFlujoTramite ft "
			+ "where ts.id = :idTramite "
			+ "and fp.vigente = true")
})
public class DetFechaPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha;
	private Boolean vigente;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;

	public DetFechaPublicacion() {
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Boolean getVigente() {
		return this.vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

}