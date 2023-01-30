package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_conceptos_costos_hist database table.
 * 
 */
@Entity
@Table(name="det_conceptos_costos_hist", schema = "retys_v2")
@NamedQueries({
  @NamedQuery(name="DetConceptosCostosHist.findAll"
, query="SELECT d FROM DetConceptosCostosHist d")
, @NamedQuery(name="DetConceptosCostosHist.findByIdCostosHist"
, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetConceptosCostoDTO"
	+ " ("
	+ "dcchist.id, " 
	+ "dcchist.descripcionConcepto, " 
	+ "dcchist.lineaCaptura, " 
	+ "dcchist.monto, " 
	+ "dcchist.situacion " 
	+ ")"
	+ "FROM DetConceptosCostosHist dcchist "
	+ "join dcchist.detCosto dchist "
	+ "join dchist.tramiteServicio ts "
	+ "join ts.crcFlujoTramites ft "
	+ "join ft.catEtapasTramite cet "
	+ "join ft.catEstatusTramite cestt "
	+ "where dcchist.situacion = true "
	+ "and dchist.id = :idCosto "
	+ "and cestt = 2 "
	+ "and cet.esProcesoFinal = false"
	)
})

public class DetConceptosCostosHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcionConcepto;
	private String lineaCaptura;
	private double monto;
	private Boolean situacion;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCosto detCosto;
	private DetConceptosCosto detConceptosCosto;

	public DetConceptosCostosHist() {
	}


	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="descripcion_concepto")
	public String getDescripcionConcepto() {
		return this.descripcionConcepto;
	}

	public void setDescripcionConcepto(String descripcionConcepto) {
		this.descripcionConcepto = descripcionConcepto;
	}


	@Column(name="linea_captura")
	public String getLineaCaptura() {
		return this.lineaCaptura;
	}

	public void setLineaCaptura(String lineaCaptura) {
		this.lineaCaptura = lineaCaptura;
	}


	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CrcFlujoTramite2
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to DetCosto2
	@ManyToOne
	@JoinColumn(name="id_costos")
	public DetCosto getDetCosto() {
		return this.detCosto;
	}

	public void setDetCosto(DetCosto detCosto) {
		this.detCosto = detCosto;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetConceptosCosto getDetConceptosCosto() {
		return detConceptosCosto;
	}

	public void setDetConceptosCosto(DetConceptosCosto detConceptosCosto) {
		this.detConceptosCosto = detConceptosCosto;
	}

}