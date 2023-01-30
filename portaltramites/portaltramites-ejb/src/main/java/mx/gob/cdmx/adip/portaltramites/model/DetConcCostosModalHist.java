package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_conc_costos_modal_hist database table.
 * 
 */
@Entity
@Table(name="det_conc_costos_modal_hist", schema = "retys_v2")
@NamedQueries({
  @NamedQuery(name="DetConcCostosModalHist.findAll", query="SELECT d FROM DetConcCostosModalHist d")
, @NamedQuery(name="DetConcCostosModalHist.findByIdTramiteHist"
, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetConcCostosModalDTO(d.id"
		+ ", d.descripcionConcepto"
		+ ", d.lineaCaptura"
		+ ", d.monto"
		+ ", d.situacion"
		+ ", ft.id"
		+ ", dmt.id"
		+ ", ctc.id) "
		+ "FROM DetConcCostosModalHist d "
		+ "join d.detModalidadesTramite dmt "
		+ "join dmt.tramiteServicio ts "
		+ "join ts.crcFlujoTramites ft "
		+ "join ft.catEtapasTramite cet "
		+ "join ft.catEstatusTramite cestt "
		+ "join dmt.catTipoConcepto ctc "
		+ "where d.situacion = true "
		+ "and dmt.id = :idTramite "
		+ "and cestt = 2 "
		+ "and cet.esProcesoFinal = false"
		)
})
public class DetConcCostosModalHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcionConcepto;
	private Long idFlujoTramite;
	//private Long idModalidadTramite;
	private DetModalidadesTramite detModalidadesTramite;
	private String lineaCaptura;
	private double monto;
	private Boolean situacion;

	public DetConcCostosModalHist() {
	}


	@Id
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


	@Column(name="id_flujo_tramite")
	public Long getIdFlujoTramite() {
		return this.idFlujoTramite;
	}

	public void setIdFlujoTramite(Long idFlujoTramite) {
		this.idFlujoTramite = idFlujoTramite;
	}

/*
	@Column(name="id_modalidad_tramite")
	public Long getIdModalidadTramite() {
		return this.idModalidadTramite;
	}

	public void setIdModalidadTramite(Long idModalidadTramite) {
		this.idModalidadTramite = idModalidadTramite;
	}
*/

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
	//bi-directional many-to-one association to DetModalidadesTramite
	@ManyToOne
	@JoinColumn(name="id_modalidad_tramite")

	public DetModalidadesTramite getDetModalidadesTramite() {
		return detModalidadesTramite;
	}


	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

}