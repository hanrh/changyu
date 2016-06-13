/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BizInfo;

import java.util.Date;

/**
 * 具备，执行主体，处理人的对象基类
 * <p>
 * Created by Silence on 2016/6/12.
 */
public class FlowInfo extends BizInfo {

    /**
     * 类型
     */
    protected String type;

    /**
     * 客户编码
     */
    protected String customerId;

    /**
     * 客户名称
     */
    protected String customerName;

    /**
     * 省份
     */
    protected String province;

    /**
     * 客户所属的城市
     */
    protected String city;

    /**
     * 营销部
     */
    protected String department;

    /**
     * 提交人
     */
    protected String submitor;

    /**
     * 提交时间
     */
    protected Date submitTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubmitor() {
        return submitor;
    }

    public void setSubmitor(String submitor) {
        this.submitor = submitor;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}
