package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CrcTramiteFundamentoDTO;

@Stateless
@LocalBean
public class CrcTramiteFundamentoDAO extends IBaseDAO<CrcTramiteFundamentoDTO, Long> {

	@Override
	public CrcTramiteFundamentoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrcTramiteFundamentoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrcTramiteFundamentoDTO> buscarPorCriterios(CrcTramiteFundamentoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CrcTramiteFundamentoDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CrcTramiteFundamentoDTO e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public List<CrcTramiteFundamentoDTO> buscarPorIdTramite (Long idTramite){      
		List<CrcTramiteFundamentoDTO> bsq = em.createNamedQuery
				("CrcTramiteFundamento.findByIdTramiteHist", CrcTramiteFundamentoDTO.class)
				.setParameter("idTramite", idTramite)
				.getResultList();
		if (bsq == null || bsq.size() == 0) {
			return em.createNamedQuery
					("CrcTramiteFundamento.findByIdTramite", CrcTramiteFundamentoDTO.class)
					.setParameter("idTramite", idTramite)
					.getResultList();
		} else {
			return bsq;
		}
	}
	
	
	

}
