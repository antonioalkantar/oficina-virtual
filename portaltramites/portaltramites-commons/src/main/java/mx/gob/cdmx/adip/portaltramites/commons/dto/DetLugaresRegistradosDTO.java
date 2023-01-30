package mx.gob.cdmx.adip.portaltramites.commons.dto;


import java.io.Serializable;
import java.util.List;



public class DetLugaresRegistradosDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775640027383263467L;
	
	private Long id;
	private List<DetHorariosLugareDTO> detHorariosLugares;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetCanalAtencionDTO detCanalAtencion;
	private Boolean situacion;
	private CatAreaAcDTO catAreaAc;
//	
//	//Otros
	private DetHorariosLugareDTO horarioLugarDTO;
	
	public DetLugaresRegistradosDTO() {		
		horarioLugarDTO = new DetHorariosLugareDTO();
		catAreaAc = new CatAreaAcDTO();
	}
	
	public DetLugaresRegistradosDTO(Long id, Long idCanal, Long idTramite, Boolean situacion ,Long idAreaAc, String nomAreaAC) {
		this.id = id;
		this.catAreaAc = new CatAreaAcDTO(idAreaAc,nomAreaAC);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idTramite);
		this.detCanalAtencion = new DetCanalAtencionDTO(idCanal);
		this.situacion = situacion;
	}
	
	public DetLugaresRegistradosDTO(Long idAreaAc, 
			List<DetHorariosLugareDTO> detHorariosLugares,
			CrcFlujoTramiteDTO crcFlujoTramite, DetCanalAtencionDTO detCanalAtencion, Boolean situacion
			,DetHorariosLugareDTO horarioLugarDTO) {
		this.catAreaAc = new CatAreaAcDTO();
		this.detHorariosLugares = detHorariosLugares;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
		this.situacion = situacion;
		this.horarioLugarDTO = horarioLugarDTO;
	}
	
	public DetLugaresRegistradosDTO(Long id, Long idAreaAc,
			List<DetHorariosLugareDTO> detHorariosLugares,
			CrcFlujoTramiteDTO crcFlujoTramite, DetCanalAtencionDTO detCanalAtencion, Boolean situacion
			,DetHorariosLugareDTO horarioLugarDTO) {
		this.id = id;
		this.catAreaAc = new CatAreaAcDTO();
		this.detHorariosLugares = detHorariosLugares;
		this.crcFlujoTramite = crcFlujoTramite;
		this.detCanalAtencion = detCanalAtencion;
		this.situacion = situacion;
		this.horarioLugarDTO = horarioLugarDTO;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public List<DetHorariosLugareDTO> getDetHorariosLugares() {
		return detHorariosLugares;
	}
	public void setDetHorariosLugares(List<DetHorariosLugareDTO> detHorariosLugares) {
		this.detHorariosLugares = detHorariosLugares;
	}
	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}
	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}
	public DetCanalAtencionDTO getDetCanalAtencion() {
		return detCanalAtencion;
	}
	public void setDetCanalAtencion(DetCanalAtencionDTO detCanalAtencion) {
		this.detCanalAtencion = detCanalAtencion;
	}

	public DetHorariosLugareDTO getHorarioLugarDTO() {
		return horarioLugarDTO;
	}

	public void setHorarioLugarDTO(DetHorariosLugareDTO horarioLugarDTO) {
		this.horarioLugarDTO = horarioLugarDTO;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	public CatAreaAcDTO getCatAreaAc() {
		return catAreaAc;
	}

	public void setCatAreaAc(CatAreaAcDTO catAreaAc) {
		this.catAreaAc = catAreaAc;
	}
	
}

