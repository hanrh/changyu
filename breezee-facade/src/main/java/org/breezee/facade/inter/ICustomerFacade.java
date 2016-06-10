/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.inter;

import org.breezee.common.domain.IFacadeLayer;
import org.breezee.crm.api.domain.CustomerInfo;
import org.breezee.facade.response.Response;

/**
 * 客户服务对外暴露服务接口
 * Created by Silence on 2016/6/10.
 */
public interface ICustomerFacade extends IFacadeLayer {

    Response<CustomerInfo> pageCustomer(CustomerInfo info);

    Response<CustomerInfo> findCustomerById(String id);
}
