package com.factory.bean.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.learning.dto.UserDetails;
import com.spring.learning.dto.Vehicle;

public class ManyToManyEntityMappingDriver {

	public static void main(String[] args) {

        try {
           	// getting session instance from session factory
        	Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();

			List<UserDetails> users1 = new ArrayList<>();
			List<UserDetails> users2 = new ArrayList<>();
			
        	UserDetails user1 = new UserDetails();
        	user1.setUserName("Michael Page");

        	UserDetails user2 = new UserDetails();
        	user1.setUserName("Shelene Woodely");
        	
        	UserDetails user3 = new UserDetails();
        	user1.setUserName("Alaxandra Ambroissio");
        	
        	users1.add(user1);
        	users1.add(user2);
        	users2.add(user3);
        	
        	List<Vehicle> vehicles1 = new ArrayList<>();
        	List<Vehicle> vehicles2 = new ArrayList<>();

        	Vehicle vehicle1 = new Vehicle();
        	vehicle1.setVehicleName("Bugati chiron");
        	
        	Vehicle vehicle2 = new Vehicle();
        	vehicle2.setVehicleName("Porsche 911");
        	
        	Vehicle vehicle3 = new Vehicle();
        	vehicle1.setVehicleName("Pagani");
        	
        	Vehicle vehicle4 = new Vehicle();
        	vehicle2.setVehicleName("Audi R8");
        	
        	vehicles1.add(vehicle1);
        	vehicles1.add(vehicle2);
        	
        	vehicles2.add(vehicle3);
        	vehicles2.add(vehicle4);
        	
        	vehicle1.setUsers(users1);
        	vehicle2.setUsers(users2);
        	
        	
        	user1.setVehicle(vehicles1);
        	user2.setVehicle(vehicles2);
        	
        	session.save(user1); 
        	session.save(user2);
        	session.save(user3);
        	
        	session.save(vehicle1);
        	session.save(vehicle2);
        	session.save(vehicle3);
        	session.save(vehicle4);
        	
        	//saving user
        	//session.save(vehicle); //saving vehicle
        	
			t.commit();
			System.out.println("successfully saved");
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
