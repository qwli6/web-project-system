package com.itqiwen.crm.web.action;

import com.itqiwen.crm.entity.LinkMan;
import com.itqiwen.crm.entity.PageBean;
import com.itqiwen.crm.service.LinkmanService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Scope(value = "prototype")
public class LinkManAction extends ActionSupport {

    @Resource
    private LinkmanService linkmanService;


    public String list(){

        PageBean<LinkMan> pageBean = linkmanService.findAllLinkMan();
        System.out.println("联系人列表：" + pageBean);
        List<LinkMan> beanList = pageBean.getBeanList();

        return NONE;
    }

}
