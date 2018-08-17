package com.meng.moudle.customer.vo;

import java.util.Date;

public class Customer {
    private String id;

    private String name;

    private String gender;

    private String investor;

    private Date birthday;

    private Date order;

    private Integer orderYears;

    private String insuranceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getOrder() {
        return order;
    }

    public void setOrder(Date order) {
        this.order = order;
    }

    public Integer getOrderYears() {
        return orderYears;
    }

    public void setOrderYears(Integer orderYears) {
        this.orderYears = orderYears;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }
}