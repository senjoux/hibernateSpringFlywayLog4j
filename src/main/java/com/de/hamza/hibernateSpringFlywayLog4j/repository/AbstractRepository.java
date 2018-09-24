 /***********************************************
 *                                              *
 *     Copyright (C) Azyrox Consulting          *
 *                                              *
 *             All rights reserved.             *
 *                                              *
 ***********************************************/
package com.de.hamza.hibernateSpringFlywayLog4j.repository;

/**
 * <!-- Description -->
 *
 * @author  {Hamza Hedhly}
 * @createDate {2018-09-23}
 */
public interface AbstractRepository<X,I> {
	
	void add(X x);
	X findById(I id);
	void update(I id, X update);
	void delete(I id);
}
