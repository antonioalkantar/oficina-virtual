package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the crc_tramite_fundamento_hist database table.
 * 
 */
@Entity
@Table(name="crc_tramite_fundamento_hist", schema = "retys_v2")
@NamedQuery(name="CrcTramiteFundamentoHist.findAll", query="SELECT c FROM CrcTramiteFundamentoHist c")
public class CrcTramiteFundamentoHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLey;
	private String otraLey;
	private boolean situacion;
	private CatLeye catLeye;
	private CrcFlujoTramite crcFlujoTramite;
	private TramiteServicio tramiteServicio;
	private CrcTramiteFundamento crcTramiteFundamento;
	private List<CrcModTramiteFundamento> crcModTramiteFundamentos;
	


	public CrcTramiteFundamentoHist() {
	}


	@Id
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
//
//
//	@Column(name="id_flujo_tramite")
//	public Long getIdFlujoTramite() {
//		return this.idFlujoTramite;
//	}
//
//	public void setIdFlujoTramite(Long idFlujoTramite) {
//		this.idFlujoTramite = idFlujoTramite;
//	}
//
//
//	@Column(name="id_ley")
//	public Long getIdLey() {
//		return this.idLey;
//	}
//
//	public void setIdLey(Long idLey) {
//		this.idLey = idLey;
//	}
//
//
//	@Column(name="id_tramite_servicio")
//	public Long getIdTramiteServicio() {
//		return this.idTramiteServicio;
//	}
//
//	public void setIdTramiteServicio(Long idTramiteServicio) {
//		this.idTramiteServicio = idTramiteServicio;
//	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	@OneToOne
	@JoinColumn(name="id")
	public CrcTramiteFundamento getCrcTramiteFundamento() {
		return crcTramiteFundamento;
	}


	public void setCrcTramiteFundamento(CrcTramiteFundamento crcTramiteFundamento) {
		this.crcTramiteFundamento = crcTramiteFundamento;
	}
	
	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_ley")
	public CatLeye getCatLeye() {
		return catLeye;
	}


	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}

	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return crcFlujoTramite;
	}


	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	//bi-directional many-to-one association to TramiteServicio
	@ManyToOne
	@JoinColumn(name="id_tramite_servicio")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}


	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
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