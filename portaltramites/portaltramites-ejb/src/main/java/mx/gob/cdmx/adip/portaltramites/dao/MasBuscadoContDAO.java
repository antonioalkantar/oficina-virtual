package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.StoredProcedureQuery;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetLoMasBuscadoContDTO;

@Stateless
@Local
public class MasBuscadoContDAO extends IBaseDAO<DetLoMasBuscadoContDTO, Long> {

	@Override
	public DetLoMasBuscadoContDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetLoMasBuscadoContDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return emPortal.createNamedQuery("DetLoMasBuscadoCont.findAll", DetLoMasBuscadoContDTO.class).getResultList();
	}

	@Override
	public List<DetLoMasBuscadoContDTO> buscarPorCriterios(DetLoMasBuscadoContDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetLoMasBuscadoContDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(DetLoMasBuscadoContDTO e) {
		// TODO Auto-generated method stub

	}

	@Asynchronous
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void actualizarContador(Integer idTramite) {
		StoredProcedureQuery query = emPortal.createNamedStoredProcedureQuery("spInsertUpdateDetLoMasBuscadoCont");
		query.setParameter("idTramiteServicio", idTramite);
		query.execute();
		/*Boolean is_inserted_update = (Boolean) */query.getOutputParameterValue("contadorAccesos");
	}

}
