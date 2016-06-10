/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.pcm.api.domain.ProductLimitInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 产品限售持久域
 * Created by Silence on 2016/6/9.
 */
@Entity
@Table(name = "PCM_TF_PRODUCT_LIMIT")
public class ProductLimitEntity extends BaseEntity<ProductLimitEntity, ProductLimitInfo> {

    private Set<ProductCustomerEntity> productCustomerEntitySet;

    private ProductEntity product;

    private Date startTime;

    private Date endTime;

    /**
     * 来源
     * 0：SAP；1：手动添加
     */
    private Integer source;

    private String province;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "LMT_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "LMT_CODE", length = 64)
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

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRT_ID")
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @OneToMany(mappedBy = "productLimit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<ProductCustomerEntity> getProductCustomerEntitySet() {
        return productCustomerEntitySet;
    }

    public void setProductCustomerEntitySet(Set<ProductCustomerEntity> productCustomerEntitySet) {
        this.productCustomerEntitySet = productCustomerEntitySet;
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public ProductLimitInfo toInfo(ProductLimitInfo info, String... ignore) {
        super.toInfo(info, ignore);
        if (this.getProduct() != null) {
            info.setProductId(this.getProduct().getId());
        }
        return info;
    }
}
