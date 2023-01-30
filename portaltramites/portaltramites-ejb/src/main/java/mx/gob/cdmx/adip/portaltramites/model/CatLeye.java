package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cat_leyes database table.
 * 
 */
@Entity
@Table(name = "cat_leyes", schema = "retys_v2")
//@NamedQueries({
//		@NamedQuery(name = "CatLeye.findAll", query = "select new mx.gob.cdmx.adip.retys.commons.dto.CatLeyeDTO(l.id"
//				+ ", l.nombre" + ", l.situacion) " + "from CatLeye l " + " order by l.nombre"),
//
//		@NamedQuery(name = "CatLeye.findCadenaLike", query = "select new mx.gob.cdmx.adip.retys.commons.dto.CatLeyeDTO(l.id"
//				+ ", l.nombre" + ", l.situacion) " + "from CatLeye l " + "where LOWER(l.nombre) LIKE LOWER(:cadena) "
//				+ "order by l.nombre")
//
//})
public class CatLeye implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private Boolean situacion;
	private List<CrcTramiteFundamento> crcTramiteFundamentos;
//	private List<DetCanalAtencion> detCanalAtencions;
//	private List<DetCriterioResolucion> detCriterioResolucions;
//	private List<DetInformacionRelevante> detInformacionRelevantes1;
//	private List<DetInformacionRelevante> detInformacionRelevantes2;
//	private List<DetInformacionRelevante> detInformacionRelevantes3;
//	private List<DetInformacionRelevante> detInformacionRelevantes4;
//	private List<DetMedioBanco> detMedioBancos;
//	private List<DetMedioDependencia> detMedioDependencias;
//	private List<DetMedioOficina> detMedioOficinas;
//	private List<DetMedioOnline> detMedioOnlines;
//	private List<DetMedioOtro> detMedioOtros;
//	private List<DetMedioTienda> detMedioTiendas;
	private List<DetModalidadesTramite> detModalidadesTramites1;
	private List<DetModalidadesTramite> detModalidadesTramites2;
//	private List<DetPlazoCumplirPrevencion> detPlazoCumplirPrevencions;
	private List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas;
//	private List<DetPlazoPrevenirSolicitante> detPlazoPrevenirSolicitantes;
//	private List<DetPlazoResolucionInmediata> detPlazoResolucionInmediatas;
//	private List<DetPlazoResolver> detPlazoResolvers;
	private List<DetRequisitosFormato> detRequisitosFormatos;
//	private List<DetRequisitosModalidad> detRequisitosModalidads;
	private List<DetVigencia> detVigencias;
	private List<DetVigenciaModalidad> detVigenciaModalidads;

	public CatLeye() {
	}

	public CatLeye(Long id) {

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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	// bi-directional many-to-one association to CrcTramiteFundamento
	@OneToMany(mappedBy = "catLeye")
	public List<CrcTramiteFundamento> getCrcTramiteFundamentos() {
		return this.crcTramiteFundamentos;
	}

	public void setCrcTramiteFundamentos(List<CrcTramiteFundamento> crcTramiteFundamentos) {
		this.crcTramiteFundamentos = crcTramiteFundamentos;
	}

	public CrcTramiteFundamento addCrcTramiteFundamento(CrcTramiteFundamento crcTramiteFundamento) {
		getCrcTramiteFundamentos().add(crcTramiteFundamento);
		crcTramiteFundamento.setCatLeye(this);

		return crcTramiteFundamento;
	}

	public CrcTramiteFundamento removeCrcTramiteFundamento(CrcTramiteFundamento crcTramiteFundamento) {
		getCrcTramiteFundamentos().remove(crcTramiteFundamento);
		crcTramiteFundamento.setCatLeye(null);

		return crcTramiteFundamento;
	}

	// bi-directional many-to-one association to DetCanalAtencion
//	@OneToMany(mappedBy = "catLeye")
//	public List<DetCanalAtencion> getDetCanalAtencions() {
//		return this.detCanalAtencions;
//	}
//
//	public void setDetCanalAtencions(List<DetCanalAtencion> detCanalAtencions) {
//		this.detCanalAtencions = detCanalAtencions;
//	}

//	public DetCanalAtencion addDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
//		getDetCanalAtencions().add(detCanalAtencion);
//		detCanalAtencion.setCatLeye(this);
//
//		return detCanalAtencion;
//	}
//
//	public DetCanalAtencion removeDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
//		getDetCanalAtencions().remove(detCanalAtencion);
//		detCanalAtencion.setCatLeye(null);
//
//		return detCanalAtencion;
//	}

	// bi-directional many-to-one association to DetCriterioResolucion
//	@OneToMany(mappedBy = "catLeye")
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
//		detCriterioResolucion.setCatLeye(this);
//
//		return detCriterioResolucion;
//	}

//	public DetCriterioResolucion removeDetCriterioResolucion(DetCriterioResolucion detCriterioResolucion) {
//		getDetCriterioResolucions().remove(detCriterioResolucion);
//		detCriterioResolucion.setCatLeye(null);
//
//		return detCriterioResolucion;
//	}

	// bi-directional many-to-one association to DetInformacionRelevante
//	@OneToMany(mappedBy = "catLeye1")
//	public List<DetInformacionRelevante> getDetInformacionRelevantes1() {
//		return this.detInformacionRelevantes1;
//	}
//
//	public void setDetInformacionRelevantes1(List<DetInformacionRelevante> detInformacionRelevantes1) {
//		this.detInformacionRelevantes1 = detInformacionRelevantes1;
//	}
//
//	public DetInformacionRelevante addDetInformacionRelevantes1(DetInformacionRelevante detInformacionRelevantes1) {
//		getDetInformacionRelevantes1().add(detInformacionRelevantes1);
//		detInformacionRelevantes1.setCatLeye1(this);
//
//		return detInformacionRelevantes1;
//	}
//
//	public DetInformacionRelevante removeDetInformacionRelevantes1(DetInformacionRelevante detInformacionRelevantes1) {
//		getDetInformacionRelevantes1().remove(detInformacionRelevantes1);
//		detInformacionRelevantes1.setCatLeye1(null);
//
//		return detInformacionRelevantes1;
//	}

	// bi-directional many-to-one association to DetInformacionRelevante
//	@OneToMany(mappedBy = "catLeye2")
//	public List<DetInformacionRelevante> getDetInformacionRelevantes2() {
//		return this.detInformacionRelevantes2;
//	}
//
//	public void setDetInformacionRelevantes2(List<DetInformacionRelevante> detInformacionRelevantes2) {
//		this.detInformacionRelevantes2 = detInformacionRelevantes2;
//	}
//
//	public DetInformacionRelevante addDetInformacionRelevantes2(DetInformacionRelevante detInformacionRelevantes2) {
//		getDetInformacionRelevantes2().add(detInformacionRelevantes2);
//		detInformacionRelevantes2.setCatLeye2(this);
//
//		return detInformacionRelevantes2;
//	}
//
//	public DetInformacionRelevante removeDetInformacionRelevantes2(DetInformacionRelevante detInformacionRelevantes2) {
//		getDetInformacionRelevantes2().remove(detInformacionRelevantes2);
//		detInformacionRelevantes2.setCatLeye2(null);
//
//		return detInformacionRelevantes2;
//	}

	// bi-directional many-to-one association to DetInformacionRelevante
//	@OneToMany(mappedBy = "catLeye3")
//	public List<DetInformacionRelevante> getDetInformacionRelevantes3() {
//		return this.detInformacionRelevantes3;
//	}
//
//	public void setDetInformacionRelevantes3(List<DetInformacionRelevante> detInformacionRelevantes3) {
//		this.detInformacionRelevantes3 = detInformacionRelevantes3;
//	}
//
//	public DetInformacionRelevante addDetInformacionRelevantes3(DetInformacionRelevante detInformacionRelevantes3) {
//		getDetInformacionRelevantes3().add(detInformacionRelevantes3);
//		detInformacionRelevantes3.setCatLeye3(this);
//
//		return detInformacionRelevantes3;
//	}
//
//	public DetInformacionRelevante removeDetInformacionRelevantes3(DetInformacionRelevante detInformacionRelevantes3) {
//		getDetInformacionRelevantes3().remove(detInformacionRelevantes3);
//		detInformacionRelevantes3.setCatLeye3(null);
//
//		return detInformacionRelevantes3;
//	}

	// bi-directional many-to-one association to DetInformacionRelevante
//	@OneToMany(mappedBy = "catLeye4")
//	public List<DetInformacionRelevante> getDetInformacionRelevantes4() {
//		return this.detInformacionRelevantes4;
//	}
//
//	public void setDetInformacionRelevantes4(List<DetInformacionRelevante> detInformacionRelevantes4) {
//		this.detInformacionRelevantes4 = detInformacionRelevantes4;
//	}
//
//	public DetInformacionRelevante addDetInformacionRelevantes4(DetInformacionRelevante detInformacionRelevantes4) {
//		getDetInformacionRelevantes4().add(detInformacionRelevantes4);
//		detInformacionRelevantes4.setCatLeye4(this);
//
//		return detInformacionRelevantes4;
//	}
//
//	public DetInformacionRelevante removeDetInformacionRelevantes4(DetInformacionRelevante detInformacionRelevantes4) {
//		getDetInformacionRelevantes4().remove(detInformacionRelevantes4);
//		detInformacionRelevantes4.setCatLeye4(null);
//
//		return detInformacionRelevantes4;
//	}

	// bi-directional many-to-one association to DetMedioBanco
//	@OneToMany(mappedBy = "catLeye")
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
//		detMedioBanco.setCatLeye(this);
//
//		return detMedioBanco;
//	}
//
//	public DetMedioBanco removeDetMedioBanco(DetMedioBanco detMedioBanco) {
//		getDetMedioBancos().remove(detMedioBanco);
//		detMedioBanco.setCatLeye(null);
//
//		return detMedioBanco;
//	}

	// bi-directional many-to-one association to DetMedioDependencia
//	@OneToMany(mappedBy = "catLeye")
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
//		detMedioDependencia.setCatLeye(this);
//
//		return detMedioDependencia;
//	}
//
//	public DetMedioDependencia removeDetMedioDependencia(DetMedioDependencia detMedioDependencia) {
//		getDetMedioDependencias().remove(detMedioDependencia);
//		detMedioDependencia.setCatLeye(null);
//
//		return detMedioDependencia;
//	}

	// bi-directional many-to-one association to DetMedioOficina
//	@OneToMany(mappedBy = "catLeye")
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
//		detMedioOficina.setCatLeye(this);
//
//		return detMedioOficina;
//	}
//
//	public DetMedioOficina removeDetMedioOficina(DetMedioOficina detMedioOficina) {
//		getDetMedioOficinas().remove(detMedioOficina);
//		detMedioOficina.setCatLeye(null);
//
//		return detMedioOficina;
//	}

	// bi-directional many-to-one association to DetMedioOnline
//	@OneToMany(mappedBy = "catLeye")
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
//		detMedioOnline.setCatLeye(this);
//
//		return detMedioOnline;
//	}
//
//	public DetMedioOnline removeDetMedioOnline(DetMedioOnline detMedioOnline) {
//		getDetMedioOnlines().remove(detMedioOnline);
//		detMedioOnline.setCatLeye(null);
//
//		return detMedioOnline;
//	}

	// bi-directional many-to-one association to DetMedioOtro
//	@OneToMany(mappedBy = "catLeye")
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
//		detMedioOtro.setCatLeye(this);
//
//		return detMedioOtro;
//	}
//
//	public DetMedioOtro removeDetMedioOtro(DetMedioOtro detMedioOtro) {
//		getDetMedioOtros().remove(detMedioOtro);
//		detMedioOtro.setCatLeye(null);
//
//		return detMedioOtro;
//	}

	// bi-directional many-to-one association to DetMedioTienda
//	@OneToMany(mappedBy = "catLeye")
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
//		detMedioTienda.setCatLeye(this);
//
//		return detMedioTienda;
//	}
//
//	public DetMedioTienda removeDetMedioTienda(DetMedioTienda detMedioTienda) {
//		getDetMedioTiendas().remove(detMedioTienda);
//		detMedioTienda.setCatLeye(null);
//
//		return detMedioTienda;
//	}

	// bi-directional many-to-one association to DetModalidadesTramite
	@OneToMany(mappedBy = "catLeye1")
	public List<DetModalidadesTramite> getDetModalidadesTramites1() {
		return this.detModalidadesTramites1;
	}

	public void setDetModalidadesTramites1(List<DetModalidadesTramite> detModalidadesTramites1) {
		this.detModalidadesTramites1 = detModalidadesTramites1;
	}

	public DetModalidadesTramite addDetModalidadesTramites1(DetModalidadesTramite detModalidadesTramites1) {
		getDetModalidadesTramites1().add(detModalidadesTramites1);
		detModalidadesTramites1.setCatLeye1(this);

		return detModalidadesTramites1;
	}

	public DetModalidadesTramite removeDetModalidadesTramites1(DetModalidadesTramite detModalidadesTramites1) {
		getDetModalidadesTramites1().remove(detModalidadesTramites1);
		detModalidadesTramites1.setCatLeye1(null);

		return detModalidadesTramites1;
	}

	// bi-directional many-to-one association to DetModalidadesTramite
	@OneToMany(mappedBy = "catLeye2")
	public List<DetModalidadesTramite> getDetModalidadesTramites2() {
		return this.detModalidadesTramites2;
	}

	public void setDetModalidadesTramites2(List<DetModalidadesTramite> detModalidadesTramites2) {
		this.detModalidadesTramites2 = detModalidadesTramites2;
	}

	public DetModalidadesTramite addDetModalidadesTramites2(DetModalidadesTramite detModalidadesTramites2) {
		getDetModalidadesTramites2().add(detModalidadesTramites2);
		detModalidadesTramites2.setCatLeye2(this);

		return detModalidadesTramites2;
	}

	public DetModalidadesTramite removeDetModalidadesTramites2(DetModalidadesTramite detModalidadesTramites2) {
		getDetModalidadesTramites2().remove(detModalidadesTramites2);
		detModalidadesTramites2.setCatLeye2(null);

		return detModalidadesTramites2;
	}

	// bi-directional many-to-one association to DetPlazoCumplirPrevencion
//	@OneToMany(mappedBy = "catLeye")
//	public List<DetPlazoCumplirPrevencion> getDetPlazoCumplirPrevencions() {
//		return this.detPlazoCumplirPrevencions;
//	}
//
//	public void setDetPlazoCumplirPrevencions(List<DetPlazoCumplirPrevencion> detPlazoCumplirPrevencions) {
//		this.detPlazoCumplirPrevencions = detPlazoCumplirPrevencions;
//	}
//
//	public DetPlazoCumplirPrevencion addDetPlazoCumplirPrevencion(DetPlazoCumplirPrevencion detPlazoCumplirPrevencion) {
//		getDetPlazoCumplirPrevencions().add(detPlazoCumplirPrevencion);
//		detPlazoCumplirPrevencion.setCatLeye(this);
//
//		return detPlazoCumplirPrevencion;
//	}
//
//	public DetPlazoCumplirPrevencion removeDetPlazoCumplirPrevencion(
//			DetPlazoCumplirPrevencion detPlazoCumplirPrevencion) {
//		getDetPlazoCumplirPrevencions().remove(detPlazoCumplirPrevencion);
//		detPlazoCumplirPrevencion.setCatLeye(null);
//
//		return detPlazoCumplirPrevencion;
//	}

	// bi-directional many-to-one association to DetPlazoMaximoRespuesta
	@OneToMany(mappedBy = "catLeye")
	public List<DetPlazoMaximoRespuesta> getDetPlazoMaximoRespuestas() {
		return this.detPlazoMaximoRespuestas;
	}

	public void setDetPlazoMaximoRespuestas(List<DetPlazoMaximoRespuesta> detPlazoMaximoRespuestas) {
		this.detPlazoMaximoRespuestas = detPlazoMaximoRespuestas;
	}

	public DetPlazoMaximoRespuesta addDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
		getDetPlazoMaximoRespuestas().add(detPlazoMaximoRespuesta);
		detPlazoMaximoRespuesta.setCatLeye(this);

		return detPlazoMaximoRespuesta;
	}

	public DetPlazoMaximoRespuesta removeDetPlazoMaximoRespuesta(DetPlazoMaximoRespuesta detPlazoMaximoRespuesta) {
		getDetPlazoMaximoRespuestas().remove(detPlazoMaximoRespuesta);
		detPlazoMaximoRespuesta.setCatLeye(null);

		return detPlazoMaximoRespuesta;
	}

	// bi-directional many-to-one association to DetPlazoPrevenirSolicitante
//	@OneToMany(mappedBy = "catLeye")
//	public List<DetPlazoPrevenirSolicitante> getDetPlazoPrevenirSolicitantes() {
//		return this.detPlazoPrevenirSolicitantes;
//	}
//
//	public void setDetPlazoPrevenirSolicitantes(List<DetPlazoPrevenirSolicitante> detPlazoPrevenirSolicitantes) {
//		this.detPlazoPrevenirSolicitantes = detPlazoPrevenirSolicitantes;
//	}
//
//	public DetPlazoPrevenirSolicitante addDetPlazoPrevenirSolicitante(
//			DetPlazoPrevenirSolicitante detPlazoPrevenirSolicitante) {
//		getDetPlazoPrevenirSolicitantes().add(detPlazoPrevenirSolicitante);
//		detPlazoPrevenirSolicitante.setCatLeye(this);
//
//		return detPlazoPrevenirSolicitante;
//	}
//
//	public DetPlazoPrevenirSolicitante removeDetPlazoPrevenirSolicitante(
//			DetPlazoPrevenirSolicitante detPlazoPrevenirSolicitante) {
//		getDetPlazoPrevenirSolicitantes().remove(detPlazoPrevenirSolicitante);
//		detPlazoPrevenirSolicitante.setCatLeye(null);
//
//		return detPlazoPrevenirSolicitante;
//	}

	// bi-directional many-to-one association to DetPlazoResolucionInmediata
//	@OneToMany(mappedBy = "catLeye")
//	public List<DetPlazoResolucionInmediata> getDetPlazoResolucionInmediatas() {
//		return this.detPlazoResolucionInmediatas;
//	}
//
//	public void setDetPlazoResolucionInmediatas(List<DetPlazoResolucionInmediata> detPlazoResolucionInmediatas) {
//		this.detPlazoResolucionInmediatas = detPlazoResolucionInmediatas;
//	}
//
//	public DetPlazoResolucionInmediata addDetPlazoResolucionInmediata(
//			DetPlazoResolucionInmediata detPlazoResolucionInmediata) {
//		getDetPlazoResolucionInmediatas().add(detPlazoResolucionInmediata);
//		detPlazoResolucionInmediata.setCatLeye(this);
//
//		return detPlazoResolucionInmediata;
//	}
//
//	public DetPlazoResolucionInmediata removeDetPlazoResolucionInmediata(
//			DetPlazoResolucionInmediata detPlazoResolucionInmediata) {
//		getDetPlazoResolucionInmediatas().remove(detPlazoResolucionInmediata);
//		detPlazoResolucionInmediata.setCatLeye(null);
//
//		return detPlazoResolucionInmediata;
//	}

	// bi-directional many-to-one association to DetPlazoResolver
//	@OneToMany(mappedBy = "catLeye")
//	public List<DetPlazoResolver> getDetPlazoResolvers() {
//		return this.detPlazoResolvers;
//	}
//
//	public void setDetPlazoResolvers(List<DetPlazoResolver> detPlazoResolvers) {
//		this.detPlazoResolvers = detPlazoResolvers;
//	}
//
//	public DetPlazoResolver addDetPlazoResolver(DetPlazoResolver detPlazoResolver) {
//		getDetPlazoResolvers().add(detPlazoResolver);
//		detPlazoResolver.setCatLeye(this);
//
//		return detPlazoResolver;
//	}
//
//	public DetPlazoResolver removeDetPlazoResolver(DetPlazoResolver detPlazoResolver) {
//		getDetPlazoResolvers().remove(detPlazoResolver);
//		detPlazoResolver.setCatLeye(null);
//
//		return detPlazoResolver;
//	}

	// bi-directional many-to-one association to DetRequisitosFormato
	@OneToMany(mappedBy = "catLeye")
	public List<DetRequisitosFormato> getDetRequisitosFormatos() {
		return this.detRequisitosFormatos;
	}

	public void setDetRequisitosFormatos(List<DetRequisitosFormato> detRequisitosFormatos) {
		this.detRequisitosFormatos = detRequisitosFormatos;
	}

	public DetRequisitosFormato addDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
		getDetRequisitosFormatos().add(detRequisitosFormato);
		detRequisitosFormato.setCatLeye(this);

		return detRequisitosFormato;
	}

	public DetRequisitosFormato removeDetRequisitosFormato(DetRequisitosFormato detRequisitosFormato) {
		getDetRequisitosFormatos().remove(detRequisitosFormato);
		detRequisitosFormato.setCatLeye(null);

		return detRequisitosFormato;
	}

	// bi-directional many-to-one association to DetRequisitosModalidad
//	@OneToMany(mappedBy = "catLeye")
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
//		detRequisitosModalidad.setCatLeye(this);
//
//		return detRequisitosModalidad;
//	}
//
//	public DetRequisitosModalidad removeDetRequisitosModalidad(DetRequisitosModalidad detRequisitosModalidad) {
//		getDetRequisitosModalidads().remove(detRequisitosModalidad);
//		detRequisitosModalidad.setCatLeye(null);
//
//		return detRequisitosModalidad;
//	}

	// bi-directional many-to-one association to DetVigencia
	@OneToMany(mappedBy = "catLeye")
	public List<DetVigencia> getDetVigencias() {
		return this.detVigencias;
	}

	public void setDetVigencias(List<DetVigencia> detVigencias) {
		this.detVigencias = detVigencias;
	}

	public DetVigencia addDetVigencia(DetVigencia detVigencia) {
		getDetVigencias().add(detVigencia);
		detVigencia.setCatLeye(this);

		return detVigencia;
	}

	public DetVigencia removeDetVigencia(DetVigencia detVigencia) {
		getDetVigencias().remove(detVigencia);
		detVigencia.setCatLeye(null);

		return detVigencia;
	}

	// bi-directional many-to-one association to DetVigenciaModalidad
	@OneToMany(mappedBy = "catLeye")
	public List<DetVigenciaModalidad> getDetVigenciaModalidads() {
		return this.detVigenciaModalidads;
	}

	public void setDetVigenciaModalidads(List<DetVigenciaModalidad> detVigenciaModalidads) {
		this.detVigenciaModalidads = detVigenciaModalidads;
	}

	public DetVigenciaModalidad addDetVigenciaModalidad(DetVigenciaModalidad detVigenciaModalidad) {
		getDetVigenciaModalidads().add(detVigenciaModalidad);
		detVigenciaModalidad.setCatLeye(this);

		return detVigenciaModalidad;
	}

	public DetVigenciaModalidad removeDetVigenciaModalidad(DetVigenciaModalidad detVigenciaModalidad) {
		getDetVigenciaModalidads().remove(detVigenciaModalidad);
		detVigenciaModalidad.setCatLeye(null);

		return detVigenciaModalidad;
	}

}