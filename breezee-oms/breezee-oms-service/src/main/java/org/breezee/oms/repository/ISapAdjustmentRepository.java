/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.oms.api.domain.SapAdjustmentInfo;
import org.breezee.oms.entity.SapAdjustmentEntity;
import org.springframework.stereotype.Repository;

/**
 * SAP计划行调整的服务
 * Created by Silence on 2016/6/12.
 */
@Repository("sapAdjustmentRepository")
public interface ISapAdjustmentRepository extends ICommonRepository<SapAdjustmentEntity, SapAdjustmentInfo, String> {
}
