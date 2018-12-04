package com.spring.learning.employee.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.factory.bean.driver.HibernateUtil;
import com.spring.learning.employee.dao.EmployeeDAO;
import com.spring.learning.employee.dto.EmployeeDTO;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	public EmployeeDTO createNewEmployee() {
		
		// lets create new employee here
		EmployeeDTO emp = new EmployeeDTO();
		
		   try (Session session = HibernateUtil.getSessionFactory().openSession()) {

				Transaction t = session.beginTransaction();
				// Check MySQL database version
				String sql = "select version()";
				String result = (String) session.createNativeQuery(sql).getSingleResult();
				System.out.println("MySql Database Version is:::");
				System.out.println(result);


				emp.setFirstName("Julien");
				emp.setLastName("Moore");
				session.save(emp);
				
				t.commit();
				System.out.println("successfully saved");
				session.close();

			} catch (HibernateException e) {
				e.printStackTrace();
			}
		return emp;
		
	}
}
