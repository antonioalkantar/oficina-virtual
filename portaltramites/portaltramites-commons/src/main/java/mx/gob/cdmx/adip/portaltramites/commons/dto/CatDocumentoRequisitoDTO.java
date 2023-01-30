package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatDocumentoRequisitoDTO implements Serializable {

	private static final long serialVersionUID = 2786429778550549952L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private CatTipoDocumentoDTO catTipoDocumento;

	public CatDocumentoRequisitoDTO() {
		catTipoDocumento = new CatTipoDocumentoDTO();
	}

	public CatDocumentoRequisitoDTO(Long id, String descripcion, Boolean situacion,
			Long idTipoDoc
			, String descTipoDoc
			, Boolean sitTipoDoc) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
		this.catTipoDocumento = new CatTipoDocumentoDTO(idTipoDoc, descTipoDoc, sitTipoDoc);
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

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public CatTipoDocumentoDTO getCatTipoDocumento() {
		return catTipoDocumento;
	}

	public void setCatTipoDocumento(CatTipoDocumentoDTO catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
	}

}
