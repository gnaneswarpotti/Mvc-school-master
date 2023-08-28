package com.ty.srevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.TeacherDao;
import com.ty.dto.Teacher;

@Component
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;
	
	public Teacher saveTeacher(Teacher teacher) {
		return teacherDao.saveTeacher(teacher);
	}
	public Teacher getTeacher(int id) {
		return teacherDao.getTeacher(id);
	}
	public List<Teacher> getTeacher(String subject){
		return teacherDao.getTeacher(subject);
	}
	public List<Teacher> getAllTeacher(){
		return teacherDao.getAllTeacher();
	}
	public Teacher validateTeacher(String email,String password) {
		return teacherDao.validateTeacher(email, password);
	}
	public Teacher updateTeacher(Teacher teacher) {
		return teacherDao.updateTeacher(teacher);
	}
	public String deleteTeacher(int id) {
		return teacherDao.deleteTeacher(id);
	}
}
