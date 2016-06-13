/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.oms.api.domain.PlanLineInfo;
import org.breezee.oms.entity.PlanLineEntity;
import org.springframework.stereotype.Repository;

/**
 * 计划行的持久化服务
 * Created by Silence on 2016/6/12.
 */
@Repository("planLineRepository")
public interface IPlanLineRepository extends ICommonRepository<PlanLineEntity, PlanLineInfo, String> {
}
