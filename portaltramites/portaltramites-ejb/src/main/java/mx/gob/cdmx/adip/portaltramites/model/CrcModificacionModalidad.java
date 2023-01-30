package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crc_modificacion_modalidad database table.
 * 
 */
@Entity
@Table(name="crc_modificacion_modalidad", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CrcModificacionModalidad.findAll", query="SELECT c FROM CrcModificacionModalidad c")
})
public class CrcModificacionModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer estatusCampo;
//	private CrcModificacion crcModificacion;
	private DetModalidadesTramite detModalidadesTramite;

	public CrcModificacionModalidad() {
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

/*
	//bi-directional many-to-one association to CrcModificacion2
	@ManyToOne
	@JoinColumn(name="id_modificacion")
	public CrcModificacion getCrcModificacion() {
		return this.crcModificacion;
	}

	public void setCrcModificacion(CrcModificacion crcModificacion) {
		this.crcModificacion = crcModificacion;
	}
*/

	//bi-directional many-to-one association to DetModalidadesTramite2
	@ManyToOne
	@JoinColumn(name="id_modalidad")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return this.detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

}