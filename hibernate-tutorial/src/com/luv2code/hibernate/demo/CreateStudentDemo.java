package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// get a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);
			
			// quuery students: lastName='Doe' Or firstname='Daffy'
			theStudents = 
					session.createQuery("from Student s where"
							+ " s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();
			
			// display the students
			System.out.println("\n\nStudent who have last name of Doe or firstName Daffy ");
			displayStudents(theStudents);
			
			// query students where email LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%luv2code.com'").getResultList();
			
			// display the student
			System.out.println("\n\n students who have email like '%luv2code.com'");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
