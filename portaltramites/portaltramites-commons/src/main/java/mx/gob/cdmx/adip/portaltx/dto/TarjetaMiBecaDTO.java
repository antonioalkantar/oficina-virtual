package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;
import java.util.Date;

public class TarjetaMiBecaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idUsuarioCDMX;
	private Integer idEstatusTutor;
	private String descripcionEstatusTutor;	
	private Long idBeneficiario;
	private Integer idEstatus;
	private String descripcionEstatus;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaRegistro;
	private String nombreCompleto;
	private int idEncuesta;
	private String pathImagen;
	
	public TarjetaMiBecaDTO() {
		
	}

	public TarjetaMiBecaDTO(Long idUsuarioCDMX, Integer idEstatusTutor, String descripcionEstatusTutor,
			Long idBeneficiario, Integer idEstatus, String descripcionEstatus, String nombre, String primerApellido,
			String segundoApellido, Date fechaRegistro, int idEncuesta) {
		this.idUsuarioCDMX = idUsuarioCDMX;
		this.idEstatusTutor = idEstatusTutor;
		this.descripcionEstatusTutor = descripcionEstatusTutor;
		this.idBeneficiario = idBeneficiario;
		this.idEstatus = idEstatus;
		this.descripcionEstatus = descripcionEstatus;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaRegistro = fechaRegistro;
		this.idEncuesta = idEncuesta;
	}

	public Long getIdUsuarioCDMX() {
		return idUsuarioCDMX;
	}

	public void setIdUsuarioCDMX(Long idUsuarioCDMX) {
		this.idUsuarioCDMX = idUsuarioCDMX;
	}

	public Integer getIdEstatusTutor() {
		return idEstatusTutor;
	}

	public void setIdEstatusTutor(Integer idEstatusTutor) {
		this.idEstatusTutor = idEstatusTutor;
	}

	public String getDescripcionEstatusTutor() {
		return descripcionEstatusTutor;
	}

	public void setDescripcionEstatusTutor(String descripcionEstatusTutor) {
		this.descripcionEstatusTutor = descripcionEstatusTutor;
	}

	public Long getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}

	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(int idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	
	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	@Override
	public String toString() {
		return "TarjetaMiBecaDTO [idUsuarioCDMX=" + idUsuarioCDMX + ", idEstatusTutor=" + idEstatusTutor
				+ ", descripcionEstatusTutor=" + descripcionEstatusTutor + ", idBeneficiario=" + idBeneficiario
				+ ", idEstatus=" + idEstatus + ", descripcionEstatus=" + descripcionEstatus + ", nombre=" + nombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", fechaRegistro="
				+ fechaRegistro + ", nombreCompleto=" + nombreCompleto + ", idEncuesta=" + idEncuesta + "]";
	}
	
}
