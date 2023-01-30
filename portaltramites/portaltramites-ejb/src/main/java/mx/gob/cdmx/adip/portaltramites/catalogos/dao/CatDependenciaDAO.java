package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.CatDependenciaDTO;


/**
 * Session Bean implementation class CatDependenciaDAO
 */
@Stateless
@LocalBean
public class CatDependenciaDAO extends IBaseDAO<CatDependenciaDTO, Integer> {

    /**
     * Default constructor. 
     */
    public CatDependenciaDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public CatDependenciaDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatDependenciaDTO> buscarTodos() {
		return null;
	}

	@Override
	public List<CatDependenciaDTO> buscarPorCriterios(CatDependenciaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatDependenciaDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatDependenciaDTO e) {
		// TODO Auto-generated method stub
	}
	
	public List<CatDependenciaDTO> buscarTodosAlt() {
		List<CatDependenciaDTO> lstDependencias = em.createNamedQuery("CatDependencia.findAll", CatDependenciaDTO.class).getResultList();
		return lstDependencias;
	}
}
