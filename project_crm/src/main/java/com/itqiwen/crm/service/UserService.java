package com.itqiwen.crm.service;

import com.itqiwen.crm.entity.User;

import java.util.List;

public interface UserService {
    List<User> findUserByUserCode(User user);

    void saveUser(User user);

    User findUser(User user);
}
