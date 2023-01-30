package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetMedioBancoDTO implements Serializable {

	private static final long serialVersionUID = 5890277782918437964L;

	private Long id;
	private String articuloLeyReglamento;
	private String comoRealizaPago;
	private String nombre;
	private String numerosReferencia;
	private String otraLey;
	private Boolean situacion;
	private CatLeyeDTO catLeyeDTO;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private DetCostoDTO detCostoDTO;

	public DetMedioBancoDTO() {
		catLeyeDTO = new CatLeyeDTO();
		crcFlujoTramiteDTO = new CrcFlujoTramiteDTO();
		detCostoDTO = new DetCostoDTO();
		
	}

	public DetMedioBancoDTO(Long id, String articuloLeyReglamento, String comoRealizaPago, String nombre,
			String numerosReferencia, String otraLey, Boolean situacion, 
			Long idLey, String descripcionLey, Boolean situacionLey, 
			Long idCrcFlujoTramite, Long idCostos) {

		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.comoRealizaPago = comoRealizaPago;
		this.nombre = nombre;
		this.numerosReferencia = numerosReferencia;
		this.otraLey = otraLey;
		this.situacion = situacion;
		this.catLeyeDTO = new CatLeyeDTO(idLey, descripcionLey, situacionLey);
		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite);
		this.detCostoDTO = new DetCostoDTO(idCostos);
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

	public String getComoRealizaPago() {
		return comoRealizaPago;
	}

	public void setComoRealizaPago(String comoRealizaPago) {
		this.comoRealizaPago = comoRealizaPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumerosReferencia() {
		return numerosReferencia;
	}

	public void setNumerosReferencia(String numerosReferencia) {
		this.numerosReferencia = numerosReferencia;
	}

	public String getOtraLey() {
		return otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public CatLeyeDTO getCatLeyeDTO() {
		return catLeyeDTO;
	}

	public void setCatLeyeDTO(CatLeyeDTO catLeyeDTO) {
		this.catLeyeDTO = catLeyeDTO;
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

}
