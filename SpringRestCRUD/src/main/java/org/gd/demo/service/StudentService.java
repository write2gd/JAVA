/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.service;

import java.util.List;
import org.gd.demo.bean.Course;
import org.gd.demo.bean.Student;
import org.gd.demo.dao.StudentDao;

/**
 *
 * @author dasg
 */
public class StudentService {
    StudentDao studentDao;

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
    public List<Course> getStudentWiseCourse(int studentID) {
        List<Course> courses = studentDao.getCoursesByStudentID(studentID);
        return courses;
    }
}
