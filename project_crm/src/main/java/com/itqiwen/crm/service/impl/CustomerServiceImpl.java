package com.itqiwen.crm.service.impl;

import com.itqiwen.crm.dao.CustomerDao;
import com.itqiwen.crm.entity.Customer;
import com.itqiwen.crm.entity.PageBean;
import com.itqiwen.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;

    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
        return customerDao.findByPage(criteria, pageCode, pageSize);
    }
}
