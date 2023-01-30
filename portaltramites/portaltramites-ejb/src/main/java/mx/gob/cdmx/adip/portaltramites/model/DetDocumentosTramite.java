package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_documentos_tramite database table.
 * 
 */
@Entity
@Table(name="det_documentos_tramite", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetDocumentosTramite.findAll", query="SELECT d FROM DetDocumentosTramite d")
	,@NamedQuery(name="DetDocumentosTramite.findbyIdTramiteAndIdTipoDoc"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetDocumentosTramiteDTO( "
			+ "dt.id"
			+ ", dt.cantidadCopias"
			+ ", dr.id"
			+ ", dr.descripcion"
			+ ", cc.id"
			+ ", cc.descripcion"
			+ ", td.id"
			+ ", td.descripcion"
			+ ", ccon.id "
			+ ", ccon.descripcion"			
			+ ") "
			+ "FROM DetDocumentosTramite dt "
			+ "join dt.catDocumentoRequisito dr "
			+ "join dt.catCantidadCaracteristica cc "
			+ "join dt.catTipoDocumento td "
			+ "left join dt.catConjuncion ccon "
			+ "join dt.tramiteServicio ts "
			+ "join ts.crcFlujoTramites ft "
			+ "join ft.catEtapasTramite cet "
			+ "join ft.catEstatusTramite cestt "
			+ "where ts.id = :idTramite "
			+ "and td.id = :idTipoDoc "
			+ "and dt.situacion = true "
			+ "order by dt.id")
	,@NamedQuery(name="DetDocumentosTramite.findbyIdTramiteAndIdTipoDocHist"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetDocumentosTramiteDTO( "
			+ "dt.id, " 
			+ "dt.cantidadCopias, " 
			+ "drhist.id, " 
			+ "drhist.descripcion, " 
			+ "cchist.id, " 
			+ "cchist.descripcion, " 
			+ "tdhist.id, " 
			+ "tdhist.descripcion, " 
			+ "cconhist.id, " 
			+ "cconhist.descripcion " 
			+ ") "
			+ "FROM DetDocumentosTramiteHist dt "
			+ "join dt.tramiteServicio ts "
			+ "join ts.crcFlujoTramites ft "			
			+ "join dt.catDocumentoRequisito drhist "
			+ "join dt.catCantidadCaracteristica cchist "
			+ "join dt.catTipoDocumento tdhist "
			+ "left join dt.catConjuncion cconhist "			
			+ "join ft.catEtapasTramite cet "
			+ "join ft.catEstatusTramite cestt "
			+ "where ts.id = :idTramite "
			+ "and tdhist.id = :idTipoDoc "
			+ "and dt.situacion = true "
            + "and cestt.id = 2 "
            + "and cet.esProcesoFinal = false "
            + "order by dt.id")
})
public class DetDocumentosTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long cantidadCopias;
	private Boolean situacion;
	private CatCantidadCaracteristica catCantidadCaracteristica;
	private CatDocumentoRequisito catDocumentoRequisito;
	private CatTipoDocumento catTipoDocumento;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private CatConjuncion catConjuncion;
	private DetDocumentosTramiteHist detDocumentosTramiteHist;

	public DetDocumentosTramite() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="cantidad_copias")
	public Long getCantidadCopias() {
		return this.cantidadCopias;
	}

	public void setCantidadCopias(Long cantidadCopias) {
		this.cantidadCopias = cantidadCopias;
	}


	//bi-directional many-to-one association to CatCantidadCaracteristica
	@ManyToOne
	@JoinColumn(name="id_cantidad_caracteristicas")
	public CatCantidadCaracteristica getCatCantidadCaracteristica() {
		return this.catCantidadCaracteristica;
	}

	public void setCatCantidadCaracteristica(CatCantidadCaracteristica catCantidadCaracteristica) {
		this.catCantidadCaracteristica = catCantidadCaracteristica;
	}


	//bi-directional many-to-one association to CatDocumentoRequisito
	@ManyToOne
	@JoinColumn(name="id_documento_modalidad")
	public CatDocumentoRequisito getCatDocumentoRequisito() {
		return this.catDocumentoRequisito;
	}

	public void setCatDocumentoRequisito(CatDocumentoRequisito catDocumentoRequisito) {
		this.catDocumentoRequisito = catDocumentoRequisito;
	}


	//bi-directional many-to-one association to CatTipoDocumento
	@ManyToOne
	@JoinColumn(name="id_tipo_documento")
	public CatTipoDocumento getCatTipoDocumento() {
		return this.catTipoDocumento;
	}

	public void setCatTipoDocumento(CatTipoDocumento catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
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
	
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	//bi-directional many-to-one association to CatConjuncion
	@ManyToOne
	@JoinColumn(name="id_conjuncion")
	public CatConjuncion getCatConjuncion() {
		return this.catConjuncion;
	}

	public void setCatConjuncion(CatConjuncion catConjuncion) {
		this.catConjuncion = catConjuncion;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetDocumentosTramiteHist getDetDocumentosTramiteHist() {
		return detDocumentosTramiteHist;
	}

	public void setDetDocumentosTramiteHist(DetDocumentosTramiteHist detDocumentosTramiteHist) {
		this.detDocumentosTramiteHist = detDocumentosTramiteHist;
	}
		
	
	
}