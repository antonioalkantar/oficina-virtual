package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_documento_beneficio database table.
 * 
 */
@Entity
@Table(name="cat_documento_beneficio", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatDocumentoBeneficio.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatDocumentoBeneficioDTO(c.id"
//					+ ", c.descripcion"
//					+ ", c.situacion) "
//					+ "FROM CatDocumentoBeneficio c "
//					+ "where c.situacion = true")
//})
public class CatDocumentoBeneficio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetFormato> detFormatos;
	private List<DetFormatoHist> detFormatosHist;
	private List<DetModalidadesTramite> detModalidadesTramites;
	private List<DetModalidadesTramiteHist> detModalidadesTramitesHist;

	public CatDocumentoBeneficio() {
	}

	public CatDocumentoBeneficio(Long id) {
	this.id = id;
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getSituacion() {
		return this.situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	//bi-directional many-to-one association to DetFormato
	@OneToMany(mappedBy="catDocumentoBeneficio")
	public List<DetFormato> getDetFormatos() {
		return this.detFormatos;
	}

	public void setDetFormatos(List<DetFormato> detFormatos) {
		this.detFormatos = detFormatos;
	}

	//bi-directional many-to-one association to DetModalidadesTramite
	@OneToMany(mappedBy="catDocumentoBeneficio")
	public List<DetModalidadesTramite> getDetModalidadesTramites() {
		return this.detModalidadesTramites;
	}

	public void setDetModalidadesTramites(List<DetModalidadesTramite> detModalidadesTramites) {
		this.detModalidadesTramites = detModalidadesTramites;
	}

	public DetModalidadesTramite addDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		getDetModalidadesTramites().add(detModalidadesTramite);
		detModalidadesTramite.setCatDocumentoBeneficio(this);

		return detModalidadesTramite;
	}

	public DetModalidadesTramite removeDetModalidadesTramite(DetModalidadesTramite detModalidadesTramite) {
		getDetModalidadesTramites().remove(detModalidadesTramite);
		detModalidadesTramite.setCatDocumentoBeneficio(null);

		return detModalidadesTramite;
	}

	//bi-directional many-to-one association to DetFormato
	@OneToMany(mappedBy="catDocumentoBeneficio")
	public List<DetFormatoHist> getDetFormatosHist() {
		return detFormatosHist;
	}

	public void setDetFormatosHist(List<DetFormatoHist> detFormatosHist) {
		this.detFormatosHist = detFormatosHist;
	}

	//bi-directional many-to-one association to DetModalidadesTramite
	@OneToMany(mappedBy="catDocumentoBeneficio")
	public List<DetModalidadesTramiteHist> getDetModalidadesTramitesHist() {
		return detModalidadesTramitesHist;
	}

	public void setDetModalidadesTramitesHist(List<DetModalidadesTramiteHist> detModalidadesTramitesHist) {
		this.detModalidadesTramitesHist = detModalidadesTramitesHist;
	}

}