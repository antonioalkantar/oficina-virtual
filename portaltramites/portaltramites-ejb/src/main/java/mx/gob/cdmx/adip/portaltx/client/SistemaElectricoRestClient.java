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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaSistemaElectricoDTO;

public class SistemaElectricoRestClient implements Serializable {

	private static final long serialVersionUID = 3900501353485702198L;

	private static final Logger LOGGER = LoggerFactory.getLogger(SistemaElectricoRestClient.class);

	public void consultaRegistroSistemaElectrico(TarjetaSistemaElectricoDTO registro)
			throws URISyntaxException, ConnectException, JSONException, SistemaElectricoException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioSistemaElectrico());
		urlQuery.append("?idTramite=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKSistemaElectricoWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setFolioTramite(jsonReporte.get("folioTramite").toString());
				registro.setIdTipoTramite(Integer.valueOf(jsonReporte.get("idTipoTramite").toString()));
				registro.setTipoTramite(jsonReporte.get("tipoTramite").toString());
				registro.setIdTipoImpacto(Integer.valueOf(jsonReporte.get("idTipoImpacto").toString()));
				registro.setTipoImpacto(jsonReporte.get("tipoImpacto").toString());

				registro.setNombreEstablecimiento(jsonReporte.get("nombreEstablecimiento").toString());
				registro.setClaveEstablecimiento(jsonReporte.get("claveEstablecimiento").toString());
				registro.setFechaRegistro(jsonReporte.get("fechaRegistro").toString());
				registro.setIdEstatusTramite(Integer.valueOf(jsonReporte.get("idEstatusTramite").toString()));
				registro.setEstatusTramite(jsonReporte.get("estatusTramite").toString());

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Sistema Electrico nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new SistemaElectricoException("msj_datos_incorrectos_sistema_electrico");
			} else {
				LOGGER.error("El Webservice de Sistema Electrico nos devolvió un código de error: "
						+ response.getStatus() + " Esta fue la respuesta obtenida: " + respuesta);
				throw new SistemaElectricoException("msj_no_conexion_sistema_electrico");
			}

			LOGGER.debug("Respuesta del servico Sistema Eléctrico : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del Sistema Electrico", e);
			throw new SistemaElectricoException("msj_no_conexion_sistema_electrico");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Sistema Electrico: ", e);
			throw new SistemaElectricoException("msj_no_conexion_sistema_electrico");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del Sistema Electrico: ", ex);
			throw new SistemaElectricoException("msj_no_conexion_sistema_electrico");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Sistema Eléctrico: ", e);
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

	public static class SistemaElectricoException extends Exception {

		private static final long serialVersionUID = -4246678461721944773L;

		public SistemaElectricoException(String mensaje) {
			super(mensaje);
		}
	}

}
