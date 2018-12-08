package com.factory.bean.driver;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.learning.employee.dto.EmployeeDTO;
import com.spring.learning.employee.dto.UserDetails;
import com.spring.learning.employee.dto.Vehicle;

public class OneToOneEntityMappingDriver {

	public static void main(String[] args) {

        try {
           	// getting session instance from session factory
        	Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();


        	UserDetails user = new UserDetails();
        	user.setUserName("Michael Page");
        
        	
        	Vehicle vehicle = new Vehicle();
        	vehicle.setVehicleName("Bugati chiron");
 	        
        	
        	user.setVehicle(vehicle);
        	
        	session.save(user);  //saving user
        	session.save(vehicle); //saving vehicle
        	
			t.commit();
			System.out.println("successfully saved");
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
