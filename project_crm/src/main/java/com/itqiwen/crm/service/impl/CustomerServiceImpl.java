package com.itqiwen.crm.service.impl;

import com.itqiwen.crm.dao.CustomerDao;
import com.itqiwen.crm.entity.Customer;
import com.itqiwen.crm.service.CustomerService;
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
}
