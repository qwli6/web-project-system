package com.itqiwen.crm.service.impl;

import com.itqiwen.crm.dao.DictDao;
import com.itqiwen.crm.entity.BaseDict;
import com.itqiwen.crm.service.DictService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictDao dictDao;


    public List<BaseDict> findByCode(String baseDict) {
        return dictDao.findByCode(baseDict);
    }

    public List<BaseDict> getDictList() {
        return dictDao.getDictList();
    }
}
