package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.model.ServicioSemaforoEp;
import mx.gob.cdmx.adip.widget.dto.ServicioSemaforoEpDTO;


@Stateless
@LocalBean
public class ServicioSemaforoEpDAO  extends IBaseDAO<ServicioSemaforoEpDTO,Long>{

	@Override
	public ServicioSemaforoEpDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicioSemaforoEpDTO> buscarTodos() {
	
		return emPortal.createNamedQuery("ServicioSemaforoEp.findAllById",ServicioSemaforoEpDTO.class).getResultList();
	}

	@Override
	public List<ServicioSemaforoEpDTO> buscarPorCriterios(ServicioSemaforoEpDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(ServicioSemaforoEpDTO semEp) {
		final ServicioSemaforoEp semaforo = emPortal.getReference(ServicioSemaforoEp.class, semEp.getId());
		semaforo.setNombre(semEp.getNombre());
		semaforo.setColor(semEp.getColor());
		emPortal.merge(semaforo);

	}

	@Override
	public void guardar(ServicioSemaforoEpDTO e) {
		// TODO Auto-generated method stub
		
	}

}
