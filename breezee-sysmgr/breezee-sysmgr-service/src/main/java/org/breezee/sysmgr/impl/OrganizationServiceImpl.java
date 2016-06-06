/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.sysmgr.api.domain.OrganizationInfo;
import org.breezee.sysmgr.api.service.IOrganizationService;
import org.breezee.sysmgr.entity.OrganizationEntity;
import org.breezee.sysmgr.repository.IOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 组织服务实现类
 * Created by Silence on 2016/6/2.
 */
@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService<OrganizationEntity> {

    @Autowired
    private IOrganizationRepository organizationRepository;

    @Override
    public IRepository<OrganizationInfo> getRepository() {
        return organizationRepository;
    }

    @Override
    public Class<OrganizationEntity> getEntityClass() {
        return OrganizationEntity.class;
    }
}
