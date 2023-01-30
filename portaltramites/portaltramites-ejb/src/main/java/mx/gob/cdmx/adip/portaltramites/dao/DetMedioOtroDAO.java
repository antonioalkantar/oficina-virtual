package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioOtroDTO;

@Stateless
@LocalBean
public class DetMedioOtroDAO extends IBaseDAO<DetMedioOtroDTO, Long> {

	@Override
	public DetMedioOtroDTO buscarPorId(Long id) {
		DetMedioOtroDTO detMedioOtroDTO = em
				.createNamedQuery("DetMedioOtro.findByIdMedioOtro", DetMedioOtroDTO.class)
				.setParameter("idMedioOtro", id).getSingleResult();
		return detMedioOtroDTO;
	}

	@Override
	public List<DetMedioOtroDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetMedioOtroDTO> buscarPorCriterios(DetMedioOtroDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetMedioOtroDTO e) {
		
	}

	@Override
	public void guardar(DetMedioOtroDTO e) {
	}
	
	public List<DetMedioOtroDTO> buscarPorIdCosto (long idCosto){
		List<DetMedioOtroDTO> lstMedioOtro = em.createNamedQuery("DetMedioOtro.findByIdCosto", DetMedioOtroDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		return lstMedioOtro;
	}

}
