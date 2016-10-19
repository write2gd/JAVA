package org.gd.demo.manytomanybidirectional.annotation;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gouranga Das
 */
public class ManyToManyBidirectionalDemo {

    /**
     * @param args accepts variable arguments
     */
    public static void main(String[] args) {
        //Persisting StudentTest and CourseTest objects
        Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        StudentTest student1 = new StudentTest();
        student1.setStudentName("Nagendra Kumar");

        StudentTest student2 = new StudentTest();
        student2.setStudentName("Gouranga Das");

        CourseTest course1 = new CourseTest();
        course1.setCourseName("English");

        CourseTest course2 = new CourseTest();
        course2.setCourseName("Computer");

        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course1);
        student2.addCourse(course2);

        session.save(student1);
        session.save(student2);
        tx.commit();
        session.close();
        
        Session sessionTwo = HibernateAnnotationUtil.getSessionFactory().openSession();
        Transaction txTwo = sessionTwo.beginTransaction();
        List studentList = sessionTwo.createQuery(" from Student ").list(); 
        System.out.println("*****************************************");
 
        studentList.parallelStream().forEach((student)->{ 
            System.out.println("Student Name is " + ((StudentTest) student).getStudentName());
            (((StudentTest) student).getCourses()).parallelStream().forEach((course) -> {
                System.out.println(((CourseTest) course).getCourseName());
            });
        });
        System.out.println("*****************************************");
  
        txTwo.commit();
        sessionTwo.close();

        HibernateAnnotationUtil.shutdown();
        System.out.println("*******Done*******");

    }

}
