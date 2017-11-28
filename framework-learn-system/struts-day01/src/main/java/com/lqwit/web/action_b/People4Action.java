package com.lqwit.web.action_b;

import com.lqwit.web.domain.People;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;


/**
 * 封装成 list
 */
public class People4Action extends ActionSupport{

    private Map<String, People> peopleMap;

    public Map<String, People> getPeopleMap() {
        return peopleMap;
    }

    public void setPeopleMap(Map<String, People> peopleMap) {
        this.peopleMap = peopleMap;
    }

    public String setValue4(){
        System.out.println(peopleMap);
        return "setValue";
    }
}
