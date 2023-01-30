package mx.gob.cdmx.adip.portaltramites.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "responsible_units", schema = "public")
public class ResponsibleUnits implements java.io.Serializable {
	
	private static final long serialVersionUID = -155777480369718848L;
	private long id;
	private String clave;
	private String desc;
	private String siglas;
	private int estatus;
	private Date deletedAt;
	private Date createdAt;
	private Date updatedAt;
	private int tipoEnte;
	private CatDependenciaRetys catDependenciaRetys;
	
//	private Integer idDependencia;
	
//	private Set<CifrasControlProgramasPadron> cifrasControlProgramasPadrons = new HashSet<CifrasControlProgramasPadron>(
//			0);
//	private Set<PadronBeneficiarios> padronBeneficiarioses = new HashSet<PadronBeneficiarios>(0);

	public ResponsibleUnits() {	
		catDependenciaRetys = new CatDependenciaRetys();
	}	

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "clave", nullable = false)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "desc", nullable = false)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "siglas", nullable = false)
	public String getSiglas() {
		return this.siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	@Column(name = "estatus", nullable = false)
	public int getEstatus() {
		return this.estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_at", length = 22)
	public Date getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 22)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 22)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "tipo_ente", nullable = false)
	public int getTipoEnte() {
		return this.tipoEnte;
	}

	public void setTipoEnte(int tipoEnte) {
		this.tipoEnte = tipoEnte;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_dependencia_retys")
	public CatDependenciaRetys getCatDependenciaRetys() {
		return this.catDependenciaRetys;
	}

	public void setCatDependenciaRetys(CatDependenciaRetys catDependenciaRetys) {
		this.catDependenciaRetys = catDependenciaRetys;
	}
	

//	@Column(name = "id_dependencia_retys")
//	public Integer getIdDependencia() {
//		return idDependencia;
//	}
//
//	public void setIdDependencia(Integer idDependencia) {
//		this.idDependencia = idDependencia;
//	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsibleUnits")
//	public Set<CifrasControlProgramasPadron> getCifrasControlProgramasPadrons() {
//		return this.cifrasControlProgramasPadrons;
//	}
//
//	public void setCifrasControlProgramasPadrons(Set<CifrasControlProgramasPadron> cifrasControlProgramasPadrons) {
//		this.cifrasControlProgramasPadrons = cifrasControlProgramasPadrons;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsibleUnits")
//	public Set<PadronBeneficiarios> getPadronBeneficiarioses() {
//		return this.padronBeneficiarioses;
//	}
//
//	public void setPadronBeneficiarioses(Set<PadronBeneficiarios> padronBeneficiarioses) {
//		this.padronBeneficiarioses = padronBeneficiarioses;
//	}

}

