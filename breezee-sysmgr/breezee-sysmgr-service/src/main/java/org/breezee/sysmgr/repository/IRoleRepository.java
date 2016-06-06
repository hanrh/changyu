/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.sysmgr.api.domain.RoleInfo;
import org.breezee.sysmgr.entity.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * 角色服务持久化接口
 * Created by Silence on 2016/6/2.
 */
@Repository("roleRepository")
public interface IRoleRepository extends ICommonRepository<RoleEntity, RoleInfo, String> {
}
