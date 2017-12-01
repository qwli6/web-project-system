package com.itqiwen.crm.dao;

import com.itqiwen.crm.entity.BaseDict;

import java.util.List;

public interface DictDao {
    List<BaseDict> findByCode(String baseDict);

    List<BaseDict> getDictList();
}
