/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.gd.demo.bean.Course;
import org.gd.demo.bean.Student;
import org.gd.demo.dao.StudentDao;
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
    
    public List<Student> getAllStudents() {
        List<Student> students = studentDao.getAllStudent();
        return students;
    }

    /**
     *
     * @param studentID
     * @return
     */
    public Set<Course> getStudentWiseCourse(long studentID) {
        Set<Course> courses = studentDao.getCoursesByStudentID(studentID);
        return courses;
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
