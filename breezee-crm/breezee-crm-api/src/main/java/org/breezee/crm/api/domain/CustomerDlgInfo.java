/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.api.domain;

import org.breezee.common.domain.BizInfo;

/**
 * 实体域：客户委托，即此客户委托给谁可以帮其办理业务
 * Created by Silence on 2016/6/4.
 */
public class CustomerDlgInfo extends BizInfo {

    /**
     * 账号标识
     */
    protected String accountCode;

    /**
     * 客户标识
     */
    protected String customerId;

    /**
     * 代理范围
     */
    protected Integer delegateType;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getDelegateType() {
        return delegateType;
    }

    public void setDelegateType(Integer delegateType) {
        this.delegateType = delegateType;
    }
}
