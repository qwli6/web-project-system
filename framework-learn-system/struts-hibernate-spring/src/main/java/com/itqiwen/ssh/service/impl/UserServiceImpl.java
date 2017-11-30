package com.itqiwen.ssh.service.impl;

import com.itqiwen.ssh.dao.UserDao;
import com.itqiwen.ssh.entity.User;
import com.itqiwen.ssh.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void userLogin() {
        System.out.println("调用 service 层");
        userDao.userLogin();
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }
}
