/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.oms.api.domain.PlanInfo;

/**
 * 服务域：计划服务
 * Created by Silence on 2016/6/12.
 */
public interface IPlanService<E> extends IServiceLayer<PlanInfo, E> {

    @Override
    default Class<PlanInfo> getInfoClass() {
        return PlanInfo.class;
    }
}
