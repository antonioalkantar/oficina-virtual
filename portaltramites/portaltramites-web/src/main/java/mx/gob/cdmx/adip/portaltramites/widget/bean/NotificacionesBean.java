package mx.gob.cdmx.adip.portaltramites.widget.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URISyntaxException;

import javax.inject.Named;

import org.codehaus.jettison.json.JSONException;
import org.primefaces.event.CloseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO;
import mx.gob.cdmx.adip.portaltramites.widget.client.NotificacionesRestClient;

@Named("notificacionesBean")
@SessionScoped
public class NotificacionesBean implements Serializable  {

	private static final long serialVersionUID = -2748705305041815037L;
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificacionesBean.class);
	
	private DetEncabezadoDTO detEncabezadoDTO;
	
	private boolean mostrarNotificacion = true;

	public NotificacionesBean() {
	}

	@PostConstruct
    public void init() {
		NotificacionesRestClient notificacionesClient = new NotificacionesRestClient();
		try {
			detEncabezadoDTO = new DetEncabezadoDTO();
			detEncabezadoDTO.setSituacion(false);
			
			detEncabezadoDTO = notificacionesClient.obtenerNotificaciones();
		} catch (ConnectException e) {
			LOGGER.error("No fue posible conectarse al servicio de Notifificaciones:", e);
		} catch (URISyntaxException e) {
			LOGGER.error("La URL del servicio de Notifificaciones es incorrecta, favor de verificar la configuración en el pom.xml:", e);
		} catch (JSONException e) {
			LOGGER.error("El servicio de Notifificaciones respondió con una respuesta ineesperada, favor de verificar:", e);
		}
	}
	
	public void onClose(CloseEvent event) {
		mostrarNotificacion = false;
	}
	
	public DetEncabezadoDTO getDetEncabezadoDTO() {
		return detEncabezadoDTO;
	}

	public boolean isMostrarNotificacion() {
		return mostrarNotificacion;
	}
}
