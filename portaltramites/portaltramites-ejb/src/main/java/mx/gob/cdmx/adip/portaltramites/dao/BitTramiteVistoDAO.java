package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.BitTramiteVistoDTO;
import mx.gob.cdmx.adip.portaltramites.model.BitTramitesVistos;
import mx.gob.cdmx.adip.portaltramites.model.CatOrigenConsulta;

@Stateless
@Local
public class BitTramiteVistoDAO extends IBaseDAO<BitTramiteVistoDTO, Long> {

	@Override
	public BitTramiteVistoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BitTramiteVistoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BitTramiteVistoDTO> buscarPorCriterios(BitTramiteVistoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(BitTramiteVistoDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	@Asynchronous
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void guardar(BitTramiteVistoDTO e) {
		BitTramitesVistos bitTramitesVistos = new BitTramitesVistos();
		bitTramitesVistos.setCatOrigenConsulta(emPortal.getReference(CatOrigenConsulta.class, e.getCatOrigenConsultaDTO().getIdOrgenConsultaDTO().longValue()));
		bitTramitesVistos.setFechaConsulta(new Date());
		bitTramitesVistos.setIdTramiteServicio(e.getIdTramiteServicio());
		bitTramitesVistos.setTituloTramite(e.getTituloTramite());
		
		emPortal.persist(bitTramitesVistos);
	}

}
