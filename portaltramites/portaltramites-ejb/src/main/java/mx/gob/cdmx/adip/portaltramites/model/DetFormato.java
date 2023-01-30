package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_formato database table.
 * 
 */
@Entity
@Table(name="det_formato", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetFormato.findAll", query="SELECT d FROM DetFormato d"),
})
public class DetFormato implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Boolean medianteFormato;
	private String observaciones;
	private String otroBeneficio;
	private String otraPresentacion;
	private Boolean requisitosNoParteFormato;
	private Boolean situacion;
//	private List<DetArchivosAdjuntosTramite> detArchivosAdjuntosTramites;
	private List<DetArchivosFormatoTramite> detArchivosFormatoTramites;
	private CatDocumentoBeneficio catDocumentoBeneficio;
//	private CatTipoPresentacion catTipoPresentacion;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private List<DetRequisitosFormato> detRequisitosFormatos;

	public DetFormato() {
	}

	public DetFormato(Long id) {
	this.id = id;
	}

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="mediante_formato")
	public Boolean getMedianteFormato() {
		return this.medianteFormato;
	}

	public void setMedianteFormato(Boolean medianteFormato) {
		this.medianteFormato = medianteFormato;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	@Column(name="requisitos_no_parte_formato")
	public Boolean getRequisitosNoParteFormato() {
		return this.requisitosNoParteFormato;
	}

	public void setRequisitosNoParteFormato(Boolean requisitosNoParteFormato) {
		this.requisitosNoParteFormato = requisitosNoParteFormato;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to DetArchivosAdjuntosTramite
//	@OneToMany(mappedBy="detFormato")
//	public List<DetArchivosAdjuntosTramite> getDetArchivosAdjuntosTramites() {
//		return this.detArchivosAdjuntosTramites;
//	}
//
//	public void setDetArchivosAdjuntosTramites(List<DetArchivosAdjuntosTramite> detArchivosAdjuntosTramites) {
//		this.detArchivosAdjuntosTramites = detArchivosAdjuntosTramites;
//	}
//
//	public DetArchivosAdjuntosTramite addDetArchivosAdjuntosTramite(DetArchivosAdjuntosTramite detArchivosAdjuntosTramite) {
//		getDetArchivosAdjuntosTramites().add(detArchivosAdjuntosTramite);
//		detArchivosAdjuntosTramite.setDetFormato(this);
//
//		return detArchivosAdjuntosTramite;
//	}
//
//	public DetArchivosAdjuntosTramite removeDetArchivosAdjuntosTramite(DetArchivosAdjuntosTramite detArchivosAdjuntosTramite) {
//		getDetArchivosAdjuntosTramites().remove(detArchivosAdjuntosTramite);
//		detArchivosAdjuntosTramite.setDetFormato(null);
//
//		return detArchivosAdjuntosTramite;
//	}


	//bi-directional many-to-one association to DetArchivosFormatoTramite
	@OneToMany(mappedBy="detFormato")
	public List<DetArchivosFormatoTramite> getDetArchivosFormatoTramites() {
		return this.detArchivosFormatoTramites;
	}

	public void setDetArchivosFormatoTramites(List<DetArchivosFormatoTramite> detArchivosFormatoTramites) {
		this.detArchivosFormatoTramites = detArchivosFormatoTramites;
	}

	public DetArchivosFormatoTramite addDetArchivosFormatoTramite(DetArchivosFormatoTramite detArchivosFormatoTramite) {
		getDetArchivosFormatoTramites().add(detArchivosFormatoTramite);
		detArchivosFormatoTramite.setDetFormato(this);

		return detArchivosFormatoTramite;
	}

	public DetArchivosFormatoTramite removeDetArchivosFormatoTramite(DetArchivosFormatoTramite detArchivosFormatoTramite) {
		getDetArchivosFormatoTramites().remove(detArchivosFormatoTramite);
		detArchivosFormatoTramite.setDetFormato(null);

		return detArchivosFormatoTramite;
	}


	//bi-directional many-to-one association to CatDocumentoBeneficio
	@ManyToOne
	@JoinColumn(name="id_documento_beneficio")
	public CatDocumentoBeneficio getCatDocumentoBeneficio() {
		return this.catDocumentoBeneficio;
	}

	public void setCatDocumentoBeneficio(CatDocumentoBeneficio catDocumentoBeneficio) {
		this.catDocumentoBeneficio = catDocumentoBeneficio;
	}


	//bi-directional many-to-one association to CatTipoPresentacion
//	@ManyToOne
//	@JoinColumn(name="id_tipo_presentacion")
//	public CatTipoPresentacion getCatTipoPresentacion() {
//		return this.catTipoPresentacion;
//	}
//
//	public void setCatTipoPresentacion(CatTipoPresentacion catTipoPresentacion) {
//		this.catTipoPresentacion = catTipoPresentacion;
//	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramitre")
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


	//bi-directional many-to-one association to DetRequisitosFormato
	@OneToMany(mappedBy="detFormato")
	public List<DetRequisitosFormato> getDetRequisitosFormatos() {
		return this.detRequisitosFormatos;
	}

	public void setDetRequisitosFormatos(List<DetRequisitosFormato> detRequisitosFormatos) {
		this.detRequisitosFormatos = detRequisitosFormatos;
	}

	public DetRequisitosFormato addDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
		getDetRequisitosFormatos().add(detRequisitosFormato);
		detRequisitosFormato.setDetFormato(this);

		return detRequisitosFormato;
	}

	public DetRequisitosFormato removeDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
		getDetRequisitosFormatos().remove(detRequisitosFormato);
		detRequisitosFormato.setDetFormato(null);

		return detRequisitosFormato;
	}
    
	@Column(name="otro_beneficio")
	public String getOtroBeneficio() {
		return otroBeneficio;
	}

	public void setOtroBeneficio(String otroBeneficio) {
		this.otroBeneficio = otroBeneficio;
	}

	@Column(name="otra_presentacion")
	public String getOtraPresentacion() {
		return otraPresentacion;
	}

	public void setOtraPresentacion(String otraPresentacion) {
		this.otraPresentacion = otraPresentacion;
	}

}