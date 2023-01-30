package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;



public class DetVigenciaDTO  implements Serializable{

	private static final long serialVersionUID = -1485829898633575177L;
	
	private Long id;
	private String articuloLeyReglamento;
	private Long idVigencia;
	private String otraLey;
	private Boolean tieneFundamentoJuridico;
	private Boolean tieneVigencia;
	private Integer vigencia;
	private Integer vigenciaSuperior;
	private String especificaOtraVigencia;
	private CatLeyeDTO catLeye;
	private CatUnidadeDTO catUnidadeDTO;
	private CatVigenciaDTO catVigenciaDTO;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private TramiteServicioDTO tramiteServicio;
	
		
	public DetVigenciaDTO() {
		catLeye = new CatLeyeDTO();
		catVigenciaDTO = new CatVigenciaDTO();
		catUnidadeDTO = new CatUnidadeDTO();
	}
	
	public DetVigenciaDTO(Long id) {
		this.id = id;		
	}
	
	
	public DetVigenciaDTO(Long id, Long idTramite, String homoclave, String nombreOficial,  Long idCrcFlujoTramite,
			String articuloLeyReglamento, String otraLey,
			Boolean tieneFundamentoJuridico, Boolean tieneVigencia, Integer vigencia, Long idCatley, String descripcionLey,
			Long idCatVigencia, String descripcionCatVigencia, Integer vigenciaSuperior, String especificaOtra,
			Long idCatUnidades, String descripcionUnidades, Boolean situacionUnidades) {
		
		this.id = id;
		this.tramiteServicio = new TramiteServicioDTO(idTramite, homoclave, nombreOficial);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idCrcFlujoTramite); 
		this.articuloLeyReglamento = articuloLeyReglamento;		
		this.otraLey = otraLey;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
		this.tieneVigencia = tieneVigencia;
		this.vigencia = vigencia;
		this.catLeye = new CatLeyeDTO(idCatley , descripcionLey);
		this.catVigenciaDTO = new CatVigenciaDTO(idCatVigencia , descripcionCatVigencia);
		this.vigenciaSuperior = vigenciaSuperior;
		this.especificaOtraVigencia = especificaOtra;
		this.catUnidadeDTO = new CatUnidadeDTO(idCatUnidades , descripcionUnidades, situacionUnidades);
		
	}
	
	public DetVigenciaDTO(Long id,  String articuloLeyReglamento, Long idVigencia, String otraLey,
			Boolean tieneFundamentoJuridico, Boolean tieneVigencia, Integer vigencia,Long idCatley) {
		
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.idVigencia = idVigencia;
		this.otraLey = otraLey;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
		this.tieneVigencia = tieneVigencia;
		this.vigencia = vigencia;
		this.catLeye = new CatLeyeDTO(idCatley);
		
	}
		
	public DetVigenciaDTO(Long id, String articuloLeyReglamento, Long idVigencia, String otraLey,
			Boolean tieneFundamentoJuridico, Boolean tieneVigencia, Integer vigencia, CatLeyeDTO catLeye,
			CrcFlujoTramiteDTO crcFlujoTramite, TramiteServicioDTO tramiteServicio) {
		
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.idVigencia = idVigencia;
		this.otraLey = otraLey;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
		this.tieneVigencia = tieneVigencia;
		this.vigencia = vigencia;
		this.catLeye = catLeye;
		this.crcFlujoTramite = crcFlujoTramite;
		this.tramiteServicio = tramiteServicio;
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

	public String getOtraLey() {
		return otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}

	public Boolean getTieneFundamentoJuridico() {
		return tieneFundamentoJuridico;
	}

	public void setTieneFundamentoJuridico(Boolean tieneFundamentoJuridico) {
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
	}

	public Boolean getTieneVigencia() {
		return tieneVigencia;
	}

	public void setTieneVigencia(Boolean tieneVigencia) {
		this.tieneVigencia = tieneVigencia;
	}

	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}

	public CatLeyeDTO getCatLeye() {
		return catLeye;
	}

	public void setCatLeye(CatLeyeDTO catLeye) {
		this.catLeye = catLeye;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	public TramiteServicioDTO getTramiteServicio() {
		return tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicioDTO tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	public Long getIdVigencia() {
		return idVigencia;
	}

	public void setIdVigencia(Long idVigencia) {
		this.idVigencia = idVigencia;
	}

	public Integer getVigenciaSuperior() {
		return vigenciaSuperior;
	}

	public void setVigenciaSuperior(Integer vigenciaSuperior) {
		this.vigenciaSuperior = vigenciaSuperior;
	}

	public String getEspecificaOtraVigencia() {
		return especificaOtraVigencia;
	}

	public void setEspecificaOtraVigencia(String especificaOtraVigencia) {
		this.especificaOtraVigencia = especificaOtraVigencia;
	}

	public CatUnidadeDTO getCatUnidadeDTO() {
		return catUnidadeDTO;
	}

	public void setCatUnidadeDTO(CatUnidadeDTO catUnidadeDTO) {
		this.catUnidadeDTO = catUnidadeDTO;
	}

	public CatVigenciaDTO getCatVigenciaDTO() {
		return catVigenciaDTO;
	}

	public void setCatVigenciaDTO(CatVigenciaDTO catVigenciaDTO) {
		this.catVigenciaDTO = catVigenciaDTO;
	}

}
