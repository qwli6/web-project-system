package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.UserDao;
import com.itqiwen.crm.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;



@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    public List<User> findUserByUserCode(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(User.class);

        System.out.println("查询是否存在用户：=========" );
        EntityManager manager = sessionFactory.createEntityManager();
        TypedQuery<User> fromUser = manager.createQuery("from User where userCode = :userCode", User.class);
        TypedQuery<User> query = fromUser.setParameter("userCode", user.getUserCode());
//        criteria.add(Restrictions.eq("userCode", user.getUserCode()));

        System.out.println("查询唯一的用户:" + query.getSingleResult().toString());
        return query.getResultList();
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    /**
     * 根据用户名和密码以及状态来查询用户
     * @param user
     * @return
     */
    public User findUser(User user) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        String hql = "from User where userCode =:userCode and userPassword =:userPassword and userState = '1'";
        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("userCode", user.getUserCode());
        query.setParameter("userPassword", user.getUserPassword());
        List<User> userList = query.getResultList();
        if(userList != null && userList.size() > 0){
            return userList.get(0);
        }
        return null;

//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(User.class);
//        criteria.add(Restrictions.eq("userCode", user.getUserCode()));
//        criteria.add(Restrictions.eq("userPassword", user.getUserPassword()));
//        criteria.add(Restrictions.eq("userState", "1"));
//        List<User> userList = criteria.list();
//        if(userList != null && userList.size() > 0){
//            return userList.get(0);
//        }
//        return null;
    }
}
