package com.itqiwen.crm.dao;

import com.itqiwen.crm.entity.LinkMan;
import com.itqiwen.crm.entity.PageBean;

public interface LinkmanDao {

    PageBean<LinkMan> findAllLinkMan();

}
