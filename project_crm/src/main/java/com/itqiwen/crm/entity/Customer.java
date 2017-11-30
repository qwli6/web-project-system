package com.itqiwen.crm.entity;


public class Customer {

    /**
     * CREATE TABLE `cst_customer` (
     `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
     `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
     `cust_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
     `cust_create_id` bigint(32) DEFAULT NULL COMMENT '创建人id',
     `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
     `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
     `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
     `cust_linkman` varchar(64) DEFAULT NULL COMMENT '联系人',
     `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
     `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
     PRIMARY KEY (`cust_id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
     */

    private Long custId;
    //客户名称
    private String custName;
    private String custUserId;
    private String custCreateId;
    //客户来源
    private String custSource;
    //客户所属行业
    private String custIndustry;
    //客户的等级，初中高级
    private String custLevel;
    //客户的联系人
    private String custLinkman;
    //客户的电话
    private String custPhone;
    //客户的移动电话
    private String custMobile;

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

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
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
