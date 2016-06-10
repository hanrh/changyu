/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package org.breezee.facade.inter;

import org.breezee.common.domain.IFacadeLayer;
import org.breezee.crm.api.domain.UserInfo;
import org.breezee.facade.response.Response;

/**
 * 客户用户的对外暴露接口
 * Created by Silence on 2016/6/10.
 */
public interface IUserFacade extends IFacadeLayer {

    /**
     * 分页取用户数据
     *
     * @param info 查询条件
     * @return 分页结果
     */
    Response<UserInfo> pageUsers(UserInfo info);

    /**
     * 保存用户数据
     *
     * @param info 用户信息
     * @return 保存结果
     */
    Response<UserInfo> saveUser(UserInfo info);

    /**
     * 获取用户信息，根据指定id
     *
     * @param id 指定id
     * @return 用户信息
     */
    Response<UserInfo> findUserById(String id);
}
