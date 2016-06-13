/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.oms.api.domain.PlanInfo;
import org.breezee.oms.entity.PlanEntity;
import org.springframework.stereotype.Repository;

/**
 * 计划的持久化服务
 * Created by Silence on 2016/6/12.
 */
@Repository("planRepository")
public interface IPlanRepository extends ICommonRepository<PlanEntity, PlanInfo, String> {
}
