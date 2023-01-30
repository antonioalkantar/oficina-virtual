package mx.gob.cdmx.adip.portaltx.client;

import java.io.Serializable;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaLicenciaDTO;
import mx.gob.cdmx.adip.portaltx.dto.TarjetaNoAntecedentesDTO;

public class NoAntecedentesRestClient implements Serializable {

	private static final long serialVersionUID = -851814352362397637L;
	private static final Logger LOGGER = LoggerFactory.getLogger(NoAntecedentesRestClient.class);
	
	public RegistroDTO consultaRegistroNoAntecedentes(RegistroDTO registro) 
			throws URISyntaxException, ConnectException, JSONException, NoAntecedentesException {
		
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append(Environment.getUrlServicioNoAntecedentes());
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKNoAntecedentesWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);		
			
			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				registro.setCatEstatusDTO(new CatEstatusDTO(0,jsonReporte.get("estatusTramite").toString()));
				registro.setFolio(jsonReporte.get("folioTramite").toString());
				try {registro.setFechaRegistro(new SimpleDateFormat("dd/MM/yyyy").parse(jsonReporte.get("fecha").toString()));	} catch (ParseException e) { LOGGER.error("Error al extraer fecha SW NoAntecedentes: ", e);	}
				registro.setTipoTramite(jsonReporte.get("tipoTramite").toString());

			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de No Antecedentes nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new NoAntecedentesException("msj_datos_incorrectos_no_antecedentes");
			} else {
				LOGGER.error("El Webservice de No Antecedentes nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new NoAntecedentesException("msj_no_conexion_no_antecedentes");
			}

			LOGGER.debug("Respuesta del servico No Antecedentes : " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL del No Antecedentes", e);
			throw new NoAntecedentesException("msj_no_conexion_no_antecedentes");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de No Antecedentes: ", e);
			throw new NoAntecedentesException("msj_no_conexion_no_antecedentes");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB de No Antecedentes: ", ex);
			throw new NoAntecedentesException("msj_no_conexion_no_antecedentes");
		} catch (JSONException e) {
			LOGGER.error("ERROR al convertir JSON de No Antecedentes: ", e);
		}
		finally {
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
	public TarjetaNoAntecedentesDTO consultaDocumentoNoAntecedentes(RegistroDTO registro) throws NoAntecedentesException{

		
		TarjetaNoAntecedentesDTO tarjetaNoAntecedentesDTO = new TarjetaNoAntecedentesDTO();
		StringBuilder urlQuery = new StringBuilder();
		urlQuery.append("https://dev-antecedentespenales.cdmx.gob.mx/rest/folioAntecedentes/consultarCostancia/");
		urlQuery.append("?idFolio=");
		urlQuery.append(registro.getIdRegistroOrigen());

		URI uri = null;
		String respuesta = null;
		ClientResponse response = null;
		try {
			uri = new URI(urlQuery.toString());

			WebResource webResource = null;

			webResource = JerseyUtil.getInstance().getClientSDKNoAntecedentesWithAuth().resource(uri.toString());

			response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			respuesta = response.getEntity(String.class);

			if (response.getStatus() == 200) {

				JSONObject jsonReporte = new JSONObject(respuesta);
				
				tarjetaNoAntecedentesDTO.setDocumento(jsonReporte.get("documento").toString());
				tarjetaNoAntecedentesDTO.setExtension(jsonReporte.get("extension").toString());
				
			} else if (response.getStatus() == 400) {
				/*
				 * Los errores 400 son errores del lado del cliente, es decir de esta
				 * programación, por ejemplo un dato que mandamos que no cumple las validaciones
				 * de longitud, de obligatoriedad, etc.
				 */
				LOGGER.warn("El Webservice de Licencia nos devolvió un código: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new NoAntecedentesException("msj_datos_incorrectos_noAntecedentes");
			} else {
				LOGGER.error("El Webservice de Licencia nos devolvió un código de error: " + response.getStatus()
						+ " Esta fue la respuesta obtenida: " + respuesta);
				throw new NoAntecedentesException("msj_no_conexion_noAntecedentes");
			}

			LOGGER.debug("Respuesta del servico Licencia: " + respuesta + " " + response.getStatus());
		} catch (URISyntaxException e) {
			LOGGER.error("Error al armar la URL de No Antecedentes: ", e);
			throw new NoAntecedentesException("msj_no_conexion_noAntecedentes");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No se pudo establecer la conexión al servicio web de Licencia: ", e);
			throw new NoAntecedentesException("msj_no_conexion_noAntecedentes");
		} catch (ClientHandlerException ex) {
			LOGGER.error("Error al realizar la conexión con el servicio WEB del Licencia: ", ex);
			throw new NoAntecedentesException("msj_no_conexion_noAntecedentes");
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

		return tarjetaNoAntecedentesDTO;
	}
	
	public static class NoAntecedentesException extends Exception {

		private static final long serialVersionUID = -4246678461721944771L;

		public NoAntecedentesException(String mensaje) {
			super(mensaje);
		}
	}
	
	
	public static void main(String[] args) {
		NoAntecedentesRestClient noAntecedentesRestClient = new NoAntecedentesRestClient();
		try {
			RegistroDTO registroDTO = new RegistroDTO();
			registroDTO.setIdRegistroOrigen("1");
			registroDTO=noAntecedentesRestClient.consultaRegistroNoAntecedentes(registroDTO);	
			TarjetaNoAntecedentesDTO tarjetaNoAntecedentesDTO = new TarjetaNoAntecedentesDTO();
			tarjetaNoAntecedentesDTO=noAntecedentesRestClient.consultaDocumentoNoAntecedentes(registroDTO);	
			System.out.println(registroDTO.getFolio());
			System.out.println(tarjetaNoAntecedentesDTO.getDocumento());
			
		} catch (ConnectException | URISyntaxException | JSONException | NoAntecedentesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
