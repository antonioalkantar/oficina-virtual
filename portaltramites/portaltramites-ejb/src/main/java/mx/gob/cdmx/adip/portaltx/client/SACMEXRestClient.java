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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaDescuentoAguaDTO;

public class SACMEXRestClient implements Serializable {

	private static final long serialVersionUID = -1741908749361181117L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SACMEXRestClient.class);

	public void consultaRegistroSACMEX(TarjetaDescuentoAguaDTO registro)
			throws URISyntaxException, ConnectException, JSONException, SACMEXException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioSacmex());
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKSACMEXWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setIdEstatus(Integer.valueOf(jsonReporte.get("idEstatus").toString()));
				registro.setEstatus(jsonReporte.get("descripcion").toString());
				registro.setNumeroCuentaRecibo(jsonReporte.get("numeroCuentaRecibo").toString());				
				registro.setNuevoRegistro(jsonReporte.get("idTramiteHis").toString() == "null"
						? true : false);
				registro.setFolio(jsonReporte.get("folioTramite").toString());
				
				switch ((int) jsonReporte.get("idEstatus")) {
				case Constantes.ID_ESTATUS_PENDIENTE_SACMEX:
				case Constantes.ID_ESTATUS_RECHAZADO_SACMEX:
				case Constantes.ID_ESTATUS_ENVIADO_SISCOMSE_SACMEX:
					registro.setFechaVencimiento(Constantes.STR_NO_APLICA);
					break;
				case Constantes.ID_ESTATUS_APROBADO_SACMEX:
				case Constantes.ID_ESTATUS_VIGENTE_SACMEX:					
					registro.setFechaVencimiento("31/12"+jsonReporte.get("fechaCreacion").toString().substring(5));
					break;
				case Constantes.ID_ESTATUS_VENCIDO_SACMEX:
					registro.setFechaVencimiento("01/01/"+(Integer.parseInt(jsonReporte.get("fechaCreacion").toString().substring(6))+1));
					break;
				default:
					registro.setFechaVencimiento(jsonReporte.get("fechaVencimiento").toString() == "null" 
					? null : jsonReporte.get("fechaVencimiento").toString() );
					break;
				}				

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de SAXMEX nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SACMEXException("msj_datos_incorrectos_sacmex");
			} else {
				LOGGER.error("El Webservice de SACMEX nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SACMEXException("msj_no_conexion_sacmex");
			}

			LOGGER.debug("Respuesta del servico SACMEX : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del SACMEX", e);
			throw new SACMEXException("msj_no_conexion_sacmex");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de SACMEX: ", e);
			throw new SACMEXException("msj_no_conexion_sacmex");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del SACMEX: ", ex);
			throw new SACMEXException("msj_no_conexion_sacmex");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del SACMEX: ", e);
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

	public static class SACMEXException extends Exception {

		private static final long serialVersionUID = -4246678461721944772L;

		public SACMEXException(String mensaje) {
			super(mensaje);
		}
	}

}
