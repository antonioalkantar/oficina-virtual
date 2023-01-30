package mx.gob.cdmx.adip.portaltramites.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;

@Named
@ViewScoped
public class AdministradorBean implements Serializable {

	private static final long serialVersionUID = -2214486958516949868L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AdministradorBean.class);
	
	private boolean menuEncabezado;
	private boolean menuEnlaces;
	private boolean menuSemaforo;
	private boolean menuTag;
	private boolean menuAnuncios;
	private boolean menuContenidoManual;	
	private boolean menuImagenFondo;
	private String vista;
	
	@PostConstruct
	public void iniciarAdministrador() {
		LOGGER.info("Inicio como Admin");
		actualizaSeccion(1);
	}
	
	public String init() {		
		return Constantes.RETURN_ADMIN_TAGS + Constantes.JSF_REDIRECT;
	}
	
	public String initAnuncios(){
		return Constantes.RETURN_ADMIN_ANUNCIOS + Constantes.JSF_REDIRECT;
	}
	
	public String initContenido() {
		return Constantes.RETURN_ADMIN_CONTENIDO_MANUAL + Constantes.JSF_REDIRECT;		
	}
	
	public void actualizaSeccion(int seccion) {
		switch (seccion) {
		case Constantes.MENU_ENCABEZADO:
			menuEncabezado = true;
			menuEnlaces = false;
			menuSemaforo = false;
			menuTag = false;
			menuAnuncios = false;
			menuContenidoManual = false;
			menuImagenFondo = false;
			vista = Constantes.RETURN_ADMIN_ENCABEZADO;
			break;
		case Constantes.MENU_ENLACES:
			menuEncabezado = false;
			menuEnlaces = true;
			menuSemaforo = false;
			menuTag = false;
			menuAnuncios = false;
			menuContenidoManual = false;
			menuImagenFondo = false;
			vista = Constantes.RETURN_ADMIN_ENLACES;
			break;
		case Constantes.MENU_SEMAFORO:
			menuEncabezado = false;
			menuEnlaces = false;
			menuSemaforo = true;
			menuTag = false;
			menuAnuncios = false;
			menuContenidoManual = false;
			menuImagenFondo = false;
			vista = Constantes.RETURN_ADMIN_SEMAFORO;
			break;		
		case Constantes.MENU_TAGS:
			menuEncabezado = false;
			menuEnlaces = false;
			menuSemaforo = false;
			menuTag = true;
			menuAnuncios = false;
			menuContenidoManual = false;
			menuImagenFondo = false;
			vista = Constantes.RETURN_ADMIN_TAGS;
			break;
		case Constantes.MENU_ANUNCIOS:
			menuEncabezado = false;
			menuEnlaces = false;
			menuSemaforo = false;
			menuTag = false;
			menuAnuncios = true;
			menuContenidoManual = false;
			menuImagenFondo = false;
			vista = Constantes.RETURN_ADMIN_ANUNCIOS;
			break;
		case Constantes.MENU_CONTENIDO:
			menuEncabezado = false;
			menuEnlaces = false;
			menuSemaforo = false;
			menuTag = false;
			menuAnuncios = false;
			menuContenidoManual = true;
			menuImagenFondo = false;
			vista = Constantes.RETURN_ADMIN_CONTENIDO_MANUAL;
			break;
		case Constantes.MENU_IMG_FONDO:
			menuEncabezado = false;
			menuEnlaces = false;
			menuSemaforo = false;
			menuTag = false;
			menuAnuncios = false;
			menuContenidoManual = false;
			menuImagenFondo = true;
			vista = Constantes.RETURN_ADMIN_IMG_FONDO;
			break;
		}
	}

	public boolean isMenuTag() {
		return menuTag;
	}

	public void setMenuTag(boolean menuTag) {
		this.menuTag = menuTag;
	}

	public boolean isMenuAnuncios() {
		return menuAnuncios;
	}

	public void setMenuAnuncios(boolean menuAnuncios) {
		this.menuAnuncios = menuAnuncios;
	}

	public boolean isMenuContenidoManual() {
		return menuContenidoManual;
	}

	public void setMenuContenidoManual(boolean menuContenidoManual) {
		this.menuContenidoManual = menuContenidoManual;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public boolean isMenuEncabezado() {
		return menuEncabezado;
	}

	public void setMenuEncabezado(boolean menuEncabezado) {
		this.menuEncabezado = menuEncabezado;
	}

	public boolean isMenuEnlaces() {
		return menuEnlaces;
	}

	public void setMenuEnlaces(boolean menuEnlaces) {
		this.menuEnlaces = menuEnlaces;
	}

	public boolean isMenuSemaforo() {
		return menuSemaforo;
	}

	public void setMenuSemaforo(boolean menuSemaforo) {
		this.menuSemaforo = menuSemaforo;
	}

	public boolean isMenuImagenFondo() {
		return menuImagenFondo;
	}

	public void setMenuImagenFondo(boolean menuImagenFondo) {
		this.menuImagenFondo = menuImagenFondo;
	}
	
}
