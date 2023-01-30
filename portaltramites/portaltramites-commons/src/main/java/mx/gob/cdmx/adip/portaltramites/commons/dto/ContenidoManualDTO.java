package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;


public class ContenidoManualDTO  implements Serializable {

	private static final long serialVersionUID = 954340188540360104L;
	
	private Long idContenido;
	private CatDependenciasDTO catDependenciasDTO;
	private CatTemaDTO catTemaDTO;
	private String titulo;
	private String descripcion;
	private String link;
	private Integer orden;
	private Boolean activo;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Boolean situacion;
	private String palabrasClave;

	public ContenidoManualDTO() {
		catDependenciasDTO = new CatDependenciasDTO();
		catTemaDTO = new CatTemaDTO();
	}

	/**
	 * @param idContenido
	 * @param catDependenciasDTO
	 * @param catTemaDTO
	 * @param titulo
	 * @param descripcion
	 * @param link
	 * @param orden
	 * @param activo
	 * @param fechaCreacion
	 * @param fechaModificacion
	 * @param situacion
	 */
	public ContenidoManualDTO(Long idContenido, String titulo, String descripcion, String link, Boolean activo, Date fechaCreacion,
							 Boolean situacion, Long idDependencia, String nombreDependencia, Boolean situacionDep,
							 Long idCatTema, String descripcionTema, Boolean situacionTema, String palabrasClave ) {
		
		this.idContenido = idContenido;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.link = link;
		this.activo = activo;
		this.fechaCreacion = fechaCreacion;
		this.situacion = situacion;		
		this.catDependenciasDTO = new CatDependenciasDTO(idDependencia, nombreDependencia, situacionDep);
		this.catTemaDTO = new CatTemaDTO(idCatTema, descripcionTema, situacionTema);
		this.palabrasClave = palabrasClave;
	}
	
	public ContenidoManualDTO (String titulo, String descripcion, String link, String palabrasClave,
			Long idDependencia, String nombreDependencia, Long idCatTema, String descripcionTema) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.link = link;
		this.palabrasClave = palabrasClave;
		this.catDependenciasDTO = new CatDependenciasDTO(idDependencia, nombreDependencia);
		this.catTemaDTO = new CatTemaDTO(idCatTema, descripcionTema);		
	}


	public Long getIdContenido() {
		return idContenido;
	}

	public void setIdContenido(Long idContenido) {
		this.idContenido = idContenido;
	}

	public CatDependenciasDTO getCatDependenciasDTO() {
		return catDependenciasDTO;
	}

	public void setCatDependenciasDTO(CatDependenciasDTO catDependenciasDTO) {
		this.catDependenciasDTO = catDependenciasDTO;
	}

	public CatTemaDTO getCatTemaDTO() {
		return catTemaDTO;
	}

	public void setCatTemaDTO(CatTemaDTO catTemaDTO) {
		this.catTemaDTO = catTemaDTO;
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

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

}
