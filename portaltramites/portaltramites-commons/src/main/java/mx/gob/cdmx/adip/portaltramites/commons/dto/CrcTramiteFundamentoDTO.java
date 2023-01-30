package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CrcTramiteFundamentoDTO implements Serializable {

	private static final long serialVersionUID = 163735965191936392L;
	private Long id;
	private String articuloLey;
	private String otraLey;
	private CatLeyeDTO catLeye;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private TramiteServicioDTO tramiteServicio;

	public CrcTramiteFundamentoDTO() {
		catLeye = new CatLeyeDTO();
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		tramiteServicio = new TramiteServicioDTO();
	}
	
	
	public CrcTramiteFundamentoDTO(Long id, Long idLey, String NombreLey, Boolean sitLey, String articuloLey, String otraLey,
			Long idtramiteServicio, Long idFlujoTramite) {
		this.id = id;
		this.catLeye = new CatLeyeDTO(idLey, NombreLey, sitLey);		
		this.articuloLey = articuloLey;
		this.otraLey = otraLey;
		this.tramiteServicio = new TramiteServicioDTO(idtramiteServicio);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		
	}

	public CrcTramiteFundamentoDTO(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticuloLey() {
		return articuloLey;
	}

	public void setArticuloLey(String articuloLey) {
		this.articuloLey = articuloLey;
	}

	public String getOtraLey() {
		return otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
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
	
}
