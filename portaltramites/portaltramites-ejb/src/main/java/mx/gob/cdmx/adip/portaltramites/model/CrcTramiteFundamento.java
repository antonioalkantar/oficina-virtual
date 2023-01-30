package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the crc_tramite_fundamento database table.
 * 
 */
@Entity
@Table(name="crc_tramite_fundamento", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CrcTramiteFundamento.findAll", query="SELECT c FROM CrcTramiteFundamento c"),
	@NamedQuery(name="CrcTramiteFundamento.findByIdTramite"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CrcTramiteFundamentoDTO("
			+ "c.id " 
			+ ",l.id " 
			+ ",l.nombre " 
			+ ",l.situacion " 
			+ ",c.articuloLey " 
			+ ",c.otraLey " 
			+ ",ts.id " 
			+ ",ft.id " 
			+ ") "
			+ "FROM CrcTramiteFundamento c "
			+ "join c.tramiteServicio ts "
			+ "join c.crcFlujoTramite ft "
			+ "join ft.catEtapasTramite cet "
			+ "join ft.catEstatusTramite cestt "
			+ "join c.catLeye l "
			+ "left join c.crcModTramiteFundamentos cmtf "
			+ "where ts.id = :idTramite "
			+ "and c.situacion = true "
			+ "and cestt.id = 2 "
			+ "and (cmtf.estatusCampo is null or cmtf.estatusCampo = 1 or cmtf.estatusCampo = 2)")
	
	,@NamedQuery(name="CrcTramiteFundamento.findByIdTramiteHist"
	, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CrcTramiteFundamentoDTO("
			+ "ch.id " 
			+ ",lh.id " 
			+ ",lh.nombre " 
			+ ",lh.situacion " 
			+ ",ch.articuloLey " 
			+ ",ch.otraLey " 
			+ ",tsh.id " 
			+ ",fth.id " 
			+ ") "
			+ "FROM CrcTramiteFundamento c "
			+ "JOIN c.crcTramiteFundamentoHist ch "
			+ "join ch.tramiteServicio tsh "
			+ "join ch.crcFlujoTramite fth "
			+ "join fth.catEtapasTramite cet "
			+ "join fth.catEstatusTramite cestt "
			+ "join ch.catLeye lh "
			+ "where tsh.id = :idTramite "
			+ "and ch.situacion = true "
			+ "and cestt.id = 2 "
			+ "and cet.esProcesoFinal = false "
			)
})
public class CrcTramiteFundamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLey;
	private String otraLey;
	private boolean situacion;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private CrcTramiteFundamentoHist crcTramiteFundamentoHist;
	private List<CrcModTramiteFundamento> crcModTramiteFundamentos;

	public CrcTramiteFundamento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="articulo_ley")
	public String getArticuloLey() {
		return this.articuloLey;
	}

	public void setArticuloLey(String articuloLey) {
		this.articuloLey = articuloLey;
	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_ley")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return this.tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}


	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	@OneToOne
	@JoinColumn(name="id")
	public CrcTramiteFundamentoHist getCrcTramiteFundamentoHist() {
		return crcTramiteFundamentoHist;
	}


	public void setCrcTramiteFundamentoHist(CrcTramiteFundamentoHist crcTramiteFundamentoHist) {
		this.crcTramiteFundamentoHist = crcTramiteFundamentoHist;
	}
	
	
	
	//bi-directional many-to-one association to CrcModTramiteFundamento
	@OneToMany(mappedBy="crcTramiteFundamento")
	public List<CrcModTramiteFundamento> getCrcModTramiteFundamentos() {
		return this.crcModTramiteFundamentos;
	}

	public void setCrcModTramiteFundamentos(List<CrcModTramiteFundamento> crcModTramiteFundamentos) {
		this.crcModTramiteFundamentos = crcModTramiteFundamentos;
	}

}