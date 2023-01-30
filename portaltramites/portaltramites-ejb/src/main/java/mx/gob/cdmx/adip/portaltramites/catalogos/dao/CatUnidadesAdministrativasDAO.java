package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatUnidadesAdministrativaDTO;

@Stateless
@LocalBean
public class CatUnidadesAdministrativasDAO extends IBaseDAO<CatUnidadesAdministrativaDTO, Long>{

	@Override
	public CatUnidadesAdministrativaDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatUnidadesAdministrativaDTO> buscarTodos() {
		return (List<CatUnidadesAdministrativaDTO>)em.createNamedQuery("CatUnidadesAdministrativa.findAll", CatUnidadesAdministrativaDTO.class).getResultList();
	}

	@Override
	public List<CatUnidadesAdministrativaDTO> buscarPorCriterios(CatUnidadesAdministrativaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatUnidadesAdministrativaDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatUnidadesAdministrativaDTO e) {
		// TODO Auto-generated method stub
		
	}

}
