package mx.gob.cdmx.adip.portaltx.dto;

import java.io.Serializable;

public class TarjetaNoAntecedentesDTO implements Serializable {

	private static final long serialVersionUID = 3028803116693015051L;
	
	private String extension;
	private String documento;

	public TarjetaNoAntecedentesDTO() {
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
