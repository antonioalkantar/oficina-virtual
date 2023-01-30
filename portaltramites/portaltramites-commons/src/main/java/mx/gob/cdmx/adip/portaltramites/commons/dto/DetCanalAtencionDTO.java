package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class DetCanalAtencionDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905747436822832399L;
	

	
	
	private Long id;
	private String articuloLeyReglamento;
	private String otraLey;
	private Boolean puedeRealizarseDigitalmente;
	private Boolean puedeRealizarsePresencialmente;
	private Boolean puedeRealizarseTelefonicamente;
	private Boolean tieneFundamentoJuridico;
	
	private CatLeyeDTO catLeye;
//	private CatTipoMedioDTO catTipoMedio;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private TramiteServicioDTO tramiteServicio;
	private List<DetLugaresRegistradosDTO> detLugaresRegistrados;
	private List<DetPasosRegistradoDTO> detPasosRegistrados;
	private List<DetPasosRegistradoDTO> detPasosRegistradosTel;
	private List<DetPasosRegistradoDTO> detPasosRegistradosDig;
//	private List<DetTelefonosRegistradosDTO> detTelefonosRegistrados;
//	private List<DetUrlRegistradoDTO> detUrlRegistrados;
	
	//Otros
	
	private DetLugaresRegistradosDTO lugarRegistradoDTO;
//	private DetTelefonosRegistradosDTO telefonoRegistradoDTO;
	
	public DetCanalAtencionDTO() {
		
		lugarRegistradoDTO = new DetLugaresRegistradosDTO();
//		telefonoRegistradoDTO = new DetTelefonosRegistradosDTO();
		catLeye  = new CatLeyeDTO();
		 
		//listas 
		detLugaresRegistrados = new ArrayList<DetLugaresRegistradosDTO>();
		detPasosRegistrados= new ArrayList<DetPasosRegistradoDTO>();;
//		detTelefonosRegistrados= new ArrayList<DetTelefonosRegistradosDTO>();
//		detUrlRegistrados= new ArrayList<DetUrlRegistradoDTO>();
	}
	
	public DetCanalAtencionDTO(Long id) {
		this.id = id;
	}
	
	

	public DetCanalAtencionDTO(Long id,String articuloLeyReglamento, String otraLey,
			Boolean puedeRealizarseDigitalmente, Boolean puedeRealizarsePresencialmente,
			Boolean puedeRealizarseTelefonicamente, Boolean tieneFundamentoJuridico, Long idLey, String nombreLey ) {		
	
		this.id=id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;		
		this.catLeye = new CatLeyeDTO(idLey,nombreLey);
	}
	
	public DetCanalAtencionDTO(Long id,String articuloLeyReglamento, String otraLey,
			Boolean puedeRealizarseDigitalmente, Boolean puedeRealizarsePresencialmente,
			Boolean puedeRealizarseTelefonicamente, Boolean tieneFundamentoJuridico, Long idLey, String nombreLey, Long idMedio, String descMedio ) {		
	
		this.id=id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;		
		this.catLeye = new CatLeyeDTO(idLey,nombreLey);		
//		this.catTipoMedio= new CatTipoMedioDTO(idMedio,descMedio);
	}
	
	public DetCanalAtencionDTO(Long id,String articuloLeyReglamento, String otraLey,
			Boolean puedeRealizarseDigitalmente, Boolean puedeRealizarsePresencialmente,
			Boolean puedeRealizarseTelefonicamente, Boolean tieneFundamentoJuridico, Long idLey, String nombreLey, Long idMedio, String descMedio,Long idTram, Long IfFlujo ) {		
	
		this.id=id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;		
		this.catLeye = new CatLeyeDTO(idLey,nombreLey);		
//		this.catTipoMedio= new CatTipoMedioDTO(idMedio,descMedio);
		
		  this.crcFlujoTramite= new CrcFlujoTramiteDTO(IfFlujo);
		  this.tramiteServicio = new TramiteServicioDTO(idTram);
	}

	
	public DetCanalAtencionDTO(String articuloLeyReglamento, String otraLey,
			Boolean puedeRealizarseDigitalmente, Boolean puedeRealizarsePresencialmente,
			Boolean puedeRealizarseTelefonicamente, Boolean tieneFundamentoJuridico, CatLeyeDTO catLeye,
//			CatTipoMedioDTO catTipoMedio, 
			CrcFlujoTramiteDTO crcFlujoTramite, TramiteServicioDTO tramiteServicio,
			List<DetLugaresRegistradosDTO> detLugaresRegistrados, 
			List<DetPasosRegistradoDTO> detPasosRegistrados,
//			List<DetTelefonosRegistradosDTO> detTelefonosRegistrados, List<DetUrlRegistradoDTO> detUrlRegistrados,
			DetLugaresRegistradosDTO lugarRegistradoDTO
//			, DetTelefonosRegistradosDTO telefonoRegistradoDTO
			) {		
	
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
		this.catLeye = catLeye;
//		this.catTipoMedio = catTipoMedio;
		this.crcFlujoTramite = crcFlujoTramite;
		this.tramiteServicio = tramiteServicio;
		this.detLugaresRegistrados = detLugaresRegistrados;
		this.detPasosRegistrados = detPasosRegistrados;
//		this.detTelefonosRegistrados = detTelefonosRegistrados;
//		this.detUrlRegistrados = detUrlRegistrados;
		this.lugarRegistradoDTO = lugarRegistradoDTO;
//		this.telefonoRegistradoDTO = telefonoRegistradoDTO;
	}
	

	public DetCanalAtencionDTO(Long id, String articuloLeyReglamento, String otraLey,
			Boolean puedeRealizarseDigitalmente, Boolean puedeRealizarsePresencialmente,
			Boolean puedeRealizarseTelefonicamente, Boolean tieneFundamentoJuridico, CatLeyeDTO catLeye,
//			CatTipoMedioDTO  catTipoMedio, 
			CrcFlujoTramiteDTO crcFlujoTramite, TramiteServicioDTO tramiteServicio,
			List<DetLugaresRegistradosDTO> detLugaresRegistrados, 
			List<DetPasosRegistradoDTO> detPasosRegistrados,
//			List<DetTelefonosRegistradosDTO> detTelefonosRegistrados, 
//			List<DetUrlRegistradoDTO> detUrlRegistrados,
			DetLugaresRegistradosDTO lugarRegistradoDTO
//			, DetTelefonosRegistradosDTO telefonoRegistradoDTO
			) {		
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.otraLey = otraLey;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
		this.catLeye = catLeye;
//		this.catTipoMedio = catTipoMedio;
		this.crcFlujoTramite = crcFlujoTramite;
		this.tramiteServicio = tramiteServicio;
		this.detLugaresRegistrados = detLugaresRegistrados;
		this.detPasosRegistrados = detPasosRegistrados;
//		this.detTelefonosRegistrados = detTelefonosRegistrados;
//		this.detUrlRegistrados = detUrlRegistrados;
//		this.lugarRegistradoDTO = lugarRegistradoDTO;
//		this.telefonoRegistradoDTO = telefonoRegistradoDTO;
	}
	
	public DetCanalAtencionDTO(Long id, Boolean puedeRealizarseDigitalmente, Boolean puedeRealizarsePresencialmente,
			Boolean puedeRealizarseTelefonicamente) {
		super();
		this.id = id;
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
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
	public Boolean getPuedeRealizarseDigitalmente() {
		return puedeRealizarseDigitalmente;
	}
	public void setPuedeRealizarseDigitalmente(Boolean puedeRealizarseDigitalmente) {
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
	}
	public Boolean getPuedeRealizarsePresencialmente() {
		return puedeRealizarsePresencialmente;
	}
	public void setPuedeRealizarsePresencialmente(Boolean puedeRealizarsePresencialmente) {
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
	}
	public Boolean getPuedeRealizarseTelefonicamente() {
		return puedeRealizarseTelefonicamente;
	}
	public void setPuedeRealizarseTelefonicamente(Boolean puedeRealizarseTelefonicamente) {
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
	}
	public Boolean getTieneFundamentoJuridico() {
		return tieneFundamentoJuridico;
	}
	public void setTieneFundamentoJuridico(Boolean tieneFundamentoJuridico) {
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
	}
	public CatLeyeDTO getCatLeye() {
		return catLeye;
	}
	public void setCatLeye(CatLeyeDTO catLeye) {
		this.catLeye = catLeye;
	}
//	public CatTipoMedioDTO getCatTipoMedio() {
//		return catTipoMedio;
//	}
//	public void setCatTipoMedio(CatTipoMedioDTO catTipoMedio) {
//		this.catTipoMedio = catTipoMedio;
//	}
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
	public List<DetLugaresRegistradosDTO> getDetLugaresRegistrados() {
		return detLugaresRegistrados;
	}
	public void setDetLugaresRegistrados(List<DetLugaresRegistradosDTO> detLugaresRegistrados) {
		this.detLugaresRegistrados = detLugaresRegistrados;
	}
	public List<DetPasosRegistradoDTO> getDetPasosRegistrados() {
		return detPasosRegistrados;
	}
	public void setDetPasosRegistrados(List<DetPasosRegistradoDTO> detPasosRegistrados) {
		this.detPasosRegistrados = detPasosRegistrados;
	}
//	public List<DetTelefonosRegistradosDTO> getDetTelefonosRegistrados() {
//		return detTelefonosRegistrados;
//	}
//	public void setDetTelefonosRegistrados(List<DetTelefonosRegistradosDTO> detTelefonosRegistrados) {
//		this.detTelefonosRegistrados = detTelefonosRegistrados;
//	}
//	public List<DetUrlRegistradoDTO> getDetUrlRegistrados() {
//		return detUrlRegistrados;
//	}
//	public void setDetUrlRegistrados(List<DetUrlRegistradoDTO> detUrlRegistrados) {
//		this.detUrlRegistrados = detUrlRegistrados;
//	}
//	public DetLugaresRegistradosDTO getLugarRegistradoDTO() {
//		return lugarRegistradoDTO;
//	}
//	public void setLugarRegistradoDTO(DetLugaresRegistradosDTO lugarRegistradoDTO) {
//		this.lugarRegistradoDTO = lugarRegistradoDTO;
//	}
//	public DetTelefonosRegistradosDTO getTelefonoRegistradoDTO() {
//		return telefonoRegistradoDTO;
//	}
//	public void setTelefonoRegistradoDTO(DetTelefonosRegistradosDTO telefonoRegistradoDTO) {
//		this.telefonoRegistradoDTO = telefonoRegistradoDTO;
//	}
//
//
//	public CatTipoMedioDTO getCatTipoMedio() {
//		return catTipoMedio;
//	}
//
//
//	public void setCatTipoMedio(CatTipoMedioDTO catTipoMedio) {
//		this.catTipoMedio = catTipoMedio;
//	}

	public List<DetPasosRegistradoDTO> getDetPasosRegistradosTel() {
		return detPasosRegistradosTel;
	}

	public void setDetPasosRegistradosTel(List<DetPasosRegistradoDTO> detPasosRegistradosTel) {
		this.detPasosRegistradosTel = detPasosRegistradosTel;
	}

	public List<DetPasosRegistradoDTO> getDetPasosRegistradosDig() {
		return detPasosRegistradosDig;
	}

	public void setDetPasosRegistradosDig(List<DetPasosRegistradoDTO> detPasosRegistradosDig) {
		this.detPasosRegistradosDig = detPasosRegistradosDig;
	}
	
	

}
