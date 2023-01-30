package mx.gob.cdmx.adip.portaltramites.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Base64;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FileUtils;
import org.omnifaces.cdi.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltramites.dao.DetArchivoFondoDAO;

@Named()
@ViewScoped
public class imageBackgroud implements Serializable {

	private static final long serialVersionUID = -6901535427154486473L;
	private static final Logger LOGGER = LoggerFactory.getLogger(imageBackgroud.class);

	private List<DetArchivoFondoDTO> listadoFondo;
	
	private List<DetArchivoFondoDTO> listadoFondoMobile;

	private String imageBackground;
	
	private String imageBackgroundMobile;

	@Inject
	private DetArchivoFondoDAO detArchivoFondoDAO;

	public imageBackgroud() {
	}

	@PostConstruct
	public void init() {
		listadoFondo = detArchivoFondoDAO.buscarporSituacion();
		listadoFondoMobile = detArchivoFondoDAO.buscarporSituacionMobile();
		
		if (!listadoFondo.isEmpty()) {
			imageBackground = toBase64Img(Environment.getPathImgFondo() + Constantes.RUTA_FONDOS + Constantes.SEPARADOR_RUTA + listadoFondo.get(0).getNombre_archivo());
		}
		if (imageBackground == null || imageBackground.isEmpty()) {
			imageBackground = Constantes.PATH_FONDO_DEFAULT;
		}
		
		
		if (!listadoFondoMobile.isEmpty()) {
			imageBackgroundMobile = toBase64Img(Environment.getPathImgFondo() + Constantes.RUTA_FONDOS + Constantes.SEPARADOR_RUTA + listadoFondoMobile.get(0).getNombre_archivo());
		}
		if (imageBackgroundMobile == null || imageBackgroundMobile.isEmpty()) {
			imageBackgroundMobile = Constantes.PATH_FONDO_MOBILE_DEFAULT;
		}
		
		
	}

	private String toBase64Img(String path) {
		String base = "";
		byte[] fileContent = null;
		try {
			File file = new File(path);
			if (file.exists()) {
				fileContent = FileUtils.readFileToByteArray(file);
				base = Base64.getEncoder().encodeToString(fileContent);
				base = "data:image/jpeg;base64," + base;
			}
		} catch (IOException e) {
			LOGGER.error("No es posible convertir la imagen a base64 " + e.getMessage());
		}
		return base;
	}

	public String getImageBackground() {
		return imageBackground;
	}

	public void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
	}

	public String getImageBackgroundMobile() {
		return imageBackgroundMobile;
	}

	public void setImageBackgroundMobile(String imageBackgroundMobile) {
		this.imageBackgroundMobile = imageBackgroundMobile;
	}	
	
}
