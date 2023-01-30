package mx.gob.cdmx.adip.portaltx.client;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaMiBecaDTO;

public class MiBecaRestClient implements Serializable {

	private static final long serialVersionUID = -4340384324988739471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(MiBecaRestClient.class);

	public TarjetaMiBecaDTO consultaBeneficiario(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, MiBecaException {

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

			LOGGER.info("RESPUESTA: " + respuesta);
			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta).getJSONObject("beneficiario");
				tarjetaMiBecaDTO.setIdUsuarioCDMX(Long.valueOf(jsonReporte.get("idUsuarioCDMX").toString()));
				tarjetaMiBecaDTO.setIdEstatusTutor(Integer.valueOf(jsonReporte.get("idEstatusTutor").toString()));
				tarjetaMiBecaDTO.setDescripcionEstatusTutor(jsonReporte.get("descripcionEstatusTutor").toString());
				tarjetaMiBecaDTO.setIdBeneficiario(Long.valueOf(jsonReporte.get("idBeneficiario").toString()));
				tarjetaMiBecaDTO.setIdEstatus(Integer.valueOf(jsonReporte.get("idEstatus").toString()));
				tarjetaMiBecaDTO.setDescripcionEstatus(jsonReporte.get("descripcionEstatus").toString());
				tarjetaMiBecaDTO.setNombre(jsonReporte.get("nombre").toString());
				tarjetaMiBecaDTO.setPrimerApellido(jsonReporte.get("primerApellido").toString());
				tarjetaMiBecaDTO.setSegundoApellido(jsonReporte.get("segundoApellido").toString());
				SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
			    Date date = formatter.parse(jsonReporte.get("fechaRegistro").toString());
				tarjetaMiBecaDTO.setFechaRegistro(date);
				tarjetaMiBecaDTO.setIdEncuesta(Integer.valueOf(jsonReporte.get("idEncuesta").toString()));
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de MiBeca nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new MiBecaException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de SUAC nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new MiBecaException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico MiBeca: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del MiBeca: ", e);
			throw new MiBecaException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de MiBeca: ", e);
			throw new MiBecaException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del MiBeca: ", ex);
			throw new MiBecaException("msj_no_conexion_suac");
		} catch (ParseException e) {
			throw new MiBecaException("Error al convertir fecha");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de MiBeca: ", e);
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

	public static class MiBecaException extends Exception {

		private static final long serialVersionUID = -4246678461748595671L;

		public MiBecaException(String mensaje) {
			super(mensaje);
		}
	}

}
