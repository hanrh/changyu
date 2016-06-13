/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.OrderShipmentInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单物流持久域实体
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_ORDER_SHP", schema = BaseEntity.DB_SCHEMA)
public class OrderShipmentEntity extends BaseEntity<OrderShipmentEntity, OrderShipmentInfo> {

    private OrderEntity order;

    private String shipMethod;

    private Boolean free;

    private String placer;

    private String consignee;

    private Double totalWeight;

    private String consignName;

    private String consignAddress;

    private String postCode;

    private String telephone;

    private String tax;

    private String taxAdd;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_ID")
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
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

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ORD_SHP_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ORD_SHP_CODE", length = 64)
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

}
