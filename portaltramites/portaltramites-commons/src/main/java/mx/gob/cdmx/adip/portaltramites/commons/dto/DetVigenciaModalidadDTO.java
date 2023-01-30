package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetVigenciaModalidadDTO implements Serializable {

	private static final long serialVersionUID = -8010706404327993784L;
	private Long id;
	private String articuloLeyReglamento;
	private String otraLey;
	private Integer vigencia;
	private CatLeyeDTO catLeye;
	private CatUnidadeDTO catUnidade;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetModalidadesTramiteDTO detModalidadesTramite;
	private Integer vigenciaSuperior;
	private CatVigenciaDTO catVigencia;
	private String especificaOtra;
	
	public DetVigenciaModalidadDTO() {
		catLeye = new CatLeyeDTO();
		catUnidade = new CatUnidadeDTO();
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		detModalidadesTramite = new DetModalidadesTramiteDTO();
		catVigencia = new CatVigenciaDTO();
	}
	
	public DetVigenciaModalidadDTO(Long id, String articuloLeyReglamento, String otraLey, Integer vigencia,
			Long idLey, Long idUnidad, Long idFlujoTramite, Long idModalidadesTramite) {
		super();
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.vigencia = vigencia;
		this.catLeye = new CatLeyeDTO(idLey);
		this.catUnidade = new CatUnidadeDTO(idUnidad, null, null);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detModalidadesTramite = new DetModalidadesTramiteDTO(idModalidadesTramite);
	}
	
	public DetVigenciaModalidadDTO(Long id, String articuloLeyReglamento, String otraLey, Integer vigencia,
			Long idLey, String nombreLey, Long idUnidad, String descUnidad, Long idFlujoTramite, Long idModalidadesTramite,
			Long idVigencia, String descVigencia, Integer vigenciaSuperior, String especificaOtra) {
		super();
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.vigencia = vigencia;
		this.catLeye = new CatLeyeDTO(idLey, nombreLey, null);
		this.catUnidade = new CatUnidadeDTO(idUnidad, descUnidad, null);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detModalidadesTramite = new DetModalidadesTramiteDTO(idModalidadesTramite);
		this.catVigencia = new CatVigenciaDTO(idVigencia, descVigencia);
		this.vigenciaSuperior = vigenciaSuperior;
		this.especificaOtra = especificaOtra;
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

	public CatUnidadeDTO getCatUnidade() {
		return catUnidade;
	}

	public void setCatUnidade(CatUnidadeDTO catUnidade) {
		this.catUnidade = catUnidade;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	public DetModalidadesTramiteDTO getDetModalidadesTramite() {
		return detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramiteDTO detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	public Integer getVigenciaSuperior() {
		return vigenciaSuperior;
	}

	public void setVigenciaSuperior(Integer vigenciaSuperior) {
		this.vigenciaSuperior = vigenciaSuperior;
	}

	public CatVigenciaDTO getCatVigencia() {
		return catVigencia;
	}

	public void setCatVigencia(CatVigenciaDTO catVigencia) {
		this.catVigencia = catVigencia;
	}

	public String getEspecificaOtra() {
		return especificaOtra;
	}

	public void setEspecificaOtra(String especificaOtra) {
		this.especificaOtra = especificaOtra;
	}

}
