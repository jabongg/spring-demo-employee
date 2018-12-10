package com.factory.bean.driver;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.spring.learning.dto.Doctor;
import com.spring.learning.dto.FamilyPhysician;
import com.spring.learning.dto.Surgeon;

public class InheritenceLogicEntities {
	public static void main(String[] args) {

        try {
           	// getting session instance from session factory
        	Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction t = session.beginTransaction();
        	
			Doctor doctor = new Doctor();
			doctor.setDoctorName("Dr. Arsad");
			
			
			Surgeon surgeon = new Surgeon();
			surgeon.setDoctorName("Dr. Lohia");
			surgeon.setDoesSurgery(true);
			
			
			FamilyPhysician fp = new FamilyPhysician();
			fp.setDoctorName("Dr. Kartavya Shaah");
			fp.setGivesAdvice(true);
			
        	session.save(doctor); 
        	session.save(surgeon); 
        	session.save(fp); 
        	
			t.commit();
			System.out.println("successfully saved");
			session.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
