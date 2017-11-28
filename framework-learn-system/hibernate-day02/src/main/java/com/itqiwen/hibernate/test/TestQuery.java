package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.domain.User2;
import com.itqiwen.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class TestQuery {

    @Test
    public void addData(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User2 user = new User2();
        user.setAge(23);
        user.setName("张三");
        user.setAddress("北京西贡");
        session.save(user);
        transaction.commit();
    }

    /**
     * 查询全部
     */
    @Test
    public void testQuery1(){

        Session session = HibernateUtil.getSession();

        Query query = session.createQuery("from User2");
        List<User2> list = query.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
    }


    /**
     * 条件查询
     */
    @Test
    public void testQuery2(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from User2 where age > ?");
        //设置参数，0 表示第一个 ？
        query.setParameter(0, 13);
        List<User2> list = query.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
    }

    /**
     * 条件查询，自定义 key
     */
    @Test
    public void testQuery3(){
        Session session = HibernateUtil.getSession();
        //把 age 当做 key
        Query query = session.createQuery("from User2 where age > :age");
        query.setParameter("age", 13);
        List<User2> list = query.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
    }

    /**
     * 使用 Criteria 接口添加查询条件
     * Criteria 比较适合做条件查询
     * 在 5.2 版本以上已经被废弃，使用 JPA Criteria 代替
     */
    @Test
    public void testQuery4(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User2.class);
        /**
         * 添加年龄大于 13 的
         */
//        criteria.add(Restrictions.gt("age", 13));

        /**
         * 添加条件 name = 小王
         */
        criteria.add(Restrictions.eq("name", "小王"));

        List<User2> list = criteria.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
    }


}
