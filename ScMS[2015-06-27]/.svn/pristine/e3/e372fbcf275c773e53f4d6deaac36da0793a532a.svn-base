/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author JAY KUMAR
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml) 
                // config file.
                sessionFactory = Handler.setProps(new AnnotationConfiguration()
                        .configure())
                        .buildSessionFactory();
//            Session session = sessionFactory.openSession();
//            session.close();
//            dbupdate.DbUpdateExecuter.execute();
            } catch (Throwable ex) {
                // Log the exception. 
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
        sessionFactory = null;
    }
}
