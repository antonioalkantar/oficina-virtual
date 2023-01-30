package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;

public class DetArchivoFondoDTO implements Serializable {

	private static final long serialVersionUID = -3884683270220225632L;

	private Long id;
	private String nombre_archivo;
	private String ruta_archivo;
	private boolean estatus;
	private boolean situacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private boolean esEscritorio;
	
	// Auxiliares Imagenes Fondo
	private byte[] contentFileImgFondo;
	
	

	public DetArchivoFondoDTO() {
		super();
	}

	public DetArchivoFondoDTO(Long id, String nombre_archivo, String ruta_archivo, boolean estatus, boolean situacion,
			Date fechaCreacion, Date fechaModificacion) {
		super();
		this.id = id;
		this.nombre_archivo = nombre_archivo;
		this.ruta_archivo = ruta_archivo;
		this.estatus = estatus;
		this.situacion = situacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_archivo() {
		return nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}

	public String getRuta_archivo() {
		return ruta_archivo;
	}

	public void setRuta_archivo(String ruta_archivo) {
		this.ruta_archivo = ruta_archivo;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public boolean isSituacion() {
		return situacion;
	}

	public void setSituacion(boolean situacion) {
		this.situacion = situacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public byte[] getContentFileImgFondo() {
		return contentFileImgFondo;
	}

	public void setContentFileImgFondo(byte[] contentFileImgFondo) {
		this.contentFileImgFondo = contentFileImgFondo;
	}
	
	public boolean isEsEscritorio() {
		return esEscritorio;
	}

	public void setEsEscritorio(boolean esEscritorio) {
		this.esEscritorio = esEscritorio;
	}

	public String getNombreImagenCorto() {
		return ruta_archivo == null ? ""
				: ruta_archivo.contains(Constantes.SEPARADOR_RUTA)
						? ruta_archivo.substring(ruta_archivo.lastIndexOf(Constantes.SEPARADOR_RUTA) + 1)
						: ruta_archivo;
	}

}
