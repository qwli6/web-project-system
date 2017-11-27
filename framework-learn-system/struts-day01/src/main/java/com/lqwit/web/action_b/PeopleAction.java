package com.lqwit.web.action_b;

import com.lqwit.web.domain.People;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 模型驱动的方式从页面取值
 */
public class PeopleAction extends ActionSupport implements ModelDriven<People>{

    //对象需要自己 new，属性不需要
    private People people = new People();

    public People getModel() {
        return people;
    }

    public String setValue(){
        System.out.println(people);
        return "setValue";
    }
}
