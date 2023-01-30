package mx.gob.cdmx.adip.portaltx.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cat_tipo_funcionalidad", schema = "\"portalcdmx-tx\"")
@NamedQueries({
    @NamedQuery(name="CatTipoFuncionalidad.findAllTx"
            ,query="SELECT new mx.gob.cdmx.adip.portaltx.dto.CatTipoFuncionalidadDTO" 
            		+ "(" 
            		+ "  t.idTipoFuncionalidad " 
            		+ ", t.descripcion " 
            		+ " ) " 
            		+ " FROM CatTipoFuncionalidad  t "
            		+ " WHERE t.activo = true"
            		+ "	ORDER BY t.idTipoFuncionalidad"
                    )
})
public class CatTipoFuncionalidad implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8072227438589168161L;
	private Integer idTipoFuncionalidad;
	private String descripcion;
	private boolean activo;
	private Set<CatFuncionalidad> catFuncionalidads = new HashSet<CatFuncionalidad>(0);

	public CatTipoFuncionalidad() {
	}


	@Id
	@Column(name = "id_tipo_funcionalidad", unique = true, nullable = false)
	public Integer getIdTipoFuncionalidad() {
		return this.idTipoFuncionalidad;
	}

	public void setIdTipoFuncionalidad(Integer idTipoFuncionalidad) {
		this.idTipoFuncionalidad = idTipoFuncionalidad;
	}

	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catTipoFuncionalidad")
	public Set<CatFuncionalidad> getCatFuncionalidads() {
		return this.catFuncionalidads;
	}

	public void setCatFuncionalidads(Set<CatFuncionalidad> catFuncionalidads) {
		this.catFuncionalidads = catFuncionalidads;
	}

}
