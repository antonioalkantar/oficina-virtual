package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioDependenciaDTO;

@Stateless
@LocalBean
public class DetMedioDependenciaDAO extends IBaseDAO<DetMedioDependenciaDTO, Long> {

	@Override
	public DetMedioDependenciaDTO buscarPorId(Long id) {
		DetMedioDependenciaDTO detMedioDependenciaDTO = em
				.createNamedQuery("DetMedioDependencia.findByIdMedioDep", DetMedioDependenciaDTO.class)
				.setParameter("idMedioDep", id).getSingleResult();
		return detMedioDependenciaDTO;
	}

	@Override
	public List<DetMedioDependenciaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetMedioDependenciaDTO> buscarPorCriterios(DetMedioDependenciaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetMedioDependenciaDTO e) {
	}

	@Override
	public void guardar(DetMedioDependenciaDTO e) {
	}
	
	public List<DetMedioDependenciaDTO> buscarPorIdCosto (long idCosto){
		List<DetMedioDependenciaDTO> lstMedioDep = em.createNamedQuery("DetMedioDependencia.findByIdCosto", DetMedioDependenciaDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		return lstMedioDep;
	}
	
}
