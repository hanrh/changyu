/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.oms.api.domain.PlanInfo;
import org.breezee.oms.api.service.IPlanService;
import org.breezee.oms.entity.PlanEntity;
import org.breezee.oms.repository.IPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 计划服务实现类
 * Created by Silence on 2016/6/12.
 */
@Service("planService")
public class PlanServiceImpl implements IPlanService<PlanEntity> {

    @Autowired
    private IPlanRepository planRepository;

    @Override
    public IRepository<PlanInfo> getRepository() {
        return planRepository;
    }

    @Override
    public Class<PlanEntity> getEntityClass() {
        return PlanEntity.class;
    }
}
