package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetTelefonoRegistradoDTO;

@Stateless
@LocalBean
public class DetTelefonoRegistradoDAO extends IBaseDAO<DetTelefonoRegistradoDTO, Long> {

	@Override
	public DetTelefonoRegistradoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetTelefonoRegistradoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetTelefonoRegistradoDTO> buscarPorCriterios(DetTelefonoRegistradoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetTelefonoRegistradoDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(DetTelefonoRegistradoDTO e) {
		// TODO Auto-generated method stub
		
	}

	public List<DetTelefonoRegistradoDTO> buscarPoridArea(Long idArea) {
		List<DetTelefonoRegistradoDTO> listado = em
				.createNamedQuery("DetTelefonoRegistrado.buscarPorIdArea", DetTelefonoRegistradoDTO.class)
				.setParameter("idArea", idArea).getResultList();
		return listado;

	}

}
