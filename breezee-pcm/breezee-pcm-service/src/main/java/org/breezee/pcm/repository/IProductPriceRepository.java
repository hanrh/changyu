/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.pcm.api.domain.ProductPriceInfo;
import org.breezee.pcm.entity.ProductPriceEntity;
import org.springframework.stereotype.Repository;

/**
 * 产品价格持久化服务
 * Created by Silence on 2016/6/9.
 */
@Repository("productPriceRepository")
public interface IProductPriceRepository extends
        ICommonRepository<ProductPriceEntity, ProductPriceInfo, String> {
}
