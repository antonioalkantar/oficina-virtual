package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_documentos_tramite_hist database table.
 * 
 */
@Entity
@Table(name="det_documentos_tramite_hist", schema = "retys_v2")
@NamedQuery(name="DetDocumentosTramiteHist.findAll", query="SELECT d FROM DetDocumentosTramiteHist d")
public class DetDocumentosTramiteHist implements Serializable {
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
	private DetDocumentosTramite detDocumentosTramite;

	public DetDocumentosTramiteHist() {
	}

	@Id
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
	public DetDocumentosTramite getDetDocumentosTramite() {
		return detDocumentosTramite;
	}

	public void setDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
		this.detDocumentosTramite = detDocumentosTramite;
	}	
	
	

}