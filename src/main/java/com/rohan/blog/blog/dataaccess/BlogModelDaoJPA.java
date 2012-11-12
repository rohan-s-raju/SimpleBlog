package com.rohan.blog.blog.dataaccess;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.rohan.blog.entity.Blog;
import com.rohan.blog.framework.dataaccess.BaseDaoImpl;


@Repository("blogModelDao")
public class BlogModelDaoJPA extends BaseDaoImpl implements BlogModelDao {

	
	public BlogModelDaoJPA(){
	}

	
	@Override
	public EntityManager getEntityManager() {
		return super.getEntityManager();
	}

	/**
	 * This method is implementation of the getObjectType() abstract method of
	 * BaseDaoImpl. 
	 * 
	 * @return Class  returns the Class of the Entity the DAO is mapped to.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Class getObjectType() {
		return Blog.class;
	}
	
	
}














