package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the det_lugares_registrados database table.
 * 
 */
@Entity
@Table(name="det_lugares_registrados", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetLugaresRegistrado.findAll", query="SELECT d FROM DetLugaresRegistrado d"),
	@NamedQuery(name="DetLugaresRegistrado.buscarPorCanalAtencion", query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetLugaresRegistradosDTO"
			+ " ("
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dlrhist.id is not null then dlrhist.id else d.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and canalhist.id is not null then canalhist.id else canal.id end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and tramhist.id is not null then tramhist.id else tram.id end, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and dlrhist.situacion is not null then dlrhist.situacion else d.situacion end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and areahist.id is not null then areahist.id else area.id end, "
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and areahist.nombreAac is not null then areahist.nombreAac else area.nombreAac end "
			
			//+ "d.id,"
			//+ "  canal.id,"
			//+ " tram.id,"
			//+ " d.situacion,"
			//+ " area.id,"
			//+ " area.nombreAac "
			
			+ ") "
			+ " FROM DetLugaresRegistrado d"
			+ " INNER JOIN d.detCanalAtencion canal"
			+ " INNER JOIN d.catAreaAc area"
			+ " INNER JOIN d.crcFlujoTramite tram"
			
			+ " left join d.detLugaresRegistradosHist dlrhist "
			+ " left join dlrhist.detCanalAtencionHist canalhist "
			+ " left join dlrhist.catAreaAc areahist "
			+ " left join dlrhist.crcFlujoTramite tramhist "
			
			+ " join tram.catEtapasTramite cet "
			+ " join tram.catEstatusTramite cestt "	
			
			+ " WHERE canal.id=:idcanal"
			+ " AND d.situacion = TRUE"
			+ " ORDER BY d.id ASC")  , 
})

public class DetLugaresRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private List<DetHorariosLugare> detHorariosLugares;
	private DetCanalAtencion detCanalAtencion;
	private CrcFlujoTramite crcFlujoTramite;
	private Boolean situacion;
	private CatAreaAc catAreaAc;
	private DetLugaresRegistradosHist detLugaresRegistradosHist;

	public DetLugaresRegistrado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

/*
	@Column(name="id_area_ac")
	public Long getIdAreaAc() {
		return this.idAreaAc;
	}

	public void setIdAreaAc(Long idAreaAc) {
		this.idAreaAc = idAreaAc;
	}
	*/


	//bi-directional many-to-one association to DetHorariosLugare
	@OneToMany(mappedBy="detLugaresRegistrado")
	public List<DetHorariosLugare> getDetHorariosLugares() {
		return this.detHorariosLugares;
	}

	public void setDetHorariosLugares(List<DetHorariosLugare> detHorariosLugares) {
		this.detHorariosLugares = detHorariosLugares;
	}

	public DetHorariosLugare addDetHorariosLugare(DetHorariosLugare detHorariosLugare) {
		getDetHorariosLugares().add(detHorariosLugare);
		detHorariosLugare.setDetLugaresRegistrado(this);

		return detHorariosLugare;
	}

	public DetHorariosLugare removeDetHorariosLugare(DetHorariosLugare detHorariosLugare) {
		getDetHorariosLugares().remove(detHorariosLugare);
		detHorariosLugare.setDetLugaresRegistrado(null);

		return detHorariosLugare;
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

	@ManyToOne
	@JoinColumn(name="id_area_ac")
	public CatAreaAc getCatAreaAc() {
		return catAreaAc;
	}


	public void setCatAreaAc(CatAreaAc catAreaAc) {
		this.catAreaAc = catAreaAc;
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
	
	@OneToOne
	@JoinColumn(name="id")
	public DetLugaresRegistradosHist getDetLugaresRegistradosHist() {
		return detLugaresRegistradosHist;
	}

	public void setDetLugaresRegistradosHist(DetLugaresRegistradosHist detLugaresRegistradosHist) {
		this.detLugaresRegistradosHist = detLugaresRegistradosHist;
	}
	

}