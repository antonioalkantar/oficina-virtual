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
@Table(name="det_telefonos_registrados_hist", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetTelefonosRegistradosHist.findAll", query="SELECT d FROM DetTelefonosRegistradosHist d"),
})
public class DetTelefonosRegistradosHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long extensionTel;
	private DetCanalAtencionHist canalAtencionHist;
	private CrcFlujoTramite crcFlujoTramite;
	private Long numTelefono;
	private Boolean situacion;
	private DetTelefonosRegistrado detTelefonosRegistrado;
	
	DetTelefonosRegistradosHist(){
		
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="extension_tel")
	public Long getExtensionTel() {
		return this.extensionTel;
	}

	public void setExtensionTel(Long extensionTel) {
		this.extensionTel = extensionTel;
	}

	// bi-directional many-to-one association to DetCanalAtencion
	@ManyToOne
	@JoinColumn(name = "id_canal_atencion")
	public DetCanalAtencionHist getDetCanalAtencionHist() {
		return this.canalAtencionHist;
	}

	public void setDetCanalAtencionHist(DetCanalAtencionHist canalAtencionHist) {
		this.canalAtencionHist = canalAtencionHist;
	}

	// bi-directional many-to-one association to CrcFlujoTramite2
	@ManyToOne
	@JoinColumn(name = "id_flujo_tramitre")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	@Column(name = "num_telefono")
	public Long getNumTelefono() {
		return this.numTelefono;
	}

	public void setNumTelefono(Long numTelefono) {
		this.numTelefono = numTelefono;
	}
	
	
	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
	@OneToOne
	@JoinColumn(name="id")
	public DetTelefonosRegistrado getDetTelefonosRegistrado() {
		return detTelefonosRegistrado;
	}

	public void setDetTelefonosRegistrado(DetTelefonosRegistrado detTelefonosRegistrado) {
		this.detTelefonosRegistrado = detTelefonosRegistrado;
	}
	
}
