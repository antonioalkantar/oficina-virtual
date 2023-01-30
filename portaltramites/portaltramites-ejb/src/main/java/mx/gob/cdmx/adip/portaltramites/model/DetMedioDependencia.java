package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the det_medio_dependencia database table.
 * 
 */
@Entity
@Table(name="det_medio_dependencia", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="DetMedioDependencia.findAll", query="SELECT d FROM DetMedioDependencia d"),
	
	@NamedQuery(name="DetMedioDependencia.findByIdCosto"
    , query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioDependenciaDTO"
            + "("
            + "dmd.id"
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.articuloLeyReglamento else dmd.articuloLeyReglamento end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.calle else dmd.calle end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.numeroExterior else dmd.numeroExterior end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.numeroInterior else dmd.numeroInterior end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.numeroReferencia else dmd.numeroReferencia end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.otraLey else dmd.otraLey end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then dmdHist.situacion else dmd.situacion end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then caHist.idAlcaldia else ca.idAlcaldia end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then caHist.idEstado else ca.idEstado end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then caHist.idMunicipioPorEstado else ca.idMunicipioPorEstado end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then caHist.municipio else ca.municipio end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then casHist.idAsentamiento else cas.idAsentamiento end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then casHist.asentamiento else cas.asentamiento end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then ccpHist.idCodigoPostal else ccp.idCodigoPostal end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then ccpHist.codigoPostal else ccp.codigoPostal end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then ctvHist.id else ctv.id end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then ctvHist.descripcion else ctv.descripcion end "
            + ", cft.id"
            + ", dc.id"
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then clHist.id else cl.id end " 
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then clHist.nombre else cl.nombre end "
            + ", case when cestt.id = 2 and cet.esProcesoFinal = false and dmdHist.id is not null then clHist.situacion else cl.situacion end "
            + ")"
            + "FROM DetMedioDependencia dmd "
            + "join dmd.catAlcaldia ca "
            + "join dmd.catAsentamiento cas "
            + "join dmd.catCodigosPostale ccp "
            + "join dmd.catTipoVialidad ctv "
            + "join dmd.detCosto dc "
            + "join dmd.catLeye cl "

            + "left join dmd.detMedioDependenciaHist dmdHist "
            + "left join dmdHist.catAlcaldia caHist "
            + "left join dmdHist.catAsentamiento casHist "
            + "left join dmdHist.catCodigosPostale ccpHist "
            + "left join dmdHist.catTipoVialidad ctvHist "
            + "left join dmdHist.catLeye clHist "

            + "join dmd.crcFlujoTramite cft "
            + "join cft.catEtapasTramite cet "
            + "join cft.catEstatusTramite cestt "
            + "join cft.catTipoSolicitud cts "
            
            + "where dc.id = :idCosto "
            + "and dmd.situacion = true"
            )
//    , query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioDependenciaDTO"
//            + "("
//            + "dmd.id"
//            + ", dmd.articuloLeyReglamento"
//            + ", dmd.calle"
//            + ", dmd.numeroExterior"
//            + ", dmd.numeroInterior"
//            + ", dmd.numeroReferencia"
//            + ", dmd.otraLey"
//            + ", dmd.situacion"
//            + ", ca.idAlcaldia"
//            + ", ca.idEstado"
//            + ", ca.idMunicipioPorEstado"
//            + ", ca.municipio"
//            + ", cas.idAsentamiento"
//            + ", cas.asentamiento"
//            + ", ccp.idCodigoPostal"
//            + ", ccp.codigoPostal"
//            + ", ctv.id"
//            + ", ctv.descripcion"            
//            + ", cft.id"
//            + ", dc.id"
//            + ", cl.id" 
//            + ", cl.nombre"
//            + ", cl.situacion"
//            + ")"
//            + "FROM DetMedioDependencia dmd "
//            + "join dmd.catAlcaldia ca "
//            + "join dmd.catAsentamiento cas "
//            + "join dmd.catCodigosPostale ccp "
//            + "join dmd.catTipoVialidad ctv "
//            + "join dmd.crcFlujoTramite cft "
//            + "join dmd.detCosto dc "
//            + "join dmd.catLeye cl "
//            + "where dc.id = :idCosto "
//            + "and dmd.situacion = true"
//            )
})

public class DetMedioDependencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String articuloLeyReglamento;
	private String calle;
	private String numeroExterior;
	private String numeroInterior;
	private String numeroReferencia;
	private String otraLey;
	private Boolean situacion;
//	private List<DetHorariosMedioDependencia> detHorariosMedioDependencias;
	private CatAlcaldia catAlcaldia;
	private CatAsentamiento catAsentamiento;
	private CatCodigosPostale catCodigosPostale;
	private CatLeye catLeye;
	private CatTipoVialidad catTipoVialidad;
	private CrcFlujoTramite crcFlujoTramite;
	private DetCosto detCosto;
	private DetMedioDependenciaHist detMedioDependenciaHist;

	public DetMedioDependencia() {
	}
	
	public DetMedioDependencia(Long id) {
	
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


	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}


	@Column(name="numero_exterior")
	public String getNumeroExterior() {
		return this.numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}


	@Column(name="numero_interior")
	public String getNumeroInterior() {
		return this.numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}


	@Column(name="numero_referencia")
	public String getNumeroReferencia() {
		return this.numeroReferencia;
	}

	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}


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
	@JoinColumn(name="id_colonia")
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


	//bi-directional many-to-one association to CatLeye
	@ManyToOne
	@JoinColumn(name="id_fundamento_juridico")
	public CatLeye getCatLeye() {
		return this.catLeye;
	}

	public void setCatLeye(CatLeye catLeye) {
		this.catLeye = catLeye;
	}


	//bi-directional many-to-one association to CatTipoVialidad
	@ManyToOne
	@JoinColumn(name="id_tipo_vialidad")
	public CatTipoVialidad getCatTipoVialidad() {
		return this.catTipoVialidad;
	}

	public void setCatTipoVialidad(CatTipoVialidad catTipoVialidad) {
		this.catTipoVialidad = catTipoVialidad;
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


	//bi-directional many-to-one association to DetCosto
	@ManyToOne
	@JoinColumn(name="id_costos")
	public DetCosto getDetCosto() {
		return this.detCosto;
	}

	public void setDetCosto(DetCosto detCosto) {
		this.detCosto = detCosto;
	}

	@OneToOne
	@JoinColumn(name="id")
	public DetMedioDependenciaHist getDetMedioDependenciaHist() {
		return detMedioDependenciaHist;
	}

	public void setDetMedioDependenciaHist(DetMedioDependenciaHist detMedioDependenciaHist) {
		this.detMedioDependenciaHist = detMedioDependenciaHist;
	}

}