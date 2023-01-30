package mx.gob.cdmx.adip.portaltx.client;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

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
import mx.gob.cdmx.adip.portaltx.dto.TarjetaLicenciaDTO;

public class LicenciaRestClient implements Serializable {

	private static final long serialVersionUID = -4340384004787459471L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LicenciaRestClient.class);

	public RegistroDTO consultaRegistroLicencia(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, LicenciaException, ParseException {

		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioLicencia());
		urlQuery.append("?idSolicitud=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKLicenciaWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				if (jsonReporte.toString().contains("No se encontraron resultados.")) {
					
				}else {
					registro.setTipoLicencia(jsonReporte.get("tipoLicencia").toString());
					registro.setNumeroLicencia(jsonReporte.get("numeroLicencia").toString());
					registro.setFechaNuevaVigencia(jsonReporte.get("fechaNuevaVigencia").toString());
					registro.setEstatusTramite(jsonReporte.get("estatusTramite").toString());
					registro.setCatEstatusDTO(new CatEstatusDTO(Integer.parseInt(jsonReporte.get("idEstatusTramite").toString()),jsonReporte.get("estatusTramite").toString())); 
				}
				
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Licencia nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new LicenciaException("msj_datos_incorrectos_licencia");
			} else {
				LOGGER.error("El Webservice de Licencia nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new LicenciaException("msj_no_conexion_licencia");
			}

			LOGGER.debug("Respuesta del servico Licencia: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Licencia: ", e);
			throw new LicenciaException("msj_no_conexion_licencia");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Licencia: ", e);
			throw new LicenciaException("msj_no_conexion_licencia");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del Licencia: ", ex);
			throw new LicenciaException("msj_no_conexion_licencia");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Licencia: ", e);
			throw new LicenciaException("msj_no_conexion_licencia");
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
	
	public TarjetaLicenciaDTO consultaDocumentoRegistroLicencia(RegistroDTO registro)
			throws URISyntaxException, ConnectException, JSONException, LicenciaException, ParseException {

		TarjetaLicenciaDTO tarjetaLicenciaDTO = new TarjetaLicenciaDTO(); 
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioDocLicencia());
		urlQuery.append("?idSolicitud=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKLicenciaWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				tarjetaLicenciaDTO.setDocumento(jsonReporte.get("documento").toString());
				tarjetaLicenciaDTO.setExtension(jsonReporte.get("extension").toString());
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Licencia nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new LicenciaException("msj_datos_incorrectos_licencia");
			} else {
				LOGGER.error("El Webservice de Licencia nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new LicenciaException("msj_no_conexion_licencia");
			}

			LOGGER.debug("Respuesta del servico Licencia: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de Licencia: ", e);
			throw new LicenciaException("msj_no_conexion_licencia");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Licencia: ", e);
			throw new LicenciaException("msj_no_conexion_licencia");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del Licencia: ", ex);
			throw new LicenciaException("msj_no_conexion_licencia");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de Licencia: ", e);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					LOGGER.warn("No es posible cerrar el objeto response", e);
				}
			}
		}

		return tarjetaLicenciaDTO;
	}

	public static class LicenciaException extends Exception {

		private static final long serialVersionUID = -42405056848595671L;

		public LicenciaException(String mensaje) {
			super(mensaje);
		}
	}
	
	public static void main(String[] args) {
		LicenciaRestClient client = new LicenciaRestClient();
		RegistroDTO registro = new RegistroDTO();
		registro.setIdRegistroOrigen("3");
		
		try {
		registro=	client.consultaRegistroLicencia(registro);
		System.out.println(registro.getNumeroLicencia()); 
		System.out.println(registro.getEstatusTramite()); 
		} catch (ConnectException | URISyntaxException | JSONException | LicenciaException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
