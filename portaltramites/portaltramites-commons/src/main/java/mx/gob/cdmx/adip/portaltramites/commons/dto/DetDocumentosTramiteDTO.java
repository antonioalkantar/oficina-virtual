package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetDocumentosTramiteDTO implements Serializable {

	private static final long serialVersionUID = 4041749706317037917L;
	private Long id;
	private Long cantidadCopias;
	private Long idDocumentoRequisito;
	private String descDocumentoRequisito;
	private Long idCantidadCaracteristica;
	private String descCantidadCaracteristica;
	private Long idTipoDocumento;
	private String descTipoDocumento;
	private Long idConjuncion;
	private String descConjuncion;
	private String requisitosGenerales;

	public DetDocumentosTramiteDTO(Long id, Long cantidadCopias, Long idDocumentoRequisito, String descDocumentoRequisito, 
			Long idCantidadCaracteristica, String descCantidadCaracteristica, Long idTipoDocumento, String descTipoDocumento,
			Long idConjuncion, String descConjuncion) {
		super();
		this.id = id;
		this.cantidadCopias = cantidadCopias;
		this.idDocumentoRequisito = idDocumentoRequisito;
		this.descDocumentoRequisito = descDocumentoRequisito;
		this.idCantidadCaracteristica = idCantidadCaracteristica;
		this.descCantidadCaracteristica = descCantidadCaracteristica;
		this.idTipoDocumento = idTipoDocumento;
		this.descTipoDocumento = descTipoDocumento;
		this.idConjuncion = idConjuncion;
		this.descConjuncion = descConjuncion;
		this.requisitosGenerales = descConjuncion != null ? descConjuncion +" " + descDocumentoRequisito + " - " + descCantidadCaracteristica : "" + descDocumentoRequisito + " - " + descCantidadCaracteristica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCantidadCopias() {
		return cantidadCopias;
	}

	public Long getIdDocumentoRequisito() {
		return idDocumentoRequisito;
	}

	public String getDescDocumentoRequisito() {
		return descDocumentoRequisito;
	}

	public Long getIdCantidadCaracteristica() {
		return idCantidadCaracteristica;
	}

	public String getDescCantidadCaracteristica() {
		return descCantidadCaracteristica;
	}

	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public String getDescTipoDocumento() {
		return descTipoDocumento;
	}

	public Long getIdConjuncion() {
		return idConjuncion;
	}

	public String getDescConjuncion() {
		return descConjuncion;
	}

	public void setCantidadCopias(Long cantidadCopias) {
		this.cantidadCopias = cantidadCopias;
	}

	public void setIdDocumentoRequisito(Long idDocumentoRequisito) {
		this.idDocumentoRequisito = idDocumentoRequisito;
	}

	public void setDescDocumentoRequisito(String descDocumentoRequisito) {
		this.descDocumentoRequisito = descDocumentoRequisito;
	}

	public void setIdCantidadCaracteristica(Long idCantidadCaracteristica) {
		this.idCantidadCaracteristica = idCantidadCaracteristica;
	}

	public void setDescCantidadCaracteristica(String descCantidadCaracteristica) {
		this.descCantidadCaracteristica = descCantidadCaracteristica;
	}

	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public void setDescTipoDocumento(String descTipoDocumento) {
		this.descTipoDocumento = descTipoDocumento;
	}

	public void setIdConjuncion(Long idConjuncion) {
		this.idConjuncion = idConjuncion;
	}

	public void setDescConjuncion(String descConjuncion) {
		this.descConjuncion = descConjuncion;
	}

	public String getRequisitosGenerales() {
		return requisitosGenerales;
	}

	public void setRequisitosGenerales(String requisitosGenerales) {
		this.requisitosGenerales = requisitosGenerales;
	}

}
