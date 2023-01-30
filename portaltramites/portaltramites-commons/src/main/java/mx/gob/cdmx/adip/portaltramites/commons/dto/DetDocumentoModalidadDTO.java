package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetDocumentoModalidadDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1259137491853942087L;
	private Long id;
	private Long idCantidadCopias;
	private CatCantidadCaracteristicaDTO catCantidadCaracteristica;
	private CatDocumentoRequisitoDTO catDocumentoRequisito;
	private CatTipoDocumentoDTO catTipoDocumento;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetModalidadesTramiteDTO detModalidadesTramite;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCantidadCopias() {
		return idCantidadCopias;
	}
	public void setIdCantidadCopias(Long idCantidadCopias) {
		this.idCantidadCopias = idCantidadCopias;
	}
	public CatCantidadCaracteristicaDTO getCatCantidadCaracteristica() {
		return catCantidadCaracteristica;
	}
	public void setCatCantidadCaracteristica(CatCantidadCaracteristicaDTO catCantidadCaracteristica) {
		this.catCantidadCaracteristica = catCantidadCaracteristica;
	}
	public CatDocumentoRequisitoDTO getCatDocumentoRequisito() {
		return catDocumentoRequisito;
	}
	public void setCatDocumentoRequisito(CatDocumentoRequisitoDTO catDocumentoRequisito) {
		this.catDocumentoRequisito = catDocumentoRequisito;
	}
	public CatTipoDocumentoDTO getCatTipoDocumento() {
		return catTipoDocumento;
	}
	public void setCatTipoDocumento(CatTipoDocumentoDTO catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
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
	
}
