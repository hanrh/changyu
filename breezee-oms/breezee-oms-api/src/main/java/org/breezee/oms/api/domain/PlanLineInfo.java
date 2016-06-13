/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BaseInfo;

import java.util.Date;

/**
 * 实体域：计划行信息对象
 * Created by Silence on 2016/4/26.
 */
public class PlanLineInfo extends BaseInfo {

    /**
     * 所属计划主体
     */
    protected PlanInfo planInfo;

    /**
     * 计划数量，数量不可以为0
     */
    protected Integer quantity;

    /**
     * 价格
     */
    protected Double price;

    /**
     * 保证金价格
     */
    protected Double additionPrice;

    protected SapAdjustmentInfo sapAdjustment;

    /**
     * 已消耗数量
     */
    protected Integer usedQuantity;

    /**
     * 单位
     */
    protected String unit;

    /**
     * 类型：0:非直发，1：直发
     */
    protected Boolean direct;

    /**
     * 关闭人
     */
    protected String closer;

    /**
     * 关闭原因
     */
    protected String closeReason;

    /**
     * 关闭时间
     */
    protected Date closeTime;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAdditionPrice() {
        return additionPrice;
    }

    public void setAdditionPrice(Double additionPrice) {
        this.additionPrice = additionPrice;
    }

    public SapAdjustmentInfo getSapAdjustment() {
        return sapAdjustment;
    }

    public void setSapAdjustment(SapAdjustmentInfo sapAdjustment) {
        this.sapAdjustment = sapAdjustment;
    }

    public Integer getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(Integer usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getDirect() {
        return direct;
    }

    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

    public String getCloser() {
        return closer;
    }

    public void setCloser(String closer) {
        this.closer = closer;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public PlanInfo getPlanInfo() {
        return planInfo;
    }

    public void setPlanInfo(PlanInfo planInfo) {
        this.planInfo = planInfo;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
