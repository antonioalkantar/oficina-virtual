package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the det_documento_modalidad database table.
 * 
 */
@Entity
@Table(name="det_documento_modalidad", schema = "retys_v2")
//@NamedQuery(name="DetDocumentoModalidad.findAll", query="SELECT d FROM DetDocumentoModalidad d")
public class DetDocumentoModalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idCantidadCopias;
	private CatCantidadCaracteristica catCantidadCaracteristica;
	private CatDocumentoRequisito catDocumentoRequisito;
	private CatTipoDocumento catTipoDocumento;
	private CrcFlujoTramite crcFlujoTramite;
	private DetModalidadesTramite detModalidadesTramite;

	public DetDocumentoModalidad() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="id_cantidad_copias")
	public Long getIdCantidadCopias() {
		return this.idCantidadCopias;
	}

	public void setIdCantidadCopias(Long idCantidadCopias) {
		this.idCantidadCopias = idCantidadCopias;
	}


	//bi-directional many-to-one association to CatCantidadCaracteristica
	@ManyToOne
	@JoinColumn(name="id_cantidad_caracteristicas")
	public CatCantidadCaracteristica getCatCantidadCaracteristica() {
		return this.catCantidadCaracteristica;
	}

	public void setCatCantidadCaracteristica(CatCantidadCaracteristica catCantidadCaracteristica) {
		this.catCantidadCaracteristica = catCantidadCaracteristica;
	}


	//bi-directional many-to-one association to CatDocumentoRequisito
	@ManyToOne
	@JoinColumn(name="id_documento_modalidad")
	public CatDocumentoRequisito getCatDocumentoRequisito() {
		return this.catDocumentoRequisito;
	}

	public void setCatDocumentoRequisito(CatDocumentoRequisito catDocumentoRequisito) {
		this.catDocumentoRequisito = catDocumentoRequisito;
	}


	//bi-directional many-to-one association to CatTipoDocumento
	@ManyToOne
	@JoinColumn(name="id_tipo_documento")
	public CatTipoDocumento getCatTipoDocumento() {
		return this.catTipoDocumento;
	}

	public void setCatTipoDocumento(CatTipoDocumento catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
	}


	//bi-directional many-to-one association to CrcFlujoTramite
	@ManyToOne
	@JoinColumn(name="id_flujo_tramite")
	public CrcFlujoTramite getCrcFlujoTramite() {
		return this.crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramite crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}


	//bi-directional many-to-one association to DetModalidadesTramite
	@ManyToOne
	@JoinColumn(name="id_modalidad_tramite")
	public DetModalidadesTramite getDetModalidadesTramite() {
		return this.detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

}