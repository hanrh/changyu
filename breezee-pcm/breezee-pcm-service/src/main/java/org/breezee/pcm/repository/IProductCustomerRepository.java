/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.pcm.api.domain.ProductCustomerInfo;
import org.breezee.pcm.entity.ProductCustomerEntity;
import org.springframework.stereotype.Repository;

/**
 * 客户限售持久化服务
 * Created by Silence on 2016/6/9.
 */
@Repository("productCustomerRepository")
public interface IProductCustomerRepository extends
        ICommonRepository<ProductCustomerEntity, ProductCustomerInfo, String> {
}
