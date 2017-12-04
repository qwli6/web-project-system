package com.itqiwen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/index")
    public String index(){

        System.out.println("访问 index");
        return "index";
    }
}
