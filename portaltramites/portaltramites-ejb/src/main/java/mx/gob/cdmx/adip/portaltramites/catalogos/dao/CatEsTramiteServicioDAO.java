package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatEsTramiteServicioDTO;


@Stateless
@LocalBean
public class CatEsTramiteServicioDAO extends IBaseDAO<CatEsTramiteServicioDTO, Long>{

	@Override
	public CatEsTramiteServicioDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatEsTramiteServicioDTO> buscarTodos() {
		return em.createNamedQuery("CatEsTramiteServicio.findAll", CatEsTramiteServicioDTO.class).getResultList();
//		return null;
	}

	@Override
	public List<CatEsTramiteServicioDTO> buscarPorCriterios(CatEsTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatEsTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatEsTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		
	}

}
