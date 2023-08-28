package com.ty.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ty.dto.Teacher;
 
@Component
public class TeacherDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Teacher saveTeacher(Teacher teacher) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		return teacher;
	}
	
	public Teacher getTeacher(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select t from Teacher t where id?=1");
		query.setParameter(1, id); 
		List<Teacher> teachers = query.getResultList();
		return teachers.get(0);
	}
	
	public List<Teacher> getTeacher(String subject) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select t from Teacher t where subject?=1");
		query.setParameter(1, subject); 

		return query.getResultList();
	}
	
	public List<Teacher> getAllTeacher(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select t from Teacher t");
		return query.getResultList();
	}
	
	public Teacher validateTeacher(String email,String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select t from Teacher t where email?=1 and password?=2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Teacher> teachers = query.getResultList();
		return teachers.get(0);
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Teacher teacher2 = entityManager.find(Teacher.class, teacher.getId());
		if(teacher2 != null) {
			entityTransaction.begin();
			entityManager.merge(teacher);
			entityTransaction.commit();
			return teacher;
		}else {
			return null;
		}
	}
	
	public String deleteTeacher(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Teacher teacher = entityManager.find(Teacher.class, id);
		if(teacher != null) {
			entityTransaction.begin();
			entityManager.merge(teacher);
			entityTransaction.commit();
			return "Teacher data is deleted";
		}else {
			return "Teacher id is not found";
		}
	}
}
