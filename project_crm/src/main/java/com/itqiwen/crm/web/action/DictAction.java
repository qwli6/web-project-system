package com.itqiwen.crm.web.action;

import com.itqiwen.crm.entity.BaseDict;
import com.itqiwen.crm.service.DictService;
import com.itqiwen.crm.utils.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


@Scope(value = "prototype")
@Controller
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

    public String findByCode(){

//        List<BaseDict> dictList = dictService.findByCode("001");
        List<BaseDict> dictList = dictService.findByCode(baseDict.getDictTypeCode());
        String jsonString = JsonUtil.toJSONString(dictList);
        //通过输出流将 json 字符串输出到页面上
        JsonUtil.writeJsonToResponse(ServletActionContext.getResponse(), jsonString);
        System.out.println(jsonString);
        return NONE;
    }

    public String getDictList(){

        List<BaseDict> dictList = dictService.getDictList();
        String s = JsonUtil.toJSONString(dictList);
        JsonUtil.writeJsonToResponse(ServletActionContext.getResponse(), s);
        return NONE;
    }

    public BaseDict getModel() {
        return baseDict;
    }
}
