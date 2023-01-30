package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_pasos_registrados database table.
 * 
 */
@Entity
@Table(name="det_pasos_registrados", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetPasosRegistrado.findAll", query="SELECT d FROM DetPasosRegistrado d"),
	@NamedQuery(name="DetPasosRegistrado.buscarPorCanalAtencionTipoSol"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetPasosRegistradoDTO"
			+ " ("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dprhist.id is not null then dprhist.id else d.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dprhist.descripcion is not null then dprhist.descripcion else d.descripcion end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dprhist.numeroPaso is not null then dprhist.numeroPaso else d.numeroPaso end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and actorhist.id is not null then actorhist.id else actor.id end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and actorhist.descripcion is not null then actorhist.descripcion else actor.descripcion end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dprhist.situacion is not null then dprhist.situacion else d.situacion end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and canalhist.id is not null then canalhist.id else canal.id end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and tramhist.id is not null then tramhist.id else tram.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dprhist.tipoSolicitud is not null then dprhist.tipoSolicitud else d.tipoSolicitud end "			
			//+ "d.id"
			//+ ",d.descripcion"
			//+ ",d.numeroPaso"
			//+ ",actor.id"
			//+ ",actor.descripcion"
			//+ ",d.situacion"
			//+ ",canal.id"
			//+ ", tram.id"
			//+ ",d.tipoSolicitud"			
			+ ") "
			+ "	FROM DetPasosRegistrado d "
			+ "	INNER JOIN d.catActor actor "
			+ " INNER JOIN d.detCanalAtencion canal "
			+ " INNER JOIN d.crcFlujoTramite tram "
			
			+ " left join d.detPasosRegistradosHist dprhist "
			+ " left join dprhist.catActor actorhist "
			+ " left join dprhist.detCanalAtencionHist canalhist "
			+ " left join dprhist.crcFlujoTramite tramhist "
			
			+ " join tram.catEtapasTramite cet "
			+ " join tram.catEstatusTramite cestt "			
			+ " WHERE canal.id=:idcanal AND d.tipoSolicitud=:idTipo "
			+ "	AND d.situacion = TRUE	"
			+ "	ORDER BY d.id ASC")
})

public class DetPasosRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Long numeroPaso;
	private CatActor catActor;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCanalAtencion detCanalAtencion;	
	private Boolean situacion;
	private Long tipoSolicitud;
	private DetPasosRegistradosHist detPasosRegistradosHist;

	public DetPasosRegistrado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name="numero_paso")
	public Long getNumeroPaso() {
		return this.numeroPaso;
	}

	public void setNumeroPaso(Long numeroPaso) {
		this.numeroPaso = numeroPaso;
	}


	//bi-directional many-to-one association to CatActor
	@ManyToOne
	@JoinColumn(name="id_actor")
	public CatActor getCatActor() {
		return this.catActor;
	}

	public void setCatActor(CatActor catActor) {
		this.catActor = catActor;
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


	//bi-directional many-to-one association to DetCanalAtencion
	@ManyToOne
	@JoinColumn(name="id_canal_atencion")
	public DetCanalAtencion getDetCanalAtencion() {
		return this.detCanalAtencion;
	}

	public void setDetCanalAtencion(DetCanalAtencion detCanalAtencion) {
		this.detCanalAtencion = detCanalAtencion;
	}

	@Column(name="situacion")
	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

	@Column(name="tipo_solicitud")
	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}


	public void setTipoSolicitud(Long tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	@OneToOne
	@JoinColumn(name="id")
	public DetPasosRegistradosHist getDetPasosRegistradosHist() {
		return detPasosRegistradosHist;
	}

	public void setDetPasosRegistradosHist(DetPasosRegistradosHist detPasosRegistradosHist) {
		this.detPasosRegistradosHist = detPasosRegistradosHist;
	}

}