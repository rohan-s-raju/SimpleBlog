package com.rohan.blog.authentication.dataaccess;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.rohan.blog.common.dataaccess.BaseDaoImpl;
import com.rohan.blog.entity.Person;

@Repository("personModelDao")
public class PersonModelDaoJPA extends BaseDaoImpl implements PersonModelDao {
	
	@Override
	public EntityManager getEntityManager() {
		return super.getEntityManager();
	}
    
	
	@Override
	public Person getPersonByLogin(String login) {
		return (Person) getEntityManager().createQuery("select p from Person p where p.username = :login").setParameter("login", login).getSingleResult();		
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return Person.class;
	}

}
