package com.itqiwen.crm.web.action;

import com.itqiwen.crm.constants.ActionIndex;
import com.itqiwen.crm.entity.User;
import com.itqiwen.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Scope(scopeName = "prototype")
@Controller
public class UserAction extends ActionSupport implements ModelDriven<User> {

    @Resource
    private UserService userService;

    private User user = new User();

    private String userCode;

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public String login(){

        User u1 = userService.findUser(user);

        if(u1 != null){
            ServletActionContext.getRequest().getSession().setAttribute("u1", u1);
            return ActionIndex.INDEX_PAGE;
        }else{
            return LOGIN;
        }
    }

    /**
     * 跳转到注册界面
     * @return
     */
    public String registerPage(){

        return ActionIndex.REGISTER_PAGE;
    }


    /**
     * 通过登录名判断登录名称是否存在
     * @return
     */
    public String checkUserCode() throws IOException {
        //离线条件查询也可以
//        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
//        detachedCriteria.add(Restrictions.eq("userCode", user.getUserCode()));
        List<User> userList = userService.findUserByUserCode(user);
        System.out.println("封装数据为:" + user);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(userList != null && userList.size() > 0){
            //用户名已经存在
            writer.print("userExists");
        }else{
            writer.print("userDon'tExists");
        }
        return NONE;
    }


    public String loginPage(){
        return ActionIndex.LOGIN_PAGE;
    }


    //退出登录
    public String loginOut(){
        ServletActionContext.getRequest().getSession().removeAttribute("u1");
        return LOGIN;
    }

    /**
     * 用户注册
     * @return
     */
    public String register(){
        userService.saveUser(user);
        return LOGIN;
    }


    public String index(){

        return ActionIndex.INDEX;
    }

    public User getModel() {
        return user;
    }
}
