package mx.gob.cdmx.adip.portaltx.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltx.dto.RegistroDTO;

@Stateless
@LocalBean
public class RegistroDAO extends IBaseDAO<RegistroDTO, Long> {

	@Override
	public RegistroDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegistroDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegistroDTO> buscarPorCriterios(RegistroDTO e) {		
		return null;
	}

	@Override
	public void actualizar(RegistroDTO e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(RegistroDTO e) {
		// TODO Auto-generated method stub

	}
	
	public List<RegistroDTO> consultaGral(long idUsuarioLlaveCdmx, String curpUsuario, String correoUsuario ) {		
		List<RegistroDTO> lstRegistro = emPortal.createNamedQuery("Registro.findAllByIdUsuario", RegistroDTO.class)
				.setParameter("idUsuarioLlaveCdmx", idUsuarioLlaveCdmx)
				.setParameter("curpUsuario", curpUsuario)
				.setParameter("correoUsuario", correoUsuario)
				.getResultList();
		return lstRegistro;
	}

}
