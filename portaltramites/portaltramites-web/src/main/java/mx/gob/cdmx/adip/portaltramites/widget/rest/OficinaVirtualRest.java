package mx.gob.cdmx.adip.portaltramites.widget.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.gob.cdmx.adip.portaltramites.common.util.BeanUtils;
import mx.gob.cdmx.adip.portaltramites.commons.dto.OficinaVirtualRespuestaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.RespuestaHttpDTO;
import mx.gob.cdmx.adip.portaltramites.commons.enums.RespuestaHttpEnum;
import mx.gob.cdmx.adip.portaltramites.dao.OficinaVirtualDAO;
import mx.gob.cdmx.adip.portaltramites.dto.OficinaVirtualDTO;


@Path("/oficinas-virtuales")
@RequestScoped
public class OficinaVirtualRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(OficinaVirtualRest.class);

	@Inject
	private OficinaVirtualDAO oficinaVirtualDAO;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarOficinaVirtual(OficinaVirtualDTO oficinaVirtualDTO) {
		Gson gson = new Gson();
		RespuestaHttpDTO respuesta = new RespuestaHttpDTO();
		if (BeanUtils.isNull(oficinaVirtualDTO.getIdSistema())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdFuncionalidad())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdRegistro())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdEstatus())
				|| BeanUtils.isNull(oficinaVirtualDTO.getFechaRegistro())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdUsuarioLlavecdmx())
				|| BeanUtils.isNull(oficinaVirtualDTO.getCurpUsuario())
				|| BeanUtils.isNull(oficinaVirtualDTO.getCorreoUsuario())) {
			respuesta.setCodigo(RespuestaHttpEnum.FALTAN_PARAMETROS_OBLIGATORIOS.getCodigoRespuesta());
			respuesta.setMensaje(RespuestaHttpEnum.FALTAN_PARAMETROS_OBLIGATORIOS.getMensajeRespuesta());
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson(respuesta)).build();
		}
		try {
			OficinaVirtualRespuestaDTO oficinaVirtualRespuesta = oficinaVirtualDAO.guardarOficinaVirtualSP(oficinaVirtualDTO);
			return Response.status(Response.Status.OK).entity(gson.toJson(oficinaVirtualRespuesta)).build();
		} catch (Exception e) {
			LOGGER.error("Error al guardar oficina virtual", e);
			respuesta.setCodigo(RespuestaHttpEnum.ERROR_INESPERADO.getCodigoRespuesta());
			respuesta.setMensaje(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(respuesta)).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarOficinaVirtual(OficinaVirtualDTO oficinaVirtualDTO) {
		Gson gson = new Gson();
		RespuestaHttpDTO respuesta = new RespuestaHttpDTO();
		if (BeanUtils.isNull(oficinaVirtualDTO.getIdSistema())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdFuncionalidad())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdRegistro())
				|| BeanUtils.isNull(oficinaVirtualDTO.getIdEstatus())) {
			respuesta.setCodigo(RespuestaHttpEnum.FALTAN_PARAMETROS_OBLIGATORIOS.getCodigoRespuesta());
			respuesta.setMensaje(RespuestaHttpEnum.FALTAN_PARAMETROS_OBLIGATORIOS.getMensajeRespuesta());
			return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson(respuesta)).build();
		}
		try {
			OficinaVirtualRespuestaDTO oficinaVirtualRespuesta = oficinaVirtualDAO.actualizarOficinaVirtualSP(oficinaVirtualDTO);
			return Response.status(Response.Status.OK).entity(gson.toJson(oficinaVirtualRespuesta)).build();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar oficina virtual", e);
			respuesta.setCodigo(RespuestaHttpEnum.ERROR_INESPERADO.getCodigoRespuesta());
			respuesta.setMensaje(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(respuesta)).build();
		}
	}
}
