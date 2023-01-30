package mx.gob.cdmx.adip.portaltramites.commons.dto;


public class DetRequisitosFormatoDTO {

	private Long id;
	private String articuloLeyReglamento;
	private String detalleRequisito;
	private String otraLey;
	private Boolean parteDelFormato;
	private CatLeyeDTO catLeye;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetFormatoDTO detFormato;
	private Boolean situacion;
	
	
	public DetRequisitosFormatoDTO(){
		catLeye = new CatLeyeDTO();
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		detFormato = new DetFormatoDTO();
	}
	
	
	
	public DetRequisitosFormatoDTO(Long id,String articuloLeyReglamento, String otraLey,  Boolean parteDelFormato,
			String detalleRequisito,Long catLeyeid, String catNombre, Long idFormato, Long idFlujoTramite){
	this.id = id;
	this.articuloLeyReglamento = articuloLeyReglamento;
	this.otraLey = otraLey;
	this.parteDelFormato = parteDelFormato;
	this.detalleRequisito = detalleRequisito;
	this.catLeye = new CatLeyeDTO(catLeyeid,catNombre,Boolean.TRUE);
	this.detFormato = new DetFormatoDTO(idFormato);
	this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
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
	public String getDetalleRequisito() {
		return detalleRequisito;
	}
	public void setDetalleRequisito(String detalleRequisito) {
		this.detalleRequisito = detalleRequisito;
	}
	public String getOtraLey() {
		return otraLey;
	}
	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}
	public Boolean getParteDelFormato() {
		return parteDelFormato;
	}
	public void setParteDelFormato(Boolean parteDelFormato) {
		this.parteDelFormato = parteDelFormato;
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
	public DetFormatoDTO getDetFormato() {
		return detFormato;
	}
	public void setDetFormato(DetFormatoDTO detFormato) {
		this.detFormato = detFormato;
	}


	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}	
	
}
