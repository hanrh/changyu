/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.oms.api.domain.OrderInfo;

/**
 * 服务域：订单服务
 * Created by Silence on 2016/6/12.
 */
public interface IOrderService<E> extends IServiceLayer<OrderInfo, E> {

    @Override
    default Class<OrderInfo> getInfoClass() {
        return OrderInfo.class;
    }
}
