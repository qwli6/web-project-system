package com.lqwit.web.action_b;

import com.lqwit.web.domain.People;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 封装成 list
 */
public class People3Action extends ActionSupport{

    /**
     * 不需要自己 new 对象
     */
    private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    public String setValue3(){
        for (People people :
                peopleList) {
            System.out.println(people);
        }
        return "setValue";
    }
}
