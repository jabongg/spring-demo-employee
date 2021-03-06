package com.factory.bean.driver;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.learning.dto.Address;
import com.spring.learning.dto.EmployeeDTO;

public class HibernateTester {

	public static void main(String[] args) {

        try {

        	Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			// Check MySQL database version
			String sql = "select version()";
			String result = (String) session.createNativeQuery(sql).getSingleResult();
			System.out.println("MySql Database Version is:::");
			System.out.println(result);

			List<Address> addresses = new ArrayList<>();
			
	        Address add1 = new Address();
	        add1.setStreet("U - 16/81");
	        add1.setCity("Gurgaon");
	        add1.setState("Haryana");
	        add1.setCountry("India");
	        
	        
	        
	        Address add2 = new Address();
	        add2.setStreet("U - 16/81");
	        add2.setCity("Varansi");
	        add2.setState("UP");
	        add2.setCountry("India");

	        
	        
	        Address add3 = new Address();
	        add3.setStreet("250 D");
	        add3.setCity("Los Angeles");
	        add3.setState("Los Angeles");
	        add3.setCountry("United States");

	        addresses.add(add1);
	        addresses.add(add2);
	        addresses.add(add3);
	        
			EmployeeDTO e1 = new EmployeeDTO();
			//e1.setId(101);
			e1.setFirstName("Whipsy");
			e1.setLastName("Tony");
			e1.setAddress(addresses);
			e1.setSalary(80000);
			session.save(e1);

			EmployeeDTO e2 = new EmployeeDTO();
			//e2.setId(102);
			e2.setFirstName("Mike");
			e2.setLastName("Hike");
			e2.setAddress(addresses);
			e2.setSalary(5000);
			session.save(e2);

	        EmployeeDTO obj = new EmployeeDTO();
	        //obj.setId(103);
	        obj.setFirstName("Emmanuel");
	        obj.setLastName("Ferris");
	        obj.setAddress(addresses);
	        obj.setSalary(70000);
	        session.save(obj);
	
	        
			t.commit();
			System.out.println("successfully saved");
			session.close();
			
			session = HibernateUtil.getSessionFactory().openSession();
			EmployeeDTO emp = session.load(EmployeeDTO.class, 4);
			System.out.println(emp);
			
			session.close();
			System.out.println(emp.getAddress().size());

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
