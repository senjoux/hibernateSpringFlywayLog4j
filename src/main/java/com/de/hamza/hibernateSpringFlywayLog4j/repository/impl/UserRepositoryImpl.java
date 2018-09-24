 /***********************************************
 *                                              *
 *     Copyright (C) Azyrox Consulting          *
 *                                              *
 *             All rights reserved.             *
 *                                              *
 ***********************************************/
package com.de.hamza.hibernateSpringFlywayLog4j.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.de.hamza.hibernateSpringFlywayLog4j.entity.User;
import com.de.hamza.hibernateSpringFlywayLog4j.repository.RepositoryBase;
import com.de.hamza.hibernateSpringFlywayLog4j.repository.UserRepository;

/**
 * <!-- Description -->
 *
 * @author  {Hamza Hedhly}
 * @createDate {2018-09-23}
 */
@Repository
public class UserRepositoryImpl extends RepositoryBase implements UserRepository{

	@Transactional
	public void add(User x) {
		getCurrentSession().save(x);
	}

	@Transactional(readOnly=true)
	public User findById(Integer id) {
		return getCurrentSession().find(User.class, id);
	}

	@Transactional
	public void update(Integer id, User update) {
		getCurrentSession().update(update);
	}

	@Transactional
	public void delete(Integer id) {
		getCurrentSession().delete(findById(id));
	}

}
