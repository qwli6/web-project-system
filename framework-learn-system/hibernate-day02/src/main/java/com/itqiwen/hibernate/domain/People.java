package com.itqiwen.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 多对多
 *
 * 人和角色
 */
public class People {

    private String pid;
    private String name;

    private Set<Role> roleSet = new HashSet<Role>();

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
