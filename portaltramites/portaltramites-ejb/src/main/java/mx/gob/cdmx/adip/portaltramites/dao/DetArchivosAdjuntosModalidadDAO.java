package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosAdjuntosModalidadDTO;

/**
 * Session Bean implementation class DetArchivosAdjuntosModalidadDAO
 */
@Stateless
@LocalBean
public class DetArchivosAdjuntosModalidadDAO extends IBaseDAO<DetArchivosAdjuntosModalidadDTO, Long> {

    /**
     * Default constructor. 
     */
    public DetArchivosAdjuntosModalidadDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DetArchivosAdjuntosModalidadDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosAdjuntosModalidadDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosAdjuntosModalidadDTO> buscarPorCriterios(DetArchivosAdjuntosModalidadDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetArchivosAdjuntosModalidadDTO aa) {
	}

	@Override
	public void guardar(DetArchivosAdjuntosModalidadDTO aa) {
	}
	
	public List<DetArchivosAdjuntosModalidadDTO> buscarPorIdModalidad(Long idModalidad){
		List<DetArchivosAdjuntosModalidadDTO> lstArchivoAdjunto = em.createNamedQuery("DetArchivosAdjuntosModalidad.findByIdTramite", DetArchivosAdjuntosModalidadDTO.class)
				.setParameter("idTramite", idModalidad)
				.getResultList();
		
		return lstArchivoAdjunto;
	}
	
}
