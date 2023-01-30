package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;


@Stateless
@LocalBean
public class CatSistemaDAO extends IBaseDAO<CatSistemaDTO, Integer> {

	@Override
	public CatSistemaDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatSistemaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("CatSistema.findAllTx", CatSistemaDTO.class).getResultList();
	}

	@Override
	public List<CatSistemaDTO> buscarPorCriterios(CatSistemaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatSistemaDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(CatSistemaDTO e) {
		// TODO Auto-generated method stub

	}

}
