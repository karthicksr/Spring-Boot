package com.example.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aop.model.Employee;
import com.example.aop.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findById(Integer id) {
		return employeeRepository.findById(id).orElseThrow();
	}

}
