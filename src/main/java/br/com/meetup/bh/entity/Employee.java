
/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package br.com.meetup.bh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Employee {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="ID")
	private final long id;
//	@Column(name="FIRSTNAME")
	private final String firstName;
//	@Column(name="LASTNAME")
	private final String lastName;
//	@Column(name="EMAIL")
	private final String email;
//	@Column(name="PHONE")
	private final String phone;
//	@Column(name="BIRTHDATE")
	private final String birthDate;
//	@Column(name="TITLE")
	private final String title;
//	@Column(name="DEPARTMENT")
	private final String department;

	public Employee() {
		super();
		id = 0;
		firstName = "";
		lastName = "";
		email = "";
		phone = "";
		birthDate = "";
		title = "";
		department = "";
	}

	public Employee(long id, String firstName, String lastName, String email, String phone, String birthDate,
			String title, String department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.title = title;
		this.department = department;
	}

	public long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDepartment() {
		return this.department;
	}

	@Override
	public String toString() {
		return "ID: " + id + " First Name: " + firstName + " Last Name: " + lastName + " EMail: " + email + " Phone: "
				+ phone + " Birth Date: " + birthDate + " Title: " + title + " Department: " + department;
	}

}