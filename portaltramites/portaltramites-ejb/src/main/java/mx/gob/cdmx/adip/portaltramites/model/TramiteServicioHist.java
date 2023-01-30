package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tramite_servicio_hist database table.
 * 
 */
@Entity
@Table(name="tramite_servicio_hist", schema = "retys_v2")
@NamedQuery(name="TramiteServicioHist.findAll", query="SELECT t FROM TramiteServicioHist t")
public class TramiteServicioHist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String beneficio;
	private String homoclave;
	private Long idAreaAdministrativa;
	private Long idDependencia;
	private Long idEsTramiteServicio;
	private Long idEtapaDeVida;
	private String nombreOficial;
	private String nombreParaCiudadano;
	private Boolean tieneModalidades;
	private TramiteServicio tramiteServicio;
	private CatDependencia catDependencia;
	private CatEtapaDeVida catEtapaDeVida;
	private CatEsTramiteServicio catEsTramiteServicio;
	private CatUnidadesAdministrativa catUnidadesAdministrativaHist;

	public TramiteServicioHist() {
	}

	@Id
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBeneficio() {
		return this.beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	public String getHomoclave() {
		return this.homoclave;
	}

	public void setHomoclave(String homoclave) {
		this.homoclave = homoclave;
	}
/*
	@Column(name="id_area_administrativa")
	public Long getIdAreaAdministrativa() {
		return this.idAreaAdministrativa;
	}

	public void setIdAreaAdministrativa(Long idAreaAdministrativa) {
		this.idAreaAdministrativa = idAreaAdministrativa;
	}
*/
	@Column(name="nombre_oficial")
	public String getNombreOficial() {
		return this.nombreOficial;
	}

	public void setNombreOficial(String nombreOficial) {
		this.nombreOficial = nombreOficial;
	}

	@Column(name="nombre_para_ciudadano")
	public String getNombreParaCiudadano() {
		return this.nombreParaCiudadano;
	}

	public void setNombreParaCiudadano(String nombreParaCiudadano) {
		this.nombreParaCiudadano = nombreParaCiudadano;
	}

	@Column(name="tiene_modalidades")
	public Boolean getTieneModalidades() {
		return this.tieneModalidades;
	}

	public void setTieneModalidades(Boolean tieneModalidades) {
		this.tieneModalidades = tieneModalidades;
	}

	//bi-directional many-to-one association to TramiteServicio
	@OneToOne
	@JoinColumn(name="id")
	public TramiteServicio getTramiteServicio() {
		return tramiteServicio;
	}

	public void setTramiteServicio(TramiteServicio tramiteServicio) {
		this.tramiteServicio = tramiteServicio;
	}

	//bi-directional many-to-one association to CatEtapaDeVida
	@ManyToOne
	@JoinColumn(name="id_dependencia")
	public CatDependencia getCatDependencia() {
		return this.catDependencia;
	}

	public void setCatDependencia(CatDependencia catDependencia) {
		this.catDependencia = catDependencia;
	}

	//bi-directional many-to-one association to CatEtapaDeVida
	@ManyToOne
	@JoinColumn(name="id_etapa_de_vida")
	public CatEtapaDeVida getCatEtapaDeVida() {
		return this.catEtapaDeVida;
	}

	public void setCatEtapaDeVida(CatEtapaDeVida catEtapaDeVida) {
		this.catEtapaDeVida = catEtapaDeVida;
	}

	//bi-directional many-to-one association to CatEsTramiteServicio
	@ManyToOne
	@JoinColumn(name="id_es_tramite_servicio")
	public CatEsTramiteServicio getCatEsTramiteServicio() {
		return this.catEsTramiteServicio;
	}

	public void setCatEsTramiteServicio(CatEsTramiteServicio catEsTramiteServicio) {
		this.catEsTramiteServicio = catEsTramiteServicio;
	}

	//bi-directional many-to-one association to CatUnidadesAdministrativa
	@ManyToOne
	@JoinColumn(name="id_area_administrativa")
	public CatUnidadesAdministrativa getCatUnidadesAdministrativaHist() {
		return catUnidadesAdministrativaHist;
	}

	public void setCatUnidadesAdministrativaHist(CatUnidadesAdministrativa catUnidadesAdministrativaHist) {
		this.catUnidadesAdministrativaHist = catUnidadesAdministrativaHist;
	}

}