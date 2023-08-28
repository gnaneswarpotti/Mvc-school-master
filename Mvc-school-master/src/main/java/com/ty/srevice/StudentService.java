package com.ty.srevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.StudentDao;
import com.ty.dto.Student;

@Component
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}
	public Student getStudent(String rollNumber) {
		return studentDao.getStudent(rollNumber);
	}
	public List<Student> getAllStudents(){
		return studentDao.getAllStudent();
	}
	public Student updateStudent(Student stduent) {
		return studentDao.updateStudent(stduent);
	}
	public String deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}
	public Student validateStudent(String email,String password) {
		return studentDao.validateStudent(email, password);
	}
}
