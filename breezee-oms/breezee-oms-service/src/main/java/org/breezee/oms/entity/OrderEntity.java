/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.OrderInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 订单实体持久域
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_ORDER", schema = BaseEntity.DB_SCHEMA)
public class OrderEntity extends BaseEntity<OrderEntity, OrderInfo> {

    private OrderFicoEntity orderFico;

    private OrderShipmentEntity orderShipment;

    private Set<OrderLineEntity> orderLines;

    private String type;

    private String customerId;

    private String customerName;

    private String province;

    private String city;

    private String department;

    private String submitor;

    private Date submitTime;

    private String distribution;

    private String closeTime;

    private String remitComment;

    private String stockRoom;

    private String returnReason;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ORD_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ORD_CODE", unique = true, nullable = false, updatable = false, length = 64)
    public String getCode() {
        return code;
    }

    @Column(name = "TENANT_ID", nullable = false, updatable = false, length = 64)
    public String getTenantId() {
        return tenantId;
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

    @Column(name = "COMPANY", nullable = false, length = 32)
    public String getCompany() {
        return company;
    }

    @Column(name = "CHANNEL", nullable = false, length = 32)
    public String getChannel() {
        return channel;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubmitor() {
        return submitor;
    }

    public void setSubmitor(String submitor) {
        this.submitor = submitor;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
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

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public OrderFicoEntity getOrderFico() {
        return orderFico;
    }

    public void setOrderFico(OrderFicoEntity orderFico) {
        this.orderFico = orderFico;
    }

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public OrderShipmentEntity getOrderShipment() {
        return orderShipment;
    }

    public void setOrderShipment(OrderShipmentEntity orderShipment) {
        this.orderShipment = orderShipment;
    }

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<OrderLineEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }
}
