/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.api.domain;

import org.breezee.common.domain.BizInfo;

import java.util.Date;

/**
 * 产品价格信息
 * Created by Silence on 2016/6/9.
 */
public class ProductPriceInfo extends BizInfo {

    protected String productId;

    protected Date startTime;

    protected Date endTime;

    protected String unit;

    protected String province;

    protected Double baseValue;

    protected Double addInValue;

    protected String customerId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
    }

    public Double getAddInValue() {
        return addInValue;
    }

    public void setAddInValue(Double addInValue) {
        this.addInValue = addInValue;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
