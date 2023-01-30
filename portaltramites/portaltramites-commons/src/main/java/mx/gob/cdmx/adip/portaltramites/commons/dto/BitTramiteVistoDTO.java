package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.util.Date;

public class BitTramiteVistoDTO implements Serializable{
	
	private static final long serialVersionUID = -7202695356617286685L;
	private Long idBitacoraTramiteVisto;
	private Long idTramiteServicio;
	private String tituloTramite;
	private CatOrigenConsultaDTO catOrigenConsultaDTO;
	private Date fechaConsulta;
	
	public BitTramiteVistoDTO() {
	}
	
	public BitTramiteVistoDTO(Long idBitacoraTramiteVisto, Long idTramiteServicio, String tituloTramite,
			CatOrigenConsultaDTO catOrigenConsultaDTO, Date fechaConsulta) {
		this.idBitacoraTramiteVisto = idBitacoraTramiteVisto;
		this.idTramiteServicio = idTramiteServicio;
		this.tituloTramite = tituloTramite;
		this.catOrigenConsultaDTO = catOrigenConsultaDTO;
		this.fechaConsulta = fechaConsulta;
	}
	
	public Long getIdBitacoraTramiteVisto() {
		return idBitacoraTramiteVisto;
	}
	public void setIdBitacoraTramiteVisto(Long idBitacoraTramiteVisto) {
		this.idBitacoraTramiteVisto = idBitacoraTramiteVisto;
	}
	public Long getIdTramiteServicio() {
		return idTramiteServicio;
	}
	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}
	public String getTituloTramite() {
		return tituloTramite;
	}
	public void setTituloTramite(String tituloTramite) {
		this.tituloTramite = tituloTramite;
	}
	public Date getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public CatOrigenConsultaDTO getCatOrigenConsultaDTO() {
		return catOrigenConsultaDTO;
	}
	public void setCatOrigenConsultaDTO(CatOrigenConsultaDTO catOrigenConsultaDTO) {
		this.catOrigenConsultaDTO = catOrigenConsultaDTO;
	}
}
