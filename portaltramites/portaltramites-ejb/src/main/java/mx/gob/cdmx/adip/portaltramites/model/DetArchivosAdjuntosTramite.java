package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_adjuntos_tramite database table.
 * 
 */
@Entity
@Table(name="det_archivos_adjuntos_tramite", schema = "retys_v2")
@NamedQueries({
@NamedQuery(name="DetArchivosAdjuntosTramite.findAll", query="SELECT d FROM DetArchivosAdjuntosTramite d"),

@NamedQuery(name="DetArchivosAdjuntosTramite.findById"
, query="SELECT  new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosAdjuntosTramiteDTO"
		+ " ( "
		+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dhist.id is not null then dhist.id else d.id end, " 
		+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dhist.nombreArchivo is not null then dhist.nombreArchivo else d.nombreArchivo end, " 
		+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dfhist.id is not null then dfhist.id else df.id end, " 
		+ "case when cestt.id = 2 and cet.esProcesoFinal = false and cfthist.id is not null then cfthist.id else cft.id end " 
//		+ "d.id, "
//		+ "d.nombreArchivo, "
//		+ "df.id, "
//		+ "cft.id "
		+ ")"
		+ "FROM DetArchivosAdjuntosTramite d  "
		+ "  JOIN d.detFormato df "
		+ "  JOIN d.crcFlujoTramite cft "
		
		+ " left join d.detArchivosAdjuntosTramiteHist dhist "
		+ " left JOIN dhist.detFormato dfhist "
		+ " left JOIN dhist.crcFlujoTramite cfthist "
		
		+ " join cft.catEtapasTramite cet "
		+ " join cft.catEstatusTramite cestt "		
		+ "where d.situacion = TRUE and d.detFormato.id = :idFormato  " )
})
public class DetArchivosAdjuntosTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramite crcFlujoTramite;
	private DetFormato detFormato;
	private Boolean situacion;
	private DetArchivosAdjuntosTramiteHist detArchivosAdjuntosTramiteHist;

	public DetArchivosAdjuntosTramite() {
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
	public DetArchivosAdjuntosTramiteHist getDetArchivosAdjuntosTramiteHist() {
		return detArchivosAdjuntosTramiteHist;
	}

	public void setDetArchivosAdjuntosTramiteHist(DetArchivosAdjuntosTramiteHist detArchivosAdjuntosTramiteHist) {
		this.detArchivosAdjuntosTramiteHist = detArchivosAdjuntosTramiteHist;
	}

}