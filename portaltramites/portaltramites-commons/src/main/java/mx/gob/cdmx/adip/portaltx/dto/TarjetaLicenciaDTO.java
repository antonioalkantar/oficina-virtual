package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaLicenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String documento;
	private String extension;
	
	public TarjetaLicenciaDTO() {
		
	}

	public TarjetaLicenciaDTO(String documento, String extension) {
		this.documento = documento;
		this.extension = extension;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
		
}
