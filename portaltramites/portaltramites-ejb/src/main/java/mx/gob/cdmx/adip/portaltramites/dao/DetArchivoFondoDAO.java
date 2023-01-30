package mx.gob.cdmx.adip.portaltramites.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.io.FileUtils;

import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.DetArchivoFondoDTO;
import mx.gob.cdmx.adip.portaltramites.model.DetArchivoFondo;

@Stateless
@LocalBean
public class DetArchivoFondoDAO extends IBaseDAO<DetArchivoFondoDTO, Long>{

	@Override
	public DetArchivoFondoDTO buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivoFondoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetArchivoFondoDTO> buscarPorCriterios(DetArchivoFondoDTO e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DetArchivoFondoDTO e) {
		final DetArchivoFondo fondo = emPortal.getReference(DetArchivoFondo.class, e.getId());
		fondo.setEstatus(e.isEstatus());
		fondo.setSituacion(e.isSituacion());
		fondo.setFechaCreacion(e.getFechaCreacion());
		fondo.setFechaModificacion(e.getFechaModificacion());
		fondo.setNombre_archivo(e.getNombre_archivo());
		fondo.setRuta_archivo(e.getRuta_archivo());
		
		emPortal.merge(fondo);
		
	}

	@Override
	public void guardar(DetArchivoFondoDTO e) {		
		DetArchivoFondo fondo = new DetArchivoFondo();
		fondo.setEstatus(e.isEstatus());
		fondo.setSituacion(e.isSituacion());
		fondo.setFechaCreacion(e.getFechaCreacion());
		fondo.setFechaModificacion(e.getFechaModificacion());
		fondo.setNombre_archivo(e.getNombre_archivo());
		fondo.setRuta_archivo(e.getRuta_archivo());
		
		emPortal.persist(fondo);
		emPortal.flush();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetArchivoFondoDTO> buscarPorEstatus() {
		return emPortal.createNamedQuery("DetArchivoFondo.findByEstatus", DetArchivoFondoDTO.class).getResultList();
	}	

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetArchivoFondoDTO> buscarPorEstatusMobile() {
		return emPortal.createNamedQuery("DetArchivoFondo.findByEstatusMobile", DetArchivoFondoDTO.class).getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetArchivoFondoDTO> buscarporSituacion() {
		return emPortal.createNamedQuery("DetArchivoFondo.findBySituacion", DetArchivoFondoDTO.class).getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetArchivoFondoDTO> buscarporSituacionMobile() {
		return emPortal.createNamedQuery("DetArchivoFondo.findBySituacionMobile", DetArchivoFondoDTO.class).getResultList();
	}
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrar(DetArchivoFondoDTO e) throws IOException {
		
		if (e.getContentFileImgFondo() !=null) {
			FileUtils.writeByteArrayToFile(new File(e.getRuta_archivo()), e.getContentFileImgFondo());
		}
		DetArchivoFondo fondo = new DetArchivoFondo();
		fondo.setEstatus(e.isEstatus());
		fondo.setSituacion(e.isSituacion());
		fondo.setFechaCreacion(e.getFechaCreacion());
		fondo.setFechaModificacion(e.getFechaModificacion());
		fondo.setNombre_archivo(e.getNombre_archivo());
		fondo.setRuta_archivo(e.getRuta_archivo());
		fondo.setEsEscritorio(e.isEsEscritorio());
		
		emPortal.persist(fondo);
		emPortal.flush();
		
	}

}
