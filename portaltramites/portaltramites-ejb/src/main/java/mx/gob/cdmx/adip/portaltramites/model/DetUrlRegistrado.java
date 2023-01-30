package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_url_registrado database table.
 * 
 */
@Entity
@Table(name="det_url_registrado", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetUrlRegistrado.findAll", query="SELECT d FROM DetUrlRegistrado d")
	, @NamedQuery(name="DetUrlRegistrado.buscarPorCanalAtencion"
	, query="SELECT  new mx.gob.cdmx.adip.portaltramites.commons.dto.DetUrlRegistradoDTO"
			+ "("
			+ "d.id, " 
			+ "case when cestt.id = 2 and cet.esProcesoFinal = false and durhist.url is not null then durhist.url else d.url end, " 
			+ "canal.id, "
			+ "tram.id, " 
			+ "d.situacion "
			
			//+ "d.id"
			//+ ",d.url"
			//+ ",canal.id"
			//+ ",tram.id"
			//+ ",d.situacion"					
			+ ")"
			+ "FROM DetUrlRegistrado d"
			+ " INNER JOIN d.detCanalAtencion canal"
			+ " INNER JOIN d.crcFlujoTramite tram"
			
			+ " left join d.detUrlRegistradoHist durhist "
			+ " left join durhist.detCanalAtencionHist canalhist "
//			+ " join durhist.crcFlujoTramite tramhist "
			
			+ " join tram.catEtapasTramite cet "
			+ " join tram.catEstatusTramite cestt "
			+ " WHERE canal.id=:idcanal "
			+ "	AND d.situacion = 'TRUE'"
			+ "	ORDER BY d.id ASC")
})

public class DetUrlRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String url;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCanalAtencion detCanalAtencion;
	private Boolean situacion;
	private DetUrlRegistradoHist detUrlRegistradoHist;

	public DetUrlRegistrado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	@OneToOne
	@JoinColumn(name="id")
	public DetUrlRegistradoHist getDetUrlRegistradoHist() {
		return detUrlRegistradoHist;
	}

	public void setDetUrlRegistradoHist(DetUrlRegistradoHist detUrlRegistradoHist) {
		this.detUrlRegistradoHist = detUrlRegistradoHist;
	}

}