package com.factory.bean.driver;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.factory.bean.example.Employee;

public class EmployeeBFDemo {

	private static Logger logger = Logger.getLogger(EmployeeBFDemo.class.getName());
	public static void main(String[] args) {

		// get an instance of bean factory
		//ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean.xml");
		
		ApplicationContext context = new FileSystemXmlApplicationContext("employee-bean.xml");

		Employee emp1 = (Employee) context.getBean("employee");
		logger.info(emp1.getCompanyName() + "..." + emp1.getName());
	}
}
