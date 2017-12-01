package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.DictDao;
import com.itqiwen.crm.entity.BaseDict;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DictDaoImpl implements DictDao {

    @Resource
    private SessionFactory sessionFactory;


    public List<BaseDict> findByCode(String dictTypeCode) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        String hql = "from BaseDict where dictTypeCode = :dictTypeCode";
        Query query = entityManager.createQuery(hql)
                .setParameter("dictTypeCode", dictTypeCode);
        List<BaseDict> dictList = query.getResultList();
        return dictList;
    }

    public List<BaseDict> getDictList() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        /**
        TypedQuery<BaseDict> dictBd = entityManager.createQuery("select bd from BaseDict bd", BaseDict.class);
         **/
        String hql ="select c from BaseDict c";

//        TypedQuery<BaseDict> query = entityManager.createQuery("select c from BaseDict c where c.dictTypeCode = :code", BaseDict.class);
        TypedQuery<BaseDict> query = entityManager.createQuery(hql, BaseDict.class);
//        query.setFirstResult(0);
//        query.setMaxResults(8);

        //查询唯一的一个用户，用户数量多于1 会报错
//        BaseDict result = query.getSingleResult();
//        System.out.println("BaseDict:" + result);

        return query.getResultList();
    }
}
