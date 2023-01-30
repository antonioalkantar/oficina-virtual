package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosFormatoTramiteDTO;


@Stateless
@LocalBean
public class DetArchivosFormatoTramiteDAO extends  IBaseDAO<DetArchivosFormatoTramiteDTO, Long> {

	@Override
	public DetArchivosFormatoTramiteDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosFormatoTramiteDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosFormatoTramiteDTO> buscarPorCriterios(DetArchivosFormatoTramiteDTO e) {
		return null;
				
	}

	public List<DetArchivosFormatoTramiteDTO> buscarPorCriterios(Long idFormato) {
		List<DetArchivosFormatoTramiteDTO> lstFormatos = new ArrayList<DetArchivosFormatoTramiteDTO>();
		lstFormatos = em.createNamedQuery("DetArchivosFormatoTramite.findByIdHist",DetArchivosFormatoTramiteDTO.class)
				.setParameter("idDetFormato", idFormato)
				.getResultList();
		if (lstFormatos != null && lstFormatos.size() > 0) {
			return lstFormatos;
		}
		
		return em.createNamedQuery("DetArchivosFormatoTramite.findById",DetArchivosFormatoTramiteDTO.class)
				.setParameter("idDetFormato", idFormato)
				.getResultList();
	}

	@Override
	public void actualizar(DetArchivosFormatoTramiteDTO e) {
	}

	@Override
	public void guardar(DetArchivosFormatoTramiteDTO e) {		
	}

}
