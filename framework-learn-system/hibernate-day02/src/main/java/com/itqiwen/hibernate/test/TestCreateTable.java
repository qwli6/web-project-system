package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;

public class TestCreateTable {
    @Test
    public void createTable(){
        HibernateUtil.getSession();
    }

    /**
     * 5.2 以后推荐用这种方式获取 sessionFactory
     */
    @Test
    public void createTable2(){
        StandardServiceRegistry registryBuilder =
                new StandardServiceRegistryBuilder()
                        .configure()//加载 classpath 下的 hibernate.cfg.xml 配置文件
                        .build();
        try {

            SessionFactory sessionFactory =
                    new MetadataSources(registryBuilder)
                            .buildMetadata()
                            .buildSessionFactory();
            EntityManager entityManager = sessionFactory.createEntityManager();


        }catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registryBuilder);
        }
    }
}
