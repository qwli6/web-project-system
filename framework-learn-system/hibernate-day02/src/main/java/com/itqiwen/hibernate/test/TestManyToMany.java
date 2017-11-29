package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.domain.People;
import com.itqiwen.hibernate.domain.Role;
import com.itqiwen.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * 测试多对多
 *
 * 多对多千万不要配置级联删除
 */
public class TestManyToMany {


    /**
     * 测试双向关联
     *
     * 多对多必须要一方放弃外键的维护
     */
    @Test
    public void testSave(){

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();


        People p1 = new People();
        p1.setName("曹焱兵");
        People p2 = new People();
        p2.setName("曹玄亮");

        Role role1 = new Role();
        role1.setRoleName("镇魂将");

        Role role2 = new Role();
        role2.setRoleName("寄灵人");

        //双向关联
        p1.getRoleSet().add(role1);
        p1.getRoleSet().add(role2);
        role1.getPeopleSet().add(p1);
        role2.getPeopleSet().add(p1);


        p2.getRoleSet().add(role2);
        role2.getPeopleSet().add(p2);


        session.save(p1);
        session.save(p2);
        session.save(role1);
        session.save(role2);


        transaction.commit();
        session.close();

    }

    /**
     * 级联保存，有方向性
     */
    @Test
    public void run(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        People p1 = new People();
        p1.setName("小王");
        People p2 = new People();
        p2.setName("小蓝");

        Role role = new Role();
        role.setRoleName("演员");

        Role role2 = new Role();
        role2.setRoleName("刺客");

        //第一个用户有两个角色
        p1.getRoleSet().add(role);
        p1.getRoleSet().add(role2);

        //用户 p2 有一个角色
        p2.getRoleSet().add(role2);

        //在 People.hbm.xml 中配置级联保存
        session.save(p1);
        session.save(p2);


        transaction.commit();
        session.close();
    }


    /**
     * 让 p1 对象只有刺客一个角色
     * 操作集合就相当于操作中间表
     */
    @Test
    public void run2(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //根据 p1 的 id 去查询该 People 对象
        People people = session.get(People.class, "402881ea60059fe00160059fe3510000");
        Set<Role> roleSet = people.getRoleSet();//拿到张三对应的集合对象

        Role role2 = session.get(Role.class, 1);

        roleSet.remove(role2);

        //不用修改，自动更新，快照机制

        transaction.commit();
        session.close();
    }
}

