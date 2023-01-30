package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_tipo_solicitud database table.
 * 
 */
@Entity
@Table(name="cat_tipo_solicitud", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatTipoSolicitud.findAll", query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatTipoSolicitudDTO(c.id, c.descripcion) FROM CatTipoSolicitud c where c.situacion = true order by c.descripcion ASC")
//})
public class CatTipoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<CrcFlujoTramite> crcFlujoTramites;

	public CatTipoSolicitud() {
	}
	public CatTipoSolicitud(Long id) {
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


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@OneToMany(mappedBy="catTipoSolicitud")
	public List<CrcFlujoTramite> getCrcFlujoTramites() {
		return this.crcFlujoTramites;
	}

	public void setCrcFlujoTramites(List<CrcFlujoTramite> crcFlujoTramites) {
		this.crcFlujoTramites = crcFlujoTramites;
	}

	public CrcFlujoTramite addCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		getCrcFlujoTramites().add(crcFlujoTramite);
		crcFlujoTramite.setCatTipoSolicitud(this);

		return crcFlujoTramite;
	}

	public CrcFlujoTramite removeCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		getCrcFlujoTramites().remove(crcFlujoTramite);
		crcFlujoTramite.setCatTipoSolicitud(null);

		return crcFlujoTramite;
	}

}