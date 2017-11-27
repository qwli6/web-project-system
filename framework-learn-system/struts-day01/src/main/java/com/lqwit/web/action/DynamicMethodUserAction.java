package com.lqwit.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class DynamicMethodUserAction extends ActionSupport{

    public String register(){

        return "save";
    }

    public String login(){

        return "login";
    }
}
