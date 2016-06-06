/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.crm.api.domain.CustomerFicoInfo;
import org.breezee.crm.entity.CustomerFicoEntity;
import org.springframework.stereotype.Repository;

/**
 * 客户财务信息持久化服务
 * Created by Silence on 2016/6/4.
 */
@Repository("customerFicoRepository")
public interface ICustomerFicoRepository extends
        ICommonRepository<CustomerFicoEntity, CustomerFicoInfo, String> {
}
