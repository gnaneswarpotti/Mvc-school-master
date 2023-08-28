package com.ty.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ty.dto.Student;

@Component
public class StudentDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Student saveStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student getStudent(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select s from Student s where id=?1");
		query.setParameter(1, id);
		List<Student> students = query.getResultList();

		return students.get(0);
	}
	
	public Student getStudent(String rollNumber) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select s from Student s where id=?1");
		query.setParameter(1, rollNumber);
		List<Student> students = query.getResultList();

		return students.get(0);
	}

	public List<Student> getAllStudent() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select s from Student s");
		return query.getResultList();
	}

	public Student updateStudent(Student student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student2 = entityManager.find(Student.class, student.getId());
		if (student2 != null) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		} else {
			return null;
		}
	}

	public String deleteStudent(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return "Student data is deletd";
		} else {
			return "Student Id is not found";
		}
	}

	public Student validateStudent(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select s from Student s where email?=1 and password?=2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<Student> students = query.getResultList();
		return students.get(0);
	}
}
