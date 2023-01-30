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
@Table(name="det_lugares_registrados_hist", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetLugaresRegistradosHist.findAll", query="SELECT d FROM DetLugaresRegistradosHist d"),
})
public class DetLugaresRegistradosHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private CrcFlujoTramite crcFlujoTramite;
	private CatAreaAc catAreaAc;
	private DetCanalAtencionHist  detCanalAtencionHist;
	private Boolean situacion;
	private DetLugaresRegistrado detLugaresRegistrado;
	
	
	public DetLugaresRegistradosHist() {		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	// bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name = "id_area_ac")
	public CatAreaAc getCatAreaAc() {
		return this.catAreaAc;
	}

	public void setCatAreaAc(CatAreaAc catAreaAc) {
		this.catAreaAc = catAreaAc;
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
	
	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
	@OneToOne
	@JoinColumn(name="id")
	public DetLugaresRegistrado getDetLugaresRegistrado() {
		return detLugaresRegistrado;
	}

	public void setDetLugaresRegistrado(DetLugaresRegistrado detLugaresRegistrado) {
		this.detLugaresRegistrado = detLugaresRegistrado;
	}
}
