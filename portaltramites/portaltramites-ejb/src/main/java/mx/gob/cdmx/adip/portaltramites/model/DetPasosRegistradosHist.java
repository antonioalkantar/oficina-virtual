package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="det_pasos_registrados_hist", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetPasosRegistradosHist.findAll", query="SELECT d FROM DetPasosRegistradosHist d"),
})
public class DetPasosRegistradosHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private CatActor catActor;
	private DetCanalAtencionHist  detCanalAtencionHist;
	private CrcFlujoTramite crcFlujoTramite;
	private Long numeroPaso;
	private Boolean situacion;
	private Long tipoSolicitud;
	private DetPasosRegistrado detPasosRegistrado;
	
	public DetPasosRegistradosHist() {		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// bi-directional many-to-one association to CrcFlujoTramite2
	@ManyToOne
	@JoinColumn(name = "id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	@Column(name="numero_paso")
	public Long getNumeroPaso() {
		return this.numeroPaso;
	}

	public void setNumeroPaso(Long numeroPaso) {
		this.numeroPaso = numeroPaso;
	}
	
	
	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
	@Column(name="tipo_solicitud")
	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}


	public void setTipoSolicitud(Long tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	

	// bi-directional many-to-one association to CatActor
	@ManyToOne
	@JoinColumn(name = "id_actor")
	public CatActor getCatActor() {
		return this.catActor;
	}

	public void setCatActor(CatActor catActor) {
		this.catActor = catActor;
	}

	// bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name = "id_canal_atencion")
	public DetCanalAtencionHist getDetCanalAtencionHist() {
		return this.detCanalAtencionHist;
	}

	public void setDetCanalAtencionHist(DetCanalAtencionHist detCanalAtencionHist) {
		this.detCanalAtencionHist = detCanalAtencionHist;
	}
	
	
	@OneToOne
	@JoinColumn(name="id")
	public DetPasosRegistrado getDetPasosRegistrado() {
		return detPasosRegistrado;
	}

	public void setDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
		this.detPasosRegistrado = detPasosRegistrado;
	}
	

}
