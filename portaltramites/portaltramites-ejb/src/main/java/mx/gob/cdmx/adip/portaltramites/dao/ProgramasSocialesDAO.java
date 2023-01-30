package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.sibis.dto.ProgramasSocialesDTO;

@Stateless
@LocalBean
public class ProgramasSocialesDAO extends IBaseDAO<ProgramasSocialesDTO, Long> {

	@Override
	public ProgramasSocialesDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgramasSocialesDTO> buscarTodos() {
		Calendar today = Calendar.getInstance();
	    int year = today.get(Calendar.YEAR);
		return sibisDS.createNamedQuery("Programs.buscarProgramasSociales", ProgramasSocialesDTO.class)
					  .setParameter("year", year )
					  .getResultList();
	}

	@Override
	public List<ProgramasSocialesDTO> buscarPorCriterios(ProgramasSocialesDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(ProgramasSocialesDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(ProgramasSocialesDTO e) {
		// TODO Auto-generated method stub
		
	}

}
