/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.gd.demo.bean.CourseBean;
import org.gd.demo.bean.StudentBean;

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
    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @RequestMapping(value = "/students", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<StudentBean> getAllStudents() {
		List<StudentBean> listOfStudents = studentService.getAllStudents();
		return listOfStudents;
	}
    
        @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  List<CourseBean> getCoursesByStudentID(@PathVariable long id) {
		 List<CourseBean> listOfCourses = studentService.getStudentWiseCourse(id);
		return listOfCourses;
	}
         
    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/students/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllStudents(@PathVariable String name ) {
		Serializable resultStudent = studentService.saveStudent(name);
		return "ID="+resultStudent;
	}
    
}
