/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.OrderLineInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单行持久化实体
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_ORDER_LINE", schema = BaseEntity.DB_SCHEMA)
public class OrderLineEntity extends BaseEntity<OrderLineEntity, OrderLineInfo> {

    private OrderEntity order;

    private SapPushEntity sapPush;

    private Integer quantity;

    private Double price;

    private Double additionPrice;

    private Double returnPrice;

    private String unit;

    private Double grossWeight;

    private Double adjustPrice;

    private Integer source;

    private String planLineId;

    private String productOpenId;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ORD_LINE_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ORD_LINE_CODE", nullable = false, updatable = false, length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "CREATOR", nullable = false, updatable = false, length = 64)
    public String getCreator() {
        return creator;
    }

    @Column(name = "CREATE_TIME", nullable = false, updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    @Column(name = "UPDATOR", nullable = false, length = 64)
    public String getUpdator() {
        return updator;
    }

    @Column(name = "UPDATE_TIME", nullable = false)
    public Date getUpdateTime() {
        return updateTime;
    }

    @Column(name = "REMARK", length = 3000)
    public String getRemark() {
        return remark;
    }

    @Column(name = "ROW_NUM", nullable = false)
    public Long getRowNum() {
        return rowNum;
    }

    @Column(name = "VERSION", nullable = false)
    public Integer getVersion() {
        return version;
    }

    @Column(name = "STATUS", nullable = false)
    public Integer getStatus() {
        return this.status;
    }

    @Column(name = "NODE_HOST", nullable = false, length = 128)
    public String getNode() {
        return node;
    }

    @Column(name = "EQUIPMENT", nullable = false)
    public Integer getEquipment() {
        return equipment;
    }

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_ID")
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @OneToOne(mappedBy = "orderLine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public SapPushEntity getSapPush() {
        return sapPush;
    }

    public void setSapPush(SapPushEntity sapPush) {
        this.sapPush = sapPush;
    }

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

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getAdjustPrice() {
        return adjustPrice;
    }

    public void setAdjustPrice(Double adjustPrice) {
        this.adjustPrice = adjustPrice;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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
}
