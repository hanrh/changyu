/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.crm.api.domain.CustomerDlgInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 持久域：客户代理的持久
 * Created by Silence on 2016/6/4.
 */
@Entity
@Table(name = "CRM_TF_CUSTOMER_DLG", schema = BaseEntity.DB_SCHEMA)
public class CustomerDlgEntity extends BaseEntity<CustomerDlgEntity, CustomerDlgInfo> {

    /**
     * 代理账号
     */
    private String accountCode;
    /**
     * 代理的类型：计划/订单/全部
     */
    private Integer delegateType;
    /**
     * 客户主体
     */
    private CustomerEntity customer;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "CUS_DLG_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "CODE", length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "COMPANY", nullable = false, length = 32)
    public String getCompany() {
        return company;
    }

    @Column(name = "CHANNEL", nullable = false, length = 32)
    public String getChannel() {
        return channel;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUS_ID", nullable = false)
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Column(name = "CUS_ACN_CODE", nullable = false, length = 64)
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    @Column(name = "DLG_TYPE", nullable = false)
    public Integer getDelegateType() {
        return delegateType;
    }

    public void setDelegateType(Integer delegateType) {
        this.delegateType = delegateType;
    }
}
