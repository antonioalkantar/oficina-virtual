package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivosAdjuntosTramiteDTO;

@Stateless
@LocalBean
public class DetArchivosAdjuntosTramiteDAO  extends  IBaseDAO<DetArchivosAdjuntosTramiteDTO, Long> {

	@Override
	public DetArchivosAdjuntosTramiteDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosAdjuntosTramiteDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivosAdjuntosTramiteDTO> buscarPorCriterios(DetArchivosAdjuntosTramiteDTO e) {
		return null;
		
	}

	public List<DetArchivosAdjuntosTramiteDTO> buscarPorCriterios(Long idFormato) {
		return em.createNamedQuery("DetArchivosAdjuntosTramite.findById", DetArchivosAdjuntosTramiteDTO.class )
		.setParameter("idFormato", idFormato)
				.getResultList();
		
	}

	@Override
	public void actualizar(DetArchivosAdjuntosTramiteDTO e) {		
	}

	@Override
	public void guardar(DetArchivosAdjuntosTramiteDTO e) {
	}

}
