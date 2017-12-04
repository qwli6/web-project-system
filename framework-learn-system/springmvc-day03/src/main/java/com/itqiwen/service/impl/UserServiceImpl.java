package com.itqiwen.service.impl;

import com.itqiwen.dao.UserDao;
import com.itqiwen.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

}
