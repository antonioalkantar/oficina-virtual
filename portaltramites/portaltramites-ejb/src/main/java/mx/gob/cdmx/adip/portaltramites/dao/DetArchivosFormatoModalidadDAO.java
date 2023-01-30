package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosFormatoModalidadDTO;

/**
 * Session Bean implementation class DetArchivosFormatoModalidadDAO
 */
@Stateless
@LocalBean
public class DetArchivosFormatoModalidadDAO extends IBaseDAO<DetArchivosFormatoModalidadDTO, Long> {

    /**
     * Default constructor. 
     */
    public DetArchivosFormatoModalidadDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DetArchivosFormatoModalidadDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosFormatoModalidadDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosFormatoModalidadDTO> buscarPorCriterios(DetArchivosFormatoModalidadDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetArchivosFormatoModalidadDTO af) {
	}

	@Override
	public void guardar(DetArchivosFormatoModalidadDTO af) {
	}
	
	public List<DetArchivosFormatoModalidadDTO> buscarPorIdModalidad(Long idTramite, Long idModalidad){
		List<DetArchivosFormatoModalidadDTO> lstArchivosFormato = em.createNamedQuery("DetArchivosFormatoModalidad.findByIdTramite", DetArchivosFormatoModalidadDTO.class)
				.setParameter("idTramite", idTramite)
				.setParameter("idModalidad", idModalidad)
				.getResultList();
		
		if (lstArchivosFormato != null && lstArchivosFormato.size() > 0)
			return lstArchivosFormato;
		
		return em.createNamedQuery("DetArchivosFormatoModalidad.findByIdTramiteII", DetArchivosFormatoModalidadDTO.class)
				.setParameter("idTramite", idTramite)
				.setParameter("idModalidad", idModalidad)
				.getResultList();
	}
	
}
