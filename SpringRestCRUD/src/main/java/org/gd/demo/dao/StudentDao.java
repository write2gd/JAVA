/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.gd.demo.bean.Course;
import org.gd.demo.bean.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author dasg
 */
public class StudentDao {
     private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
     public void addStudent(Student std){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(std);
        session.flush();
        tx.commit();                
     }
     
      @Transactional
     public List<Student> getAllStudent(){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List studentlist = session.createCriteria(Student.class).list();
        session.flush();
        tx.commit(); 
        return studentlist;
     }

    public List<Course> getCoursesByStudentID(int studentID) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List courseList = session.createCriteria(Course.class).list();
        session.flush();
        tx.commit(); 
        return courseList;
    }
    
}
