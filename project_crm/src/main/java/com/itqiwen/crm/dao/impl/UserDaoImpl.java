package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.UserDao;
import com.itqiwen.crm.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;



@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    public List<User> findUserByUserCode(User user) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userCode", user.getUserCode()));
        return (List<User>)criteria.list();
    }

    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public User findUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userCode", user.getUserCode()));
        criteria.add(Restrictions.eq("userPassword", user.getUserPassword()));
        criteria.add(Restrictions.eq("userState", "1"));
        List<User> userList = criteria.list();
        if(userList != null && userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }
}
