/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BizInfo;

/**
 * 库存信息
 * Created by Silence on 2016/6/11.
 */
public class InventoryInfo extends BizInfo {

    protected Double total;

    protected Double remain;

    protected Double hold;

    protected String unit;

    protected String factory;

    protected String location;

    /**
     * 库存类型，0：普通， 1：开放清单库存
     */
    protected Integer type;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getRemain() {
        return remain;
    }

    public void setRemain(Double remain) {
        this.remain = remain;
    }

    public Double getHold() {
        return hold;
    }

    public void setHold(Double hold) {
        this.hold = hold;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
