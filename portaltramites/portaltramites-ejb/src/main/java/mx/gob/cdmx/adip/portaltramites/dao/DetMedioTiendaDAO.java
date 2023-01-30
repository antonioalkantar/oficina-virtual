package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetMedioTiendaDTO;

@Stateless
@LocalBean
public class DetMedioTiendaDAO extends IBaseDAO<DetMedioTiendaDTO, Long> {

	@Override
	public DetMedioTiendaDTO buscarPorId(Long id) {
		DetMedioTiendaDTO detMedioTiendaDTO = em
				.createNamedQuery("DetMedioTienda.findByIdMedioTienda", DetMedioTiendaDTO.class)
				.setParameter("idMedioTienda", id).getSingleResult();
		return detMedioTiendaDTO;
	}

	@Override
	public List<DetMedioTiendaDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetMedioTiendaDTO> buscarPorCriterios(DetMedioTiendaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetMedioTiendaDTO e) {
	}

	@Override
	public void guardar(DetMedioTiendaDTO e) {
	}
	
	public List<DetMedioTiendaDTO> buscarPorIdCosto (long idCosto){
		List<DetMedioTiendaDTO> lstMedioTienda = em.createNamedQuery("DetMedioTienda.findByIdCosto", DetMedioTiendaDTO.class )
				.setParameter("idCosto", idCosto)
				.getResultList();
		return lstMedioTienda;
		
	}

}
