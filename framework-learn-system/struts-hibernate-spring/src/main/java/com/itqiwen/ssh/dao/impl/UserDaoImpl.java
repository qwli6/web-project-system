package com.itqiwen.ssh.dao.impl;

import com.itqiwen.ssh.dao.UserDao;
import com.itqiwen.ssh.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;


    public void userLogin() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();
        System.out.println("用户列表为："+ userList.size());
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public User findUserByName(String name) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username =:username");
        query.setParameter("username", name);
        List<User> list = query.list();
        if(list.size() > 0){
            User user = list.get(0);
            return user;
        }
        return null;
    }
}
