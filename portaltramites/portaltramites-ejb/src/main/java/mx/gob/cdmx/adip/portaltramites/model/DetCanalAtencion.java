package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_canal_atencion database table.
 * 
 */
@Entity
@Table(name="det_canal_atencion", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetCanalAtencion.findAll", query="SELECT d FROM DetCanalAtencion d"),
	
})

public class DetCanalAtencion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String otraLey;
	private Boolean puedeRealizarseDigitalmente;
	private Boolean puedeRealizarsePresencialmente;
	private Boolean puedeRealizarseTelefonicamente;
	private Boolean tieneFundamentoJuridico;
	private CatTipoMedio catTipoMedio;
	private TramiteServicio tramiteServicio;
	private List<DetLugaresRegistrado> detLugaresRegistrados;
//	private List<DetPasosRegistrado> detPasosRegistrados;
//	private List<DetTelefonosRegistrado> detTelefonosRegistrados;
	private List<DetUrlRegistrado> detUrlRegistrados;
	private Boolean tramiteConLlave;
	
	public DetCanalAtencion() {}
	
	public DetCanalAtencion(Long id) {
		this.id=id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="articulo_ley_reglamento")
	public String getArticuloLeyReglamento() {
		return this.articuloLeyReglamento;
	}

	public void setArticuloLeyReglamento(String articuloLeyReglamento) {
		this.articuloLeyReglamento = articuloLeyReglamento;
	}


	@Column(name="otra_ley")
	public String getOtraLey() {
		return this.otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}


	@Column(name="puede_realizarse_digitalmente")
	public Boolean getPuedeRealizarseDigitalmente() {
		return this.puedeRealizarseDigitalmente;
	}

	public void setPuedeRealizarseDigitalmente(Boolean puedeRealizarseDigitalmente) {
		this.puedeRealizarseDigitalmente = puedeRealizarseDigitalmente;
	}


	@Column(name="puede_realizarse_presencialmente")
	public Boolean getPuedeRealizarsePresencialmente() {
		return this.puedeRealizarsePresencialmente;
	}

	public void setPuedeRealizarsePresencialmente(Boolean puedeRealizarsePresencialmente) {
		this.puedeRealizarsePresencialmente = puedeRealizarsePresencialmente;
	}


	@Column(name="puede_realizarse_telefonicamente")
	public Boolean getPuedeRealizarseTelefonicamente() {
		return this.puedeRealizarseTelefonicamente;
	}

	public void setPuedeRealizarseTelefonicamente(Boolean puedeRealizarseTelefonicamente) {
		this.puedeRealizarseTelefonicamente = puedeRealizarseTelefonicamente;
	}


	@Column(name="tiene_fundamento_juridico")
	public Boolean getTieneFundamentoJuridico() {
		return this.tieneFundamentoJuridico;
	}

	public void setTieneFundamentoJuridico(Boolean tieneFundamentoJuridico) {
		this.tieneFundamentoJuridico = tieneFundamentoJuridico;
	}

/*
	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}*/


	//bi-directional many-to-one association to CatTipoMedio
	@ManyToOne
	@JoinColumn(name="id_tipo_medio")
	public CatTipoMedio getCatTipoMedio() {
		return this.catTipoMedio;
	}

	public void setCatTipoMedio(CatTipoMedio catTipoMedio) {
		this.catTipoMedio = catTipoMedio;
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


	//bi-directional many-to-one association to DetLugaresRegistrado
	@OneToMany(mappedBy="detCanalAtencion")
	public List<DetLugaresRegistrado> getDetLugaresRegistrados() {
		return this.detLugaresRegistrados;
	}

	public void setDetLugaresRegistrados(List<DetLugaresRegistrado> detLugaresRegistrados) {
		this.detLugaresRegistrados = detLugaresRegistrados;
	}

	public DetLugaresRegistrado addDetLugaresRegistrado(DetLugaresRegistrado detLugaresRegistrado) {
		getDetLugaresRegistrados().add(detLugaresRegistrado);
		detLugaresRegistrado.setDetCanalAtencion(this);

		return detLugaresRegistrado;
	}

	public DetLugaresRegistrado removeDetLugaresRegistrado(DetLugaresRegistrado detLugaresRegistrado) {
		getDetLugaresRegistrados().remove(detLugaresRegistrado);
		detLugaresRegistrado.setDetCanalAtencion(null);

		return detLugaresRegistrado;
	}

	@Column(name="tramite_con_llave")
	public Boolean getTramiteConLlave() {
		return tramiteConLlave;
	}

	public void setTramiteConLlave(Boolean tramiteConLlave) {
		this.tramiteConLlave = tramiteConLlave;
	}

/*
	//bi-directional many-to-one association to DetPasosRegistrado
	@OneToMany(mappedBy="detCanalAtencion")
	public List<DetPasosRegistrado> getDetPasosRegistrados() {
		return this.detPasosRegistrados;
	}

	public void setDetPasosRegistrados(List<DetPasosRegistrado> detPasosRegistrados) {
		this.detPasosRegistrados = detPasosRegistrados;
	}

	public DetPasosRegistrado addDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
		getDetPasosRegistrados().add(detPasosRegistrado);
		detPasosRegistrado.setDetCanalAtencion(this);

		return detPasosRegistrado;
	}

	public DetPasosRegistrado removeDetPasosRegistrado(DetPasosRegistrado detPasosRegistrado) {
		getDetPasosRegistrados().remove(detPasosRegistrado);
		detPasosRegistrado.setDetCanalAtencion(null);

		return detPasosRegistrado;
	}


	//bi-directional many-to-one association to DetTelefonosRegistrado
	@OneToMany(mappedBy="detCanalAtencion")
	public List<DetTelefonosRegistrado> getDetTelefonosRegistrados() {
		return this.detTelefonosRegistrados;
	}

	public void setDetTelefonosRegistrados(List<DetTelefonosRegistrado> detTelefonosRegistrados) {
		this.detTelefonosRegistrados = detTelefonosRegistrados;
	}

	public DetTelefonosRegistrado addDetTelefonosRegistrado(DetTelefonosRegistrado detTelefonosRegistrado) {
		getDetTelefonosRegistrados().add(detTelefonosRegistrado);
		detTelefonosRegistrado.setDetCanalAtencion(this);

		return detTelefonosRegistrado;
	}

	public DetTelefonosRegistrado removeDetTelefonosRegistrado(DetTelefonosRegistrado detTelefonosRegistrado) {
		getDetTelefonosRegistrados().remove(detTelefonosRegistrado);
		detTelefonosRegistrado.setDetCanalAtencion(null);

		return detTelefonosRegistrado;
	}

*/
	//bi-directional many-to-one association to DetUrlRegistrado
	@OneToMany(mappedBy="detCanalAtencion")
	public List<DetUrlRegistrado> getDetUrlRegistrados() {
		return this.detUrlRegistrados;
	}

	public void setDetUrlRegistrados(List<DetUrlRegistrado> detUrlRegistrados) {
		this.detUrlRegistrados = detUrlRegistrados;
	}
/*
	public DetUrlRegistrado addDetUrlRegistrado(DetUrlRegistrado detUrlRegistrado) {
		getDetUrlRegistrados().add(detUrlRegistrado);
		detUrlRegistrado.setDetCanalAtencion(this);

		return detUrlRegistrado;
	}

	public DetUrlRegistrado removeDetUrlRegistrado(DetUrlRegistrado detUrlRegistrado) {
		getDetUrlRegistrados().remove(detUrlRegistrado);
		detUrlRegistrado.setDetCanalAtencion(null);

		return detUrlRegistrado;
	}
*/
}