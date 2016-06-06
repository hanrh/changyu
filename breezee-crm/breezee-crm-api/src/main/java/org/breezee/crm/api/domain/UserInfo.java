/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * 实体域，聚合根：客户登录的信息
 * Created by Silence on 2016/6/4.
 */
public class UserInfo extends BaseInfo {

    /**
     * 关联的客户号。这里一般是客户编号，例如30080019等
     */
    protected String customerId;

    /**
     * 密码
     */
    protected String password;

    /**
     * 性别
     */
    protected Integer sex;

    /**
     * 手机
     */
    protected String mobile;

    /**
     * 邮箱
     */
    protected String email;

    /**
     * 地址
     */
    protected String address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
