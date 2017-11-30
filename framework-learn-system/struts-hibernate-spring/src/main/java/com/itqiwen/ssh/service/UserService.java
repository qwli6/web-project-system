package com.itqiwen.ssh.service;

import com.itqiwen.ssh.entity.User;

public interface UserService {
    void userLogin();

    //新增User
    void saveUser(User user);


    //修改 User
    void updateUser(User user);

    User findUserByName(String name);
}
