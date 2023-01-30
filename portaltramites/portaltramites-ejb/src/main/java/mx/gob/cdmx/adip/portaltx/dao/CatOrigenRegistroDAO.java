package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltx.dto.CatOrigenRegistroDTO;


@Stateless
@LocalBean
public class CatOrigenRegistroDAO extends IBaseDAO<CatOrigenRegistroDTO, Integer> {

	@Override
	public CatOrigenRegistroDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatOrigenRegistroDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("CatOrigenRegistro.findAllTx", CatOrigenRegistroDTO.class).getResultList();
	}

	@Override
	public List<CatOrigenRegistroDTO> buscarPorCriterios(CatOrigenRegistroDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatOrigenRegistroDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(CatOrigenRegistroDTO e) {
		// TODO Auto-generated method stub

	}

}
