package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;

public class AnunciosDTO implements Serializable {

	private static final long serialVersionUID = -3805308045121216228L;

	private Long idAnuncio;
	private String titulo;
	private String descripcion;
	private String link;
	private String imagen;
	private Integer orden;
	private Boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean situacion;
	// Auxiliares documentos
	private byte[] contentFileTarjetaAnuncio;


	public AnunciosDTO() {

	}
	
	public AnunciosDTO(Long idAnuncio, String titulo, String descripcion, String link, String imagen, Integer orden,
			Boolean activo, Boolean situacion) {
		this.idAnuncio = idAnuncio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.link = link;
		this.imagen = imagen;
		this.orden = orden;	
		this.activo = activo;
		this.situacion = situacion;
	}

	public Long getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
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

	public byte[] getContentFileTarjetaAnuncio() {
		return contentFileTarjetaAnuncio;
	}

	public void setContentFileTarjetaAnuncio(byte[] contentFileTarjetaAnuncio) {
		this.contentFileTarjetaAnuncio = contentFileTarjetaAnuncio;
	}

	public String getNombreImagenCorto() {
		return imagen == null ? ""
				: imagen.contains(Constantes.SEPARADOR_RUTA)
						? imagen.substring(imagen.lastIndexOf(Constantes.SEPARADOR_RUTA) + 1)
						: imagen;
	}

}
