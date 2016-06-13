/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.oms.api.domain.OrderInfo;
import org.breezee.oms.api.service.IOrderService;
import org.breezee.oms.entity.OrderEntity;
import org.breezee.oms.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单服务的实现类
 * Created by Silence on 2016/6/12.
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService<OrderEntity> {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public IRepository<OrderInfo> getRepository() {
        return orderRepository;
    }

    @Override
    public Class<OrderEntity> getEntityClass() {
        return OrderEntity.class;
    }
}
