package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltx.dto.CatEstatusDTO;
import mx.gob.cdmx.adip.portaltx.dto.CatFuncionalidadDTO;


@Stateless
@LocalBean
public class CatFuncionalidadDAO extends IBaseDAO<CatFuncionalidadDTO, Integer> {

	@Override
	public CatFuncionalidadDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatFuncionalidadDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("CatFuncionalidad.findAllTx", CatFuncionalidadDTO.class).getResultList();
	}

	@Override
	public List<CatFuncionalidadDTO> buscarPorCriterios(CatFuncionalidadDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatFuncionalidadDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(CatFuncionalidadDTO e) {
		// TODO Auto-generated method stub

	}

}
