package com.factory.bean.driver;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.learning.dto.UserDetails;

public class UnderstandingSessionDemo {
	public static void main(String[] args) {
		try {
			
			// a newly created object in transient state
			UserDetails user1 = new UserDetails();
			user1.setUserName("ChristianBale");
			
			
			
			// getting session instance from session factory
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
			
			session.save(user1); // object being attached to session here.
								 // object in persistent state
			
			user1.setUserName("Gerard Butler");
			user1.setUserName("Hugh Jackman"); // update is reflected immediately to database.

			t.commit(); // no data is written to database until transaction is committed.
			System.out.println("successfully saved");
			session.close(); // session is closed
			
			user1.setUserName("Michael Jordan"); // since session is closed, so object is in detached state.
												// changes not reflected to the database;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
