package mx.gob.cdmx.adip.portaltx.model;

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
@Table(name = "cat_estatus", schema = "\"portalcdmx-tx\"")
@NamedQueries({
    @NamedQuery(name="CatEstatus.findAllTx"
            ,query="SELECT new mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO" 
            		+ "(" 
            		+ "  t.idEstatus " 
            		+ ", t.descripcion " 
            		+ " ) " 
            		+ " FROM CatEstatus  t "
                    )
})
public class CatEstatus implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6335929810333634508L;
	private Integer idEstatus;
	private String descripcion;
	private Set<Registro> registros = new HashSet<Registro>(0);

	public CatEstatus() {
	}

	@Id

	@Column(name = "id_estatus", unique = true, nullable = false)
	public Integer getIdEstatus() {
		return this.idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	@Column(name = "descripcion", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catEstatus")
	public Set<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

}
