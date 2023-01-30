package mx.gob.cdmx.adip.portaltx.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cat_funcionalidad", schema = "\"portalcdmx-tx\"")
@NamedQueries({
    @NamedQuery(name="CatFuncionalidad.findAllTx"
            ,query="SELECT new mx.gob.cdmx.adip.portaltx.dto.CatFuncionalidadDTO" 
            		+ "(" 
            		+ "  t.idFuncionalidad " 
            		+ ", t.nombre "
            		+ ", t.urlEspecifica" 
            		+ ", cs.idSistema " 
            		+ ", cs.nombre " 
            		+ ", cs.urlHome " 
            		+ ", cs.pathImagen " 
            		+ ", ctf.idTipoFuncionalidad " 
            		+ ", ctf.descripcion " 
            		+ " ) " 
            		+ " FROM CatFuncionalidad  t "
            		+ " INNER JOIN t.catSistema  cs "
            		+ " INNER JOIN t.catTipoFuncionalidad  ctf "
            		+ " WHERE t.activo = true "
                    )
})
public class CatFuncionalidad implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4443163251652061808L;
	private Integer idFuncionalidad;
	private CatSistema catSistema;
	private CatTipoFuncionalidad catTipoFuncionalidad;
	private String nombre;
	private Date fechaAlta;
	private boolean activo;
	private String urlEspecifica;
	private Set<Registro> registros = new HashSet<Registro>(0);

	public CatFuncionalidad() {
	}

	@Id

	@Column(name = "id_funcionalidad", unique = true, nullable = false)
	public Integer getIdFuncionalidad() {
		return this.idFuncionalidad;
	}

	public void setIdFuncionalidad(Integer idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sistema", nullable = false)
	public CatSistema getCatSistema() {
		return this.catSistema;
	}

	public void setCatSistema(CatSistema catSistema) {
		this.catSistema = catSistema;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_funcionalidad", nullable = false)
	public CatTipoFuncionalidad getCatTipoFuncionalidad() {
		return this.catTipoFuncionalidad;
	}

	public void setCatTipoFuncionalidad(CatTipoFuncionalidad catTipoFuncionalidad) {
		this.catTipoFuncionalidad = catTipoFuncionalidad;
	}

	@Column(name = "nombre", nullable = false, length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_alta", nullable = false, length = 13)
	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Column(name = "activo", nullable = false)
	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Column(name = "url_especifica", nullable = false, length = 500)
	public String getUrlEspecifica() {
		return this.urlEspecifica;
	}

	public void setUrlEspecifica(String urlEspecifica) {
		this.urlEspecifica = urlEspecifica;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catFuncionalidad")
	public Set<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(Set<Registro> registros) {
		this.registros = registros;
	}

}
