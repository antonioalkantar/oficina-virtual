package mx.gob.cdmx.adip.portaltramites.dao;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

import org.apache.commons.io.FileUtils;

import mx.gob.cdmx.adip.portaltramites.common.util.JPQL;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.AnunciosDTO;
import mx.gob.cdmx.adip.portaltramites.model.Anuncios;

@Stateless
@LocalBean
public class AnunciosDAO extends IBaseDAO <AnunciosDTO, Long>{

	@Override
	public AnunciosDTO buscarPorId(Long id) {
		AnunciosDTO dto = emPortal.createNamedQuery("",AnunciosDTO.class)
				.setParameter("", id)
				.getSingleResult();
		return dto;
	}

	@Override
	public List<AnunciosDTO> buscarTodos() {
		return emPortal.createNamedQuery("Anuncios.findAll", AnunciosDTO.class).getResultList();
	}

	@Override
	public List<AnunciosDTO> buscarPorCriterios(AnunciosDTO e) {
		
		// 1. Se arma los segmentos de la consulta (Select, from, where, order by) por separado para después poderlas ejecutarlas aparte.
		JPQL jpqlQuerySelectFields = new JPQL();
		JPQL jpqlQueryFromWhere = new JPQL();
		JPQL jpqlQueryOrderby = new JPQL();
		
		jpqlQuerySelectFields.append(" SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.AnunciosDTO ");
		jpqlQuerySelectFields.append("         (a.idAnuncio, a.titulo, ");
		jpqlQuerySelectFields.append("         a.descripcion, a.link, ");
		jpqlQuerySelectFields.append("         a.imagen, a.orden, ");
		jpqlQuerySelectFields.append("         a.activo, a.situacion )");
		
		jpqlQueryFromWhere.append(" FROM Anuncios a  ");
		jpqlQueryFromWhere.append(" WHERE a.situacion = TRUE ");
		
		jpqlQueryFromWhere.append(e.getTitulo() != null  &&  !e.getTitulo().isEmpty(),
								 "    and a.titulo like :titulo ", "titulo", "%" + e.getTitulo()+"%");
		
		jpqlQueryFromWhere.append(e.getActivo() !=  null,
								 " 	  and a.activo  = :activo ", "activo", e.getActivo());		
		jpqlQueryOrderby.append("    ORDER BY a.orden ASC ");
							
		
		JPQL jpqlQueryFullFields = new JPQL(jpqlQuerySelectFields.toString() + jpqlQueryFromWhere.toString() + jpqlQueryOrderby.toString(), jpqlQueryFromWhere.getParams());
		
		
		Query query = emPortal.createQuery(jpqlQueryFullFields.toString());
		
		jpqlQueryFullFields.setParameters(query);
		
		@SuppressWarnings("unchecked")
		List<AnunciosDTO> lstAnuncios = query.getResultList();
		
		return lstAnuncios;
	}

	@Override
	public void actualizar(AnunciosDTO e) {
		
	}

	@Override
	public void guardar(AnunciosDTO e) {		
	
	}
	
	public List<AnunciosDTO> buscarRecientes() {		
		return null;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registrar(AnunciosDTO e) throws IOException {		
		
		if (e.getContentFileTarjetaAnuncio() != null) {
			FileUtils.writeByteArrayToFile(new File(e.getImagen()), e.getContentFileTarjetaAnuncio());
		}
		Anuncios anuncio = new Anuncios();		
		anuncio.setTitulo(e.getTitulo());
		anuncio.setDescripcion(e.getDescripcion());
		anuncio.setLink(e.getLink());
		anuncio.setImagen(e.getImagen());
		anuncio.setOrden(e.getOrden());
		anuncio.setActivo(e.getActivo());
		anuncio.setFechaCreacion(new Date());
		anuncio.setSituacion(true);
		
		emPortal.persist(anuncio);
		emPortal.flush();	
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(AnunciosDTO e , String pathActual) throws IOException {		
		
		// 1. Se guardan las imagenes  en fileSystem, así si falla su guarado se evita que quede un registro inconsistente en  la BD, es decir, que exista en la BD el Anuncios pero hayamos perdido el documento
		
		// 1.1 Se verifica si la imagen del Anuncio se ha cargado nuevamente
				if (e.getContentFileTarjetaAnuncio() != null) {
					
					if (pathActual != null && !pathActual.equals("")) {						
						
						// Se elimina la imagen
						FileUtils.forceDelete(new File(pathActual));
						
						// Se guarda la imagen
						FileUtils.writeByteArrayToFile(new File(e.getImagen()),
								e.getContentFileTarjetaAnuncio());
					}					
				}		
		//Se actualia la informacion del anuncio				
		Anuncios anuncio = new Anuncios();	
		anuncio.setIdAnuncio(e.getIdAnuncio());
		anuncio.setTitulo(e.getTitulo());
		anuncio.setDescripcion(e.getDescripcion());
		anuncio.setLink(e.getLink());
		anuncio.setImagen(e.getImagen());
		anuncio.setOrden(e.getOrden());
		anuncio.setActivo(e.getActivo());
		anuncio.setFechaCreacion(e.getFechaCreacion());
		anuncio.setFechaModificacion(new Date());
		anuncio.setSituacion(true);
		
		emPortal.merge(anuncio);
		emPortal.flush();
	}	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizarActivoInactivo (AnunciosDTO e) {
		Anuncios anuncios = emPortal.getReference(Anuncios.class, e.getIdAnuncio());		
		anuncios.setActivo(!e.getActivo());
		emPortal.merge(anuncios);
	}	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover (AnunciosDTO e) {
		Anuncios anuncios = emPortal.getReference(Anuncios.class, e.getIdAnuncio());		
		anuncios.setSituacion(!e.getSituacion());
		emPortal.merge(anuncios);
	}

}
