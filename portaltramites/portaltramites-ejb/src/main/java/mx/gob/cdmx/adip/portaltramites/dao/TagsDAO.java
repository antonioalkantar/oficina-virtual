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
import mx.gob.cdmx.adip.portaltramites.commons.dto.TagsDTO;
import mx.gob.cdmx.adip.portaltramites.model.Tags;

@Stateless
@LocalBean
public class TagsDAO extends IBaseDAO<TagsDTO, Long>{

	@Override
	public TagsDTO buscarPorId(Long id) {
		return null;
	}

	@Override
	public List<TagsDTO> buscarTodos() {
		return null;
	}

	@Override
	public List<TagsDTO> buscarPorCriterios(TagsDTO e) {
		
		// 1. Se arma los segmentos de la consulta (Select, from, where, order by) por separado para después poderlas ejecutarlas aparte.
		JPQL jpqlQuerySelectFields = new JPQL();
		JPQL jpqlQueryFromWhere = new JPQL();
		JPQL jpqlQueryOrderby = new JPQL();
		
		jpqlQuerySelectFields.append(" SELECT NEW mx.gob.cdmx.adip.portaltramites.commons.dto.TagsDTO ");
		jpqlQuerySelectFields.append("         (t.idTag, t.tituloTag, ");
		jpqlQuerySelectFields.append("         t.orden, t.activo, ");
		jpqlQuerySelectFields.append("         t.situacion, t.fechaCreacion )");
		
		jpqlQueryFromWhere.append(" FROM Tags t  ");
		jpqlQueryFromWhere.append(" WHERE t.situacion = TRUE ");
		
		jpqlQueryFromWhere.append(e.getTituloTag() != null  &&  !e.getTituloTag().isEmpty(),
				 "    and t.tituloTag like :tituloTag ", "tituloTag", "%" + e.getTituloTag()+"%");

		jpqlQueryFromWhere.append(e.getActivo() !=  null,
				 " 	  and t.activo  = :activo ", "activo", e.getActivo());		
		jpqlQueryOrderby.append("    ORDER BY t.orden ASC ");
		
		JPQL jpqlQueryFullFields = new JPQL(jpqlQuerySelectFields.toString() + jpqlQueryFromWhere.toString() + jpqlQueryOrderby.toString(), jpqlQueryFromWhere.getParams());
		
		
		Query query = emPortal.createQuery(jpqlQueryFullFields.toString());
		
		jpqlQueryFullFields.setParameters(query);
		
		@SuppressWarnings("unchecked")
		List<TagsDTO> lstsTags = query.getResultList();
		
		return lstsTags;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizar(TagsDTO e) {
		Tags tags = new Tags();
		tags.setIdTag(e.getIdTag());
		tags.setTituloTag(e.getTituloTag());
		tags.setOrden(e.getOrden());
		tags.setActivo(e.getActivo());
		tags.setFechaCreacion(e.getFechaCreacion());
		tags.setFechaModificacion(new Date());
		tags.setSituacion(e.getSituacion());
		emPortal.merge(tags);
		emPortal.flush();	
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void guardar(TagsDTO e) {
		Tags tags = new Tags();
		tags.setTituloTag(e.getTituloTag());
		tags.setOrden(e.getOrden());
		tags.setActivo(e.getActivo());
		tags.setFechaCreacion(new Date());
		tags.setSituacion(true);
		emPortal.persist(tags);
		emPortal.flush();
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TagsDTO> consultaTopTags() {	
		List<TagsDTO> listado = emPortal.createNamedQuery("Tags.consultaTop", TagsDTO.class)
				.setMaxResults(4)
				.getResultList();
		return listado;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizarActivoInactivo(TagsDTO e) {
		Tags tags = emPortal.getReference(Tags.class, e.getIdTag());
		tags.setActivo(!e.getActivo());
		emPortal.merge(tags);		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(TagsDTO e) {
		Tags tags = emPortal.getReference(Tags.class, e.getIdTag());
		tags.setSituacion(!e.getSituacion());
		emPortal.merge(tags);		
	}

}
