package mx.gob.cdmx.adip.portaltramites.dto;

import java.io.Serializable;

public class ModalidadesTramiteServicioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2981059121904079837L;
	private Long idModalidad;
	private String nombreModalidad;
	private String doctoBeneficioModalidad;
	private String otroDoctoBeneficioModalidad;
	private String vigenciaModalidad;
	private String tipoFictaModalidad;
	private Long idFundamentoCostos;
	private String descFundamentoCostos;
	private String articuloLeyReglamentoCostos;
	private Long idUnidadVigencia;
	private String descripcionUnidadVigencia;
	private Integer cantVig;
	private String especificaOtraVig;
	private boolean replicaMedianteFormato;
	private boolean medianteFormato;

	public ModalidadesTramiteServicioDTO() {
	}
	
	public ModalidadesTramiteServicioDTO(Long idModalidad, String nombreModalidad, String doctoBeneficioModalidad,
			String otroDoctoBeneficioModalidad, String vigenciaModalidad,
			String tipoFictaModalidad, Long idFundamentoCostos, String descFundamentoCostos,String articuloLeyReglamentoCostos) {
		this.idModalidad = idModalidad;
		this.nombreModalidad = nombreModalidad;
		this.doctoBeneficioModalidad = doctoBeneficioModalidad;
		this.otroDoctoBeneficioModalidad = otroDoctoBeneficioModalidad;
		this.vigenciaModalidad = vigenciaModalidad;
		this.tipoFictaModalidad = tipoFictaModalidad;
		this.idFundamentoCostos = idFundamentoCostos;
		this.descFundamentoCostos = descFundamentoCostos;
		this.articuloLeyReglamentoCostos = articuloLeyReglamentoCostos;
	}
	
	public ModalidadesTramiteServicioDTO(Long idModalidad, String nombreModalidad, String doctoBeneficioModalidad,
			String otroDoctoBeneficioModalidad, Long idCatVig, String vigenciaModalidad,
			String tipoFictaModalidad, Long idFundamentoCostos, String descFundamentoCostos,String articuloLeyReglamentoCostos, Long idUnidadVigencia, String descripcionUnidadVigencia,
			Integer cantVig , String especificaOtraVig, Integer vigSuperior, Boolean replicaMedianteFormato, Boolean medianteFormato) {
		this.idModalidad = idModalidad;
		this.nombreModalidad = nombreModalidad;
		this.doctoBeneficioModalidad = doctoBeneficioModalidad.equals("Otro") ? otroDoctoBeneficioModalidad : doctoBeneficioModalidad;
		this.otroDoctoBeneficioModalidad = otroDoctoBeneficioModalidad;
		this.vigenciaModalidad = idCatVig.compareTo(3L) == 0 ? "De " + cantVig.toString() + " a " + vigSuperior.toString() + " " + descripcionUnidadVigencia : cantVig!= null ? cantVig.toString() + " " + descripcionUnidadVigencia : vigenciaModalidad.equals("Otro") ? especificaOtraVig :  vigenciaModalidad ;
		this.tipoFictaModalidad = tipoFictaModalidad;
		this.idFundamentoCostos = idFundamentoCostos;
		this.descFundamentoCostos = descFundamentoCostos;
		this.articuloLeyReglamentoCostos = articuloLeyReglamentoCostos;
		this.cantVig = cantVig;
		this.especificaOtraVig = especificaOtraVig;
		this.replicaMedianteFormato = replicaMedianteFormato != null ? replicaMedianteFormato : false;
		this.medianteFormato = medianteFormato != null ? medianteFormato : false;
	}

	public Long getIdModalidad() {
		return idModalidad;
	}

	public String getNombreModalidad() {
		return nombreModalidad;
	}

	public String getDoctoBeneficioModalidad() {
		return doctoBeneficioModalidad;
	}

	public String getOtroDoctoBeneficioModalidad() {
		return otroDoctoBeneficioModalidad;
	}

	public String getVigenciaModalidad() {
		return vigenciaModalidad;
	}

	public String getTipoFictaModalidad() {
		return tipoFictaModalidad;
	}

	public void setIdModalidad(Long idModalidad) {
		this.idModalidad = idModalidad;
	}

	public void setNombreModalidad(String nombreModalidad) {
		this.nombreModalidad = nombreModalidad;
	}

	public void setDoctoBeneficioModalidad(String doctoBeneficioModalidad) {
		this.doctoBeneficioModalidad = doctoBeneficioModalidad;
	}

	public void setOtroDoctoBeneficioModalidad(String otroDoctoBeneficioModalidad) {
		this.otroDoctoBeneficioModalidad = otroDoctoBeneficioModalidad;
	}

	public void setVigenciaModalidad(String vigenciaModalidad) {
		this.vigenciaModalidad = vigenciaModalidad;
	}

	public void setTipoFictaModalidad(String tipoFictaModalidad) {
		this.tipoFictaModalidad = tipoFictaModalidad;
	}

	public Long getIdFundamentoCostos() {
		return idFundamentoCostos;
	}

	public void setIdFundamentoCostos(Long idFundamentoCostos) {
		this.idFundamentoCostos = idFundamentoCostos;
	}

	public String getDescFundamentoCostos() {
		return descFundamentoCostos;
	}

	public void setDescFundamentoCostos(String descFundamentoCostos) {
		this.descFundamentoCostos = descFundamentoCostos;
	}

	public String getArticuloLeyReglamentoCostos() {
		return articuloLeyReglamentoCostos;
	}

	public void setArticuloLeyReglamentoCostos(String articuloLeyReglamentoCostos) {
		this.articuloLeyReglamentoCostos = articuloLeyReglamentoCostos;
	}

	public Long getIdUnidadVigencia() {
		return idUnidadVigencia;
	}

	public void setIdUnidadVigencia(Long idUnidadVigencia) {
		this.idUnidadVigencia = idUnidadVigencia;
	}

	public String getDescripcionUnidadVigencia() {
		return descripcionUnidadVigencia;
	}

	public void setDescripcionUnidadVigencia(String descripcionUnidadVigencia) {
		this.descripcionUnidadVigencia = descripcionUnidadVigencia;
	}

	public Integer getCantVig() {
		return cantVig;
	}

	public void setCantVig(Integer cantVig) {
		this.cantVig = cantVig;
	}

	public String getEspecificaOtraVig() {
		return especificaOtraVig;
	}

	public void setEspecificaOtraVig(String especificaOtraVig) {
		this.especificaOtraVig = especificaOtraVig;
	}

	public boolean isReplicaMedianteFormato() {
		return replicaMedianteFormato;
	}

	public void setReplicaMedianteFormato(boolean replicaMedianteFormato) {
		this.replicaMedianteFormato = replicaMedianteFormato;
	}

	/**
	 * @return the medianteFormato
	 */
	public boolean isMedianteFormato() {
		return medianteFormato;
	}

	/**
	 * @param medianteFormato the medianteFormato to set
	 */
	public void setMedianteFormato(boolean medianteFormato) {
		this.medianteFormato = medianteFormato;
	}
	
	
	
}
