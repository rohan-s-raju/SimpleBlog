
package com.rohan.blog.framework.dataaccess;

import java.util.List;

import com.rohan.blog.framework.entity.BaseDO;

/**
 * This interface provides the methods to be implemented
 * for performing the basic database operations like create
 * update,select and delete.
 * This will be implemented by the BaseDaoImpl.
 *
 */
public interface BaseDao {

	/**
	 * This method persists an object in the database.
	 * @param baseDO 			Holds the instance to be persisted.
	 * @return BaseDO			The persisted BaseDO object.
	 */
	BaseDO save(final BaseDO baseDO);
	/**
	 * This method retrieves the object based on the primary key.
	 * @param key 			Holds the primary key for the row in the
	 * 						database from which the object has to
	 * 						be retrieved.
	 * @return BaseDO		The retrieved BaseDO object.
	 */
	BaseDO findByPrimaryKey(final Object key);
	/**
	 * This method updates the state of the given BaseDO with the
	 * one existing.
	 * @param baseDO 	Holds the entity to be merged.
	 * @return BaseDO	The updated BaseDO object.
	 */
	BaseDO update(final BaseDO baseDO);
	/**
	 * This method removes the given object from the database based
	 * on the entity.
	 * @param baseDO 	Holds the entity to be removed.
	 */
	void delete(BaseDO baseDO);
	/**
	 * This method removes the given object from the database based
	 * on the key.
	 * @param key		Holds the key for the entity to be removed.
	 */
	void deleteByKey(final Object key);
	/**
	 * This method retrieves all the objects from the database for
	 * the entity.
	 * @return List				The list of the entities.
	 */
	List findAll();
	/**
	 * This method sets the entityManager.
	 * @param entityManager		The entityManager to be set.
	 */
	//void setEntityManager(final EntityManager entityManager);
	/**
     * This method returns the entityManager.
     * @return EntityManager     The EntityManager instance.
     */
	//EntityManager getEntityManager();
    }