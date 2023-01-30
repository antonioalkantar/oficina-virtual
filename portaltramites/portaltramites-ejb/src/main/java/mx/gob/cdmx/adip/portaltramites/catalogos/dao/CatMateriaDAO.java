package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.AdminMateriaDTO;

@Stateless
@LocalBean
public class CatMateriaDAO extends IBaseDAO<AdminMateriaDTO, Integer>{

	@Override
	public AdminMateriaDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminMateriaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("CatMateria.findAll", AdminMateriaDTO.class).getResultList();
	}

	@Override
	public List<AdminMateriaDTO> buscarPorCriterios(AdminMateriaDTO e) {
		return null;
	}

	@Override
	public void actualizar(AdminMateriaDTO e) {
	}

	@Override
	public void guardar(AdminMateriaDTO e) {
	}

}
