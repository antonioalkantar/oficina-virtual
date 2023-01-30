package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetPlazoMaximoRespuestaDTO implements Serializable {

	private static final long serialVersionUID = -5190623925212467614L;
	private Long id;
	private String articuloLeyReglamentoFicta;
	private Boolean esResolucionInmediata;
	private String otraLeyFicta;
	private CatLeyeDTO catLeyeDTO;
	private CatTipoFictaDTO catTipoFictaDTO;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private TramiteServicioDTO tramiteServicioDTO;
	private Boolean tieneFundamentoResolver;
	private Boolean tieneFundamentoPrevenirSolicitante;
	private Boolean tieneFundamentoCumplirPrevencion;
	private Boolean tieneFundamentoResolucionInmediata;

	
	public DetPlazoMaximoRespuestaDTO() {
		catLeyeDTO = new CatLeyeDTO();
		catTipoFictaDTO = new CatTipoFictaDTO();
		crcFlujoTramiteDTO = new CrcFlujoTramiteDTO();
		tramiteServicioDTO = new TramiteServicioDTO();
		
	}
	
	
	public DetPlazoMaximoRespuestaDTO(Long id,
			Long idTramite, String homoclave, String nombreOficial,  
			String articuloLeyReglamentoFicta, Boolean esResolucionInmediata,
			String otraLeyFicta, Long idLey, String nombreLey, Boolean situacionLey, 
			Long idTipoFicta, String descripcionFicta, Boolean situacionFicta,
			Long idCrcFlujoTramite,
			Boolean tieneFundamentoResolver, Boolean tieneFundamentoPrevenirSolicitante,
			Boolean tieneFundamentoCumplirPrevencion, Boolean tieneFundamentoResolucionInmediata) {
		
		this.id = id;
		this.tramiteServicioDTO =  new TramiteServicioDTO(idTramite, homoclave, nombreOficial);
		this.articuloLeyReglamentoFicta = articuloLeyReglamentoFicta;
		this.esResolucionInmediata = esResolucionInmediata;
		this.otraLeyFicta = otraLeyFicta;
		this.catLeyeDTO = new CatLeyeDTO(idLey,nombreLey, situacionLey);
		this.catTipoFictaDTO = new CatTipoFictaDTO(idTipoFicta, descripcionFicta, situacionFicta);
		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite);
		this.tieneFundamentoResolver = tieneFundamentoResolver;
		this.tieneFundamentoPrevenirSolicitante = tieneFundamentoPrevenirSolicitante;
		this.tieneFundamentoCumplirPrevencion = tieneFundamentoCumplirPrevencion;
		this.tieneFundamentoResolucionInmediata = tieneFundamentoResolucionInmediata;
		
	}
	
	

	public DetPlazoMaximoRespuestaDTO(Long id, Boolean tieneFundamentoCumplirPrevencion,
			Boolean tieneFundamentoPrevenirSolicitante, Boolean tieneFundamentoResolucionInmediata,
			Boolean tieneFundamentoResolver) {
		super();
		this.id = id;
		this.tieneFundamentoCumplirPrevencion = tieneFundamentoCumplirPrevencion;
		this.tieneFundamentoPrevenirSolicitante = tieneFundamentoPrevenirSolicitante;
		this.tieneFundamentoResolucionInmediata = tieneFundamentoResolucionInmediata;
		this.tieneFundamentoResolver = tieneFundamentoResolver;
	}


	public DetPlazoMaximoRespuestaDTO(Long id) {
		this.id = id;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticuloLeyReglamentoFicta() {
		return articuloLeyReglamentoFicta;
	}

	public void setArticuloLeyReglamentoFicta(String articuloLeyReglamentoFicta) {
		this.articuloLeyReglamentoFicta = articuloLeyReglamentoFicta;
	}

	public Boolean getEsResolucionInmediata() {
		return esResolucionInmediata;
	}

	public void setEsResolucionInmediata(Boolean esResolucionInmediata) {
		this.esResolucionInmediata = esResolucionInmediata;
	}

	public String getOtraLeyFicta() {
		return otraLeyFicta;
	}

	public void setOtraLeyFicta(String otraLeyFicta) {
		this.otraLeyFicta = otraLeyFicta;
	}

	public CatLeyeDTO getCatLeyeDTO() {
		return catLeyeDTO;
	}

	public void setCatLeyeDTO(CatLeyeDTO catLeyeDTO) {
		this.catLeyeDTO = catLeyeDTO;
	}

	public CatTipoFictaDTO getCatTipoFictaDTO() {
		return catTipoFictaDTO;
	}

	public void setCatTipoFictaDTO(CatTipoFictaDTO catTipoFictaDTO) {
		this.catTipoFictaDTO = catTipoFictaDTO;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramiteDTO() {
		return crcFlujoTramiteDTO;
	}

	public void setCrcFlujoTramiteDTO(CrcFlujoTramiteDTO crcFlujoTramiteDTO) {
		this.crcFlujoTramiteDTO = crcFlujoTramiteDTO;
	}

	public TramiteServicioDTO getTramiteServicioDTO() {
		return tramiteServicioDTO;
	}

	public void setTramiteServicioDTO(TramiteServicioDTO tramiteServicioDTO) {
		this.tramiteServicioDTO = tramiteServicioDTO;
	}

	public Boolean getTieneFundamentoResolver() {
		return tieneFundamentoResolver;
	}

	public void setTieneFundamentoResolver(Boolean tieneFundamentoResolver) {
		this.tieneFundamentoResolver = tieneFundamentoResolver;
	}

	public Boolean getTieneFundamentoPrevenirSolicitante() {
		return tieneFundamentoPrevenirSolicitante;
	}

	public void setTieneFundamentoPrevenirSolicitante(Boolean tieneFundamentoPrevenirSolicitante) {
		this.tieneFundamentoPrevenirSolicitante = tieneFundamentoPrevenirSolicitante;
	}

	public Boolean getTieneFundamentoCumplirPrevencion() {
		return tieneFundamentoCumplirPrevencion;
	}

	public void setTieneFundamentoCumplirPrevencion(Boolean tieneFundamentoCumplirPrevencion) {
		this.tieneFundamentoCumplirPrevencion = tieneFundamentoCumplirPrevencion;
	}

	public Boolean getTieneFundamentoResolucionInmediata() {
		return tieneFundamentoResolucionInmediata;
	}

	public void setTieneFundamentoResolucionInmediata(Boolean tieneFundamentoResolucionInmediata) {
		this.tieneFundamentoResolucionInmediata = tieneFundamentoResolucionInmediata;
	}
	
}