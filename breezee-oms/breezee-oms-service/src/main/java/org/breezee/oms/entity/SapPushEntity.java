/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.SapPushInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * SAP推送的信息持久化
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_ORDER_PUSH", schema = BaseEntity.DB_SCHEMA)
public class SapPushEntity extends BaseEntity<SapPushEntity, SapPushInfo> {

    private OrderLineEntity orderLine;

    private String sellNo;

    private String deliveryNo;

    private String billNo;

    private String goldenTax;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_LINE_ID")
    public OrderLineEntity getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLineEntity orderLine) {
        this.orderLine = orderLine;
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

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "SAP_PUS_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "SAP_PUS_CODE", length = 32)
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

    @Column(name = "ROW_NUM", nullable = false)
    public Long getRowNum() {
        return rowNum;
    }

    @Column(name = "VERSION", nullable = false)
    public Integer getVersion() {
        return version;
    }

    @Column(name = "NODE_HOST", nullable = false, length = 128)
    public String getNode() {
        return node;
    }
}
