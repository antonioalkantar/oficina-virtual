package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetConceptosCostoDTO;

@Stateless
@LocalBean
public class DetConceptosCostoDAO extends IBaseDAO<DetConceptosCostoDTO, Long>{

	
	public DetConceptosCostoDAO() {
		
	}

	@Override
	public DetConceptosCostoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetConceptosCostoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetConceptosCostoDTO> buscarPorCriterios(DetConceptosCostoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetConceptosCostoDTO cc) {

	}

	@Override
	public void guardar(DetConceptosCostoDTO cc) {

	}
	
	public List<DetConceptosCostoDTO> buscarPorIdCosto (Long idCosto){
		List<DetConceptosCostoDTO> lstConceptos = em.createNamedQuery("DetConceptosCostosHist.findByIdCostosHist", DetConceptosCostoDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		if (lstConceptos == null || lstConceptos.size() == 0) {
			return lstConceptos = em.createNamedQuery("DetConceptosCosto.findByIdCostos", DetConceptosCostoDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		} else {
			return lstConceptos;
		}
	}
	
}
