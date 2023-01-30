package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetRequisitosFormatoDTO;

@Stateless
@LocalBean
public class DetRequisitosFormatoDAO extends IBaseDAO<DetRequisitosFormatoDTO, Long>  {

	@Override
	public DetRequisitosFormatoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetRequisitosFormatoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetRequisitosFormatoDTO> buscarPorCriterios(DetRequisitosFormatoDTO e) {
		return null;
	}

	public List<DetRequisitosFormatoDTO> buscarPorIdFormato(Long idFormato) {
		List<DetRequisitosFormatoDTO> lstDatos = new ArrayList<DetRequisitosFormatoDTO>();
		lstDatos = em.createNamedQuery("DetRequisitosFormato.findByIdHist",DetRequisitosFormatoDTO.class)
		.setParameter("detFormatoid", idFormato)
		.getResultList();
		
		if (lstDatos != null && lstDatos.size() > 0)
			return lstDatos;
		else
			return em.createNamedQuery("DetRequisitosFormato.findById",DetRequisitosFormatoDTO.class)
					.setParameter("detFormatoid", idFormato)
					.getResultList();
	}

	@Override
	public void actualizar(DetRequisitosFormatoDTO e) {
	
	}

	@Override
	public void guardar(DetRequisitosFormatoDTO e) {
		
	}

}
