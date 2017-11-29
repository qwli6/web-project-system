package com.itqiwen.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色表
 */
public class Role {

    private Integer rid;
    private String roleName;

    private Set<People> peopleSet = new HashSet<People>();

    public Set<People> getPeopleSet() {
        return peopleSet;
    }

    public void setPeopleSet(Set<People> peopleSet) {
        this.peopleSet = peopleSet;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
