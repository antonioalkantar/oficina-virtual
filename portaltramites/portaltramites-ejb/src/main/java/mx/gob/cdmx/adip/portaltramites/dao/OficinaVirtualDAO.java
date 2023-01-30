package mx.gob.cdmx.adip.portaltramites.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.OficinaVirtualRespuestaDTO;
import mx.gob.cdmx.adip.portaltramites.dto.OficinaVirtualDTO;

@Stateless
@LocalBean
public class OficinaVirtualDAO extends IBaseDAO<OficinaVirtualDTO, Long> {

	@Override
	public OficinaVirtualDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OficinaVirtualDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OficinaVirtualDTO> buscarPorCriterios(OficinaVirtualDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(OficinaVirtualDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(OficinaVirtualDTO e) {

	}

	public OficinaVirtualRespuestaDTO guardarOficinaVirtualSP(OficinaVirtualDTO e)  {

		StringBuilder sb = new StringBuilder();
		sb.append("call \"portalcdmx-tx\".recibe_datos_oficina_virtual");
		sb.append("(");
		sb.append("cast('usuario' as varchar),");
		sb.append("cast('contrasenia' as varchar),");
		sb.append(e.getIdSistema() + ",");
		sb.append(e.getIdFuncionalidad() + ",");
		sb.append("cast('" + e.getIdRegistro() + "' as varchar),");
		sb.append("cast(" + e.getIdEstatus() + " as smallint),");
		sb.append("cast(to_timestamp('" + e.getFechaRegistro() + "', 'YYYY/MM/DD hh24:mi:ss') as timestamp),");
		sb.append("cast(" + e.getIdUsuarioLlavecdmx() + " as bigint),");
		sb.append("cast('" + e.getCurpUsuario() + "' as varchar),");
		sb.append("cast('" + e.getCorreoUsuario() + "' as varchar),");
		sb.append("0,");
		sb.append("cast('' as varchar)");
		sb.append(")");

		Query query = em.createNativeQuery(sb.toString());

		List<Object[]> resultados = query.getResultList();

		Integer codigoResultado = (Integer) resultados.get(0)[0];
		String mensajeResultado = (String) resultados.get(0)[1];

		return new OficinaVirtualRespuestaDTO(codigoResultado, mensajeResultado);

	}

	public OficinaVirtualRespuestaDTO actualizarOficinaVirtualSP(OficinaVirtualDTO e) {

		StringBuilder sb = new StringBuilder();
		sb.append("call \"portalcdmx-tx\".actualiza_datos_oficina_virtual");
		sb.append("(");
		sb.append("cast('usuario' as varchar),");
		sb.append("cast('contrasenia' as varchar),");
		sb.append(e.getIdSistema() + ",");
		sb.append(e.getIdFuncionalidad() + ",");
		sb.append("cast('" + e.getIdRegistro() + "' as varchar),");
		sb.append("cast(" + e.getIdEstatus() + " as smallint),");
		sb.append("0,");
		sb.append("cast('' as varchar)");
		sb.append(")");

		Query query = em.createNativeQuery(sb.toString());

		List<Object[]> resultados = query.getResultList();

		Integer codigoResultado = (Integer) resultados.get(0)[0];
		String mensajeResultado = (String) resultados.get(0)[1];

		return new OficinaVirtualRespuestaDTO(codigoResultado, mensajeResultado);

	}

}
