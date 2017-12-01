package com.itqiwen.crm.service;


import com.itqiwen.crm.entity.BaseDict;

import java.util.List;

public interface DictService {
    List<BaseDict> findByCode(String baseDict);

    List<BaseDict> getDictList();

}
