package com.itqiwen.crm.web.interceptor;


import com.itqiwen.crm.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 判断用户是否登录，如果没有登录，跳转到登录界面
 * 不能拦截 login 方法，也不能拦截 register 方法
 */
public class UserInterceptor extends MethodFilterInterceptor {
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("u1");
        if(user == null){
            //没有登录
            return ActionSupport.LOGIN;
        }
        //执行下一个拦截器
        return actionInvocation.invoke();
    }
}
