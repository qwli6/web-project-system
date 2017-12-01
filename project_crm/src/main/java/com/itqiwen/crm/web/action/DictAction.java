package com.itqiwen.crm.web.action;

import com.itqiwen.crm.entity.BaseDict;
import com.itqiwen.crm.service.DictService;
import com.itqiwen.crm.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


@Scope(value = "prototype")
@Controller
@Namespace("/dict")
@ParentPackage("struts-default")
@Results({@Result(name="success", location = "/index.jsp"),

})
public class DictAction extends ActionSupport implements ModelDriven<BaseDict>{


    @Resource
    private DictService dictService;

    private BaseDict baseDict = new BaseDict();

    public BaseDict getBaseDict() {
        return baseDict;
    }

    public void setBaseDict(BaseDict baseDict) {
        this.baseDict = baseDict;
    }

    @Action("findByCode")
    public String findByCode(){

        List<BaseDict> dictList = dictService.findByCode("006");
//        List<BaseDict> dictList = dictService.findByCode(baseDict.getDictTypeCode());
        String jsonString = FastJsonUtil.toJSONString(dictList);
        //通过输出流将 json 字符串输出到页面上
        FastJsonUtil.writeJsonToResponse(ServletActionContext.getResponse(), jsonString);
        System.out.println(jsonString);
        return NONE;
    }


    @Action("dictList")
    public String getDictList(){

        List<BaseDict> dictList = dictService.getDictList();
        String s = FastJsonUtil.toJSONString(dictList);
        FastJsonUtil.writeJsonToResponse(ServletActionContext.getResponse(), s);

        return NONE;
    }

    public BaseDict getModel() {
        return baseDict;
    }
}
