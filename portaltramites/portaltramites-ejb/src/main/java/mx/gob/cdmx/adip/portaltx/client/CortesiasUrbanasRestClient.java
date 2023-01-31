package mx.gob.cdmx.adip.portaltx.client;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.portaltramites.common.util.JerseyUtil;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaCortesiaUrbanaDTO;

public class CortesiasUrbanasRestClient implements Serializable {

	private static final long serialVersionUID = -665663500700288471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CortesiasUrbanasRestClient.class);

	public TarjetaCortesiaUrbanaDTO consultaBeneficiario(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, CortesiasUrbanasException {

		TarjetaCortesiaUrbanaDTO tarjetaCortesiaUrbanaDTO = new TarjetaCortesiaUrbanaDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioCortesiasUrbanas());
		urlQuery.append("?idSolicitud=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKCortesiasUrbanasWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta).getJSONObject("tarjetaCortesiaUrbana");
				// TODO EL SIGUIENTE LLENADO SOLO ES DE EJEMPLO, SE DEBE CORROBORAR EL FORMATO DEL OBJETO DE RESPUESTA.
				tarjetaCortesiaUrbanaDTO.setEstatusTramite(jsonReporte.get("estatusTramite").toString());
				tarjetaCortesiaUrbanaDTO.setFolioSolicitud(jsonReporte.get("folioSolicitud").toString());
				tarjetaCortesiaUrbanaDTO.setFolioTarjeta(jsonReporte.get("folioTarjeta").toString());
				tarjetaCortesiaUrbanaDTO.setTipoDiscapacidad(jsonReporte.get("tipoDiscapacidad").toString());
				tarjetaCortesiaUrbanaDTO.setVigenteAl(jsonReporte.get("vigenteAl").toString());
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Cortesias Urbanas nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new CortesiasUrbanasException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de Cortesias Urbanas nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new CortesiasUrbanasException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico Cortesias Urbanas: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Cortesias Urbanas: ", e);
			throw new CortesiasUrbanasException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Cortesias Urbanas: ", e);
			throw new CortesiasUrbanasException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB de Cortesias Urbanas: ", ex);
			throw new CortesiasUrbanasException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Cortesias Urbanas: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

		return tarjetaCortesiaUrbanaDTO;
	}

	public static class CortesiasUrbanasException extends Exception {

		private static final long serialVersionUID = -782056800218451L;

		public CortesiasUrbanasException(String mensaje) {
			super(mensaje);
		}
	}

}
