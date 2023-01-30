package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetUrlRegistradoDTO;

@Stateless
@LocalBean
public class DetUrlRegistradaDAO  extends IBaseDAO<DetUrlRegistradoDTO,Integer>{

	@Override
	public DetUrlRegistradoDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetUrlRegistradoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetUrlRegistradoDTO> buscarPorCriterios(DetUrlRegistradoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetUrlRegistradoDTO e) {
		
	}

	@Override
	public void guardar(DetUrlRegistradoDTO e) {

	}
	
	
	public List<DetUrlRegistradoDTO> buscarPorCanal(Long id){
		
		 List<DetUrlRegistradoDTO> lstEncontrado =  em.createNamedQuery("DetUrlRegistrado.buscarPorCanalAtencion",DetUrlRegistradoDTO.class)
				.setParameter("idcanal", id)				
				.getResultList();
		
		return lstEncontrado;
		
	}

}
