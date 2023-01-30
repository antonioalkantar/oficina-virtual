package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatEstadosDTO;

@Stateless
@LocalBean
public class CatEstadosDAO extends IBaseDAO<CatEstadosDTO, Integer>{

	@Override
	public CatEstadosDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public List<CatEstadosDTO> buscarTodos() {
		return em.createNamedQuery("CatEstados.findAll", CatEstadosDTO.class).getResultList();
	}

	@Override
	public List<CatEstadosDTO> buscarPorCriterios(CatEstadosDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatEstadosDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatEstadosDTO e) {
		// TODO Auto-generated method stub
		
	}

}
