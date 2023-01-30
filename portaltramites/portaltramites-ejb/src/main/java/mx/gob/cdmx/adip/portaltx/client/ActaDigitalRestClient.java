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
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaActaDigitalDTO;

public class ActaDigitalRestClient implements Serializable {

	private static final long serialVersionUID = 5761974089736978334L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ActaDigitalRestClient.class);

	public void consultaRegistroActa(TarjetaActaDigitalDTO registro)
			throws URISyntaxException, ConnectException, JSONException, ACTASException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioActa());
		urlQuery.append("?idSolicitud=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKActaWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setIdEstatus(Integer.valueOf(jsonReporte.get("idEstatusSolicitud").toString()));
				registro.setEstatus(jsonReporte.get("estatusSolicitud").toString());
				registro.setFolio(jsonReporte.get("folioSolicitud").toString());
				registro.setTipoTramite(jsonReporte.get("tipoActa").toString());
				registro.setNumeroActa(jsonReporte.get("numeroActa").toString());
				registro.setDescargaHabilitada(jsonReporte.get("habilitaDescarga").toString().equals("null") ? null
						: Boolean.valueOf((boolean) jsonReporte.get("habilitaDescarga")));
				registro.setLinkRedirect(jsonReporte.get("linkBandejaSolicitudes").toString());
				registro.setLinkDocumento(jsonReporte.get("linkDocumentoActa").toString());

				if (Integer.valueOf(
						jsonReporte.get("idEstatusSolicitud").toString()) == Constantes.ID_ESTATUS_REGISTRADA_ACTAS
						|| Integer.valueOf(jsonReporte.get("idEstatusSolicitud")
								.toString()) == Constantes.ID_ESTATUS_PENDIENTE_ACTAS) {
					registro.setFechaVencimiento(Constantes.STR_NO_APLICA);
				} else {
					registro.setFechaVencimiento(
							jsonReporte.get("fechaVigenciaDescarga").toString().equals("null") ? null
									: jsonReporte.get("fechaVigenciaDescarga").toString());
				}

				StringBuilder sb = new StringBuilder();
				if (!jsonReporte.get("nombreTitular").toString().equals("null")) {
					sb.append(jsonReporte.get("nombreTitular").toString()).append(" ");
				}
				if (!jsonReporte.get("primerApellidoTitular").toString().equals("null")) {
					sb.append(jsonReporte.get("primerApellidoTitular").toString()).append(" ");
				}
				if (!jsonReporte.get("segundoApellidoTitular").toString().equals("null")) {
					sb.append(jsonReporte.get("segundoApellidoTitular").toString()).append(" ");
				}
				registro.setTitular(sb.toString());
				sb.setLength(0);

				if (!jsonReporte.get("nombreSegundoTitular").toString().equals("null")) {
					sb.append(jsonReporte.get("nombreSegundoTitular").toString()).append(" ");
				}
				if (!jsonReporte.get("primerApellidoSegundoTitular").toString().equals("null")) {
					sb.append(jsonReporte.get("primerApellidoSegundoTitular").toString()).append(" ");
				}
				if (!jsonReporte.get("segundoApellidoSegundoTitular").toString().equals("null")) {
					sb.append(jsonReporte.get("segundoApellidoSegundoTitular").toString()).append(" ");
				}
				registro.setSegundoTitular(sb.toString().isEmpty() ? null : sb.toString());
				sb = null;

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de ACTAS nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new ACTASException("msj_datos_incorrectos_acta_digital");
			} else {
				LOGGER.error("El Webservice de ACTAS nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new ACTASException("msj_no_conexion_acta_digital");
			}

			LOGGER.debug("Respuesta del servico ACTAS : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del ACTAS", e);
			throw new ACTASException("msj_no_conexion_acta_digital");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de ACTAS: ", e);
			throw new ACTASException("msj_no_conexion_acta_digital");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del ACTAS: ", ex);
			throw new ACTASException("msj_no_conexion_acta_digital");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del ACTAS: ", e);
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

	public void consultaDocumentoActaDigital(TarjetaActaDigitalDTO registro)
			throws URISyntaxException, ConnectException, JSONException, ACTASException {

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(registro.getLinkDocumento());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKActaWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonDocumento = new JSONObject(respuesta);
				registro.setNombreDocumento(jsonDocumento.get("nombreDocumento").toString());
				registro.setDocumento(jsonDocumento.get("documentoBase64").toString());

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice para Documento ACTAS nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new ACTASException("msj_datos_incorrectos_acta_digital");
			} else {
				LOGGER.error("El Webservice para Documento ACTAS nos devolvió un código de error: "
						+ response.getStatus() + " Esta fue la respuesta obtenida: " + respuesta);
				throw new ACTASException("msj_no_conexion_acta_digital");
			}

			LOGGER.debug("Respuesta del servico Documento ACTAS : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del Documento ACTAS", e);
			throw new ACTASException("msj_no_conexion_acta_digital");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web del Documento ACTAS: ", e);
			throw new ACTASException("msj_no_conexion_acta_digital");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del Documento ACTAS: ", ex);
			throw new ACTASException("msj_no_conexion_acta_digital");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON del Documento ACTAS: ", e);
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

	public static class ACTASException extends Exception {

		private static final long serialVersionUID = -4246678461721944772L;

		public ACTASException(String mensaje) {
			super(mensaje);
		}
	}
}
