package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetCostoDTO implements Serializable {

	private static final long serialVersionUID = 8897901934351483983L;
	private Long id;
	private int diasVigencia;
	private Boolean seEstableceVigencia;
	private Boolean sePuedeBanco;
	private Boolean sePuedeDependencia;
	private Boolean sePuedeOficina;
	private Boolean sePuedeOnline;
	private Boolean sePuedeOtro;
	private Boolean sePuedeTienda;
	private Boolean situacion;
	private Boolean tieneMontoDerechos;
	private String articuloLeyReglamento;
	private String otraLey;
	private CatMomentoRealizaPagoDTO catMomentoRealizaPagoDTO;
	private CatUnidadeDTO catUnidadeDTO;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private TramiteServicioDTO tramiteServicioDTO;
	private CatLeyeDTO catLeyeDTO;
	private CatTipoConceptoDTO catTipoConceptoDTO;
	private CatFijoOCalculadoDTO catFijoOCalculadoDTO;
	private String metodoCalcular;

	public DetCostoDTO() {
		catMomentoRealizaPagoDTO = new CatMomentoRealizaPagoDTO();
		catUnidadeDTO = new CatUnidadeDTO();
		crcFlujoTramiteDTO = new CrcFlujoTramiteDTO();
		tramiteServicioDTO = new TramiteServicioDTO();
		catLeyeDTO = new CatLeyeDTO();
		catTipoConceptoDTO = new CatTipoConceptoDTO();
		catFijoOCalculadoDTO = new CatFijoOCalculadoDTO();
	}
	
	public DetCostoDTO (Long id, 
			Long idTramite, String homoclave, String nombreOficial,
			Integer diasVigencia, Boolean seEstableceVigencia, Boolean sePuedeBanco, Boolean sePuedeDependencia, Boolean sePuedeOficina, Boolean sePuedeOnline, Boolean sePuedeOtro
				, Boolean sePuedeTienda , Boolean situacion, Boolean tieneMontoDerechos, String articuloLeyReglamento, String otraLey
				, Long idMomento , String descripcionMomento, Boolean situacionMomento
				, Long idUnidades , String descripcionUnidades, Boolean situacionUnidades
				, Long idCrcFlujoTramite
				, Long idLey, String nombreLey, Boolean situacionLey
				, Long idTipoConc , String descripcionTipoConc, Boolean situacionTipoConc
				, Long idFijoCalc , String descripcionFijoCalc, Boolean situacionFijoCalc
				, String metodoCalcular) {
		
		
		this.id = id;
		this.tramiteServicioDTO =  new TramiteServicioDTO(idTramite, homoclave, nombreOficial);
		this.diasVigencia = diasVigencia;
		this.seEstableceVigencia =seEstableceVigencia;
		this.sePuedeBanco = sePuedeBanco;
		this.sePuedeDependencia = sePuedeDependencia;
		this.sePuedeOficina = sePuedeOficina;
		this.sePuedeOnline =sePuedeOnline;
		this.sePuedeOtro = sePuedeOtro;
		this.sePuedeTienda = sePuedeTienda;
		this.situacion = situacion;
		this.tieneMontoDerechos = tieneMontoDerechos;
		this.articuloLeyReglamento =articuloLeyReglamento;
		this.otraLey = otraLey;
		this.catMomentoRealizaPagoDTO = new CatMomentoRealizaPagoDTO(idMomento , descripcionMomento, situacionMomento);
		this.catUnidadeDTO = new CatUnidadeDTO(idUnidades, descripcionUnidades, situacionUnidades);
		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite);
		this.catLeyeDTO = new CatLeyeDTO(idLey,nombreLey, situacionLey);
		this.catTipoConceptoDTO = new CatTipoConceptoDTO(idTipoConc, descripcionTipoConc, situacionTipoConc );
		this.catFijoOCalculadoDTO = new CatFijoOCalculadoDTO(idFijoCalc, descripcionFijoCalc, situacionFijoCalc);
		this.metodoCalcular = metodoCalcular;
		
		
	}	
	
	

	public DetCostoDTO(Long id, Boolean sePuedeBanco, Boolean sePuedeDependencia, Boolean sePuedeOficina,
			Boolean sePuedeOnline, Boolean sePuedeOtro, Boolean sePuedeTienda, Boolean tieneMontoDerechos) {
		super();
		this.id = id;
		this.sePuedeBanco = sePuedeBanco;
		this.sePuedeDependencia = sePuedeDependencia;
		this.sePuedeOficina = sePuedeOficina;
		this.sePuedeOnline = sePuedeOnline;
		this.sePuedeOtro = sePuedeOtro;
		this.sePuedeTienda = sePuedeTienda;
		this.tieneMontoDerechos = tieneMontoDerechos;
	}

	public DetCostoDTO(Long id) {		
		this.id = id;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDiasVigencia() {
		return diasVigencia;
	}

	public void setDiasVigencia(int diasVigencia) {
		this.diasVigencia = diasVigencia;
	}

	public Boolean getSeEstableceVigencia() {
		return seEstableceVigencia;
	}

	public void setSeEstableceVigencia(Boolean seEstableceVigencia) {
		this.seEstableceVigencia = seEstableceVigencia;
	}

	public Boolean getSePuedeBanco() {
		return sePuedeBanco;
	}

	public void setSePuedeBanco(Boolean sePuedeBanco) {
		this.sePuedeBanco = sePuedeBanco;
	}

	public Boolean getSePuedeDependencia() {
		return sePuedeDependencia;
	}

	public void setSePuedeDependencia(Boolean sePuedeDependencia) {
		this.sePuedeDependencia = sePuedeDependencia;
	}

	public Boolean getSePuedeOficina() {
		return sePuedeOficina;
	}

	public void setSePuedeOficina(Boolean sePuedeOficina) {
		this.sePuedeOficina = sePuedeOficina;
	}

	public Boolean getSePuedeOnline() {
		return sePuedeOnline;
	}

	public void setSePuedeOnline(Boolean sePuedeOnline) {
		this.sePuedeOnline = sePuedeOnline;
	}

	public Boolean getSePuedeOtro() {
		return sePuedeOtro;
	}

	public void setSePuedeOtro(Boolean sePuedeOtro) {
		this.sePuedeOtro = sePuedeOtro;
	}

	public Boolean getSePuedeTienda() {
		return sePuedeTienda;
	}

	public void setSePuedeTienda(Boolean sePuedeTienda) {
		this.sePuedeTienda = sePuedeTienda;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public Boolean getTieneMontoDerechos() {
		return tieneMontoDerechos;
	}

	public void setTieneMontoDerechos(Boolean tieneMontoDerechos) {
		this.tieneMontoDerechos = tieneMontoDerechos;
	}

	public CatMomentoRealizaPagoDTO getCatMomentoRealizaPagoDTO() {
		return catMomentoRealizaPagoDTO;
	}

	public void setCatMomentoRealizaPagoDTO(CatMomentoRealizaPagoDTO catMomentoRealizaPagoDTO) {
		this.catMomentoRealizaPagoDTO = catMomentoRealizaPagoDTO;
	}

	public CatUnidadeDTO getCatUnidadeDTO() {
		return catUnidadeDTO;
	}

	public void setCatUnidadeDTO(CatUnidadeDTO catUnidadeDTO) {
		this.catUnidadeDTO = catUnidadeDTO;
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

	public CatLeyeDTO getCatLeyeDTO() {
		return catLeyeDTO;
	}

	public void setCatLeyeDTO(CatLeyeDTO catLeyeDTO) {
		this.catLeyeDTO = catLeyeDTO;
	}

	public CatTipoConceptoDTO getCatTipoConceptoDTO() {
		return catTipoConceptoDTO;
	}

	public void setCatTipoConceptoDTO(CatTipoConceptoDTO catTipoConceptoDTO) {
		this.catTipoConceptoDTO = catTipoConceptoDTO;
	}

	public CatFijoOCalculadoDTO getCatFijoOCalculadoDTO() {
		return catFijoOCalculadoDTO;
	}

	public void setCatFijoOCalculadoDTO(CatFijoOCalculadoDTO catFijoOCalculadoDTO) {
		this.catFijoOCalculadoDTO = catFijoOCalculadoDTO;
	}

	public String getMetodoCalcular() {
		return metodoCalcular;
	}

	public void setMetodoCalcular(String metodoCalcular) {
		this.metodoCalcular = metodoCalcular;
	}
	
	

}
