/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.api.domain;

import org.breezee.common.domain.BizInfo;

import java.util.Date;

/**
 * 产品限售信息
 * Created by Silence on 2016/6/9.
 */
public class ProductLimitInfo extends BizInfo {

    protected String productId;

    protected Date startTime;

    protected Date endTime;

    /**
     * 来源
     * 0：SAP；1：手动添加
     */
    protected Integer source;

    protected String province;

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
