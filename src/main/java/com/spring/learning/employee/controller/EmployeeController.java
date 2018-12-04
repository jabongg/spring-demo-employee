package com.spring.learning.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.learning.employee.dto.EmployeeDTO;
import com.spring.learning.employee.service.EmployeeService;

//@Component("employeeController")
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	public EmployeeDTO createNewEmployee() {
		return employeeService.createNewEmployee();
	}
}
