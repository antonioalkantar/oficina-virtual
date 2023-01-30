package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_conc_costos_modal database table.
 * 
 */
@Entity
@Table(name="det_conc_costos_modal", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetConcCostosModal.findAll", query="SELECT d FROM DetConcCostosModal d")
	, @NamedQuery(name="DetConcCostosModal.findByIdTramite"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetConcCostosModalDTO(d.id"
			+ ", d.descripcionConcepto"
			+ ", d.lineaCaptura"
			+ ", d.monto"
			+ ", d.situacion"
			+ ", ft.id"
			+ ", dmt.id"
			+ ", ctc.id) "
			+ "FROM DetConcCostosModal d "
			+ "join d.detModalidadesTramite dmt "
			+ "join dmt.tramiteServicio ts "
			+ "join ts.crcFlujoTramites ft "
			+ "join ft.catEtapasTramite cet "
			+ "join ft.catEstatusTramite cestt "
			+ "join dmt.catTipoConcepto ctc "
			+ "where d.situacion = true "
			+ "and dmt.id = :idTramite "
			)
})
public class DetConcCostosModal implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcionConcepto;
	private String lineaCaptura;
	private double monto;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;
	private Boolean situacion;

	public DetConcCostosModal() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	//bi-directional many-to-one association to DetModalidadesTramite
	@ManyToOne
	@JoinColumn(name="id_modalidad_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return this.detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}