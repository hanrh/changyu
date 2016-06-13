/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved. 
 */

package org.breezee.pcm.entity;

import org.breezee.common.framework.BaseEntity;
import org.breezee.pcm.api.domain.ProductInfo;
import org.breezee.pcm.api.domain.ProductPriceInfo;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Set;

/**
 * 持久域：产品信息
 * Created by Silence on 2016/6/9.
 */
@Entity
@Table(name = "PCM_TF_PRODUCT", schema = BaseEntity.DB_SCHEMA)
public class ProductEntity extends BaseEntity<ProductEntity, ProductInfo> {

    private String brand;

    private String shortText;

    private String imageId;

    private String factory;

    private String grade;

    private String wrapped;

    private String volume;

    private Double karDivisor;

    private Double palDivisor;

    private Double divisor;

    private String group;

    private String measureUnit;

    private String saleUnit;

    private Double grossWeight;

    private Double netWeight;

    private Double bulk;

    private Set<ProductPriceEntity> productPriceEntitySet;

    private Set<ProductLimitEntity> productLimitEntitySet;

    private Set<ProductCustomerEntity> productCustomerEntitySet;

    @Id
    @GeneratedValue(generator = "assigned-uid")
    @GenericGenerator(name = "assigned-uid", strategy = "assigned")
    @Column(name = "PRT_ID", unique = true, nullable = false, updatable = false, length = 64)
    public String getId() {
        return id;
    }

    @Column(name = "PRT_CODE", unique = true, nullable = false, updatable = false, length = 64)
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

    @Column(name = "BRAND", length = 32)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "SHORT_TEXT", length = 3000)
    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    @Column(name = "IMAGE_ID", length = 255)
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Column(name = "FACTORY", length = 32)
    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    @Column(name = "B_GRADE", length = 32)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Column(name = "WRAPPED", length = 32)
    public String getWrapped() {
        return wrapped;
    }

    public void setWrapped(String wrapped) {
        this.wrapped = wrapped;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Double getKarDivisor() {
        return karDivisor;
    }

    public void setKarDivisor(Double karDivisor) {
        this.karDivisor = karDivisor;
    }

    public Double getPalDivisor() {
        return palDivisor;
    }

    public void setPalDivisor(Double palDivisor) {
        this.palDivisor = palDivisor;
    }

    public Double getDivisor() {
        return divisor;
    }

    public void setDivisor(Double divisor) {
        this.divisor = divisor;
    }

    @Column(name = "B_GROUP", length = 32)
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Column(name = "MEASURE_UNIT", length = 32)
    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Column(name = "SALE_UNIT", length = 32)
    public String getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getBulk() {
        return bulk;
    }

    public void setBulk(Double bulk) {
        this.bulk = bulk;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "endTime DESC")
    public Set<ProductPriceEntity> getProductPriceEntitySet() {
        return productPriceEntitySet;
    }

    public void setProductPriceEntitySet(Set<ProductPriceEntity> productPriceEntitySet) {
        this.productPriceEntitySet = productPriceEntitySet;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "endTime DESC")
    public Set<ProductLimitEntity> getProductLimitEntitySet() {
        return productLimitEntitySet;
    }

    public void setProductLimitEntitySet(Set<ProductLimitEntity> productLimitEntitySet) {
        this.productLimitEntitySet = productLimitEntitySet;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<ProductCustomerEntity> getProductCustomerEntitySet() {
        return productCustomerEntitySet;
    }

    public void setProductCustomerEntitySet(Set<ProductCustomerEntity> productCustomerEntitySet) {
        this.productCustomerEntitySet = productCustomerEntitySet;
    }

    @Transactional
    public ProductInfo toInfo(ProductInfo info, String... ignore) {
        super.toInfo(info, ignore);
        this.getProductPriceEntitySet().forEach(a -> {
            info.addPrice(a.toInfo(ProductPriceInfo.class));
        });
        return info;
    }
}
