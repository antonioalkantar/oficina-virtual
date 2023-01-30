package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_etapas_tramite database table.
 * 
 */
@Entity
@Table(name="cat_etapas_tramite", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatEtapasTramite.findAll", query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatEtapasTramiteDTO(c.id, c.descripcion) FROM CatEtapasTramite c order by c.descripcion ASC")
//})
public class CatEtapasTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean esProcesoFinal;
	private Boolean situacion;
	private List<CrcFlujoTramite> crcFlujoTramites;
//	private List<CrcDiasTramite> crcDiasTramites;

	public CatEtapasTramite() {
	}
	
	public CatEtapasTramite(Long id) {
		this.id = id;
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


	@Column(name="es_proceso_final")
	public Boolean getEsProcesoFinal() {
		return this.esProcesoFinal;
	}

	public void setEsProcesoFinal(Boolean esProcesoFinal) {
		this.esProcesoFinal = esProcesoFinal;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@OneToMany(mappedBy="catEtapasTramite")
	public List<CrcFlujoTramite> getCrcFlujoTramites() {
		return this.crcFlujoTramites;
	}

	public void setCrcFlujoTramites(List<CrcFlujoTramite> crcFlujoTramites) {
		this.crcFlujoTramites = crcFlujoTramites;
	}

//	public CrcFlujoTramite addCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
//		getCrcFlujoTramites().add(crcFlujoTramite);
//		crcFlujoTramite.setCatEtapasTramite(this);
//
//		return crcFlujoTramite;
//	}
//
//	public CrcFlujoTramite removeCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
//		getCrcFlujoTramites().remove(crcFlujoTramite);
//		crcFlujoTramite.setCatEtapasTramite(null);
//
//		return crcFlujoTramite;
//	}
	
	//bi-directional many-to-one association to CrcDiasTramite
//	@OneToMany(mappedBy="catEtapasTramite")
//	public List<CrcDiasTramite> getCrcDiasTramites() {
//		return this.crcDiasTramites;
//	}
//
//	public void setCrcDiasTramites(List<CrcDiasTramite> crcDiasTramites) {
//		this.crcDiasTramites = crcDiasTramites;
//	}
//
//	public CrcDiasTramite addCrcDiasTramite(CrcDiasTramite crcDiasTramite) {
//		getCrcDiasTramites().add(crcDiasTramite);
//		crcDiasTramite.setCatEtapasTramite(this);
//
//		return crcDiasTramite;
//	}

//	public CrcDiasTramite removeCrcDiasTramite(CrcDiasTramite crcDiasTramite) {
//		getCrcDiasTramites().remove(crcDiasTramite);
//		crcDiasTramite.setCatEtapasTramite(null);
//
//		return crcDiasTramite;
//	}

}