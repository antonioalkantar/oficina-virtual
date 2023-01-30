package mx.gob.cdmx.adip.widget.client;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import mx.gob.cdmx.adip.portaltramites.common.infra.Environment;
import mx.gob.cdmx.adip.widget.dto.HoyNoCirculaDTO;

public class HoyNoCirculaClient implements Serializable {

	private static final long serialVersionUID = 1092985005899122139L;
	private static final Logger LOGGER = LoggerFactory.getLogger(HoyNoCirculaClient.class);

	public HoyNoCirculaClient() {

	}

	public HoyNoCirculaDTO consulatHoyNoCircula() {
		HoyNoCirculaDTO noCirculaDTO = new HoyNoCirculaDTO();
		try {
			Client restClient = Client.create();
			restClient.setConnectTimeout(3000);
			restClient.setReadTimeout(3000);
			WebResource wr = restClient.resource(Environment.getUrlHoyNoCirculaCDMX());

			ClientResponse cr = wr.accept("application/json").get(ClientResponse.class);

			if(cr.getStatus() >= 500 && cr.getStatus() < 600 ) {
				LOGGER.warn("El servicio del Hoy No Circula contestó con error (HTTP 5XX): " + cr.getEntity(String.class));
				return noCirculaDTO;
			}else if (cr.getStatus() != 200) {
				LOGGER.warn("El servicio del Hoy No Circula respondió con un código de error HTTP: " + cr.getStatus());
				return noCirculaDTO;
			}
			
			String json = cr.getEntity(String.class);
			LOGGER.debug(json);			
			
	        noCirculaDTO = new Gson().fromJson(json, HoyNoCirculaDTO.class);
		} catch (Exception ex) {
			LOGGER.error("Ocurrió un error al consultar serivicio Hoy No Circula", ex);
		}
		return noCirculaDTO;
	}

}