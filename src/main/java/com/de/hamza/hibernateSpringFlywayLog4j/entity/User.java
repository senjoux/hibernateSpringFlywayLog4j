 /***********************************************
 *                                              *
 *     Copyright (C) Azyrox Consulting          *
 *                                              *
 *             All rights reserved.             *
 *                                              *
 ***********************************************/
package com.de.hamza.hibernateSpringFlywayLog4j.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <!-- Description -->
 *
 * @author  {Hamza Hedhly}
 * @createDate {2018-09-23}
 */
@Entity(name="utilisateur")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="prenom")
	private String firstName;
	
	@Column(name="nom")
	private String lastName;

	public User() {}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}