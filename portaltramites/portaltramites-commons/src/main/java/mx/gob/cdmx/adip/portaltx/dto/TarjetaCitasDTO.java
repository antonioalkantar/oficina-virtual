package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaCitasDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2872243062389135276L;
	String folio;
	String idDependencia;
	String abreviaturaDependencia;
	String nombreDependencia;
	String nombreTramite;
	String descripcionTramite;
	String domicilioCompleto;
	String idEstatusCita;
	String estatusCitaDesc;
	String fechaHoraInicioDisponible;
	String fechaHoraCita;
	Long idDetalleCitaUsuarioLlavecdmx;

	private String pathImagen;

	public TarjetaCitasDTO() {
	}

	public TarjetaCitasDTO(String folio, String idDependencia, String abreviaturaDependencia, String nombreDependencia,
			String nombreTramite, String descripcionTramite, String domicilioCompleto, String idEstatusCita,
			String estatusCitaDesc, String fechaHoraInicioDisponible, String fechaHoraCita,
			Long idDetalleCitaUsuarioLlavecdmx) {
		this.idDependencia = idDependencia;
		this.abreviaturaDependencia = abreviaturaDependencia;
		this.nombreDependencia = nombreDependencia;
		this.nombreTramite = nombreTramite;
		this.descripcionTramite = descripcionTramite;
		this.domicilioCompleto = domicilioCompleto;
		this.idEstatusCita = idEstatusCita;
		this.estatusCitaDesc = estatusCitaDesc;
		this.fechaHoraInicioDisponible = fechaHoraInicioDisponible;
		this.folio = folio;
		this.fechaHoraCita = fechaHoraCita;
		this.idDetalleCitaUsuarioLlavecdmx = idDetalleCitaUsuarioLlavecdmx;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(String idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getAbreviaturaDependencia() {
		return abreviaturaDependencia;
	}

	public void setAbreviaturaDependencia(String abreviaturaDependencia) {
		this.abreviaturaDependencia = abreviaturaDependencia;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public String getNombreTramite() {
		return nombreTramite;
	}

	public void setNombreTramite(String nombreTramite) {
		this.nombreTramite = nombreTramite;
	}

	public String getDescripcionTramite() {
		return descripcionTramite;
	}

	public void setDescripcionTramite(String descripcionTramite) {
		this.descripcionTramite = descripcionTramite;
	}

	public String getDomicilioCompleto() {
		return domicilioCompleto;
	}

	public void setDomicilioCompleto(String domicilioCompleto) {
		this.domicilioCompleto = domicilioCompleto;
	}

	public String getIdEstatusCita() {
		return idEstatusCita;
	}

	public void setIdEstatusCita(String idEstatusCita) {
		this.idEstatusCita = idEstatusCita;
	}

	public String getEstatusCitaDesc() {
		return estatusCitaDesc;
	}

	public void setEstatusCitaDesc(String estatusCitaDesc) {
		this.estatusCitaDesc = estatusCitaDesc;
	}

	public String getFechaHoraInicioDisponible() {
		return fechaHoraInicioDisponible;
	}

	public void setFechaHoraInicioDisponible(String fechaHoraInicioDisponible) {
		this.fechaHoraInicioDisponible = fechaHoraInicioDisponible;
	}

	public String getFechaHoraCita() {
		return fechaHoraCita;
	}

	public void setFechaHoraCita(String fechaHoraCita) {
		this.fechaHoraCita = fechaHoraCita;
	}

	public Long getIdDetalleCitaUsuarioLlavecdmx() {
		return idDetalleCitaUsuarioLlavecdmx;
	}

	public void setIdDetalleCitaUsuarioLlavecdmx(Long idDetalleCitaUsuarioLlavecdmx) {
		this.idDetalleCitaUsuarioLlavecdmx = idDetalleCitaUsuarioLlavecdmx;
	}

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	
}
