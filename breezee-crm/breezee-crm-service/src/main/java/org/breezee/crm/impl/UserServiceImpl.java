/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.impl;

import org.breezee.common.domain.IRepository;
import org.breezee.crm.api.domain.UserInfo;
import org.breezee.crm.api.service.IUserService;
import org.breezee.crm.entity.UserEntity;
import org.breezee.crm.repository.IUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户管理的服务实现
 * Created by Silence on 2016/6/4.
 */
@Service("userService")
public class UserServiceImpl implements IUserService<UserEntity> {

    @Resource
    private IUserRepository userRepository;


    @Override
    public String register(UserInfo userInfo) {
        return null;
    }

    @Override
    public String login(UserInfo userInfo) {
        return null;
    }

    @Override
    public IRepository<UserInfo> getRepository() {
        return userRepository;
    }

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    @Override
    public Class<UserInfo> getInfoClass() {
        return null;
    }
}
