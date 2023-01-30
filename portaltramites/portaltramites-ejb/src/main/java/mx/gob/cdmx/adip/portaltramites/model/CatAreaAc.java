
package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_area_ac database table.
 * 
 */
@Entity
@Table(name="cat_area_ac", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatAreaAc.findAll", query="SELECT d FROM CatAreaAc d"),
	@NamedQuery(name="CatAreaAc.findById", 
	query="SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.CatAreaAcDTO"
			+ " (c.id"
			+ ",c.calle"
			+ ",c.esKiosco"
			+ ",c.latitud"
			+ ",c.longitud"
			+ ",c.nombreAac"
			+ ",c.numExterior"
			+ ",c.numInterior"
			+ ",c.situacion"
			+ ",catAl.idAlcaldia"
			+ ",catAl.municipio"
			+ ",catCP.idCodigoPostal"
			+ ",catCP.codigoPostal"
			+ ",catAs.idAsentamiento"
			+ ",catAs.asentamiento"
			+ ",vial.id"
			+ ",vial.descripcion) "
			+ " FROM CatAreaAc c"
			+ " INNER JOIN c.catAlcaldia catAl"
			+ " INNER JOIN c.catCodigosPostale catCP"
			+ " INNER JOIN c.catAsentamiento catAs"
			+ " LEFT JOIN c.catTipoVialidad vial"
			+ " WHERE c.id = :idCatArea "
			+ " AND c.situacion = TRUE"
			+ " ORDER BY c.nombreAac ASC"),
	@NamedQuery(name="CatAreaAc.busqHorarios", 
	query="SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.CatAreaAcDTO"
		+ " (c.id"
		+ ",horario.id"
		+ ",horario.atiendeDomingo"
		+ ",horario.atiendeJueves"
		+ ",horario.atiendeLunes"
		+ ",horario.atiendeMartes"
		+ ",horario.atiendeMiercoles"
		+ ",horario.atiendeSabado"
		+ ",horario.atiendeViernes"
		+ ",horario.horaFin"
		+ ",horario.horaInicio"
		+ ",horario.catTipoHorario.id"
		+ ",horario.catTipoHorario.descripcion) "
		+ " FROM CatAreaAc c"
		+ " INNER JOIN c.detHorarioRegistrados horario"		
		+ " WHERE c.id = :idCatArea"),
}) 

public class CatAreaAc implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String calle;
	private Boolean esKiosco;
	private String latitud;
	private String longitud;
	private String nombreAac;
	private String numExterior;
	private String numInterior;
	private Boolean situacion;
	private CatAlcaldia catAlcaldia;
	private CatDependencia catDependencia;
	private CatAsentamiento catAsentamiento;
	private CatCodigosPostale catCodigosPostale;
	private CatEstatusAreaAc catEstatusAreaAc;
	private List<DetHorarioRegistrado> detHorarioRegistrados;
	private List<DetTelefonoRegistrado> detTelefonoRegistrados;
	private CatTipoVialidad catTipoVialidad;

	public CatAreaAc() {
		catAlcaldia = new CatAlcaldia();
		catAsentamiento = new CatAsentamiento();
		catCodigosPostale = new CatCodigosPostale();
		catEstatusAreaAc =  new CatEstatusAreaAc();
	}
	
	public CatAreaAc(Long id) {
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


	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	@Column(name="es_kiosco")
	public Boolean getEsKiosco() {
		return this.esKiosco;
	}

	public void setEsKiosco(Boolean esKiosco) {
		this.esKiosco = esKiosco;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	@Column(name="nombre_aac")
	public String getNombreAac() {
		return this.nombreAac;
	}

	public void setNombreAac(String nombreAac) {
		this.nombreAac = nombreAac;
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


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CatAlcaldia
	@ManyToOne
	@JoinColumn(name="id_alcaldia")
	public CatAlcaldia getCatAlcaldia() {
		return this.catAlcaldia;
	}

	public void setCatAlcaldia(CatAlcaldia catAlcaldia) {
		this.catAlcaldia = catAlcaldia;
	}


	//bi-directional many-to-one association to CatAsentamiento
	@ManyToOne
	@JoinColumn(name="id_asentamiento")
	public CatAsentamiento getCatAsentamiento() {
		return this.catAsentamiento;
	}

	public void setCatAsentamiento(CatAsentamiento catAsentamiento) {
		this.catAsentamiento = catAsentamiento;
	}


	//bi-directional many-to-one association to CatCodigosPostale
	@ManyToOne
	@JoinColumn(name="id_codigo_postal")
	public CatCodigosPostale getCatCodigosPostale() {
		return this.catCodigosPostale;
	}

	public void setCatCodigosPostale(CatCodigosPostale catCodigosPostale) {
		this.catCodigosPostale = catCodigosPostale;
	}


	//bi-directional many-to-one association to CatEstatusAreaAc
	@ManyToOne
	@JoinColumn(name="id_estatus")
	public CatEstatusAreaAc getCatEstatusAreaAc() {
		return this.catEstatusAreaAc;
	}

	public void setCatEstatusAreaAc(CatEstatusAreaAc catEstatusAreaAc) {
		this.catEstatusAreaAc = catEstatusAreaAc;
	}


	//bi-directional many-to-one association to DetHorarioRegistrado
	@OneToMany(mappedBy="catAreaAc")
	public List<DetHorarioRegistrado> getDetHorarioRegistrados() {
		return this.detHorarioRegistrados;
	}

	public void setDetHorarioRegistrados(List<DetHorarioRegistrado> detHorarioRegistrados) {
		this.detHorarioRegistrados = detHorarioRegistrados;
	}

	public DetHorarioRegistrado addDetHorarioRegistrado(DetHorarioRegistrado detHorarioRegistrado) {
		getDetHorarioRegistrados().add(detHorarioRegistrado);
		detHorarioRegistrado.setCatAreaAc(this);

		return detHorarioRegistrado;
	}

	public DetHorarioRegistrado removeDetHorarioRegistrado(DetHorarioRegistrado detHorarioRegistrado) {
		getDetHorarioRegistrados().remove(detHorarioRegistrado);
		detHorarioRegistrado.setCatAreaAc(null);

		return detHorarioRegistrado;
	}


	//bi-directional many-to-one association to DetTelefonoRegistrado
	@OneToMany(mappedBy="catAreaAc")
	public List<DetTelefonoRegistrado> getDetTelefonoRegistrados() {
		return this.detTelefonoRegistrados;
	}

	public void setDetTelefonoRegistrados(List<DetTelefonoRegistrado> detTelefonoRegistrados) {
		this.detTelefonoRegistrados = detTelefonoRegistrados;
	}

	public DetTelefonoRegistrado addDetTelefonoRegistrado(DetTelefonoRegistrado detTelefonoRegistrado) {
		getDetTelefonoRegistrados().add(detTelefonoRegistrado);
		detTelefonoRegistrado.setCatAreaAc(this);

		return detTelefonoRegistrado;
	}

	public DetTelefonoRegistrado removeDetTelefonoRegistrado(DetTelefonoRegistrado detTelefonoRegistrado) {
		getDetTelefonoRegistrados().remove(detTelefonoRegistrado);
		detTelefonoRegistrado.setCatAreaAc(null);

		return detTelefonoRegistrado;
	}

	//bi-directional many-to-one association to CatTipoVialidad
	@ManyToOne
	@JoinColumn(name="id_tipo_vialidad")
	public CatTipoVialidad getCatTipoVialidad() {
		return catTipoVialidad;
	}

	public void setCatTipoVialidad(CatTipoVialidad catTipoVialidad) {
		this.catTipoVialidad = catTipoVialidad;
	}

	
	@ManyToOne
	@JoinColumn(name = "id_dependencia")
	public CatDependencia getCatDependencia() {
		return catDependencia;
	}

	public void setCatDependencia(CatDependencia catDependencia) {
		this.catDependencia = catDependencia;
	}

}