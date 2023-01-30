package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatMetroLineaDTO implements Serializable{


	private static final long serialVersionUID = -9076115540658006359L;
	
	private Long id;
	private String idLinea;
	private String nombreLinea;
	private String colorLinea;
	private String direccionuno;
	private String direcciondos;
	private Boolean situacion;
	
	public CatMetroLineaDTO() {}
	
	
	
	
	public CatMetroLineaDTO(Long id, String idLinea, String nombreLinea, String colorLinea, String direccionuno,
			String direcciondos) {		
		this.id = id;
		this.idLinea = idLinea;
		this.nombreLinea = nombreLinea;
		this.colorLinea = colorLinea;
		this.direccionuno = direccionuno;
		this.direcciondos = direcciondos;
	}
	
	public CatMetroLineaDTO(Long id, String idLinea, String nombreLinea, String colorLinea, String direccionuno,
			String direcciondos,Boolean situacion) {		
		this.id = id;
		this.idLinea = idLinea;
		this.nombreLinea = nombreLinea;
		this.colorLinea = colorLinea;
		this.direccionuno = direccionuno;
		this.direcciondos = direcciondos;
		this.situacion = situacion;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(String idLinea) {
		this.idLinea = idLinea;
	}
	public String getNombreLinea() {
		return nombreLinea;
	}
	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}
	public String getColorLinea() {
		return colorLinea;
	}
	public void setColorLinea(String colorLinea) {
		this.colorLinea = colorLinea;
	}
	public String getDireccionuno() {
		return direccionuno;
	}
	public void setDireccionuno(String direccionuno) {
		this.direccionuno = direccionuno;
	}
	public String getDirecciondos() {
		return direcciondos;
	}
	public void setDirecciondos(String direcciondos) {
		this.direcciondos = direcciondos;
	}




	public Boolean getSituacion() {
		return situacion;
	}




	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
}
