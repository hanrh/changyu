/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.oms.api.domain.OrderInfo;
import org.breezee.oms.entity.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * 订单持久化服务
 * Created by Silence on 2016/6/12.
 */
@Repository("orderRepository")
public interface IOrderRepository extends ICommonRepository<OrderEntity, OrderInfo, String> {
}
