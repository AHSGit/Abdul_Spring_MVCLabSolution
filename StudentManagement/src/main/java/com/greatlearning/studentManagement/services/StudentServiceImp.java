package com.greatlearning.studentManagement.services;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.greatlearning.studentManagement.model.Student;

@Repository
public class StudentServiceImp implements StudentService {

	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	StudentServiceImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public void save(Student theStudent) {

		Transaction tx = session.beginTransaction();

		// save transaction
		session.save(theStudent);
		tx.commit();

	}

	@Transactional
	public List<Student> findAll() {

		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	@Transactional
	public Student findById(int id) {

		Student student = new Student();

		Transaction tx = session.beginTransaction();

		// find record with Id from database table
		student = session.get(Student.class, id);
		tx.commit();
		return student;
	}

	@Transactional
	public void update(Student theStudent) {

		Transaction tx = session.beginTransaction();

		session.clear();
		// save transaction
		session.update(theStudent);
		tx.commit();

	}

	@Transactional
	public void delete(int studentId) {

		Student student = new Student();

		Transaction tx = session.beginTransaction();

		// find record with Id from database table
		student = session.get(Student.class, studentId);
		session.delete(student);
		tx.commit();

	}

}
