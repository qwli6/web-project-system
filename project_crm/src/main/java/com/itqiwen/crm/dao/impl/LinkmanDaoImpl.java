package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.LinkmanDao;
import com.itqiwen.crm.entity.LinkMan;
import com.itqiwen.crm.entity.PageBean;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LinkmanDaoImpl implements LinkmanDao{


    @Resource
    private SessionFactory sessionFactory;


    public PageBean<LinkMan> findAllLinkMan() {

        PageBean<LinkMan> pageBean = new PageBean<LinkMan>();


        EntityManager entityManager = sessionFactory.createEntityManager();
        TypedQuery<LinkMan> linkMan = entityManager.createQuery("from LinkMan", LinkMan.class);
        List<LinkMan> list = linkMan.getResultList();

        if(list != null && list.size() > 0){
            pageBean.setBeanList(list);
            return pageBean;
        }
        return null;
    }
}
