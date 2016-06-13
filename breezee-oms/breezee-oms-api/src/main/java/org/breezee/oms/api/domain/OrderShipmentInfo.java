/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * 订单物流信息
 * Created by Silence on 2016/6/12.
 */
public class OrderShipmentInfo extends BaseInfo {

    protected String orderId;

    /**
     * 装运方式
     */
    protected String shipMethod;

    /**
     * 是否免运费
     */
    protected Boolean free;

    /**
     * 售达方，一般值下单人
     */
    protected String placer;

    /**
     * 送达方，一般指收货人。
     * 需要校验此值在客户主数据中，是否存在
     */
    protected String consignee;

    /**
     * 总重量
     */
    protected Double totalWeight;

    private String consignName;

    private String consignAddress;

    private String postCode;

    private String telephone;

    /**
     * 税号1
     */
    private String tax;

    /**
     * 附加税号
     */
    private String taxAdd;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(String shipMethod) {
        this.shipMethod = shipMethod;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getPlacer() {
        return placer;
    }

    public void setPlacer(String placer) {
        this.placer = placer;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getConsignName() {
        return consignName;
    }

    public void setConsignName(String consignName) {
        this.consignName = consignName;
    }

    public String getConsignAddress() {
        return consignAddress;
    }

    public void setConsignAddress(String consignAddress) {
        this.consignAddress = consignAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxAdd() {
        return taxAdd;
    }

    public void setTaxAdd(String taxAdd) {
        this.taxAdd = taxAdd;
    }
}
