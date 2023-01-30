package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crc_mod_requisito_modalidad database table.
 * 
 */
@Entity
@Table(name="crc_mod_requisito_modalidad", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CrcModRequisitoModalidad.findAll", query="SELECT c FROM CrcModRequisitoModalidad c")
})
public class CrcModRequisitoModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer estatusCampo;
//	private CrcModificacion crcModificacion;
	private DetRequisitosModalidad detRequisitosModalidad;

	public CrcModRequisitoModalidad() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="estatus_campo")
	public Integer getEstatusCampo() {
		return this.estatusCampo;
	}

	public void setEstatusCampo(Integer estatusCampo) {
		this.estatusCampo = estatusCampo;
	}


	//bi-directional many-to-one association to CrcModificacion2
//	@ManyToOne
//	@JoinColumn(name="id_modificacion")
//	public CrcModificacion getCrcModificacion() {
//		return this.crcModificacion;
//	}

//	public void setCrcModificacion(CrcModificacion crcModificacion) {
//		this.crcModificacion = crcModificacion;
//	}


	//bi-directional many-to-one association to DetRequisitosModalidad2
	@ManyToOne
	@JoinColumn(name="id_requisito_modalidad")
	public DetRequisitosModalidad getDetRequisitosModalidad() {
		return this.detRequisitosModalidad;
	}

	public void setDetRequisitosModalidad(DetRequisitosModalidad detRequisitosModalidad) {
		this.detRequisitosModalidad = detRequisitosModalidad;
	}

}