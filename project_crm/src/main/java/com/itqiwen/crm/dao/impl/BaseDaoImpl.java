package com.itqiwen.crm.dao.impl;

import com.itqiwen.crm.dao.BaseDao;
import com.itqiwen.crm.entity.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


//压制全部的警告
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class aClass;

    public BaseDaoImpl() {
        Class c = this.getClass();
        Type type = c.getGenericSuperclass();

        if(type instanceof ParameterizedType){
            ParameterizedType p = (ParameterizedType) type;
            Type[] typeArguments = p.getActualTypeArguments();
            this.aClass = (Class) typeArguments[0];
        }
    }

    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    public T findById(String id) {

        return (T) this.getHibernateTemplate().get(aClass, id);
    }

    public T findById(Long id) {
        return (T) getHibernateTemplate().get(aClass, id);
    }

    public List<T> findAll() {
        return (List<T>) getHibernateTemplate()
                .find("from " + aClass.getSimpleName());
    }

    /**
     * 分页方法
     * @param pageCode
     * @param pageSize
     * @param criteria
     * @return
     */
    public PageBean<T> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
        PageBean<T> pageBean = new PageBean<T>();
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        criteria.setProjection(Projections.rowCount());
        List<Number> list = (List<Number>) getHibernateTemplate().findByCriteria(criteria);
        if(list != null && list.size() > 0){
            int intValue = list.get(0).intValue();
            //总记录数
            pageBean.setTotalCount(intValue);
        }

        criteria.setProjection(null);
        List<T> beanList = (List<T>) getHibernateTemplate()
                .findByCriteria(criteria, (pageCode - 1) * pageSize, pageSize);

        pageBean.setBeanList(beanList);

        return pageBean;
    }
}
