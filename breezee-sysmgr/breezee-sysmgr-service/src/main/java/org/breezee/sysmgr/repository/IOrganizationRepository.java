/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.entity.OrganizationEntity;
import org.springframework.stereotype.Repository;

/**
 * 组织服务持久化接口
 * Created by Silence on 2016/6/2.
 */
@Repository("organizationRepository")
public interface IOrganizationRepository extends ICommonRepository<OrganizationEntity, OrganizationInfo, String> {
}
