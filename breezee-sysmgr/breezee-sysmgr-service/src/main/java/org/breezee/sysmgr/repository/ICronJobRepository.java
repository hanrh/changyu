/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.sysmgr.api.domain.CronJobInfo;
import org.breezee.sysmgr.entity.CronJobEntity;
import org.springframework.stereotype.Repository;

/**
 * 定时任务持久化接口
 * Created by Silence on 2016/6/2.
 */
@Repository("cronJobRepository")
public interface ICronJobRepository extends ICommonRepository<CronJobEntity, CronJobInfo, String> {
}
