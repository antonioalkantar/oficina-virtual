package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEncabezadoDTO;
import mx.gob.cdmx.adip.portaltramites.model.DetEncabezado;

@Stateless
@LocalBean
public class EncabezadoDAO extends IBaseDAO<DetEncabezadoDTO, Long> {

	@Override
	public DetEncabezadoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetEncabezadoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("DetEncabezado.findAll", DetEncabezadoDTO.class).getResultList();
	}

	@Override
	public List<DetEncabezadoDTO> buscarPorCriterios(DetEncabezadoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetEncabezadoDTO e) {
		final DetEncabezado encabezado = emPortal.getReference(DetEncabezado.class, e.getId());
		encabezado.setDescripcion_encabezado(e.getDescripcion_encabezado());
		encabezado.setBackground(e.getBackground());
		encabezado.setEstatus(e.isEstatus());
		encabezado.setSituacion(e.isSituacion());
		encabezado.setLink_encabezado(e.getLink_encabezado());
		encabezado.setOrden(e.getOrden());
		emPortal.merge(encabezado);

	}

	@Override
	public void guardar(DetEncabezadoDTO e) {
		DetEncabezado encabezado = new DetEncabezado();
		encabezado.setDescripcion_encabezado(e.getDescripcion_encabezado());
		encabezado.setBackground(e.getBackground());
		encabezado.setEstatus(e.isEstatus());
		encabezado.setSituacion(e.isSituacion());
		encabezado.setLink_encabezado(e.getLink_encabezado());
		encabezado.setOrden(e.getOrden());
		emPortal.persist(encabezado);
		emPortal.flush();

	}
	
	public List<DetEncabezadoDTO> buscarPorEstatus() {
		return emPortal.createNamedQuery("DetEncabezado.findByEstatus", DetEncabezadoDTO.class).getResultList();
	}
	
	public List<DetEncabezadoDTO> buscarPorSituacion() {
		return emPortal.createNamedQuery("DetEncabezado.findBySituacion", DetEncabezadoDTO.class).getResultList();
	}

}
