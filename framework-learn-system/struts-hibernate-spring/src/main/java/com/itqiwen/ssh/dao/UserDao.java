package com.itqiwen.ssh.dao;

import com.itqiwen.ssh.entity.User;

public interface UserDao {
    void userLogin();

    void saveUser(User user);

    void updateUser(User user);

    User findUserByName(String name);
}
