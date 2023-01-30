package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetLoMasBuscadoDTO;

@Stateless
@LocalBean
public class MasBuscadoDAO extends IBaseDAO<DetLoMasBuscadoDTO, Long> {

	@Override
	public DetLoMasBuscadoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetLoMasBuscadoDTO> buscarTodos() {
		return emPortal.createNamedQuery("DetLoMasBuscado.findAll", DetLoMasBuscadoDTO.class).getResultList();
	}

	@Override
	public List<DetLoMasBuscadoDTO> buscarPorCriterios(DetLoMasBuscadoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetLoMasBuscadoDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(DetLoMasBuscadoDTO e) {
		// TODO Auto-generated method stub

	}

}
