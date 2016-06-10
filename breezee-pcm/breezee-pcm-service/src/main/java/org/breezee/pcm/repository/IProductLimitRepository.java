/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.pcm.api.domain.ProductLimitInfo;
import org.breezee.pcm.entity.ProductLimitEntity;
import org.springframework.stereotype.Repository;

/**
 * 产品限售持久化服务
 * Created by Silence on 2016/6/9.
 */
@Repository("productLimitRepository")
public interface IProductLimitRepository extends
        ICommonRepository<ProductLimitEntity, ProductLimitInfo, String> {
}
