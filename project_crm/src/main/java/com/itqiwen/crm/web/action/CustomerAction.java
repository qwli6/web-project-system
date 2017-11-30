package com.itqiwen.crm.web.action;

import com.itqiwen.crm.entity.Customer;
import com.itqiwen.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Scope(value = "prototype")
@Controller
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();


    @Resource
    private CustomerService customerService;

    public String test(){

        System.out.println("访问action");
        return NONE;
    }

    public Customer getModel() {
        return customer;
    }
}
