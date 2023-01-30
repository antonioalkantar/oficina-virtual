package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the cat_vigencia database table.
 * 
 */
@Entity
@Table(name="cat_vigencia", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatVigencia.findAll", query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatVigenciaDTO("
//			+ "c.id, c.descripcion,"
//			+ "c.situacion) "
//			+ "FROM CatVigencia c"
//			+ " WHERE c.situacion = true "
//			+ " ORDER BY c.descripcion ASC "),
//	@NamedQuery(name="CatVigencia.findAllSinFiltro", query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatVigenciaDTO("
//			+ "c.id, c.descripcion,"
//			+ "c.situacion) "
//			+ "FROM CatVigencia c"			
//			+ " ORDER BY c.descripcion ASC "),
//	@NamedQuery(name="CatVigencia.buscarEntrada", query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatVigenciaDTO("
//				+ "c.id, c.descripcion,"
//				+ "c.situacion) "
//				+ "FROM CatVigencia c"
//				+ " WHERE c.situacion = true "
//				+ " AND  LOWER(c.descripcion)  LIKE LOWER(:cadena)"
//				+ " ORDER BY c.descripcion ASC ")
//	
//	
//})
public class CatVigencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetVigencia> detVigencias;
	private List<DetVigenciaHist> detVigenciasHist;
	private List<DetVigenciaModalidad> detVigenciaModalidads;

	public CatVigencia() {
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
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}
	
	//bi-directional many-to-one association to DetVigencia2
	@OneToMany(mappedBy="catVigencia")
	public List<DetVigencia> getDetVigencias() {
		return this.detVigencias;
	}

	public void setDetVigencias(List<DetVigencia> detVigencias) {
		this.detVigencias = detVigencias;
	}


	//bi-directional many-to-one association to DetVigenciaModalidad2
	@OneToMany(mappedBy="catVigencia")
	public List<DetVigenciaModalidad> getDetVigenciaModalidads() {
		return this.detVigenciaModalidads;
	}

	public void setDetVigenciaModalidads(List<DetVigenciaModalidad> detVigenciaModalidads) {
		this.detVigenciaModalidads = detVigenciaModalidads;
	}


	//bi-directional many-to-one association to DetVigencia2
	@OneToMany(mappedBy="catVigencia")	
	public List<DetVigenciaHist> getDetVigenciasHist() {
		return detVigenciasHist;
	}


	public void setDetVigenciasHist(List<DetVigenciaHist> detVigenciasHist) {
		this.detVigenciasHist = detVigenciasHist;
	}

}