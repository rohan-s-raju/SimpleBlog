package com.rohan.blog.framework.dataaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rohan.blog.framework.entity.BaseDO;


public abstract class BaseDaoImpl implements BaseDao{

	EntityManager entityManager;

	/**
	 * This method sets the entityManager. Will be used for
	 * CRUD operations
	 * @param entityManager 	Holds the instance of EntityManager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/**
	 * This method gets the entityManager.
	 * @return EntityManager	The entityManager.
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * This method persists an object in the database.
	 * @param baseDO 		Holds the instance to be persisted.
	 * @return BaseDO		The persisted BaseDO object.
	 */
	public BaseDO save(final BaseDO baseDO) {
		this.getEntityManager().persist(baseDO);
		return baseDO;
	}
	
	/**
	 * This method retrieves the object based on the primary key.
	 * @param key 				Holds the primary key for the row
	 * 							in the database from which
	 * 							the object has to be retrieved.
	 * @return BaseDO			The retrieved BaseDO object.
	 */
	public BaseDO findByPrimaryKey(final Object key) {
		final BaseDO baseDO = (BaseDO)getEntityManager().find(getObjectType(), key);
		return baseDO;
	}
	/**
	 * This method updates the state of the given BaseDO
	 * with the one existing.
	 * @param baseDO 			Holds the entity to be merged.
	 * @return BaseDO			The updated BaseDO object.
	 */
	public BaseDO update(final BaseDO baseDO) {
		return getEntityManager().merge(baseDO);
	}
	/**
	 * This method removes the given object from the database
	 * based on the key.
	 * @param key			Holds the key for the entity
	 * 						to be removed.
	 */
	public void deleteByKey(final Object key) {
		final BaseDO baseDO = (BaseDO)getEntityManager().getReference(getObjectType(), key);
		if(baseDO != null) {
			this.getEntityManager().remove(baseDO);
		}
	}
	/**
	 * This method removes the given object from the database
	 * based on the entity.
	 * @param baseDO 			Holds the entity to be removed.
	 */
	public void delete(BaseDO baseDO) {
		//baseDO = this.makeObjectPersistent(baseDO);
		getEntityManager().remove(baseDO);
	}
	/**
	 * This method retrieves all the objects from the database
	 * for the entity.
	 * @return List				The list of the entities.
	 */
	public List findAll() {
		//return (List) getEntityManager().createQuery("FROM " + getObjectType().getSimpleName()).setHint("org.hibernate.cacheable", true).getResultList();
		return  (List) getEntityManager().createQuery("FROM " + getObjectType().getSimpleName()).getResultList();
    }
	/**
	 * This abstract method returns the Class of the Entity
	 * the DAO is mapped to.
	 * @return Class			The Class of the Entity.
	 */
	public abstract Class getObjectType();
		
	/**
	 * This method merges the entity. This is required while deleting the entity.
	 * @param baseDO 			The entity to be merged.
	 * @return BaseDO			The updated BaseDO object.
	 */
    private BaseDO makeObjectPersistent(final BaseDO baseDO) {
    	return getEntityManager().merge(baseDO);
    }
}