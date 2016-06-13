/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.pcm.api.domain.ProductOpenInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 开放清单持久域
 * Created by Silence on 2016/6/10.
 */
@Entity
@Table(name = "PCM_TF_PRODUCT_OPEN", schema = BaseEntity.DB_SCHEMA)
public class ProductOpenEntity extends BaseEntity<ProductOpenEntity, ProductOpenInfo> {

    private ProductEntity product;

    private String province;

    private Integer source;

    private String unit;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "OPN_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "OPN_CODE", length = 64)
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

    @Column(name = "CHANNEL", length = 32)
    public String getChannel() {
        return channel;
    }

    @Column(name = "COMPANY", length = 32)
    public String getCompany() {
        return company;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRT_ID")
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ProductOpenInfo toInfo(ProductOpenInfo info, String... ignore) {
        super.toInfo(info, ignore);
        if (this.getProduct() != null) {
            info.setProductId(this.getProduct().getId());
            info.setShortText(this.getProduct().getShortText());
        }
        return info;
    }
}
