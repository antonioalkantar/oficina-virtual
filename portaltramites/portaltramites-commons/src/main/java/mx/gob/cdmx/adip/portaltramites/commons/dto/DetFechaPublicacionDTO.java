package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetFechaPublicacionDTO implements Serializable {

	private static final long serialVersionUID = -6723436821437584402L;
	private Long id;
	private Date fecha;
	private Boolean vigente;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private TramiteServicioDTO tramiteServicio;
	private String strFecha;
	private SimpleDateFormat dt1 = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "MX"));

	public DetFechaPublicacionDTO() {
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		tramiteServicio = new TramiteServicioDTO();
	}

	public DetFechaPublicacionDTO(Long id, Date fecha, Boolean vigente, CrcFlujoTramiteDTO crcFlujoTramite,
			TramiteServicioDTO tramiteServicio) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.vigente = vigente;
		this.crcFlujoTramite = crcFlujoTramite;
		this.tramiteServicio = tramiteServicio;
		this.strFecha = dt1.format(fecha);
	}
	
	public DetFechaPublicacionDTO(Long id, Date fecha, Boolean vigente, Long idtramiteServicio,
			Long idFlujoTramite) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.vigente = vigente;
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.tramiteServicio = new TramiteServicioDTO(idtramiteServicio);
		this.strFecha = dt1.format(fecha);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
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

	public String getStrFecha() {
		return strFecha;
	}

	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}

}
