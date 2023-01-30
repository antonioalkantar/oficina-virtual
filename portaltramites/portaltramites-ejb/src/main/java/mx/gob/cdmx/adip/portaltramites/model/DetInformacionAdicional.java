package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_informacion_adicional database table.
 * 
 */
@Entity
@Table(name="det_informacion_adicional", schema = "retys_v2")

@NamedQueries({
	@NamedQuery(name="DetInformacionAdicional.findByIdTramite"
			, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetInformacionAdicionalDTO"
					+ "("
					+ "  c.id "
					+ ", ts.id"
					+ ", ts.homoclave"
					+ ", ts.nombreOficial"
//					+ ", cee.id"
//					+ ", cee.descripcion"
					+ ", c.esRequisitoOtroTramite"
					+ ", c.informacionUtil"
					+ ", cft.id"
					+ ") "
					+ "FROM DetInformacionAdicional c "
					+ "JOIN c.tramiteServicio ts "
					+ "JOIN c.crcFlujoTramite cft "
//					+ "JOIN c.catEstadoEmpresa cee "
					+ "WHERE c.id = :idTramite "
				)
//
//	, 	@NamedQuery(name="DetInformacionAdicional.findByIdTramiteFlujo"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.DetInformacionAdicionalDTO"
//					+ "("
//					+ "  COALESCE(max(c.id), 0) "
//					+ ") "
//					+ "FROM DetInformacionAdicional c "
//					+ "JOIN c.tramiteServicio ts "
//					+ "WHERE ts.id = :idTramite "
//				)
//	
//	, 	@NamedQuery(name="DetInformacionAdicional.totalRegistrosByIdTramite"
//	, query="select count(ia) from DetInformacionAdicional ia where ia.tramiteServicio.id = :idTramite")
})

public class DetInformacionAdicional implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Boolean esRequisitoOtroTramite;
	private String informacionUtil;
//	private CatEstadoEmpresa catEstadoEmpresa;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private DetInformacionAdicional detInformacionAdicional;

	public DetInformacionAdicional() {
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


	@Column(name="informacion_util")
	public String getInformacionUtil() {
		return this.informacionUtil;
	}

	public void setInformacionUtil(String informacionUtil) {
		this.informacionUtil = informacionUtil;
	}


//	//bi-directional many-to-one association to CatEstadoEmpresa
//	@ManyToOne
//	@JoinColumn(name="id_estado_empresa")
//	public CatEstadoEmpresa getCatEstadoEmpresa() {
//		return this.catEstadoEmpresa;
//	}
//
//	public void setCatEstadoEmpresa(CatEstadoEmpresa catEstadoEmpresa) {
//		this.catEstadoEmpresa = catEstadoEmpresa;
//	}


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

	@OneToOne
	@JoinColumn(name="id")
	public DetInformacionAdicional getDetInformacionAdicional() {
		return detInformacionAdicional;
	}

	public void setDetInformacionAdicional(DetInformacionAdicional detInformacionAdicional) {
		this.detInformacionAdicional = detInformacionAdicional;
	}

}