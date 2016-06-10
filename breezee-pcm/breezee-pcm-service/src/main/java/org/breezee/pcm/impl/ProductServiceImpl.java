/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.common.domain.InfoPage;
import org.breezee.common.framework.DynamicSpecifications;
import org.breezee.common.framework.page.PageInfo;
import org.breezee.pcm.api.domain.ProductCustomerInfo;
import org.breezee.pcm.api.domain.ProductInfo;
import org.breezee.pcm.api.domain.ProductLimitInfo;
import org.breezee.pcm.api.domain.ProductOpenInfo;
import org.breezee.pcm.api.service.IProductService;
import org.breezee.pcm.entity.ProductCustomerEntity;
import org.breezee.pcm.entity.ProductEntity;
import org.breezee.pcm.entity.ProductLimitEntity;
import org.breezee.pcm.entity.ProductOpenEntity;
import org.breezee.pcm.repository.IProductCustomerRepository;
import org.breezee.pcm.repository.IProductLimitRepository;
import org.breezee.pcm.repository.IProductOpenRepository;
import org.breezee.pcm.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品管理服务实现类
 * Created by Silence on 2016/6/9.
 */
@Service("productService")
public class ProductServiceImpl implements IProductService<ProductEntity> {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductCustomerRepository productCustomerRepository;

    @Autowired
    private IProductLimitRepository productLimitRepository;

    @Autowired
    private IProductOpenRepository productOpenRepository;

    @Override
    public IRepository<ProductInfo> getRepository() {
        return productRepository;
    }

    @Override
    public Class<ProductEntity> getEntityClass() {
        return ProductEntity.class;
    }

    @Override
    public InfoPage pageByCustomer(ProductCustomerInfo customerInfo) {
        PageInfo pageInfo = new PageInfo(customerInfo.getProperties());
        Page<ProductCustomerEntity> page = productCustomerRepository.findAll(DynamicSpecifications.createSpecification(customerInfo.getProperties()), pageInfo);
        List<Object> l = new ArrayList<>();
        page.getContent().forEach(a -> {
            l.add(a.getProductLimit().getProduct().toInfo(ProductInfo.class));
        });
        InfoPage p = new InfoPage();
        p.setContent(l);
        p.setTotal(page.getTotalElements());
        return p;
    }

    @Override
    public InfoPage pageByLimit(ProductLimitInfo info) {
        PageInfo pageInfo = new PageInfo(info.getProperties());
        Page<ProductLimitEntity> page = productLimitRepository.findAll(DynamicSpecifications.createSpecification(info.getProperties()), pageInfo);
        List<Object> l = new ArrayList<>();
        page.getContent().forEach(a -> {
            l.add(a.getProduct().toInfo(ProductInfo.class));
        });
        InfoPage p = new InfoPage();
        p.setContent(l);
        p.setTotal(page.getTotalElements());
        return p;
    }

    @Override
    public List<ProductLimitInfo> listLimit(ProductLimitInfo info) {
        return productLimitRepository.listAll(info, ProductLimitInfo.class);
    }

    @Override
    public InfoPage customerOpenProduct(ProductCustomerInfo info) {
        PageInfo pageInfo = new PageInfo(info.getProperties());
        Page<ProductOpenEntity> page = productOpenRepository.customerOpenProduct(info.getCustomerId(), info.getScope(), pageInfo);
        List<Object> l = new ArrayList<>();
        page.getContent().forEach(a -> {
            l.add(a.getProduct().toInfo(ProductInfo.class));
        });
        InfoPage p = new InfoPage();
        p.setContent(l);
        p.setTotal(page.getTotalElements());
        return p;
    }

    @Override
    public InfoPage pageByOpen(ProductOpenInfo info) {
        return productOpenRepository.pageAll(info, ProductOpenInfo.class);
    }

}
