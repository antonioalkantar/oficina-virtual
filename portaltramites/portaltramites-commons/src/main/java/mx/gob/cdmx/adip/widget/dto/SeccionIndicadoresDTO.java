package mx.gob.cdmx.adip.widget.dto;

import java.util.List;

import mx.gob.cdmx.adip.portaltramites.commons.dto.CatMetroEstacionesDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatMetroLineaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.MetroRespuestaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ServicioGralDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ServicioHoyNoCirculaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ServicioLineaMetroDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ServicioVerificacionDTO;

import java.io.Serializable;
import java.util.Date;

public class SeccionIndicadoresDTO implements Serializable{

	private static final long serialVersionUID = 942625319559004197L;
	
	private ServicioGralClimaDTO servicioClima;
	
	private ServicioGralDTO servicioGral;	
	private List<ServicioLineaMetroDTO> lstservicioMetro;
	private List<ServicioLineaMetroDTO> lstservicioMetrosinFun;
	private List<ServicioHoyNoCirculaDTO> lstNoCircula;
	private List<ServicioHoyNoCirculaDTO> lstNoCirculaProxSabado;
	private String msgProxSabado;
	private List<ServicioVerificacionDTO> lstVerificacion;
	private Date fechaActual;
	private String fecha;
	private String fechasVerificacion;
	private HoyNoCirculaDTO hoyNoCircula;
	
	//METRO
	private List<CatMetroLineaDTO> lstLineasMetro;	
	private List<CatMetroEstacionesDTO> metroEstaciones;
	private CatMetroLineaDTO selLineaMetro;
	private CatMetroEstacionesDTO selEstacionMetro;
	private MetroRespuestaDTO respuestaEstacionMetro;
	
	//SEMAFORO EPIDEMIOLOGICO
	private ServicioSemaforoEpDTO semaforoEpi;
	
	
	public SeccionIndicadoresDTO() {
		selEstacionMetro = new CatMetroEstacionesDTO();
		respuestaEstacionMetro = new MetroRespuestaDTO();
		servicioClima = new ServicioGralClimaDTO();
	}
	
	/*public List<CarouselDTO> getImagesCaroussel() {
		return imagesCaroussel;
	}
	public void setImagesCaroussel(List<CarouselDTO> imagesCaroussel) {
		this.imagesCaroussel = imagesCaroussel;
	}*/
	
	public ServicioGralClimaDTO getServicioClima() {
		return servicioClima;
	}
	public void setServicioClima(ServicioGralClimaDTO servicioClima) {
		this.servicioClima = servicioClima;
	}
	public ServicioGralDTO getServicioGral() {
		return servicioGral;
	}
	public void setServicioGral(ServicioGralDTO servicioGral) {
		this.servicioGral = servicioGral;
	}
	public List<ServicioLineaMetroDTO> getLstservicioMetro() {
		return lstservicioMetro;
	}
	public void setLstservicioMetro(List<ServicioLineaMetroDTO> lstservicioMetro) {
		this.lstservicioMetro = lstservicioMetro;
	}
	public List<ServicioLineaMetroDTO> getLstservicioMetrosinFun() {
		return lstservicioMetrosinFun;
	}
	public void setLstservicioMetrosinFun(List<ServicioLineaMetroDTO> lstservicioMetrosinFun) {
		this.lstservicioMetrosinFun = lstservicioMetrosinFun;
	}

	public List<ServicioVerificacionDTO> getLstVerificacion() {
		return lstVerificacion;
	}
	public void setLstVerificacion(List<ServicioVerificacionDTO> lstVerificacion) {
		this.lstVerificacion = lstVerificacion;
	}

	public List<ServicioHoyNoCirculaDTO> getLstNoCircula() {
		return lstNoCircula;
	}

	public void setLstNoCircula(List<ServicioHoyNoCirculaDTO> lstNoCircula) {
		this.lstNoCircula = lstNoCircula;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMsgProxSabado() {
		return msgProxSabado;
	}

	public void setMsgProxSabado(String msgProxSabado) {
		this.msgProxSabado = msgProxSabado;
	}

	public String getFechasVerificacion() {
		return fechasVerificacion;
	}

	public void setFechasVerificacion(String fechasVerificacion) {
		this.fechasVerificacion = fechasVerificacion;
	}

	public List<ServicioHoyNoCirculaDTO> getLstNoCirculaProxSabado() {
		return lstNoCirculaProxSabado;
	}

	public void setLstNoCirculaProxSabado(List<ServicioHoyNoCirculaDTO> lstNoCirculaProxSabado) {
		this.lstNoCirculaProxSabado = lstNoCirculaProxSabado;
	}

	public List<CatMetroLineaDTO> getLstLineasMetro() {
		return lstLineasMetro;
	}

	public void setLstLineasMetro(List<CatMetroLineaDTO> lstLineasMetro) {
		this.lstLineasMetro = lstLineasMetro;
	}

	public List<CatMetroEstacionesDTO> getMetroEstaciones() {
		return metroEstaciones;
	}

	public void setMetroEstaciones(List<CatMetroEstacionesDTO> metroEstaciones) {
		this.metroEstaciones = metroEstaciones;
	}

	public CatMetroLineaDTO getSelLineaMetro() {
		return selLineaMetro;
	}

	public void setSelLineaMetro(CatMetroLineaDTO selLineaMetro) {
		this.selLineaMetro = selLineaMetro;
	}

	public CatMetroEstacionesDTO getSelEstacionMetro() {
		return selEstacionMetro;
	}

	public void setSelEstacionMetro(CatMetroEstacionesDTO selEstacionMetro) {
		this.selEstacionMetro = selEstacionMetro;
	}

	public MetroRespuestaDTO getRespuestaEstacionMetro() {
		return respuestaEstacionMetro;
	}

	public void setRespuestaEstacionMetro(MetroRespuestaDTO respuestaEstacionMetro) {
		this.respuestaEstacionMetro = respuestaEstacionMetro;
	}

	public ServicioSemaforoEpDTO getSemaforoEpi() {
		return semaforoEpi;
	}

	public void setSemaforoEpi(ServicioSemaforoEpDTO semaforoEpi) {
		this.semaforoEpi = semaforoEpi;
	}

	public HoyNoCirculaDTO getHoyNoCircula() {
		return hoyNoCircula;
	}

	public void setHoyNoCircula(HoyNoCirculaDTO hoyNoCircula) {
		this.hoyNoCircula = hoyNoCircula;
	}
}
