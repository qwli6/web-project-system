package com.itqiwen.crm.service;

import com.itqiwen.crm.entity.LinkMan;
import com.itqiwen.crm.entity.PageBean;

public interface LinkmanService {
    PageBean<LinkMan> findAllLinkMan();
}
