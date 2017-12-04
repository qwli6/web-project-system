package com.itqiwen.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private Long custId;
    //客户名称
    private String custName;
    private String custUserId;
    private String custCreateId;
    //客户的联系人
    private String custLinkman;
    //客户的电话
    private String custPhone;
    //客户的移动电话
    private String custMobile;

    /**
     * 3 个外键，一个是描述客户来源，一个是客户的级别，一个是客户的行业，所以需要三个
     */
    private BaseDict dictSource;
    private BaseDict dictIndustry;
    private BaseDict dictLevel;


    private Set<LinkMan> linkManSet = new HashSet<LinkMan>();

    public void setLinkManSet(Set<LinkMan> linkManSet) {
        this.linkManSet = linkManSet;
    }

    public Set<LinkMan> getLinkManSet() {
        return linkManSet;
    }

    public BaseDict getDictLevel() {
        return dictLevel;
    }

    public void setDictLevel(BaseDict dictLevel) {
        this.dictLevel = dictLevel;
    }

    public BaseDict getDictIndustry() {
        return dictIndustry;
    }

    public void setDictIndustry(BaseDict dictIndustry) {
        this.dictIndustry = dictIndustry;
    }

    public BaseDict getDictSource() {
        return dictSource;
    }

    public void setDictSource(BaseDict dictSource) {
        this.dictSource = dictSource;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(String custUserId) {
        this.custUserId = custUserId;
    }

    public String getCustCreateId() {
        return custCreateId;
    }

    public void setCustCreateId(String custCreateId) {
        this.custCreateId = custCreateId;
    }


    public String getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(String custLinkman) {
        this.custLinkman = custLinkman;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }
}
