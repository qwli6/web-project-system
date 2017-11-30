package com.itqiwen.crm.dao;

import com.itqiwen.crm.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findUserByUserCode(User user);

    void saveUser(User user);

    User findUser(User user);
}
