package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the crc_mod_tramite_fundamento database table.
 * 
 */
@Entity
@Table(name="crc_mod_tramite_fundamento", schema = "retys_v2")
@NamedQueries({
	@NamedQuery(name="CrcModTramiteFundamento.findAll", query="SELECT c FROM CrcModTramiteFundamento c")
})
public class CrcModTramiteFundamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer estatusCampo;
	//private CrcModificacion crcModificacion;
	private CrcTramiteFundamento crcTramiteFundamento;

	public CrcModTramiteFundamento() {
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

	//bi-directional many-to-one association to CrcTramiteFundamento2
	@ManyToOne
	@JoinColumn(name="id_tramite_fundamento")
	public CrcTramiteFundamento getCrcTramiteFundamento() {
		return this.crcTramiteFundamento;
	}

	public void setCrcTramiteFundamento(CrcTramiteFundamento crcTramiteFundamento) {
		this.crcTramiteFundamento = crcTramiteFundamento;
	}

}