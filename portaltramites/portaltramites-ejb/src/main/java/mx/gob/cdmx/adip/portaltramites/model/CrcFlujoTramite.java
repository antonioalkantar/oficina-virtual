package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the crc_flujo_tramite database table.
 * 
 */
@Entity
@Table(name = "crc_flujo_tramite", schema = "retys_v2")
//@NamedQueries({
//		@NamedQuery(name = "CrcFlujoTramite.findMaxIdUltimo", query = "SELECT new mx.gob.cdmx.adip.retys.commons.dto.CrcFlujoTramiteDTO(  COALESCE(max(d.id), 0) ) "
//				+ " FROM CrcFlujoTramite d" + "  WHERE d.tramiteServicio.id=:idtram"),
//
//		@NamedQuery(name = "CrcFlujoTramite.findByID", query = "SELECT new mx.gob.cdmx.adip.retys.commons.dto.CrcFlujoTramiteDTO( d.id, d.catEtapasTramite.id   ) "
//				+ " FROM CrcFlujoTramite d" + "  WHERE d.id=:ID")
//})

public class CrcFlujoTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha;
	private CatEstatusTramite catEstatusTramite;
	private CatEtapasTramite catEtapasTramite;
	private CatTipoSolicitud catTipoSolicitud;
//	private Usuario usuario;
	private String correoOrigen;
	private String nombreUsuarioOrigen;
	private String primerApellidoOrigen;
	private String segundoApellidoOrigen;
	private String tipoUsuarioOrigen;
	private String etapaTramiteOrigen;
	private String dependenciaOrigen;
//	private List<CrcModificacion> crcModificacions;
	private List<CrcTramiteFundamento> crcTramiteFundamentos;
//	private List<DetArchivosAdjuntosModalidad> detArchivosAdjuntosModalidads;
//	private List<DetArchivosAdjuntosTramite> detArchivosAdjuntosTramites;
//	private List<DetArchivosFormatoModalidad> detArchivosFormatoModalidads;
//	private List<DetArchivosFormatoTramite> detArchivosFormatoTramites;
//	private List<DetArchivosTramite> detArchivosTramites;
//	private List<DetCamposAdicionale> detCamposAdicionales;
	private List<DetCanalAtencion> detCanalAtencions;
//	private List<DetCitasDependencia> detCitasDependencias;
//	private List<DetConcCostosModal> detConcCostosModals;
	private List<DetCosto> detCostos;
//	private List<DetCriterioResolucion> detCriterioResolucions;
//	private List<DetDatosPersonalesResponsable> detDatosPersonalesResponsables;
//	private List<DetDescripcionTramite> detDescripcionTramites;
//	private List<DetDocumentoModalidad> detDocumentoModalidads;
	private List<DetDocumentosTramite> detDocumentosTramites;
//	private List<DetElementosTecnologico> detElementosTecnologicos;
//	private List<DetEstadisticaFrecuencia> detEstadisticaFrecuencias;
//	private List<DetFechaPublicacion> detFechaPublicacions;
	private List<DetFormato> detFormatos;
//	private List<DetGestion> detGestions;
//	private List<DetHechosVitale> detHechosVitales;
	private List<DetHorariosLugare> detHorariosLugares;
//	private List<DetHorariosMedioDependencia> detHorariosMedioDependencias;
//	private List<DetHorariosTelefono> detHorariosTelefonos;
//	private List<DetHorariosUnidAdmResp> detHorariosUnidAdmResps;
	private List<DetInformacionAdicional> detInformacionAdicional;
//	private List<DetInformacionRelevante> detInformacionRelevantes;
//	private List<DetInspeccion> detInspeccions;
	private List<DetLugaresRegistrado> detLugaresRegistrados;
//	private List<DetMedioBanco> detMedioBancos;
//	private List<DetMedioDependencia> detMedioDependencias;
//	private List<DetMedioOficina> detMedioOficinas;
//	private List<DetMedioOnline> detMedioOnlines;
//	private List<DetMedioOtro> detMedioOtros;
//	private List<DetMedioTienda> detMedioTiendas;
	private List<DetModalidadesTramite> detModalidadesTramites;
//	private List<DetPasosRegistrado> detPasosRegistrados;
	private List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas;
//	private List<DetProtestaCiudadana> detProtestaCiudadanas;
	private List<DetRequisitosFormato> detRequisitosFormatos;
//	private List<DetRequisitosModalidad> detRequisitosModalidads;
//	private List<DetTelefonoProtesta> detTelefonoProtestas;
//	private List<DetTelefonosRegistrado> detTelefonosRegistrados;
//	private List<DetUnidadesAdmResp> detUnidadesAdmResps;
//	private List<DetUrlRegistrado> detUrlRegistrados;
	private List<DetVigencia> detVigencias;
	private List<DetVigenciaModalidad> detVigenciaModalidads;
//	private List<DetConceptosCosto> detConceptosCostos;
	private TramiteServicio tramiteServicio;
//	private List<CrcObservacionesEnlace> crcObservacionesEnlaces;

	public CrcFlujoTramite() {
	}

	public CrcFlujoTramite(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "correo_origen")
	public String getCorreoOrigen() {
		return this.correoOrigen;
	}

	public void setCorreoOrigen(String correoOrigen) {
		this.correoOrigen = correoOrigen;
	}

	@Column(name = "nombre_usuario_origen")
	public String getNombreUsuarioOrigen() {
		return this.nombreUsuarioOrigen;
	}

	public void setNombreUsuarioOrigen(String nombreUsuarioOrigen) {
		this.nombreUsuarioOrigen = nombreUsuarioOrigen;
	}

	@Column(name = "primer_apellido_origen")
	public String getPrimerApellidoOrigen() {
		return this.primerApellidoOrigen;
	}

	public void setPrimerApellidoOrigen(String primerApellidoOrigen) {
		this.primerApellidoOrigen = primerApellidoOrigen;
	}

	@Column(name = "segundo_apellido_origen")
	public String getSegundoApellidoOrigen() {
		return this.segundoApellidoOrigen;
	}

	public void setSegundoApellidoOrigen(String segundoApellidoOrigen) {
		this.segundoApellidoOrigen = segundoApellidoOrigen;
	}

	@Column(name = "tipo_usuario_origen")
	public String getTipoUsuarioOrigen() {
		return this.tipoUsuarioOrigen;
	}

	public void setTipoUsuarioOrigen(String tipoUsuarioOrigen) {
		this.tipoUsuarioOrigen = tipoUsuarioOrigen;
	}

	@Column(name = "etapa_tramite_origen")
	public String getEtapaTramiteOrigen() {
		return this.etapaTramiteOrigen;
	}

	public void setEtapaTramiteOrigen(String etapaTramiteOrigen) {
		this.etapaTramiteOrigen = etapaTramiteOrigen;
	}

	@Column(name = "dependencia_origen")
	public String getDependenciaOrigen() {
		return this.dependenciaOrigen;
	}

	public void setDependenciaOrigen(String dependenciaOrigen) {
		this.dependenciaOrigen = dependenciaOrigen;
	}

	// bi-directional many-to-one association to CatEstatusTramite
	@ManyToOne
	@JoinColumn(name = "id_estatus_tramite")
	public CatEstatusTramite getCatEstatusTramite() {
		return this.catEstatusTramite;
	}

	public void setCatEstatusTramite(CatEstatusTramite catEstatusTramite) {
		this.catEstatusTramite = catEstatusTramite;
	}

	// bi-directional many-to-one association to CatEtapasTramite
	@ManyToOne
	@JoinColumn(name = "id_etapa_tramite")
	public CatEtapasTramite getCatEtapasTramite() {
		return this.catEtapasTramite;
	}

	public void setCatEtapasTramite(CatEtapasTramite catEtapasTramite) {
		this.catEtapasTramite = catEtapasTramite;
	}

	// bi-directional many-to-one association to CatTipoSolicitud
	@ManyToOne
	@JoinColumn(name = "id_tipo_solicitud")
	public CatTipoSolicitud getCatTipoSolicitud() {
		return this.catTipoSolicitud;
	}

	public void setCatTipoSolicitud(CatTipoSolicitud catTipoSolicitud) {
		this.catTipoSolicitud = catTipoSolicitud;
	}

	// bi-directional many-to-one association to Usuario
//	@ManyToOne
//	@JoinColumn(name = "id_usuario")
//	public Usuario getUsuario() {
//		return this.usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

	// bi-directional many-to-one association to CrcModificacion
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<CrcModificacion> getCrcModificacions() {
//		return this.crcModificacions;
//	}
//
//	public void setCrcModificacions(List<CrcModificacion> crcModificacions) {
//		this.crcModificacions = crcModificacions;
//	}
//
//	public CrcModificacion addCrcModificacion(CrcModificacion crcModificacion) {
//		getCrcModificacions().add(crcModificacion);
//		crcModificacion.setCrcFlujoTramite(this);
//
//		return crcModificacion;
//	}
//
//	public CrcModificacion removeCrcModificacion(CrcModificacion crcModificacion) {
//		getCrcModificacions().remove(crcModificacion);
//		crcModificacion.setCrcFlujoTramite(null);
//
//		return crcModificacion;
//	}

	// bi-directional many-to-one association to CrcTramiteFundamento
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crcFlujoTramite")
	public List<CrcTramiteFundamento> getCrcTramiteFundamentos() {
		return this.crcTramiteFundamentos;
	}

	public void setCrcTramiteFundamentos(List<CrcTramiteFundamento> crcTramiteFundamentos) {
		this.crcTramiteFundamentos = crcTramiteFundamentos;
	}

	public CrcTramiteFundamento addCrcTramiteFundamento(CrcTramiteFundamento crcTramiteFundamento) {
		getCrcTramiteFundamentos().add(crcTramiteFundamento);
		crcTramiteFundamento.setCrcFlujoTramite(this);

		return crcTramiteFundamento;
	}

	public CrcTramiteFundamento removeCrcTramiteFundamento(CrcTramiteFundamento crcTramiteFundamento) {
		getCrcTramiteFundamentos().remove(crcTramiteFundamento);
		crcTramiteFundamento.setCrcFlujoTramite(null);

		return crcTramiteFundamento;
	}

	// bi-directional many-to-one association to DetArchivosAdjuntosModalidad
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetArchivosAdjuntosModalidad> getDetArchivosAdjuntosModalidads() {
//		return this.detArchivosAdjuntosModalidads;
//	}
//
//	public void setDetArchivosAdjuntosModalidads(List<DetArchivosAdjuntosModalidad> detArchivosAdjuntosModalidads) {
//		this.detArchivosAdjuntosModalidads = detArchivosAdjuntosModalidads;
//	}
//
//	public DetArchivosAdjuntosModalidad addDetArchivosAdjuntosModalidad(
//			DetArchivosAdjuntosModalidad detArchivosAdjuntosModalidad) {
//		getDetArchivosAdjuntosModalidads().add(detArchivosAdjuntosModalidad);
//		detArchivosAdjuntosModalidad.setCrcFlujoTramite(this);
//
//		return detArchivosAdjuntosModalidad;
//	}
//
//	public DetArchivosAdjuntosModalidad removeDetArchivosAdjuntosModalidad(
//			DetArchivosAdjuntosModalidad detArchivosAdjuntosModalidad) {
//		getDetArchivosAdjuntosModalidads().remove(detArchivosAdjuntosModalidad);
//		detArchivosAdjuntosModalidad.setCrcFlujoTramite(null);
//
//		return detArchivosAdjuntosModalidad;
//	}

	// bi-directional many-to-one association to DetArchivosAdjuntosTramite
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetArchivosAdjuntosTramite> getDetArchivosAdjuntosTramites() {
//		return this.detArchivosAdjuntosTramites;
//	}
//
//	public void setDetArchivosAdjuntosTramites(List<DetArchivosAdjuntosTramite> detArchivosAdjuntosTramites) {
//		this.detArchivosAdjuntosTramites = detArchivosAdjuntosTramites;
//	}

//	public DetArchivosAdjuntosTramite addDetArchivosAdjuntosTramite(
//			DetArchivosAdjuntosTramite detArchivosAdjuntosTramite) {
//		getDetArchivosAdjuntosTramites().add(detArchivosAdjuntosTramite);
//		detArchivosAdjuntosTramite.setCrcFlujoTramite(this);
//
//		return detArchivosAdjuntosTramite;
//	}
//
//	public DetArchivosAdjuntosTramite removeDetArchivosAdjuntosTramite(
//			DetArchivosAdjuntosTramite detArchivosAdjuntosTramite) {
//		getDetArchivosAdjuntosTramites().remove(detArchivosAdjuntosTramite);
//		detArchivosAdjuntosTramite.setCrcFlujoTramite(null);
//
//		return detArchivosAdjuntosTramite;
//	}

	// bi-directional many-to-one association to DetArchivosFormatoModalidad
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetArchivosFormatoModalidad> getDetArchivosFormatoModalidads() {
//		return this.detArchivosFormatoModalidads;
//	}
//
//	public void setDetArchivosFormatoModalidads(List<DetArchivosFormatoModalidad> detArchivosFormatoModalidads) {
//		this.detArchivosFormatoModalidads = detArchivosFormatoModalidads;
//	}
//
//	public DetArchivosFormatoModalidad addDetArchivosFormatoModalidad(
//			DetArchivosFormatoModalidad detArchivosFormatoModalidad) {
//		getDetArchivosFormatoModalidads().add(detArchivosFormatoModalidad);
//		detArchivosFormatoModalidad.setCrcFlujoTramite(this);
//
//		return detArchivosFormatoModalidad;
//	}
//
//	public DetArchivosFormatoModalidad removeDetArchivosFormatoModalidad(
//			DetArchivosFormatoModalidad detArchivosFormatoModalidad) {
//		getDetArchivosFormatoModalidads().remove(detArchivosFormatoModalidad);
//		detArchivosFormatoModalidad.setCrcFlujoTramite(null);
//
//		return detArchivosFormatoModalidad;
//	}

	// bi-directional many-to-one association to DetArchivosFormatoTramite
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetArchivosFormatoTramite> getDetArchivosFormatoTramites() {
//		return this.detArchivosFormatoTramites;
//	}
//
//	public void setDetArchivosFormatoTramites(List<DetArchivosFormatoTramite> detArchivosFormatoTramites) {
//		this.detArchivosFormatoTramites = detArchivosFormatoTramites;
//	}

//	public DetArchivosFormatoTramite addDetArchivosFormatoTramite(DetArchivosFormatoTramite detArchivosFormatoTramite) {
//		getDetArchivosFormatoTramites().add(detArchivosFormatoTramite);
//		detArchivosFormatoTramite.setCrcFlujoTramite(this);
//
//		return detArchivosFormatoTramite;
//	}
//
//	public DetArchivosFormatoTramite removeDetArchivosFormatoTramite(
//			DetArchivosFormatoTramite detArchivosFormatoTramite) {
//		getDetArchivosFormatoTramites().remove(detArchivosFormatoTramite);
//		detArchivosFormatoTramite.setCrcFlujoTramite(null);
//
//		return detArchivosFormatoTramite;
//	}

	// bi-directional many-to-one association to DetArchivosTramite
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crcFlujoTramite")
//	public List<DetArchivosTramite> getDetArchivosTramites() {
//		return this.detArchivosTramites;
//	}
//
//	public void setDetArchivosTramites(List<DetArchivosTramite> detArchivosTramites) {
//		this.detArchivosTramites = detArchivosTramites;
//	}
//
//	public DetArchivosTramite addDetArchivosTramite(DetArchivosTramite detArchivosTramite) {
//		getDetArchivosTramites().add(detArchivosTramite);
//		detArchivosTramite.setCrcFlujoTramite(this);
//
//		return detArchivosTramite;
//	}
//
//	public DetArchivosTramite removeDetArchivosTramite(DetArchivosTramite detArchivosTramite) {
//		getDetArchivosTramites().remove(detArchivosTramite);
//		detArchivosTramite.setCrcFlujoTramite(null);
//
//		return detArchivosTramite;
//	}

	// bi-directional many-to-one association to DetCamposAdicionale
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetCamposAdicionale> getDetCamposAdicionales() {
//		return this.detCamposAdicionales;
//	}
//
//	public void setDetCamposAdicionales(List<DetCamposAdicionale> detCamposAdicionales) {
//		this.detCamposAdicionales = detCamposAdicionales;
//	}
//
//	public DetCamposAdicionale addDetCamposAdicionale(DetCamposAdicionale detCamposAdicionale) {
//		getDetCamposAdicionales().add(detCamposAdicionale);
//		detCamposAdicionale.setCrcFlujoTramite(this);
//
//		return detCamposAdicionale;
//	}
//
//	public DetCamposAdicionale removeDetCamposAdicionale(DetCamposAdicionale detCamposAdicionale) {
//		getDetCamposAdicionales().remove(detCamposAdicionale);
//		detCamposAdicionale.setCrcFlujoTramite(null);
//
//		return detCamposAdicionale;
//	}

	// bi-directional many-to-one association to DetCanalAtencion
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetCanalAtencion> getDetCanalAtencions() {
//		return this.detCanalAtencions;
//	}
//
//	public void setDetCanalAtencions(List<DetCanalAtencion> detCanalAtencions) {
//		this.detCanalAtencions = detCanalAtencions;
//	}
//
//	public DetCanalAtencion addDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
//		getDetCanalAtencions().add(detCanalAtencion);
//		detCanalAtencion.setCrcFlujoTramite(this);
//
//		return detCanalAtencion;
//	}
//
//	public DetCanalAtencion removeDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
//		getDetCanalAtencions().remove(detCanalAtencion);
//		detCanalAtencion.setCrcFlujoTramite(null);
//
//		return detCanalAtencion;
//	}

	// bi-directional many-to-one association to DetCitasDependencia
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetCitasDependencia> getDetCitasDependencias() {
//		return this.detCitasDependencias;
//	}
//
//	public void setDetCitasDependencias(List<DetCitasDependencia> detCitasDependencias) {
//		this.detCitasDependencias = detCitasDependencias;
//	}
//
//	public DetCitasDependencia addDetCitasDependencia(DetCitasDependencia detCitasDependencia) {
//		getDetCitasDependencias().add(detCitasDependencia);
//		detCitasDependencia.setCrcFlujoTramite(this);
//
//		return detCitasDependencia;
//	}
//
//	public DetCitasDependencia removeDetCitasDependencia(DetCitasDependencia detCitasDependencia) {
//		getDetCitasDependencias().remove(detCitasDependencia);
//		detCitasDependencia.setCrcFlujoTramite(null);
//
//		return detCitasDependencia;
//	}

	// bi-directional many-to-one association to DetConcCostosModal
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetConcCostosModal> getDetConcCostosModals() {
//		return this.detConcCostosModals;
//	}
//
//	public void setDetConcCostosModals(List<DetConcCostosModal> detConcCostosModals) {
//		this.detConcCostosModals = detConcCostosModals;
//	}
//
//	public DetConcCostosModal addDetConcCostosModal(DetConcCostosModal detConcCostosModal) {
//		getDetConcCostosModals().add(detConcCostosModal);
//		detConcCostosModal.setCrcFlujoTramite(this);
//
//		return detConcCostosModal;
//	}
//
//	public DetConcCostosModal removeDetConcCostosModal(DetConcCostosModal detConcCostosModal) {
//		getDetConcCostosModals().remove(detConcCostosModal);
//		detConcCostosModal.setCrcFlujoTramite(null);
//
//		return detConcCostosModal;
//	}

	// bi-directional many-to-one association to DetCosto
	@OneToMany(mappedBy = "crcFlujoTramite")
	public List<DetCosto> getDetCostos() {
		return this.detCostos;
	}

	public void setDetCostos(List<DetCosto> detCostos) {
		this.detCostos = detCostos;
	}

	public DetCosto addDetCosto(DetCosto detCosto) {
		getDetCostos().add(detCosto);
		detCosto.setCrcFlujoTramite(this);

		return detCosto;
	}

	public DetCosto removeDetCosto(DetCosto detCosto) {
		getDetCostos().remove(detCosto);
		detCosto.setCrcFlujoTramite(null);

		return detCosto;
	}

	// bi-directional many-to-one association to DetCriterioResolucion
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetCriterioResolucion> getDetCriterioResolucions() {
//		return this.detCriterioResolucions;
//	}
//
//	public void setDetCriterioResolucions(List<DetCriterioResolucion> detCriterioResolucions) {
//		this.detCriterioResolucions = detCriterioResolucions;
//	}
//
//	public DetCriterioResolucion addDetCriterioResolucion(DetCriterioResolucion detCriterioResolucion) {
//		getDetCriterioResolucions().add(detCriterioResolucion);
//		detCriterioResolucion.setCrcFlujoTramite(this);
//
//		return detCriterioResolucion;
//	}
//
//	public DetCriterioResolucion removeDetCriterioResolucion(DetCriterioResolucion detCriterioResolucion) {
//		getDetCriterioResolucions().remove(detCriterioResolucion);
//		detCriterioResolucion.setCrcFlujoTramite(null);
//
//		return detCriterioResolucion;
//	}

	// bi-directional many-to-one association to DetDatosPersonalesResponsable
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetDatosPersonalesResponsable> getDetDatosPersonalesResponsables() {
//		return this.detDatosPersonalesResponsables;
//	}
//
//	public void setDetDatosPersonalesResponsables(List<DetDatosPersonalesResponsable> detDatosPersonalesResponsables) {
//		this.detDatosPersonalesResponsables = detDatosPersonalesResponsables;
//	}
//
//	public DetDatosPersonalesResponsable addDetDatosPersonalesResponsable(
//			DetDatosPersonalesResponsable detDatosPersonalesResponsable) {
//		getDetDatosPersonalesResponsables().add(detDatosPersonalesResponsable);
//		detDatosPersonalesResponsable.setCrcFlujoTramite(this);
//
//		return detDatosPersonalesResponsable;
//	}
//
//	public DetDatosPersonalesResponsable removeDetDatosPersonalesResponsable(
//			DetDatosPersonalesResponsable detDatosPersonalesResponsable) {
//		getDetDatosPersonalesResponsables().remove(detDatosPersonalesResponsable);
//		detDatosPersonalesResponsable.setCrcFlujoTramite(null);
//
//		return detDatosPersonalesResponsable;
//	}

	// bi-directional many-to-one association to DetDescripcionTramite
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetDescripcionTramite> getDetDescripcionTramites() {
//		return this.detDescripcionTramites;
//	}
//
//	public void setDetDescripcionTramites(List<DetDescripcionTramite> detDescripcionTramites) {
//		this.detDescripcionTramites = detDescripcionTramites;
//	}

//	public DetDescripcionTramite addDetDescripcionTramite(DetDescripcionTramite detDescripcionTramite) {
//		getDetDescripcionTramites().add(detDescripcionTramite);
//		detDescripcionTramite.setCrcFlujoTramite(this);
//
//		return detDescripcionTramite;
//	}
//
//	public DetDescripcionTramite removeDetDescripcionTramite(DetDescripcionTramite detDescripcionTramite) {
//		getDetDescripcionTramites().remove(detDescripcionTramite);
//		detDescripcionTramite.setCrcFlujoTramite(null);
//
//		return detDescripcionTramite;
//	}

	// bi-directional many-to-one association to DetDocumentoModalidad
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetDocumentoModalidad> getDetDocumentoModalidads() {
//		return this.detDocumentoModalidads;
//	}
//
//	public void setDetDocumentoModalidads(List<DetDocumentoModalidad> detDocumentoModalidads) {
//		this.detDocumentoModalidads = detDocumentoModalidads;
//	}
//
//	public DetDocumentoModalidad addDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
//		getDetDocumentoModalidads().add(detDocumentoModalidad);
//		detDocumentoModalidad.setCrcFlujoTramite(this);
//
//		return detDocumentoModalidad;
//	}
//
//	public DetDocumentoModalidad removeDetDocumentoModalidad(DetDocumentoModalidad detDocumentoModalidad) {
//		getDetDocumentoModalidads().remove(detDocumentoModalidad);
//		detDocumentoModalidad.setCrcFlujoTramite(null);
//
//		return detDocumentoModalidad;
//	}

	// bi-directional many-to-one association to DetDocumentosTramite
	@OneToMany(mappedBy = "crcFlujoTramite")
	public List<DetDocumentosTramite> getDetDocumentosTramites() {
		return this.detDocumentosTramites;
	}

	public void setDetDocumentosTramites(List<DetDocumentosTramite> detDocumentosTramites) {
		this.detDocumentosTramites = detDocumentosTramites;
	}

	public DetDocumentosTramite addDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
		getDetDocumentosTramites().add(detDocumentosTramite);
		detDocumentosTramite.setCrcFlujoTramite(this);

		return detDocumentosTramite;
	}

	public DetDocumentosTramite removeDetDocumentosTramite(DetDocumentosTramite detDocumentosTramite) {
		getDetDocumentosTramites().remove(detDocumentosTramite);
		detDocumentosTramite.setCrcFlujoTramite(null);

		return detDocumentosTramite;
	}

	// bi-directional many-to-one association to DetElementosTecnologico
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetElementosTecnologico> getDetElementosTecnologicos() {
//		return this.detElementosTecnologicos;
//	}
//
//	public void setDetElementosTecnologicos(List<DetElementosTecnologico> detElementosTecnologicos) {
//		this.detElementosTecnologicos = detElementosTecnologicos;
//	}
//
//	public DetElementosTecnologico addDetElementosTecnologico(DetElementosTecnologico detElementosTecnologico) {
//		getDetElementosTecnologicos().add(detElementosTecnologico);
//		detElementosTecnologico.setCrcFlujoTramite(this);
//
//		return detElementosTecnologico;
//	}
//
//	public DetElementosTecnologico removeDetElementosTecnologico(DetElementosTecnologico detElementosTecnologico) {
//		getDetElementosTecnologicos().remove(detElementosTecnologico);
//		detElementosTecnologico.setCrcFlujoTramite(null);
//
//		return detElementosTecnologico;
//	}

	// bi-directional many-to-one association to DetEstadisticaFrecuencia
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetEstadisticaFrecuencia> getDetEstadisticaFrecuencias() {
//		return this.detEstadisticaFrecuencias;
//	}
//
//	public void setDetEstadisticaFrecuencias(List<DetEstadisticaFrecuencia> detEstadisticaFrecuencias) {
//		this.detEstadisticaFrecuencias = detEstadisticaFrecuencias;
//	}
//
//	public DetEstadisticaFrecuencia addDetEstadisticaFrecuencia(DetEstadisticaFrecuencia detEstadisticaFrecuencia) {
//		getDetEstadisticaFrecuencias().add(detEstadisticaFrecuencia);
//		detEstadisticaFrecuencia.setCrcFlujoTramite(this);
//
//		return detEstadisticaFrecuencia;
//	}
//
//	public DetEstadisticaFrecuencia removeDetEstadisticaFrecuencia(DetEstadisticaFrecuencia detEstadisticaFrecuencia) {
//		getDetEstadisticaFrecuencias().remove(detEstadisticaFrecuencia);
//		detEstadisticaFrecuencia.setCrcFlujoTramite(null);
//
//		return detEstadisticaFrecuencia;
//	}

	// bi-directional many-to-one association to DetFechaPublicacion
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "crcFlujoTramite")
//	public List<DetFechaPublicacion> getDetFechaPublicacions() {
//		return this.detFechaPublicacions;
//	}
//
//	public void setDetFechaPublicacions(List<DetFechaPublicacion> detFechaPublicacions) {
//		this.detFechaPublicacions = detFechaPublicacions;
//	}
//
//	public DetFechaPublicacion addDetFechaPublicacion(DetFechaPublicacion detFechaPublicacion) {
//		getDetFechaPublicacions().add(detFechaPublicacion);
//		detFechaPublicacion.setCrcFlujoTramite(this);
//
//		return detFechaPublicacion;
//	}
//
//	public DetFechaPublicacion removeDetFechaPublicacion(DetFechaPublicacion detFechaPublicacion) {
//		getDetFechaPublicacions().remove(detFechaPublicacion);
//		detFechaPublicacion.setCrcFlujoTramite(null);
//
//		return detFechaPublicacion;
//	}

	// bi-directional many-to-one association to DetFormato
	@OneToMany(mappedBy = "crcFlujoTramite")
	public List<DetFormato> getDetFormatos() {
		return this.detFormatos;
	}

	public void setDetFormatos(List<DetFormato> detFormatos) {
		this.detFormatos = detFormatos;
	}

	public DetFormato addDetFormato(DetFormato detFormato) {
		getDetFormatos().add(detFormato);
		detFormato.setCrcFlujoTramite(this);

		return detFormato;
	}

	public DetFormato removeDetFormato(DetFormato detFormato) {
		getDetFormatos().remove(detFormato);
		detFormato.setCrcFlujoTramite(null);

		return detFormato;
	}

	// bi-directional many-to-one association to DetGestion
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetGestion> getDetGestions() {
//		return this.detGestions;
//	}
//
//	public void setDetGestions(List<DetGestion> detGestions) {
//		this.detGestions = detGestions;
//	}
//
//	public DetGestion addDetGestion(DetGestion detGestion) {
//		getDetGestions().add(detGestion);
//		detGestion.setCrcFlujoTramite(this);
//
//		return detGestion;
//	}
//
//	public DetGestion removeDetGestion(DetGestion detGestion) {
//		getDetGestions().remove(detGestion);
//		detGestion.setCrcFlujoTramite(null);
//
//		return detGestion;
//	}

	// bi-directional many-to-one association to DetHechosVitale
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetHechosVitale> getDetHechosVitales() {
//		return this.detHechosVitales;
//	}
//
//	public void setDetHechosVitales(List<DetHechosVitale> detHechosVitales) {
//		this.detHechosVitales = detHechosVitales;
//	}
//
//	public DetHechosVitale addDetHechosVitale(DetHechosVitale detHechosVitale) {
//		getDetHechosVitales().add(detHechosVitale);
//		detHechosVitale.setCrcFlujoTramite(this);
//
//		return detHechosVitale;
//	}
//
//	public DetHechosVitale removeDetHechosVitale(DetHechosVitale detHechosVitale) {
//		getDetHechosVitales().remove(detHechosVitale);
//		detHechosVitale.setCrcFlujoTramite(null);
//
//		return detHechosVitale;
//	}

	// bi-directional many-to-one association to DetHorariosLugare
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetHorariosLugare> getDetHorariosLugares() {
//		return this.detHorariosLugares;
//	}
//
//	public void setDetHorariosLugares(List<DetHorariosLugare> detHorariosLugares) {
//		this.detHorariosLugares = detHorariosLugares;
//	}

//	public DetHorariosLugare addDetHorariosLugare(DetHorariosLugare detHorariosLugare) {
//		getDetHorariosLugares().add(detHorariosLugare);
//		detHorariosLugare.setCrcFlujoTramite(this);
//
//		return detHorariosLugare;
//	}
//
//	public DetHorariosLugare removeDetHorariosLugare(DetHorariosLugare detHorariosLugare) {
//		getDetHorariosLugares().remove(detHorariosLugare);
//		detHorariosLugare.setCrcFlujoTramite(null);
//
//		return detHorariosLugare;
//	}

	// bi-directional many-to-one association to DetHorariosMedioDependencia
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetHorariosMedioDependencia> getDetHorariosMedioDependencias() {
//		return this.detHorariosMedioDependencias;
//	}
//
//	public void setDetHorariosMedioDependencias(List<DetHorariosMedioDependencia> detHorariosMedioDependencias) {
//		this.detHorariosMedioDependencias = detHorariosMedioDependencias;
//	}
//
//	public DetHorariosMedioDependencia addDetHorariosMedioDependencia(
//			DetHorariosMedioDependencia detHorariosMedioDependencia) {
//		getDetHorariosMedioDependencias().add(detHorariosMedioDependencia);
//		detHorariosMedioDependencia.setCrcFlujoTramite(this);
//
//		return detHorariosMedioDependencia;
//	}
//
//	public DetHorariosMedioDependencia removeDetHorariosMedioDependencia(
//			DetHorariosMedioDependencia detHorariosMedioDependencia) {
//		getDetHorariosMedioDependencias().remove(detHorariosMedioDependencia);
//		detHorariosMedioDependencia.setCrcFlujoTramite(null);
//
//		return detHorariosMedioDependencia;
//	}

	// bi-directional many-to-one association to DetHorariosTelefono
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetHorariosTelefono> getDetHorariosTelefonos() {
//		return this.detHorariosTelefonos;
//	}
//
//	public void setDetHorariosTelefonos(List<DetHorariosTelefono> detHorariosTelefonos) {
//		this.detHorariosTelefonos = detHorariosTelefonos;
//	}
//
//	public DetHorariosTelefono addDetHorariosTelefono(DetHorariosTelefono detHorariosTelefono) {
//		getDetHorariosTelefonos().add(detHorariosTelefono);
//		detHorariosTelefono.setCrcFlujoTramite(this);
//
//		return detHorariosTelefono;
//	}
//
//	public DetHorariosTelefono removeDetHorariosTelefono(DetHorariosTelefono detHorariosTelefono) {
//		getDetHorariosTelefonos().remove(detHorariosTelefono);
//		detHorariosTelefono.setCrcFlujoTramite(null);
//
//		return detHorariosTelefono;
//	}

	// bi-directional many-to-one association to DetHorariosUnidAdmResp
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetHorariosUnidAdmResp> getDetHorariosUnidAdmResps() {
//		return this.detHorariosUnidAdmResps;
//	}
//
//	public void setDetHorariosUnidAdmResps(List<DetHorariosUnidAdmResp> detHorariosUnidAdmResps) {
//		this.detHorariosUnidAdmResps = detHorariosUnidAdmResps;
//	}
//
//	public DetHorariosUnidAdmResp addDetHorariosUnidAdmResp(DetHorariosUnidAdmResp detHorariosUnidAdmResp) {
//		getDetHorariosUnidAdmResps().add(detHorariosUnidAdmResp);
//		detHorariosUnidAdmResp.setCrcFlujoTramite(this);
//
//		return detHorariosUnidAdmResp;
//	}
//
//	public DetHorariosUnidAdmResp removeDetHorariosUnidAdmResp(DetHorariosUnidAdmResp detHorariosUnidAdmResp) {
//		getDetHorariosUnidAdmResps().remove(detHorariosUnidAdmResp);
//		detHorariosUnidAdmResp.setCrcFlujoTramite(null);
//
//		return detHorariosUnidAdmResp;
//	}

	// bi-directional many-to-one association to DetInformacionAdicional
	@OneToMany(mappedBy = "crcFlujoTramite")
	public List<DetInformacionAdicional> getDetInformacionAdicional() {
		return this.detInformacionAdicional;
	}

	public void setDetInformacionAdicional(List<DetInformacionAdicional> detInformacionAdicional) {
		this.detInformacionAdicional = detInformacionAdicional;
	}
//
//	public DetInformacionAdicional addDetInformacionAdicional(DetInformacionAdicional detInformacionAdicional) {
//		getDetInformacionAdicionals().add(detInformacionAdicional);
//		detInformacionAdicional.setCrcFlujoTramite(this);
//
//		return detInformacionAdicional;
//	}
//
//	public DetInformacionAdicional removeDetInformacionAdicional(DetInformacionAdicional detInformacionAdicional) {
//		getDetInformacionAdicionals().remove(detInformacionAdicional);
//		detInformacionAdicional.setCrcFlujoTramite(null);
//
//		return detInformacionAdicional;
//	}

	// bi-directional many-to-one association to DetInformacionRelevante
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetInformacionRelevante> getDetInformacionRelevantes() {
//		return this.detInformacionRelevantes;
//	}
//
//	public void setDetInformacionRelevantes(List<DetInformacionRelevante> detInformacionRelevantes) {
//		this.detInformacionRelevantes = detInformacionRelevantes;
//	}
//
//	public DetInformacionRelevante addDetInformacionRelevante(DetInformacionRelevante detInformacionRelevante) {
//		getDetInformacionRelevantes().add(detInformacionRelevante);
//		detInformacionRelevante.setCrcFlujoTramite(this);
//
//		return detInformacionRelevante;
//	}
//
//	public DetInformacionRelevante removeDetInformacionRelevante(DetInformacionRelevante detInformacionRelevante) {
//		getDetInformacionRelevantes().remove(detInformacionRelevante);
//		detInformacionRelevante.setCrcFlujoTramite(null);
//
//		return detInformacionRelevante;
//	}

	// bi-directional many-to-one association to DetInspeccion
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetInspeccion> getDetInspeccions() {
//		return this.detInspeccions;
//	}

//	public void setDetInspeccions(List<DetInspeccion> detInspeccions) {
//		this.detInspeccions = detInspeccions;
//	}
//
//	public DetInspeccion addDetInspeccion(DetInspeccion detInspeccion) {
//		getDetInspeccions().add(detInspeccion);
//		detInspeccion.setCrcFlujoTramite(this);
//
//		return detInspeccion;
//	}
//
//	public DetInspeccion removeDetInspeccion(DetInspeccion detInspeccion) {
//		getDetInspeccions().remove(detInspeccion);
//		detInspeccion.setCrcFlujoTramite(null);
//
//		return detInspeccion;
//	}

	// bi-directional many-to-one association to DetLugaresRegistrado
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetLugaresRegistrado> getDetLugaresRegistrados() {
//		return this.detLugaresRegistrados;
//	}
//
//	public void setDetLugaresRegistrados(List<DetLugaresRegistrado> detLugaresRegistrados) {
//		this.detLugaresRegistrados = detLugaresRegistrados;
//	}

//	public DetLugaresRegistrado addDetLugaresRegistrado(DetLugaresRegistrado detLugaresRegistrado) {
//		getDetLugaresRegistrados().add(detLugaresRegistrado);
//		detLugaresRegistrado.setCrcFlujoTramite(this);
//
//		return detLugaresRegistrado;
//	}
//
//	public DetLugaresRegistrado removeDetLugaresRegistrado(DetLugaresRegistrado detLugaresRegistrado) {
//		getDetLugaresRegistrados().remove(detLugaresRegistrado);
//		detLugaresRegistrado.setCrcFlujoTramite(null);
//
//		return detLugaresRegistrado;
//	}

	// bi-directional many-to-one association to DetMedioBanco
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetMedioBanco> getDetMedioBancos() {
//		return this.detMedioBancos;
//	}
//
//	public void setDetMedioBancos(List<DetMedioBanco> detMedioBancos) {
//		this.detMedioBancos = detMedioBancos;
//	}
//
//	public DetMedioBanco addDetMedioBanco(DetMedioBanco detMedioBanco) {
//		getDetMedioBancos().add(detMedioBanco);
//		detMedioBanco.setCrcFlujoTramite(this);
//
//		return detMedioBanco;
//	}
//
//	public DetMedioBanco removeDetMedioBanco(DetMedioBanco detMedioBanco) {
//		getDetMedioBancos().remove(detMedioBanco);
//		detMedioBanco.setCrcFlujoTramite(null);
//
//		return detMedioBanco;
//	}

	// bi-directional many-to-one association to DetMedioDependencia
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetMedioDependencia> getDetMedioDependencias() {
//		return this.detMedioDependencias;
//	}
//
//	public void setDetMedioDependencias(List<DetMedioDependencia> detMedioDependencias) {
//		this.detMedioDependencias = detMedioDependencias;
//	}
//
//	public DetMedioDependencia addDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().add(detMedioDependencia);
//		detMedioDependencia.setCrcFlujoTramite(this);
//
//		return detMedioDependencia;
//	}
//
//	public DetMedioDependencia removeDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().remove(detMedioDependencia);
//		detMedioDependencia.setCrcFlujoTramite(null);
//
//		return detMedioDependencia;
//	}

	// bi-directional many-to-one association to DetMedioOficina
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetMedioOficina> getDetMedioOficinas() {
//		return this.detMedioOficinas;
//	}
//
//	public void setDetMedioOficinas(List<DetMedioOficina> detMedioOficinas) {
//		this.detMedioOficinas = detMedioOficinas;
//	}
//
//	public DetMedioOficina addDetMedioOficina(DetMedioOficina detMedioOficina) {
//		getDetMedioOficinas().add(detMedioOficina);
//		detMedioOficina.setCrcFlujoTramite(this);
//
//		return detMedioOficina;
//	}
//
//	public DetMedioOficina removeDetMedioOficina(DetMedioOficina detMedioOficina) {
//		getDetMedioOficinas().remove(detMedioOficina);
//		detMedioOficina.setCrcFlujoTramite(null);
//
//		return detMedioOficina;
//	}

	// bi-directional many-to-one association to DetMedioOnline
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetMedioOnline> getDetMedioOnlines() {
//		return this.detMedioOnlines;
//	}
//
//	public void setDetMedioOnlines(List<DetMedioOnline> detMedioOnlines) {
//		this.detMedioOnlines = detMedioOnlines;
//	}
//
//	public DetMedioOnline addDetMedioOnline(DetMedioOnline detMedioOnline) {
//		getDetMedioOnlines().add(detMedioOnline);
//		detMedioOnline.setCrcFlujoTramite(this);
//
//		return detMedioOnline;
//	}
//
//	public DetMedioOnline removeDetMedioOnline(DetMedioOnline detMedioOnline) {
//		getDetMedioOnlines().remove(detMedioOnline);
//		detMedioOnline.setCrcFlujoTramite(null);
//
//		return detMedioOnline;
//	}

	// bi-directional many-to-one association to DetMedioOtro
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetMedioOtro> getDetMedioOtros() {
//		return this.detMedioOtros;
//	}
//
//	public void setDetMedioOtros(List<DetMedioOtro> detMedioOtros) {
//		this.detMedioOtros = detMedioOtros;
//	}
//
//	public DetMedioOtro addDetMedioOtro(DetMedioOtro detMedioOtro) {
//		getDetMedioOtros().add(detMedioOtro);
//		detMedioOtro.setCrcFlujoTramite(this);
//
//		return detMedioOtro;
//	}
//
//	public DetMedioOtro removeDetMedioOtro(DetMedioOtro detMedioOtro) {
//		getDetMedioOtros().remove(detMedioOtro);
//		detMedioOtro.setCrcFlujoTramite(null);
//
//		return detMedioOtro;
//	}

	// bi-directional many-to-one association to DetMedioTienda
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetMedioTienda> getDetMedioTiendas() {
//		return this.detMedioTiendas;
//	}
//
//	public void setDetMedioTiendas(List<DetMedioTienda> detMedioTiendas) {
//		this.detMedioTiendas = detMedioTiendas;
//	}
//
//	public DetMedioTienda addDetMedioTienda(DetMedioTienda detMedioTienda) {
//		getDetMedioTiendas().add(detMedioTienda);
//		detMedioTienda.setCrcFlujoTramite(this);
//
//		return detMedioTienda;
//	}
//
//	public DetMedioTienda removeDetMedioTienda(DetMedioTienda detMedioTienda) {
//		getDetMedioTiendas().remove(detMedioTienda);
//		detMedioTienda.setCrcFlujoTramite(null);
//
//		return detMedioTienda;
//	}

	// bi-directional many-to-one association to DetModalidadesTramite
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetModalidadesTramite> getDetModalidadesTramites() {
//		return this.detModalidadesTramites;
//	}
//
//	public void setDetModalidadesTramites(List<DetModalidadesTramite> detModalidadesTramites) {
//		this.detModalidadesTramites = detModalidadesTramites;
//	}

//	public DetModalidadesTramite addDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
//		getDetModalidadesTramites().add(detModalidadesTramite);
//		detModalidadesTramite.setCrcFlujoTramite(this);
//
//		return detModalidadesTramite;
//	}
//
//	public DetModalidadesTramite removeDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
//		getDetModalidadesTramites().remove(detModalidadesTramite);
//		detModalidadesTramite.setCrcFlujoTramite(null);
//
//		return detModalidadesTramite;
//	}

	// bi-directional many-to-one association to DetPasosRegistrado
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetPasosRegistrado> getDetPasosRegistrados() {
//		return this.detPasosRegistrados;
//	}
//
//	public void setDetPasosRegistrados(List<DetPasosRegistrado> detPasosRegistrados) {
//		this.detPasosRegistrados = detPasosRegistrados;
//	}
//
//	public DetPasosRegistrado addDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
//		getDetPasosRegistrados().add(detPasosRegistrado);
//		detPasosRegistrado.setCrcFlujoTramite(this);
//
//		return detPasosRegistrado;
//	}
//
//	public DetPasosRegistrado removeDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
//		getDetPasosRegistrados().remove(detPasosRegistrado);
//		detPasosRegistrado.setCrcFlujoTramite(null);
//
//		return detPasosRegistrado;
//	}

	// bi-directional many-to-one association to DetPlazoMaximoRespuesta
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetPlazoMaximoRespuesta> getDetPlazoMaximoRespuestas() {
//		return this.detPlazoMaximoRespuestas;
//	}
//
//	public void setDetPlazoMaximoRespuestas(List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas) {
//		this.detPlazoMaximoRespuestas = detPlazoMaximoRespuestas;
//	}

//	public DetPlazoMaximoRespuesta addDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
//		getDetPlazoMaximoRespuestas().add(detPlazoMaximoRespuesta);
//		detPlazoMaximoRespuesta.setCrcFlujoTramite(this);
//
//		return detPlazoMaximoRespuesta;
//	}
//
//	public DetPlazoMaximoRespuesta removeDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
//		getDetPlazoMaximoRespuestas().remove(detPlazoMaximoRespuesta);
//		detPlazoMaximoRespuesta.setCrcFlujoTramite(null);
//
//		return detPlazoMaximoRespuesta;
//	}

	// bi-directional many-to-one association to DetProtestaCiudadana
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetProtestaCiudadana> getDetProtestaCiudadanas() {
//		return this.detProtestaCiudadanas;
//	}
//
//	public void setDetProtestaCiudadanas(List<DetProtestaCiudadana> detProtestaCiudadanas) {
//		this.detProtestaCiudadanas = detProtestaCiudadanas;
//	}
//
//	public DetProtestaCiudadana addDetProtestaCiudadana(DetProtestaCiudadana detProtestaCiudadana) {
//		getDetProtestaCiudadanas().add(detProtestaCiudadana);
//		detProtestaCiudadana.setCrcFlujoTramite(this);
//
//		return detProtestaCiudadana;
//	}
//
//	public DetProtestaCiudadana removeDetProtestaCiudadana(DetProtestaCiudadana detProtestaCiudadana) {
//		getDetProtestaCiudadanas().remove(detProtestaCiudadana);
//		detProtestaCiudadana.setCrcFlujoTramite(null);
//
//		return detProtestaCiudadana;
//	}

	// bi-directional many-to-one association to DetRequisitosFormato
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetRequisitosFormato> getDetRequisitosFormatos() {
//		return this.detRequisitosFormatos;
//	}
//
//	public void setDetRequisitosFormatos(List<DetRequisitosFormato> detRequisitosFormatos) {
//		this.detRequisitosFormatos = detRequisitosFormatos;
//	}
//
//	public DetRequisitosFormato addDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
//		getDetRequisitosFormatos().add(detRequisitosFormato);
//		detRequisitosFormato.setCrcFlujoTramite(this);
//
//		return detRequisitosFormato;
//	}
//
//	public DetRequisitosFormato removeDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
//		getDetRequisitosFormatos().remove(detRequisitosFormato);
//		detRequisitosFormato.setCrcFlujoTramite(null);
//
//		return detRequisitosFormato;
//	}

	// bi-directional many-to-one association to DetRequisitosModalidad
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetRequisitosModalidad> getDetRequisitosModalidads() {
//		return this.detRequisitosModalidads;
//	}
//
//	public void setDetRequisitosModalidads(List<DetRequisitosModalidad> detRequisitosModalidads) {
//		this.detRequisitosModalidads = detRequisitosModalidads;
//	}
//
//	public DetRequisitosModalidad addDetRequisitosModalidad(DetRequisitosModalidad detRequisitosModalidad) {
//		getDetRequisitosModalidads().add(detRequisitosModalidad);
//		detRequisitosModalidad.setCrcFlujoTramite(this);
//
//		return detRequisitosModalidad;
//	}
//
//	public DetRequisitosModalidad removeDetRequisitosModalidad(DetRequisitosModalidad detRequisitosModalidad) {
//		getDetRequisitosModalidads().remove(detRequisitosModalidad);
//		detRequisitosModalidad.setCrcFlujoTramite(null);
//
//		return detRequisitosModalidad;
//	}

	// bi-directional many-to-one association to DetTelefonoProtesta
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetTelefonoProtesta> getDetTelefonoProtestas() {
//		return this.detTelefonoProtestas;
//	}
//
//	public void setDetTelefonoProtestas(List<DetTelefonoProtesta> detTelefonoProtestas) {
//		this.detTelefonoProtestas = detTelefonoProtestas;
//	}
//
//	public DetTelefonoProtesta addDetTelefonoProtesta(DetTelefonoProtesta detTelefonoProtesta) {
//		getDetTelefonoProtestas().add(detTelefonoProtesta);
//		detTelefonoProtesta.setCrcFlujoTramite(this);
//
//		return detTelefonoProtesta;
//	}
//
//	public DetTelefonoProtesta removeDetTelefonoProtesta(DetTelefonoProtesta detTelefonoProtesta) {
//		getDetTelefonoProtestas().remove(detTelefonoProtesta);
//		detTelefonoProtesta.setCrcFlujoTramite(null);
//
//		return detTelefonoProtesta;
//	}

	// bi-directional many-to-one association to DetTelefonosRegistrado
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetTelefonosRegistrado> getDetTelefonosRegistrados() {
//		return this.detTelefonosRegistrados;
//	}
//
//	public void setDetTelefonosRegistrados(List<DetTelefonosRegistrado> detTelefonosRegistrados) {
//		this.detTelefonosRegistrados = detTelefonosRegistrados;
//	}
//
//	public DetTelefonosRegistrado addDetTelefonosRegistrado(DetTelefonosRegistrado detTelefonosRegistrado) {
//		getDetTelefonosRegistrados().add(detTelefonosRegistrado);
//		detTelefonosRegistrado.setCrcFlujoTramite(this);
//
//		return detTelefonosRegistrado;
//	}
//
//	public DetTelefonosRegistrado removeDetTelefonosRegistrado(DetTelefonosRegistrado detTelefonosRegistrado) {
//		getDetTelefonosRegistrados().remove(detTelefonosRegistrado);
//		detTelefonosRegistrado.setCrcFlujoTramite(null);
//
//		return detTelefonosRegistrado;
//	}

	// bi-directional many-to-one association to DetUnidadesAdmResp
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetUnidadesAdmResp> getDetUnidadesAdmResps() {
//		return this.detUnidadesAdmResps;
//	}
//
//	public void setDetUnidadesAdmResps(List<DetUnidadesAdmResp> detUnidadesAdmResps) {
//		this.detUnidadesAdmResps = detUnidadesAdmResps;
//	}
//
//	public DetUnidadesAdmResp addDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
//		getDetUnidadesAdmResps().add(detUnidadesAdmResp);
//		detUnidadesAdmResp.setCrcFlujoTramite(this);
//
//		return detUnidadesAdmResp;
//	}
//
//	public DetUnidadesAdmResp removeDetUnidadesAdmResp(DetUnidadesAdmResp detUnidadesAdmResp) {
//		getDetUnidadesAdmResps().remove(detUnidadesAdmResp);
//		detUnidadesAdmResp.setCrcFlujoTramite(null);
//
//		return detUnidadesAdmResp;
//	}

	// bi-directional many-to-one association to DetUrlRegistrado
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetUrlRegistrado> getDetUrlRegistrados() {
//		return this.detUrlRegistrados;
//	}
//
//	public void setDetUrlRegistrados(List<DetUrlRegistrado> detUrlRegistrados) {
//		this.detUrlRegistrados = detUrlRegistrados;
//	}

//	public DetUrlRegistrado addDetUrlRegistrado(DetUrlRegistrado detUrlRegistrado) {
//		getDetUrlRegistrados().add(detUrlRegistrado);
//		detUrlRegistrado.setCrcFlujoTramite(this);
//
//		return detUrlRegistrado;
//	}
//
//	public DetUrlRegistrado removeDetUrlRegistrado(DetUrlRegistrado detUrlRegistrado) {
//		getDetUrlRegistrados().remove(detUrlRegistrado);
//		detUrlRegistrado.setCrcFlujoTramite(null);
//
//		return detUrlRegistrado;
//	}

	// bi-directional many-to-one association to DetVigencia
	@OneToMany(mappedBy = "crcFlujoTramite")
	public List<DetVigencia> getDetVigencias() {
		return this.detVigencias;
	}

	public void setDetVigencias(List<DetVigencia> detVigencias) {
		this.detVigencias = detVigencias;
	}

//	public DetVigencia addDetVigencia(DetVigencia detVigencia) {
//		getDetVigencias().add(detVigencia);
//		detVigencia.setCrcFlujoTramite(this);
//
//		return detVigencia;
//	}
//
//	public DetVigencia removeDetVigencia(DetVigencia detVigencia) {
//		getDetVigencias().remove(detVigencia);
//		detVigencia.setCrcFlujoTramite(null);
//
//		return detVigencia;
//	}

	// bi-directional many-to-one association to DetVigenciaModalidad
	@OneToMany(mappedBy = "crcFlujoTramite")
	public List<DetVigenciaModalidad> getDetVigenciaModalidads() {
		return this.detVigenciaModalidads;
	}

	public void setDetVigenciaModalidads(List<DetVigenciaModalidad> detVigenciaModalidads) {
		this.detVigenciaModalidads = detVigenciaModalidads;
	}

//	public DetVigenciaModalidad addDetVigenciaModalidad(DetVigenciaModalidad detVigenciaModalidad) {
//		getDetVigenciaModalidads().add(detVigenciaModalidad);
//		detVigenciaModalidad.setCrcFlujoTramite(this);
//
//		return detVigenciaModalidad;
//	}
//
//	public DetVigenciaModalidad removeDetVigenciaModalidad(DetVigenciaModalidad detVigenciaModalidad) {
//		getDetVigenciaModalidads().remove(detVigenciaModalidad);
//		detVigenciaModalidad.setCrcFlujoTramite(null);
//
//		return detVigenciaModalidad;
//	}

	// bi-directional many-to-one association to DetConceptosCosto
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<DetConceptosCosto> getDetConceptosCostos() {
//		return this.detConceptosCostos;
//	}
//
//	public void setDetConceptosCostos(List<DetConceptosCosto> detConceptosCostos) {
//		this.detConceptosCostos = detConceptosCostos;
//	}

//	public DetConceptosCosto addDetConceptosCosto(DetConceptosCosto detConceptosCosto) {
//		getDetConceptosCostos().add(detConceptosCosto);
//		detConceptosCosto.setCrcFlujoTramite(this);
//
//		return detConceptosCosto;
//	}
//
//	public DetConceptosCosto removeDetConceptosCosto(DetConceptosCosto detConceptosCosto) {
//		getDetConceptosCostos().remove(detConceptosCosto);
//		detConceptosCosto.setCrcFlujoTramite(null);
//
//		return detConceptosCosto;
//	}

	// bi-directional many-to-one association to TramiteServicio2
	@ManyToOne
	@JoinColumn(name = "id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	// bi-directional many-to-one association to CrcObservacionesEnlace
//	@OneToMany(mappedBy = "crcFlujoTramite")
//	public List<CrcObservacionesEnlace> getCrcObservacionesEnlaces() {
//		return this.crcObservacionesEnlaces;
//	}
//
//	public void setCrcObservacionesEnlaces(List<CrcObservacionesEnlace> crcObservacionesEnlaces) {
//		this.crcObservacionesEnlaces = crcObservacionesEnlaces;
//	}

//	public CrcObservacionesEnlace addCrcObservacionesEnlace(CrcObservacionesEnlace crcObservacionesEnlace) {
//		getCrcObservacionesEnlaces().add(crcObservacionesEnlace);
//		crcObservacionesEnlace.setCrcFlujoTramite(this);
//
//		return crcObservacionesEnlace;
//	}
//
//	public CrcObservacionesEnlace removeCrcObservacionesEnlace(CrcObservacionesEnlace crcObservacionesEnlace) {
//		getCrcObservacionesEnlaces().remove(crcObservacionesEnlace);
//		crcObservacionesEnlace.setCrcFlujoTramite(null);
//
//		return crcObservacionesEnlace;
//	}
}