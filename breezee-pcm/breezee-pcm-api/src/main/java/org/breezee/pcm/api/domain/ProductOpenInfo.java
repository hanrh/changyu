/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.api.domain;

import org.breezee.common.domain.BizInfo;

/**
 * 开放清单产品信息
 * Created by Silence on 2016/6/10.
 */
public class ProductOpenInfo extends BizInfo {

    protected String productId;

    protected String province;

    protected Integer source;

    protected String unit;

    protected String shortText;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }
}
