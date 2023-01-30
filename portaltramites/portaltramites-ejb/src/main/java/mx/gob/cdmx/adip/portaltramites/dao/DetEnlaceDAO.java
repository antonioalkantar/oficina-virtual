package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetEnlaceDTO;
import mx.gob.cdmx.adip.portaltramites.model.DetEnlace;

@Stateless
@LocalBean
public class DetEnlaceDAO extends IBaseDAO<DetEnlaceDTO, Long> {

	@Override
	public DetEnlaceDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public List<DetEnlaceDTO> buscarTodos() {
		return emPortal.createNamedQuery("DetEnlace.findAll", DetEnlaceDTO.class).getResultList();
	}

	@Override
	public List<DetEnlaceDTO> buscarPorCriterios(DetEnlaceDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetEnlaceDTO e) {
		final DetEnlace detEnlace = emPortal.getReference(DetEnlace.class, e.getId());
		detEnlace.setDescripcion(e.getDescripcion());
		detEnlace.setEnlace(e.getEnlace());
		detEnlace.setEstatus(e.isEstatus());
		detEnlace.setVisible(e.isVisible());
		detEnlace.setOrden(e.getOrden());
		detEnlace.setFechaModificacion(e.getFechaModificacion());

		emPortal.merge(detEnlace);
	}

	@Override
//	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void guardar(DetEnlaceDTO e) {
		DetEnlace detEnlace = new DetEnlace();
		detEnlace.setDescripcion(e.getDescripcion());
		detEnlace.setEnlace(e.getEnlace());
		detEnlace.setEstatus(e.isEstatus());
		detEnlace.setVisible(e.isVisible());
		detEnlace.setOrden(e.getOrden());
		detEnlace.setFechaCreacion(e.getFechaCreacion());
		detEnlace.setFechaModificacion(e.getFechaModificacion());
		emPortal.persist(detEnlace);
		emPortal.flush();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetEnlaceDTO> buscarPorVisible() {
		return emPortal.createNamedQuery("DetEnlace.findByVisible", DetEnlaceDTO.class).getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetEnlaceDTO> buscarPorEstatus() {
		return emPortal.createNamedQuery("DetEnlace.findByEstatus", DetEnlaceDTO.class).getResultList();
	}

}
