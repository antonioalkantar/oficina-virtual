package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cat_momento_realiza_pago database table.
 * 
 */
@Entity
@Table(name="cat_momento_realiza_pago", schema = "retys_v2")
//@NamedQueries({
//	@NamedQuery(name="CatMomentoRealizaPago.findAll"
//			, query="SELECT new mx.gob.cdmx.adip.retys.commons.dto.CatMomentoRealizaPagoDTO "
//					+ "("
//					+ "cmrp.id "
//					+ ", cmrp.descripcion "
//					+ ", cmrp.situacion "
//					+ " ) "					
//					+ "FROM CatMomentoRealizaPago cmrp "
//					+ "where cmrp.situacion = true"
//					+ " ORDER BY cmrp.descripcion ASC "
//			)
//})

public class CatMomentoRealizaPago implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Boolean situacion;
	private List<DetCosto> detCostos;

	public CatMomentoRealizaPago() {
	}

	public CatMomentoRealizaPago(Long id) {
		
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


	//bi-directional many-to-one association to DetCosto
	@OneToMany(mappedBy="catMomentoRealizaPago")
	public List<DetCosto> getDetCostos() {
		return this.detCostos;
	}

	public void setDetCostos(List<DetCosto> detCostos) {
		this.detCostos = detCostos;
	}

//	public DetCosto addDetCosto(DetCosto detCosto) {
//		getDetCostos().add(detCosto);
//		detCosto.setCatMomentoRealizaPago(this);
//
//		return detCosto;
//	}
//
//	public DetCosto removeDetCosto(DetCosto detCosto) {
//		getDetCostos().remove(detCosto);
//		detCosto.setCatMomentoRealizaPago(null);
//
//		return detCosto;
//	}

}