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

import mx.gob.cdmx.adip.portaltx.model.CatDependencia;

@Entity
@Table(name = "cat_sistema", schema = "\"portalcdmx-tx\"")
@NamedQueries({
    @NamedQuery(name="CatSistema.findAllTx"
            ,query="SELECT new mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO" 
            		+ "(" 
            		+ "  t.idSistema " 
            		+ ", t.nombre " 
            		+ ", t.urlHome " 
            		+ ", t.pathImagen " 
            		+ ", cd.idDependencia " 
            		+ ", cd.nombre " 
            		+ ", cd.acronimo " 
            		+ " ) " 
            		+ " FROM CatSistema  t "
            		+ " INNER JOIN t.catDependencia cd"
            		+ " WHERE t.activo = true"
                    )
})
public class CatSistema implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7232937711103924754L;
	private Integer idSistema;
	private CatDependencia  catDependencia;
	private String nombre;
	private String urlHome;
	private boolean activo;
	private Date fechaAlta;
	private String pathImagen;
	private Set<CatFuncionalidad> catFuncionalidads = new HashSet<CatFuncionalidad>(0);

	public CatSistema() {
	}


	@Id

	@Column(name = "id_sistema", unique = true, nullable = false)
	public Integer getIdSistema() {
		return this.idSistema;
	}

	public void setIdSistema(Integer idSistema) {
		this.idSistema = idSistema;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_dependencia")
	public CatDependencia getCatDependencia() {
		return this.catDependencia;
	}

	public void setCatDependencia(CatDependencia catDependencia) {
		this.catDependencia = catDependencia;
	}

	@Column(name = "nombre", nullable = false, length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "url_home", nullable = false, length = 500)
	public String getUrlHome() {
		return this.urlHome;
	}

	public void setUrlHome(String urlHome) {
		this.urlHome = urlHome;
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

	@Column(name = "path_imagen", nullable = false, length = 500)
	public String getPathImagen() {
		return this.pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catSistema")
	public Set<CatFuncionalidad> getCatFuncionalidads() {
		return this.catFuncionalidads;
	}

	public void setCatFuncionalidads(Set<CatFuncionalidad> catFuncionalidads) {
		this.catFuncionalidads = catFuncionalidads;
	}

}
