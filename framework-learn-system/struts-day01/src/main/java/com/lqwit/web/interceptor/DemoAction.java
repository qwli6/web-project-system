package com.lqwit.web.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport {

    public String testInterceptor(){
        System.out.println("执行 action 方法");
        return NONE;
    }
}
