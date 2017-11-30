package com.lqwit.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义自己的拦截器
 */
public class DemoInterceptor extends AbstractInterceptor{

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Action 方法执行之前，拦截器会被调用....");

        //执行下一个拦截器
        String result = actionInvocation.invoke();

        System.out.println("Action 方法执行之后，拦截器再次被调用。。。。。");
        return result;
    }
}
