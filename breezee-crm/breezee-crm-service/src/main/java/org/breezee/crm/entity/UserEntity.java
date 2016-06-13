/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.entity;

import org.breezee.common.domain.BreezeeUtils;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.framework.BaseEntity;
import org.breezee.common.framework.ContextUtil;
import org.breezee.crm.api.domain.UserInfo;
import org.breezee.crm.repository.ICustomerRepository;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体持久域
 * Created by Silence on 2016/6/4.
 */
@Entity
@Table(name = "CRM_TF_USER", schema = BaseEntity.DB_SCHEMA)
public class UserEntity extends BaseEntity<UserEntity, UserInfo> {

    private String password;
    private Integer sex;
    private String mobile;
    private String email;
    private String address;
    private CustomerEntity customer;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "USER_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "USER_CODE", unique = true, nullable = false, updatable = false, length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "USER_NAME", nullable = false, length = 2000)
    public String getName() {
        return name;
    }

    @Column(name = "TENANT_ID", nullable = false, updatable = false, length = 64)
    public String getTenantId() {
        return tenantId;
    }

    @Column(name = "CREATOR", nullable = false, updatable = false, length = 64)
    public String getCreator() {
        return creator;
    }

    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    @Column(name = "UPDATOR", nullable = false, length = 64)
    public String getUpdator() {
        return updator;
    }

    @Column(name = "UPDATE_TIME", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    @Column(name = "REMARK", length = 3000)
    public String getRemark() {
        return remark;
    }

    @Column(name = "ROW_NUM", nullable = false)
    public Long getRowNum() {
        return rowNum;
    }

    @Column(name = "VERSION", nullable = false)
    public Integer getVersion() {
        return version;
    }

    @Column(name = "STATUS", nullable = false)
    public Integer getStatus() {
        return this.status;
    }

    @Column(name = "NODE_HOST", nullable = false, length = 128)
    public String getNode() {
        return node;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUS_ID", nullable = true)
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Column(name = "PASSWORD", length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "SEX", length = 16)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "MOBILE", unique = true, nullable = false, length = 16)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "EMAIL", length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ADDRESS", length = 1000)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public UserInfo toInfo(UserInfo userInfo, String... ignore) {
        super.toInfo(userInfo, "customer");
        if (this.getCustomer() != null) {
            userInfo.setCustomerId(this.getCustomer().getCode());
        }
        return userInfo;
    }

    @Override
    public UserEntity parseInfo(UserInfo info, String... ignore) throws BreezeeException {
        super.parseInfo(info, ignore);
        if (StringUtils.hasText(info.getCustomerId())) {
            CustomerEntity c = ContextUtil.getBean("customerRepository", ICustomerRepository.class).findByCode(info.getCustomerId());
            if (c == null)
                throw new BreezeeException("绑定的客户不存在");
            this.setCustomer(c);
        }
        if (StringUtils.isEmpty(info.getPassword())) {
            this.setPassword(BreezeeUtils.enCrypt(info.getCode() + "123"));
        }
        return this;
    }
}
