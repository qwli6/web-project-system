package com.lqwit.web.action_b;

import com.lqwit.web.domain.People;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 模型驱动的方式从页面取值
 */
public class People2Action extends ActionSupport{

    /**
     * 不需要自己 new 但是需要提供 get 和 set
     * 并且页面上的 name 属性必须和对象的字段相同
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setValue2(){
        System.out.println("属性驱动方式：" + name);
        return "setValue";
    }
}
