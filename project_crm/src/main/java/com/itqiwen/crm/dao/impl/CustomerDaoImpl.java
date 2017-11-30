package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.CustomerDao;
import com.itqiwen.crm.entity.Customer;
import com.itqiwen.crm.entity.PageBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void saveCustomer(Customer customer) {

    }

    /**
     * 分页查询
     * @param criteria 离线条件查询
     * @param pageCode
     * @param pageSize
     * @return
     */
    public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
        Session session = sessionFactory.getCurrentSession();
        PageBean<Customer> pageBean = new PageBean<Customer>();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        criteria.setProjection(Projections.rowCount());

        List<Number> list = criteria.getExecutableCriteria(session).list();
        if(list != null && list.size() > 0){
            int count = list.get(0).intValue();
            pageBean.setTotalCount(count);
        }
        criteria.setProjection(null);
        Query query = session.createQuery("from Customer");
        query.setFirstResult((pageCode- 1)* pageSize);
        query.setMaxResults(pageSize);
//        query.
//        query.setParameter(0, (pageCode - 1)* pageSize);
//        query.setParameter(1, pageSize);
        List<Customer> customerList = query.list();
        pageBean.setBeanList(customerList);
        return pageBean;
    }
}
