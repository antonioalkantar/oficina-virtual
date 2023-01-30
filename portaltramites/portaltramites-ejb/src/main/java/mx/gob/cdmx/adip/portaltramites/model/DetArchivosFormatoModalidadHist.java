package mx.gob.cdmx.adip.portaltramites.model;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_formato_modalidad_hist database table.
 * 
 */
@Entity
@Table(name="det_archivos_formato_modalidad_hist", schema = "retys_v2")
@NamedQuery(name="DetArchivosFormatoModalidadHist.findAll", query="SELECT d FROM DetArchivosFormatoModalidadHist d")
public class DetArchivosFormatoModalidadHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	//private Long idFlujoTramite;
	//private Long idModalidadesTramite;
	private String nombreArchivo;
	private String rutaArchivo;
	private Boolean situacion;
	
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	
	private  DetArchivosFormatoModalidad detArchivosFormatoModalidad; 

	public DetArchivosFormatoModalidadHist() {
	}


	@Id
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


	@Column(name="ruta_archivo")
	public String getRutaArchivo() {
		return this.rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetArchivosFormatoModalidad getDetArchivosFormatoModalidad() {
		return detArchivosFormatoModalidad;
	}


	public void setDetArchivosFormatoModalidad(DetArchivosFormatoModalidad detArchivosFormatoModalidad) {
		this.detArchivosFormatoModalidad = detArchivosFormatoModalidad;
	}

	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return crcFlujoTramite;
	}


	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	@ManyToOne
	@JoinColumn(name="id_modalidades_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return detModalidadesTramite;
	}


	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

}