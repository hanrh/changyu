/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.api.service;

import org.breezee.common.domain.IServiceLayer;
import org.breezee.crm.api.domain.UserInfo;

/**
 * 服务域：用户管理服务
 * Created by Silence on 2016/6/4.
 */
public interface IUserService<E> extends IServiceLayer<UserInfo, E> {

    default Class<UserInfo> getInfoClass() {
        return UserInfo.class;
    }

    void register(UserInfo userInfo);

    void login(UserInfo userInfo);
}
