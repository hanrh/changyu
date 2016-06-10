/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.pcm.api.domain.ProductInfo;
import org.breezee.pcm.entity.ProductEntity;
import org.springframework.stereotype.Repository;

/**
 * 产品管理的持久化服务
 * Created by Silence on 2016/6/9.
 */
@Repository("productRepository")
public interface IProductRepository extends ICommonRepository<ProductEntity, ProductInfo, String> {
}
