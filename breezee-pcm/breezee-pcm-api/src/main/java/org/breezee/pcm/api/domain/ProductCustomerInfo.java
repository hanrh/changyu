/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * 产品客户限售信息
 * Created by Silence on 2016/6/9.
 */
public class ProductCustomerInfo extends BaseInfo {

    protected ProductInfo product;

    /**
     * 从那个限售中获取过来的
     */
    protected String limitId;

    protected String customerId;

    /**
     * 试用范围 -1：计划, 0：全部, 1：订单
     */
    protected Integer scope;

    public ProductInfo getProduct() {
        return product;
    }

    public void setProduct(ProductInfo product) {
        this.product = product;
    }

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
}
