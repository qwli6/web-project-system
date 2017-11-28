package com.itqiwen.hibernate.domain;

import javax.persistence.Entity;

/**
 * 用户与订单的关系
 * 一个用户多个订单
 * 一个订单一个用户
 */
public class Order {

    private String oid;
    private String goodName;
    private String content;
    private String address;

    private User2 user;

    public void setUser(User2 user) {
        this.user = user;
    }

    public User2 getUser() {
        return user;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
