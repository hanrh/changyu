/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * SAP推送下来的信息，主要针对订单行
 * Created by Silence on 2016/6/12.
 */
public class SapPushInfo extends BaseInfo {

    protected String orderLineId;

    /**
     * 销售凭证
     */
    protected String sellNo;

    /**
     * 交货凭证
     */
    protected String deliveryNo;

    /**
     * 发票号
     */
    protected String billNo;

    /**
     * 金税号
     */
    protected String goldenTax;

    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    public String getSellNo() {
        return sellNo;
    }

    public void setSellNo(String sellNo) {
        this.sellNo = sellNo;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getGoldenTax() {
        return goldenTax;
    }

    public void setGoldenTax(String goldenTax) {
        this.goldenTax = goldenTax;
    }
}
