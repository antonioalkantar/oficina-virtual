package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_es_tramite_servicio database table.
 * 
 */
@Entity
@Table(name="cat_es_tramite_servicio", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CatEsTramiteServicio.findAll"
			, query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.CatEsTramiteServicioDTO(c.id "
					+ ", c.descripcion "
					+ ", c.situacion) "
					+ "FROM CatEsTramiteServicio c "
					+ "where c.situacion = true "
					+ "order by c.descripcion ASC")
})
public class CatEsTramiteServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<TramiteServicio> tramiteServicios;
	private List<TramiteServicioHist> tramiteServicioHist;

	public CatEsTramiteServicio() {
	}
	
	public CatEsTramiteServicio(Long id, String descripcion, Boolean situacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.situacion = situacion;
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


	//bi-directional many-to-one association to TramiteServicio
	@OneToMany(mappedBy="catEsTramiteServicio")
	public List<TramiteServicio> getTramiteServicios() {
		return this.tramiteServicios;
	}

	public void setTramiteServicios(List<TramiteServicio> tramiteServicios) {
		this.tramiteServicios = tramiteServicios;
	}

	//bi-directional many-to-one association to TramiteServicio
	@OneToMany(mappedBy="catEsTramiteServicio")
	public List<TramiteServicioHist> getTramiteServicioHist() {
		return this.tramiteServicioHist;
	}

	public void setTramiteServicioHist(List<TramiteServicioHist> tramiteServicioHist) {
		this.tramiteServicioHist = tramiteServicioHist;
	}
}