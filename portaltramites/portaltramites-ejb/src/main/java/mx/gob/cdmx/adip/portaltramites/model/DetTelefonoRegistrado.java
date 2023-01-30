package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_telefono_registrado database table.
 * 
 */
@Entity
@Table(name="det_telefono_registrado", schema = "retys_v2")
@NamedQueries({
@NamedQuery(name="DetTelefonoRegistrado.findAll", query="SELECT d FROM DetTelefonoRegistrado d"),
@NamedQuery(name="DetTelefonoRegistrado.buscarPorIdArea",
	query="SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetTelefonoRegistradoDTO"
		+ " ("
		+ " d.id,"
		+ " d.extensionTel,"
		+ " d.numeroTelefono,"
		+ " area.id"
		+ ") "
		+ "FROM DetTelefonoRegistrado d"
		+ " INNER JOIN d.catAreaAc area"
		+ " WHERE area.id = :idArea "
		+ " AND d.situacion = TRUE "
		+ " ORDER BY d.id ASC")
})
public class DetTelefonoRegistrado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String extensionTel;
	private String numeroTelefono;
	private CatAreaAc catAreaAc;
	private Boolean situacion;

	public DetTelefonoRegistrado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="extension_tel")
	public String getExtensionTel() {
		return this.extensionTel;
	}

	public void setExtensionTel(String extensionTel) {
		this.extensionTel = extensionTel;
	}


	@Column(name="numero_telefono")
	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


	//bi-directional many-to-one association to CatAreaAc
	@ManyToOne
	@JoinColumn(name="id_area_ac")
	public CatAreaAc getCatAreaAc() {
		return this.catAreaAc;
	}

	public void setCatAreaAc(CatAreaAc catAreaAc) {
		this.catAreaAc = catAreaAc;
	}


	public Boolean getSituacion() {
		return situacion;
	}


	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}