package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioOnlineDTO;

@Stateless
@LocalBean
public class DetMedioOnlineDAO extends IBaseDAO<DetMedioOnlineDTO, Long> {

	@Override
	public DetMedioOnlineDTO buscarPorId(Long id) {
		DetMedioOnlineDTO detMedioOnlineDTO = em
				.createNamedQuery("DetMedioOnline.findByIdMedioOnline", DetMedioOnlineDTO.class)
				.setParameter("idMedioOnLine", id).getSingleResult();
		return detMedioOnlineDTO;
	}

	@Override
	public List<DetMedioOnlineDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetMedioOnlineDTO> buscarPorCriterios(DetMedioOnlineDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetMedioOnlineDTO e) {
		
	}

	@Override
	public void guardar(DetMedioOnlineDTO e) {
		
	}
	
	public List<DetMedioOnlineDTO> buscarPorIdCosto (long idCosto){
		List<DetMedioOnlineDTO> lstMedioOnLine = em.createNamedQuery("DetMedioOnline.findByIdCosto", DetMedioOnlineDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		return lstMedioOnLine;
				
	}
	

}
