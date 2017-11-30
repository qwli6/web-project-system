package com.itqiwen.ssh.test;


import com.itqiwen.ssh.entity.User;
import com.itqiwen.ssh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCrud {

    @Resource
    private UserService userService;

    @Test
    public void run1(){
        User user = new User();
        user.setNickname("凤凰2");
        user.setUsername("admin");
        userService.saveUser(user);
    }

    @Test
    public void run2(){
        User admin = userService.findUserByName("admin");
        if(admin != null){
            admin.setNickname("飞流");
            userService.updateUser(admin);
        }
    }
}
