/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.crm.api.domain.CustomerInfo;
import org.breezee.crm.api.service.ICustomerService;
import org.breezee.crm.entity.CustomerEntity;
import org.springframework.stereotype.Service;

/**
 * 服务域：客户服务
 * Created by Silence on 2016/6/4.
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService<CustomerEntity> {


    @Override
    public IRepository<CustomerInfo> getRepository() {
        return null;
    }

    @Override
    public Class<CustomerEntity> getEntityClass() {
        return null;
    }
}
