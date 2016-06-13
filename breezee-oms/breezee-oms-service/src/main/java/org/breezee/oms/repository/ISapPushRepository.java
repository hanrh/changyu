/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.oms.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.oms.api.domain.SapPushInfo;
import org.breezee.oms.entity.SapPushEntity;
import org.springframework.stereotype.Repository;

/**
 * sap推送信息持久化服务
 * Created by Silence on 2016/6/12.
 */
@Repository("sapPushRepository")
public interface ISapPushRepository extends ICommonRepository<SapPushEntity, SapPushInfo, String> {
}
