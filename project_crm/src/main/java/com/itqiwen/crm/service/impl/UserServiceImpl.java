package com.itqiwen.crm.service.impl;

import com.itqiwen.crm.dao.UserDao;
import com.itqiwen.crm.entity.User;
import com.itqiwen.crm.service.UserService;
import com.itqiwen.crm.utils.EncryptUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    public List<User> findUserByUserCode(User user) {
        return userDao.findUserByUserCode(user);
    }

    public void saveUser(User user) {
        user.setUserPassword(EncryptUtils.md5(user.getUserPassword()));
        user.setUserState("1");
        userDao.saveUser(user);
    }

    public User findUser(User user) {
        user.setUserPassword(EncryptUtils.md5(user.getUserPassword()));
        User u1 = userDao.findUser(user);
        if(u1 != null){
            return u1;
        }else {
            return null;
        }
    }
}
