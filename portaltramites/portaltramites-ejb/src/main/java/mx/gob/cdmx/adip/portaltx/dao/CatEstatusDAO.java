package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;


@Stateless
@LocalBean
public class CatEstatusDAO extends IBaseDAO<CatEstatusDTO, Integer> {

	@Override
	public CatEstatusDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatEstatusDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("CatEstatus.findAllTx", CatEstatusDTO.class).getResultList();
	}

	@Override
	public List<CatEstatusDTO> buscarPorCriterios(CatEstatusDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatEstatusDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(CatEstatusDTO e) {
		// TODO Auto-generated method stub

	}

}
