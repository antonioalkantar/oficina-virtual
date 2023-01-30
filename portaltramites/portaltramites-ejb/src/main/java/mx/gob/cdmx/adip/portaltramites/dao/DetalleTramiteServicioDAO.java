package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.DetalleTramiteServicioDTO;

@Stateless
@LocalBean
public class DetalleTramiteServicioDAO extends IBaseDAO<DetalleTramiteServicioDTO, Integer>{

	@Override
	public DetalleTramiteServicioDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DetalleTramiteServicioDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		List<DetalleTramiteServicioDTO> lst = em.createNamedQuery("TramiteServicio.findById",DetalleTramiteServicioDTO.class)
				.setParameter("idTramite", id)
				.getResultList();
		if (lst.size() > 0)
			return lst.get(0);
		else
			return null;
	}

	@Override
	public List<DetalleTramiteServicioDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleTramiteServicioDTO> buscarPorCriterios(DetalleTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetalleTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(DetalleTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		
	}

}
