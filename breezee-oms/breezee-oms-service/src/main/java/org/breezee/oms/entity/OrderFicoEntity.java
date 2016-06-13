/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.OrderFicoInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单财务信息持久域
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_ORDER_FICO", schema = BaseEntity.DB_SCHEMA)
public class OrderFicoEntity extends BaseEntity<OrderFicoEntity, OrderFicoInfo> {

    private OrderEntity order;

    private String payer;

    private String rcdInvoice;

    private Double totalDeposit;

    private Double totalPayment;

    private Double totalRemittances;

    private String budgetApply;

    private String budgetObligate;

    private String obligateRow;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_ID")
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getRcdInvoice() {
        return rcdInvoice;
    }

    public void setRcdInvoice(String rcdInvoice) {
        this.rcdInvoice = rcdInvoice;
    }

    public Double getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(Double totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Double getTotalRemittances() {
        return totalRemittances;
    }

    public void setTotalRemittances(Double totalRemittances) {
        this.totalRemittances = totalRemittances;
    }

    public String getBudgetApply() {
        return budgetApply;
    }

    public void setBudgetApply(String budgetApply) {
        this.budgetApply = budgetApply;
    }

    public String getBudgetObligate() {
        return budgetObligate;
    }

    public void setBudgetObligate(String budgetObligate) {
        this.budgetObligate = budgetObligate;
    }

    public String getObligateRow() {
        return obligateRow;
    }

    public void setObligateRow(String obligateRow) {
        this.obligateRow = obligateRow;
    }

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "ORD_FIC_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "ORD_FIC_CODE", length = 32)
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
