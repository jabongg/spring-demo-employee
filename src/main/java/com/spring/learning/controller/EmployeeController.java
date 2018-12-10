package com.spring.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.learning.dto.EmployeeDTO;
import com.spring.learning.service.EmployeeService;

//@Component("employeeController")
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	public EmployeeDTO createNewEmployee() {
		return employeeService.createNewEmployee();
	}
}
