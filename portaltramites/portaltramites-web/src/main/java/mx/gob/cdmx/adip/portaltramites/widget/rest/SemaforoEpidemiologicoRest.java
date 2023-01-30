package mx.gob.cdmx.adip.portaltramites.widget.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.dao.ServicioSemaforoEpDAO;
import mx.gob.cdmx.adip.widget.dto.ServicioSemaforoEpDTO;

import javax.ws.rs.Produces;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Path("/semaforo-epidemiologico")
@RequestScoped
public class SemaforoEpidemiologicoRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SemaforoEpidemiologicoRest.class);

	@Inject
	private ServicioSemaforoEpDAO semaforo;

	/**
	 * Metodo para consumir el servicio semaforo
	 * Respuestas: 200: Si encontro algun resultado 301: No ha datos disponibles
	 */
	@GET
	@Path("/consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarSemaforoEpidemiologico() {
		StringBuilder respuesta = new StringBuilder();

		List<ServicioSemaforoEpDTO> semaforoDTO = semaforo.buscarTodos();
		if (semaforoDTO.size() > 0) {
			ServicioSemaforoEpDTO semaforo = semaforoDTO.get(0);
			respuesta.append("{\"codigo\":200,\"nombre\": \"" + semaforo.getNombre() + "\",\"color\":\""
					+ semaforo.getColor() + "\"}");
			return Response.status(Response.Status.OK).entity(respuesta.toString()).type(MediaType.APPLICATION_JSON)
					.build();
		} else {
			respuesta.append("{\"codigo\":301,\"mensage\":\"No ha encontrado ningun color\"}");
			return Response.status(Response.Status.OK).entity(respuesta.toString()).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}
}
