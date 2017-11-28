package com.itqiwen.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSIONFACTORY;
    private static final Configuration CONFIGURE;

    static {
        /**
         * 加载配置文件，默认加载 src 目录下的配置文件
         */
        CONFIGURE = new Configuration().configure();
        /**
         * 创建 SessionFactory 对象
         */
        SESSIONFACTORY = CONFIGURE.buildSessionFactory();
    }

    public static Session getSession(){
        /**
         * 创建 session 对象
         */
        return SESSIONFACTORY.openSession();
    }
}
