package com.rohan.blog.authentication.dataaccess;

import com.rohan.blog.common.dataaccess.BaseDao;
import com.rohan.blog.entity.Person;

public interface PersonModelDao  extends BaseDao {

	public Person getPersonByLogin(String login);
}
