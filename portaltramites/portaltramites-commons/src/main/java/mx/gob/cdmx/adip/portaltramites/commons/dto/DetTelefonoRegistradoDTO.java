package mx.gob.cdmx.adip.portaltramites.commons.dto;


import java.io.Serializable;



public class DetTelefonoRegistradoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905747436822832399L;
	
	
	private Long id;
	private String extensionTel;
	private String numeroTelefono;
	private CatAreaAcDTO catAreaAc;
	private Boolean situacion;
	private Long idArea;
	
	public DetTelefonoRegistradoDTO() {}
	
	
	public DetTelefonoRegistradoDTO(String extensionTel, String numeroTelefono, CatAreaAcDTO catAreaAc) {
		
		
		this.extensionTel = extensionTel;
		this.numeroTelefono = numeroTelefono;
		this.catAreaAc = catAreaAc;
	}
	
	public DetTelefonoRegistradoDTO(Long id, String extensionTel, String numeroTelefono, CatAreaAcDTO catAreaAc) {
	
		this.id = id;
		this.extensionTel = extensionTel;
		this.numeroTelefono = numeroTelefono;
		this.catAreaAc = catAreaAc;
	}
	public DetTelefonoRegistradoDTO(Long id, String extensionTel, String numeroTelefono, Long idArea) {
		this.id = id;
		this.extensionTel = extensionTel;
		this.numeroTelefono = numeroTelefono;
		this.idArea = idArea;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExtensionTel() {
		return extensionTel;
	}
	public void setExtensionTel(String extensionTel) {
		this.extensionTel = extensionTel;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public CatAreaAcDTO getCatAreaAc() {
		return catAreaAc;
	}
	public void setCatAreaAc(CatAreaAcDTO catAreaAc) {
		this.catAreaAc = catAreaAc;
	}


	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	public Long getIdArea() {
		return idArea;
	}


	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}
	
	
	
}
