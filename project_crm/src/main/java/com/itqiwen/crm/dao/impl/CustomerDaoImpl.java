package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.CustomerDao;
import com.itqiwen.crm.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void saveCustomer(Customer customer) {

    }
}
