package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetConceptosCostoDTO implements Serializable {

	private static final long serialVersionUID = -7962517934382987986L;

	private Long id;
	private String descripcionConcepto;
	private String lineaCaptura;
	private Double monto;
	private Boolean situacion;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private DetCostoDTO detCostoDTO;
	private CatTipoConceptoDTO catTipoConceptoDTO;

	public DetConceptosCostoDTO() {
		crcFlujoTramiteDTO = new CrcFlujoTramiteDTO();
		detCostoDTO = new DetCostoDTO();
	}

	public DetConceptosCostoDTO(Long id, String descripcionConcepto, String lineaCaptura, Double monto, Boolean situacion) {
		this.id = id;
		this.descripcionConcepto = descripcionConcepto;
		this.lineaCaptura = lineaCaptura;
		this.monto = monto;
		this.situacion = situacion;
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

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramiteDTO() {
		return crcFlujoTramiteDTO;
	}

	public void setCrcFlujoTramiteDTO(CrcFlujoTramiteDTO crcFlujoTramiteDTO) {
		this.crcFlujoTramiteDTO = crcFlujoTramiteDTO;
	}

	public DetCostoDTO getDetCostoDTO() {
		return detCostoDTO;
	}

	public void setDetCostoDTO(DetCostoDTO detCostoDTO) {
		this.detCostoDTO = detCostoDTO;
	}

	public CatTipoConceptoDTO getCatTipoConceptoDTO() {
		return catTipoConceptoDTO;
	}

	public void setCatTipoConceptoDTO(CatTipoConceptoDTO catTipoConceptoDTO) {
		this.catTipoConceptoDTO = catTipoConceptoDTO;
	}

	
}
