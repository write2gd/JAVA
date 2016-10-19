/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gd.demo.manytomanybidirectional.annotation;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author dasg
 */
public class HibernateAnnotationUtil {
    
 private static SessionFactory sessionFactory;
    private static StandardServiceRegistryBuilder serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration().configure("config/annotation.hibernate.cfg.xml");
            configuration.addAnnotatedClass(CourseTest.class);
            configuration.addAnnotatedClass(StudentTest.class);
            

            serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());
        } catch (HibernateException he) {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}

