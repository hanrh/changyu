/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.sysmgr.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.common.domain.exception.BreezeeException;
import org.breezee.sysmgr.api.domain.OrganizationInfo;

/**
 * 服务域：组织服务
 * Created by Silence on 2016/5/24.
 */
public interface IOrganizationService<E> extends IServiceLayer<OrganizationInfo, E> {

    @Override
    default Class<OrganizationInfo> getInfoClass() {
        return OrganizationInfo.class;
    }

    void saveAccounts(OrganizationInfo info) throws BreezeeException;
}
