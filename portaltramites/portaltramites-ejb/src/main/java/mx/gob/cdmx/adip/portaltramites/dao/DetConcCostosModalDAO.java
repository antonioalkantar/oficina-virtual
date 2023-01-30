package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetConcCostosModalDTO;

/**
 * Session Bean implementation class DetConcCostosModalDAO
 */
@Stateless
@LocalBean
public class DetConcCostosModalDAO extends IBaseDAO<DetConcCostosModalDTO, Long> {

    /**
     * Default constructor. 
     */
    public DetConcCostosModalDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DetConcCostosModalDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetConcCostosModalDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetConcCostosModalDTO> buscarPorCriterios(DetConcCostosModalDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetConcCostosModalDTO cc) {
	}

	@Override
	public void guardar(DetConcCostosModalDTO cc) {
	}
	
	public List<DetConcCostosModalDTO> buscarPorIdModalidad(Long idModalidad){
		List<DetConcCostosModalDTO> lstConceptos = em.createNamedQuery("DetConcCostosModalHist.findByIdTramiteHist", DetConcCostosModalDTO.class)
				.setParameter("idTramite", idModalidad)
				.getResultList();
		if (lstConceptos == null || lstConceptos.size() == 0) {
			return em.createNamedQuery("DetConcCostosModal.findByIdTramite", DetConcCostosModalDTO.class)
			.setParameter("idTramite", idModalidad)
			.getResultList();
		} else {
			return lstConceptos;
		}
	}

}
