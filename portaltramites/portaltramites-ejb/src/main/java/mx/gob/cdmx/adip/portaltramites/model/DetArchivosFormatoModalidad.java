package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_formato_modalidad database table.
 * 
 */
@Entity
@Table(name="det_archivos_formato_modalidad", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetArchivosFormatoModalidad.findAll", query="SELECT d FROM DetArchivosFormatoModalidad d"),
	@NamedQuery(name="DetArchivosFormatoModalidad.findByIdTramiteII",
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosFormatoModalidadDTO"
			+ "(d.id"
			+ ", d.nombreArchivo"
			+ ", d.situacion"
			+ ", ft.id"
			+ ", mt.id"
			+ ", d.rutaArchivo) "
			+ "FROM DetArchivosFormatoModalidad d "
			+ "join d.crcFlujoTramite ft "
			+ "join d.detModalidadesTramite mt "
			+ "join mt.tramiteServicio ts "
			+ "left join mt.crcModificacionModalidads cmm "
			+ "where "
			+ "( "
			+ "(mt.id <> :idModalidad and ts.id = :idTramite and mt.replicaMedianteFormato = true)"
			+ "or (mt.id = :idModalidad)"
			+ ") "
			+ "and d.situacion = true "
			+ "and (cmm.estatusCampo is null or cmm.estatusCampo in (1,2)) "
			+ "order by d.id"),
	@NamedQuery(name="DetArchivosFormatoModalidad.findByIdTramite",
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosFormatoModalidadDTO"
			+ "( archmodhist.id "
			+ ", archmodhist.nombreArchivo "
			+ ", archmodhist.situacion "
			+ ", archmodhist.crcFlujoTramite.id "
			+ ", archmodhist.detModalidadesTramite.id "
			+ ", archmodhist.rutaArchivo "
			+ ") "
			+ "FROM DetArchivosFormatoModalidad d "
			+ "join d.detModalidadesTramite mt "
			+ "join mt.detModalidadesTramiteHist mth "
			+ "join mt.tramiteServicio ts "			
			+ "join d.crcFlujoTramite cft "
			+ "join cft.catEtapasTramite cet "
			+ "join cft.catEstatusTramite cett "
			+ "join d.detArchivoFormatoModalidadHist archmodhist "
			+ "where "
			+ "( "
			+ "(mth.id <> :idModalidad and ts.id = :idTramite and mth.replicaMedianteFormato = true)"
			+ "or (mth.id = :idModalidad)"
			+ ") "
			+ "and archmodhist.situacion = true "
			+ "and mth.situacion = true "
			+ "and cett.id = 2 "
			+ "and cet.esProcesoFinal = false "
			+ "order by d.id")
})
public class DetArchivosFormatoModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	private Boolean situacion;
	private String rutaArchivo;
	
	private DetArchivosFormatoModalidadHist detArchivoFormatoModalidadHist;

	public DetArchivosFormatoModalidad() {
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
	public DetArchivosFormatoModalidadHist getDetArchivoFormatoModalidadHist() {
		return detArchivoFormatoModalidadHist;
	}


	public void setDetArchivoFormatoModalidadHist(DetArchivosFormatoModalidadHist detArchivoFormatoModalidadHist) {
		this.detArchivoFormatoModalidadHist = detArchivoFormatoModalidadHist;
	}

}