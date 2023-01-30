package mx.gob.cdmx.adip.portaltramites.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cat_tema", schema = "portaltramitescdmx")
@NamedQueries({   
     @NamedQuery(name="CatTema.findAllBack"
            , query = "SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.CatTemaDTO"
	                    + "( "
	                    + " ct.idCatTema, "
	                    + " ct.descripcion, " 
	                    + " ct.situacion " 
	                    + ") "
	                    + " FROM CatTema  ct "
	                    + " WHERE ct.situacion = true "
						+ " order by ct.descripcion ASC")    				
})
public class CatTema implements java.io.Serializable {

	private static final long serialVersionUID = -4574106433843071228L;
	private Long idCatTema;
	private String descripcion;
	private Long idCategoria;
	private Boolean situacion;
	
	public CatTema() {
		
	}

	public CatTema(Long idCatTema) {
		this.idCatTema = idCatTema;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cat_tema", unique = true, nullable = false)
	public Long getIdCatTema() {
		return this.idCatTema;
	}

	public void setIdCatTema(Long idCatTema) {
		this.idCatTema = idCatTema;
	}

	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "id_categoria", nullable = false)
	public Long getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "situacion")
	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
