package com.factory.bean.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.learning.employee.controller.EmployeeController;
import com.spring.learning.employee.dto.EmployeeDTO;

public class TestSpringContext {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("application-context.xml");
		EmployeeController ctrl = (EmployeeController) context.getBean("employeeController");
		EmployeeDTO emp = ctrl.createNewEmployee();
		
		System.out.print(emp);
	}
}
