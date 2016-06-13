/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.PlanLineInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 计划行持久
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_PLAN_LINE", schema = BaseEntity.DB_SCHEMA)
public class PlanLineEntity extends BaseEntity<PlanLineEntity, PlanLineInfo> {

    private PlanEntity plan;

    private SapAdjustmentEntity sapAdjustment;

    private Integer quantity;

    private Double price;

    private Double additionPrice;

    private Integer usedQuantity;

    private String unit;

    private Boolean direct;

    private String closer;

    private String closeReason;

    private Date closeTime;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PLN_ID")
    public PlanEntity getPlan() {
        return plan;
    }

    public void setPlan(PlanEntity plan) {
        this.plan = plan;
    }

    @OneToOne(mappedBy = "planLine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public SapAdjustmentEntity getSapAdjustment() {
        return sapAdjustment;
    }

    public void setSapAdjustment(SapAdjustmentEntity sapAdjustment) {
        this.sapAdjustment = sapAdjustment;
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

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "PLN_LINE_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "PLN_LINE_CODE", nullable = false, updatable = false, length = 64)
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

    public PlanLineEntity parseInfo(PlanLineInfo info, String... ignore) throws BreezeeException {
        if (this.getQuantity() == null || this.getQuantity() < 1) {
            throw new BreezeeException("数量不可以小于1");
        }
        super.parseInfo(info, ignore);
        if (info.getSapAdjustment() != null)
            this.setSapAdjustment(new SapAdjustmentEntity().parseInfo(info.getSapAdjustment()));
        return this;
    }
}
