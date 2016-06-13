/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * SAP调整的信息，目前只有计划行会被调整掉
 * Created by Silence on 2016/6/12.
 */
public class SapAdjustmentInfo extends BaseInfo {

    protected String planLineId;

    /**
     * SAP调整数量
     */
    protected Integer quantity;

    /**
     * SAP的单位
     */
    protected String unit;

    public String getPlanLineId() {
        return planLineId;
    }

    public void setPlanLineId(String planLineId) {
        this.planLineId = planLineId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
