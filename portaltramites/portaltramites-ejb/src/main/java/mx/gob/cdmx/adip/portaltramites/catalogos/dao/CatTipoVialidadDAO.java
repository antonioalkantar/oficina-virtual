package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatTipoVialidadDTO;

@Stateless
@LocalBean
public class CatTipoVialidadDAO extends IBaseDAO<CatTipoVialidadDTO, Long> {

	@Override
	public CatTipoVialidadDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatTipoVialidadDTO> buscarTodos() {
		
		return em.createNamedQuery("CatTipoVialidad.findAll", CatTipoVialidadDTO.class).getResultList();
	}

	@Override
	public List<CatTipoVialidadDTO> buscarPorCriterios(CatTipoVialidadDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatTipoVialidadDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatTipoVialidadDTO e) {
		// TODO Auto-generated method stub
		
	}

}
