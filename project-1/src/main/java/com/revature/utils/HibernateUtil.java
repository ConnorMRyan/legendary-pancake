package com.revature.utils;

import com.revature.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class HibernateUtil {
    private static Session session;
    private static final Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    private static SessionFactory sf = configuration.buildSessionFactory();

    public static Session getSession() {
        if(session == null){
            session = sf.openSession();
        }
        return session;
    }

    public static void closeSession(){
        session.close();
        session = null;
    }
}
