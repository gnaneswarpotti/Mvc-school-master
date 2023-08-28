package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.Student;
import com.ty.srevice.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/loadstudent")
	public ModelAndView loadStudent() {
		ModelAndView modelAndView = new ModelAndView("savestudent.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}
	
	@RequestMapping("/savestudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		ModelAndView modelAndView = new ModelAndView("studentmenu.jsp");
		modelAndView.addObject("studentmsg", "login successfully");
		return modelAndView;
	}
	
}
