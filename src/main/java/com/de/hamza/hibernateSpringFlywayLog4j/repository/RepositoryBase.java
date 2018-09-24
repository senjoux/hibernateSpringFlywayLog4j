 /***********************************************
 *                                              *
 *     Copyright (C) Azyrox Consulting          *
 *                                              *
 *             All rights reserved.             *
 *                                              *
 ***********************************************/
package com.de.hamza.hibernateSpringFlywayLog4j.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <!-- Description -->
 *
 * @author  {Hamza Hedhly}
 * @createDate {2018-09-23}
 */
public abstract class RepositoryBase{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

}
