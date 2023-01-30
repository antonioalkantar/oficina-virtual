package mx.gob.cdmx.adip.portaltx.client;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

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
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaLicenciaDTO;

public class JuridicoLaboralRestClient implements Serializable {

	private static final long serialVersionUID = -556146139899400471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(JuridicoLaboralRestClient.class);

	public RegistroDTO consultaRegistroJuridicoLaboral(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, JuridicoLaboralException, ParseException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioLicencia());
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKLicenciaWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setTipoLicencia(jsonReporte.get("idUsuario").toString());
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Juridico Laboral nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new JuridicoLaboralException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de Juridico Laboral nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new JuridicoLaboralException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico Juridico Laboral: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Juridico Laboral: ", e);
			throw new JuridicoLaboralException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Juridico Laboral: ", e);
			throw new JuridicoLaboralException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del Juridico Laboral: ", ex);
			throw new JuridicoLaboralException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Juridico Laboral: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

		return registro;
	}

	public static class JuridicoLaboralException extends Exception {

		private static final long serialVersionUID = -42405056848595671L;

		public JuridicoLaboralException(String mensaje) {
			super(mensaje);
		}
	}

}
