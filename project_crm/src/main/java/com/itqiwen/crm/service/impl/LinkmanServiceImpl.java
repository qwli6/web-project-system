package com.itqiwen.crm.service.impl;

import com.itqiwen.crm.dao.LinkmanDao;
import com.itqiwen.crm.entity.LinkMan;
import com.itqiwen.crm.entity.PageBean;
import com.itqiwen.crm.service.LinkmanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class LinkmanServiceImpl implements LinkmanService {

    @Resource
    private LinkmanDao linkmanDao;


    public PageBean<LinkMan> findAllLinkMan() {
        return linkmanDao.findAllLinkMan();
    }
}
