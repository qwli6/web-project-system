package com.itqiwen.crm.service;

import com.itqiwen.crm.entity.Customer;
import com.itqiwen.crm.entity.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {

    void saveCustomer(Customer customer);

    PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);
}
