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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaVentanillaControlVehicularDTO;

public class ControlVehicularRestClient implements Serializable {

	private static final long serialVersionUID = -4346635007898739471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ControlVehicularRestClient.class);

	public TarjetaVentanillaControlVehicularDTO consultaBeneficiario(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, ControlVehicularException {

		TarjetaVentanillaControlVehicularDTO tarjetaVentanillaControlVehicularDTO = new TarjetaVentanillaControlVehicularDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioVentanillaControlVehicular());
		urlQuery.append("?idSolicitud=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKVentanillaControlVehicularWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta).getJSONObject("tarjetaVentanillaControlVehicular");
				// TODO EL SIGUIENTE LLENADO SOLO ES DE EJEMPLO, SE DEBE CORROBORAR EL FORMATO DEL OBJETO DE RESPUESTA.
				tarjetaVentanillaControlVehicularDTO.setEstatusTramite(jsonReporte.get("estatusTramite").toString());
				tarjetaVentanillaControlVehicularDTO.setFolioTramite(jsonReporte.get("folioTramite").toString());
				tarjetaVentanillaControlVehicularDTO.setModelo(jsonReporte.get("modelo").toString());
				tarjetaVentanillaControlVehicularDTO.setPlacaAnterior(jsonReporte.get("placaAnterior").toString());
				tarjetaVentanillaControlVehicularDTO.setTipo(jsonReporte.get("tipo").toString());
			
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Ventanilla de Control Vehicular nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new ControlVehicularException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de Ventanilla de Control Vehicular nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new ControlVehicularException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico Ventanilla de Control Vehicular: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Ventanilla de Control Vehicular: ", e);
			throw new ControlVehicularException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Ventanilla de Control Vehicular: ", e);
			throw new ControlVehicularException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB de Ventanilla de Control Vehicular: ", ex);
			throw new ControlVehicularException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Ventanilla de Control Vehicular: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

		return tarjetaVentanillaControlVehicularDTO;
	}

	public static class ControlVehicularException extends Exception {

		private static final long serialVersionUID = -42405056848595671L;

		public ControlVehicularException(String mensaje) {
			super(mensaje);
		}
	}

}
