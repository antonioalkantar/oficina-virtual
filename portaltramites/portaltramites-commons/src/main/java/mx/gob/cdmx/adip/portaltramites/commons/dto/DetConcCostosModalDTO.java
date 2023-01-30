package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetConcCostosModalDTO implements Serializable {

	private static final long serialVersionUID = -6914055921608045048L;
	private Long id;
	private String descripcionConcepto;
	private String lineaCaptura;
	private Double monto;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetModalidadesTramiteDTO detModalidadesTramite;
	private Boolean situacion;

	public DetConcCostosModalDTO() {
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		detModalidadesTramite = new DetModalidadesTramiteDTO();
	}
	
	public DetConcCostosModalDTO(Long id, String descripcionConcepto, String lineaCaptura, Double monto, Boolean situacion,
			Long idFlujoTramite, Long idModalidadesTramite, Long idTipoConcepto) {
		super();
		this.id = id;
		this.descripcionConcepto = descripcionConcepto;
		this.lineaCaptura = lineaCaptura;
		this.monto = monto;
		this.situacion = situacion;
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detModalidadesTramite = new DetModalidadesTramiteDTO(idModalidadesTramite, idTipoConcepto);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcionConcepto() {
		return descripcionConcepto;
	}

	public void setDescripcionConcepto(String descripcionConcepto) {
		this.descripcionConcepto = descripcionConcepto;
	}

	public String getLineaCaptura() {
		return lineaCaptura;
	}

	public void setLineaCaptura(String lineaCaptura) {
		this.lineaCaptura = lineaCaptura;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	public DetModalidadesTramiteDTO getDetModalidadesTramite() {
		return detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramiteDTO detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
