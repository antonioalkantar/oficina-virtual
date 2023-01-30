package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_adjuntos_tramite_hist database table.
 * 
 */
@Entity
@Table(name="det_archivos_adjuntos_tramite_hist", schema = "retys_v2")
@NamedQuery(name="DetArchivosAdjuntosTramiteHist.findAll", query="SELECT d FROM DetArchivosAdjuntosTramiteHist d")
public class DetArchivosAdjuntosTramiteHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramite crcFlujoTramite;
	private DetFormato detFormato;
	private Boolean situacion;
	private DetArchivosAdjuntosTramite detArchivosAdjuntosTramite;

	public DetArchivosAdjuntosTramiteHist() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="nombre_archivo")
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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

	//bi-directional many-to-one association to DetFormato
	@ManyToOne
	@JoinColumn(name="id_formato")
	public DetFormato getDetFormato() {
		return this.detFormato;
	}

	public void setDetFormato(DetFormato detFormato) {
		this.detFormato = detFormato;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetArchivosAdjuntosTramite getDetArchivosAdjuntosTramite() {
		return detArchivosAdjuntosTramite;
	}

	public void setDetArchivosAdjuntosTramite(DetArchivosAdjuntosTramite detArchivosAdjuntosTramite) {
		this.detArchivosAdjuntosTramite = detArchivosAdjuntosTramite;
	}

	
}