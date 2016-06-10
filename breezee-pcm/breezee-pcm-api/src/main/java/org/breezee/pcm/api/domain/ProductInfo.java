/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.api.domain;

import org.breezee.common.domain.BaseInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体域,聚合根: 产品信息
 * Created by Silence on 2016/6/9.
 */
public class ProductInfo extends BaseInfo {

    protected List<ProductPriceInfo> priceInfoList;

    /**
     * 品牌
     */
    protected String brand;

    /**
     * 简短描述
     */
    protected String shortText;

    /**
     * 图片列表，以逗号分开多个
     */
    protected String imageId;

    /**
     * 交货工厂
     */
    protected String factory;

    /**
     * 档次
     */
    protected String grade;

    /**
     * 包装分类
     */
    protected String wrapped;

    /**
     * 容量
     */
    protected String volume;

    /**
     * 箱因子
     */
    protected String karDivisor;

    /**
     * 托因子
     */
    protected String palDivisor;

    /**
     * 箱托因子
     */
    protected String divisor;

    /**
     * 物料组
     */
    protected String group;

    /**
     * 计量单位
     */
    protected String measureUnit;

    /**
     * 销售单位
     */
    protected String saleUnit;

    /**
     * 毛重
     */
    protected Double grossWeight;

    /**
     * 净重
     */
    protected Double netWeight;

    /**
     * 体积
     */
    protected Double bulk;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

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

    public String getKarDivisor() {
        return karDivisor;
    }

    public void setKarDivisor(String karDivisor) {
        this.karDivisor = karDivisor;
    }

    public String getPalDivisor() {
        return palDivisor;
    }

    public void setPalDivisor(String palDivisor) {
        this.palDivisor = palDivisor;
    }

    public String getDivisor() {
        return divisor;
    }

    public void setDivisor(String divisor) {
        this.divisor = divisor;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

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

    public List<ProductPriceInfo> getPriceInfoList() {
        return priceInfoList;
    }

    public void setPriceInfoList(List<ProductPriceInfo> priceInfoList) {
        this.priceInfoList = priceInfoList;
    }

    public void addPrice(ProductPriceInfo priceInfo) {
        if (priceInfoList == null)
            priceInfoList = new ArrayList<>();
        priceInfo.setProductId(this.getId());
        priceInfoList.add(priceInfo);
    }
}
