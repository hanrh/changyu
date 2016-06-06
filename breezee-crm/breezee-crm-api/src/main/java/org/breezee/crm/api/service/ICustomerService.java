/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.crm.api.domain.CustomerInfo;

/**
 * 服务域：客户管理服务
 * Created by Silence on 2016/6/4.
 */
public interface ICustomerService<E> extends IServiceLayer<CustomerInfo, E> {

    @Override
    default Class<CustomerInfo> getInfoClass() {
        return CustomerInfo.class;
    }
}
