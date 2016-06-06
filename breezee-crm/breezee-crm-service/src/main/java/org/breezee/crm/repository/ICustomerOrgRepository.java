/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.crm.api.domain.CustomerOrgInfo;
import org.breezee.crm.entity.CustomerOrgEntity;
import org.springframework.stereotype.Repository;

/**
 * 客户所属组织信息持久化服务
 * Created by Silence on 2016/6/4.
 */
@Repository("customerOrgRepository")
public interface ICustomerOrgRepository extends
        ICommonRepository<CustomerOrgEntity, CustomerOrgInfo, String> {
}
