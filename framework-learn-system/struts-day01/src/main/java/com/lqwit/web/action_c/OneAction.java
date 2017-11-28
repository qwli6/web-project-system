package com.lqwit.web.action_c;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 测试 Action 的跳转
 */
public class OneAction extends ActionSupport{

    public String addUser(){
        System.out.println("我是 OneAction");
        return SUCCESS;
    }
}
