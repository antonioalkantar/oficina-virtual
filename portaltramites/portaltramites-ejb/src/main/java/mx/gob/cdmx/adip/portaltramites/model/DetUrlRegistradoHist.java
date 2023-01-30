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
@Table(name="det_url_registrado_hist", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetUrlRegistradoHist.findAll", query="SELECT d FROM DetUrlRegistradoHist d"),
})
public class DetUrlRegistradoHist implements Serializable {	
	private static final long serialVersionUID = 1L;
	private Long id;
	private DetCanalAtencionHist  detCanalAtencionHist;
	private CrcFlujoTramite crcFlujoTramite;
	private Boolean situacion;
	private String url;
	private DetUrlRegistrado detUrlRegistrado;
	
	DetUrlRegistradoHist(){
		
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
	@JoinColumn(name = "id_canal_atencion")
	public DetCanalAtencionHist getDetCanalAtencionHist() {
		return this.detCanalAtencionHist;
	}

	public void setDetCanalAtencionHist(DetCanalAtencionHist detCanalAtencionHist) {
		this.detCanalAtencionHist = detCanalAtencionHist;
	}
	
	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetUrlRegistrado getDetUrlRegistrado() {
		return detUrlRegistrado;
	}

	public void setDetUrlRegistrado(DetUrlRegistrado detUrlRegistrado) {
		this.detUrlRegistrado = detUrlRegistrado;
	}

}
