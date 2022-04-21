package com.company.classes;

import com.company.classes.enums.PolicyType;

public class Risk {
    private int id;
    private float price;
    private String protectionFrom;
    private String protectionTo;
    private String description;
    private PolicyType policyType;

    public Risk(int id, float price, String protectionFrom, String protectionTo, String description, PolicyType policyType) {
        this.id = id;
        this.price = price;
        this.protectionFrom = protectionFrom;
        this.protectionTo = protectionTo;
        this.description = description;
        this.policyType = policyType;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProtectionFrom() {
        return protectionFrom;
    }

    public void setProtectionFrom(String protectionFrom) {
        this.protectionFrom = protectionFrom;
    }

    public String getProtectionTo() {
        return protectionTo;
    }

    public void setProtectionTo(String protectionTo) {
        this.protectionTo = protectionTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }
}
