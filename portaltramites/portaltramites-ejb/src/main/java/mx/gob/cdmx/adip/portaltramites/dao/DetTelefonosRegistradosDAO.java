package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetTelefonosRegistradosDTO;

@Stateless
@LocalBean
public class DetTelefonosRegistradosDAO extends IBaseDAO<DetTelefonosRegistradosDTO,Integer>{

	@Override
	public DetTelefonosRegistradosDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetTelefonosRegistradosDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetTelefonosRegistradosDTO> buscarPorCriterios(DetTelefonosRegistradosDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetTelefonosRegistradosDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(DetTelefonosRegistradosDTO e) {
				
	}
	public List<DetTelefonosRegistradosDTO> buscarPorCanal(Long id){
		
		 List<DetTelefonosRegistradosDTO> lstEncontrado =  em.createNamedQuery("DetTelefonosRegistrado.buscarPorCanalAtencion",DetTelefonosRegistradosDTO.class)
				.setParameter("idcanal", id)				
				.getResultList();
		
		return lstEncontrado;
		
	}

}
