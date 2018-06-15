package com.bupt.medicine.data;

import lombok.Data;

@Data
public class CustomerInfo {

    private Integer customerId;
    private String customerName;
    private Integer sexInfo;
    private Integer heightInfo;
    private Double weightInfo;
    private String phoneInfo;
    private String idNumber;
    private String birthday;
    private String createTime;
    private String authorizationCode;
    private Integer departmentId;
    private String customerPass;
    private Integer customerType;
    private String nationality;
    private Integer marriage;
    private String education;
    private String job;
    private String token;
    private String homeTel;
    private String zipCode;
    private String address;
    private String religion;
    private Integer bloodType;
    private String sleep;
    private Integer highBloodPress;
    private Integer lowBloodPress;
    private Integer bloodPress;
    private Double beforeBloodSugar;
    private Double afterBloodSugar;
    private Integer bloodSugar;
    private Integer weightState;
    private String diet;
    private Integer bodyTest;
    private String baoJian;
    private String remark;
    private String heartBlood;
    private String bones;
    private String digest;
    private String breath;
    private String immune;
    private String nervus;
    private String treatment;
    private String pharmacy;


    public CustomerInfo(int customerId,String customerName){

        this.customerId = customerId;
        this.customerName = customerName;

    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getToken(){return token;}

}
