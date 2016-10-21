/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.dao;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.gd.demo.bean.CourseBean;
import org.gd.demo.entity.Course;
import org.gd.demo.entity.Student;
import org.gd.demo.manytomanybidirectional.annotation.CourseTest;
import org.gd.demo.manytomanybidirectional.annotation.StudentTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dasg
 */
@Repository
public class StudentDao {
     private SessionFactory sessionFactory;
     private StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

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

    public Student getStudentByID(long studentID) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student std = session.get(Student.class,studentID);       
        session.flush();
        tx.commit();         
        return std;
    }

    public Serializable save(Student s) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Serializable result = session.save(s);
        session.flush();
        tx.commit(); 
        return result;
    }
    
}
