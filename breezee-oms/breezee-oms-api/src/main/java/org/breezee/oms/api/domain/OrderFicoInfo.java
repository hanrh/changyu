/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.domain;

import org.breezee.common.domain.BaseInfo;

/**
 * 订单的Fico信息，在此对订单的约束条件以及订单金额的计算
 * Created by Silence on 2016/6/12.
 */
public class OrderFicoInfo extends BaseInfo {

    protected OrderInfo order;

    /**
     * 付款方
     */
    protected String payer;

    /**
     * 收票方
     */
    protected String rcdInvoice;

    /**
     * 附加价格*数量 = 保证金
     */
    protected Double totalDeposit;

    /**
     * 最终价格*数量 = 货款
     */
    protected Double totalPayment;

    /**
     * 保证金+货款=总汇款
     */
    protected Double totalRemittances;

    /**
     * 预算申请单号
     */
    protected String budgetApply;

    /**
     * 预算预留单号
     */
    protected String budgetObligate;

    /**
     * 预算预留行项目号
     */
    protected String obligateRow;

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
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

}
