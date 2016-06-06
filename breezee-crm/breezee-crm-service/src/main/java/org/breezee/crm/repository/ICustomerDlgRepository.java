/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.crm.api.domain.CustomerDlgInfo;
import org.breezee.crm.entity.CustomerDlgEntity;
import org.springframework.stereotype.Repository;

/**
 * 客户代理持久化服务
 * Created by Silence on 2016/6/4.
 */
@Repository("customerDlgRepository")
public interface ICustomerDlgRepository extends ICommonRepository<CustomerDlgEntity, CustomerDlgInfo, String> {
}
