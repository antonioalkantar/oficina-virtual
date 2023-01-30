package mx.gob.cdmx.adip.portaltx.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "registro", schema = "\"portalcdmx-tx\"")
@NamedQueries({
	  @NamedQuery(name = "Registro.findAllByIdUsuario"
	, query = "SELECT NEW mx.gob.cdmx.adip.portaltx.dto.RegistroDTO"
			+ "( "
			+ "r.idRegistro, "
			+ "r.fechaRegistro, "
			+ "r.idUsuarioLlaveCdmx, "
			+ "r.idRegistroOrigen, "
			+ "ce.idEstatus, "
			+ "ce.descripcion, "
			+ "cf.idFuncionalidad, "
			+ "cf.nombre, "
			+ "cf.urlEspecifica, "
			+ "ctf.idTipoFuncionalidad, "
			+ "ctf.descripcion, "
			+ "cs.idSistema, "
			+ "cs.nombre, "
			+ "cs.urlHome, "
			+ "cs.pathImagen, "
			+ "cs.activo, "
			+ "cd.idDependencia, "
			+ "cd.nombre, "
			+ "cd.activo"
			+ ") "
			+ "FROM Registro r "
			+ "JOIN r.catEstatus ce "
			+ "JOIN r.catFuncionalidad cf "
			+ "JOIN cf.catTipoFuncionalidad ctf "
			+ "JOIN cf.catSistema cs "
			+ "JOIN cs.catDependencia cd "
			+ "WHERE (r.idUsuarioLlaveCdmx =:idUsuarioLlaveCdmx or r.curpUsuario =:curpUsuario or r.correoUsuario =:correoUsuario ) "
			+ "AND r.visible = true "
			+ "ORDER BY r.fechaRegistro DESC"
			)
})
public class Registro implements Serializable {


	private static final long serialVersionUID = 301629477183964274L;
	private long idRegistro;
	private CatEstatus catEstatus;
	private CatFuncionalidad catFuncionalidad;
	private CatOrigenRegistro catOrigenRegistro;	
	private String idRegistroOrigen;
	private Date fechaRegistro;
	private Date fechaRecibido;
	private Date fechaUltimaActualizacion;
	private Long idUsuarioLlaveCdmx;
	private String curpUsuario;
	private String correoUsuario;
	private boolean visible;

	public Registro() {
	}

	@Id

	@Column(name = "id_registro", unique = true, nullable = false)
	public long getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estatus", nullable = false)
	public CatEstatus getCatEstatus() {
		return this.catEstatus;
	}

	public void setCatEstatus(CatEstatus catEstatus) {
		this.catEstatus = catEstatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcionalidad", nullable = false)
	public CatFuncionalidad getCatFuncionalidad() {
		return this.catFuncionalidad;
	}

	public void setCatFuncionalidad(CatFuncionalidad catFuncionalidad) {
		this.catFuncionalidad = catFuncionalidad;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_origen_registro", nullable = false)
	public CatOrigenRegistro getCatOrigenRegistro() {
		return this.catOrigenRegistro;
	}

	public void setCatOrigenRegistro(CatOrigenRegistro catOrigenRegistro) {
		this.catOrigenRegistro = catOrigenRegistro;
	}

	@Column(name = "id_registro_origen", nullable = false)
	public String getIdRegistroOrigen() {
		return this.idRegistroOrigen;
	}

	public void setIdRegistroOrigen(String idRegistroOrigen) {
		this.idRegistroOrigen = idRegistroOrigen;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false, length = 29)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_recibido", nullable = false, length = 29)
	public Date getFechaRecibido() {
		return this.fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ultima_actualizacion", nullable = false, length = 29)
	public Date getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	@Column(name = "id_usuario_llave_cdmx")
	public Long getIdUsuarioLlaveCdmx() {
		return this.idUsuarioLlaveCdmx;
	}

	public void setIdUsuarioLlaveCdmx(Long idUsuarioLlaveCdmx) {
		this.idUsuarioLlaveCdmx = idUsuarioLlaveCdmx;
	}

	@Column(name = "curp_usuario", length = 18)
	public String getCurpUsuario() {
		return this.curpUsuario;
	}

	public void setCurpUsuario(String curpUsuario) {
		this.curpUsuario = curpUsuario;
	}

	@Column(name = "correo_usuario")
	public String getCorreoUsuario() {
		return this.correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	@Column(name = "visible", nullable = false)
	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
