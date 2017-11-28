package com.itqiwen.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory SESSIONFACTORY;
    public static final Configuration CONFIGURE;

    static {
        CONFIGURE = new Configuration().configure();
        SESSIONFACTORY = CONFIGURE.buildSessionFactory();
    }

    public static Session getSession(){
        return SESSIONFACTORY.openSession();
    }
}
