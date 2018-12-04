package com.spring.learning.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.spring.learning.employee.dao.EmployeeDAO;
import com.spring.learning.employee.dto.EmployeeDTO;
import com.spring.learning.employee.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Bean
	public EmployeeDTO createNewEmployee() {
		return employeeDAO.createNewEmployee();
	}

}
