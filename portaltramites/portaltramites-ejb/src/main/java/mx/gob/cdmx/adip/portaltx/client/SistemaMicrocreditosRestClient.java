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
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaMiBecaDTO;

public class SistemaMicrocreditosRestClient implements Serializable {

	private static final long serialVersionUID = -7794216500700288471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SistemaMicrocreditosRestClient.class);

	public TarjetaMiBecaDTO consultaBeneficiario(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, SistemaMicrocreditosException {

		TarjetaMiBecaDTO tarjetaMiBecaDTO = new TarjetaMiBecaDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioMiBeca());
		urlQuery.append("?idSolicitud=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKMiBecaWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta).getJSONObject("beneficiario");
				tarjetaMiBecaDTO.setIdUsuarioCDMX(Long.valueOf(jsonReporte.get("idUsuarioCDMX").toString()));
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programaci??n, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Sistema Microcreditos nos devolvi?? un c??digo: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SistemaMicrocreditosException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de Sistema Microcreditos nos devolvi?? un c??digo de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SistemaMicrocreditosException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico Sistema Microcreditos: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Sistema Microcreditos: ", e);
			throw new SistemaMicrocreditosException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexi??n al servicio web de Sistema Microcreditos: ", e);
			throw new SistemaMicrocreditosException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexi??n con el servicio WEB de Sistema Microcreditos: ", ex);
			throw new SistemaMicrocreditosException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Sistema Microcreditos: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

		return tarjetaMiBecaDTO;
	}

	public static class SistemaMicrocreditosException extends Exception {

		private static final long serialVersionUID = -6671006800218451L;

		public SistemaMicrocreditosException(String mensaje) {
			super(mensaje);
		}
	}

}
