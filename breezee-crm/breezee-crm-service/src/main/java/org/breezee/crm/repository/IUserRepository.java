/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.crm.repository;

import org.breezee.common.framework.ICommonRepository;
import org.breezee.crm.api.domain.UserInfo;
import org.breezee.crm.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 用户持久化服务
 * Created by Silence on 2016/6/4.
 */
@Repository("userRepository")
public interface IUserRepository extends ICommonRepository<UserEntity, UserInfo, String> {

    UserEntity findByMobile(String mobile);
}
