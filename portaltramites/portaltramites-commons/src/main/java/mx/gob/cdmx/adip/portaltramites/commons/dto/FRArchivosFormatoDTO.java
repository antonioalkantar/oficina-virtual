package mx.gob.cdmx.adip.portaltramites.commons.dto;

import java.io.Serializable;

public class FRArchivosFormatoDTO implements Serializable {

	private static final long serialVersionUID = 264196451568923819L;
	private DetArchivosFormatoTramiteDTO detArchivosFormatoTramiteDTO;

	public FRArchivosFormatoDTO() {
		detArchivosFormatoTramiteDTO = new DetArchivosFormatoTramiteDTO();
	}

	public DetArchivosFormatoTramiteDTO getDetArchivosFormatoTramiteDTO() {
		return detArchivosFormatoTramiteDTO;
	}

	public void setDetArchivosFormatoTramiteDTO(DetArchivosFormatoTramiteDTO detArchivosFormatoTramiteDTO) {
		this.detArchivosFormatoTramiteDTO = detArchivosFormatoTramiteDTO;
	}

}
