package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class DetMedioDependenciaDTO implements Serializable {

	private static final long serialVersionUID = 6874645667180044241L;

	private Long id;
	private String articuloLeyReglamento;
	private String calle;
	private String numeroExterior;
	private String numeroInterior;
	private String numeroReferencia;
	private String otraLey;
	private Boolean situacion;
	private CatAlcaldiaDTO catAlcaldiaDTO;
	private CatAsentamientosDTO catAsentamientosDTO;
	private CatCodigosPostalesDTO catCodigosPostalesDTO;
	private CatLeyeDTO catLeyeDTO;
	private CatTipoVialidadDTO catTipoVialidadDTO;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private DetCostoDTO detCostoDTO;

	public DetMedioDependenciaDTO() {		
		catTipoVialidadDTO = new CatTipoVialidadDTO();
		catLeyeDTO = new CatLeyeDTO();
		catAlcaldiaDTO = new CatAlcaldiaDTO();
		catAsentamientosDTO = new CatAsentamientosDTO();
		catCodigosPostalesDTO = new CatCodigosPostalesDTO();
		crcFlujoTramiteDTO = new CrcFlujoTramiteDTO();
		detCostoDTO = new DetCostoDTO();
	}	

	public DetMedioDependenciaDTO(Long id) {		
		this.id = id;
	}		
	
	public DetMedioDependenciaDTO(Long id, String articuloLeyReglamento, String calle, String numeroExterior,
			String numeroInterior, String numeroReferencia, String otraLey, Boolean situacion,			 
			Integer idAlcaldia, Integer idEstado, Integer idMunicipioPorEstado, String municipio, 
			Integer idAsentamiento , String descripcion, 
			Integer idCodigoPostal, String codigoPostal, 
			Long idTipoVialidad, String descripcionVialidad, Long idCrcFlujoTramite,		
			Long idCostos, 
			Long idLey, String descripcionLey, Boolean situacionLey ) {
		
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.calle = calle;
		this.numeroExterior = numeroExterior;
		this.numeroInterior = numeroInterior;
		this.numeroReferencia = numeroReferencia;
		this.otraLey = otraLey;
		this.situacion = situacion;
		this.catAlcaldiaDTO = new CatAlcaldiaDTO(idAlcaldia, idEstado, idMunicipioPorEstado, municipio);
		this.catAsentamientosDTO = new CatAsentamientosDTO(idAsentamiento, descripcion);
		this.catCodigosPostalesDTO = new CatCodigosPostalesDTO(idCodigoPostal, codigoPostal);		
		this.catTipoVialidadDTO = new CatTipoVialidadDTO(idTipoVialidad, descripcionVialidad);
		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite);
		this.detCostoDTO = new DetCostoDTO(idCostos);
		this.catLeyeDTO = new CatLeyeDTO(idLey, descripcionLey, situacionLey);
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticuloLeyReglamento() {
		return articuloLeyReglamento;
	}

	public void setArticuloLeyReglamento(String articuloLeyReglamento) {
		this.articuloLeyReglamento = articuloLeyReglamento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public String getOtraLey() {
		return otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}

	public CatAlcaldiaDTO getCatAlcaldiaDTO() {
		return catAlcaldiaDTO;
	}

	public void setCatAlcaldiaDTO(CatAlcaldiaDTO catAlcaldiaDTO) {
		this.catAlcaldiaDTO = catAlcaldiaDTO;
	}

	public CatAsentamientosDTO getCatAsentamientosDTO() {
		return catAsentamientosDTO;
	}

	public void setCatAsentamientosDTO(CatAsentamientosDTO catAsentamientosDTO) {
		this.catAsentamientosDTO = catAsentamientosDTO;
	}

	public CatCodigosPostalesDTO getCatCodigosPostalesDTO() {
		return catCodigosPostalesDTO;
	}

	public void setCatCodigosPostalesDTO(CatCodigosPostalesDTO catCodigosPostalesDTO) {
		this.catCodigosPostalesDTO = catCodigosPostalesDTO;
	}

	public CatLeyeDTO getCatLeyeDTO() {
		return catLeyeDTO;
	}

	public void setCatLeyeDTO(CatLeyeDTO catLeyeDTO) {
		this.catLeyeDTO = catLeyeDTO;
	}

	public CatTipoVialidadDTO getCatTipoVialidadDTO() {
		return catTipoVialidadDTO;
	}

	public void setCatTipoVialidadDTO(CatTipoVialidadDTO catTipoVialidadDTO) {
		this.catTipoVialidadDTO = catTipoVialidadDTO;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramiteDTO() {
		return crcFlujoTramiteDTO;
	}

	public void setCrcFlujoTramiteDTO(CrcFlujoTramiteDTO crcFlujoTramiteDTO) {
		this.crcFlujoTramiteDTO = crcFlujoTramiteDTO;
	}

	public DetCostoDTO getDetCostoDTO() {
		return detCostoDTO;
	}

	public void setDetCostoDTO(DetCostoDTO detCostoDTO) {
		this.detCostoDTO = detCostoDTO;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
