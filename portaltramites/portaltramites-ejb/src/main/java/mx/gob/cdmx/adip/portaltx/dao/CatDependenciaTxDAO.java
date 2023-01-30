package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.CatDependenciaDTO;
import mx.gob.cdmx.adip.portaltx.dto.CatDependenciaTxDTO;

@Stateless
@LocalBean
public class CatDependenciaTxDAO extends IBaseDAO<CatDependenciaTxDTO, Integer> {

	@Override
	public CatDependenciaTxDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDependenciaTxDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("CatDependenciaTx.findAllTx", CatDependenciaTxDTO.class).getResultList();
	}

	@Override
	public List<CatDependenciaTxDTO> buscarPorCriterios(CatDependenciaTxDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatDependenciaTxDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(CatDependenciaTxDTO e) {
		// TODO Auto-generated method stub

	}

}
