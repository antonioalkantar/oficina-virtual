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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaCitasDTO;

public class CitasRestClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1531591781091328609L;
	private static final Logger LOGGER = LoggerFactory.getLogger(CitasRestClient.class);

	public TarjetaCitasDTO consultaRegistroCitas(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, CitasException {

		TarjetaCitasDTO tarCitasDTO = new TarjetaCitasDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioCitas());
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKCitasWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {
				JSONObject jsonReporte = new JSONObject(respuesta);
				tarCitasDTO.setFolio(jsonReporte.get("folio").toString());
				tarCitasDTO.setIdDependencia(jsonReporte.get("idDependencia").toString());
				tarCitasDTO.setAbreviaturaDependencia(jsonReporte.get("abreviaturaDependencia").toString());
				tarCitasDTO.setNombreDependencia(jsonReporte.get("nombreDependencia").toString());
				tarCitasDTO.setNombreTramite(jsonReporte.get("nombreTramite").toString());
				tarCitasDTO.setDescripcionTramite(jsonReporte.get("descripcionTramite").toString());
				tarCitasDTO.setDomicilioCompleto(jsonReporte.get("domicilioCompleto").toString());
				tarCitasDTO.setIdEstatusCita(jsonReporte.get("idEstatusCita").toString());
				tarCitasDTO.setEstatusCitaDesc(jsonReporte.get("estatusCitaDesc").toString());
				tarCitasDTO.setFechaHoraInicioDisponible(jsonReporte.get("fechaHoraInicioDisponible").toString());
				tarCitasDTO.setFechaHoraCita(jsonReporte.get("fechaHoraCita").toString());
				tarCitasDTO.setIdDetalleCitaUsuarioLlavecdmx(
						Long.valueOf(jsonReporte.get("idDetalleCitaUsuarioLlavecdmx").toString()));
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de citas nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new CitasException("msj_datos_incorrectos_suac");
			} else {
				LOGGER.error("El Webservice de citas nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new CitasException("msj_no_conexion_suac");
			}

			LOGGER.debug("Respuesta del servico citas : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del citas", e);
			throw new CitasException("msj_no_conexion_suac");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de citas: ", e);
			throw new CitasException("msj_no_conexion_suac");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del citas: ", ex);
			throw new CitasException("msj_no_conexion_suac");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del citas: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

		return tarCitasDTO;
	}

	public static class CitasException extends Exception {

		private static final long serialVersionUID = -4246678461721944771L;

		public CitasException(String mensaje) {
			super(mensaje);
		}
	}

}
