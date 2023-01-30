package mx.gob.cdmx.adip.portaltramites.widget.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO;
import mx.gob.cdmx.adip.portaltramites.dao.EncabezadoDAO;
import mx.gob.cdmx.adip.widget.dto.ServicioSemaforoEpDTO;

import javax.ws.rs.Produces;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Path("/notificaciones")
@RequestScoped
public class NotificacionesRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificacionesRest.class);

	@Inject
	private EncabezadoDAO encabezadoDAO;

	/**
	 * Metodo para consumir las notificaciones emergentes
	 */
	@GET
	@Path("/consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarSemaforoEpidemiologico() {
		StringBuilder respuesta = new StringBuilder(500);

		List<DetEncabezadoDTO> lstEncabezadoDTO = encabezadoDAO.buscarPorSituacion();
		if (lstEncabezadoDTO.size() > 0 && lstEncabezadoDTO.get(0).isSituacion()) {
			respuesta.append("{\"codigo\":200, \"activo\":true, \"mensaje\": \"" + lstEncabezadoDTO.get(0).getDescripcion_encabezado().replaceAll("\"", "") + "\",\"background-color\":\""
					+ lstEncabezadoDTO.get(0).getBackground() + "\", \"href\": \"" + lstEncabezadoDTO.get(0).getLink_encabezado() +"\" }");
			return Response.status(Response.Status.OK).entity(respuesta.toString()).type(MediaType.APPLICATION_JSON)
					.build();
		} else {
			respuesta.append("{\"codigo\":200, \"activo\":false, \"mensaje\": \"\",\"background-color\":\"\", \"href\": \"\" }");
			return Response.status(Response.Status.OK).entity(respuesta.toString()).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}
}
