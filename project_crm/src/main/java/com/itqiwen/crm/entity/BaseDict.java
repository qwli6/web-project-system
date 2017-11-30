package com.itqiwen.crm.entity;

public class BaseDict {

    private String dictId;
    //数据字典类别代码 001  006
    private String dictTypeCode;
    //类别名称 001 属于行业， 006 属于客户级别
    private String dictTypeName;
    //字典项目名称
    private String dictItemName;
    private String dictItemCode;
    private Integer dictSort;
    private String dictEnable;
    private String dictMemo;


    //没有查字典的需求，所以不需要配置
//    private Set<Customer> customerSet = new HashSet<Customer>();

//    public Set<Customer> getCustomerSet() {
//        return customerSet;
//    }
//
//    public void setCustomerSet(Set<Customer> customerSet) {
//        this.customerSet = customerSet;
//    }

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName;
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {
        this.dictEnable = dictEnable;
    }

    public String getDictMemo() {
        return dictMemo;
    }

    public void setDictMemo(String dictMemo) {
        this.dictMemo = dictMemo;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "dictId='" + dictId + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", dictTypeName='" + dictTypeName + '\'' +
                ", dictItemName='" + dictItemName + '\'' +
                ", dictItemCode='" + dictItemCode + '\'' +
                ", dictSort=" + dictSort +
                ", dictEnable='" + dictEnable + '\'' +
                ", dictMemo='" + dictMemo + '\'' +
                '}';
    }
}
