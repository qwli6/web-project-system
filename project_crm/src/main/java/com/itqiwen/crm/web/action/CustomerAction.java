package com.itqiwen.crm.web.action;

import com.itqiwen.crm.constants.ActionIndex;
import com.itqiwen.crm.entity.Customer;
import com.itqiwen.crm.entity.PageBean;
import com.itqiwen.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Scope(value = "prototype")
@Controller
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    public Customer getModel() {
        return customer;
    }

    //当前页码
    private Integer pageCode = 1;
    public void setPageCode(Integer pageCode) {
        if(pageCode == null){
            pageCode = 1;
        }
        this.pageCode = pageCode;
    }

    //每页显示的条数
    private Integer pageSize = 5;
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



    @Resource
    private CustomerService customerService;


    /**
     * 查询客户列表
     * @return
     */
    public String list(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        PageBean<Customer> pageBean = customerService.findByPage(criteria, pageCode, pageSize);
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.set("pageBean", pageBean);
        System.out.println(pageBean);

        return ActionIndex.CUSTOMER_LIST;
    }


    public String addPage(){
        return ActionIndex.CUSTOMER_ADD_PAGE;
    }

    public String add(){

        System.out.println("保存客户封装数据：" + customer);

        return ActionIndex.CUSTOMER_LIST;
    }

}
