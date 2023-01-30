package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_formato_hist database table.
 * 
 */
@Entity
@Table(name="det_formato_hist", schema = "retys_v2")
@NamedQuery(name="DetFormatoHist.findAll", query="SELECT d FROM DetFormatoHist d")
public class DetFormatoHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idFlujoTramitre;
	private Long idTipoPresentacion;
	private Boolean medianteFormato;
	private String observaciones;
	private Boolean requisitosNoParteFormato;
	private Boolean situacion;
	private String otraPresentacion;
	private String otroBeneficio;
	private TramiteServicio tramiteServicio;
	private CatDocumentoBeneficio catDocumentoBeneficio;

	public DetFormatoHist() {
	}


	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="id_flujo_tramitre")
	public Long getIdFlujoTramitre() {
		return this.idFlujoTramitre;
	}

	public void setIdFlujoTramitre(Long idFlujoTramitre) {
		this.idFlujoTramitre = idFlujoTramitre;
	}


	@Column(name="id_tipo_presentacion")
	public Long getIdTipoPresentacion() {
		return this.idTipoPresentacion;
	}

	public void setIdTipoPresentacion(Long idTipoPresentacion) {
		this.idTipoPresentacion = idTipoPresentacion;
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


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}


	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
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

}