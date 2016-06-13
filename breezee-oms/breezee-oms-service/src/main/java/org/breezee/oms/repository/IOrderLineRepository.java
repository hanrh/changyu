/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.oms.api.domain.OrderLineInfo;
import org.breezee.oms.entity.OrderLineEntity;
import org.springframework.stereotype.Repository;

/**
 * 订单行持久化服务
 * Created by Silence on 2016/6/12.
 */
@Repository("orderLineRepository")
public interface IOrderLineRepository extends ICommonRepository<OrderLineEntity, OrderLineInfo, String> {
}
