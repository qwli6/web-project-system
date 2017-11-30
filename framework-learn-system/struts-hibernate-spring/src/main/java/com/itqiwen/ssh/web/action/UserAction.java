package com.itqiwen.ssh.web.action;

import com.itqiwen.ssh.service.UserService;
import com.itqiwen.ssh.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


@Scope(value = "prototype")
@Controller
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;

    public String userLogin(){

        System.out.println("调用Web层");
        userService.userLogin();

        return NONE;
    }
}
