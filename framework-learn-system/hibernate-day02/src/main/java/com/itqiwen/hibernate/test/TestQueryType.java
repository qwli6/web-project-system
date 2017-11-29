package com.itqiwen.hibernate.test;

import com.itqiwen.hibernate.domain.Order;
import com.itqiwen.hibernate.domain.User;
import com.itqiwen.hibernate.domain.User2;
import com.itqiwen.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.OrderBy;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestQueryType {

    /**
     * 唯一标识 OID 的方式
     * 也就是通过主键来查询
     */
    @Test
    public void run(){
        Session session = HibernateUtil.getSession();
        User user = session.get(User.class, 1);
        System.out.println(user);
    }

    /**
     * 对象导航的方式
     * new User().getRole().getName()
     *
     * 有延迟加载的策略
     */
    @Test
    public void run2(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        //现有 OID 的查询方式
        User2 user2 = session.get(User2.class, 4);

        System.out.println("===================");
        //查询该用户下的订单集合
        //直接从 user 中拿出 OrderSet 就可以查询出来
        Set<Order> orderSet = user2.getOrderSet();
        System.out.println(user2.getOrderSet().size());
        transaction.commit();
    }


    /**
     * HQL 查询
     */
    @Test
    public void run3(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User user :
                list) {
            System.out.println(user);
        }
    }

    /**
     * 可以取别名
     */
    @Test
    public void run31(){
        Session session = HibernateUtil.getSession();
//        List<User2> list = session.createQuery("from User2 as u").list();//as 可以省略
        List<User2> list = session.createQuery("select u from User2 as u").list();//as 可以省略
        for (User2 user2 :
                list) {
            System.out.println(user2);
        }
    }

    /**
     * 利用 HQL 排序
     */
    @Test
    public void run32(){
        Session session = HibernateUtil.getSession();
        List<User2> list = session.createQuery("select u from User2 as u order by id desc").list();
        for (User2 user2 :
                list) {
            System.out.println(user2);
        }
    }

    /**
     * 利用 HQL 分页
     */
    @Test
    public void run33(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select u from User2 as u order by id desc");
        query.setFirstResult(0);//从哪天记录开始，默认从 0 开始
//        query.setFirstResult((2-1)*3);//查询第二页的数据
        query.setMaxResults(3);//每一页显示多少数据
        List<User2> list = query.list();
        for (User2 user2 :
                list) {
            System.out.println(user2);
        }
    }

    /**
     * HQL
     * 利用 setParameter 查询添加条件
     */
    @Test
    public void run4(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User2 where age > ?");
        query.setParameter(0, 13);

        List<User2> list = query.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
        transaction.commit();
        session.close();
    }

    /**
     * HQL 添加查询条件
     */
    @Test
    public void run5(){
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User2 where age >:age");
//        query.setParameter(age, 13);

        query.setParameter("age", 13);
        List<User2> list = query.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
        session.close();
    }

    /**
     * HQL 模糊查询
     */
    @Test
    public void run51(){
        Session session = HibernateUtil.getSession();
        List<User2> list = session.createQuery("from User2 where name like ?")
                .setParameter(0, "%曹%").list();
        for (User2 user :
                list) {
            System.out.println(user);
        }

    }

    /**
     * 投影查询，可以不查全部字段，并且指定查询
     * 某一些字段
     * //output
     * [小王, 12]
     * [小王2, 22]
     * [张三, 23]
     * [曹焱兵, 16]
     * [曹焱亮, 19]
     */
    @Test
    public void run6(){
        Session session = HibernateUtil.getSession();
        //只查询用户表中的 name 字段
        List<Object[]> list = session.createQuery("select u.name, u.age from User2 u").list();
        for (Object[] objs : list) {
            System.out.println(Arrays.toString(objs));
        }
    }

    /**
     * 把投影查询出来的结果映射到对象中
     * //output
     * User2{id=null, name='小王', age=12, address='null'}
     * User2{id=null, name='小王2', age=22, address='null'}
     * User2{id=null, name='张三', age=23, address='null'}
     * User2{id=null, name='曹焱兵', age=16, address='null'}
     * User2{id=null, name='曹焱亮', age=19, address='null'}
     *
     */
    @Test
    public void run61(){
        Session session = HibernateUtil.getSession();
        //在 User2 中提供要查询字段的构造方法
        Query query = session.createQuery("select new User2(u.name, u.age) from User2 u");
        List<User2> list = query.list();
        for (User2 user2 : list) {
            System.out.println(user2);
        }
    }


    /**
     * 聚合函数： sum() count() avg() max() min()
     */
    @Test
    public void run7(){
        Session session = HibernateUtil.getSession();
        //查询所有的联系人的数量
//        List<Number> list = session.createQuery("select count(*) from  User2 ").list();
        List<Number> list = session.createQuery("select count(u) from  User2 u ").list();
        //通过下标取值
        int i = list.get(0).intValue();
        System.out.println(i);
    }


    /**
     * QBC 查询方式 Query By Criteria （按条件查询）
     */
    @Test
    public void run8(){
        Session session = HibernateUtil.getSession();

        //创建 QBC 的查询接口
        Criteria criteria = session.createCriteria(User2.class);
        criteria.add(Restrictions.gt("age", 14));

        List<User2> list = criteria.list();
        for (User2 user : list) {
            System.out.println(user);
        }
    }

    /**
     * QBC 按id升序
     */
    @Test
    public void run9(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User2.class);
        //升序
        criteria.addOrder(org.hibernate.criterion.Order.asc("id"));
//        criteria.addOrder(org.hibernate.criterion.Order.desc("id"));
        List<User2> list = criteria.list();
        for (User2 user : list) {
            System.out.println(user);
        }
    }


    /**
     * QBC 分页
     */
    @Test
    public void run10(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User2.class);
        //升序
        criteria.addOrder(org.hibernate.criterion.Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(3);
        List<User2> list = criteria.list();
        for (User2 user : list) {
            System.out.println(user);
        }
    }

    /**
     * QBC 条件查询
     */
    @Test
    public void run11(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User2.class);
        /**
         * 使用 Restrictions 添加条件
         */
        criteria.add(Restrictions.like("name", "%曹%"));
        List<User2> list = criteria.list();
        for (User2 user : list) {
            System.out.println(user);
        }
    }


    /**
     * QBC or 方法查询
     */
    @Test
    public void run12(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User2.class);
        /**
         * 使用 Restrictions 添加条件
         * sql  select * from user2 where age > 13 or name like %曹%;
         */
        criteria.add(Restrictions.or(Restrictions.gt("age", 13),
                Restrictions.like("name", "%曹%")));

        List<User2> list = criteria.list();
        for (User2 user : list) {
            System.out.println(user);
        }
    }

    /**
     * QBC 查询聚合条件
     * Projections: 聚合函数的工具类
     */
    @Test
    public void run13(){
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User2.class);
        List<Number> id = criteria.setProjection(Projections.count("id")).list();
        long l = id.get(0).longValue();
        System.out.println(l);

        //重置聚合函数条件
        criteria.setProjection(null);
        List<User2> list = criteria.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }

    }

    /**
     * 离线条件查询
     * DetachedCriteria 创建不依赖 session，查询需要依赖 session
     */
    @Test
    public void run14(){

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User2.class);
        detachedCriteria.add(Restrictions.like("name", "%曹%"));

        Criteria criteria = detachedCriteria.getExecutableCriteria(HibernateUtil.getSession());
        List<User2> list = criteria.list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
    }


    /**
     * 执行原生SQL语句查询
     * 默认是封装到数组中的，我们可以执行添加实体对象选择将数据封装到对象中--具体实现 run16中
     */
    @Test
    public void run15(){
        Session session = HibernateUtil.getSession();
//        NativeQuery sqlQuery = session.createSQLQuery("select * from user2");
        NativeQuery query = session.createNativeQuery("select * from user2");
        List<Object[]> list = query.list();
        for (Object[] objs :
                list) {
            System.out.println(Arrays.toString(objs));
        }
    }

    /**
     * 原生 sql 查询，封装查询结果到实体对象zhogn
     */
    @Test
    public void run16(){
        Session session = HibernateUtil.getSession();
        List<User2> list = session.createNativeQuery("select * from user2").addEntity(User2.class).list();
        for (User2 user :
                list) {
            System.out.println(user);
        }
    }




    /**============================================================================**/

    /**
     * HQL 多表查询
     *
     * 左连接
     */
    @Test
    public void run17(){
        Session session = HibernateUtil.getSession();

        Query query = session.createQuery("from User2 u left join u.orderSet");
        //默认的返回值还是 数组
        List<Object[]> list = query.list();
        for (Object[] objs :
                list) {
            System.out.println(Arrays.toString(objs));
        }
    }


    /**
     * HQL 多表查询
     * 默认是封装到 Object[] 数组中，如果我们想要把数据封装到对象中，那么需要使用
     * fetch ：：迫切左连接
     * 但是还是有数据重复的问题，数据重复的问题需要手动解决
     *
     * 左连接
     */
    @Test
    public void run18(){
        Session session = HibernateUtil.getSession();

        Query query = session.createQuery("from User2 u left join fetch u.orderSet");
        //默认的返回值还是 数组
        List<User2> list = query.list();
        for (User2 user2 :
                list) {
            System.out.println(user2);
        }
    }


    /**
     * HQL 多表查询
     * 解决上面出现的数据重复的问题
     *
     * 左连接
     */
    @Test
    public void run19(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from User2 u left join fetch u.orderSet");
        //默认的返回值还是 数组
        List<User2> list = query.list();

        //Set 集合是默认不可以重复的，手动解决重复问题
        Set<User2> set = new HashSet<User2>(list);
        System.out.println(set);
    }
}
