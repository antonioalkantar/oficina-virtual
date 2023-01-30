package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_archivos_formato_tramite database table.
 * 
 */
@Entity
@Table(name="det_archivos_formato_tramite", schema = "retys_v2")

@NamedQueries({
@NamedQuery(name="DetArchivosFormatoTramite.findAll", query="SELECT d FROM DetArchivosFormatoTramite d")
, @NamedQuery(name="DetArchivosFormatoTramite.findById"
, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosFormatoTramiteDTO"
		+ "( "
		+ "  d.id " 
		+ ", d.nombreArchivo " 
		+ ", df.id " 
		+ ", cft.id " 
		+ ") "
		+ " FROM DetArchivosFormatoTramite d "
		+ " JOIN d.detFormato df "
		+ " JOIN d.crcFlujoTramite cft "
		+ " where d.situacion = TRUE "
		+ " and df.id = :idDetFormato")
, @NamedQuery(name="DetArchivosFormatoTramite.findByIdHist"
, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosFormatoTramiteDTO"
		+ "( "
		+ "  dhist.id " 
		+ ", dhist.nombreArchivo " 
		+ ", df.id " 
		+ ", cft.id " 
		+ ") "
		+ " FROM DetArchivosFormatoTramite d "
		+ " JOIN d.detFormato df "
		+ " JOIN d.crcFlujoTramite cft "
		+ " join cft.catEtapasTramite cet "
		+ " join cft.catEstatusTramite cestt "
		+ " join d.detArchivosFormatoTramiteHist dhist "
		+ " where dhist.situacion = TRUE "
		+ " and df.id = :idDetFormato "
		+ " and cestt.id = 2 "
		+ " and cet.esProcesoFinal = false "
		+ " ")
})

public class DetArchivosFormatoTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombreArchivo;
	private CrcFlujoTramite crcFlujoTramite;
	private DetFormato detFormato;
	private Boolean situacion;
	private DetArchivosFormatoTramiteHist detArchivosFormatoTramiteHist;
	
	public DetArchivosFormatoTramite() {
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
	public DetArchivosFormatoTramiteHist getDetArchivosFormatoTramiteHist() {
		return detArchivosFormatoTramiteHist;
	}

	public void setDetArchivosFormatoTramiteHist(DetArchivosFormatoTramiteHist detArchivosFormatoTramiteHist) {
		this.detArchivosFormatoTramiteHist = detArchivosFormatoTramiteHist;
	}

	
}