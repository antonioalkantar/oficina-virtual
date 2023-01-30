package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioBancoDTO;

@Stateless
@LocalBean
public class DetMedioBancoDAO extends IBaseDAO<DetMedioBancoDTO, Long> {

	@Override
	public DetMedioBancoDTO buscarPorId(Long id) {
		DetMedioBancoDTO detMedioBancoDTO = em
				.createNamedQuery("DetMedioBanco.findByIdMedioBanco", DetMedioBancoDTO.class)
				.setParameter("idMedBanco", id).getSingleResult();		
		return detMedioBancoDTO;
	}

	@Override
	public List<DetMedioBancoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetMedioBancoDTO> buscarPorCriterios(DetMedioBancoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetMedioBancoDTO e) {
	}

	@Override
	public void guardar(DetMedioBancoDTO e) {
		
	}
	
	public List<DetMedioBancoDTO> buscarPorIdCosto (long idCosto){
		List<DetMedioBancoDTO> lstMedioBanc = em.createNamedQuery("DetMedioBanco.findByIdCosto", DetMedioBancoDTO.class)
				.setParameter("idCosto", idCosto)
				.getResultList();
		return lstMedioBanc;
	}
	
}
