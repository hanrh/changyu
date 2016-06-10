/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.pcm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.pcm.api.domain.ProductOpenInfo;
import org.breezee.pcm.entity.ProductOpenEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 开放清单的持久化服务
 * Created by Silence on 2016/6/10.
 */
@Repository("productOpenRepository")
public interface IProductOpenRepository extends
        ICommonRepository<ProductOpenEntity, ProductOpenInfo, String> {

    @Query("SELECT e from ProductOpenEntity e,ProductCustomerEntity c " +
            "where c.customerId=:customerId " +
            "and c.scope=:scope " +
            "and c.startTime<=sysdate and c.endTime>sysdate " +
            "and e.product=c.product")
    Page<ProductOpenEntity> customerOpenProduct(@Param("customerId") String customerId, @Param("scope") Integer scope, Pageable page);
}
