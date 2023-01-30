package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatMomentoRealizaPagoDTO;

@Stateless
@LocalBean
public class MomentoRealizaPagoDAO extends IBaseDAO<CatMomentoRealizaPagoDTO, Long>{

	@Override
	public List<CatMomentoRealizaPagoDTO> buscarTodos() {
		return em.createNamedQuery("DetEncabezado.findAll", CatMomentoRealizaPagoDTO.class).getResultList();
	}

	@Override
	public List<CatMomentoRealizaPagoDTO> buscarPorCriterios(CatMomentoRealizaPagoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatMomentoRealizaPagoDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatMomentoRealizaPagoDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CatMomentoRealizaPagoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
