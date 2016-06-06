/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.crm.api.domain.CustomerInfo;
import org.breezee.crm.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

/**
 * 客户持久化服务
 * Created by Silence on 2016/6/4.
 */
@Repository("customerRepository")
public interface ICustomerRepository extends
        ICommonRepository<CustomerEntity, CustomerInfo, String> {
}
