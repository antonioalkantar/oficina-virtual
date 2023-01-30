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
@Table(name = "cat_origen_registro", schema = "\"portalcdmx-tx\"")
@NamedQueries({
    @NamedQuery(name="CatOrigenRegistro.findAllTx"
            ,query="SELECT new mx.gob.cdmx.adip.portaltx.dto.CatOrigenRegistroDTO" 
            		+ "(" 
            		+ "  t.idOrigenRegistro " 
            		+ ", t.descripcion " 
            		+ " ) " 
            		+ " FROM CatOrigenRegistro  t "
                    )
})
public class CatOrigenRegistro implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1047515450898781394L;
	private Integer idOrigenRegistro;
	private String descripcion;
	private Set<Registro> registros = new HashSet<Registro>(0);

	public CatOrigenRegistro() {
	}


	@Id

	@Column(name = "id_origen_registro", unique = true, nullable = false)
	public Integer getIdOrigenRegistro() {
		return this.idOrigenRegistro;
	}

	public void setIdOrigenRegistro(Integer idOrigenRegistro) {
		this.idOrigenRegistro = idOrigenRegistro;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catOrigenRegistro")
	public Set<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

}
