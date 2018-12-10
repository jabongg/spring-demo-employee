package com.factory.bean.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.learning.employee.dto.UserDetails;
import com.spring.learning.employee.dto.Vehicle;

public class ManyToOneEntityMappingDriver {

	public static void main(String[] args) {

        try {
           	// getting session instance from session factory
        	Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();


        	UserDetails user = new UserDetails();
        	user.setUserName("Michael Page");
        
        	List<Vehicle> vehicles = new ArrayList<>();
        	
        	Vehicle vehicle1 = new Vehicle();
        	vehicle1.setVehicleName("Bugati chiron");
 	        vehicle1.setUser(user);
        	
        	Vehicle vehicle2 = new Vehicle();
        	vehicle2.setVehicleName("Porsche 911");
 	        vehicle2.setUser(user);
        	
        	vehicles.add(vehicle1);
        	vehicles.add(vehicle2);
        	
        	user.setVehicle(vehicles);
        	
        	session.save(user);  //saving user
        	//session.save(vehicle); //saving vehicle
        	
			t.commit();
			System.out.println("successfully saved");
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
