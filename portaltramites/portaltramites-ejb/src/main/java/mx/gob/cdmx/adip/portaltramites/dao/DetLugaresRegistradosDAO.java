package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetLugaresRegistradosDTO;

@Stateless
@LocalBean
public class DetLugaresRegistradosDAO  extends IBaseDAO<DetLugaresRegistradosDTO,Integer>{

	@Override
	public DetLugaresRegistradosDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetLugaresRegistradosDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetLugaresRegistradosDTO> buscarPorCriterios(DetLugaresRegistradosDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetLugaresRegistradosDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(DetLugaresRegistradosDTO e) {
		
	}
	
	
	public List<DetLugaresRegistradosDTO> buscarPorCanal(Long id){
		 List<DetLugaresRegistradosDTO> lstEncontrado =  em.createNamedQuery("DetLugaresRegistrado.buscarPorCanalAtencion",DetLugaresRegistradosDTO.class)
				.setParameter("idcanal", id)				
				.getResultList();
		
		return lstEncontrado;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizaEstatus(Long idPaso) {
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizaURL(DetLugaresRegistradosDTO e) {
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPorID(Long id) {
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarPorCanalAt(Long id) {
	}

}
