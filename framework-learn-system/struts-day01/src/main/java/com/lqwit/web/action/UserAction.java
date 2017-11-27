package com.lqwit.web.action;

import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{

    @Override
    public String execute() throws Exception {
        System.out.println("Action 已经执行");
        return SUCCESS;
    }
}
