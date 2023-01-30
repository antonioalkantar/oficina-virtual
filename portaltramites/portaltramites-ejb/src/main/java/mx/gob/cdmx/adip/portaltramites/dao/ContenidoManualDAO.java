package mx.gob.cdmx.adip.portaltramites.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

import mx.gob.cdmx.adip.portaltramites.common.util.JPQL;
import mx.gob.cdmx.adip.portaltramites.commons.dao.IBaseDAO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatDependenciasDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.CatTemaDTO;
import mx.gob.cdmx.adip.portaltramites.commons.dto.ContenidoManualDTO;
import mx.gob.cdmx.adip.portaltramites.model.CatDependencias;
import mx.gob.cdmx.adip.portaltramites.model.CatTema;
import mx.gob.cdmx.adip.portaltramites.model.ContenidoManual;

@Stateless
@LocalBean
public class ContenidoManualDAO extends IBaseDAO <ContenidoManualDTO, Long>{

	@Override
	public ContenidoManualDTO buscarPorId(Long id) {
		return null;
	}

	@Override
	public List<ContenidoManualDTO> buscarTodos() {
		return emPortal.createNamedQuery("ContenidoManual.findAll",ContenidoManualDTO.class).getResultList();
	}

	@Override
	public List<ContenidoManualDTO> buscarPorCriterios(ContenidoManualDTO e) {
		
		// 1. Se arma los segmentos de la consulta (Select, from, where, order by) por separado para después poderlas ejecutarlas aparte.
		
		JPQL jpqlQuerySelectFields = new JPQL();
		JPQL jpqlQueryFromWhere = new JPQL();
		JPQL jpqlQueryOrderby = new JPQL();
		
		jpqlQuerySelectFields.append(" SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.ContenidoManualDTO ");
		jpqlQuerySelectFields.append("         (c.idContenido, c.titulo, ");
		jpqlQuerySelectFields.append("         c.descripcion, c.link, ");
		jpqlQuerySelectFields.append("         c.activo, c.fechaCreacion, ");
		jpqlQuerySelectFields.append("         c.situacion, cd.idDependencia, ");
		jpqlQuerySelectFields.append("         cd.nombreDependencia, cd.situacion, ");
		jpqlQuerySelectFields.append("         ct.idCatTema, ct.descripcion, ");
		jpqlQuerySelectFields.append("         ct.situacion, c.palabrasClave )");
		
		jpqlQueryFromWhere.append(" FROM ContenidoManual c  ");
		jpqlQueryFromWhere.append("     JOIN c.catDependencias cd  ");
		jpqlQueryFromWhere.append("     JOIN c.catTema ct  ");
		
		jpqlQueryFromWhere.append(" WHERE c.situacion = TRUE AND cd.situacion = TRUE AND ct.situacion = TRUE ");
		
		jpqlQueryFromWhere.append(e.getTitulo()  != null  &&  !e.getTitulo().isEmpty(),
				 "    and c.titulo like :titulo ", "titulo", "%" + e.getTitulo()+"%");
		
		jpqlQueryFromWhere.append(e.getActivo() !=  null,
				 " 	  and c.activo  = :activo ", "activo", e.getActivo());	
		
		jpqlQueryOrderby.append("    ORDER BY c.titulo ASC ");
		
		JPQL jpqlQueryFullFields = new JPQL(jpqlQuerySelectFields.toString() + jpqlQueryFromWhere.toString() + jpqlQueryOrderby.toString(), jpqlQueryFromWhere.getParams());
		
		
		Query query = emPortal.createQuery(jpqlQueryFullFields.toString());
		
		jpqlQueryFullFields.setParameters(query);
		
		@SuppressWarnings("unchecked")
		List<ContenidoManualDTO> lstContenidoManual = query.getResultList();
		
		return lstContenidoManual;
		
	}

	@Override
	public void actualizar(ContenidoManualDTO e) {
		
		ContenidoManual contenidoManual = new ContenidoManual();
		
		contenidoManual.setIdContenido(e.getIdContenido());
		contenidoManual.setTitulo(e.getTitulo());
		contenidoManual.setDescripcion(e.getDescripcion());
		contenidoManual.setLink(e.getLink());
		contenidoManual.setOrden(0);
		contenidoManual.setActivo(e.getActivo());
		contenidoManual.setFechaCreacion(e.getFechaCreacion());
		contenidoManual.setFechaModificacion(new Date());
		contenidoManual.setSituacion(true);
		contenidoManual.setCatDependencias(new CatDependencias(e.getCatDependenciasDTO().getIdDependencia()));
		contenidoManual.setCatTema(new CatTema(e.getCatTemaDTO().getIdCatTema()));
		contenidoManual.setPalabrasClave(e.getPalabrasClave());
		
		emPortal.merge(contenidoManual);
		emPortal.flush();	
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void guardar(ContenidoManualDTO e) {
		
		ContenidoManual contenidoManual = new ContenidoManual();
		
		contenidoManual.setTitulo(e.getTitulo());
		contenidoManual.setDescripcion(e.getDescripcion());
		contenidoManual.setLink(e.getLink());
		contenidoManual.setOrden(0);
		contenidoManual.setActivo(e.getActivo());
		contenidoManual.setFechaCreacion(new Date());
		contenidoManual.setSituacion(true);
		contenidoManual.setCatDependencias(new CatDependencias(e.getCatDependenciasDTO().getIdDependencia()));
		contenidoManual.setCatTema(new CatTema(e.getCatTemaDTO().getIdCatTema()));
		contenidoManual.setPalabrasClave(e.getPalabrasClave());
		
		emPortal.persist(contenidoManual);
		emPortal.flush();	
				
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizarActivoInactivo (ContenidoManualDTO e) {
		ContenidoManual contenidoManual = emPortal.getReference(ContenidoManual.class, e.getIdContenido());
		contenidoManual.setActivo(!e.getActivo());
		emPortal.merge(contenidoManual);
	}
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover (ContenidoManualDTO e) {
		ContenidoManual contenidoManual = emPortal.getReference(ContenidoManual.class, e.getIdContenido());
		contenidoManual.setSituacion(!e.getSituacion());
		emPortal.merge(contenidoManual);
	}
	
	//Catalogo Dependencias Portal
	public List<CatDependenciasDTO> buscarTodosBackDep() {
		List<CatDependenciasDTO> lstDependencias = emPortal.createNamedQuery("CatDependencias.findAllBack", CatDependenciasDTO.class).getResultList();
		return lstDependencias;
	}
	
	//Catalogo Temas Portal
	public List<CatTemaDTO> buscarTodosBackTema() {
		List<CatTemaDTO> lstDependencias = emPortal.createNamedQuery("CatTema.findAllBack", CatTemaDTO.class).getResultList();
		return lstDependencias;
		}
}
