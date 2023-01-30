package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;


public class DetRequisitosModalidadDTO implements Serializable {

	private static final long serialVersionUID = -5810943552180476667L;
	private Long id;
	private String articuloLeyReglamento;
	private String detalleRequisito;
	private String otraLey;
	private CatLeyeDTO catLeye;
	private CrcFlujoTramiteDTO crcFlujoTramite;
	private DetModalidadesTramiteDTO detModalidadesTramite;
	private Boolean situacion;
	private Boolean replicaEnModalidades;
	private Boolean esReplicado;

	public DetRequisitosModalidadDTO() {
		catLeye = new CatLeyeDTO();
		crcFlujoTramite = new CrcFlujoTramiteDTO();
		detModalidadesTramite = new DetModalidadesTramiteDTO();
		setEsReplicado(false);
	}
	
	public DetRequisitosModalidadDTO(Long id) {
		super();
		this.id = id;
		setEsReplicado(false);
	}

	public DetRequisitosModalidadDTO(Long id, String articuloLeyReglamento, String detalleRequisito, String otraLey, Boolean situacion,
			Long idLey, String nombreLey, Long idFlujoTramite, Long idModalidadesTramite, Boolean replicaEnModalidades) {
		super();
		this.id = id;
		this.articuloLeyReglamento = articuloLeyReglamento;
		this.detalleRequisito = detalleRequisito;
		this.otraLey = otraLey;
		this.situacion = situacion;
		this.catLeye = new CatLeyeDTO(idLey, nombreLey, null);
		this.crcFlujoTramite = new CrcFlujoTramiteDTO(idFlujoTramite);
		this.detModalidadesTramite = new DetModalidadesTramiteDTO(idModalidadesTramite);
		this.replicaEnModalidades = replicaEnModalidades;
		setEsReplicado(false);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticuloLeyReglamento() {
		return articuloLeyReglamento;
	}

	public void setArticuloLeyReglamento(String articuloLeyReglamento) {
		this.articuloLeyReglamento = articuloLeyReglamento;
	}

	public String getDetalleRequisito() {
		return detalleRequisito;
	}

	public void setDetalleRequisito(String detalleRequisito) {
		this.detalleRequisito = detalleRequisito;
	}

	public String getOtraLey() {
		return otraLey;
	}

	public void setOtraLey(String otraLey) {
		this.otraLey = otraLey;
	}

	public CatLeyeDTO getCatLeye() {
		return catLeye;
	}

	public void setCatLeye(CatLeyeDTO catLeye) {
		this.catLeye = catLeye;
	}

	public CrcFlujoTramiteDTO getCrcFlujoTramite() {
		return crcFlujoTramite;
	}

	public void setCrcFlujoTramite(CrcFlujoTramiteDTO crcFlujoTramite) {
		this.crcFlujoTramite = crcFlujoTramite;
	}

	public DetModalidadesTramiteDTO getDetModalidadesTramite() {
		return detModalidadesTramite;
	}

	public void setDetModalidadesTramite(DetModalidadesTramiteDTO detModalidadesTramite) {
		this.detModalidadesTramite = detModalidadesTramite;
	}

	public Boolean getSituacion() {
		return situacion;
	}

	public void setSituacion(Boolean situacion) {
		this.situacion = situacion;
	}


	public Boolean getReplicaEnModalidades() {
		return replicaEnModalidades;
	}


	public void setReplicaEnModalidades(Boolean replicaEnModalidades) {
		this.replicaEnModalidades = replicaEnModalidades;
	}

	public Boolean getEsReplicado() {
		return esReplicado;
	}

	public void setEsReplicado(Boolean esReplicado) {
		this.esReplicado = esReplicado;
	}

}
