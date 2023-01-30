package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_adjuntos_modalidad database table.
 * 
 */
@Entity
@Table(name="det_archivos_adjuntos_modalidad", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetArchivosAdjuntosModalidad.findAll", query="SELECT d FROM DetArchivosAdjuntosModalidad d"),
	@NamedQuery(name="DetArchivosAdjuntosModalidad.findByIdTramiteII", 
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosAdjuntosModalidadDTO(d.id"
			+ ", d.nombreArchivo"
			+ ", d.situacion"
			+ ", ft.id"
			+ ", mt.id"
			+ ", d.rutaArchivo) "
			+ "FROM DetArchivosAdjuntosModalidad d "
			+ "join d.crcFlujoTramite ft "
			+ "join d.detModalidadesTramite mt "
			+ "where mt.id = :idTramite "
			+ "and d.situacion = true"),
	/*
	@NamedQuery(name="DetArchivosAdjuntosModalidad.findByIdTramite", 
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosAdjuntosModalidadDTO("
			+ " CASE WHEN ts.catEstatusTramite.id= 2 AND  cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.id  ELSE  d.id END"
			+ ",CASE WHEN ts.catEstatusTramite.id= 2 AND  cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.nombreArchivo   ELSE  d.nombreArchivo END"
			+ ",CASE WHEN ts.catEstatusTramite.id= 2 AND  cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.situacion ELSE  d.situacion END"
			+ ",CASE WHEN ts.catEstatusTramite.id= 2 AND  cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.idFlujoTramite  ELSE ft.id END "
			+ ",CASE WHEN ts.catEstatusTramite.id= 2 AND  cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.idModalidadesTramite ELSE mt.id END"
			+ ",CASE WHEN ts.catEstatusTramite.id= 2 AND  cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.rutaArchivo ELSE d.rutaArchivo END) "
			+ "FROM DetArchivosAdjuntosModalidad d "
			+ "join d.crcFlujoTramite ft "
			+ "join d.detModalidadesTramite mt "
			+ "left join d.detArchAdjModalidadHist archAmodhist "
			+ "join d.crcFlujoTramite cft "
			+ "join cft.catEtapasTramite cet "
			+ "where mt.id = :idTramite "
			+ "and d.situacion = true")
	*/
	@NamedQuery(name="DetArchivosAdjuntosModalidad.findByIdTramite", 
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosAdjuntosModalidadDTO("
			+ " CASE WHEN   cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.id  ELSE  d.id END"
			+ ",CASE WHEN   cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.nombreArchivo   ELSE  d.nombreArchivo END"
			+ ",CASE WHEN   cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.situacion ELSE  d.situacion END"
			+ ",CASE WHEN   cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.idFlujoTramite  ELSE ft.id END "
			+ ",CASE WHEN   cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.idModalidadesTramite ELSE mt.id END"
			+ ",CASE WHEN   cet.esProcesoFinal = false  AND  archAmodhist.id IS NOT NULL THEN archAmodhist.rutaArchivo ELSE d.rutaArchivo END) "
			+ "FROM DetArchivosAdjuntosModalidad d "
			+ "join d.crcFlujoTramite ft "
			+ "join d.detModalidadesTramite mt "
			+ "left join d.detArchAdjModalidadHist archAmodhist "
			+ "join d.crcFlujoTramite cft "
			+ "join cft.catEtapasTramite cet "
			+ "where mt.id = :idTramite "
			+ "and d.situacion = true")
})
public class DetArchivosAdjuntosModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	private Boolean situacion;
	private String rutaArchivo;
	
	private DetArchivosAdjuntosModalidadHist detArchAdjModalidadHist;

	public DetArchivosAdjuntosModalidad() {
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


	//bi-directional many-to-one association to DetModalidadesTramite
	@ManyToOne
	@JoinColumn(name="id_modalidades_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return this.detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@Column(name="ruta_archivo")
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetArchivosAdjuntosModalidadHist getDetArchAdjModalidadHist() {
		return detArchAdjModalidadHist;
	}


	public void setDetArchAdjModalidadHist(DetArchivosAdjuntosModalidadHist detArchAdjModalidadHist) {
		this.detArchAdjModalidadHist = detArchAdjModalidadHist;
	}

}