package mx.gob.cdmx.adip.portaltramites.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "programs", schema = "public")
@NamedQueries({
@NamedQuery(name="Programs.buscarProgramasSociales",
	query="SELECT new mx.gob.cdmx.adip.sibis.dto.ProgramasSocialesDTO"
		+ " ( "
		+ "p.anio, "
		+ "p.id, "
		+ "p.clave, "
		+ "r.descripcion, "
		+ "p.description, "
		+ "cdr.idDependenciaRetys, "
		+ "c.id, "
		+ "c.descripcion, "
		+ "p.palabrasClave, "
		+ "p.esDigital, "
		+ "r.urlPrograma, "
		+ "p.activo, "
		+ "cdr.nombreDependencia "
		+ ") "
		+ " FROM Programs p "
		+ " INNER JOIN p.responsibleUnits d "
		+ " INNER JOIN d.catDependenciaRetys cdr"
		+ " INNER JOIN p.categorias c "
		+ " LEFT JOIN p.resumenesProgramas r "
		+ " WHERE p.anio =: year "
		+ " AND p.catEstatusRevisionId in (7,9) "
		+ " AND p.isProgramaAccion = '1' "
		+ " AND p.activo = true "
		+ " ORDER BY p.id ASC"
		)
})
public class Programs implements java.io.Serializable {

	private static final long serialVersionUID = -6932681575267599203L;
	private long id;
	private String clave;
	private String objective;
	private String description;
	private int anio;
	private ResponsibleUnits responsibleUnits;
	private Categorias categorias;
	private List<ResumenesProgramas> resumenesProgramas;
	private Long metaFisica;
	private Integer unitMeasurementId;
	private Double presupuestoAprobado;
	private String poblacionPotencial;
	private String poblacionObjetivo;
	private String poblacionBeneficiaria;
	private String poblacionFacilitadora;
	private String descUnidadResponsableInformacion;
	private String cargoResponsableOtorgarApoyo;
	private String correoResponsableOtorgarApoyo;
	private String telefonoResponsableOtorgarApoyo;
	private Boolean corresponsabilidad;
	private String corresponsabilidadDetalle;
	private String documentos;
	private String enlaceRop;
	private Date fechaPublicacion;
	private String paginaInternet;
	private double presupuestoEjercido;
	private String tooltipDescription;
	private Date ultimaActualizacion;
	private Date deletedAt;
	private Date createdAt;
	private Date updatedAt;
	private String fundamentoLegal;
	private String abreviatura;
	private String nombreResponsablePrograma;
	private String primerApellidoResponsablePrograma;
	private String segundoApellidoResponsablePrograma;
	private Integer ejecucionCoordinada;
	private Integer catProgramaPresupuestarioId;
	private Integer alineacionAgenda2030;
	private Integer odsId;
	private Integer metaOdsId;
	private Integer pgcdmxLineaAccionId;
	private Integer pdhCapituloId;
	private Integer vulnerableGroupId;
	private Integer derechosPrioritariosConstitucionId;
	private Integer derechosEvaluaId;
	private String antecedentes;
	private Integer programaAniosAnteriores;
	private Integer programaAnioUno;
	private String problemaAtendido;
	private String descripcionIntervencion;
	private String contribucionResolucion;
	private String fuentesInformacion;
	private Integer totalPoblacionPotencial;
	private Integer poblacionPotencialDiferenciaSexo;
	private Integer poblacionPotencialMujeres;
	private Integer poblacionPotencialHombres;
	private Integer poblacionPotencialDiferenciaEdad;
	private Integer poblacionPotencialRangoMinimo;
	private Integer poblacionPotencialRangoMaximo;
	private Integer poblacionPotencialDiferenciaGeografica;
	private String objetivoGeneral;
	private Integer tipoEstrategia;
	private Integer totalPoblacionObjetivo;
	private Integer poblacionObjetivoDiferenciaSexo;
	private Integer poblacionObjetivoMujeres;
	private Integer poblacionObjetivoHombres;
	private Integer poblacionObjetivoDiferenciaEdad;
	private Integer poblacionObjetivoRangoMinimo;
	private Integer poblacionObjetivoRangoMaximo;
	private Integer poblacionObjetivoDiferenciaGeografica;
	private Integer isBeneficiario;
	private Integer totalPoblacionBeneficiaria;
	private Integer poblacionBeneficiariaDiferenciaSexo;
	private Integer poblacionBeneficiariaMujeres;
	private Integer poblacionBeneficiariaHombres;
	private Integer poblacionBeneficiariaDiferenciaEdad;
	private Integer poblacionBeneficiariaRangoMinimo;
	private Integer poblacionBeneficiariaRangoMaximo;
	private Integer poblacionBeneficiariaDiferenciaGeografica;
	private Integer hasFacilitadores;
	private Integer totalFacilitadores;
	private Integer montoTotalFacilitadores;
	private Integer tipoBeneficiario;
	private Integer colectivosConstitucionLegal;
	private Integer numeroColectivos;
	private String objetoActividad;
	private Integer cobertura;
	private String resultadosCualitativos;
	private String metasFisicasTotales;
	private String suficienciaPresupuestalDocumento;
	private Double totalPresupuestoAutorizado;
	private Double costoTotalOperacion;
	private String erogarPresupuesto;
	private Integer frecuenciaId;
	private Double presupuestoPriTrimestre;
	private Double presupuestoSegTrimestre;
	private Double presupuestoTerTrimestre;
	private Double presupuestoCuaTrimestre;
	private String difusionProgramaSocial;
	private String incorporacionBeneficiariosFacilitadores;
	private Integer registroDomParticular;
	private Integer operacionDomParticular;
	private Integer alcanzaPlenaCobertura;
	private String criterioPriorizacion;
	private String lugaresFisicos;
	private String urlDependencias;
	private String procedimientos;
	private String unidadResponsableEvaluacion;
	private String fuentesInformacionGabinete;
	private String nombreMatrizIndicadores;
	private String descParticipacionCiudadana;
	private String modalidadParticipacionAlcance;
	private Integer articulaOtros;
	private Integer articulaAccionesCdmx;
	private Integer articulaAccionesRepublica;
	private String mecanismosIdentEvalDuplicidades;
	private String sitioBases;
	private String mecanismosDeteccionErrores;
	private Date fechaEnvio;
	private int catEstatusRevisionId;
	private int estatus;
	private Date fechaCierreEvaluacion;
	private String codigoAprobacion;
	private String numeroGaceta;
	private Date fechaPublicacionGaceta;
	private Integer pgcdmxEjesId;
	private Integer pgcdmxDerechosId;
	private int programaPadre;
	private String isProgramaAccion;
	private Date fechaInicio;
	private Date fechaVigencia;
	private String periodicidad;
	private String tipoApoyoOtorgadoAcciones;
	private String montoApoyoOtorgadoAcciones;
	private String numeroBeneficiariosAcciones;
	private Boolean accesoSimultaneoProgramaAcciones;
	private String palabrasClave;
	private Boolean esDigital;
	public Boolean activo;

	public Programs() {
	}


	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "clave", nullable = false)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "objective")
	public String getObjective() {
		return this.objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "anio", nullable = false)
	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	@ManyToOne
	@JoinColumn(name = "responsible_unit_id")	
	public ResponsibleUnits getResponsibleUnits() {
		return responsibleUnits;
	}

	public void setResponsibleUnits(ResponsibleUnits responsibleUnits) {
		this.responsibleUnits = responsibleUnits;
	}	

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	public Categorias getCategorias() {
		return this.categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
		
	@Column(name = "meta_fisica")
	public Long getMetaFisica() {
		return this.metaFisica;
	}

	public void setMetaFisica(Long metaFisica) {
		this.metaFisica = metaFisica;
	}

	@Column(name = "unit_measurement_id")
	public Integer getUnitMeasurementId() {
		return this.unitMeasurementId;
	}

	public void setUnitMeasurementId(Integer unitMeasurementId) {
		this.unitMeasurementId = unitMeasurementId;
	}

	@Column(name = "presupuesto_aprobado", precision = 17, scale = 17)
	public Double getPresupuestoAprobado() {
		return this.presupuestoAprobado;
	}

	public void setPresupuestoAprobado(Double presupuestoAprobado) {
		this.presupuestoAprobado = presupuestoAprobado;
	}

	@Column(name = "poblacion_potencial")
	public String getPoblacionPotencial() {
		return this.poblacionPotencial;
	}

	public void setPoblacionPotencial(String poblacionPotencial) {
		this.poblacionPotencial = poblacionPotencial;
	}

	@Column(name = "poblacion_objetivo")
	public String getPoblacionObjetivo() {
		return this.poblacionObjetivo;
	}

	public void setPoblacionObjetivo(String poblacionObjetivo) {
		this.poblacionObjetivo = poblacionObjetivo;
	}

	@Column(name = "poblacion_beneficiaria")
	public String getPoblacionBeneficiaria() {
		return this.poblacionBeneficiaria;
	}

	public void setPoblacionBeneficiaria(String poblacionBeneficiaria) {
		this.poblacionBeneficiaria = poblacionBeneficiaria;
	}

	@Column(name = "poblacion_facilitadora")
	public String getPoblacionFacilitadora() {
		return this.poblacionFacilitadora;
	}

	public void setPoblacionFacilitadora(String poblacionFacilitadora) {
		this.poblacionFacilitadora = poblacionFacilitadora;
	}

	@Column(name = "desc_unidad_responsable_informacion")
	public String getDescUnidadResponsableInformacion() {
		return this.descUnidadResponsableInformacion;
	}

	public void setDescUnidadResponsableInformacion(String descUnidadResponsableInformacion) {
		this.descUnidadResponsableInformacion = descUnidadResponsableInformacion;
	}

	@Column(name = "cargo_responsable_otorgar_apoyo")
	public String getCargoResponsableOtorgarApoyo() {
		return this.cargoResponsableOtorgarApoyo;
	}

	public void setCargoResponsableOtorgarApoyo(String cargoResponsableOtorgarApoyo) {
		this.cargoResponsableOtorgarApoyo = cargoResponsableOtorgarApoyo;
	}

	@Column(name = "correo_responsable_otorgar_apoyo")
	public String getCorreoResponsableOtorgarApoyo() {
		return this.correoResponsableOtorgarApoyo;
	}

	public void setCorreoResponsableOtorgarApoyo(String correoResponsableOtorgarApoyo) {
		this.correoResponsableOtorgarApoyo = correoResponsableOtorgarApoyo;
	}

	@Column(name = "telefono_responsable_otorgar_apoyo")
	public String getTelefonoResponsableOtorgarApoyo() {
		return this.telefonoResponsableOtorgarApoyo;
	}

	public void setTelefonoResponsableOtorgarApoyo(String telefonoResponsableOtorgarApoyo) {
		this.telefonoResponsableOtorgarApoyo = telefonoResponsableOtorgarApoyo;
	}

	@Column(name = "corresponsabilidad")
	public Boolean getCorresponsabilidad() {
		return this.corresponsabilidad;
	}

	public void setCorresponsabilidad(Boolean corresponsabilidad) {
		this.corresponsabilidad = corresponsabilidad;
	}

	@Column(name = "corresponsabilidad_detalle")
	public String getCorresponsabilidadDetalle() {
		return this.corresponsabilidadDetalle;
	}

	public void setCorresponsabilidadDetalle(String corresponsabilidadDetalle) {
		this.corresponsabilidadDetalle = corresponsabilidadDetalle;
	}

	@Column(name = "documentos")
	public String getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	@Column(name = "enlace_rop")
	public String getEnlaceRop() {
		return this.enlaceRop;
	}

	public void setEnlaceRop(String enlaceRop) {
		this.enlaceRop = enlaceRop;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_publicacion", length = 13)
	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Column(name = "pagina_internet")
	public String getPaginaInternet() {
		return this.paginaInternet;
	}

	public void setPaginaInternet(String paginaInternet) {
		this.paginaInternet = paginaInternet;
	}

	@Column(name = "presupuesto_ejercido", nullable = false, precision = 17, scale = 17)
	public double getPresupuestoEjercido() {
		return this.presupuestoEjercido;
	}

	public void setPresupuestoEjercido(double presupuestoEjercido) {
		this.presupuestoEjercido = presupuestoEjercido;
	}

	@Column(name = "tooltip_description")
	public String getTooltipDescription() {
		return this.tooltipDescription;
	}

	public void setTooltipDescription(String tooltipDescription) {
		this.tooltipDescription = tooltipDescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ultima_actualizacion", nullable = false, length = 13)
	public Date getUltimaActualizacion() {
		return this.ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_at", length = 22)
	public Date getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 22)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 22)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "fundamento_legal")
	public String getFundamentoLegal() {
		return this.fundamentoLegal;
	}

	public void setFundamentoLegal(String fundamentoLegal) {
		this.fundamentoLegal = fundamentoLegal;
	}

	@Column(name = "abreviatura")
	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	@Column(name = "nombre_responsable_programa")
	public String getNombreResponsablePrograma() {
		return this.nombreResponsablePrograma;
	}

	public void setNombreResponsablePrograma(String nombreResponsablePrograma) {
		this.nombreResponsablePrograma = nombreResponsablePrograma;
	}

	@Column(name = "primer_apellido_responsable_programa")
	public String getPrimerApellidoResponsablePrograma() {
		return this.primerApellidoResponsablePrograma;
	}

	public void setPrimerApellidoResponsablePrograma(String primerApellidoResponsablePrograma) {
		this.primerApellidoResponsablePrograma = primerApellidoResponsablePrograma;
	}

	@Column(name = "segundo_apellido_responsable_programa")
	public String getSegundoApellidoResponsablePrograma() {
		return this.segundoApellidoResponsablePrograma;
	}

	public void setSegundoApellidoResponsablePrograma(String segundoApellidoResponsablePrograma) {
		this.segundoApellidoResponsablePrograma = segundoApellidoResponsablePrograma;
	}

	@Column(name = "ejecucion_coordinada")
	public Integer getEjecucionCoordinada() {
		return this.ejecucionCoordinada;
	}

	public void setEjecucionCoordinada(Integer ejecucionCoordinada) {
		this.ejecucionCoordinada = ejecucionCoordinada;
	}

	@Column(name = "cat_programa_presupuestario_id")
	public Integer getCatProgramaPresupuestarioId() {
		return this.catProgramaPresupuestarioId;
	}

	public void setCatProgramaPresupuestarioId(Integer catProgramaPresupuestarioId) {
		this.catProgramaPresupuestarioId = catProgramaPresupuestarioId;
	}

	@Column(name = "alineacion_agenda_2030")
	public Integer getAlineacionAgenda2030() {
		return this.alineacionAgenda2030;
	}

	public void setAlineacionAgenda2030(Integer alineacionAgenda2030) {
		this.alineacionAgenda2030 = alineacionAgenda2030;
	}

	@Column(name = "ods_id")
	public Integer getOdsId() {
		return this.odsId;
	}

	public void setOdsId(Integer odsId) {
		this.odsId = odsId;
	}

	@Column(name = "meta_ods_id")
	public Integer getMetaOdsId() {
		return this.metaOdsId;
	}

	public void setMetaOdsId(Integer metaOdsId) {
		this.metaOdsId = metaOdsId;
	}

	@Column(name = "pgcdmx_linea_accion_id")
	public Integer getPgcdmxLineaAccionId() {
		return this.pgcdmxLineaAccionId;
	}

	public void setPgcdmxLineaAccionId(Integer pgcdmxLineaAccionId) {
		this.pgcdmxLineaAccionId = pgcdmxLineaAccionId;
	}

	@Column(name = "pdh_capitulo_id")
	public Integer getPdhCapituloId() {
		return this.pdhCapituloId;
	}

	public void setPdhCapituloId(Integer pdhCapituloId) {
		this.pdhCapituloId = pdhCapituloId;
	}

	@Column(name = "vulnerable_group_id")
	public Integer getVulnerableGroupId() {
		return this.vulnerableGroupId;
	}

	public void setVulnerableGroupId(Integer vulnerableGroupId) {
		this.vulnerableGroupId = vulnerableGroupId;
	}

	@Column(name = "derechos_prioritarios_constitucion_id")
	public Integer getDerechosPrioritariosConstitucionId() {
		return this.derechosPrioritariosConstitucionId;
	}

	public void setDerechosPrioritariosConstitucionId(Integer derechosPrioritariosConstitucionId) {
		this.derechosPrioritariosConstitucionId = derechosPrioritariosConstitucionId;
	}

	@Column(name = "derechos_evalua_id")
	public Integer getDerechosEvaluaId() {
		return this.derechosEvaluaId;
	}

	public void setDerechosEvaluaId(Integer derechosEvaluaId) {
		this.derechosEvaluaId = derechosEvaluaId;
	}

	@Column(name = "antecedentes")
	public String getAntecedentes() {
		return this.antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	@Column(name = "programa_anios_anteriores")
	public Integer getProgramaAniosAnteriores() {
		return this.programaAniosAnteriores;
	}

	public void setProgramaAniosAnteriores(Integer programaAniosAnteriores) {
		this.programaAniosAnteriores = programaAniosAnteriores;
	}

	@Column(name = "programa_anio_uno")
	public Integer getProgramaAnioUno() {
		return this.programaAnioUno;
	}

	public void setProgramaAnioUno(Integer programaAnioUno) {
		this.programaAnioUno = programaAnioUno;
	}

	@Column(name = "problema_atendido")
	public String getProblemaAtendido() {
		return this.problemaAtendido;
	}

	public void setProblemaAtendido(String problemaAtendido) {
		this.problemaAtendido = problemaAtendido;
	}

	@Column(name = "descripcion_intervencion")
	public String getDescripcionIntervencion() {
		return this.descripcionIntervencion;
	}

	public void setDescripcionIntervencion(String descripcionIntervencion) {
		this.descripcionIntervencion = descripcionIntervencion;
	}

	@Column(name = "contribucion_resolucion")
	public String getContribucionResolucion() {
		return this.contribucionResolucion;
	}

	public void setContribucionResolucion(String contribucionResolucion) {
		this.contribucionResolucion = contribucionResolucion;
	}

	@Column(name = "fuentes_informacion")
	public String getFuentesInformacion() {
		return this.fuentesInformacion;
	}

	public void setFuentesInformacion(String fuentesInformacion) {
		this.fuentesInformacion = fuentesInformacion;
	}

	@Column(name = "total_poblacion_potencial")
	public Integer getTotalPoblacionPotencial() {
		return this.totalPoblacionPotencial;
	}

	public void setTotalPoblacionPotencial(Integer totalPoblacionPotencial) {
		this.totalPoblacionPotencial = totalPoblacionPotencial;
	}

	@Column(name = "poblacion_potencial_diferencia_sexo")
	public Integer getPoblacionPotencialDiferenciaSexo() {
		return this.poblacionPotencialDiferenciaSexo;
	}

	public void setPoblacionPotencialDiferenciaSexo(Integer poblacionPotencialDiferenciaSexo) {
		this.poblacionPotencialDiferenciaSexo = poblacionPotencialDiferenciaSexo;
	}

	@Column(name = "poblacion_potencial_mujeres")
	public Integer getPoblacionPotencialMujeres() {
		return this.poblacionPotencialMujeres;
	}

	public void setPoblacionPotencialMujeres(Integer poblacionPotencialMujeres) {
		this.poblacionPotencialMujeres = poblacionPotencialMujeres;
	}

	@Column(name = "poblacion_potencial_hombres")
	public Integer getPoblacionPotencialHombres() {
		return this.poblacionPotencialHombres;
	}

	public void setPoblacionPotencialHombres(Integer poblacionPotencialHombres) {
		this.poblacionPotencialHombres = poblacionPotencialHombres;
	}

	@Column(name = "poblacion_potencial_diferencia_edad")
	public Integer getPoblacionPotencialDiferenciaEdad() {
		return this.poblacionPotencialDiferenciaEdad;
	}

	public void setPoblacionPotencialDiferenciaEdad(Integer poblacionPotencialDiferenciaEdad) {
		this.poblacionPotencialDiferenciaEdad = poblacionPotencialDiferenciaEdad;
	}

	@Column(name = "poblacion_potencial_rango_minimo")
	public Integer getPoblacionPotencialRangoMinimo() {
		return this.poblacionPotencialRangoMinimo;
	}

	public void setPoblacionPotencialRangoMinimo(Integer poblacionPotencialRangoMinimo) {
		this.poblacionPotencialRangoMinimo = poblacionPotencialRangoMinimo;
	}

	@Column(name = "poblacion_potencial_rango_maximo")
	public Integer getPoblacionPotencialRangoMaximo() {
		return this.poblacionPotencialRangoMaximo;
	}

	public void setPoblacionPotencialRangoMaximo(Integer poblacionPotencialRangoMaximo) {
		this.poblacionPotencialRangoMaximo = poblacionPotencialRangoMaximo;
	}

	@Column(name = "poblacion_potencial_diferencia_geografica")
	public Integer getPoblacionPotencialDiferenciaGeografica() {
		return this.poblacionPotencialDiferenciaGeografica;
	}

	public void setPoblacionPotencialDiferenciaGeografica(Integer poblacionPotencialDiferenciaGeografica) {
		this.poblacionPotencialDiferenciaGeografica = poblacionPotencialDiferenciaGeografica;
	}

	@Column(name = "objetivo_general")
	public String getObjetivoGeneral() {
		return this.objetivoGeneral;
	}

	public void setObjetivoGeneral(String objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}

	@Column(name = "tipo_estrategia")
	public Integer getTipoEstrategia() {
		return this.tipoEstrategia;
	}

	public void setTipoEstrategia(Integer tipoEstrategia) {
		this.tipoEstrategia = tipoEstrategia;
	}

	@Column(name = "total_poblacion_objetivo")
	public Integer getTotalPoblacionObjetivo() {
		return this.totalPoblacionObjetivo;
	}

	public void setTotalPoblacionObjetivo(Integer totalPoblacionObjetivo) {
		this.totalPoblacionObjetivo = totalPoblacionObjetivo;
	}

	@Column(name = "poblacion_objetivo_diferencia_sexo")
	public Integer getPoblacionObjetivoDiferenciaSexo() {
		return this.poblacionObjetivoDiferenciaSexo;
	}

	public void setPoblacionObjetivoDiferenciaSexo(Integer poblacionObjetivoDiferenciaSexo) {
		this.poblacionObjetivoDiferenciaSexo = poblacionObjetivoDiferenciaSexo;
	}

	@Column(name = "poblacion_objetivo_mujeres")
	public Integer getPoblacionObjetivoMujeres() {
		return this.poblacionObjetivoMujeres;
	}

	public void setPoblacionObjetivoMujeres(Integer poblacionObjetivoMujeres) {
		this.poblacionObjetivoMujeres = poblacionObjetivoMujeres;
	}

	@Column(name = "poblacion_objetivo_hombres")
	public Integer getPoblacionObjetivoHombres() {
		return this.poblacionObjetivoHombres;
	}

	public void setPoblacionObjetivoHombres(Integer poblacionObjetivoHombres) {
		this.poblacionObjetivoHombres = poblacionObjetivoHombres;
	}

	@Column(name = "poblacion_objetivo_diferencia_edad")
	public Integer getPoblacionObjetivoDiferenciaEdad() {
		return this.poblacionObjetivoDiferenciaEdad;
	}

	public void setPoblacionObjetivoDiferenciaEdad(Integer poblacionObjetivoDiferenciaEdad) {
		this.poblacionObjetivoDiferenciaEdad = poblacionObjetivoDiferenciaEdad;
	}

	@Column(name = "poblacion_objetivo_rango_minimo")
	public Integer getPoblacionObjetivoRangoMinimo() {
		return this.poblacionObjetivoRangoMinimo;
	}

	public void setPoblacionObjetivoRangoMinimo(Integer poblacionObjetivoRangoMinimo) {
		this.poblacionObjetivoRangoMinimo = poblacionObjetivoRangoMinimo;
	}

	@Column(name = "poblacion_objetivo_rango_maximo")
	public Integer getPoblacionObjetivoRangoMaximo() {
		return this.poblacionObjetivoRangoMaximo;
	}

	public void setPoblacionObjetivoRangoMaximo(Integer poblacionObjetivoRangoMaximo) {
		this.poblacionObjetivoRangoMaximo = poblacionObjetivoRangoMaximo;
	}

	@Column(name = "poblacion_objetivo_diferencia_geografica")
	public Integer getPoblacionObjetivoDiferenciaGeografica() {
		return this.poblacionObjetivoDiferenciaGeografica;
	}

	public void setPoblacionObjetivoDiferenciaGeografica(Integer poblacionObjetivoDiferenciaGeografica) {
		this.poblacionObjetivoDiferenciaGeografica = poblacionObjetivoDiferenciaGeografica;
	}

	@Column(name = "is_beneficiario")
	public Integer getIsBeneficiario() {
		return this.isBeneficiario;
	}

	public void setIsBeneficiario(Integer isBeneficiario) {
		this.isBeneficiario = isBeneficiario;
	}

	@Column(name = "total_poblacion_beneficiaria")
	public Integer getTotalPoblacionBeneficiaria() {
		return this.totalPoblacionBeneficiaria;
	}

	public void setTotalPoblacionBeneficiaria(Integer totalPoblacionBeneficiaria) {
		this.totalPoblacionBeneficiaria = totalPoblacionBeneficiaria;
	}

	@Column(name = "poblacion_beneficiaria_diferencia_sexo")
	public Integer getPoblacionBeneficiariaDiferenciaSexo() {
		return this.poblacionBeneficiariaDiferenciaSexo;
	}

	public void setPoblacionBeneficiariaDiferenciaSexo(Integer poblacionBeneficiariaDiferenciaSexo) {
		this.poblacionBeneficiariaDiferenciaSexo = poblacionBeneficiariaDiferenciaSexo;
	}

	@Column(name = "poblacion_beneficiaria_mujeres")
	public Integer getPoblacionBeneficiariaMujeres() {
		return this.poblacionBeneficiariaMujeres;
	}

	public void setPoblacionBeneficiariaMujeres(Integer poblacionBeneficiariaMujeres) {
		this.poblacionBeneficiariaMujeres = poblacionBeneficiariaMujeres;
	}

	@Column(name = "poblacion_beneficiaria_hombres")
	public Integer getPoblacionBeneficiariaHombres() {
		return this.poblacionBeneficiariaHombres;
	}

	public void setPoblacionBeneficiariaHombres(Integer poblacionBeneficiariaHombres) {
		this.poblacionBeneficiariaHombres = poblacionBeneficiariaHombres;
	}

	@Column(name = "poblacion_beneficiaria_diferencia_edad")
	public Integer getPoblacionBeneficiariaDiferenciaEdad() {
		return this.poblacionBeneficiariaDiferenciaEdad;
	}

	public void setPoblacionBeneficiariaDiferenciaEdad(Integer poblacionBeneficiariaDiferenciaEdad) {
		this.poblacionBeneficiariaDiferenciaEdad = poblacionBeneficiariaDiferenciaEdad;
	}

	@Column(name = "poblacion_beneficiaria_rango_minimo")
	public Integer getPoblacionBeneficiariaRangoMinimo() {
		return this.poblacionBeneficiariaRangoMinimo;
	}

	public void setPoblacionBeneficiariaRangoMinimo(Integer poblacionBeneficiariaRangoMinimo) {
		this.poblacionBeneficiariaRangoMinimo = poblacionBeneficiariaRangoMinimo;
	}

	@Column(name = "poblacion_beneficiaria_rango_maximo")
	public Integer getPoblacionBeneficiariaRangoMaximo() {
		return this.poblacionBeneficiariaRangoMaximo;
	}

	public void setPoblacionBeneficiariaRangoMaximo(Integer poblacionBeneficiariaRangoMaximo) {
		this.poblacionBeneficiariaRangoMaximo = poblacionBeneficiariaRangoMaximo;
	}

	@Column(name = "poblacion_beneficiaria_diferencia_geografica")
	public Integer getPoblacionBeneficiariaDiferenciaGeografica() {
		return this.poblacionBeneficiariaDiferenciaGeografica;
	}

	public void setPoblacionBeneficiariaDiferenciaGeografica(Integer poblacionBeneficiariaDiferenciaGeografica) {
		this.poblacionBeneficiariaDiferenciaGeografica = poblacionBeneficiariaDiferenciaGeografica;
	}

	@Column(name = "has_facilitadores")
	public Integer getHasFacilitadores() {
		return this.hasFacilitadores;
	}

	public void setHasFacilitadores(Integer hasFacilitadores) {
		this.hasFacilitadores = hasFacilitadores;
	}

	@Column(name = "total_facilitadores")
	public Integer getTotalFacilitadores() {
		return this.totalFacilitadores;
	}

	public void setTotalFacilitadores(Integer totalFacilitadores) {
		this.totalFacilitadores = totalFacilitadores;
	}

	@Column(name = "monto_total_facilitadores")
	public Integer getMontoTotalFacilitadores() {
		return this.montoTotalFacilitadores;
	}

	public void setMontoTotalFacilitadores(Integer montoTotalFacilitadores) {
		this.montoTotalFacilitadores = montoTotalFacilitadores;
	}

	@Column(name = "tipo_beneficiario")
	public Integer getTipoBeneficiario() {
		return this.tipoBeneficiario;
	}

	public void setTipoBeneficiario(Integer tipoBeneficiario) {
		this.tipoBeneficiario = tipoBeneficiario;
	}

	@Column(name = "colectivos_constitucion_legal")
	public Integer getColectivosConstitucionLegal() {
		return this.colectivosConstitucionLegal;
	}

	public void setColectivosConstitucionLegal(Integer colectivosConstitucionLegal) {
		this.colectivosConstitucionLegal = colectivosConstitucionLegal;
	}

	@Column(name = "numero_colectivos")
	public Integer getNumeroColectivos() {
		return this.numeroColectivos;
	}

	public void setNumeroColectivos(Integer numeroColectivos) {
		this.numeroColectivos = numeroColectivos;
	}

	@Column(name = "objeto_actividad")
	public String getObjetoActividad() {
		return this.objetoActividad;
	}

	public void setObjetoActividad(String objetoActividad) {
		this.objetoActividad = objetoActividad;
	}

	@Column(name = "cobertura")
	public Integer getCobertura() {
		return this.cobertura;
	}

	public void setCobertura(Integer cobertura) {
		this.cobertura = cobertura;
	}

	@Column(name = "resultados_cualitativos")
	public String getResultadosCualitativos() {
		return this.resultadosCualitativos;
	}

	public void setResultadosCualitativos(String resultadosCualitativos) {
		this.resultadosCualitativos = resultadosCualitativos;
	}

	@Column(name = "metas_fisicas_totales")
	public String getMetasFisicasTotales() {
		return this.metasFisicasTotales;
	}

	public void setMetasFisicasTotales(String metasFisicasTotales) {
		this.metasFisicasTotales = metasFisicasTotales;
	}

	@Column(name = "suficiencia_presupuestal_documento")
	public String getSuficienciaPresupuestalDocumento() {
		return this.suficienciaPresupuestalDocumento;
	}

	public void setSuficienciaPresupuestalDocumento(String suficienciaPresupuestalDocumento) {
		this.suficienciaPresupuestalDocumento = suficienciaPresupuestalDocumento;
	}

	@Column(name = "total_presupuesto_autorizado", precision = 17, scale = 17)
	public Double getTotalPresupuestoAutorizado() {
		return this.totalPresupuestoAutorizado;
	}

	public void setTotalPresupuestoAutorizado(Double totalPresupuestoAutorizado) {
		this.totalPresupuestoAutorizado = totalPresupuestoAutorizado;
	}

	@Column(name = "costo_total_operacion", precision = 17, scale = 17)
	public Double getCostoTotalOperacion() {
		return this.costoTotalOperacion;
	}

	public void setCostoTotalOperacion(Double costoTotalOperacion) {
		this.costoTotalOperacion = costoTotalOperacion;
	}

	@Column(name = "erogar_presupuesto")
	public String getErogarPresupuesto() {
		return this.erogarPresupuesto;
	}

	public void setErogarPresupuesto(String erogarPresupuesto) {
		this.erogarPresupuesto = erogarPresupuesto;
	}

	@Column(name = "frecuencia_id")
	public Integer getFrecuenciaId() {
		return this.frecuenciaId;
	}

	public void setFrecuenciaId(Integer frecuenciaId) {
		this.frecuenciaId = frecuenciaId;
	}

	@Column(name = "presupuesto_pri_trimestre", precision = 17, scale = 17)
	public Double getPresupuestoPriTrimestre() {
		return this.presupuestoPriTrimestre;
	}

	public void setPresupuestoPriTrimestre(Double presupuestoPriTrimestre) {
		this.presupuestoPriTrimestre = presupuestoPriTrimestre;
	}

	@Column(name = "presupuesto_seg_trimestre", precision = 17, scale = 17)
	public Double getPresupuestoSegTrimestre() {
		return this.presupuestoSegTrimestre;
	}

	public void setPresupuestoSegTrimestre(Double presupuestoSegTrimestre) {
		this.presupuestoSegTrimestre = presupuestoSegTrimestre;
	}

	@Column(name = "presupuesto_ter_trimestre", precision = 17, scale = 17)
	public Double getPresupuestoTerTrimestre() {
		return this.presupuestoTerTrimestre;
	}

	public void setPresupuestoTerTrimestre(Double presupuestoTerTrimestre) {
		this.presupuestoTerTrimestre = presupuestoTerTrimestre;
	}

	@Column(name = "presupuesto_cua_trimestre", precision = 17, scale = 17)
	public Double getPresupuestoCuaTrimestre() {
		return this.presupuestoCuaTrimestre;
	}

	public void setPresupuestoCuaTrimestre(Double presupuestoCuaTrimestre) {
		this.presupuestoCuaTrimestre = presupuestoCuaTrimestre;
	}

	@Column(name = "difusion_programa_social")
	public String getDifusionProgramaSocial() {
		return this.difusionProgramaSocial;
	}

	public void setDifusionProgramaSocial(String difusionProgramaSocial) {
		this.difusionProgramaSocial = difusionProgramaSocial;
	}

	@Column(name = "incorporacion_beneficiarios_facilitadores")
	public String getIncorporacionBeneficiariosFacilitadores() {
		return this.incorporacionBeneficiariosFacilitadores;
	}

	public void setIncorporacionBeneficiariosFacilitadores(String incorporacionBeneficiariosFacilitadores) {
		this.incorporacionBeneficiariosFacilitadores = incorporacionBeneficiariosFacilitadores;
	}

	@Column(name = "registro_dom_particular")
	public Integer getRegistroDomParticular() {
		return this.registroDomParticular;
	}

	public void setRegistroDomParticular(Integer registroDomParticular) {
		this.registroDomParticular = registroDomParticular;
	}

	@Column(name = "operacion_dom_particular")
	public Integer getOperacionDomParticular() {
		return this.operacionDomParticular;
	}

	public void setOperacionDomParticular(Integer operacionDomParticular) {
		this.operacionDomParticular = operacionDomParticular;
	}

	@Column(name = "alcanza_plena_cobertura")
	public Integer getAlcanzaPlenaCobertura() {
		return this.alcanzaPlenaCobertura;
	}

	public void setAlcanzaPlenaCobertura(Integer alcanzaPlenaCobertura) {
		this.alcanzaPlenaCobertura = alcanzaPlenaCobertura;
	}

	@Column(name = "criterio_priorizacion")
	public String getCriterioPriorizacion() {
		return this.criterioPriorizacion;
	}

	public void setCriterioPriorizacion(String criterioPriorizacion) {
		this.criterioPriorizacion = criterioPriorizacion;
	}

	@Column(name = "lugares_fisicos")
	public String getLugaresFisicos() {
		return this.lugaresFisicos;
	}

	public void setLugaresFisicos(String lugaresFisicos) {
		this.lugaresFisicos = lugaresFisicos;
	}

	@Column(name = "url_dependencias")
	public String getUrlDependencias() {
		return this.urlDependencias;
	}

	public void setUrlDependencias(String urlDependencias) {
		this.urlDependencias = urlDependencias;
	}

	@Column(name = "procedimientos")
	public String getProcedimientos() {
		return this.procedimientos;
	}

	public void setProcedimientos(String procedimientos) {
		this.procedimientos = procedimientos;
	}

	@Column(name = "unidad_responsable_evaluacion")
	public String getUnidadResponsableEvaluacion() {
		return this.unidadResponsableEvaluacion;
	}

	public void setUnidadResponsableEvaluacion(String unidadResponsableEvaluacion) {
		this.unidadResponsableEvaluacion = unidadResponsableEvaluacion;
	}

	@Column(name = "fuentes_informacion_gabinete")
	public String getFuentesInformacionGabinete() {
		return this.fuentesInformacionGabinete;
	}

	public void setFuentesInformacionGabinete(String fuentesInformacionGabinete) {
		this.fuentesInformacionGabinete = fuentesInformacionGabinete;
	}

	@Column(name = "nombre_matriz_indicadores")
	public String getNombreMatrizIndicadores() {
		return this.nombreMatrizIndicadores;
	}

	public void setNombreMatrizIndicadores(String nombreMatrizIndicadores) {
		this.nombreMatrizIndicadores = nombreMatrizIndicadores;
	}

	@Column(name = "desc_participacion_ciudadana")
	public String getDescParticipacionCiudadana() {
		return this.descParticipacionCiudadana;
	}

	public void setDescParticipacionCiudadana(String descParticipacionCiudadana) {
		this.descParticipacionCiudadana = descParticipacionCiudadana;
	}

	@Column(name = "modalidad_participacion_alcance")
	public String getModalidadParticipacionAlcance() {
		return this.modalidadParticipacionAlcance;
	}

	public void setModalidadParticipacionAlcance(String modalidadParticipacionAlcance) {
		this.modalidadParticipacionAlcance = modalidadParticipacionAlcance;
	}

	@Column(name = "articula_otros")
	public Integer getArticulaOtros() {
		return this.articulaOtros;
	}

	public void setArticulaOtros(Integer articulaOtros) {
		this.articulaOtros = articulaOtros;
	}

	@Column(name = "articula_acciones_cdmx")
	public Integer getArticulaAccionesCdmx() {
		return this.articulaAccionesCdmx;
	}

	public void setArticulaAccionesCdmx(Integer articulaAccionesCdmx) {
		this.articulaAccionesCdmx = articulaAccionesCdmx;
	}

	@Column(name = "articula_acciones_republica")
	public Integer getArticulaAccionesRepublica() {
		return this.articulaAccionesRepublica;
	}

	public void setArticulaAccionesRepublica(Integer articulaAccionesRepublica) {
		this.articulaAccionesRepublica = articulaAccionesRepublica;
	}

	@Column(name = "mecanismos_ident_eval_duplicidades")
	public String getMecanismosIdentEvalDuplicidades() {
		return this.mecanismosIdentEvalDuplicidades;
	}

	public void setMecanismosIdentEvalDuplicidades(String mecanismosIdentEvalDuplicidades) {
		this.mecanismosIdentEvalDuplicidades = mecanismosIdentEvalDuplicidades;
	}

	@Column(name = "sitio_bases")
	public String getSitioBases() {
		return this.sitioBases;
	}

	public void setSitioBases(String sitioBases) {
		this.sitioBases = sitioBases;
	}

	@Column(name = "mecanismos_deteccion_errores")
	public String getMecanismosDeteccionErrores() {
		return this.mecanismosDeteccionErrores;
	}

	public void setMecanismosDeteccionErrores(String mecanismosDeteccionErrores) {
		this.mecanismosDeteccionErrores = mecanismosDeteccionErrores;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_envio", length = 22)
	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	@Column(name = "cat_estatus_revision_id", nullable = false)
	public int getCatEstatusRevisionId() {
		return this.catEstatusRevisionId;
	}

	public void setCatEstatusRevisionId(int catEstatusRevisionId) {
		this.catEstatusRevisionId = catEstatusRevisionId;
	}

	@Column(name = "estatus", nullable = false)
	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_cierre_evaluacion", length = 22)
	public Date getFechaCierreEvaluacion() {
		return this.fechaCierreEvaluacion;
	}

	public void setFechaCierreEvaluacion(Date fechaCierreEvaluacion) {
		this.fechaCierreEvaluacion = fechaCierreEvaluacion;
	}

	@Column(name = "codigo_aprobacion")
	public String getCodigoAprobacion() {
		return this.codigoAprobacion;
	}

	public void setCodigoAprobacion(String codigoAprobacion) {
		this.codigoAprobacion = codigoAprobacion;
	}

	@Column(name = "numero_gaceta")
	public String getNumeroGaceta() {
		return this.numeroGaceta;
	}

	public void setNumeroGaceta(String numeroGaceta) {
		this.numeroGaceta = numeroGaceta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_publicacion_gaceta", length = 13)
	public Date getFechaPublicacionGaceta() {
		return this.fechaPublicacionGaceta;
	}

	public void setFechaPublicacionGaceta(Date fechaPublicacionGaceta) {
		this.fechaPublicacionGaceta = fechaPublicacionGaceta;
	}

	@Column(name = "pgcdmx_ejes_id")
	public Integer getPgcdmxEjesId() {
		return this.pgcdmxEjesId;
	}

	public void setPgcdmxEjesId(Integer pgcdmxEjesId) {
		this.pgcdmxEjesId = pgcdmxEjesId;
	}

	@Column(name = "pgcdmx_derechos_id")
	public Integer getPgcdmxDerechosId() {
		return this.pgcdmxDerechosId;
	}

	public void setPgcdmxDerechosId(Integer pgcdmxDerechosId) {
		this.pgcdmxDerechosId = pgcdmxDerechosId;
	}

	@Column(name = "programa_padre", nullable = false)
	public int getProgramaPadre() {
		return this.programaPadre;
	}

	public void setProgramaPadre(int programaPadre) {
		this.programaPadre = programaPadre;
	}

	@Column(name = "is_programa_accion", nullable = false)
	public String getIsProgramaAccion() {
		return this.isProgramaAccion;
	}

	public void setIsProgramaAccion(String isProgramaAccion) {
		this.isProgramaAccion = isProgramaAccion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vigencia", length = 13)
	public Date getFechaVigencia() {
		return this.fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	@Column(name = "periodicidad")
	public String getPeriodicidad() {
		return this.periodicidad;
	}

	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	@Column(name = "tipo_apoyo_otorgado_acciones")
	public String getTipoApoyoOtorgadoAcciones() {
		return this.tipoApoyoOtorgadoAcciones;
	}

	public void setTipoApoyoOtorgadoAcciones(String tipoApoyoOtorgadoAcciones) {
		this.tipoApoyoOtorgadoAcciones = tipoApoyoOtorgadoAcciones;
	}

	@Column(name = "monto_apoyo_otorgado_acciones")
	public String getMontoApoyoOtorgadoAcciones() {
		return this.montoApoyoOtorgadoAcciones;
	}

	public void setMontoApoyoOtorgadoAcciones(String montoApoyoOtorgadoAcciones) {
		this.montoApoyoOtorgadoAcciones = montoApoyoOtorgadoAcciones;
	}

	@Column(name = "numero_beneficiarios_acciones")
	public String getNumeroBeneficiariosAcciones() {
		return this.numeroBeneficiariosAcciones;
	}

	public void setNumeroBeneficiariosAcciones(String numeroBeneficiariosAcciones) {
		this.numeroBeneficiariosAcciones = numeroBeneficiariosAcciones;
	}

	@Column(name = "acceso_simultaneo_programa_acciones")
	public Boolean getAccesoSimultaneoProgramaAcciones() {
		return this.accesoSimultaneoProgramaAcciones;
	}

	public void setAccesoSimultaneoProgramaAcciones(Boolean accesoSimultaneoProgramaAcciones) {
		this.accesoSimultaneoProgramaAcciones = accesoSimultaneoProgramaAcciones;
	}
	
	@Column(name = "palabras_clave")
	public String getPalabrasClave() {
		return this.palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}

	@Column(name = "es_digital")
	public Boolean getEsDigital() {
		return this.esDigital;
	}

	public void setEsDigital(Boolean esDigital) {
		this.esDigital = esDigital;
	}


	@OneToMany(mappedBy="programs")
	public List<ResumenesProgramas> getResumenesProgramas() {
		return resumenesProgramas;
	}

	public void setResumenesProgramas(List<ResumenesProgramas> resumenesProgramas) {
		this.resumenesProgramas = resumenesProgramas;
	}
	
	@Column(name = "activo")
	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	

}
