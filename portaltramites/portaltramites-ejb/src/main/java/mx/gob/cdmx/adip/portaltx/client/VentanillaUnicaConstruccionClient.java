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
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;

public class VentanillaUnicaConstruccionClient implements Serializable {

	private static final long serialVersionUID = -8653495859382880541L;
	private static final Logger LOGGER = LoggerFactory.getLogger(VentanillaUnicaConstruccionClient.class);

	public RegistroDTO consultaRegistroVentanillaUnicaConstr(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, VentanillaUnicaConstruccionException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioVentanillaUnicaConstruccion());
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKVentanillaUnicaConstruccionWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setCatEstatusDTO(new CatEstatusDTO(Integer.valueOf(jsonReporte.get("idEstatus").toString()),
						jsonReporte.get("estatus").toString()));
//				registro.setAlcaldiaSolicitud(jsonReporte.get("alcaldiaSolicitud").toString());
//				registro.setAtiende(jsonReporte.get("atiende").toString());
//				registro.setDescripcionSolicitud(jsonReporte.get("descripcionSolicitud").toString());
//				registro.setFolio(jsonReporte.get("folio").toString());

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de PVENTANILLA UNICA DE CONSTRUCCION nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new VentanillaUnicaConstruccionException("msj_datos_incorrectos_ventanilla_unica_construccion");
			} else {
				LOGGER.error("El Webservice de VENTANILLA UNICA DE CONSTRUCCION nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new VentanillaUnicaConstruccionException("msj_no_conexion_ventanilla_unica_construccion");
			}

			LOGGER.debug("Respuesta del servico ventanillauniconstruccion : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del ventanillauniconstruccion", e);
			throw new VentanillaUnicaConstruccionException("msj_no_conexion_ventanilla_unica_construccion");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de ventanillauniconstruccion: ", e);
			throw new VentanillaUnicaConstruccionException("msj_no_conexion_ventanilla_unica_construccion");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del ventanillauniconstruccion: ", ex);
			throw new VentanillaUnicaConstruccionException("msj_no_conexion_ventanilla_unica_construccion");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del ventanillauniconstruccion: ", e);
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
	
	public static class VentanillaUnicaConstruccionException extends Exception {
		
		private static final long serialVersionUID = 5311578107987774128L;

		public VentanillaUnicaConstruccionException(String mensaje) {
			super(mensaje);
		}
	}
}
