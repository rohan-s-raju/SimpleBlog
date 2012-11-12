package com.rohan.blog.authentication.dataaccess;

import com.rohan.blog.entity.Person;
import com.rohan.blog.framework.dataaccess.BaseDao;

public interface PersonModelDao  extends BaseDao {

	public Person getPersonByLogin(String login);
}
