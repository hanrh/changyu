/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.sysmgr.api.domain.RoleInfo;
import org.breezee.sysmgr.api.service.IRoleService;
import org.breezee.sysmgr.entity.RoleEntity;
import org.breezee.sysmgr.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色服务实现类
 * Created by Silence on 2016/6/2.
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService<RoleEntity> {

    @Autowired
    private IRoleRepository roleRepository;


    @Override
    public IRepository<RoleInfo> getRepository() {
        return roleRepository;
    }

    @Override
    public Class<RoleEntity> getEntityClass() {
        return RoleEntity.class;
    }
}
