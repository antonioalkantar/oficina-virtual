package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "det_lo_mas_buscado_contador", schema = "portaltramitescdmx")
@NamedQueries({ @NamedQuery(name = "DetLoMasBuscadoCont.find", query = "SELECT d FROM DetLoMasBuscadoCont d"),

		@NamedQuery(name = "DetLoMasBuscadoCont.findAll", query = "SELECT new mx.gob.cdmx.adip.portaltramites.commons.dto.DetLoMasBuscadoContDTO "
				+ "(" + "t.id " + ", t.idTramiteServicio " + ", t.contadorAccesos" + ", t.situacion" + ")  "
				+ "FROM DetLoMasBuscadoCont t order by t.contadorAccesos DESC")})
@NamedStoredProcedureQuery(
	    name = "spInsertUpdateDetLoMasBuscadoCont",
	    procedureName = "portaltramitescdmx.spInsertUpdateDetLoMasBuscadoCont",
	    parameters = { 
	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "idTramiteServicio"), 
//	        @StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "y"), 
	        @StoredProcedureParameter(mode = ParameterMode.OUT, type = Boolean.class, name = "contadorAccesos")
	    }
	)
public class DetLoMasBuscadoCont implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1474975267949235626L;
	private Long id;
	private Long idTramiteServicio;
	private Integer contadorAccesos;
	private Boolean situacion;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "id_tramite_servicio")
	public Long getIdTramiteServicio() {
		return idTramiteServicio;
	}

	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}

	@Column(name = "contador_accesos")
	public Integer getContadorAccesos() {
		return contadorAccesos;
	}

	public void setContadorAccesos(Integer contadorAccesos) {
		this.contadorAccesos = contadorAccesos;
	}

	@Column(name = "situacion")
	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}

}
