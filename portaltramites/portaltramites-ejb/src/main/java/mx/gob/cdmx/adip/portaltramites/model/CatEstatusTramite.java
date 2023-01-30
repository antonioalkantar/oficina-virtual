package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_estatus_tramite database table.
 * 
 */
@Entity
@Table(name="cat_estatus_tramite", schema = "retys_v2")
@NamedQuery(name="CatEstatusTramite.findAll", query="SELECT c FROM CatEstatusTramite c")
public class CatEstatusTramite implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean esProcesoFinal;
	private Boolean situacion;
	private List<CrcFlujoTramite> crcFlujoTramites;

	public CatEstatusTramite() {
	}
	
	public CatEstatusTramite(Long id) {
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
	@OneToMany(mappedBy="catEstatusTramite")
	public List<CrcFlujoTramite> getCrcFlujoTramites() {
		return this.crcFlujoTramites;
	}

	public void setCrcFlujoTramites(List<CrcFlujoTramite> crcFlujoTramites) {
		this.crcFlujoTramites = crcFlujoTramites;
	}

	public CrcFlujoTramite addCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		getCrcFlujoTramites().add(crcFlujoTramite);
		crcFlujoTramite.setCatEstatusTramite(this);

		return crcFlujoTramite;
	}

	public CrcFlujoTramite removeCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		getCrcFlujoTramites().remove(crcFlujoTramite);
		crcFlujoTramite.setCatEstatusTramite(null);

		return crcFlujoTramite;
	}

}