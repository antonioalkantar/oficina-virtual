package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_formato_tramite_hist database table.
 * 
 */
@Entity
@Table(name="det_archivos_formato_tramite_hist", schema = "retys_v2")
@NamedQuery(name="DetArchivosFormatoTramiteHist.findAll", query="SELECT d FROM DetArchivosFormatoTramiteHist d")
public class DetArchivosFormatoTramiteHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramite crcFlujoTramite;
	private DetFormato detFormato;
	private Boolean situacion;
	private DetArchivosFormatoTramite detArchivosFormatoTramite;

	public DetArchivosFormatoTramiteHist() {
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
	public DetArchivosFormatoTramite getDetArchivosFormatoTramite() {
		return detArchivosFormatoTramite;
	}

	public void setDetArchivosFormatoTramite(DetArchivosFormatoTramite detArchivosFormatoTramite) {
		this.detArchivosFormatoTramite = detArchivosFormatoTramite;
	}
	

}