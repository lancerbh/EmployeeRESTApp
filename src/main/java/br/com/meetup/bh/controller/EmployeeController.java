/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package br.com.meetup.bh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.meetup.bh.dao.EmployeeDAO;
import br.com.meetup.bh.dao.impl.EmployeeDAOImpl;
import br.com.meetup.bh.entity.Employee;

//@CrossOrigin
//@RestController
//@RequestMapping("/employees")
public class EmployeeController {

//	private EmployeeDAO edao = new EmployeeMockDAOImpl();
	private EmployeeDAO edao = new EmployeeDAOImpl();

	// Get all employees
//	@RequestMapping(method = RequestMethod.GET)
	public Employee[] getAll() {

		List<Employee> matchList = edao.getAllEmployees();

		if (matchList.size() > 0) {
			return matchList.toArray(new Employee[0]);
		} else {
			return null;
		}

	}

	// Get an employee
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Employee> get(@PathVariable long id) {

		Employee match = edao.getEmployee(id);

		if (match != null) {
			return new ResponseEntity<>(match, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Get employees by lastName
	@RequestMapping(method = RequestMethod.GET, value = "/lastname/{name}")
	public ResponseEntity<Employee[]> getByLastName(@PathVariable String name) {

		List<Employee> matchList = edao.getByLastName(name);

		if (matchList.size() > 0) {
			return new ResponseEntity<Employee[]>(matchList.toArray(new Employee[0]), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee[]>(HttpStatus.NOT_FOUND);
		}

	}

	// Get employee by title
	@RequestMapping(method = RequestMethod.GET, value = "/title/{name}")
	public ResponseEntity<Employee[]> getByTitle(@PathVariable String name) {

		List<Employee> matchList = edao.getByTitle(name);

		if (matchList.size() > 0) {
			return new ResponseEntity<Employee[]>(matchList.toArray(new Employee[0]), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee[]>(HttpStatus.NOT_FOUND);
		}
	}

	// Get employee by dept
	@RequestMapping(method = RequestMethod.GET, value = "/department/{name}")
	public ResponseEntity<Employee[]> getByDept(@PathVariable String name) {

		List<Employee> matchList = edao.getByDepartment(name);

		if (matchList.size() > 0) {
			return new ResponseEntity<Employee[]>(matchList.toArray(new Employee[0]), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee[]>(HttpStatus.NOT_FOUND);
		}
	}

	// Add an employee
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Employee employee) {
		if (edao.add(employee)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update an employee
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Employee employee) {
		if (edao.update(id, employee)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a employee
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {

		boolean result = edao.delete(id);

		if (result) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}