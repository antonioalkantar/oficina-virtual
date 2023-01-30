package mx.gob.cdmx.adip.portaltramites.widget.client;

import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.common.util.JerseyUtil;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO;

public class NotificacionesRestClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificacionesRestClient.class);

	public DetEncabezadoDTO obtenerNotificaciones() throws URISyntaxException, ConnectException, JSONException {
		DetEncabezadoDTO detEncabezadoDTO = new DetEncabezadoDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioNotificaciones());

		URI uri = null;
		String respuesta = null;
		try {
			uri = new URI(urlQuery.toString());
		} catch (URISyntaxException e) {
			LOGGER.error("Error en la sintaxis de la url: ", e);
			throw new URISyntaxException("", "La sintaxis de la url no es correcta.");
		}

		WebResource webResource = null;
		try {
			webResource = JerseyUtil.getInstance().getClient().resource(uri.toString());
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Notificaciones: ", e);
		}
		ClientResponse response;
		try {
			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);
			LOGGER.debug("Respuesta del servico de notificaicones: " + respuesta + " " + response.getStatus());
		} catch (com.sun.jersey.api.client.ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio de notificaciones::", ex);
			throw new ConnectException("No fue posible realizar la conexión con el servicio web de notificaciones");
		}
		if (response.getStatus() == 200) {
			JSONObject jsonNotificacion = null;
			try {
				jsonNotificacion = new JSONObject(respuesta);
				detEncabezadoDTO.setSituacion(Boolean.parseBoolean(jsonNotificacion.get("activo").toString()));
				detEncabezadoDTO.setBackground(jsonNotificacion.get("background-color").toString());
				detEncabezadoDTO.setDescripcion_encabezado(jsonNotificacion.get("mensaje").toString());
				detEncabezadoDTO.setLink_encabezado(jsonNotificacion.get("href").toString());
			} catch (Exception e) {
				LOGGER.error("Respuesta:" + respuesta);
//			LOGGER.error("Error al realizar la conexión con el servicio de notificaciones::" , e);
				detEncabezadoDTO.setSituacion(false);
				detEncabezadoDTO.setDescripcion_encabezado("");
				detEncabezadoDTO.setBackground("");
			}
		} else {
			LOGGER.error("NotificacionesRestClient Status: " + response.getStatus());
			detEncabezadoDTO = new DetEncabezadoDTO();
			detEncabezadoDTO.setSituacion(false);
			detEncabezadoDTO.setDescripcion_encabezado("");
			detEncabezadoDTO.setBackground("");

		}
		return detEncabezadoDTO;
	}
}
