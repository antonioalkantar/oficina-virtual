package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class DetInformacionAdicionalDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9142616876177808865L;

	private Long id;
	private Boolean esRequisitoOtroTramite;
	private String informacionUtil;
//	private CatEstadoEmpresaDTO catEstadoEmpresaDTO;
	private CrcFlujoTramiteDTO crcFlujoTramiteDTO;
	private TramiteServicioDTO tramiteServicioDTO;

	public DetInformacionAdicionalDTO() {
		
	}

	public DetInformacionAdicionalDTO(Long id) {
		this.id = id;
	}

	public DetInformacionAdicionalDTO(Long id, Long idTramite, String homoclave, String nombreOficial,
			Boolean esRequisitoOtroTramite, String informacionUtil, Long idCrcFlujoTramite) {
		this.id = id;
		this.tramiteServicioDTO = new TramiteServicioDTO(idTramite, homoclave, nombreOficial);
//		this.catEstadoEmpresaDTO = new CatEstadoEmpresaDTO(idEstadoEmpresa, descripcionEstadoEmpresa);
		this.esRequisitoOtroTramite = esRequisitoOtroTramite;
		this.informacionUtil = informacionUtil;
//		this.crcFlujoTramiteDTO = new CrcFlujoTramiteDTO(idCrcFlujoTramite); 
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getEsRequisitoOtroTramite() {
		return esRequisitoOtroTramite;
	}
	public void setEsRequisitoOtroTramite(Boolean esRequisitoOtroTramite) {
		this.esRequisitoOtroTramite = esRequisitoOtroTramite;
	}
	public String getInformacionUtil() {
		return informacionUtil;
	}
	public void setInformacionUtil(String informacionUtil) {
		this.informacionUtil = informacionUtil;
	}
//	public CatEstadoEmpresaDTO getCatEstadoEmpresaDTO() {
//		return catEstadoEmpresaDTO;
//	}
//	public void setCatEstadoEmpresaDTO(CatEstadoEmpresaDTO catEstadoEmpresaDTO) {
//		this.catEstadoEmpresaDTO = catEstadoEmpresaDTO;
//	}
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

}
