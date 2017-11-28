package com.lqwit.web.action_c;

import com.opensymphony.xwork2.ActionSupport;


public class TwoAction extends ActionSupport{

    public String addTwoUser(){
        System.out.println("我是第二个 Action");
        return SUCCESS;
    }
}
