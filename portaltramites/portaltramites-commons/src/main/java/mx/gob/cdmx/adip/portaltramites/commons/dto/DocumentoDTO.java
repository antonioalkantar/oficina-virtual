package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DocumentoDTO implements Serializable {

	private static final long serialVersionUID = -1485829898633575177L;

	private Long id;
	private String descripcion;
	private String tipoDocumento;
	private String formato;
	private Boolean mostrarBtnVer;
	private Boolean mostrarBtnEliminar;
	private Boolean mostrarBtnActualizar;

	public DocumentoDTO() {
	}

	public DocumentoDTO(Long id, String descripcion, String tipoDocumento, String formato, Boolean mostrarBtnVer,
			Boolean mostrarBtnEliminar, Boolean mostrarBtnActualizar) {
		this.id = id;
		this.descripcion = descripcion;
		this.tipoDocumento = tipoDocumento;
		this.formato = formato;
		this.mostrarBtnVer = mostrarBtnVer;
		this.mostrarBtnEliminar = mostrarBtnEliminar;
		this.mostrarBtnActualizar = mostrarBtnActualizar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Boolean getMostrarBtnVer() {
		return mostrarBtnVer;
	}

	public void setMostrarBtnVer(Boolean mostrarBtnVer) {
		this.mostrarBtnVer = mostrarBtnVer;
	}

	public Boolean getMostrarBtnEliminar() {
		return mostrarBtnEliminar;
	}

	public void setMostrarBtnEliminar(Boolean mostrarBtnEliminar) {
		this.mostrarBtnEliminar = mostrarBtnEliminar;
	}

	public Boolean getMostrarBtnActualizar() {
		return mostrarBtnActualizar;
	}

	public void setMostrarBtnActualizar(Boolean mostrarBtnActualizar) {
		this.mostrarBtnActualizar = mostrarBtnActualizar;
	}
}