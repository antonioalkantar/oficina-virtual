package mx.gob.cdmx.adip.portaltx.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="catDependenciaTx")
@Table(name = "cat_dependencia", schema = "\"portalcdmx-tx\"")
@NamedQueries({
    @NamedQuery(name="CatDependenciaTx.findAllTx"
            ,query="SELECT new mx.gob.cdmx.adip.portaltx.dto.CatDependenciaTxDTO" 
            		+ "(" 
            		+ "  t.idDependencia " 
            		+ ", t.nombre " 
            		+ ", t.acronimo " 
            		+ " ) " 
            		+ " FROM catDependenciaTx  t "
                    + " WHERE t.activo = true "
                    + "	ORDER BY t.nombre"
                    )
})
public class CatDependencia implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6120146853253289704L;

	private Integer idDependencia;
	private String nombre;
	private String acronimo;
	private boolean activo;
	private Date fechaAlta;
	private Set<CatSistema> catSistemas = new HashSet<CatSistema>(0);

	public CatDependencia() {
	}

	@Id

	@Column(name = "id_dependencia", unique = true, nullable = false)
	public Integer getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	@Column(name = "nombre", nullable = false, length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "acronimo", length = 50)
	public String getAcronimo() {
		return this.acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_alta", nullable = false, length = 13)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catDependencia")
	public Set<CatSistema> getCatSistemas() {
		return this.catSistemas;
	}

	public void setCatSistemas(Set<CatSistema> catSistemas) {
		this.catSistemas = catSistemas;
	}

}
