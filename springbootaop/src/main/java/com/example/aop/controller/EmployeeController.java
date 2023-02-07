package com.example.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.annotation.CustomAnnotation;
import com.example.aop.model.Employee;
import com.example.aop.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping("/employees/{id}")
	@CustomAnnotation
	public Employee findById(@PathVariable(value = "id") Integer id) {
		return employeeService.findById(id);
	}

}
