package mx.gob.cdmx.adip.portaltramites.commons.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class IBaseDAO<E, ID> {
	
	@PersistenceContext(unitName = "retysDS")
	protected EntityManager em;

	@PersistenceContext(unitName = "portaltramitesDS")
	protected EntityManager emPortal;
	
	@PersistenceContext(unitName = "sibisDS")
	protected EntityManager sibisDS;
	
	public abstract E buscarPorId(ID id);
	
	public abstract List<E> buscarTodos();
	
	public abstract List<E> buscarPorCriterios(E e);
	
	public abstract void actualizar(E e);
	
	public abstract void guardar(E e);
}