package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class CatAlcaldiaDTO implements Serializable {

	private static final long serialVersionUID = -2427455014879675974L;

	private Integer idAlcaldia;
	private Integer idEstado;
	private Integer idMunicipioPorEstado;
	private String municipio;

	public CatAlcaldiaDTO() {

	}

	public CatAlcaldiaDTO(Integer idAlcaldia, String municipio) {
		this.idAlcaldia = idAlcaldia;
		this.municipio = municipio;
	}

	public CatAlcaldiaDTO(Integer idAlcaldia, Integer idEstado, Integer idMunicipioPorEstado, String municipio) {

		this.idAlcaldia = idAlcaldia;
		this.idEstado = idEstado;
		this.idMunicipioPorEstado = idMunicipioPorEstado;
		this.municipio = municipio;
	}

	public Integer getIdAlcaldia() {
		return idAlcaldia;
	}

	public void setIdAlcaldia(Integer idAlcaldia) {
		this.idAlcaldia = idAlcaldia;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdMunicipioPorEstado() {
		return idMunicipioPorEstado;
	}

	public void setIdMunicipioPorEstado(Integer idMunicipioPorEstado) {
		this.idMunicipioPorEstado = idMunicipioPorEstado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

}
