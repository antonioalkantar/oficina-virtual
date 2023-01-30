package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetCanalAtencionDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetPasosRegistradoDTO;
import mx.gob.cdmx.adip.portaltramites.model.CatActor;
import mx.gob.cdmx.adip.portaltramites.model.CrcFlujoTramite;
import mx.gob.cdmx.adip.portaltramites.model.DetCanalAtencion;
import mx.gob.cdmx.adip.portaltramites.model.DetPasosRegistrado;

@Stateless
@LocalBean
public class DetPasosRegistradoDAO  extends IBaseDAO<DetPasosRegistradoDTO,Integer>{

	@Override
	public DetPasosRegistradoDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetPasosRegistradoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetPasosRegistradoDTO> buscarPorCriterios(DetPasosRegistradoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetPasosRegistradoDTO e) {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void guardar(DetPasosRegistradoDTO e) {	
	}
	
	public void guardarNuevo(DetPasosRegistradoDTO e) {	
	}
	
	public List<DetPasosRegistradoDTO> buscarPorCanalTipoSolicitud(Long id,Long idTipo){
		
		 List<DetPasosRegistradoDTO> lstEncontrado =  em.createNamedQuery("DetPasosRegistrado.buscarPorCanalAtencionTipoSol",DetPasosRegistradoDTO.class)
				.setParameter("idcanal", id)
				.setParameter("idTipo", idTipo)
				.getResultList();
		
		return lstEncontrado;
		
	}
	
}
