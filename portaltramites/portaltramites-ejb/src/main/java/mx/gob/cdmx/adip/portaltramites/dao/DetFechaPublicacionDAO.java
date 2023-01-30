package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetFechaPublicacionDTO;

@Stateless
@LocalBean
public class DetFechaPublicacionDAO extends IBaseDAO<DetFechaPublicacionDTO, Long>{

	@Override
	public DetFechaPublicacionDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetFechaPublicacionDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetFechaPublicacionDTO> buscarPorCriterios(DetFechaPublicacionDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetFechaPublicacionDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(DetFechaPublicacionDTO e) {
		// TODO Auto-generated method stub
		
	}
	
	public DetFechaPublicacionDTO buscarPorIdTramiteAndIdFlujoTramite(Long idTramite, Long idFlujoTramite) {
		List<DetFechaPublicacionDTO> listado = em.createNamedQuery("DetFechaPublicacion.findByIdTramite", DetFechaPublicacionDTO.class)
				.setParameter("idTramite", idTramite)
				.setParameter("idCrcFlujo", idFlujoTramite)
				.getResultList();
		return listado.size()>0 ? listado.get(0): null;
	}
	
	
	public DetFechaPublicacionDTO buscarPorIdTramite(Long idTramite) {
		DetFechaPublicacionDTO detFechaPublicacionDTO = new DetFechaPublicacionDTO();
		List<DetFechaPublicacionDTO> listado = em.createNamedQuery("DetFechaPublicacion.findByIdTram", DetFechaPublicacionDTO.class)
				.setParameter("idTramite", idTramite)
				.getResultList();
		if (listado.size() > 0 ) {
			detFechaPublicacionDTO = listado.get(0);
		}
		
		return detFechaPublicacionDTO;
	}
	
	

}
