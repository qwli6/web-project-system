package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.domain.User;
import com.itqiwen.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class HibernateTest {

    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

    }


    /**
     * 测试单表插入
     * 主键已经交给 hibernate 来管理，这里不要指定主键，指定主键也不会生效
     */
    @Test
    public void testInsert(){

        User user = new User();
        user.setName("小白白");
//        user.setId(10); //指定主键也不会生效
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);

        transaction.commit();
    }


    /**
     * 测试单表查询，根据主键查询单个对象
     * 查询不需要开启事务
     */
    @Test
    public void testQuery(){
        Session session = HibernateUtil.getSession();
        User user = session.get(User.class, 4);
        System.out.println(user);
    }

    /**
     * HQL hibernate query language（hibernate 查询语言）
     * 查询全部数据
     */
    @Test
    public void testQueryAll(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User user :
                list) {
            System.out.println(user);
        }
    }


    /**
     * 测试修改
     * 先查询出数据，在进行修改
     */
    @Test
    public void testUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 4);
        if(user != null){
            user.setName("小灰灰");
        }
        session.update(user);
        transaction.commit();
    }


    /**
     * 测试删除，先查询出数据，在进行删除
     */
    @Test
    public void testDelete(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 4);
        if(user != null){
            session.delete(user);
            transaction.commit();
        }
    }


    /**
     * 测试 saveOrUpdate
     */
    @Test
    public void testSaveOrUpdate(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 100);
        user.setName("小王八");
        session.saveOrUpdate(user);
        transaction.commit();
    }


    /**
     * 持久态对象有更新数据库的能力
     * 并没有调用保存，但是 User 的名称已经被修改了
     *
     * 先执行了查询，然后执行了修改
     */
    @Test
    public void testUpdate2(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //执行了两次查询操作，第一次查询是从数据库中查询的，打印出了 sql 语句
        User user = session.get(User.class, 5);
        System.out.println(user);
        user.setName("小王八");

        transaction.commit();

        //这次的查询并没有打印出 sql 语句，说明这次的查询是从缓存中取出来的
        User u1 = session.get(User.class, 5);

        System.out.println(u1);
    }
}
