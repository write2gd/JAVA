/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.gd.demo.bean.CourseBean;
import org.gd.demo.bean.StudentBean;

import org.gd.demo.dao.StudentDao;
import org.gd.demo.entity.Course;
import org.gd.demo.entity.Student;
import org.springframework.stereotype.Service;

/**
 *
 * @author dasg
 */
@Service
public class StudentService {
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public List<StudentBean> getAllStudents() {
        List<Student> students = studentDao.getAllStudent();
        List<StudentBean> studentBeans =  new ArrayList<>();
        
        students.parallelStream().forEach((student)->{ 
            StudentBean studentBean = new StudentBean();
            studentBean.setStudentName(student.getStudentName());
             Set<String> courseset = new HashSet();
            student.getCourses().parallelStream().forEach((course) -> {
            courseset.add(course.getCourseName());
            });
            studentBean.setCourses(courseset);
            studentBeans.add(studentBean);
        });
        return studentBeans;
    }

    /**
     *
     * @param studentID
     * @return
     */
    public List<CourseBean> getStudentWiseCourse(long studentID) {
       Student student= studentDao.getStudentByID(studentID);
        Set<Course> courseset = new HashSet();
        if(student != null){
            courseset = student.getCourses();
        }        
        List<CourseBean> courseList = new ArrayList<>();
        courseset.parallelStream().forEach((course) -> {
            CourseBean courseBean = new CourseBean();
            courseBean.setId(course.getId());
               courseBean.setCourseName(course.getCourseName());   
               courseBean.setStudentName(student.getStudentName());
               courseList.add(courseBean);
            });        
        return courseList;
    }

    public Serializable saveStudent(String name) {
        Student s = new Student();
        s.setStudentName(name);
        Course c = new Course();
        c.setCourseName("Test"+ name);
        s.addCourse(c);
        return studentDao.save(s);
        
    }
}
