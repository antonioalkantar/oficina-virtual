package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_informacion_adicional_hist database table.
 * 
 */
@Entity
@Table(name="det_informacion_adicional_hist", schema = "retys_v2")
@NamedQuery(name="DetInformacionAdicionalHist.findAll", query="SELECT d FROM DetInformacionAdicionalHist d")
public class DetInformacionAdicionalHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Boolean esRequisitoOtroTramite;
	private Long idEstadoEmpresa;
	private Long idFlujoTramite;
	private Long idTramiteServicio;
	private String informacionUtil;
	private DetInformacionAdicionalHist detInformacionAdicionalHist;

	public DetInformacionAdicionalHist() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="es_requisito_otro_tramite")
	public Boolean getEsRequisitoOtroTramite() {
		return this.esRequisitoOtroTramite;
	}

	public void setEsRequisitoOtroTramite(Boolean esRequisitoOtroTramite) {
		this.esRequisitoOtroTramite = esRequisitoOtroTramite;
	}


	@Column(name="id_estado_empresa")
	public Long getIdEstadoEmpresa() {
		return this.idEstadoEmpresa;
	}

	public void setIdEstadoEmpresa(Long idEstadoEmpresa) {
		this.idEstadoEmpresa = idEstadoEmpresa;
	}


	@Column(name="id_flujo_tramite")
	public Long getIdFlujoTramite() {
		return this.idFlujoTramite;
	}

	public void setIdFlujoTramite(Long idFlujoTramite) {
		this.idFlujoTramite = idFlujoTramite;
	}


	@Column(name="id_tramite_servicio")
	public Long getIdTramiteServicio() {
		return this.idTramiteServicio;
	}

	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}


	@Column(name="informacion_util")
	public String getInformacionUtil() {
		return this.informacionUtil;
	}

	public void setInformacionUtil(String informacionUtil) {
		this.informacionUtil = informacionUtil;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetInformacionAdicionalHist getDetInformacionAdicionalHist() {
		return detInformacionAdicionalHist;
	}

	public void setDetInformacionAdicionalHist(DetInformacionAdicionalHist detInformacionAdicionalHist) {
		this.detInformacionAdicionalHist = detInformacionAdicionalHist;
	}
	
	

}