package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class DetModalidadesTramiteDTO implements Serializable {

	private static final long serialVersionUID = 4219968415523088009L;
	private Long id;
	private String articuloLeyReglamFicta;
	private String articuloLeyReglamMonto;
	private Boolean medianteFormato;
	private String metodoCalcular;
	private String nombre;
	private String otraLeyFicta;
	private String otraLeyMonto;
	private Boolean situacion;
	private Boolean tieneMontoDerechos;
	private CatDocumentoBeneficioDTO catDocumentoBeneficio;
	private CatFijoOCalculadoDTO catFijoOCalculado;
	private CatLeyeDTO catLeye1;
	private CatLeyeDTO catLeye2;
	private CatTipoFictaDTO catTipoFicta;
//	private CatTipoPresentacionDTO catTipoPresentacion;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private TramiteServicioDTO tramiteServicio;
	private CatTipoConceptoDTO catTipoConcepto;
	private Boolean tieneVigencia;
	private Boolean replicaMedianteFormato;
	private Boolean replicaDocumentoBeneficio;
	private Boolean replicaFijoCalculado;
	private Boolean replicaFicta;
	private Boolean replicaVigencia;
	private String otroMedioPresentacion;
	private String otroDocBeneficio;
	
	public DetModalidadesTramiteDTO() {
		catDocumentoBeneficio = new CatDocumentoBeneficioDTO();
		catFijoOCalculado = new CatFijoOCalculadoDTO();
		catLeye1 = new CatLeyeDTO();
		catLeye2 = new CatLeyeDTO();
		catTipoFicta = new CatTipoFictaDTO();
//		catTipoPresentacion = new CatTipoPresentacionDTO();
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		tramiteServicio = new TramiteServicioDTO();
		catTipoConcepto = new CatTipoConceptoDTO();
	}
	
	public DetModalidadesTramiteDTO(Long id, String articuloLeyReglamFicta, String articuloLeyReglamMonto,
			Boolean medianteFormato, String metodoCalcular, String nombre, String otraLeyFicta, String otraLeyMonto,
			Boolean situacion, Boolean tieneMontoDerechos, Boolean tieneVigencia, Long idDocumentoBeneficio,
			Long idFijoOCalculado, Long idLeye1, Long idLeye2, Long idTipoFicta, Long idTipoPresentacion,
			Long idFlujoTramite, Long idTramiteServicio, Long idTipoConcepto, Boolean replicaMedianteFormato
			, Boolean replicaDocumentoBeneficio, Boolean replicaFijoCalculado, Boolean replicaFicta
			, Boolean replicaVigencia) {
		super();
		this.id = id;
		this.articuloLeyReglamFicta = articuloLeyReglamFicta;
		this.articuloLeyReglamMonto = articuloLeyReglamMonto;
		this.medianteFormato = medianteFormato;
		this.metodoCalcular = metodoCalcular;
		this.nombre = nombre;
		this.otraLeyFicta = otraLeyFicta;
		this.otraLeyMonto = otraLeyMonto;
		this.situacion = situacion;
		this.tieneMontoDerechos = tieneMontoDerechos;
		this.tieneVigencia = tieneVigencia;
		this.catDocumentoBeneficio = new CatDocumentoBeneficioDTO(idDocumentoBeneficio, null, null);
		this.catFijoOCalculado = new CatFijoOCalculadoDTO(idFijoOCalculado, null, null);
		this.catLeye1 = new CatLeyeDTO(idLeye1, null, null);
		this.catLeye2 = new CatLeyeDTO(idLeye2, null, null);
		this.catTipoFicta = new CatTipoFictaDTO(idTipoFicta, null, null);
//		this.catTipoPresentacion = new CatTipoPresentacionDTO(idTipoPresentacion, null, null);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.tramiteServicio = new TramiteServicioDTO(idTramiteServicio);
		this.catTipoConcepto = new CatTipoConceptoDTO(idTipoConcepto, null, null);
		this.replicaMedianteFormato = replicaMedianteFormato;
		this.replicaDocumentoBeneficio = replicaDocumentoBeneficio;
		this.replicaFijoCalculado = replicaFijoCalculado;
		this.replicaFicta = replicaFicta;
		this.replicaVigencia = replicaVigencia;
	}
	
	public DetModalidadesTramiteDTO(Long id, 
			String articuloLeyReglamFicta, 
			String articuloLeyReglamMonto,
			Boolean medianteFormato, 
			String metodoCalcular, 
			String nombre, 
			String otraLeyFicta, 
			String otraLeyMonto,
			Boolean situacion, 
			Boolean tieneMontoDerechos, 
			Boolean tieneVigencia, 
			Long idDocumentoBeneficio, 
			String descDocumentoBeneficio,
			Long idFijoOCalculado, 
			String descFijoOCalculado, 
			Long idLeye1, 
			String nombreLeye1, 
			Long idLeye2, 
			String nombreLeye2, 
			Long idTipoFicta, 
			String descTipoFicta, 
			Long idTipoPresentacion, 
			String descTipoPresentacion, 
			Long idFlujoTramite, 
			Long idTramiteServicio, 
			Long idTipoConcepto,
			String descTipoConcepto,
			Boolean replicaMedianteFormato, 
			Boolean replicaDocumentoBeneficio, 
			Boolean replicaFijoCalculado, 
			Boolean replicaFicta, 
			Boolean replicaVigencia,
			String otroMedioPresentacion,
			String otroDocBeneficio) {
		super();
		this.id = id;
		this.articuloLeyReglamFicta = articuloLeyReglamFicta;
		this.articuloLeyReglamMonto = articuloLeyReglamMonto;
		this.medianteFormato = medianteFormato;
		this.metodoCalcular = metodoCalcular;
		this.nombre = nombre;
		this.otraLeyFicta = otraLeyFicta;
		this.otraLeyMonto = otraLeyMonto;
		this.situacion = situacion;
		this.tieneMontoDerechos = tieneMontoDerechos;
		this.tieneVigencia = tieneVigencia;
		this.catDocumentoBeneficio = new CatDocumentoBeneficioDTO(idDocumentoBeneficio, descDocumentoBeneficio, null);
		this.catFijoOCalculado = new CatFijoOCalculadoDTO(idFijoOCalculado, descFijoOCalculado, null);
		this.catLeye1 = new CatLeyeDTO(idLeye1, nombreLeye1, null);
		this.catLeye2 = new CatLeyeDTO(idLeye2, nombreLeye2, null);
		this.catTipoFicta = new CatTipoFictaDTO(idTipoFicta, descTipoFicta, null);
//		this.catTipoPresentacion = new CatTipoPresentacionDTO(idTipoPresentacion, descTipoPresentacion, null);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.tramiteServicio = new TramiteServicioDTO(idTramiteServicio);
		this.catTipoConcepto = new CatTipoConceptoDTO(idTipoConcepto, descTipoConcepto, null);
		this.replicaMedianteFormato = replicaMedianteFormato;
		this.replicaDocumentoBeneficio = replicaDocumentoBeneficio;
		this.replicaFijoCalculado = replicaFijoCalculado;
		this.replicaFicta = replicaFicta;
		this.replicaVigencia = replicaVigencia;
		this.otroMedioPresentacion = otroMedioPresentacion;
		this.otroDocBeneficio = otroDocBeneficio;
	}
	
	public DetModalidadesTramiteDTO(Long id, Long idDocumentoBeneficio, Boolean replicaDocumentoBeneficio, String otroDocBeneficio) {
		super();
		this.id = id;
		this.catDocumentoBeneficio = new CatDocumentoBeneficioDTO(idDocumentoBeneficio, null, null);
		this.replicaDocumentoBeneficio = replicaDocumentoBeneficio;
		this.otroDocBeneficio = otroDocBeneficio;
	}
	

	public DetModalidadesTramiteDTO(Long id, Long idFijoOCalculado, String metodoCalcular, Boolean replicaFijoCalculado) {
		super();
		this.id = id;
		this.metodoCalcular = metodoCalcular;
		this.catFijoOCalculado = new CatFijoOCalculadoDTO(idFijoOCalculado, null, null);
		this.replicaFijoCalculado = replicaFijoCalculado;
	}
	

	public DetModalidadesTramiteDTO(Long id, Long idTipoFicta, Long idLey, 
			String articuloLeyReglamFicta, String otraLeyFicta, Boolean replicaFicta) {
		super();
		this.id = id;
		this.articuloLeyReglamFicta = articuloLeyReglamFicta;
		this.otraLeyFicta = otraLeyFicta;
		this.catLeye1 = new CatLeyeDTO(idLey);
		this.catTipoFicta = new CatTipoFictaDTO(idTipoFicta);
		this.replicaFicta = replicaFicta;
	}

	public DetModalidadesTramiteDTO(Long id, Boolean tieneVigencia, Boolean replicaVigencia) {
		super();
		this.id = id;
		this.tieneVigencia = tieneVigencia;
		this.replicaVigencia = replicaVigencia;
	}
	

	public DetModalidadesTramiteDTO(Boolean medianteFormato, Long id, Boolean replicaMedianteFormato) {
		super();
		this.id = id;
		this.medianteFormato = medianteFormato;
		this.replicaMedianteFormato = replicaMedianteFormato;
	}

	public DetModalidadesTramiteDTO(Long id) {
		this.id = id;
	}
	public DetModalidadesTramiteDTO(Long id, Long idTipoConcepto) {
		this.id = id;
		this.catTipoConcepto = new CatTipoConceptoDTO(idTipoConcepto);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArticuloLeyReglamFicta() {
		return articuloLeyReglamFicta;
	}
	public void setArticuloLeyReglamFicta(String articuloLeyReglamFicta) {
		this.articuloLeyReglamFicta = articuloLeyReglamFicta;
	}
	public String getArticuloLeyReglamMonto() {
		return articuloLeyReglamMonto;
	}
	public void setArticuloLeyReglamMonto(String articuloLeyReglamMonto) {
		this.articuloLeyReglamMonto = articuloLeyReglamMonto;
	}
	public Boolean getMedianteFormato() {
		return medianteFormato;
	}
	public void setMedianteFormato(Boolean medianteFormato) {
		this.medianteFormato = medianteFormato;
	}
	public String getMetodoCalcular() {
		return metodoCalcular;
	}
	public void setMetodoCalcular(String metodoCalcular) {
		this.metodoCalcular = metodoCalcular;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOtraLeyFicta() {
		return otraLeyFicta;
	}
	public void setOtraLeyFicta(String otraLeyFicta) {
		this.otraLeyFicta = otraLeyFicta;
	}
	public String getOtraLeyMonto() {
		return otraLeyMonto;
	}
	public void setOtraLeyMonto(String otraLeyMonto) {
		this.otraLeyMonto = otraLeyMonto;
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
	public CatDocumentoBeneficioDTO getCatDocumentoBeneficio() {
		return catDocumentoBeneficio;
	}
	public void setCatDocumentoBeneficio(CatDocumentoBeneficioDTO catDocumentoBeneficio) {
		this.catDocumentoBeneficio = catDocumentoBeneficio;
	}
	public CatFijoOCalculadoDTO getCatFijoOCalculado() {
		return catFijoOCalculado;
	}
	public void setCatFijoOCalculado(CatFijoOCalculadoDTO catFijoOCalculado) {
		this.catFijoOCalculado = catFijoOCalculado;
	}
	public CatLeyeDTO getCatLeye1() {
		return catLeye1;
	}
	public void setCatLeye1(CatLeyeDTO catLeye1) {
		this.catLeye1 = catLeye1;
	}
	public CatLeyeDTO getCatLeye2() {
		return catLeye2;
	}
	public void setCatLeye2(CatLeyeDTO catLeye2) {
		this.catLeye2 = catLeye2;
	}
	public CatTipoFictaDTO getCatTipoFicta() {
		return catTipoFicta;
	}
	public void setCatTipoFicta(CatTipoFictaDTO catTipoFicta) {
		this.catTipoFicta = catTipoFicta;
	}
//	public CatTipoPresentacionDTO getCatTipoPresentacion() {
//		return catTipoPresentacion;
//	}
//	public void setCatTipoPresentacion(CatTipoPresentacionDTO catTipoPresentacion) {
//		this.catTipoPresentacion = catTipoPresentacion;
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

	public CatTipoConceptoDTO getCatTipoConcepto() {
		return catTipoConcepto;
	}

	public void setCatTipoConcepto(CatTipoConceptoDTO catTipoConcepto) {
		this.catTipoConcepto = catTipoConcepto;
	}

	public Boolean getTieneVigencia() {
		return tieneVigencia;
	}

	public void setTieneVigencia(Boolean tieneVigencia) {
		this.tieneVigencia = tieneVigencia;
	}

	public Boolean getReplicaMedianteFormato() {
		return replicaMedianteFormato;
	}

	public void setReplicaMedianteFormato(Boolean replicaMedianteFormato) {
		this.replicaMedianteFormato = replicaMedianteFormato;
	}

	public Boolean getReplicaDocumentoBeneficio() {
		return replicaDocumentoBeneficio;
	}

	public void setReplicaDocumentoBeneficio(Boolean replicaDocumentoBeneficio) {
		this.replicaDocumentoBeneficio = replicaDocumentoBeneficio;
	}

	public Boolean getReplicaFijoCalculado() {
		return replicaFijoCalculado;
	}

	public void setReplicaFijoCalculado(Boolean replicaFijoCalculado) {
		this.replicaFijoCalculado = replicaFijoCalculado;
	}

	public Boolean getReplicaFicta() {
		return replicaFicta;
	}

	public void setReplicaFicta(Boolean replicaFicta) {
		this.replicaFicta = replicaFicta;
	}

	public Boolean getReplicaVigencia() {
		return replicaVigencia;
	}

	public void setReplicaVigencia(Boolean replicaVigencia) {
		this.replicaVigencia = replicaVigencia;
	}

	public String getOtroMedioPresentacion() {
		return otroMedioPresentacion;
	}

	public void setOtroMedioPresentacion(String otroMedioPresentacion) {
		this.otroMedioPresentacion = otroMedioPresentacion;
	}

	public String getOtroDocBeneficio() {
		return otroDocBeneficio;
	}

	public void setOtroDocBeneficio(String otroDocBeneficio) {
		this.otroDocBeneficio = otroDocBeneficio;
	}

}
