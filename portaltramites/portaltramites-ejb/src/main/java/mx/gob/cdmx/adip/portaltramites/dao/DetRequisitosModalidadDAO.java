package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetRequisitosModalidadDTO;
import mx.gob.cdmx.adip.portaltramites.model.CatLeye;
import mx.gob.cdmx.adip.portaltramites.model.CrcFlujoTramite;
import mx.gob.cdmx.adip.portaltramites.model.DetModalidadesTramite;
import mx.gob.cdmx.adip.portaltramites.model.DetRequisitosModalidad;

/**
 * Session Bean implementation class DetRequisitosModalidadDAO
 */
@Stateless
@LocalBean
public class DetRequisitosModalidadDAO extends IBaseDAO<DetRequisitosModalidadDTO, Long> {

    /**
     * Default constructor. 
     */
    public DetRequisitosModalidadDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DetRequisitosModalidadDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetRequisitosModalidadDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetRequisitosModalidadDTO> buscarPorCriterios(DetRequisitosModalidadDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetRequisitosModalidadDTO r) {
	}

	@Override
	public void guardar(DetRequisitosModalidadDTO r) {
	}
	
	public List<DetRequisitosModalidadDTO> buscarPorIdModalidad(Long idTramite, Long idModalidad){
		List<DetRequisitosModalidadDTO> lstRequisitos = em.createNamedQuery("DetRequisitosModalidad.findByIdTramiteHist", DetRequisitosModalidadDTO.class)
				.setParameter("idTramite", idTramite)
				.setParameter("idModalidad", idModalidad)
				.getResultList();
		if (lstRequisitos != null && lstRequisitos.size() > 0)
			return lstRequisitos;
		else 
			return em.createNamedQuery("DetRequisitosModalidad.findByIdTramiteII", DetRequisitosModalidadDTO.class)
					.setParameter("idTramite", idTramite)
					.setParameter("idModalidad", idModalidad)
					.getResultList();
	}
	

}
