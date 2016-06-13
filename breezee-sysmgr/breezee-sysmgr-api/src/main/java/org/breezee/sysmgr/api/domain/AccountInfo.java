/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.api.domain;

import org.breezee.common.domain.BizInfo;

import java.util.Set;

/**
 * 实体域,聚合根：系统账户对象
 * Created by Silence on 2016/4/22.
 */
public class AccountInfo extends BizInfo {

    /**
     * 密码
     */
    protected String password;

    /**
     * 类型：正式，临时
     */
    protected Integer type = 1;

    /**
     * 职务
     */
    protected String job;

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
     * 权限字符
     */
    protected Set<String> permits;

    /**
     * 所属组织
     */
    protected OrganizationInfo org;

    protected String province;

    /**
     * 角色
     */
    protected Set<RoleInfo> roles;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public Set<String> getPermits() {
        return permits;
    }

    public void setPermits(Set<String> permits) {
        this.permits = permits;
    }

    public OrganizationInfo getOrg() {
        return org;
    }

    public void setOrg(OrganizationInfo org) {
        this.org = org;
    }

    public Set<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleInfo> roles) {
        this.roles = roles;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
