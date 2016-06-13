/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.entity;

import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.common.framework.BaseEntity;
import org.breezee.oms.api.domain.PlanInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 计划实体持久域
 * Created by Silence on 2016/6/12.
 */
@Entity
@Table(name = "OMS_TF_PLAN", schema = BaseEntity.DB_SCHEMA)
public class PlanEntity extends BaseEntity<PlanEntity, PlanInfo> {

    private Set<PlanLineEntity> planLines;

    private String type;

    private String customerId;

    private String customerName;

    private String province;

    private String city;

    private String department;

    private Date month;

    private Double rated;

    private String submitor;

    private Date submitTime;

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

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Double getRated() {
        return rated;
    }

    public void setRated(Double rated) {
        this.rated = rated;
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

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<PlanLineEntity> getPlanLines() {
        return planLines;
    }

    public void setPlanLines(Set<PlanLineEntity> planLines) {
        this.planLines = planLines;
    }

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "PLN_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "PLN_CODE", unique = true, nullable = false, updatable = false, length = 64)
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

    public PlanEntity parseInfo(PlanInfo info, String... ignore) throws BreezeeException {
        if (info.getLineInfoList() == null || info.getLineInfoList().size() == 0) {
            throw new BreezeeException("计划行不可为空");
        }
        super.parseInfo(info, ignore);
        this.setPlanLines(new HashSet<>());
        info.getLineInfoList().forEach(a -> {
            this.getPlanLines().add(new PlanLineEntity().parseInfo(a));
        });
        return this;
    }
}
