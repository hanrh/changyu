/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.crm.api.domain.CustomerInfo;
import org.breezee.crm.api.service.ICustomerService;
import org.breezee.crm.entity.CustomerEntity;
import org.breezee.crm.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务域：客户服务
 * Created by Silence on 2016/6/4.
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService<CustomerEntity> {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public IRepository<CustomerInfo> getRepository() {
        return customerRepository;
    }

    @Override
    public Class<CustomerEntity> getEntityClass() {
        return CustomerEntity.class;
    }
}
