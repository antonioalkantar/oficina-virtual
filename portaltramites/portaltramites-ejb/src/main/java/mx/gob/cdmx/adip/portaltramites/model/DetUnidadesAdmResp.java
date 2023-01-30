package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_unidades_adm_resp database table.
 * 
 */
@Entity
@Table(name="det_unidades_adm_resp", schema = "retys_v2")
@NamedQueries({
//	@NamedQuery(name="DetUnidadesAdmResp.findByIdTramite"
//			, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetUnidadesAdmRespDTO"
//					+ " ("
//					+ "  c.id "
//					+ ", ts.id"
//					+ ", ts.homoclave"
//					+ ", ts.nombreOficial"
//					+ ", c.numeroUnidades"
//					+ ", cua.id"
//					+ ", cua.nombre"
//					+ ", ctv.id"
//					+ ", ctv.descripcion"
//					+ ", c.calle"
//					+ ", c.numExterior"
//					+ ", c.numInterior"
//					+ ", ca.idAlcaldia"
//					+ ", ca.idEstado"
//					+ ", ca.idMunicipioPorEstado"
//					+ ", ca.municipio"
//					+ ", cas.idAsentamiento"
//					+ ", cas.asentamiento"
//					+ ", ccp.idCodigoPostal"
//					+ ", ccp.codigoPostal"
//					+ ", c.telefono"
//					+ ", c.email"
//					+ ", cft.id"
//					+ ", c.situacion"
//					+ ") "
//					+ "FROM DetUnidadesAdmResp c "
//					+ "JOIN c.tramiteServicio ts "
//					+ "JOIN c.crcFlujoTramite cft "
//					+ "JOIN c.catUnidadesAdministrativa cua "
//					+ "JOIN c.catTipoVialidad ctv "
//					+ "JOIN c.catCodigosPostale ccp "
//					+ "JOIN c.catAlcaldia ca "
//					+ "JOIN c.catAsentamiento cas "
//					+ "WHERE ts.id = :idTramite ORDER BY c.id ASC"
//				),
//	@NamedQuery(name="DetUnidadesAdmResp.findByIdTramiteWithComments"
//	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetUnidadesAdmRespDTO"
//			+ " ("
//			+ "  c.id "
//			+ ", ts.id"
//			+ ", ts.homoclave"
//			+ ", ts.nombreOficial"
//			+ ", c.numeroUnidades"
//			+ ", cua.id"
//			+ ", cua.nombre"
//			+ ", ctv.id"
//			+ ", ctv.descripcion"
//			+ ", c.calle"
//			+ ", c.numExterior"
//			+ ", c.numInterior"
//			+ ", ca.idAlcaldia"
//			+ ", ca.idEstado"
//			+ ", ca.idMunicipioPorEstado"
//			+ ", ca.municipio"
//			+ ", cas.idAsentamiento"
//			+ ", cas.asentamiento"
//			+ ", ccp.idCodigoPostal"
//			+ ", ccp.codigoPostal"
//			+ ", c.telefono"
//			+ ", c.email"
//			+ ", cft.id"
//			+ ", c.situacion"
//			+ ", modf.id"
//			+ ", modf.fundamento"
//			+ ", modf.motivo) "
//			+ "FROM DetUnidadesAdmResp c "
//			+ "JOIN c.tramiteServicio ts "
//			+ "JOIN c.crcFlujoTramite cft "
//			+ "JOIN c.catUnidadesAdministrativa cua "
//			+ "JOIN c.catTipoVialidad ctv "
//			+ "JOIN c.catCodigosPostale ccp "
//			+ "JOIN c.catAlcaldia ca "
//			+ "JOIN c.catAsentamiento cas "
//			+ "LEFT JOIN CrcModificacion modf ON modf.idTramite =c.tramiteServicio.id "
//			+ "WHERE ts.id = :idTramite ORDER BY c.id ASC"
//		)
//	, 	@NamedQuery(name="DetUnidadesAdmResp.findByIdTramiteFlujo"
//			, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetUnidadesAdmRespDTO"
//					+ "("
//					+ "  COALESCE(max(ts.id), 0) "
//					+ ") "
//					+ "FROM DetUnidadesAdmResp c "
//					+ "JOIN c.tramiteServicio ts "
//					+ "WHERE ts.id = :idTramite "
//				),
//		@NamedQuery(name="DetUnidadesAdmResp.findByIdTramiteFlujoAddInfo"
//		, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetUnidadesAdmRespDTO"
//				+ "("
//				+ "  c.id , c.numeroUnidades, c.situacion"
//				+ ") "
//				+ "FROM DetUnidadesAdmResp c "
//				+ "WHERE c.tramiteServicio.id = :idTramite"
//			),
		@NamedQuery(name="DetUnidadesAdmResp.totalRegistrosByIdTramite"
		, query="select count(uar) from DetUnidadesAdmResp uar where uar.tramiteServicio.id = :idTramite and uar.situacion = true"),
		
		@NamedQuery(name="DetUnidadesAdmResp.borrar",
		query="DELETE FROM DetUnidadesAdmResp drp "
			+ " WHERE drp.id=:idfila"),
		
})
public class DetUnidadesAdmResp implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String calle;
	private String email;
	private String numExterior;
	private String numInterior;
	private String telefono;
	private Long numeroUnidades;
	private Boolean situacion;
	private List<DetHorariosUnidAdmResp> detHorariosUnidAdmResps;
//	private CatAlcaldia catAlcaldia;
//	private CatAsentamiento catAsentamiento;
//	private CatCodigosPostale catCodigosPostale;
	private CatTipoVialidad catTipoVialidad;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private CatUnidadesAdministrativa catUnidadesAdministrativa;
//	private List<CrcObservacionesUnidadAdm> crcObservacionesUnidadAdms;

	public DetUnidadesAdmResp() {
	}

	public DetUnidadesAdmResp(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="num_exterior")
	public String getNumExterior() {
		return this.numExterior;
	}

	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}


	@Column(name="num_interior")
	public String getNumInterior() {
		return this.numInterior;
	}

	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}


	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Column(name="numero_unidades")
	public Long getNumeroUnidades() {
		return this.numeroUnidades;
	}

	public void setNumeroUnidades(Long numeroUnidades) {
		this.numeroUnidades = numeroUnidades;
	}

	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	//bi-directional many-to-one association to DetHorariosUnidAdmResp
	@OneToMany(mappedBy="detUnidadesAdmResp")
	public List<DetHorariosUnidAdmResp> getDetHorariosUnidAdmResps() {
		return this.detHorariosUnidAdmResps;
	}

	public void setDetHorariosUnidAdmResps(List<DetHorariosUnidAdmResp> detHorariosUnidAdmResps) {
		this.detHorariosUnidAdmResps = detHorariosUnidAdmResps;
	}

	public DetHorariosUnidAdmResp addDetHorariosUnidAdmResp(DetHorariosUnidAdmResp detHorariosUnidAdmResp) {
		getDetHorariosUnidAdmResps().add(detHorariosUnidAdmResp);
		detHorariosUnidAdmResp.setDetUnidadesAdmResp(this);

		return detHorariosUnidAdmResp;
	}

	public DetHorariosUnidAdmResp removeDetHorariosUnidAdmResp(DetHorariosUnidAdmResp detHorariosUnidAdmResp) {
		getDetHorariosUnidAdmResps().remove(detHorariosUnidAdmResp);
		detHorariosUnidAdmResp.setDetUnidadesAdmResp(null);

		return detHorariosUnidAdmResp;
	}


	//bi-directional many-to-one association to CatAlcaldia
//	@ManyToOne
//	@JoinColumn(name="id_alcaldia")
//	public CatAlcaldia getCatAlcaldia() {
//		return this.catAlcaldia;
//	}
//
//	public void setCatAlcaldia(CatAlcaldia catAlcaldia) {
//		this.catAlcaldia = catAlcaldia;
//	}


	//bi-directional many-to-one association to CatAsentamiento
//	@ManyToOne
//	@JoinColumn(name="id_asentamiento")
//	public CatAsentamiento getCatAsentamiento() {
//		return this.catAsentamiento;
//	}
//
//	public void setCatAsentamiento(CatAsentamiento catAsentamiento) {
//		this.catAsentamiento = catAsentamiento;
//	}


	//bi-directional many-to-one association to CatCodigosPostale
//	@ManyToOne
//	@JoinColumn(name="id_codigo_postal")
//	public CatCodigosPostale getCatCodigosPostale() {
//		return this.catCodigosPostale;
//	}
//
//	public void setCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
//		this.catCodigosPostale = catCodigosPostale;
//	}


	//bi-directional many-to-one association to CatTipoVialidad
	@ManyToOne
	@JoinColumn(name="id_tipo_vialidad")
	public CatTipoVialidad getCatTipoVialidad() {
		return this.catTipoVialidad;
	}

	public void setCatTipoVialidad(CatTipoVialidad catTipoVialidad) {
		this.catTipoVialidad = catTipoVialidad;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}
	
	//bi-directional many-to-one association to CatUnidadesAdministrativa2
	@ManyToOne
	@JoinColumn(name="id_area_administrativa")
	public CatUnidadesAdministrativa getCatUnidadesAdministrativa() {
		return this.catUnidadesAdministrativa;
	}

	public void setCatUnidadesAdministrativa(CatUnidadesAdministrativa catUnidadesAdministrativa) {
		this.catUnidadesAdministrativa = catUnidadesAdministrativa;
	}
	
	//bi-directional many-to-one association to CrcObservacionesUnidadAdm
//	@OneToMany(mappedBy="detUnidadesAdmResp")
//	public List<CrcObservacionesUnidadAdm> getCrcObservacionesUnidadAdms() {
//		return this.crcObservacionesUnidadAdms;
//	}
//
//	public void setCrcObservacionesUnidadAdms(List<CrcObservacionesUnidadAdm> crcObservacionesUnidadAdms) {
//		this.crcObservacionesUnidadAdms = crcObservacionesUnidadAdms;
//	}
//
//	public CrcObservacionesUnidadAdm addCrcObservacionesUnidadAdm(CrcObservacionesUnidadAdm crcObservacionesUnidadAdm) {
//		getCrcObservacionesUnidadAdms().add(crcObservacionesUnidadAdm);
//		crcObservacionesUnidadAdm.setDetUnidadesAdmResp(this);
//
//		return crcObservacionesUnidadAdm;
//	}
//
//	public CrcObservacionesUnidadAdm removeCrcObservacionesUnidadAdm(CrcObservacionesUnidadAdm crcObservacionesUnidadAdm) {
//		getCrcObservacionesUnidadAdms().remove(crcObservacionesUnidadAdm);
//		crcObservacionesUnidadAdm.setDetUnidadesAdmResp(null);
//
//		return crcObservacionesUnidadAdm;
//	}

}