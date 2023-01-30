package mx.gob.cdmx.adip.portaltramites.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bit_tramites_vistos", schema = "portaltramitescdmx")
public class BitTramitesVistos implements Serializable{

	private static final long serialVersionUID = 3182761698320894676L;
	
	private Long idBitacoraTramiteVisto;
	private Long idTramiteServicio;
	private String tituloTramite;
	private CatOrigenConsulta catOrigenConsulta;
	private Date fechaConsulta;
	
	public BitTramitesVistos() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bitacora_tramite_visto")
	public Long getIdBitacoraTramiteVisto() {
		return idBitacoraTramiteVisto;
	}

	public void setIdBitacoraTramiteVisto(Long idBitacoraTramiteVisto) {
		this.idBitacoraTramiteVisto = idBitacoraTramiteVisto;
	}

	@Column(name="id_tramite_servicio")
	public Long getIdTramiteServicio() {
		return idTramiteServicio;
	}

	public void setIdTramiteServicio(Long idTramiteServicio) {
		this.idTramiteServicio = idTramiteServicio;
	}

	@Column(name="titulo_tramite")
	public String getTituloTramite() {
		return tituloTramite;
	}

	public void setTituloTramite(String tituloTramite) {
		this.tituloTramite = tituloTramite;
	}

	@ManyToOne
	@JoinColumn(name="id_origen_consulta")
	public CatOrigenConsulta getCatOrigenConsulta() {
		return catOrigenConsulta;
	}

	public void setCatOrigenConsulta(CatOrigenConsulta catOrigenConsulta) {
		this.catOrigenConsulta = catOrigenConsulta;
	}

	@Column(name="fecha_consulta")
	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
}
