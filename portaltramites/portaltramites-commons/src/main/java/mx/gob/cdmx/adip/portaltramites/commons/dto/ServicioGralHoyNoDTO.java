package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class ServicioGralHoyNoDTO implements Serializable{
	

	private static final long serialVersionUID = 3182761698320894676L;
	private ServicioNoCirculaClienteDTO servNoCircDTO;
	private ServicioVerifClienteDTO serviVerifDTO;
	private Integer  codigo;
	
	public ServicioGralHoyNoDTO() {}
	
	public ServicioNoCirculaClienteDTO getServNoCircDTO() {
		return servNoCircDTO;
	}
	public void setServNoCircDTO(ServicioNoCirculaClienteDTO servNoCircDTO) {
		this.servNoCircDTO = servNoCircDTO;
	}
	public ServicioVerifClienteDTO getServiVerifDTO() {
		return serviVerifDTO;
	}
	public void setServiVerifDTO(ServicioVerifClienteDTO serviVerifDTO) {
		this.serviVerifDTO = serviVerifDTO;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
}

