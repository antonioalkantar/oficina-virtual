package mx.gob.cdmx.adip.portaltx.client;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.common.util.JerseyUtil;
import mx.gob.cdmx.adip.portaltramites.commons.utils.Constantes;
import mx.gob.cdmx.adip.portaltx.client.RefrendoTCRestClient.RefrendoTCException;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaRefrendoTarjetaCirculacionDTO;

public class DoctoRefrendoTCRestClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6139478366901062897L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctoRefrendoTCRestClient.class);

	public void consultaDoctoRefrendoTC(TarjetaRefrendoTarjetaCirculacionDTO tarRefrendoTCDTO)
			throws URISyntaxException, ConnectException, JSONException, RefrendoTCException  {

//		TarjetaRefrendoTarjetaCirculacionDTO tarRefrendoTCDTO = new TarjetaRefrendoTarjetaCirculacionDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioDoctoRefrendoTC());
		urlQuery.append("?idFolio=");
		urlQuery.append(tarRefrendoTCDTO.getIdTarjetaCirculacion());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKRefrendoTCWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON)
					.header("Accept", Constantes.CONTENT_TYPE)
					.header("User-agent", Constantes.PARAM_USER_AGENT)
					.post(ClientResponse.class, "{\r\n" + 
							"\"clientID\": \""+Environment.getClientIDRefrendoTC()+"\",\r\n" + 
							"\"idTramite\":"+ tarRefrendoTCDTO.getIdTarjetaCirculacion() + " \r\n" + 
							"}");
						
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {
				JSONObject jsonReporte = new JSONObject(respuesta);
				JSONObject dataJson = new JSONObject(jsonReporte.get("data").toString());
				
				tarRefrendoTCDTO.setDisplayName(dataJson.get("$display-name").toString());
				tarRefrendoTCDTO.setExtension(dataJson.get("$extension").toString());
				tarRefrendoTCDTO.setFullName(dataJson.get("$full-name").toString());
				tarRefrendoTCDTO.setContent(dataJson.get("content").toString());
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de refrendo de tarjeta de circulación nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new RefrendoTCException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de refrendo de tarjeta de circulación nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new RefrendoTCException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico refrendo de tarjeta de circulación : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del refrendo de tarjeta de circulación", e);
			throw new RefrendoTCException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de refrendo de tarjeta de circulación: ", e);
			throw new RefrendoTCException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del refrendo de tarjeta de circulación: ", ex);
			throw new RefrendoTCException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del refrendo de tarjeta de circulación: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

	}

	public static class RefrendoTCException extends Exception {

		private static final long serialVersionUID = -4246678461721944771L;

		public RefrendoTCException(String mensaje) {
			super(mensaje);
		}
	}

}
