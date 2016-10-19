/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.controller;

import java.util.List;
import org.gd.demo.bean.Country;
import org.gd.demo.bean.Course;
import org.gd.demo.bean.Student;
import org.gd.demo.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dasg
 */
@RestController
public class StudentController {
    StudentService studentService = new StudentService();
    @RequestMapping(value = "/students", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Student> getAllStudents() {
		List<Student> listOfStudents = studentService.getAllStudents();
		return listOfStudents;
	}
    
        @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Course> getCoursesByStudentID(@PathVariable int id) {
		List<Course> listOfCourses = studentService.getStudentWiseCourse(id);
		return listOfCourses;
	}
    
}
