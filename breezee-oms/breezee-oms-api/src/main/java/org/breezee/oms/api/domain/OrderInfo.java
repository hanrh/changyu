/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import java.util.List;

/**
 * 实体域，聚合根：订单信息对象
 * 订单拆分为以下几个信息，基本信息，物料信息(orderLineInfo), Fico信息(orderFico), 物流信息(orderShipment)，任何一个都不可以为空
 * <p>
 * Order必须有对应的客户信息，否则就不能称为一个有效的Order
 * 同理，Order对OrderLineItem有不变性约束，Order也必须至少有一个OrderLineInfo，否则就不能称为一个有效的Order
 * 另外，Order中的任何OrderLineItem的数量都不能为0，否则认为该OrderLineItem是无效的
 * Created by Silence on 2016/4/26.
 */
public class OrderInfo extends FlowInfo {

    protected OrderFicoInfo orderFico;

    protected OrderShipmentInfo orderShipment;

    protected List<OrderLineInfo> orderLines;

    /**
     * 分销渠道
     */
    protected String distribution;

    /**
     * 关闭时间
     */
    protected String closeTime;

    /**
     * 汇款备注
     */
    protected String remitComment;

    /**
     * 库存地点
     */
    protected String stockRoom;

    /**
     * 退货原因
     */
    protected String returnReason;

    public OrderFicoInfo getOrderFico() {
        return orderFico;
    }

    public void setOrderFico(OrderFicoInfo orderFico) {
        this.orderFico = orderFico;
    }

    public OrderShipmentInfo getOrderShipment() {
        return orderShipment;
    }

    public void setOrderShipment(OrderShipmentInfo orderShipment) {
        this.orderShipment = orderShipment;
    }

    public List<OrderLineInfo> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineInfo> orderLines) {
        this.orderLines = orderLines;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getRemitComment() {
        return remitComment;
    }

    public void setRemitComment(String remitComment) {
        this.remitComment = remitComment;
    }

    public String getStockRoom() {
        return stockRoom;
    }

    public void setStockRoom(String stockRoom) {
        this.stockRoom = stockRoom;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }
}
