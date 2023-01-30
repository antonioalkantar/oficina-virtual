package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_adjuntos_modalidad_hist database table.
 * 
 */
@Entity
@Table(name="det_archivos_adjuntos_modalidad_hist", schema = "retys_v2")
@NamedQuery(name="DetArchivosAdjuntosModalidadHist.findAll", query="SELECT d FROM DetArchivosAdjuntosModalidadHist d")
public class DetArchivosAdjuntosModalidadHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idFlujoTramite;
	private Long idModalidadesTramite;
	private String nombreArchivo;
	private String rutaArchivo;
	private Boolean situacion;
	
	private DetArchivosAdjuntosModalidad detArchAdjuModalidad;

	public DetArchivosAdjuntosModalidadHist() {
	}


	@Id
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


	@Column(name="id_modalidades_tramite")
	public Long getIdModalidadesTramite() {
		return this.idModalidadesTramite;
	}

	public void setIdModalidadesTramite(Long idModalidadesTramite) {
		this.idModalidadesTramite = idModalidadesTramite;
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
	public DetArchivosAdjuntosModalidad getDetArchAdjuModalidad() {
		return detArchAdjuModalidad;
	}


	public void setDetArchAdjuModalidad(DetArchivosAdjuntosModalidad detArchAdjuModalidad) {
		this.detArchAdjuModalidad = detArchAdjuModalidad;
	}

}