package com.itqiwen.crm.entity;

public class LinkMan {

    private Long linkManId;
    private String linkManName;
    private String linkManSex;
    private String linkManPhone;
    private String linkManMobile;
    private String linkManEmail;
    private String linkManQQ;
    private String linkManPosition;
    private String linkManMemo;


    //客户和联系人是一对多的关系
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Long getLinkManId() {
        return linkManId;
    }

    public void setLinkManId(Long linkManId) {
        this.linkManId = linkManId;
    }

    public String getLinkManName() {
        return linkManName;
    }

    public void setLinkManName(String linkManName) {
        this.linkManName = linkManName;
    }

    public String getLinkManSex() {
        return linkManSex;
    }

    public void setLinkManSex(String linkManSex) {
        this.linkManSex = linkManSex;
    }

    public String getLinkManPhone() {
        return linkManPhone;
    }

    public void setLinkManPhone(String linkManPhone) {
        this.linkManPhone = linkManPhone;
    }

    public String getLinkManMobile() {
        return linkManMobile;
    }

    public void setLinkManMobile(String linkManMobile) {
        this.linkManMobile = linkManMobile;
    }

    public String getLinkManEmail() {
        return linkManEmail;
    }

    public void setLinkManEmail(String linkManEmail) {
        this.linkManEmail = linkManEmail;
    }

    public String getLinkManQQ() {
        return linkManQQ;
    }

    public void setLinkManQQ(String linkManQQ) {
        this.linkManQQ = linkManQQ;
    }

    public String getLinkManPosition() {
        return linkManPosition;
    }

    public void setLinkManPosition(String linkManPosition) {
        this.linkManPosition = linkManPosition;
    }

    public String getLinkManMemo() {
        return linkManMemo;
    }

    public void setLinkManMemo(String linkManMemo) {
        this.linkManMemo = linkManMemo;
    }
}
