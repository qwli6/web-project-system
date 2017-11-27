package com.lqwit.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class MulMethodAction extends ActionSupport{

    public String saveUser(){
        System.out.println("保存用户");
        return "save";
    }

    public String updateUser(){
        System.out.println("修改用户");
        return "update";
    }

    public String deleteUser(){
        System.out.println("删除用户");
        return "delete";
    }
}
