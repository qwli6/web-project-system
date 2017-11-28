package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.domain.Order;
import com.itqiwen.hibernate.domain.User2;
import com.itqiwen.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 测试级联
 */
public class TestCascade {

    /**
     * 测试双向关联
     * 并没有在 hbm.xml 文件中配置级联属性
     */
    @Test
    public void run(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User2 user2 = new User2();
        user2.setName("曹焱兵");
        user2.setAddress("罗刹街");
        user2.setAge(16);

        Order o1 = new Order();
        o1.setAddress("罗刹街");
        o1.setContent("外卖一号");

        Order o2 = new Order();
        o2.setAddress("罗刹街");
        o2.setContent("外卖二号");

        //订单和用户关联
        o1.setUser(user2);
        o2.setUser(user2);

        //用户和订单关联
        user2.getOrderSet().add(o1);
        user2.getOrderSet().add(o2);

        session.save(user2);
        session.save(o1);
        session.save(o2);

        transaction.commit();
        session.close();
    }


    /**
     * 测试级联保存
     * 在 hbm.xml 文件中配置级联属性
     *
     * 只在用户中配置，也就是单向级联
     * cascade="save-update"
     */
    @Test
    public void run2(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();


        User2 user2 = new User2();
        user2.setName("曹焱亮");
        user2.setAddress("死魂岛");
        user2.setAge(19);

        Order o1 = new Order();
        o1.setAddress("死魂岛");
        o1.setContent("曹家霸器");

        Order o2 = new Order();
        o2.setAddress("死魂岛");
        o2.setContent("武神躯");

        //用户关联订单
        user2.getOrderSet().add(o1);
        user2.getOrderSet().add(o2);

        /**
         * 在用户中配置了级联属性，所以在保存用户的时候，会级联保存订单
         */
        session.save(user2);
        transaction.commit();
    }


    /**
     * 双向级联
     * User 和 Order 之间都配置了 cascade = save-update 属性，也就是说
     * 插入用户时会级联插入 order
     * 插入 order 会级联插入 user
     */
    @Test
    public void run3(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User2 user2 = new User2();
        user2.setName("曹焱亮2");
        user2.setAddress("死魂岛2");
        user2.setAge(29);

        Order o1 = new Order();
        o1.setAddress("死魂岛2");
        o1.setContent("曹家霸器2");



        Order o2 = new Order();
        o2.setAddress("死魂岛2");
        o2.setContent("武神躯2");

        o2.setUser(user2);
        user2.getOrderSet().add(o1);

        session.save(o2);
        transaction.commit();

    }


    /**
     * 测试级联删除
     */
    @Test
    public void run4(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        User2 user2 = session.get(User2.class, 8);
        if(user2 != null){
            session.delete(user2);
        }

        transaction.commit();
    }
}
