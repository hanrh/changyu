/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.pcm.api.domain.ProductPriceInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 产品价格持久域
 * Created by Silence on 2016/6/9.
 */
@Entity
@Table(name = "PCM_TF_PRODUCT_PRICE", schema = BaseEntity.DB_SCHEMA)
public class ProductPriceEntity extends BaseEntity<ProductPriceEntity, ProductPriceInfo> {

    private ProductEntity product;

    private Date startTime;

    private Date endTime;

    private String unit;

    private String province;

    private Double baseValue;

    private Double addInValue;

    private String customerId;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "PRC_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "PRC_CODE", length = 64)
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

    @Column(name = "STATUS", nullable = false)
    public Integer getStatus() {
        return this.status;
    }

    @Column(name = "NODE_HOST", nullable = false, length = 128)
    public String getNode() {
        return node;
    }

    @Column(name = "COMPANY", length = 32)
    public String getCompany() {
        return company;
    }

    @Column(name = "CHANNEL", length = 32)
    public String getChannel() {
        return channel;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRT_ID")
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
    }

    public Double getAddInValue() {
        return addInValue;
    }

    public void setAddInValue(Double addInValue) {
        this.addInValue = addInValue;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
