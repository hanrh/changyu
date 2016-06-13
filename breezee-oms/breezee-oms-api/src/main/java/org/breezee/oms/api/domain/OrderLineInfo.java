/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * 实体域：订单行信息对象
 * <p>
 * 订单和订单项一样是一个内聚的关系
 * 我们是没有什么情况会绕开订单实体，直接对订单行做操作的
 * 我们对 OrderLineItem的所有的操作都是以Order为出发点，
 * 我们总是会面向整个Order在做业务操作，
 * 比如向Order中增加明细，修改 Order的某个明细对应的商品的购买数量，
 * 从Order中移除某个明细，等等类似操作，我们从来不会从OrderLineInfo为出发点去执行一些业务操作；
 * 另外，从生命周期的角度去理解，那么OrderLineInfo离开Order没有任何存在的意义，也就是说OrderLineInfo的生命周期是从属于Order的
 * <p>
 * Created by Silence on 2016/4/26.
 */
public class OrderLineInfo extends BaseInfo {

    /**
     * 数量,必须大于0
     */
    protected Integer quantity;

    /**
     * 价格
     */
    protected Double price;

    /**
     * 产品保证金价格
     */
    protected Double additionPrice;

    /**
     * 退货价格，只在退货的时候存在
     */
    protected Double returnPrice;

    /**
     * 单位
     */
    protected String unit;

    /**
     * 产品毛重
     */
    protected Double grossWeight;

    /**
     * 省公司调整的价格，增量值
     */
    protected Double adjustPrice;

    /**
     * 来源：0：计划，1：开放清单
     */
    protected Integer source;

    /**
     * 关联计划行编号，只有在source=0
     */
    protected String planLineId;

    /**
     * 开放清单编号，只有在source=1
     */
    protected String productOpenId;

    /**
     * sap推送的信息，只有在status=uploaded之后才存在
     */
    protected SapPushInfo sapPushInfo;

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

    public Double getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(Double returnPrice) {
        this.returnPrice = returnPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getAdjustPrice() {
        return adjustPrice;
    }

    public void setAdjustPrice(Double adjustPrice) {
        this.adjustPrice = adjustPrice;
    }

    public String getPlanLineId() {
        return planLineId;
    }

    public void setPlanLineId(String planLineId) {
        this.planLineId = planLineId;
    }

    public String getProductOpenId() {
        return productOpenId;
    }

    public void setProductOpenId(String productOpenId) {
        this.productOpenId = productOpenId;
    }

    public SapPushInfo getSapPushInfo() {
        return sapPushInfo;
    }

    public void setSapPushInfo(SapPushInfo sapPushInfo) {
        this.sapPushInfo = sapPushInfo;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
