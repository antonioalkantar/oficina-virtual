package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetDocumentosTramiteDTO;

/**
 * Session Bean implementation class DetDocumentosTramiteDAO
 */
@Stateless
@LocalBean
public class DetDocumentosTramiteDAO extends IBaseDAO<DetDocumentosTramiteDTO, Long> {

    /**
     * Default constructor. 
     */
    public DetDocumentosTramiteDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DetDocumentosTramiteDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetDocumentosTramiteDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetDocumentosTramiteDTO> buscarPorCriterios(DetDocumentosTramiteDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetDocumentosTramiteDTO e) {

	}

	@Override
	public void guardar(DetDocumentosTramiteDTO dt) {

	}
	
	public List<DetDocumentosTramiteDTO> buscarPorIdTramiteAndIdTipo(Long idTramite, Long idTipoDoc) {
		List<DetDocumentosTramiteDTO> lstDocumentosTramite = em.createNamedQuery("DetDocumentosTramite.findbyIdTramiteAndIdTipoDocHist", DetDocumentosTramiteDTO.class)
				.setParameter("idTramite", idTramite)
				.setParameter("idTipoDoc", idTipoDoc)
				.getResultList();
		if (lstDocumentosTramite != null && lstDocumentosTramite.size() > 0)
			return lstDocumentosTramite;
		else
			return em.createNamedQuery("DetDocumentosTramite.findbyIdTramiteAndIdTipoDoc", DetDocumentosTramiteDTO.class)
			.setParameter("idTramite", idTramite)
			.setParameter("idTipoDoc", idTipoDoc)
			.getResultList();
	}
	
}
