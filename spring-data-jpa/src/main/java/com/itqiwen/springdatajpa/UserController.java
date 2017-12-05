package com.itqiwen.springdatajpa;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/list")
    public String list(){
        return userRepository.findOne(6L).toString();
    }
}
