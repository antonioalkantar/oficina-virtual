package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltx.dto.CatSistemaDTO;
import mx.gob.cdmx.adip.portaltx.dto.CatTipoFuncionalidadDTO;


@Stateless
@LocalBean
public class CatTipoFuncionalidadDAO extends IBaseDAO<CatTipoFuncionalidadDTO, Integer> {

	@Override
	public CatTipoFuncionalidadDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public List<CatTipoFuncionalidadDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("CatTipoFuncionalidad.findAllTx", CatTipoFuncionalidadDTO.class).getResultList();
	}

	@Override
	public List<CatTipoFuncionalidadDTO> buscarPorCriterios(CatTipoFuncionalidadDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatTipoFuncionalidadDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(CatTipoFuncionalidadDTO e) {
		// TODO Auto-generated method stub

	}

}
