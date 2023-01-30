package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.DetalleTramiteServicioDTO;
import mx.gob.cdmx.adip.portaltramites.dto.ModalidadesTramiteServicioDTO;


@Stateless
@LocalBean
public class ModalidadesTramiteServicioDAO extends IBaseDAO<ModalidadesTramiteServicioDTO, Integer> {

	@Override
	public ModalidadesTramiteServicioDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModalidadesTramiteServicioDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ModalidadesTramiteServicioDTO> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		List<ModalidadesTramiteServicioDTO> lstData = new ArrayList<ModalidadesTramiteServicioDTO>();
		lstData = em.createNamedQuery("DetModalidadesTramite.findByIdTramiteHist",ModalidadesTramiteServicioDTO.class)
		.setParameter("idTramite", id)
		.getResultList();
		if (lstData != null && lstData.size() > 0)
			return lstData; 
		else
			return em.createNamedQuery("DetModalidadesTramite.findByIdTramiteII",ModalidadesTramiteServicioDTO.class)
			.setParameter("idTramite", id)
			.getResultList();
		
	}

	@Override
	public List<ModalidadesTramiteServicioDTO> buscarPorCriterios(ModalidadesTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(ModalidadesTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(ModalidadesTramiteServicioDTO e) {
		// TODO Auto-generated method stub
		
	}

}
