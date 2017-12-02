package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.domain2.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;
import javax.persistence.criteria.CriteriaBuilder;

public class JpaTest {

    @Test
    public void createTabl(){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJpa");
        factory.close();
    }

    @Test
    public void save(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJpa");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        Customer customer = new Customer();
        customer.setName("张三");
        manager.persist(customer);//持久化实体
        manager.getTransaction().commit();


    }
}
