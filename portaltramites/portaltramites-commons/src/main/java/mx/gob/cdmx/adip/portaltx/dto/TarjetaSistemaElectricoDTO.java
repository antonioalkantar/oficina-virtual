package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaSistemaElectricoDTO implements Serializable {
	private static final long serialVersionUID = -1069044269430929387L;

	private String idRegistroOrigen;
	private String folioTramite;
	private Integer idTipoTramite;
	private String tipoTramite;
	private Integer idTipoImpacto;
	private String tipoImpacto;
	private String nombreEstablecimiento;
	private String claveEstablecimiento;
	private String fechaRegistro;
	private String nombreDocumento;
	private String documento;
	private Integer idEstatusTramite;
	private String estatusTramite;
	private String pathImagen;
	private String sistema;

	public TarjetaSistemaElectricoDTO() {
	}

	public String getIdRegistroOrigen() {
		return idRegistroOrigen;
	}

	public void setIdRegistroOrigen(String idRegistroOrigen) {
		this.idRegistroOrigen = idRegistroOrigen;
	}

	public String getFolioTramite() {
		return folioTramite;
	}

	public void setFolioTramite(String folioTramite) {
		this.folioTramite = folioTramite;
	}

	public Integer getIdTipoTramite() {
		return idTipoTramite;
	}

	public void setIdTipoTramite(Integer idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}

	public String getTipoTramite() {
		return tipoTramite;
	}

	public void setTipoTramite(String tipoTramite) {
		this.tipoTramite = tipoTramite;
	}

	public Integer getIdTipoImpacto() {
		return idTipoImpacto;
	}

	public void setIdTipoImpacto(Integer idTipoImpacto) {
		this.idTipoImpacto = idTipoImpacto;
	}

	public String getTipoImpacto() {
		return tipoImpacto;
	}

	public void setTipoImpacto(String tipoImpacto) {
		this.tipoImpacto = tipoImpacto;
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	public String getClaveEstablecimiento() {
		return claveEstablecimiento;
	}

	public void setClaveEstablecimiento(String claveEstablecimiento) {
		this.claveEstablecimiento = claveEstablecimiento;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getIdEstatusTramite() {
		return idEstatusTramite;
	}

	public void setIdEstatusTramite(Integer idEstatusTramite) {
		this.idEstatusTramite = idEstatusTramite;
	}

	public String getEstatusTramite() {
		return estatusTramite;
	}

	public void setEstatusTramite(String estatusTramite) {
		this.estatusTramite = estatusTramite;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

}
