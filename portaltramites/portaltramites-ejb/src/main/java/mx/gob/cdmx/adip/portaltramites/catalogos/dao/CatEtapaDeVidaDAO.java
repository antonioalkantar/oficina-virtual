package mx.gob.cdmx.adip.portaltramites.catalogos.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.dto.CatEtapaDeVidaDTO;

/**
 * Session Bean implementation class CatEtapaDeVidaDAO
 */
@Stateless
@LocalBean
public class CatEtapaDeVidaDAO extends IBaseDAO<CatEtapaDeVidaDTO,Long> {

    /**
     * Default constructor. 
     */
    public CatEtapaDeVidaDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public CatEtapaDeVidaDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatEtapaDeVidaDTO> buscarTodos() {
		List<CatEtapaDeVidaDTO> lstCatEtapaDeVidaDTO = em.createNamedQuery("CatEtapaDeVida.findAll", CatEtapaDeVidaDTO.class).getResultList();
		return lstCatEtapaDeVidaDTO;
	}

	@Override
	public List<CatEtapaDeVidaDTO> buscarPorCriterios(CatEtapaDeVidaDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CatEtapaDeVidaDTO e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(CatEtapaDeVidaDTO e) {
		// TODO Auto-generated method stub
		
	}

}
