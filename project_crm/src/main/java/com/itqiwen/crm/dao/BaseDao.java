package com.itqiwen.crm.dao;


import com.itqiwen.crm.entity.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 封装一些常用的方法
 * 例如增删改查
 */
public interface BaseDao<T> {


    void save(T t);

    void update(T t);

    void delete(T t);

    T findById(String id);

    T findById(Long id);


    List<T> findAll();

    //分页的方法
    PageBean<T> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
