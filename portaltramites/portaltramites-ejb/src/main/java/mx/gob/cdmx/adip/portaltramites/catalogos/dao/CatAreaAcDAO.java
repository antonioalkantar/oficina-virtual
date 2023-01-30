package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatAreaAcDTO;

@Stateless
@LocalBean
public class CatAreaAcDAO  extends IBaseDAO<CatAreaAcDTO,Long>{

	
	public List<CatAreaAcDTO> buscarPorIdArea(Long id) {
			
		
		List<CatAreaAcDTO> lstcentroAt = new ArrayList<CatAreaAcDTO>();
		
		lstcentroAt = em.createNamedQuery("CatAreaAc.findById", CatAreaAcDTO.class)
			.setParameter("idCatArea", id)
			.getResultList();
		
		return lstcentroAt;
	}
	
	
	public List<CatAreaAcDTO> busqHorarios(Long id) {
		List<CatAreaAcDTO> lstcentroAt = new ArrayList<CatAreaAcDTO>();
		lstcentroAt = em.createNamedQuery("CatAreaAc.busqHorarios", CatAreaAcDTO.class)
			.setParameter("idCatArea", id)
			.getResultList();
		
		return lstcentroAt;
	}
	
	
	@Override
	public CatAreaAcDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<CatAreaAcDTO> buscarTodos() {		
		List<CatAreaAcDTO> lstEncontrados =  em.createNamedQuery("CatAreaAc.findAll",CatAreaAcDTO.class).getResultList();
		return lstEncontrados;
	}

	@Override
	public List<CatAreaAcDTO> buscarPorCriterios(CatAreaAcDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatAreaAcDTO e) {
	}

	@Override
	public void guardar(CatAreaAcDTO e) {
	}

}
