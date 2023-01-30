package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioOficinaDTO;

@Stateless
@LocalBean
public class DetMedioOficinaDAO extends IBaseDAO<DetMedioOficinaDTO,  Long>{

	@Override
	public DetMedioOficinaDTO buscarPorId(Long id) {
		DetMedioOficinaDTO detMedioOficinaDTO = em
				.createNamedQuery("DetMedioOficina.findByIdOficinaTributaria", DetMedioOficinaDTO.class)
				.setParameter("idOficinaTributaria", id).getSingleResult();
		return detMedioOficinaDTO;
	}

	@Override
	public List<DetMedioOficinaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetMedioOficinaDTO> buscarPorCriterios(DetMedioOficinaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetMedioOficinaDTO e) {
		
	}

	@Override
	public void guardar(DetMedioOficinaDTO e) {
		
	}
	
	public List<DetMedioOficinaDTO> buscarPorIdCosto (long idCosto){
		List<DetMedioOficinaDTO> lstMedioOfic = em.createNamedQuery("DetMedioOficina.findByIdCosto", DetMedioOficinaDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		return lstMedioOfic;
	}

}
