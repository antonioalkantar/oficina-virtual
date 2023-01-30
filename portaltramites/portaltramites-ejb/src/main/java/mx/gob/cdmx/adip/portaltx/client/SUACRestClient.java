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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaSuacDTO;

public class SUACRestClient implements Serializable {

	private static final long serialVersionUID = -4340384324988739471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SUACRestClient.class);

	public void consultaRegistroSUAC(TarjetaSuacDTO registro)
			throws URISyntaxException, ConnectException, JSONException, SUACException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioSuac());
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKSUACWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setIdEstatus(Integer.valueOf(jsonReporte.get("idEstatus").toString()));
				registro.setEstatus(jsonReporte.get("estatus").toString());
				registro.setAlcaldiaSolicitud(jsonReporte.get("alcaldiaSolicitud").toString());
				registro.setAtiende(jsonReporte.get("atiende").toString());
				registro.setDescripcionSolicitud(jsonReporte.get("descripcionSolicitud").toString());
				registro.setFolio(jsonReporte.get("folio").toString());

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de SUAC nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SUACException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de SUAC nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SUACException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico SUAC : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del SUAC", e);
			throw new SUACException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de SUAC: ", e);
			throw new SUACException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del SUAC: ", ex);
			throw new SUACException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del SUAC: ", e);
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

	public static class SUACException extends Exception {

		private static final long serialVersionUID = -4246678461721944771L;

		public SUACException(String mensaje) {
			super(mensaje);
		}
	}

}
