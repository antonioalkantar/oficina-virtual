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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaPermisoResidentesDTO;

public class PermisosResidentesRestClient implements Serializable {

	private static final long serialVersionUID = -654220024988739471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PermisosResidentesRestClient.class);

	public void consultaRegistroPermisoResidente(TarjetaPermisoResidentesDTO registro)
			throws URISyntaxException, ConnectException, JSONException, PermisosResidentesException {
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioPermisoParaResidentes());
		urlQuery.append("?idRegistro=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKPermisoResidentesWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setFolio(jsonReporte.get("folioTramite").toString());
				registro.setTipoTramite(jsonReporte.get("tipoTramite").toString());
				registro.setPlaca(!"null".equalsIgnoreCase(jsonReporte.get("placa").toString())
						? jsonReporte.get("placa").toString()
						: null);
				registro.setPoligonoAutorizado(
						!"null".equalsIgnoreCase(jsonReporte.get("poligonoAutorizado").toString())
								? jsonReporte.get("poligonoAutorizado").toString()
								: null);
				registro.setFechaVigencia(!"null".equalsIgnoreCase(jsonReporte.get("fechaVigencia").toString())
						? jsonReporte.get("fechaVigencia").toString()
						: null);
				
				registro.setIdEstatus(Integer.valueOf(jsonReporte.get("idEstatusPermiso").toString()));
				registro.setEstatusDictaminador(jsonReporte.get("estatusDictaminador").toString());
				registro.setDocumentoDisponible(
						!"null".equalsIgnoreCase(jsonReporte.get("documentoDisponible").toString())
								? Boolean.parseBoolean(jsonReporte.get("documentoDisponible").toString())
								: null);

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Plataforma para Permisos para Residentes nos devolvió un código: "
						+ response.getStatus() + " Esta fue la respuesta obtenida: " + respuesta);
				throw new PermisosResidentesException("msj_datos_incorrectos_ppr");
			} else {
				LOGGER.error(
						"El Webservice de Ventanilla de Plataforma para Permisos para Residentesr nos devolvió un código de error: "
								+ response.getStatus() + " Esta fue la respuesta obtenida: " + respuesta);
				throw new PermisosResidentesException("msj_no_conexion_ppr");
			}

			LOGGER.debug("Respuesta del servico Ventanilla de Plataforma para Permisos para Residentes: " + respuesta
					+ " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Ventanilla de Plataforma para Permisos para Residentes: ", e);
			throw new PermisosResidentesException("msj_no_conexion_ppr");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(
					"No se pudo establecer la conexión al servicio web de Plataforma para Permisos para Residentes: ",
					e);
			throw new PermisosResidentesException("msj_no_conexion_ppr");
		} catch (ClientHandlerException ex) {
			LOGGER.error(
					"Error al realizar la conexión con el servicio WEB de Plataforma para Permisos para Residentes: ",
					ex);
			throw new PermisosResidentesException("msj_no_conexion_ppr");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Ventanilla de Plataforma para Permisos para Residentes: ", e);
			throw new PermisosResidentesException("msj_datos_incorrectos_ppr");
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

	public void consultaDocumentoPermisoResidentes(TarjetaPermisoResidentesDTO registro)
			throws URISyntaxException, ConnectException, JSONException, PermisosResidentesException {
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlDocServicioPermisoParaResidentes());
		urlQuery.append("?idRegistro=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKPermisoResidentesWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setDocumento(jsonReporte.get("documento").toString());

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Plataforma para Permisos para Residentes nos devolvió un código: "
						+ response.getStatus() + " Esta fue la respuesta obtenida: " + respuesta);
				throw new PermisosResidentesException("msj_datos_incorrectos_ppr");
			} else {
				LOGGER.error(
						"El Webservice de Ventanilla de Plataforma para Permisos para Residentesr nos devolvió un código de error: "
								+ response.getStatus() + " Esta fue la respuesta obtenida: " + respuesta);
				throw new PermisosResidentesException("msj_no_conexion_ppr");
			}

			LOGGER.debug("Respuesta del servico Ventanilla de Plataforma para Permisos para Residentes: " + respuesta
					+ " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Ventanilla de Plataforma para Permisos para Residentes: ", e);
			throw new PermisosResidentesException("msj_no_conexion_ppr");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(
					"No se pudo establecer la conexión al servicio web de Plataforma para Permisos para Residentes: ",
					e);
			throw new PermisosResidentesException("msj_no_conexion_ppr");
		} catch (ClientHandlerException ex) {
			LOGGER.error(
					"Error al realizar la conexión con el servicio WEB de Plataforma para Permisos para Residentes: ",
					ex);
			throw new PermisosResidentesException("msj_no_conexion_ppr");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Ventanilla de Plataforma para Permisos para Residentes: ", e);
			throw new PermisosResidentesException("msj_datos_incorrectos_ppr");
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

	public static class PermisosResidentesException extends Exception {

		private static final long serialVersionUID = -42405056848595671L;

		public PermisosResidentesException(String mensaje) {
			super(mensaje);
		}
	}

}
